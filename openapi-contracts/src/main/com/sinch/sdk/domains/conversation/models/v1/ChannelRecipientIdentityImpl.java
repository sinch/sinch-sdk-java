package com.sinch.sdk.domains.conversation.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ChannelRecipientIdentityImpl.JSON_PROPERTY_CHANNEL,
  ChannelRecipientIdentityImpl.JSON_PROPERTY_IDENTITY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChannelRecipientIdentityImpl implements ChannelRecipientIdentity {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<ConversationChannel> channel;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<String> identity;

  public ChannelRecipientIdentityImpl() {}

  protected ChannelRecipientIdentityImpl(
      OptionalValue<ConversationChannel> channel, OptionalValue<String> identity) {
    this.channel = channel;
    this.identity = identity;
  }

  @JsonIgnore
  public ConversationChannel getChannel() {
    return channel.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ConversationChannel> channel() {
    return channel;
  }

  @JsonIgnore
  public String getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> identity() {
    return identity;
  }

  /** Return true if this ChannelRecipientIdentity object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelRecipientIdentityImpl channelRecipientIdentity = (ChannelRecipientIdentityImpl) o;
    return Objects.equals(this.channel, channelRecipientIdentity.channel)
        && Objects.equals(this.identity, channelRecipientIdentity.identity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channel, identity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelRecipientIdentityImpl {\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
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
  static class Builder implements ChannelRecipientIdentity.Builder {
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<String> identity = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CHANNEL, required = true)
    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_IDENTITY, required = true)
    public Builder setIdentity(String identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    public ChannelRecipientIdentity build() {
      return new ChannelRecipientIdentityImpl(channel, identity);
    }
  }
}
