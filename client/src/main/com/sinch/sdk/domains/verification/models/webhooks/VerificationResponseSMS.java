package com.sinch.sdk.domains.verification.models.webhooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;

/**
 * Verification response related to SMS
 */
public class VerificationResponseSMS extends VerificationResponse {

  @JsonProperty("sms")
  private final SMSResponse sms;

  /**
   *
    * @param action Determines whether the verification can be executed.
   * @param sms SMS related information
   */
  VerificationResponseSMS(VerificationResponseActionType action, SMSResponse sms) {
    super(action);
    this.sms = sms;
  }

  public SMSResponse getSms() {
    return sms;
  }

  @Override
  public String toString() {
    return "VerificationResponseSMS{" + "sms=" + sms + "} " + super.toString();
  }

  /**
   * SMS related information for SMS verification callback
   * See <a href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post!c=200&amp;path=0/action&amp;t=response">sms response documentation</a>
   * @since 1.0
   */
  public static class SMSResponse {
    @JsonProperty("code")
    private final Integer code;

    @JsonProperty("acceptLanguage")
    private final Collection<String> acceptLanguage;

    /**
     *
     * @param code The SMS PIN that should be used. By default, the Sinch dashboard will automatically generate PIN codes for SMS verification. If you want to set your own PIN, you can specify it in the response to the Verification Request Event.
     * @param acceptLanguage The SMS verification content language. Set in the verification request.
     */
    public SMSResponse(Integer code, Collection<String> acceptLanguage) {
      this.code = code;
      this.acceptLanguage = acceptLanguage;
    }

    @Override
    public String toString() {
      return "SMSResponse{" + "code='" + code + '\'' + ", acceptLanguage=" + acceptLanguage + '}';
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends VerificationResponse.Builder<Builder> {

    Integer code;
    Collection<String> acceptLanguage;

    public Builder setCode(Integer code) {
      this.code = code;
      return self();
    }

    public Builder setAcceptLanguage(Collection<String> acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return self();
    }

    public VerificationResponseSMS build() {
      return new VerificationResponseSMS(action, new SMSResponse(code, acceptLanguage));
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
