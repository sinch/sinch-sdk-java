package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.Configuration.Builder;

/** Execution context related to Voice domains */
public class SmsContext {

  private final SMSRegion smsRegion;
  private final String smsUrl;

  private SmsContext(SMSRegion smsRegion, String smsUrl) {
    this.smsRegion = smsRegion;
    this.smsUrl = smsUrl;
  }

  /**
   * SMS Server Configuration
   *
   * @return SMS Server configuration to be used
   * @since 1.0
   */
  public ServerConfiguration getSmsServer() {
    return new ServerConfiguration(String.format(getSmsUrl(), getSmsRegion()));
  }

  /**
   * SMS Region
   *
   * @return SMS region
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/#base-url/">https://developers.sinch.com/docs/sms/api-reference/#base-url/</a>
   * @since 1.0
   */
  public SMSRegion getSmsRegion() {
    return smsRegion;
  }

  /**
   * SMS URL
   *
   * @return SMS Server URL
   * @since 1.0
   */
  public String getSmsUrl() {
    return smsUrl;
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
   * Getting Builder
   *
   * @param configuration Source configuration to fill initial builder state
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder(SmsContext configuration) {
    return new Builder(configuration);
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    SMSRegion smsRegion;
    String smsUrl;

    protected Builder() {}

    /**
     * Initialize a builder with existing configuration
     *
     * @param context Configuration to be used as initial builder state
     * @since 1.0
     */
    protected Builder(SmsContext context) {
      this.smsRegion = null != context ? context.getSmsRegion() : null;
      this.smsUrl = null != context ? context.getSmsUrl() : null;
    }

    /**
     * Set SMS region
     *
     * @param smsRegion SMS region
     * @return Current builder
     * @since 1.0
     */
    public Builder setSmsRegion(SMSRegion smsRegion) {
      this.smsRegion = smsRegion;
      return this;
    }

    /**
     * Set SMS API URL
     *
     * @param smsUrl SMS API URL
     * @return Current builder
     * @since 1.0
     */
    public Builder setSmsUrl(String smsUrl) {
      this.smsUrl = smsUrl;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public SmsContext build() {

      return new SmsContext(smsRegion, smsUrl);
    }
  }
}
