package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import java.util.Objects;
import java.util.Optional;

/**
 * Base class for start verification request parameters
 *
 * @since 1.0
 */
public class StartVerificationRequestParameters {

  private final Identity identity;
  private final VerificationMethodType method;
  private final VerificationReference reference;
  private final String custom;

  /**
   * @param identity Specifies the type of endpoint that will be verified and the particular
   *     endpoint. number is currently the only supported endpoint type
   * @param method The type of the verification request.
   * @param reference Used to pass your own reference in the request for tracking purposes.
   * @param custom Can be used to pass custom data in the request.
   */
  public StartVerificationRequestParameters(
      Identity identity,
      VerificationMethodType method,
      VerificationReference reference,
      String custom) {
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

  public VerificationMethodType getMethod() {
    return method;
  }

  public Optional<VerificationReference> getReference() {
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

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static Builder<?> builder(VerificationMethodType method) {
    return new Builder<>(method);
  }

  public static class Builder<B extends Builder<B>> {

    Identity identity;
    VerificationMethodType method;
    VerificationReference reference;
    String custom;

    public Builder() {}

    public Builder(VerificationMethodType method) {
      this.method = method;
    }

    public B setIdentity(Identity identity) {
      this.identity = identity;
      return self();
    }

    protected B setMethod(VerificationMethodType method) {
      this.method = method;
      return self();
    }

    public B setReference(VerificationReference reference) {
      this.reference = reference;
      return self();
    }

    public B setCustom(String custom) {
      this.custom = custom;
      return self();
    }

    public StartVerificationRequestParameters build() {
      return new StartVerificationRequestParameters(identity, method, reference, custom);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
