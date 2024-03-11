package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Objects;

@JsonPropertyOrder({
  ChannelCredentialCommonTypesImpl.JSON_PROPERTY_CALLBACK_SECRET,
  ChannelCredentialCommonTypesImpl.JSON_PROPERTY_CHANNEL,
  ChannelCredentialCommonTypesImpl.JSON_PROPERTY_STATE,
  ChannelCredentialCommonTypesImpl.JSON_PROPERTY_CHANNEL_KNOWN_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChannelCredentialCommonTypesImpl implements ChannelCredentialCommonTypes {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CALLBACK_SECRET = "callback_secret";

  private OptionalValue<String> callbackSecret;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<ConversationChannel> channel;

  public static final String JSON_PROPERTY_STATE = "state";

  private OptionalValue<ChannelIntegrationState> state;

  public static final String JSON_PROPERTY_CHANNEL_KNOWN_ID = "channel_known_id";

  private OptionalValue<String> channelKnownId;

  public ChannelCredentialCommonTypesImpl() {}

  protected ChannelCredentialCommonTypesImpl(
      OptionalValue<String> callbackSecret,
      OptionalValue<ConversationChannel> channel,
      OptionalValue<ChannelIntegrationState> state,
      OptionalValue<String> channelKnownId) {
    this.callbackSecret = callbackSecret;
    this.channel = channel;
    this.state = state;
    this.channelKnownId = channelKnownId;
  }

  @JsonIgnore
  public String getCallbackSecret() {
    return callbackSecret.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_SECRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callbackSecret() {
    return callbackSecret;
  }

  @JsonIgnore
  public ConversationChannel getChannel() {
    return channel.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConversationChannel> channel() {
    return channel;
  }

  @JsonIgnore
  public ChannelIntegrationState getState() {
    return state.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChannelIntegrationState> state() {
    return state;
  }

  @JsonIgnore
  public String getChannelKnownId() {
    return channelKnownId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_KNOWN_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> channelKnownId() {
    return channelKnownId;
  }

  /** Return true if this ChannelCredentialCommonTypes object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelCredentialCommonTypesImpl channelCredentialCommonTypes =
        (ChannelCredentialCommonTypesImpl) o;
    return Objects.equals(this.callbackSecret, channelCredentialCommonTypes.callbackSecret)
        && Objects.equals(this.channel, channelCredentialCommonTypes.channel)
        && Objects.equals(this.state, channelCredentialCommonTypes.state)
        && Objects.equals(this.channelKnownId, channelCredentialCommonTypes.channelKnownId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callbackSecret, channel, state, channelKnownId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelCredentialCommonTypesImpl {\n");
    sb.append("    callbackSecret: ").append(toIndentedString(callbackSecret)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    channelKnownId: ").append(toIndentedString(channelKnownId)).append("\n");
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
  static class Builder implements ChannelCredentialCommonTypes.Builder {
    OptionalValue<String> callbackSecret = OptionalValue.empty();
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<ChannelIntegrationState> state = OptionalValue.empty();
    OptionalValue<String> channelKnownId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CALLBACK_SECRET)
    public Builder setCallbackSecret(String callbackSecret) {
      this.callbackSecret = OptionalValue.of(callbackSecret);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    public Builder setState(ChannelIntegrationState state) {
      this.state = OptionalValue.of(state);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_KNOWN_ID)
    public Builder setChannelKnownId(String channelKnownId) {
      this.channelKnownId = OptionalValue.of(channelKnownId);
      return this;
    }

    public ChannelCredentialCommonTypes build() {
      return new ChannelCredentialCommonTypesImpl(callbackSecret, channel, state, channelKnownId);
    }
  }
}
