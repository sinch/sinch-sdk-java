package com.sinch.sdk.domains.verification.models.response;

import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters.Builder;
import java.util.Collection;

/** Dedicated response type for a callout verification */
public class StartVerificationResponseCallout extends StartVerificationResponse {

  /**
   * @param id Verification identifier used to query for status.
   * @param links Available methods and actions which can be done after a successful Verification
   */
  public StartVerificationResponseCallout(String id, Collection<Link> links) {
    super(id, links);
  }

  @Override
  public String toString() {
    return "StartVerificationResponseCallout{} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends StartVerificationResponse.Builder<Builder> {

    public StartVerificationResponseCallout build() {
      return new StartVerificationResponseCallout(id, links);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
