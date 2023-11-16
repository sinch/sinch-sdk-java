package com.sinch.sdk.core.models.pagination;

public class TokenPageNavigator extends PageNavigator<String> {

  public TokenPageNavigator(String token) {
    super(token);
  }

  @Override
  public String toString() {
    return "TokenPageNavigator{} " + super.toString();
  }
}
