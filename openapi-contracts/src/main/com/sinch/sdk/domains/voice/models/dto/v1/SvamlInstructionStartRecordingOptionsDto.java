/*
 * Voice API | Sinch
 * The Voice API exposes calling- and conference-related functionality in the Sinch Voice Platform.
 *
 * The version of the OpenAPI document: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** SvamlInstructionStartRecordingOptionsDto */
@JsonPropertyOrder({
  SvamlInstructionStartRecordingOptionsDto.JSON_PROPERTY_DESTINATION_URL,
  SvamlInstructionStartRecordingOptionsDto.JSON_PROPERTY_CREDENTIALS,
  SvamlInstructionStartRecordingOptionsDto.JSON_PROPERTY_FORMAT,
  SvamlInstructionStartRecordingOptionsDto.JSON_PROPERTY_NOTIFICATION_EVENTS,
  SvamlInstructionStartRecordingOptionsDto.JSON_PROPERTY_TRANSCRIPTION_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlInstructionStartRecordingOptionsDto {
  public static final String JSON_PROPERTY_DESTINATION_URL = "destinationUrl";
  private String destinationUrl;
  private boolean destinationUrlDefined = false;

  public static final String JSON_PROPERTY_CREDENTIALS = "credentials";
  private String credentials;
  private boolean credentialsDefined = false;

  public static final String JSON_PROPERTY_FORMAT = "format";
  private String format;
  private boolean formatDefined = false;

  public static final String JSON_PROPERTY_NOTIFICATION_EVENTS = "notificationEvents";
  private Boolean notificationEvents;
  private boolean notificationEventsDefined = false;

  public static final String JSON_PROPERTY_TRANSCRIPTION_OPTIONS = "transcriptionOptions";
  private SvamlInstructionStartRecordingOptionsTranscriptionOptionsDto transcriptionOptions;
  private boolean transcriptionOptionsDefined = false;

  public SvamlInstructionStartRecordingOptionsDto() {}

  public SvamlInstructionStartRecordingOptionsDto destinationUrl(String destinationUrl) {
    this.destinationUrl = destinationUrl;
    this.destinationUrlDefined = true;
    return this;
  }

  /**
   * Get destinationUrl
   *
   * @return destinationUrl
   */
  @JsonProperty(JSON_PROPERTY_DESTINATION_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDestinationUrl() {
    return destinationUrl;
  }

  @JsonIgnore
  public boolean getDestinationUrlDefined() {
    return destinationUrlDefined;
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDestinationUrl(String destinationUrl) {
    this.destinationUrl = destinationUrl;
    this.destinationUrlDefined = true;
  }

  public SvamlInstructionStartRecordingOptionsDto credentials(String credentials) {
    this.credentials = credentials;
    this.credentialsDefined = true;
    return this;
  }

  /**
   * Get credentials
   *
   * @return credentials
   */
  @JsonProperty(JSON_PROPERTY_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCredentials() {
    return credentials;
  }

  @JsonIgnore
  public boolean getCredentialsDefined() {
    return credentialsDefined;
  }

  @JsonProperty(JSON_PROPERTY_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCredentials(String credentials) {
    this.credentials = credentials;
    this.credentialsDefined = true;
  }

  public SvamlInstructionStartRecordingOptionsDto format(String format) {
    this.format = format;
    this.formatDefined = true;
    return this;
  }

  /**
   * Get format
   *
   * @return format
   */
  @JsonProperty(JSON_PROPERTY_FORMAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getFormat() {
    return format;
  }

  @JsonIgnore
  public boolean getFormatDefined() {
    return formatDefined;
  }

  @JsonProperty(JSON_PROPERTY_FORMAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFormat(String format) {
    this.format = format;
    this.formatDefined = true;
  }

  public SvamlInstructionStartRecordingOptionsDto notificationEvents(Boolean notificationEvents) {
    this.notificationEvents = notificationEvents;
    this.notificationEventsDefined = true;
    return this;
  }

  /**
   * Get notificationEvents
   *
   * @return notificationEvents
   */
  @JsonProperty(JSON_PROPERTY_NOTIFICATION_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getNotificationEvents() {
    return notificationEvents;
  }

  @JsonIgnore
  public boolean getNotificationEventsDefined() {
    return notificationEventsDefined;
  }

  @JsonProperty(JSON_PROPERTY_NOTIFICATION_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotificationEvents(Boolean notificationEvents) {
    this.notificationEvents = notificationEvents;
    this.notificationEventsDefined = true;
  }

  public SvamlInstructionStartRecordingOptionsDto transcriptionOptions(
      SvamlInstructionStartRecordingOptionsTranscriptionOptionsDto transcriptionOptions) {
    this.transcriptionOptions = transcriptionOptions;
    this.transcriptionOptionsDefined = true;
    return this;
  }

  /**
   * Get transcriptionOptions
   *
   * @return transcriptionOptions
   */
  @JsonProperty(JSON_PROPERTY_TRANSCRIPTION_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SvamlInstructionStartRecordingOptionsTranscriptionOptionsDto getTranscriptionOptions() {
    return transcriptionOptions;
  }

  @JsonIgnore
  public boolean getTranscriptionOptionsDefined() {
    return transcriptionOptionsDefined;
  }

  @JsonProperty(JSON_PROPERTY_TRANSCRIPTION_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTranscriptionOptions(
      SvamlInstructionStartRecordingOptionsTranscriptionOptionsDto transcriptionOptions) {
    this.transcriptionOptions = transcriptionOptions;
    this.transcriptionOptionsDefined = true;
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
    SvamlInstructionStartRecordingOptionsDto svamlInstructionStartRecordingOptions =
        (SvamlInstructionStartRecordingOptionsDto) o;
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
    sb.append("class SvamlInstructionStartRecordingOptionsDto {\n");
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
}
