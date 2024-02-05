package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;

/**
 * Base class for start verification request parameters
 *
 * @since 1.0
 */
public class StartVerificationRequestParameters {

  private final OptionalValue<Identity> identity;
  private final OptionalValue<VerificationMethodType> method;
  private final OptionalValue<VerificationReference> reference;
  private final OptionalValue<String> custom;

  protected StartVerificationRequestParameters(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationMethodType> method,
      OptionalValue<VerificationReference> reference,
      OptionalValue<String> custom) {
    this.identity = identity;
    this.method = method;
    this.reference = reference;
    this.custom = custom;
  }

  public OptionalValue<Identity> getIdentity() {
    return identity;
  }

  public OptionalValue<VerificationMethodType> getMethod() {
    return method;
  }

  public OptionalValue<VerificationReference> getReference() {
    return reference;
  }

  public OptionalValue<String> getCustom() {
    return custom;
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

  public static Builder<?> builder(VerificationMethodType method) {
    return new Builder<>(method);
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<VerificationMethodType> method = OptionalValue.empty();
    OptionalValue<VerificationReference> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();

    /**
     * @param method The type of the verification request
     */
    protected Builder(VerificationMethodType method) {
      this.method = OptionalValue.of(method);
    }

    /**
     * @param identity Specifies the type of endpoint that will be verified and the particular
     *     endpoint. number is currently the only supported endpoint type
     * @return current builder
     */
    public B setIdentity(Identity identity) {
      this.identity = OptionalValue.of(identity);
      return self();
    }

    /**
     * @param reference Used to pass your own reference in the request for tracking purposes.
     * @return current builder
     */
    public B setReference(VerificationReference reference) {
      this.reference = OptionalValue.of(reference);
      return self();
    }

    /**
     * @param custom Can be used to pass custom data in the request.
     * @return current builder
     */
    public B setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
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
