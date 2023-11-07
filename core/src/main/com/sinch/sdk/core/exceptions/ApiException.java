package com.sinch.sdk.core.exceptions;

public class ApiException extends RuntimeException {

  private static final long serialVersionUID = -1L;
  private int code = 0;

  public ApiException() {}

  public ApiException(Throwable throwable) {
    super(throwable);
  }

  public ApiException(String message) {
    super(message);
  }

  public ApiException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public ApiException(String message, Throwable throwable, int code) {
    super(message, throwable);
    this.code = code;
  }

  public ApiException(String message, int code) {
    this(message, null, code);
  }

  public ApiException(int code, String message) {
    this(message, null, code);
  }

  /**
   * Get the HTTP status code.
   *
   * @return HTTP status code
   */
  public int getCode() {
    return code;
  }

  @Override
  public String toString() {
    return "ApiException{" + "code=" + code + ", message=" + super.getMessage();
  }
}
