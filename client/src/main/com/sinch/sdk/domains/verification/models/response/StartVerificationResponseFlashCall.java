package com.sinch.sdk.domains.verification.models.response;

import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.VerificationId;
import java.util.Collection;

/** Dedicated response type for a flashcall verification */
public class StartVerificationResponseFlashCall extends StartVerificationResponse {

  private final String cliFilter;
  private final Integer interceptionTimeOut;
  private final Integer reportTimeout;
  private final Integer denyCallAfter;

  /**
   * @param id Verification identifier used to query for status.
   * @param links Available methods and actions which can be done after a successful Verification
   * @param cliFilter Filter that should be applied for incoming calls to intercept the Flashcall.
   * @param interceptionTimeOut Amount of seconds client should wait for the Flashcall.
   * @param reportTimeout The time in seconds allowed for reporting the code after which the
   *     verification will expire.
   * @param denyCallAfter Used by the SDKs, this setting makes the handset deny the flashcall after
   *     the set time in seconds.
   */
  public StartVerificationResponseFlashCall(
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

  public String getCliFilter() {
    return cliFilter;
  }

  public Integer getInterceptionTimeOut() {
    return interceptionTimeOut;
  }

  public Integer getReportTimeout() {
    return reportTimeout;
  }

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends StartVerificationResponse.Builder<Builder> {

    String cliFilter;
    Integer interceptionTimeOut;
    Integer reportTimeout;
    Integer denyCallAfter;

    public Builder setCliFilter(String cliFilter) {
      this.cliFilter = cliFilter;
      return self();
    }

    public Builder setInterceptionTimeOut(Integer interceptionTimeOut) {
      this.interceptionTimeOut = interceptionTimeOut;
      return self();
    }

    public Builder setReportTimeout(Integer reportTimeout) {
      this.reportTimeout = reportTimeout;
      return self();
    }

    public Builder setDenyCallAfter(Integer denyCallAfter) {
      this.denyCallAfter = denyCallAfter;
      return self();
    }

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
