package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  CalloutRequestEventResponseCalloutContentImpl.JSON_PROPERTY_CODE,
  CalloutRequestEventResponseCalloutContentImpl.JSON_PROPERTY_SPEECH
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CalloutRequestEventResponseCalloutContentImpl
    implements CalloutRequestEventResponseCalloutContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<String> code;

  public static final String JSON_PROPERTY_SPEECH = "speech";

  private OptionalValue<CalloutRequestEventResponseCalloutSpeechContent> speech;

  public CalloutRequestEventResponseCalloutContentImpl() {}

  protected CalloutRequestEventResponseCalloutContentImpl(
      OptionalValue<String> code,
      OptionalValue<CalloutRequestEventResponseCalloutSpeechContent> speech) {
    this.code = code;
    this.speech = speech;
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
  public CalloutRequestEventResponseCalloutSpeechContent getSpeech() {
    return speech.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SPEECH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CalloutRequestEventResponseCalloutSpeechContent> speech() {
    return speech;
  }

  /** Return true if this CalloutRequestEventResponse_callout object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalloutRequestEventResponseCalloutContentImpl calloutRequestEventResponseCallout =
        (CalloutRequestEventResponseCalloutContentImpl) o;
    return Objects.equals(this.code, calloutRequestEventResponseCallout.code)
        && Objects.equals(this.speech, calloutRequestEventResponseCallout.speech);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, speech);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalloutRequestEventResponseCalloutContentImpl {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
  static class Builder implements CalloutRequestEventResponseCalloutContent.Builder {
    OptionalValue<String> code = OptionalValue.empty();
    OptionalValue<CalloutRequestEventResponseCalloutSpeechContent> speech = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CODE)
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SPEECH)
    public Builder setSpeech(CalloutRequestEventResponseCalloutSpeechContent speech) {
      this.speech = OptionalValue.of(speech);
      return this;
    }

    public CalloutRequestEventResponseCalloutContent build() {
      return new CalloutRequestEventResponseCalloutContentImpl(code, speech);
    }
  }
}
