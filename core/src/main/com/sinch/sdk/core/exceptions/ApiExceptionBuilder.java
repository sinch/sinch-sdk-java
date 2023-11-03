package com.sinch.sdk.core.exceptions;

import java.util.Map;
import java.util.Optional;

public class ApiExceptionBuilder {

  public static ApiException build(String message, int code) {
    return new ApiException(message, code);
  }

  public static ApiException build(String message, int code, Map<String, ?> mappedResponse) {

    // Hardcoded Numbers API errors like format parsing
    Optional<ApiException> numbersException = getExceptionFromNumbersError(mappedResponse);
    if (numbersException.isPresent()) {
      return numbersException.get();
    }

    Optional<ApiException> smsException = getExceptionFromSmsError(mappedResponse);
    return smsException.orElseGet(() -> new ApiException(message, code));
  }

  private static Optional<ApiException> getExceptionFromNumbersError(Map<?, ?> mappedResponse) {

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

  private static Optional<ApiException> getExceptionFromSmsError(Map<?, ?> mappedResponse) {

    // excepted SMS API errors have following form
    //     "code": int,
    //     "text": string,
    // }

    if (null == mappedResponse) {
      return Optional.empty();
    }

    Object code = mappedResponse.get("code");
    Object text = mappedResponse.get("text");
    ;

    if (null == code || null == text) {
      return Optional.empty();
    }

    return Optional.of(new ApiException(String.format("%s: %s", code, text)));
  }
}
