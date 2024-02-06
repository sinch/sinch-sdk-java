package com.sinch.sdk.domains.verification.models.response;

import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.VerificationId;
import java.util.Collection;

/**
 * Dedicated response type for a flash call verification started with {@link
 * com.sinch.sdk.domains.verification.VerificationsService#start(StartVerificationRequestParameters)
 * VerificationsService#start()} initiated wit method {@link
 * com.sinch.sdk.domains.verification.models.VerificationMethodType#FLASH_CALL FLASH_CALL}
 *
 * @since 1.0
 */
public class StartVerificationResponseFlashCall extends StartVerificationResponse {

  private final String cliFilter;
  private final Integer interceptionTimeOut;
  private final Integer reportTimeout;
  private final Integer denyCallAfter;

  private StartVerificationResponseFlashCall(
      VerificationId id,
      Collection<Link> links,
      String cliFilter,
      Integer interceptionTimeOut,
      Integer reportTimeout,
      Integer denyCallAfter) {
    super(id, links);
    this.cliFilter = cliFilter;
    this.interceptionTimeOut = interceptionTimeOut;
    this.reportTimeout = reportTimeout;
    this.denyCallAfter = denyCallAfter;
  }

  /**
   * Filter that should be applied for incoming calls to intercept the Flashcall.
   *
   * @return Filter value
   * @since 1.0
   */
  public String getCliFilter() {
    return cliFilter;
  }

  /**
   * Amount of seconds client should wait for the Flashcall.
   *
   * @return time out value
   * @since 1.0
   */
  public Integer getInterceptionTimeOut() {
    return interceptionTimeOut;
  }

  /**
   * The time in seconds allowed for reporting the code after which the verification will expire.
   *
   * @return time out value
   * @since 1.0
   */
  public Integer getReportTimeout() {
    return reportTimeout;
  }

  /**
   * Used by the SDKs, this setting makes the handset deny the flashcall after the set time in
   * seconds.
   *
   * @return Deny value
   * @since 1.0
   */
  public Integer getDenyCallAfter() {
    return denyCallAfter;
  }

  @Override
  public String toString() {
    return "StartVerificationResponseFlashCall{"
        + "cliFilter='"
        + cliFilter
        + '\''
        + ", interceptionTimeOut="
        + interceptionTimeOut
        + ", reportTimeout="
        + reportTimeout
        + ", denyCallAfter="
        + denyCallAfter
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

    String cliFilter;
    Integer interceptionTimeOut;
    Integer reportTimeout;
    Integer denyCallAfter;

    private Builder() {
      super();
    }

    /**
     * See {@link StartVerificationResponseFlashCall#getCliFilter() getter}
     *
     * @param cliFilter see getter
     * @return The current builder
     * @since 1.0
     */
    public Builder setCliFilter(String cliFilter) {
      this.cliFilter = cliFilter;
      return self();
    }

    /**
     * See {@link StartVerificationResponseFlashCall#getInterceptionTimeOut() getter}
     *
     * @param interceptionTimeOut see getter
     * @return The current builder
     * @since 1.0
     */
    public Builder setInterceptionTimeOut(Integer interceptionTimeOut) {
      this.interceptionTimeOut = interceptionTimeOut;
      return self();
    }

    /**
     * See {@link StartVerificationResponseFlashCall#getReportTimeout() getter}
     *
     * @param reportTimeout see getter
     * @return The current builder
     * @since 1.0
     */
    public Builder setReportTimeout(Integer reportTimeout) {
      this.reportTimeout = reportTimeout;
      return self();
    }

    /**
     * See {@link StartVerificationResponseFlashCall#getDenyCallAfter() getter}
     *
     * @param denyCallAfter see getter
     * @return The current builder
     * @since 1.0
     */
    public Builder setDenyCallAfter(Integer denyCallAfter) {
      this.denyCallAfter = denyCallAfter;
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public StartVerificationResponseFlashCall build() {
      return new StartVerificationResponseFlashCall(
          id, links, cliFilter, interceptionTimeOut, reportTimeout, denyCallAfter);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
