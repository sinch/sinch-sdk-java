package com.sinch.sdk.domains.conversation.models.credentials;

/**
 * Channel Integration State.
 *
 * <p>A channel credential might need time to be processed.
 *
 * <p>Some channels will report integration state {@link CredentialStateStatusType#PENDING PENDING}
 * while the process is ongoing. However, after a few seconds, or a minute at most you should see
 * {@link CredentialStateStatusType#ACTIVE ACTIVE} or {@link CredentialStateStatusType#FAILING
 * FAILING}.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/keyconcepts/#channel-integration-state">Channel
 *     Integration State</a>
 * @since 1.0
 */
public class CredentialState {

  private final CredentialStateStatusType status;
  private final String description;

  private CredentialState(CredentialStateStatusType status, String description) {
    this.status = status;
    this.description = description;
  }

  /**
   * Current integration status
   *
   * @return Get current status
   * @since 1.0
   */
  public CredentialStateStatusType getStatus() {
    return status;
  }

  /**
   * A status description
   *
   * @return description
   * @since 1.0
   */
  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "CredentialState{"
        + "status='"
        + status
        + '\''
        + ", description='"
        + description
        + '\''
        + '}';
  }

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    CredentialStateStatusType status;
    String description;

    /**
     * see getter
     *
     * @param status see getter
     * @return Current builder
     * @see #getStatus()
     * @since 1.0
     */
    public Builder setStatus(CredentialStateStatusType status) {
      this.status = status;
      return this;
    }

    /**
     * see getter
     *
     * @param description see getter
     * @return Current builder
     * @see #getDescription()
     * @since 1.0
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public CredentialState build() {
      return new CredentialState(status, description);
    }
  }
}
