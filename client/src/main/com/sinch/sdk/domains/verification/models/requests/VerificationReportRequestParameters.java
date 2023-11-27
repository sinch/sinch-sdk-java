package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import java.util.Objects;

public class VerificationReportRequestParameters {

  private final VerificationMethodType method;

  public VerificationReportRequestParameters(VerificationMethodType method) {
    Objects.requireNonNull(method);

    this.method = method;
  }

  public VerificationMethodType getMethod() {
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

    VerificationMethodType method;

    public Builder() {}

    public Builder(VerificationMethodType method) {
      this.method = method;
    }

    protected B setMethod(VerificationMethodType method) {
      this.method = method;
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
