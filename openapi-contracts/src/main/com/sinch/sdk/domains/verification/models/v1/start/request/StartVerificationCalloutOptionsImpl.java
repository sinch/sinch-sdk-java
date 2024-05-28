package com.sinch.sdk.domains.verification.models.v1.start.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({StartVerificationCalloutOptionsImpl.JSON_PROPERTY_SPEECH})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationCalloutOptionsImpl implements StartVerificationCalloutOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SPEECH = "speech";

  private OptionalValue<StartVerificationCalloutOptionsSpeech> speech;

  public StartVerificationCalloutOptionsImpl() {}

  protected StartVerificationCalloutOptionsImpl(
      OptionalValue<StartVerificationCalloutOptionsSpeech> speech) {
    this.speech = speech;
  }

  @JsonIgnore
  public StartVerificationCalloutOptionsSpeech getSpeech() {
    return speech.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SPEECH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationCalloutOptionsSpeech> speech() {
    return speech;
  }

  /** Return true if this InitiateVerificationResource_calloutOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationCalloutOptionsImpl initiateVerificationResourceCalloutOptions =
        (StartVerificationCalloutOptionsImpl) o;
    return Objects.equals(this.speech, initiateVerificationResourceCalloutOptions.speech);
  }

  @Override
  public int hashCode() {
    return Objects.hash(speech);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationCalloutOptionsImpl {\n");
    sb.append("    speech: ").append(toIndentedString(speech)).append("\n");
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
  static class Builder implements StartVerificationCalloutOptions.Builder {
    OptionalValue<StartVerificationCalloutOptionsSpeech> speech = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SPEECH)
    public Builder setSpeech(StartVerificationCalloutOptionsSpeech speech) {
      this.speech = OptionalValue.of(speech);
      return this;
    }

    public StartVerificationCalloutOptions build() {
      return new StartVerificationCalloutOptionsImpl(speech);
    }
  }
}
