package com.sinch.sdk.domains.verification.models.webhooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;

/** Verification response related to SMS */
public class VerificationResponseSMS extends VerificationResponse {

  @JsonProperty("sms")
  private final SMSResponse sms;

  /**
   * @param action Determines whether the verification can be executed.
   * @param sms SMS related information
   */
  VerificationResponseSMS(VerificationResponseActionType action, SMSResponse sms) {
    super(action);
    this.sms = sms;
  }

  /**
   * SMS Response related information
   *
   * @return SMS related information
   * @since 1.0
   */
  public SMSResponse getSms() {
    return sms;
  }

  @Override
  public String toString() {
    return "VerificationResponseSMS{" + "sms=" + sms + "} " + super.toString();
  }

  /**
   * SMS related information for SMS verification callback See <a
   * href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post!c=200&amp;path=0/action&amp;t=response">sms
   * response documentation</a>
   *
   * @since 1.0
   */
  public static class SMSResponse {
    @JsonProperty("code")
    private final Integer code;

    @JsonProperty("acceptLanguage")
    private final Collection<String> acceptLanguage;

    /**
     * SMS response related information
     *
     * @param code The SMS PIN that should be used. By default, the Sinch dashboard will
     *     automatically generate PIN codes for SMS verification. If you want to set your own PIN,
     *     you can specify it in the response to the Verification Request Event.
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

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder extends VerificationResponse.Builder<Builder> {

    Integer code;
    Collection<String> acceptLanguage;

    private Builder() {}

    /**
     * See {@link SMSResponse#SMSResponse(Integer, Collection) constructor}
     *
     * @param code see constructor
     * @return The current builder
     * @since 1.0
     */
    public Builder setCode(Integer code) {
      this.code = code;
      return self();
    }

    /**
     * See {@link SMSResponse#SMSResponse(Integer, Collection) constructor}
     *
     * @param acceptLanguage see constructor
     * @return The current builder
     * @since 1.0
     */
    public Builder setAcceptLanguage(Collection<String> acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationResponseSMS build() {
      return new VerificationResponseSMS(action, new SMSResponse(code, acceptLanguage));
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
