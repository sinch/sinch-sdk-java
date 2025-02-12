package com.sinch.sdk.core.http;

import static com.sinch.sdk.core.http.HttpContentType.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.utils.databind.Mapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class HttpMapper {

  public <T> T deserialize(HttpResponse response, TypeReference<T> valueType) throws ApiException {
    if (null == valueType || null == response) {
      return null;
    }

    try (InputStream stream = response.getContent()) {
      if (null == stream) {
        return null;
      }

      Collection<String> contentType = response.getHeaders().get(CONTENT_TYPE_HEADER);
      if (null == contentType || contentType.isEmpty() || isMimeJson(contentType)) {
        java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A");
        String content = s.hasNext() ? s.next() : "";

        if ("".equals(content)) {
          return null;
        }
        return Mapper.getInstance().readValue(content, valueType);
      } else if (isMimeTextPlain(contentType)) {
        java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A");
        @SuppressWarnings("unchecked")
        T t = (T) (s.hasNext() ? s.next() : "");
        return t;
      } else {
        throw new ApiException(
            "Deserialization for content type '"
                + contentType
                + "' not supported for type '"
                + valueType);
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public String serialize(Collection<String> contentTypes, Object body) {
    if (null == body) {
      return null;
    }
    if (null == contentTypes || contentTypes.isEmpty() || isMimeJson(contentTypes)) {
      try {
        return Mapper.getInstance().writeValueAsString(body);
      } catch (JsonProcessingException e) {
        throw new ApiException(e);
      }
    }
    throw new ApiException(
        "Deserialization for content type '" + contentTypes + "' not supported ");
  }

  public static HttpMapper getInstance() {
    return LazyHolder.INSTANCE;
  }

  private static class LazyHolder {

    public static final HttpMapper INSTANCE = new HttpMapper();
  }
}
