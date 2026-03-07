package com.sinch.sdk.domains.numbers.models.v1.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration;
import java.util.Objects;

@JsonPropertyOrder({
  AvailableNumberRentRequestImpl.JSON_PROPERTY_SMS_CONFIGURATION,
  AvailableNumberRentRequestImpl.JSON_PROPERTY_VOICE_CONFIGURATION,
  AvailableNumberRentRequestImpl.JSON_PROPERTY_CALLBACK_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AvailableNumberRentRequestImpl implements AvailableNumberRentRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SMS_CONFIGURATION = "smsConfiguration";

  private OptionalValue<SmsConfiguration> smsConfiguration;

  public static final String JSON_PROPERTY_VOICE_CONFIGURATION = "voiceConfiguration";

  private OptionalValue<VoiceConfiguration> voiceConfiguration;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callbackUrl";

  private OptionalValue<String> eventDestinationTarget;

  public AvailableNumberRentRequestImpl() {}

  protected AvailableNumberRentRequestImpl(
      OptionalValue<SmsConfiguration> smsConfiguration,
      OptionalValue<VoiceConfiguration> voiceConfiguration,
      OptionalValue<String> eventDestinationTarget) {
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.eventDestinationTarget = eventDestinationTarget;
  }

  @JsonIgnore
  public SmsConfiguration getSmsConfiguration() {
    return smsConfiguration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SmsConfiguration> smsConfiguration() {
    return smsConfiguration;
  }

  @JsonIgnore
  public VoiceConfiguration getVoiceConfiguration() {
    return voiceConfiguration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VoiceConfiguration> voiceConfiguration() {
    return voiceConfiguration;
  }

  @JsonIgnore
  public String getEventDestinationTarget() {
    return eventDestinationTarget.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> eventDestinationTarget() {
    return eventDestinationTarget;
  }

  /** Return true if this RentNumberRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableNumberRentRequestImpl rentNumberRequest = (AvailableNumberRentRequestImpl) o;
    return Objects.equals(this.smsConfiguration, rentNumberRequest.smsConfiguration)
        && Objects.equals(this.voiceConfiguration, rentNumberRequest.voiceConfiguration)
        && Objects.equals(this.eventDestinationTarget, rentNumberRequest.eventDestinationTarget);
  }

  @Override
  public int hashCode() {
    return Objects.hash(smsConfiguration, voiceConfiguration, eventDestinationTarget);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableNumberRentRequestImpl {\n");
    sb.append("    smsConfiguration: ").append(toIndentedString(smsConfiguration)).append("\n");
    sb.append("    voiceConfiguration: ").append(toIndentedString(voiceConfiguration)).append("\n");
    sb.append("    eventDestinationTarget: ")
        .append(toIndentedString(eventDestinationTarget))
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
  static class Builder implements AvailableNumberRentRequest.Builder {
    OptionalValue<SmsConfiguration> smsConfiguration = OptionalValue.empty();
    OptionalValue<VoiceConfiguration> voiceConfiguration = OptionalValue.empty();
    OptionalValue<String> eventDestinationTarget = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
    public Builder setSmsConfiguration(SmsConfiguration smsConfiguration) {
      this.smsConfiguration = OptionalValue.of(smsConfiguration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
    public Builder setVoiceConfiguration(VoiceConfiguration voiceConfiguration) {
      this.voiceConfiguration = OptionalValue.of(voiceConfiguration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
    public Builder setEventDestinationTarget(String eventDestinationTarget) {
      this.eventDestinationTarget = OptionalValue.of(eventDestinationTarget);
      return this;
    }

    public AvailableNumberRentRequest build() {
      return new AvailableNumberRentRequestImpl(
          smsConfiguration, voiceConfiguration, eventDestinationTarget);
    }
  }
}
