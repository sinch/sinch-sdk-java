package com.sinch.sdk.domains.verification.models.webhooks;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base class for verification callback response
 *
 * @since 1.0
 */
public class VerificationResponse {

  @JsonProperty("action")
  private final VerificationResponseActionType action;

  /**
   * @param action Determines whether the verification can be executed
   */
  VerificationResponse(VerificationResponseActionType action) {
    this.action = action;
  }

  public VerificationResponseActionType getAction() {
    return action;
  }

  @Override
  public String toString() {
    return "VerificationResponse{" + "action=" + action + '}';
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    VerificationResponseActionType action;

    public B setAction(VerificationResponseActionType action) {
      this.action = action;
      return self();
    }

    public VerificationResponse build() {
      return new VerificationResponse(action);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
