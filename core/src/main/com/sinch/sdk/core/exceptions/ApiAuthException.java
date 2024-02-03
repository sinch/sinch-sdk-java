package com.sinch.sdk.core.exceptions;

import com.sinch.sdk.core.http.HttpStatus;

public class ApiAuthException extends ApiException {

  private static final long serialVersionUID = -1L;

  public ApiAuthException(Throwable throwable) {
    super(null, throwable, HttpStatus.UNAUTHORIZED);
  }

  public ApiAuthException(String message) {
    super(message, null, HttpStatus.UNAUTHORIZED);
  }
  
}
