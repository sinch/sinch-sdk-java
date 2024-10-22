package com.sinch.sdk.core.exceptions;

/** Base Sinch Client API exception */
public class ApiException extends RuntimeException {

  private static final long serialVersionUID = -1L;

  private int code;

  /** Constructs an ApiException with no detail message. */
  public ApiException() {}

  /**
   * Constructs a new exception with the specified cause and a detail message of (cause==null ? null
   * : cause.toString()) (which typically contains the class and detail message of cause). This
   * constructor is useful for exceptions that are little more than wrappers for other throwables
   *
   * @param throwable Cause
   */
  public ApiException(Throwable throwable) {
    super(throwable);
  }

  /**
   * Constructs an ApiException with the specified detail message.
   *
   * @param message the detail message.
   * @since 1.0
   */
  public ApiException(String message) {
    super(message);
  }

  /**
   * Constructs an ApiException with the specified detail message and with the specified cause
   *
   * @param message The detail message
   * @param throwable Cause
   */
  public ApiException(String message, Throwable throwable) {
    super(message, throwable);
  }

  /**
   * Constructs an ApiException with the specified detail message, the specified cause and a code
   *
   * @param message The detail message
   * @param throwable Cause
   * @param code Code
   */
  public ApiException(String message, Throwable throwable, int code) {
    super(message, throwable);
    this.code = code;
  }

  /**
   * Constructs an ApiException with the specified detail message and a code
   *
   * @param code Code
   * @param message The detail message
   */
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
    return "ApiException{" + "code=" + code + ", message=" + super.getMessage() + "}";
  }
}
