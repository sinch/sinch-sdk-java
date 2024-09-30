package com.sinch.sdk.core.models.pagination;

import com.sinch.sdk.core.utils.StringUtil;

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

  /**
   * Create a new instance from a token. If token is null or empty return null to mark no next page
   *
   * @param token A token value
   * @return The newly created
   */
  public static TokenPageNavigator valueOf(String token) {

    if (StringUtil.isEmpty(token)) {
      return null;
    }
    return new TokenPageNavigator(token);
  }

  /**
   * Check if token value is value and return same token is valid.
   *
   * <p>Return null if token or it value isd is null If token is null or empty return null to mark
   * no next page
   *
   * @param token A token value
   * @return The newly created
   */
  public static TokenPageNavigator valueOf(TokenPageNavigator token) {
    if (null == token || StringUtil.isEmpty(token.getToken())) {
      return null;
    }
    return token;
  }
}
