package com.sinch.sdk.domains.voice.models.v2.destination.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.destination.CallHeader;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  VoiceRelayInternalImpl.JSON_PROPERTY_ENDPOINT,
  VoiceRelayInternalImpl.JSON_PROPERTY_ENABLE_INTERRUPTIONS,
  VoiceRelayInternalImpl.JSON_PROPERTY_TTS_VOICE,
  VoiceRelayInternalImpl.JSON_PROPERTY_STT_LANGUAGE,
  VoiceRelayInternalImpl.JSON_PROPERTY_CALL_HEADERS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VoiceRelayInternalImpl implements VoiceRelayInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";

  private OptionalValue<String> endpoint;

  public static final String JSON_PROPERTY_ENABLE_INTERRUPTIONS = "enableInterruptions";

  private OptionalValue<Boolean> enableInterruptions;

  public static final String JSON_PROPERTY_TTS_VOICE = "ttsVoice";

  private OptionalValue<String> ttsVoice;

  public static final String JSON_PROPERTY_STT_LANGUAGE = "sttLanguage";

  private OptionalValue<String> sttLanguage;

  public static final String JSON_PROPERTY_CALL_HEADERS = "callHeaders";

  private OptionalValue<List<CallHeader>> callHeaders;

  public VoiceRelayInternalImpl() {}

  protected VoiceRelayInternalImpl(
      OptionalValue<String> endpoint,
      OptionalValue<Boolean> enableInterruptions,
      OptionalValue<String> ttsVoice,
      OptionalValue<String> sttLanguage,
      OptionalValue<List<CallHeader>> callHeaders) {
    this.endpoint = endpoint;
    this.enableInterruptions = enableInterruptions;
    this.ttsVoice = ttsVoice;
    this.sttLanguage = sttLanguage;
    this.callHeaders = callHeaders;
  }

  @JsonIgnore
  public String getEndpoint() {
    return endpoint.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> endpoint() {
    return endpoint;
  }

  @JsonIgnore
  public Boolean getEnableInterruptions() {
    return enableInterruptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENABLE_INTERRUPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> enableInterruptions() {
    return enableInterruptions;
  }

  @JsonIgnore
  public String getTtsVoice() {
    return ttsVoice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TTS_VOICE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> ttsVoice() {
    return ttsVoice;
  }

  @JsonIgnore
  public String getSttLanguage() {
    return sttLanguage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STT_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> sttLanguage() {
    return sttLanguage;
  }

  @JsonIgnore
  public List<CallHeader> getCallHeaders() {
    return callHeaders.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_HEADERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<CallHeader>> callHeaders() {
    return callHeaders;
  }

  /** Return true if this VoiceRelayInternal object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoiceRelayInternalImpl voiceRelayDetails = (VoiceRelayInternalImpl) o;
    return Objects.equals(this.endpoint, voiceRelayDetails.endpoint)
        && Objects.equals(this.enableInterruptions, voiceRelayDetails.enableInterruptions)
        && Objects.equals(this.ttsVoice, voiceRelayDetails.ttsVoice)
        && Objects.equals(this.sttLanguage, voiceRelayDetails.sttLanguage)
        && Objects.equals(this.callHeaders, voiceRelayDetails.callHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpoint, enableInterruptions, ttsVoice, sttLanguage, callHeaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoiceRelayInternalImpl {\n");
    sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
    sb.append("    enableInterruptions: ")
        .append(toIndentedString(enableInterruptions))
        .append("\n");
    sb.append("    ttsVoice: ").append(toIndentedString(ttsVoice)).append("\n");
    sb.append("    sttLanguage: ").append(toIndentedString(sttLanguage)).append("\n");
    sb.append("    callHeaders: ").append(toIndentedString(callHeaders)).append("\n");
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
  static class Builder implements VoiceRelayInternal.Builder {
    OptionalValue<String> endpoint = OptionalValue.empty();
    OptionalValue<Boolean> enableInterruptions = OptionalValue.empty();
    OptionalValue<String> ttsVoice = OptionalValue.empty();
    OptionalValue<String> sttLanguage = OptionalValue.empty();
    OptionalValue<List<CallHeader>> callHeaders = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ENDPOINT, required = true)
    public Builder setEndpoint(String endpoint) {
      this.endpoint = OptionalValue.of(endpoint);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ENABLE_INTERRUPTIONS)
    public Builder setEnableInterruptions(Boolean enableInterruptions) {
      this.enableInterruptions = OptionalValue.of(enableInterruptions);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_TTS_VOICE, required = true)
    public Builder setTtsVoice(String ttsVoice) {
      this.ttsVoice = OptionalValue.of(ttsVoice);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_STT_LANGUAGE, required = true)
    public Builder setSttLanguage(String sttLanguage) {
      this.sttLanguage = OptionalValue.of(sttLanguage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_HEADERS)
    public Builder setCallHeaders(List<CallHeader> callHeaders) {
      this.callHeaders = OptionalValue.of(callHeaders);
      return this;
    }

    public VoiceRelayInternal build() {
      return new VoiceRelayInternalImpl(
          endpoint, enableInterruptions, ttsVoice, sttLanguage, callHeaders);
    }
  }
}
