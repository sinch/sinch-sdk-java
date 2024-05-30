package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import java.util.Objects;

@JsonPropertyOrder({
  PhoneCallRequestEventResponsePhoneCallContentImpl.JSON_PROPERTY_CODE,
  PhoneCallRequestEventResponsePhoneCallContentImpl.JSON_PROPERTY_SPEECH
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PhoneCallRequestEventResponsePhoneCallContentImpl
    implements PhoneCallRequestEventResponsePhoneCallContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<String> code;

  public static final String JSON_PROPERTY_SPEECH = "speech";

  private OptionalValue<PhoneCallSpeech> speech;

  public PhoneCallRequestEventResponsePhoneCallContentImpl() {}

  protected PhoneCallRequestEventResponsePhoneCallContentImpl(
      OptionalValue<String> code, OptionalValue<PhoneCallSpeech> speech) {
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
  public PhoneCallSpeech getSpeech() {
    return speech.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SPEECH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<PhoneCallSpeech> speech() {
    return speech;
  }

  /** Return true if this PhoneCallRequestEventResponse_callout object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneCallRequestEventResponsePhoneCallContentImpl phoneCallRequestEventResponseCallout =
        (PhoneCallRequestEventResponsePhoneCallContentImpl) o;
    return Objects.equals(this.code, phoneCallRequestEventResponseCallout.code)
        && Objects.equals(this.speech, phoneCallRequestEventResponseCallout.speech);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, speech);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneCallRequestEventResponsePhoneCallContentImpl {\n");
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
  static class Builder implements PhoneCallRequestEventResponsePhoneCallContent.Builder {
    OptionalValue<String> code = OptionalValue.empty();
    OptionalValue<PhoneCallSpeech> speech = OptionalValue.empty();

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

    public PhoneCallRequestEventResponsePhoneCallContent build() {
      return new PhoneCallRequestEventResponsePhoneCallContentImpl(code, speech);
    }
  }
}
