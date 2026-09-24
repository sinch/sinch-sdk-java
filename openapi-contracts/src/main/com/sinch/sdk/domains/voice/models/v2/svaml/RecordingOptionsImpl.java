package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  RecordingOptionsImpl.JSON_PROPERTY_FORMAT,
  RecordingOptionsImpl.JSON_PROPERTY_RECORDING_TYPE,
  RecordingOptionsImpl.JSON_PROPERTY_DESTINATION,
  RecordingOptionsImpl.JSON_PROPERTY_DESTINATION_URL,
  RecordingOptionsImpl.JSON_PROPERTY_CREDENTIALS,
  RecordingOptionsImpl.JSON_PROPERTY_TRANSCRIPTION_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RecordingOptionsImpl implements RecordingOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_FORMAT = "format";

  private OptionalValue<RecordingFormatType> format;

  public static final String JSON_PROPERTY_RECORDING_TYPE = "recordingType";

  private OptionalValue<RecordingType> recordingType;

  public static final String JSON_PROPERTY_DESTINATION = "destination";

  private OptionalValue<RecordingDestinationType> destination;

  public static final String JSON_PROPERTY_DESTINATION_URL = "destinationUrl";

  private OptionalValue<String> destinationUrl;

  public static final String JSON_PROPERTY_CREDENTIALS = "credentials";

  private OptionalValue<String> credentials;

  public static final String JSON_PROPERTY_TRANSCRIPTION_OPTIONS = "transcriptionOptions";

  private OptionalValue<TranscriptionOptions> transcriptionOptions;

  public RecordingOptionsImpl() {}

  protected RecordingOptionsImpl(
      OptionalValue<RecordingFormatType> format,
      OptionalValue<RecordingType> recordingType,
      OptionalValue<RecordingDestinationType> destination,
      OptionalValue<String> destinationUrl,
      OptionalValue<String> credentials,
      OptionalValue<TranscriptionOptions> transcriptionOptions) {
    this.format = format;
    this.recordingType = recordingType;
    this.destination = destination;
    this.destinationUrl = destinationUrl;
    this.credentials = credentials;
    this.transcriptionOptions = transcriptionOptions;
  }

  @JsonIgnore
  public RecordingFormatType getFormat() {
    return format.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FORMAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<RecordingFormatType> format() {
    return format;
  }

  @JsonIgnore
  public RecordingType getRecordingType() {
    return recordingType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECORDING_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<RecordingType> recordingType() {
    return recordingType;
  }

  @JsonIgnore
  public RecordingDestinationType getDestination() {
    return destination.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<RecordingDestinationType> destination() {
    return destination;
  }

  @JsonIgnore
  public String getDestinationUrl() {
    return destinationUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> destinationUrl() {
    return destinationUrl;
  }

  @JsonIgnore
  public String getCredentials() {
    return credentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> credentials() {
    return credentials;
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

  /** Return true if this RecordingOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecordingOptionsImpl recordingOptions = (RecordingOptionsImpl) o;
    return Objects.equals(this.format, recordingOptions.format)
        && Objects.equals(this.recordingType, recordingOptions.recordingType)
        && Objects.equals(this.destination, recordingOptions.destination)
        && Objects.equals(this.destinationUrl, recordingOptions.destinationUrl)
        && Objects.equals(this.credentials, recordingOptions.credentials)
        && Objects.equals(this.transcriptionOptions, recordingOptions.transcriptionOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        format, recordingType, destination, destinationUrl, credentials, transcriptionOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecordingOptionsImpl {\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    recordingType: ").append(toIndentedString(recordingType)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    destinationUrl: ").append(toIndentedString(destinationUrl)).append("\n");
    sb.append("    credentials: ").append(toIndentedString(credentials)).append("\n");
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
  static class Builder implements RecordingOptions.Builder {
    OptionalValue<RecordingFormatType> format = OptionalValue.empty();
    OptionalValue<RecordingType> recordingType = OptionalValue.empty();
    OptionalValue<RecordingDestinationType> destination = OptionalValue.empty();
    OptionalValue<String> destinationUrl = OptionalValue.empty();
    OptionalValue<String> credentials = OptionalValue.empty();
    OptionalValue<TranscriptionOptions> transcriptionOptions = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_FORMAT)
    public Builder setFormat(RecordingFormatType format) {
      this.format = OptionalValue.of(format);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RECORDING_TYPE)
    public Builder setRecordingType(RecordingType recordingType) {
      this.recordingType = OptionalValue.of(recordingType);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_DESTINATION, required = true)
    public Builder setDestination(RecordingDestinationType destination) {
      this.destination = OptionalValue.of(destination);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_DESTINATION_URL, required = true)
    public Builder setDestinationUrl(String destinationUrl) {
      this.destinationUrl = OptionalValue.of(destinationUrl);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CREDENTIALS, required = true)
    public Builder setCredentials(String credentials) {
      this.credentials = OptionalValue.of(credentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TRANSCRIPTION_OPTIONS)
    public Builder setTranscriptionOptions(TranscriptionOptions transcriptionOptions) {
      this.transcriptionOptions = OptionalValue.of(transcriptionOptions);
      return this;
    }

    public RecordingOptions build() {
      return new RecordingOptionsImpl(
          format, recordingType, destination, destinationUrl, credentials, transcriptionOptions);
    }
  }
}
