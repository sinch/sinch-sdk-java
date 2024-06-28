package com.sinch.sdk.domains.verification.models.response;

import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import java.util.Collection;

/**
 * Dedicated response type for a SMS verification
 *
 * <p>Verification response when started using {@link
 * com.sinch.sdk.domains.verification.VerificationsService#startSms(StartVerificationSMSRequestParameters)}
 *
 * @since 1.0
 */
public class StartVerificationResponseSMS extends StartVerificationResponse {

  private final String template;
  private final Integer interceptionTimeOut;

  private StartVerificationResponseSMS(
      VerificationId id, Collection<Link> links, String template, Integer interceptionTimeOut) {
    super(id, links);
    this.template = template;
    this.interceptionTimeOut = interceptionTimeOut;
  }

  /**
   * The expected template for the SMS response
   *
   * @return Template value
   * @since 1.0
   */
  public String getTemplate() {
    return template;
  }

  /**
   * The amount of time in seconds that the client should wait for the SMS.
   *
   * @return Timeout value
   * @since 1.0
   */
  public Integer getInterceptionTimeOut() {
    return interceptionTimeOut;
  }

  @Override
  public String toString() {
    return "StartVerificationResponseSMS{"
        + "template='"
        + template
        + '\''
        + ", interceptionTimeOut="
        + interceptionTimeOut
        + "} "
        + super.toString();
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
  public static class Builder extends StartVerificationResponse.Builder<Builder> {

    String template;
    Integer interceptionTimeOut;

    private Builder() {
      super();
    }

    /**
     * See {@link StartVerificationResponseSMS#getTemplate() getter}
     *
     * @param template see getter
     * @return The current builder
     * @since 1.0
     */
    public Builder setTemplate(String template) {
      this.template = template;
      return this;
    }

    /**
     * See {@link StartVerificationResponseSMS#getInterceptionTimeOut() getter}
     *
     * @param interceptionTimeOut see getter
     * @return The current builder
     * @since 1.0
     */
    public Builder setInterceptionTimeOut(Integer interceptionTimeOut) {
      this.interceptionTimeOut = interceptionTimeOut;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public StartVerificationResponseSMS build() {
      return new StartVerificationResponseSMS(id, links, template, interceptionTimeOut);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
