package com.sinch.sdk.core.exceptions;

import com.sinch.sdk.core.utils.StringUtil;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/** APIException Builder helper to transform dedicated domains error response to Exception */
public class ApiExceptionBuilder {

  private ApiExceptionBuilder() {}

  /**
   * Consume Unqualified Map of fields received from an API error into a dedicated Exception
   *
   * @param message the detail message.
   * @param code Code
   * @param mappedResponse Map of fields (usually coming from a JSON representation) to be
   *     interpreted
   * @return Dedicated ApiException
   */
  public static ApiException build(String message, int code, Map<String, ?> mappedResponse) {

    // Hardcoded Numbers API errors like format parsing
    Optional<ApiException> exception = getExceptionFromNumbersConversationError(mappedResponse);
    if (exception.isPresent()) {
      return exception.get();
    }

    exception = getExceptionFromSmsError(code, mappedResponse);
    if (exception.isPresent()) {
      return exception.get();
    }

    exception = getExceptionFromVerificationError(mappedResponse);
    if (exception.isPresent()) {
      return exception.get();
    }

    exception = getExceptionFromVoiceV2Error(code, mappedResponse);

    return exception.orElseGet(() -> new ApiException(code, message));
  }

  private static Optional<ApiException> getExceptionFromNumbersConversationError(
      Map<?, ?> mappedResponse) {

    // excepted numbers/conversation API errors have the following form
    //   "error": {
    //      "code": int,
    //      "message": string,
    //      "status": string,
    //      "details": array
    // }

    if (null == mappedResponse || !mappedResponse.containsKey("error")) {
      return Optional.empty();
    }
    Object error = mappedResponse.get("error");
    if ((!(error instanceof Map))) {
      return Optional.empty();
    }

    Map<?, ?> errorContent = (Map<?, ?>) error;

    Integer codeValue = null;
    if (errorContent.containsKey("code")) {
      codeValue = Integer.valueOf(String.valueOf(errorContent.get("code")));
    }
    String messageValue = String.valueOf(errorContent.get("message"));
    String statusValue = String.valueOf(errorContent.get("status"));
    String details = extractErrorDetails(errorContent);

    if (null == codeValue || null == messageValue || null == statusValue) {
      return Optional.empty();
    }

    // concat details if any
    if (!StringUtil.isEmpty(details)) {
      messageValue = messageValue + ". " + details;
    }
    return Optional.of(
        new ApiException(codeValue, String.format("%s: %s", statusValue, messageValue)));
  }

  private static Optional<ApiException> getExceptionFromSmsError(
      int intCode, Map<?, ?> mappedResponse) {

    // excepted SMS API errors have following form
    //     "code": string,
    //     "text": string,
    // }

    if (null == mappedResponse) {
      return Optional.empty();
    }

    Object code = mappedResponse.get("code");
    Object text = mappedResponse.get("text");

    if (null == code || null == text) {
      return Optional.empty();
    }

    return Optional.of(new ApiException(intCode, String.format("%s: %s", code, text)));
  }

  private static Optional<ApiException> getExceptionFromVerificationError(
      Map<?, ?> mappedResponse) {

    // excepted Verification API errors have following form
    //    "errorCode": int,
    //    "message": string,
    //    "reference": string

    if (null == mappedResponse) {
      return Optional.empty();
    }

    Integer codeValue = null;
    if (mappedResponse.containsKey("errorCode")) {
      codeValue = Integer.valueOf(String.valueOf(mappedResponse.get("errorCode")));
    }
    String messageValue = String.valueOf(mappedResponse.get("message"));
    String referenceValue = String.valueOf(mappedResponse.get("reference"));

    if (null == codeValue || null == messageValue || null == referenceValue) {
      return Optional.empty();
    }

    return Optional.of(
        new ApiException(
            codeValue, String.format("%s (reference=%s)", messageValue, referenceValue)));
  }

  private static Optional<ApiException> getExceptionFromVoiceV2Error(
      int intCode, Map<?, ?> mappedResponse) {

    // excepted Voice V2 API errors have following form (RFC 9457 Problem Details)
    //    "type": string,
    //    "title": string,
    //    "detail": string,
    //    "instance": string

    if (null == mappedResponse) {
      return Optional.empty();
    }

    Object title = mappedResponse.get("title");
    Object detail = mappedResponse.get("detail");

    if (null == title || null == detail) {
      return Optional.empty();
    }

    return Optional.of(new ApiException(intCode, String.format("%s: %s", title, detail)));
  }

  private static String extractErrorDetails(Map<?, ?> errorContent) {
    // API is having a "details" field
    Collection<?> details = (Collection<?>) errorContent.get("details");
    if (null == details || details.isEmpty()) {
      return "";
    }
    return String.format(
        "Details: %s", details.stream().map(Object::toString).collect(Collectors.joining(", ")));
  }
}
