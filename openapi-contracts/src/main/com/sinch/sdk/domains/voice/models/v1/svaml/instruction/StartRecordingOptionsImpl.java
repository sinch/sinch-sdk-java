package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  StartRecordingOptionsImpl.JSON_PROPERTY_DESTINATION_URL,
  StartRecordingOptionsImpl.JSON_PROPERTY_CREDENTIALS,
  StartRecordingOptionsImpl.JSON_PROPERTY_FORMAT,
  StartRecordingOptionsImpl.JSON_PROPERTY_NOTIFICATION_EVENTS,
  StartRecordingOptionsImpl.JSON_PROPERTY_TRANSCRIPTION_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartRecordingOptionsImpl implements StartRecordingOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DESTINATION_URL = "destinationUrl";

  private OptionalValue<String> destinationUrl;

  public static final String JSON_PROPERTY_CREDENTIALS = "credentials";

  private OptionalValue<String> credentials;

  public static final String JSON_PROPERTY_FORMAT = "format";

  private OptionalValue<String> format;

  public static final String JSON_PROPERTY_NOTIFICATION_EVENTS = "notificationEvents";

  private OptionalValue<Boolean> notificationEvents;

  public static final String JSON_PROPERTY_TRANSCRIPTION_OPTIONS = "transcriptionOptions";

  private OptionalValue<TranscriptionOptions> transcriptionOptions;

  public StartRecordingOptionsImpl() {}

  protected StartRecordingOptionsImpl(
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

  @JsonIgnore
  public String getDestinationUrl() {
    return destinationUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> destinationUrl() {
    return destinationUrl;
  }

  @JsonIgnore
  public String getCredentials() {
    return credentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> credentials() {
    return credentials;
  }

  @JsonIgnore
  public String getFormat() {
    return format.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FORMAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> format() {
    return format;
  }

  @JsonIgnore
  public Boolean getNotificationEvents() {
    return notificationEvents.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NOTIFICATION_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> notificationEvents() {
    return notificationEvents;
  }

  @JsonIgnore
  public TranscriptionOptions getTranscriptionOptions() {
    return transcriptionOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRANSCRIPTION_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TranscriptionOptions> transcriptionOptions() {
    return transcriptionOptions;
  }

  /** Return true if this svaml.instruction.startRecordingOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartRecordingOptionsImpl svamlInstructionStartRecordingOptions = (StartRecordingOptionsImpl) o;
    return Objects.equals(this.destinationUrl, svamlInstructionStartRecordingOptions.destinationUrl)
        && Objects.equals(this.credentials, svamlInstructionStartRecordingOptions.credentials)
        && Objects.equals(this.format, svamlInstructionStartRecordingOptions.format)
        && Objects.equals(
            this.notificationEvents, svamlInstructionStartRecordingOptions.notificationEvents)
        && Objects.equals(
            this.transcriptionOptions, svamlInstructionStartRecordingOptions.transcriptionOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        destinationUrl, credentials, format, notificationEvents, transcriptionOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartRecordingOptionsImpl {\n");
    sb.append("    destinationUrl: ").append(toIndentedString(destinationUrl)).append("\n");
    sb.append("    credentials: ").append(toIndentedString(credentials)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    notificationEvents: ").append(toIndentedString(notificationEvents)).append("\n");
    sb.append("    transcriptionOptions: ")
        .append(toIndentedString(transcriptionOptions))
        .append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements StartRecordingOptions.Builder {
    OptionalValue<String> destinationUrl = OptionalValue.empty();
    OptionalValue<String> credentials = OptionalValue.empty();
    OptionalValue<String> format = OptionalValue.empty();
    OptionalValue<Boolean> notificationEvents = OptionalValue.empty();
    OptionalValue<TranscriptionOptions> transcriptionOptions = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DESTINATION_URL)
    public Builder setDestinationUrl(String destinationUrl) {
      this.destinationUrl = OptionalValue.of(destinationUrl);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CREDENTIALS)
    public Builder setCredentials(String credentials) {
      this.credentials = OptionalValue.of(credentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FORMAT)
    public Builder setFormat(String format) {
      this.format = OptionalValue.of(format);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NOTIFICATION_EVENTS)
    public Builder setNotificationEvents(Boolean notificationEvents) {
      this.notificationEvents = OptionalValue.of(notificationEvents);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TRANSCRIPTION_OPTIONS)
    public Builder setTranscriptionOptions(TranscriptionOptions transcriptionOptions) {
      this.transcriptionOptions = OptionalValue.of(transcriptionOptions);
      return this;
    }

    public StartRecordingOptions build() {
      return new StartRecordingOptionsImpl(
          destinationUrl, credentials, format, notificationEvents, transcriptionOptions);
    }
  }
}
