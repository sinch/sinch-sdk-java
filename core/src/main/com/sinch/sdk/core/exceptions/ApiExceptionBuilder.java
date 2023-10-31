package com.sinch.sdk.core.exceptions;

import java.util.Map;
import java.util.Optional;

public class ApiExceptionBuilder {

  public static ApiException build(String message, int code) {
    return new ApiException(message, code);
  }

  public static ApiException build(String message, int code, Map<String, ?> mappedResponse) {

    // Hardcoded Numbers API errors like format parsing
    Optional<ApiException> numbersException = getExceptionFromNumbersOrSmsError(mappedResponse);

    return numbersException.orElseGet(() -> new ApiException(message, code));
  }

  private static Optional<ApiException> getExceptionFromNumbersOrSmsError(
      Map<?, ?> mappedResponse) {

    if (null == mappedResponse) {
      return Optional.empty();
    }
    // excepted numbers API errors have following form
    //   "error": {
    //      "code": int,
    //      "message": string,
    //      "status": string,
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

    if (null == codeValue || null == messageValue || null == statusValue) {
      return Optional.empty();
    }

    return Optional.of(
        new ApiException(String.format("%s: %s", statusValue, messageValue), codeValue));
  }
}
