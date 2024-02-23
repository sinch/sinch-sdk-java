package com.sinch.sdk.models;

/**
 * Credentials related to SMS authentication based onto service plan
 *
 * @see <a href="https://dashboard.sinch.com/sms/api/services">Dashboard</a>
 * @since 1.0
 */
public class SmsServicePlanCredentials {

  private final String servicePlanId;
  private final String apiToken;

  private SmsServicePlanCredentials(String servicePlanId, String apiToken) {
    this.servicePlanId = servicePlanId;
    this.apiToken = apiToken;
  }

  /**
   * Service plan ID -
   *
   * @return service plan ID
   * @since 1.0
   */
  public String getServicePlanId() {
    return servicePlanId;
  }

  /**
   * Service plan token
   *
   * @return service plan token
   * @since 1.0
   */
  public String getApiToken() {
    return apiToken;
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
   * @param credentials Source credentials to fill initial builder state
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder(SmsServicePlanCredentials credentials) {
    return new Builder(credentials);
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    String servicePlanId;
    String apiToken;

    protected Builder() {}

    /**
     * Initialize a builder with existing credentials
     *
     * @param credentials Credentials to be used as initial builder state
     * @since 1.0
     */
    protected Builder(SmsServicePlanCredentials credentials) {
      this.servicePlanId = null != credentials ? credentials.getServicePlanId() : null;
      this.apiToken = null != credentials ? credentials.getApiToken() : null;
    }

    /**
     * Set service plan ID
     *
     * @param servicePlanId See {@link #getServicePlanId() getter}
     * @return Current builder
     * @since 1.0
     */
    public Builder setServicePlanId(String servicePlanId) {
      this.servicePlanId = servicePlanId;
      return this;
    }

    /**
     * Set service plan token
     *
     * @param apiToken See {@link #getApiToken() getter}
     * @return Current builder
     * @since 1.0
     */
    public Builder setApiToken(String apiToken) {
      this.apiToken = apiToken;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public SmsServicePlanCredentials build() {
      return new SmsServicePlanCredentials(servicePlanId, apiToken);
    }
  }
}
