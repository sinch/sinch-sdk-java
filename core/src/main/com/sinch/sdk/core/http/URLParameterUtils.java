package com.sinch.sdk.core.http;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.utils.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * See https://spec.openapis.org/oas/latest.html#parameter-object for encoding and rendering details
 */
public class URLParameterUtils {

  private static final String UTF8_CHARSET = "UTF-8";

  public static String encodeParametersAsString(Collection<URLParameter> parameters) {
    return parameters.stream()
        .map(e -> URLParameterUtils.encode(e).orElse(null))
        .collect(Collectors.joining("&"));
  }

  public static Optional<String> encode(URLParameter parameter) {

    if (null == parameter
        || StringUtil.isEmpty(parameter.getName())
        || null == parameter.getValue()) {
      return Optional.empty();
    }
    Object value = parameter.getValue();

    if (value instanceof String || value instanceof Number) {
      return encodeString(parameter.getStyle(), parameter.getName(), value.toString());
    }

    Stream<?> stream = null;
    if (parameter.getValue() instanceof Object[]) {
      stream = Arrays.stream((Object[]) parameter.getValue());
    } else if (parameter.getValue() instanceof Collection) {
      stream = ((Collection<?>) parameter.getValue()).stream();
    }
    if (null != stream) {
      return encodeStream(parameter.getStyle(), parameter.isExplode(), parameter.getName(), stream);
    }

    return encodeObject(parameter);
  }

  private static Optional<String> encodeString(
      URLParameter.STYLE style, String name, String value) {
    switch (style) {
      case MATRIX:
        return Optional.of(
            String.format(
                ";%s%s%s",
                encodeParameterValue(name),
                StringUtil.isEmpty(value) ? "" : "=",
                encodeParameterValue(value)));
      case LABEL:
        return Optional.of(String.format(".%s", encodeParameterValue(value)));
      case FORM:
        return Optional.of(
            String.format("%s=%s", encodeParameterValue(name), encodeParameterValue(value)));
      case SIMPLE:
        if (StringUtil.isEmpty(value)) {
          throw new ApiException("Unexpected empty value '" + value + "'");
        }
        return Optional.of(String.format("%s", encodeParameterValue(value)));
    }
    throw new ApiException("Unexpected style '" + style + "'");
  }

  private static Optional<String> encodeStream(
      URLParameter.STYLE style, boolean explode, String name, Stream<?> stream) {

    switch (style) {
      case MATRIX:
        return encodeMatrixArray(explode, name, stream);
      case LABEL:
        return encodeLabelArray(name, stream);
      case FORM:
        return encodeFormArray(explode, name, stream);

      case SIMPLE:
        return encodeSimpleArray(explode, name, stream);
      case SPACE_DELIMITED:
        return encodeSpaceDelimitedArray(explode, name, stream);
      case PIPE_DELIMITED:
        return encodePipeDelimitedArray(explode, name, stream);
    }

    throw new InvalidParameterException("Invalid style='" + style + "'");
  }

  private static Optional<String> encodeMatrixArray(
      boolean explode, String name, Stream<?> stream) {
    if (explode) {
      return Optional.of(
          stream
              .map(
                  e ->
                      String.format(
                          ";%s=%s",
                          encodeParameterValue(name), encodeParameterValue(String.valueOf(e))))
              .collect(Collectors.joining("")));
    }

    return Optional.of(
        String.format(
            ";%s=%s",
            encodeParameterValue(name),
            stream
                .map(e -> encodeParameterValue(String.valueOf(e)))
                .collect(Collectors.joining(","))));
  }

  private static Optional<String> encodeLabelArray(String name, Stream<?> stream) {
    return Optional.of(
        stream
            .map(e -> String.format(".%s", encodeParameterValue(e.toString())))
            .collect(Collectors.joining("")));
  }

  private static Optional<String> encodeFormArray(boolean explode, String name, Stream<?> stream) {
    if (explode) {
      return Optional.of(
          stream
              .map(
                  e ->
                      String.format(
                          "%s=%s",
                          encodeParameterValue(name), encodeParameterValue(String.valueOf(e))))
              .collect(Collectors.joining("&")));
    }

    return Optional.of(
        String.format(
            "%s=%s",
            encodeParameterValue(name),
            stream
                .map(e -> encodeParameterValue((String.valueOf(e))))
                .collect(Collectors.joining(","))));
  }

  private static Optional<String> encodeSimpleArray(
      boolean explode, String name, Stream<?> stream) {
    return Optional.of(
        String.format(
            "%s",
            stream
                .map(e -> encodeParameterValue((String.valueOf(e))))
                .collect(Collectors.joining(","))));
  }

  private static Optional<String> encodeSpaceDelimitedArray(
      boolean explode, String name, Stream<?> stream) {
    if (explode) {
      throw new ApiException("Unsupported operation");
    }

    return Optional.of(
        String.format(
            "%s",
            stream
                .map(e -> encodeParameterValue((String.valueOf(e))))
                .collect(Collectors.joining("%20"))));
  }

  private static Optional<String> encodePipeDelimitedArray(
      boolean explode, String name, Stream<?> stream) {
    if (explode) {
      throw new ApiException("Unsupported operation");
    }

    return Optional.of(
        String.format(
            "%s",
            stream
                .map(e -> encodeParameterValue((String.valueOf(e))))
                .collect(Collectors.joining("|"))));
  }

  private static Optional<String> encodeObject(URLParameter parameter) {

    throw new ApiException("Not yet implemented '" + parameter + "'");
  }

  public static String encodeParameterValue(String value) {

    try {
      return URLEncoder.encode(value, "UTF-8").replaceAll("\\.", "%2E");
    } catch (UnsupportedEncodingException e) {
      return value;
    }
  }
}
