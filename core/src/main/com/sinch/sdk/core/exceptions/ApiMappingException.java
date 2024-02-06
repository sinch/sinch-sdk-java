package com.sinch.sdk.core.exceptions;

/** Sinch Client exception related to payload parsing/mapping error */
public class ApiMappingException extends ApiException {

  private static final long serialVersionUID = 1L;

  /**
   * Exception throw when parsing a payload was causing an issue
   *
   * @param payload Payload causing error
   * @param throwable Cause
   */
  public ApiMappingException(String payload, Throwable throwable) {
    super(String.format("Unable to map string '%s'", payload), throwable);
  }
}
