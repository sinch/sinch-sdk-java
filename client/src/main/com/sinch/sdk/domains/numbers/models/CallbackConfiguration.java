package com.sinch.sdk.domains.numbers.models;

/**
 * Callback configuration
 *
 * @since 1.0
 */
public class CallbackConfiguration {
  private final String projectId;

  private final String hmacSecret;

  /**
   * @param projectId ID of the project the configuration belongs to.
   * @param hmacSecret The HMAC secret used for creating the callbacks X-Sinch-Signature header.
   */
  public CallbackConfiguration(String projectId, String hmacSecret) {
    this.projectId = projectId;
    this.hmacSecret = hmacSecret;
  }

  public String getProjectId() {
    return projectId;
  }

  public String getHMACSecret() {
    return hmacSecret;
  }

  @Override
  public String toString() {
    //  do not output secret !
    return "CallbackConfiguration{"
        + "projectId='"
        + projectId
        + '\''
        + ", hmacSecret='"
        + "..."
        + '\''
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String projectId;

    private String hmacSecret;

    private Builder() {}

    public CallbackConfiguration build() {
      return new CallbackConfiguration(projectId, hmacSecret);
    }

    public Builder setProjectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    public Builder setHMACSecret(String hmacSecret) {
      this.hmacSecret = hmacSecret;
      return this;
    }
  }
}
