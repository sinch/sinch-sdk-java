package com.sinch.sdk.core.models.pagination;

/**
 * Base class for PageNavigator
 *
 * @param <T> Token type
 */
public class PageNavigator<T> {
  private final T token;

  public PageNavigator(T token) {
    this.token = token;
  }

  /**
   * Get current page navigator token
   *
   * @return Token value
   */
  public T getToken() {
    return token;
  }

  @Override
  public String toString() {
    return "PageNavigator{" + "token='" + token + '\'' + '}';
  }
}
