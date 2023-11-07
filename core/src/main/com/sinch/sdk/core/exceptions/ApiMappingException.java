package com.sinch.sdk.core.exceptions;

public class ApiMappingException extends ApiException {

  public ApiMappingException(String payload, Throwable throwable) {
    super(String.format("Unable to map string '%s'", payload), throwable);
  }
}
