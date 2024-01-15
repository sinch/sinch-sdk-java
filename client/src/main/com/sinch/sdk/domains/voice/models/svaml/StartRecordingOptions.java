package com.sinch.sdk.domains.voice.models.svaml;

public class StartRecordingOptions {

  private final String destinationUrl;
  private final String credentials;
  private final String format;
  private final Boolean notificationEvents;

  private StartRecordingOptions(
      String destinationUrl, String credentials, String format, Boolean notificationEvents) {
    this.destinationUrl = destinationUrl;
    this.credentials = credentials;
    this.format = format;
    this.notificationEvents = notificationEvents;
  }

  public String getDestinationUrl() {
    return destinationUrl;
  }

  public String getCredentials() {
    return credentials;
  }

  public String getFormat() {
    return format;
  }

  public Boolean getNotificationEvents() {
    return notificationEvents;
  }

  @Override
  public String toString() {
    return "StartRecordingOptions{"
        + "destinationUrl='"
        + destinationUrl
        + '\''
        + ", credentials='"
        + credentials
        + '\''
        + ", format='"
        + format
        + '\''
        + ", notificationEvents="
        + notificationEvents
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String destinationUrl;
    String credentials;
    String format;
    Boolean notificationEvents;

    public Builder setDestinationUrl(String destinationUrl) {
      this.destinationUrl = destinationUrl;
      return this;
    }

    public Builder setCredentials(String credentials) {
      this.credentials = credentials;
      return this;
    }

    public Builder setFormat(String format) {
      this.format = format;
      return this;
    }

    public Builder setNotificationEvents(Boolean notificationEvents) {
      this.notificationEvents = notificationEvents;
      return this;
    }

    public StartRecordingOptions build() {
      return new StartRecordingOptions(destinationUrl, credentials, format, notificationEvents);
    }
  }
}
