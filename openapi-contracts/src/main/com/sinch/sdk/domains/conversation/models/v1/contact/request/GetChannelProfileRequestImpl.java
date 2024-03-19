package com.sinch.sdk.domains.conversation.models.v1.contact.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  GetChannelProfileRequestImpl.JSON_PROPERTY_APP_ID,
  GetChannelProfileRequestImpl.JSON_PROPERTY_RECIPIENT,
  GetChannelProfileRequestImpl.JSON_PROPERTY_CHANNEL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GetChannelProfileRequestImpl implements GetChannelProfileRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_ID = "app_id";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_RECIPIENT = "recipient";

  private OptionalValue<GetChannelProfileRequestRecipient> recipient;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<GetChannelProfileConversationChannel> channel;

  public GetChannelProfileRequestImpl() {}

  protected GetChannelProfileRequestImpl(
      OptionalValue<String> appId,
      OptionalValue<GetChannelProfileRequestRecipient> recipient,
      OptionalValue<GetChannelProfileConversationChannel> channel) {
    this.appId = appId;
    this.recipient = recipient;
    this.channel = channel;
  }

  @JsonIgnore
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> appId() {
    return appId;
  }

  @JsonIgnore
  public GetChannelProfileRequestRecipient getRecipient() {
    return recipient.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<GetChannelProfileRequestRecipient> recipient() {
    return recipient;
  }

  @JsonIgnore
  public GetChannelProfileConversationChannel getChannel() {
    return channel.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<GetChannelProfileConversationChannel> channel() {
    return channel;
  }

  /** Return true if this GetChannelProfileRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetChannelProfileRequestImpl getChannelProfileRequest = (GetChannelProfileRequestImpl) o;
    return Objects.equals(this.appId, getChannelProfileRequest.appId)
        && Objects.equals(this.recipient, getChannelProfileRequest.recipient)
        && Objects.equals(this.channel, getChannelProfileRequest.channel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, recipient, channel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetChannelProfileRequestImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
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
  static class Builder implements GetChannelProfileRequest.Builder {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<GetChannelProfileRequestRecipient> recipient = OptionalValue.empty();
    OptionalValue<GetChannelProfileConversationChannel> channel = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RECIPIENT)
    public Builder setRecipient(GetChannelProfileRequestRecipient recipient) {
      this.recipient = OptionalValue.of(recipient);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    public Builder setChannel(GetChannelProfileConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    public GetChannelProfileRequest build() {
      return new GetChannelProfileRequestImpl(appId, recipient, channel);
    }
  }
}
