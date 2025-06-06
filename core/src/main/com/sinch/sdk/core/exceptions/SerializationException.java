package com.sinch.sdk.core.exceptions;

/**
 * Exception related to serialization
 *
 * @since 1.6
 */
public class SerializationException extends RuntimeException {

  private static final long serialVersionUID = -1L;

  /**
   * Constructs a new exception with the specified cause and a detail message of (cause==null ? null
   * : cause.toString()) (which typically contains the class and detail message of cause). This
   * constructor is useful for exceptions that are little more than wrappers for other throwables
   *
   * @param throwable Cause
   * @since 1.6
   */
  public SerializationException(Throwable throwable) {
    super(null, throwable);
  }

  /**
   * Constructs an SerializationException with the specified detail message.
   *
   * @param message the detail message.
   * @since 1.6
   */
  public SerializationException(String message) {
    super(message, null);
  }
}
