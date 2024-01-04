package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;

public class VerificationReportRequestParameters {

  private final OptionalValue<VerificationMethodType> method;

  protected VerificationReportRequestParameters(OptionalValue<VerificationMethodType> method) {
    this.method = method;
  }

  public OptionalValue<VerificationMethodType> getMethod() {
    return method;
  }

  @Override
  public String toString() {
    return "VerificationReportRequestParameters{" + "method=" + method + '}';
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<VerificationMethodType> method;

    public Builder() {}

    public Builder(VerificationMethodType method) {
      this.method = OptionalValue.of(method);
    }

    /**
     * @param method The type of the verification request.
     * @return current builder
     */
    protected B setMethod(VerificationMethodType method) {
      this.method = OptionalValue.of(method);
      return self();
    }

    public VerificationReportRequestParameters build() {
      return new VerificationReportRequestParameters(method);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
