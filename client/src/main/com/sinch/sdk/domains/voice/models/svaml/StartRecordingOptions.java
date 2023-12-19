package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;

public class StartRecordingOptions {

  private final OptionalValue<String> destinationUrl;
  private final OptionalValue<String> credentials;
  private final OptionalValue<String> format;
  private final OptionalValue<Boolean> notificationEvents;
  private final OptionalValue<TranscriptionOptions> transcriptionOptions;

  private StartRecordingOptions(
      OptionalValue<String> destinationUrl,
      OptionalValue<String> credentials,
      OptionalValue<String> format,
      OptionalValue<Boolean> notificationEvents,
      OptionalValue<TranscriptionOptions> transcriptionOptions) {
    this.destinationUrl = destinationUrl;
    this.credentials = credentials;
    this.format = format;
    this.notificationEvents = notificationEvents;
    this.transcriptionOptions = transcriptionOptions;
  }

  public OptionalValue<String> getDestinationUrl() {
    return destinationUrl;
  }

  public OptionalValue<String> getCredentials() {
    return credentials;
  }

  public OptionalValue<String> getFormat() {
    return format;
  }

  public OptionalValue<Boolean> getNotificationEvents() {
    return notificationEvents;
  }

  public OptionalValue<TranscriptionOptions> getTranscriptionOptions() {
    return transcriptionOptions;
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
        + ", transcriptionOptions="
        + transcriptionOptions
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    OptionalValue<String> destinationUrl = OptionalValue.empty();
    OptionalValue<String> credentials = OptionalValue.empty();
    OptionalValue<String> format = OptionalValue.empty();
    OptionalValue<Boolean> notificationEvents = OptionalValue.empty();
    OptionalValue<TranscriptionOptions> transcriptionOptions = OptionalValue.empty();

    public Builder setDestinationUrl(String destinationUrl) {
      this.destinationUrl = OptionalValue.of(destinationUrl);
      return this;
    }

    public Builder setCredentials(String credentials) {
      this.credentials = OptionalValue.of(credentials);
      return this;
    }

    public Builder setFormat(String format) {
      this.format = OptionalValue.of(format);
      return this;
    }

    public Builder setNotificationEvents(Boolean notificationEvents) {
      this.notificationEvents = OptionalValue.of(notificationEvents);
      return this;
    }

    public Builder setTranscriptionOptions(TranscriptionOptions transcriptionOptions) {
      this.transcriptionOptions = OptionalValue.of(transcriptionOptions);
      return this;
    }

    public StartRecordingOptions build() {
      return new StartRecordingOptions(
          destinationUrl, credentials, format, notificationEvents, transcriptionOptions);
    }
  }
}
