package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;

/**
 * Base class for verification report request parameters
 *
 * @since 1.0
 */
public class VerificationReportRequestParameters {

  private final OptionalValue<VerificationMethodType> method;

  protected VerificationReportRequestParameters(OptionalValue<VerificationMethodType> method) {
    this.method = method;
  }

  /**
   * The type of the verification request.
   *
   * @return method value
   * @since 1.0
   */
  public OptionalValue<VerificationMethodType> getMethod() {
    return method;
  }

  @Override
  public String toString() {
    return "VerificationReportRequestParameters{" + "method=" + method + '}';
  }

  protected static Builder<?> builder() {
    return new Builder<>();
  }

  /**
   * Dedicated Builder
   *
   * @param <B> Builder
   * @since 1.0
   */
  public static class Builder<B extends Builder<B>> {

    OptionalValue<VerificationMethodType> method;

    protected Builder() {}

    protected Builder(VerificationMethodType method) {
      this.method = OptionalValue.of(method);
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationReportRequestParameters build() {
      return new VerificationReportRequestParameters(method);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
