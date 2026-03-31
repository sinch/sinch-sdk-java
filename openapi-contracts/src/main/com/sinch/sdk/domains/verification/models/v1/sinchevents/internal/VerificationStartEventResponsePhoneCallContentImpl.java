package com.sinch.sdk.domains.verification.models.v1.sinchevents.internal;

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

@JsonPropertyOrder({
  VerificationStartEventResponsePhoneCallContentImpl.JSON_PROPERTY_CODE,
  VerificationStartEventResponsePhoneCallContentImpl.JSON_PROPERTY_SPEECH
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartEventResponsePhoneCallContentImpl
    implements VerificationStartEventResponsePhoneCallContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<String> code;

  public static final String JSON_PROPERTY_SPEECH = "speech";

  private OptionalValue<PhoneCallSpeech> speech;

  /**
   * A container for additional, undeclared properties. This is a holder for any undeclared
   * properties as specified with the 'additionalProperties' keyword in the OAS document.
   */
  private OptionalValue<Map<String, Object>> additionalProperties;

  public VerificationStartEventResponsePhoneCallContentImpl() {}

  protected VerificationStartEventResponsePhoneCallContentImpl(
      OptionalValue<String> code,
      OptionalValue<PhoneCallSpeech> speech,
      OptionalValue<Map<String, Object>> additionalProperties) {
    this.code = code;
    this.speech = speech;
    this.additionalProperties = additionalProperties;
  }

  @JsonIgnore
  public String getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> code() {
    return code;
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
   * Return true if this VerificationRequestEventResponsePhoneCall_allOf_callout object is equal to
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
    VerificationStartEventResponsePhoneCallContentImpl
        verificationRequestEventResponsePhoneCallAllOfCallout =
            (VerificationStartEventResponsePhoneCallContentImpl) o;
    return Objects.equals(this.code, verificationRequestEventResponsePhoneCallAllOfCallout.code)
        && Objects.equals(this.speech, verificationRequestEventResponsePhoneCallAllOfCallout.speech)
        && Objects.equals(
            this.additionalProperties,
            verificationRequestEventResponsePhoneCallAllOfCallout.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, speech, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartEventResponsePhoneCallContentImpl {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
  static class Builder implements VerificationStartEventResponsePhoneCallContent.Builder {
    OptionalValue<String> code = OptionalValue.empty();
    OptionalValue<PhoneCallSpeech> speech = OptionalValue.empty();
    OptionalValue<Map<String, Object>> additionalProperties = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CODE)
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

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

    public VerificationStartEventResponsePhoneCallContent build() {
      return new VerificationStartEventResponsePhoneCallContentImpl(
          code, speech, additionalProperties);
    }
  }
}
