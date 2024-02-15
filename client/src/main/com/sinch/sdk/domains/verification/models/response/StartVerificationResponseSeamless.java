package com.sinch.sdk.domains.verification.models.response;

import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSeamlessRequestParameters;
import java.util.Collection;

/**
 * Dedicated response type for a seamless call verification started with {@link
 * com.sinch.sdk.domains.verification.VerificationsService#startSeamless(StartVerificationSeamlessRequestParameters)}
 * initiated wit method {@link
 * com.sinch.sdk.domains.verification.models.VerificationMethodType#SEAMLESS SEAMLESS}
 *
 * @since 1.0
 */
public class StartVerificationResponseSeamless extends StartVerificationResponse {

  private final String targetUri;

  private StartVerificationResponseSeamless(
      VerificationId id, Collection<Link> links, String targetUri) {
    super(id, links);
    this.targetUri = targetUri;
  }

  /**
   * The target URI
   *
   * @return The target URI
   * @since 1.0
   */
  public String getTargetUri() {
    return targetUri;
  }

  @Override
  public String toString() {
    return "StartVerificationResponseSeamless{"
        + "targetUri='"
        + targetUri
        + '\''
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

    String targetUri;

    private Builder() {
      super();
    }

    /**
     * See {@link StartVerificationResponseSeamless#getLinks() getter}
     *
     * @param targetUri see getter
     * @return The current builder
     * @since 1.0
     */
    public Builder setTargetUri(String targetUri) {
      this.targetUri = targetUri;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public StartVerificationResponseSeamless build() {
      return new StartVerificationResponseSeamless(id, links, targetUri);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
