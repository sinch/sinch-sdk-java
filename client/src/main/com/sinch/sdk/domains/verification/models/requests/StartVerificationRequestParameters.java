package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethod;
import java.util.Objects;
import java.util.Optional;

/**
 * Base class for start verification request parameters
 *
 * @since 1.0
 */
public class StartVerificationRequestParameters {

  private final Identity identity;
  private final VerificationMethod method;
  private final String reference;
  private final String custom;

  public StartVerificationRequestParameters(
      Identity identity, VerificationMethod method, String reference, String custom) {
    Objects.requireNonNull(identity);
    Objects.requireNonNull(method);

    this.identity = identity;
    this.method = method;
    this.reference = reference;
    this.custom = custom;
  }

  public Identity getIdentity() {
    return identity;
  }

  public VerificationMethod getMethod() {
    return method;
  }

  public Optional<String> getReference() {
    return Optional.ofNullable(reference);
  }

  public Optional<String> getCustom() {
    return Optional.ofNullable(custom);
  }

  @Override
  public String toString() {
    return "StartVerificationRequestParameters{"
        + "identity="
        + identity
        + ", method="
        + method
        + ", reference='"
        + reference
        + '\''
        + ", custom='"
        + custom
        + '\''
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    Identity identity;
    VerificationMethod method;
    String reference;
    String custom;

    public Builder setIdentity(Identity identity) {
      this.identity = identity;
      return this;
    }

    public Builder setMethod(VerificationMethod method) {
      this.method = method;
      return this;
    }

    public Builder setReference(String reference) {
      this.reference = reference;
      return this;
    }

    public Builder setCustom(String custom) {
      this.custom = custom;
      return this;
    }

    public StartVerificationRequestParameters build() {
      return new StartVerificationRequestParameters(identity, method, reference, custom);
    }
  }
}
