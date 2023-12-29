package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/**
 * Parameters request to update callback configuration
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/callbacks-numbers/tag/Callback-Configuration/#tag/Callback-Configuration/operation/UpdateCallbackConfiguration">https://developers.sinch.com/docs/numbers/api-reference/callbacks-numbers/tag/Callback-Configuration/#tag/Callback-Configuration/operation/UpdateCallbackConfiguration</a>
 * @since 1.0
 */
public class CallbackConfigurationUpdateRequestParameters {
  /** */
  private final OptionalValue<String> hmacSecret;

  private CallbackConfigurationUpdateRequestParameters(OptionalValue<String> hmacSecret) {
    this.hmacSecret = hmacSecret;
  }

  public OptionalValue<String> getHMACSecret() {
    return hmacSecret;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    OptionalValue<String> hmacSecret = OptionalValue.empty();

    private Builder() {}

    /***
     *
     * @param hmacSecret The HMAC secret to be updated for the specified project
     * @return current builder
     */
    public Builder setHMACSecret(String hmacSecret) {
      this.hmacSecret = OptionalValue.of(hmacSecret);
      return this;
    }

    public CallbackConfigurationUpdateRequestParameters build() {
      return new CallbackConfigurationUpdateRequestParameters(hmacSecret);
    }
  }
}
