package com.sinch.sdk.domains.conversation.models.credentials;

public class CredentialState {

  private final CredentialStateStatusType status;
  private final String description;

  public CredentialState(CredentialStateStatusType status, String description) {
    this.status = status;
    this.description = description;
  }

  public CredentialStateStatusType getStatus() {
    return status;
  }

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    CredentialStateStatusType status;
    String description;

    public Builder setStatus(CredentialStateStatusType status) {
      this.status = status;
      return this;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public CredentialState build() {
      return new CredentialState(status, description);
    }
  }
}
