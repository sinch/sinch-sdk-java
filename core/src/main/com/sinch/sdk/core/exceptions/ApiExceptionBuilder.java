package com.sinch.sdk.core.exceptions;

import java.util.Map;
import java.util.Optional;

public class ApiExceptionBuilder {

  private ApiExceptionBuilder() {}
  ;

  public static ApiException build(String message, int code, Map<String, ?> mappedResponse) {

    // Hardcoded Numbers API errors like format parsing
    Optional<ApiException> exception = getExceptionFromNumbersError(mappedResponse);
    if (exception.isPresent()) {
      return exception.get();
    }

    exception = getExceptionFromSmsError(code, mappedResponse);
    if (exception.isPresent()) {
      return exception.get();
    }

    exception = getExceptionFromVerificationError(mappedResponse);
    return exception.orElseGet(() -> new ApiException(code, message));
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
}
