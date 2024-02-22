package com.sinch.sdk.models;

/**
 * Credentials related to unified Sinch authentication
 *
 * @since 1.0
 */
public class UnifiedCredentials {

  private final String keyId;
  private final String keySecret;
  private final String projectId;

  private UnifiedCredentials(String keyId, String keySecret, String projectId) {
    this.keyId = keyId;
    this.keySecret = keySecret;
    this.projectId = projectId;
  }

  /**
   * Get Key ID
   *
   * @return key id.
   * @see <a href="https://developers.sinch.com/">https://developers.sinch.com/</a>
   * @since 1.0
   */
  public String getKeyId() {
    return keyId;
  }

  /**
   * Get key secret
   *
   * @return key secret.
   * @see <a href="https://developers.sinch.com/">https://developers.sinch.com/</a>
   * @since 1.0
   */
  public String getKeySecret() {
    return keySecret;
  }

  /**
   * Get Project ID
   *
   * @return Project id.
   * @see <a href="https://developers.sinch.com/">https://developers.sinch.com/</a>
   * @since 1.0
   */
  public String getProjectId() {
    return projectId;
  }

  @Override
  public String toString() {
    return "UnifiedCredentials{"
        + "keyId='"
        + keyId
        + '\''
        + ", keySecret='"
        + keySecret
        + '\''
        + ", projectId='"
        + projectId
        + '\''
        + '}';
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new Builder();
  }

  /**
   * Getting Builder
   *
   * @param credentials Source credentials to fill initial builder state
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder(UnifiedCredentials credentials) {
    return new Builder(credentials);
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  static class Builder {

    String keyId;
    String keySecret;
    String projectId;

    protected Builder() {}

    /**
     * Initialize a builder with existing credentials
     *
     * @param credentials Credentials to be used as initial builder state
     * @since 1.0
     */
    protected Builder(UnifiedCredentials credentials) {
      this.keyId = credentials.getKeyId();
      this.keySecret = credentials.getKeySecret();
      this.projectId = credentials.getProjectId();
    }

    /**
     * Set key ID
     *
     * @param keyId key ID
     * @return Current builder
     * @since 1.0
     */
    public Builder setKeyId(String keyId) {
      this.keyId = keyId;
      return this;
    }

    /**
     * Set key secret
     *
     * @param keySecret key secret
     * @return Current builder
     * @since 1.0
     */
    public Builder setKeySecret(String keySecret) {
      this.keySecret = keySecret;
      return this;
    }

    /**
     * Set Project ID
     *
     * @param projectId Project ID
     * @return Current builder
     * @since 1.0
     */
    public Builder setProjectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public UnifiedCredentials build() {
      return new UnifiedCredentials(keyId, keySecret, projectId);
    }
  }
}
