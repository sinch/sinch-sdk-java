package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/**
 * Dedicated options related to {@link StartVerificationSMSRequestParameters StartVerificationSMSRequestParameters}
 *
 * @since 1.0
 */
public class StartVerificationSMSOptions  {

  private final OptionalValue<String> expiry;
  private final OptionalValue<SMSCodeType> codeType;
  private final OptionalValue<String> template;

  private StartVerificationSMSOptions(
      OptionalValue<String> expiry,
      OptionalValue<SMSCodeType> codeType,
      OptionalValue<String> template) {
    this.expiry= expiry;
    this.codeType=codeType;
    this.template=template;
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
  public static class Builder {


    private  OptionalValue<String> expiry= OptionalValue.empty();
    private  OptionalValue<SMSCodeType> codeType= OptionalValue.empty();
    private  OptionalValue<String> template= OptionalValue.empty();

    private Builder() {}

    /**
     * The expiration time for a verification process is represented in the format HH:MM:SS.
     *
     * @param expiry Specifies expiry time
     * @return current builder
     * @since 1.0
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
     * @since 1.0
     */
    public Builder setCodeType(SMSCodeType codeType) {
      this.codeType = OptionalValue.of(codeType);
      return this;
    }

    /**
     * The SMS template must include a placeholder {{CODE}} where the verification code will be inserted, and it can otherwise be customized as desired
     *
     * @param template Template string
     * @return current builder
     * @since 1.0
     */
    public Builder setTemplate(String template) {
      this.template = OptionalValue.of(template);
      return this;
    }


    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public StartVerificationSMSOptions build() {
      return new StartVerificationSMSOptions( expiry, codeType, template);
    }

  }
}
