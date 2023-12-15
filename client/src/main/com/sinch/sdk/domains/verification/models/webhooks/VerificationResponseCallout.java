package com.sinch.sdk.domains.verification.models.webhooks;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Verification response related to call out */
public class VerificationResponseCallout extends VerificationResponse {

  @JsonProperty("callout")
  private final CalloutResponse callout;

  /**
   * @param action Determines whether the verification can be executed.
   * @param callout call out related information
   */
  VerificationResponseCallout(VerificationResponseActionType action, CalloutResponse callout) {
    super(action);
    this.callout = callout;
  }

  public CalloutResponse getCallout() {
    return callout;
  }

  @Override
  public String toString() {
    return "VerificationResponseCallout{" + "callout=" + callout + "} " + super.toString();
  }

  /**
   * Call out related information for call out verification callback See <a
   * href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post!c=200&amp;path=2/callout&amp;t=response">callout
   * response documentation</a>
   *
   * @since 1.0
   */
  public static class CalloutResponse {

    @JsonProperty("code")
    private final Integer code;

    @JsonProperty("speech")
    private final SpeechResponse speech;

    /**
     * @param code The Phone Call PIN that should be entered by the user. Sinch servers
     *     automatically generate PIN codes for Phone Call verification. If you want to set your own
     *     code, you can specify it in the response to the Verification Request Event.
     * @param speech An object defining various properties for the text-to-speech message.
     */
    public CalloutResponse(Integer code, SpeechResponse speech) {
      this.code = code;
      this.speech = speech;
    }

    public Integer getCode() {
      return code;
    }

    public SpeechResponse getSpeech() {
      return speech;
    }

    @Override
    public String toString() {
      return "CalloutResponse{" + "code='" + code + '\'' + ", speech=" + speech + '}';
    }
  }

  /**
   * Speech related information for SMS verification callback See <a
   * href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post!c=200&amp;path=2/callout&amp;t=response">speech
   * response documentation</a>
   *
   * @since 1.0
   */
  public static class SpeechResponse {

    @JsonProperty("locale")
    private final String locale;

    /**
     * @param locale Indicates the language that should be used for the text-to-speech message.
     *     Currently, only en-US is supported.
     */
    public SpeechResponse(String locale) {
      this.locale = locale;
    }

    public String getLocale() {
      return locale;
    }

    @Override
    public String toString() {
      return "SpeechResponse{" + "locale='" + locale + '\'' + '}';
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends VerificationResponse.Builder<Builder> {

    Integer code;

    String locale;

    public Builder setCode(Integer code) {
      this.code = code;
      return self();
    }

    public Builder setLocale(String locale) {
      this.locale = locale;
      return self();
    }

    public VerificationResponseCallout build() {
      return new VerificationResponseCallout(
          action, new CalloutResponse(code, new SpeechResponse(locale)));
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
