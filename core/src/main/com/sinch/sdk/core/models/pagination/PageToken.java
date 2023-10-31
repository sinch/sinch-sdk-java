package com.sinch.sdk.core.models.pagination;

public class PageToken<T> {
  private final T token;

  public PageToken(T token) {
    this.token = token;
  }

  public T getToken() {
    return token;
  }

  @Override
  public String toString() {
    return "PageToken{" + "token='" + token + '\'' + '}';
  }
}
