package com.sinch.sdk.domains.verification.models.response;

import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.VerificationId;
import java.util.Collection;

/** Dedicated response type for a sms verification */
public class StartVerificationResponseSMS extends StartVerificationResponse {

  private final String template;
  private final Integer interceptionTimeOut;

  /**
   * @param id Verification identifier used to query for status.
   * @param links Available methods and actions which can be done after a successful Verification
   * @param template The expected template for the SMS response
   * @param interceptionTimeOut The amount of time in seconds that the client should wait for the
   *     SMS.
   */
  public StartVerificationResponseSMS(
      VerificationId id, Collection<Link> links, String template, Integer interceptionTimeOut) {
    super(id, links);
    this.template = template;
    this.interceptionTimeOut = interceptionTimeOut;
  }

  public String getTemplate() {
    return template;
  }

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends StartVerificationResponse.Builder<Builder> {

    String template;
    Integer interceptionTimeOut;

    public Builder setTemplate(String template) {
      this.template = template;
      return this;
    }

    public Builder setInterceptionTimeOut(Integer interceptionTimeOut) {
      this.interceptionTimeOut = interceptionTimeOut;
      return this;
    }

    public StartVerificationResponseSMS build() {
      return new StartVerificationResponseSMS(id, links, template, interceptionTimeOut);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
