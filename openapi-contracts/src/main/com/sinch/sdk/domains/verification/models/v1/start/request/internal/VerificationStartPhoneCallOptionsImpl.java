package com.sinch.sdk.domains.verification.models.v1.start.request.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import java.util.Objects;

@JsonPropertyOrder({VerificationStartPhoneCallOptionsImpl.JSON_PROPERTY_SPEECH})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartPhoneCallOptionsImpl implements VerificationStartPhoneCallOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SPEECH = "speech";

  private OptionalValue<PhoneCallSpeech> speech;

  public VerificationStartPhoneCallOptionsImpl() {}

  protected VerificationStartPhoneCallOptionsImpl(OptionalValue<PhoneCallSpeech> speech) {
    this.speech = speech;
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
    return Objects.equals(this.speech, verificationStartRequestPhoneCallAllOfCalloutOptions.speech);
  }

  @Override
  public int hashCode() {
    return Objects.hash(speech);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartPhoneCallOptionsImpl {\n");
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
  static class Builder implements VerificationStartPhoneCallOptions.Builder {
    OptionalValue<PhoneCallSpeech> speech = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SPEECH)
    public Builder setSpeech(PhoneCallSpeech speech) {
      this.speech = OptionalValue.of(speech);
      return this;
    }

    public VerificationStartPhoneCallOptions build() {
      return new VerificationStartPhoneCallOptionsImpl(speech);
    }
  }
}
