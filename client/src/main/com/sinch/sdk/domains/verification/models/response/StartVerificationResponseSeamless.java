package com.sinch.sdk.domains.verification.models.response;

import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.VerificationId;
import java.util.Collection;

/** Dedicated response type for a seamless verification */
public class StartVerificationResponseSeamless extends StartVerificationResponse {

  private final String targetUri;

  /**
   * @param id Verification identifier used to query for status.
   * @param links Available methods and actions which can be done after a successful Verification
   * @param targetUri The target URI
   */
  public StartVerificationResponseSeamless(
      VerificationId id, Collection<Link> links, String targetUri) {
    super(id, links);
    this.targetUri = targetUri;
  }

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends StartVerificationResponse.Builder<Builder> {

    String targetUri;

    public Builder setTargetUri(String targetUri) {
      this.targetUri = targetUri;
      return this;
    }

    public StartVerificationResponseSeamless build() {
      return new StartVerificationResponseSeamless(id, links, targetUri);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
