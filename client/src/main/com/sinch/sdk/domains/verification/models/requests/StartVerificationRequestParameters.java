package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;

/**
 * Base class for start verification request parameters
 *
 * @since 1.0
 */
public abstract class StartVerificationRequestParameters {

  private final VerificationMethodType method;
  private final OptionalValue<Identity> identity;
  private final OptionalValue<VerificationReference> reference;
  private final OptionalValue<String> custom;

  protected StartVerificationRequestParameters(
      OptionalValue<Identity> identity,
      VerificationMethodType method,
      OptionalValue<VerificationReference> reference,
      OptionalValue<String> custom) {
    this.identity = identity;
    this.method = method;
    this.reference = reference;
    this.custom = custom;
  }

  /**
   * See {@link StartVerificationRequestParameters.Builder#setIdentity(NumberIdentity) builder
   * setter}
   *
   * @return The reference value
   * @since 1.0
   */
  public OptionalValue<Identity> getIdentity() {
    return identity;
  }

  /**
   * The type of the verification request.
   *
   * @return The method value
   * @since 1.0
   */
  public VerificationMethodType getMethod() {
    return method;
  }

  /**
   * See {@link StartVerificationRequestParameters.Builder#setReference(VerificationReference)
   * builder setter}
   *
   * @return The reference value
   * @since 1.0
   */
  public OptionalValue<VerificationReference> getReference() {
    return reference;
  }

  /**
   * See {@link StartVerificationRequestParameters.Builder#setCustom(String) builder setter}
   *
   * @return The custom value
   * @since 1.0
   */
  public OptionalValue<String> getCustom() {
    return custom;
  }

  @Override
  public String toString() {
    return "StartVerificationRequestParameters{"
        + "method="
        + method
        + ", identity="
        + identity
        + ", reference='"
        + reference
        + '\''
        + ", custom='"
        + custom
        + '\''
        + '}';
  }

  /**
   * Dedicated Builder
   *
   * @param <B> Builder
   * @since 1.0
   */
  public abstract static class Builder<B extends Builder<B>> {

    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<VerificationReference> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();

    /**
     * Specifies the type of endpoint that will be verified and the particular endpoint.
     * NumberIdentity is currently the only supported endpoint type
     *
     * @param identity Specifies the type of endpoint that will be verified and the particular
     *     endpoint. number is currently the only supported endpoint type
     * @return current builder
     * @since 1.0
     */
    public B setIdentity(NumberIdentity identity) {
      this.identity = OptionalValue.of(identity);
      return self();
    }

    /**
     * Used to pass your own reference in the request for tracking purposes
     *
     * @param reference your own reference to be used
     * @return current builder
     * @since 1.0
     */
    public B setReference(VerificationReference reference) {
      this.reference = OptionalValue.of(reference);
      return self();
    }

    /**
     * Pass custom data in the request
     *
     * @param custom custom data
     * @return current builder
     * @since 1.0
     */
    public B setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public abstract StartVerificationRequestParameters build();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
