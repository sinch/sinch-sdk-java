package com.sinch.sdk.core.exceptions;

import com.sinch.sdk.core.http.HttpStatus;

/**
 * Exception related to server authentication
 *
 * @since 1.0
 */
public class ApiAuthException extends ApiException {

  private static final long serialVersionUID = -1L;

  /**
   * Constructs a new exception with the specified cause and a detail message of (cause==null ? null
   * : cause.toString()) (which typically contains the class and detail message of cause). This
   * constructor is useful for exceptions that are little more than wrappers for other throwables
   *
   * @param throwable the cause (which is saved for later retrieval by the Throwable.getCause()
   *     method). (A null value is permitted, and indicates that the cause is nonexistent or
   *     unknown.)
   * @since 1.0
   */
  public ApiAuthException(Throwable throwable) {
    super(null, throwable, HttpStatus.UNAUTHORIZED);
  }

  /**
   * Constructs an ApiAuthException with the specified detail message.
   *
   * @param message the detail message.
   * @since 1.0
   */
  public ApiAuthException(String message) {
    super(message, null, HttpStatus.UNAUTHORIZED);
  }
}
