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

  protected static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<VerificationMethodType> method;

    protected Builder() {}

    protected Builder(VerificationMethodType method) {
      this.method = OptionalValue.of(method);
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
