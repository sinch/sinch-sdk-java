package com.sinch.sdk.domains.verification.models.webhooks;

/**
 * Base class for verification callback response
 *
 * @since 1.0
 */
public class VerificationResponse {

  private final VerificationResponseActionType action;

  VerificationResponse(VerificationResponseActionType action) {
    this.action = action;
  }

  /**
   * Determines whether the verification can be executed
   *
   * @return action type to be performed
   * @since 1.0
   */
  public VerificationResponseActionType getAction() {
    return action;
  }

  @Override
  public String toString() {
    return "VerificationResponseActionType{" + "action=" + action + '}';
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder<?> builder() {
    return new Builder<>();
  }

  /**
   * Dedicated Builder
   *
   * @param <B> Builder
   * @since 1.0
   */
  public static class Builder<B extends Builder<B>> {

    VerificationResponseActionType action;

    protected Builder() {
      super();
    }

    /**
     * See {@link VerificationResponse#getAction() getter}
     *
     * @param action see getter
     * @return The current builder
     * @since 1.0
     */
    public B setAction(VerificationResponseActionType action) {
      this.action = action;
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationResponse build() {
      return new VerificationResponse(action);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
