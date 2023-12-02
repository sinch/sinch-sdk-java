package com.sinch.sdk.domains.verification.models.webhooks;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Verification response related to flash call
 */
public class VerificationResponseFlashCall extends VerificationResponse {

  @JsonProperty("flashcall")
  private final FlashCallResponse flashCall;

  /**
   *
   * @param action Determines whether the verification can be executed.
   * @param flashCall Flash call related information
   */
  VerificationResponseFlashCall(
      VerificationResponseActionType action, FlashCallResponse flashCall) {
    super(action);
    this.flashCall = flashCall;
  }

  public FlashCallResponse getFlashCall() {
    return flashCall;
  }

  @Override
  public String toString() {
    return "VerificationResponseFlashCall{" + "flashCall=" + flashCall + "} " + super.toString();
  }

  /**
   * Flash call related information for flach call verification callback
   * See <a href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post!c=200&path=1/flashCall&t=response">callout response documentation</a>
   * @since 1.0
   */
  public static class FlashCallResponse {

    @JsonProperty("cli")
    private final String cli;

    @JsonProperty("dialTimeout")
    private final Integer dialTimeout;

    /**
     *
      * @param cli The phone number that will be displayed to the user when the flashcall is received on the user's phone. By default, the Sinch dashboard will randomly select the CLI that will be displayed during a flashcall from a pool of numbers. If you want to set your own CLI, you can specify it in the response to the Verification Request Event.
     * @param dialTimeout The maximum time that a flashcall verification will be active and can be completed. If the phone number hasn't been verified successfully during this time, then the verification request will fail. By default, the Sinch dashboard will automatically optimize dial time out during a flashcall. If you want to set your own dial time out for the flashcall, you can specify it in the response to the Verification Request Event.
     */
    public FlashCallResponse(String cli, Integer dialTimeout) {
      this.cli = cli;
      this.dialTimeout = dialTimeout;
    }

    public String getCli() {
      return cli;
    }

    public Integer getDialTimeout() {
      return dialTimeout;
    }

    @Override
    public String toString() {
      return "FlashCallResponse{" + "cli='" + cli + '\'' + ", dialTimeout=" + dialTimeout + '}';
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends VerificationResponse.Builder<Builder> {

    String cli;

    Integer dialTimeout;

    public Builder setCli(String cli) {
      this.cli = cli;
      return self();
    }

    public Builder setDialTimeout(Integer dialTimeout) {
      this.dialTimeout = dialTimeout;
      return self();
    }

    public VerificationResponseFlashCall build() {
      return new VerificationResponseFlashCall(action, new FlashCallResponse(cli, dialTimeout));
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
