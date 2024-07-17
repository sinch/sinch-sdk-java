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
  ActiveNumberUpdateRequestImpl.JSON_PROPERTY_DISPLAY_NAME,
  ActiveNumberUpdateRequestImpl.JSON_PROPERTY_SMS_CONFIGURATION,
  ActiveNumberUpdateRequestImpl.JSON_PROPERTY_VOICE_CONFIGURATION,
  ActiveNumberUpdateRequestImpl.JSON_PROPERTY_CALLBACK_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ActiveNumberUpdateRequestImpl implements ActiveNumberUpdateRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";

  private OptionalValue<String> displayName;

  public static final String JSON_PROPERTY_SMS_CONFIGURATION = "smsConfiguration";

  private OptionalValue<SmsConfiguration> smsConfiguration;

  public static final String JSON_PROPERTY_VOICE_CONFIGURATION = "voiceConfiguration";

  private OptionalValue<VoiceConfiguration> voiceConfiguration;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callbackUrl";

  private OptionalValue<String> callbackUrl;

  public ActiveNumberUpdateRequestImpl() {}

  protected ActiveNumberUpdateRequestImpl(
      OptionalValue<String> displayName,
      OptionalValue<SmsConfiguration> smsConfiguration,
      OptionalValue<VoiceConfiguration> voiceConfiguration,
      OptionalValue<String> callbackUrl) {
    this.displayName = displayName;
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.callbackUrl = callbackUrl;
  }

  @JsonIgnore
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> displayName() {
    return displayName;
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
  public String getCallbackUrl() {
    return callbackUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callbackUrl() {
    return callbackUrl;
  }

  /** Return true if this ActiveNumberRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActiveNumberUpdateRequestImpl activeNumberRequest = (ActiveNumberUpdateRequestImpl) o;
    return Objects.equals(this.displayName, activeNumberRequest.displayName)
        && Objects.equals(this.smsConfiguration, activeNumberRequest.smsConfiguration)
        && Objects.equals(this.voiceConfiguration, activeNumberRequest.voiceConfiguration)
        && Objects.equals(this.callbackUrl, activeNumberRequest.callbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, smsConfiguration, voiceConfiguration, callbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActiveNumberUpdateRequestImpl {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    smsConfiguration: ").append(toIndentedString(smsConfiguration)).append("\n");
    sb.append("    voiceConfiguration: ").append(toIndentedString(voiceConfiguration)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
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
  static class Builder implements ActiveNumberUpdateRequest.Builder {
    OptionalValue<String> displayName = OptionalValue.empty();
    OptionalValue<SmsConfiguration> smsConfiguration = OptionalValue.empty();
    OptionalValue<VoiceConfiguration> voiceConfiguration = OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    public Builder setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
      return this;
    }

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
    public Builder setCallbackUrl(String callbackUrl) {
      this.callbackUrl = OptionalValue.of(callbackUrl);
      return this;
    }

    public ActiveNumberUpdateRequest build() {
      return new ActiveNumberUpdateRequestImpl(
          displayName, smsConfiguration, voiceConfiguration, callbackUrl);
    }
  }
}
