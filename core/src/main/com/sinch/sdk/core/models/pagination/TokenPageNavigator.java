package com.sinch.sdk.core.models.pagination;

/** Token Based Page Navigator */
public class TokenPageNavigator extends PageNavigator<String> {

  /**
   * Create new instance
   *
   * @param token The token value
   */
  public TokenPageNavigator(String token) {
    super(token);
  }

  @Override
  public String toString() {
    return "TokenPageNavigator{} " + super.toString();
  }
}
