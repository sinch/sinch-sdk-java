package com.sinch.sdk.domains.numbers.models.requests;

/**
 * Parameters request to update callback configuration
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/callbacks-numbers/tag/Callback-Configuration/#tag/Callback-Configuration/operation/UpdateCallbackConfiguration">https://developers.sinch.com/docs/numbers/api-reference/callbacks-numbers/tag/Callback-Configuration/#tag/Callback-Configuration/operation/UpdateCallbackConfiguration</a>
 * @since 1.0
 */
public class CallbackConfigurationUpdateRequestParameters {
  /** */
  private final String hmacSecret;

  /** @param hmacSecret The HMAC secret to be updated for the specified project */
  public CallbackConfigurationUpdateRequestParameters(String hmacSecret) {
    this.hmacSecret = hmacSecret;
  }

  public String getHMACSecret() {
    return hmacSecret;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    String hmacSecret;

    private Builder() {}

    public Builder setHMACSecret(String hmacSecret) {
      this.hmacSecret = hmacSecret;
      return this;
    }

    public CallbackConfigurationUpdateRequestParameters build() {
      return new CallbackConfigurationUpdateRequestParameters(hmacSecret);
    }
  }
}
