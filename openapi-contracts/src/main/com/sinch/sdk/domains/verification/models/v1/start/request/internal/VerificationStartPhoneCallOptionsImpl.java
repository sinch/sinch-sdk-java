package com.sinch.sdk.domains.verification.models.v1.start.request.internal;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({VerificationStartPhoneCallOptionsImpl.JSON_PROPERTY_SPEECH})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartPhoneCallOptionsImpl implements VerificationStartPhoneCallOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SPEECH = "speech";

  private OptionalValue<PhoneCallSpeech> speech;

  /**
   * A container for additional, undeclared properties. This is a holder for any undeclared
   * properties as specified with the 'additionalProperties' keyword in the OAS document.
   */
  private OptionalValue<Map<String, Object>> additionalProperties;

  public VerificationStartPhoneCallOptionsImpl() {}

  protected VerificationStartPhoneCallOptionsImpl(
      OptionalValue<PhoneCallSpeech> speech,
      OptionalValue<Map<String, Object>> additionalProperties) {
    this.speech = speech;
    this.additionalProperties = additionalProperties;
  }

  @JsonIgnore
  public PhoneCallSpeech getSpeech() {
    return speech.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SPEECH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<PhoneCallSpeech> speech() {
    return speech;
  }

  @JsonIgnore
  public Object get(String key) {

    if (null == this.additionalProperties || !additionalProperties.isPresent()) {
      return null;
    }
    return this.additionalProperties.get().get(key);
  }

  @JsonAnyGetter
  public Map<String, Object> additionalProperties() {
    if (null == this.additionalProperties || !additionalProperties.isPresent()) {
      return null;
    }
    return additionalProperties.get();
  }

  /**
   * Return true if this VerificationStartRequestPhoneCall_allOf_calloutOptions object is equal to
   * o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartPhoneCallOptionsImpl verificationStartRequestPhoneCallAllOfCalloutOptions =
        (VerificationStartPhoneCallOptionsImpl) o;
    return Objects.equals(this.speech, verificationStartRequestPhoneCallAllOfCalloutOptions.speech)
        && Objects.equals(
            this.additionalProperties,
            verificationStartRequestPhoneCallAllOfCalloutOptions.additionalProperties)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(speech, super.hashCode(), additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartPhoneCallOptionsImpl {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    speech: ").append(toIndentedString(speech)).append("\n");
    sb.append("    additionalProperties: ")
        .append(toIndentedString(additionalProperties))
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
  static class Builder implements VerificationStartPhoneCallOptions.Builder {
    OptionalValue<PhoneCallSpeech> speech = OptionalValue.empty();
    OptionalValue<Map<String, Object>> additionalProperties = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SPEECH)
    public Builder setSpeech(PhoneCallSpeech speech) {
      this.speech = OptionalValue.of(speech);
      return this;
    }

    @JsonAnySetter
    public Builder put(String key, Object value) {
      if (!this.additionalProperties.isPresent()) {
        this.additionalProperties = OptionalValue.of(new HashMap<String, Object>());
      }
      this.additionalProperties.get().put(key, value);
      return this;
    }

    public VerificationStartPhoneCallOptions build() {
      return new VerificationStartPhoneCallOptionsImpl(speech, additionalProperties);
    }
  }
}
