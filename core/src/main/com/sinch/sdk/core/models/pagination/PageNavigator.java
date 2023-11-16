package com.sinch.sdk.core.models.pagination;

public class PageNavigator<T> {
  private final T token;

  public PageNavigator(T token) {
    this.token = token;
  }

  public T getToken() {
    return token;
  }

  @Override
  public String toString() {
    return "PageNavigator{" + "token='" + token + '\'' + '}';
  }
}
