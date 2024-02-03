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
  public OptionalValue<VerificationMethodType> getMethod() {
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

  /**
   * Getting Builder
   *
   * @param method Method to be used
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder<?> builder(VerificationMethodType method) {
    return new Builder<>(method);
  }

  /**
   * Dedicated Builder
   *
   * @param <B> Builder
   * @since 1.0
   */
  public static class Builder<B extends Builder<B>> {

    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<VerificationMethodType> method = OptionalValue.empty();
    OptionalValue<VerificationReference> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();

    /**
     * The type of the verification request
     *
     * @param method The type value
     * @since 1.0
     */
    protected Builder(VerificationMethodType method) {
      this.method = OptionalValue.of(method);
    }

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
    public StartVerificationRequestParameters build() {
      return new StartVerificationRequestParameters(identity, method, reference, custom);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
