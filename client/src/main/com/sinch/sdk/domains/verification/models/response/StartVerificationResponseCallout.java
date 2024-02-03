package com.sinch.sdk.domains.verification.models.response;

import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.VerificationId;
import java.util.Collection;

/**
 * Dedicated response type for a callout verification started with {@link
 * com.sinch.sdk.domains.verification.VerificationsService#start(StartVerificationRequestParameters)
 * VerificationsService#start()} initiated wit method {@link
 * com.sinch.sdk.domains.verification.models.VerificationMethodType#CALLOUT CALLOUT}
 *
 * @since 1.0
 */
public class StartVerificationResponseCallout extends StartVerificationResponse {

  /**
   * @param id Verification identifier used to query for status.
   * @param links Available methods and actions which can be done after a successful Verification
   */
  private StartVerificationResponseCallout(VerificationId id, Collection<Link> links) {
    super(id, links);
  }

  @Override
  public String toString() {
    return "StartVerificationResponseCallout{} " + super.toString();
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

    private Builder() {
      super();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public StartVerificationResponseCallout build() {
      return new StartVerificationResponseCallout(id, links);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
