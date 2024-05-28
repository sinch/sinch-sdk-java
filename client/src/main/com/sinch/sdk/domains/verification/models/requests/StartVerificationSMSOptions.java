package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/**
 * Dedicated options related to {@link StartVerificationSMSRequestParameters
 * StartVerificationSMSRequestParameters}
 *
 * @since 1.1
 */
public class StartVerificationSMSOptions {

  private final OptionalValue<String> expiry;
  private final OptionalValue<SMSCodeType> codeType;
  private final OptionalValue<String> template;
  private final OptionalValue<String> acceptLanguage;

  private StartVerificationSMSOptions(
      OptionalValue<String> expiry,
      OptionalValue<SMSCodeType> codeType,
      OptionalValue<String> template,
      OptionalValue<String> acceptLanguage) {
    this.expiry = expiry;
    this.codeType = codeType;
    this.template = template;
    this.acceptLanguage = acceptLanguage;
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.1
   */
  public static Builder builder() {
    return new Builder();
  }

  public OptionalValue<String> getExpiry() {
    return expiry;
  }

  public OptionalValue<SMSCodeType> getCodeType() {
    return codeType;
  }

  public OptionalValue<String> getTemplate() {
    return template;
  }

  public OptionalValue<String> getAcceptLanguage() {
    return acceptLanguage;
  }

  /**
   * Dedicated Builder
   *
   * @since 1.1
   */
  public static class Builder {

    private OptionalValue<String> expiry = OptionalValue.empty();
    private OptionalValue<SMSCodeType> codeType = OptionalValue.empty();
    private OptionalValue<String> template = OptionalValue.empty();
    private OptionalValue<String> acceptLanguage = OptionalValue.empty();

    private Builder() {}

    /**
     * The expiration time for a verification process is represented in the format HH:MM:SS.
     *
     * @param expiry Specifies expiry time
     * @return current builder
     * @since 1.1
     */
    public Builder setExpiry(String expiry) {
      this.expiry = OptionalValue.of(expiry);
      return this;
    }

    /**
     * The type of code to be generated
     *
     * @param codeType Specifies code type
     * @return current builder
     * @since 1.1
     */
    public Builder setCodeType(SMSCodeType codeType) {
      this.codeType = OptionalValue.of(codeType);
      return this;
    }

    /**
     * The SMS template must include a placeholder {{CODE}} where the verification code will be
     * inserted, and it can otherwise be customized as desired
     *
     * @param template Template string
     * @return current builder
     * @since 1.1
     */
    public Builder setTemplate(String template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    /**
     * Value of accept language is used to determine the language of an SMS message
     *
     * @param acceptLanguage locale string
     * @return current builder
     * @since 1.1
     */
    public Builder setAcceptLanguage(String acceptLanguage) {
      this.acceptLanguage = OptionalValue.of(acceptLanguage);
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.1
     */
    public StartVerificationSMSOptions build() {
      return new StartVerificationSMSOptions(expiry, codeType, template, acceptLanguage);
    }
  }
}
