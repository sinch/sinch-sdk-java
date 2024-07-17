package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.unsupported;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import java.util.Objects;

@JsonPropertyOrder({
  UnsupportedCallbackEventCallbackImpl.JSON_PROPERTY_CHANNEL,
  UnsupportedCallbackEventCallbackImpl.JSON_PROPERTY_PAYLOAD,
  UnsupportedCallbackEventCallbackImpl.JSON_PROPERTY_PROCESSING_MODE,
  UnsupportedCallbackEventCallbackImpl.JSON_PROPERTY_ID,
  UnsupportedCallbackEventCallbackImpl.JSON_PROPERTY_CONTACT_ID,
  UnsupportedCallbackEventCallbackImpl.JSON_PROPERTY_CONVERSATION_ID,
  UnsupportedCallbackEventCallbackImpl.JSON_PROPERTY_CHANNEL_IDENTITY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UnsupportedCallbackEventCallbackImpl implements UnsupportedCallbackEventCallback {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<ConversationChannel> channel;

  public static final String JSON_PROPERTY_PAYLOAD = "payload";

  private OptionalValue<String> payload;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<ProcessingMode> processingMode;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_CONVERSATION_ID = "conversation_id";

  private OptionalValue<String> conversationId;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";

  private OptionalValue<ChannelIdentity> channelIdentity;

  public UnsupportedCallbackEventCallbackImpl() {}

  protected UnsupportedCallbackEventCallbackImpl(
      OptionalValue<ConversationChannel> channel,
      OptionalValue<String> payload,
      OptionalValue<ProcessingMode> processingMode,
      OptionalValue<String> id,
      OptionalValue<String> contactId,
      OptionalValue<String> conversationId,
      OptionalValue<ChannelIdentity> channelIdentity) {
    this.channel = channel;
    this.payload = payload;
    this.processingMode = processingMode;
    this.id = id;
    this.contactId = contactId;
    this.conversationId = conversationId;
    this.channelIdentity = channelIdentity;
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
  public String getPayload() {
    return payload.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAYLOAD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> payload() {
    return payload;
  }

  @JsonIgnore
  public ProcessingMode getProcessingMode() {
    return processingMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProcessingMode> processingMode() {
    return processingMode;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public String getContactId() {
    return contactId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> contactId() {
    return contactId;
  }

  @JsonIgnore
  public String getConversationId() {
    return conversationId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> conversationId() {
    return conversationId;
  }

  @JsonIgnore
  public ChannelIdentity getChannelIdentity() {
    return channelIdentity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChannelIdentity> channelIdentity() {
    return channelIdentity;
  }

  /**
   * Return true if this UnsupportedCallbackEvent_allOf_unsupported_callback object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnsupportedCallbackEventCallbackImpl unsupportedCallbackEventAllOfUnsupportedCallback =
        (UnsupportedCallbackEventCallbackImpl) o;
    return Objects.equals(this.channel, unsupportedCallbackEventAllOfUnsupportedCallback.channel)
        && Objects.equals(this.payload, unsupportedCallbackEventAllOfUnsupportedCallback.payload)
        && Objects.equals(
            this.processingMode, unsupportedCallbackEventAllOfUnsupportedCallback.processingMode)
        && Objects.equals(this.id, unsupportedCallbackEventAllOfUnsupportedCallback.id)
        && Objects.equals(
            this.contactId, unsupportedCallbackEventAllOfUnsupportedCallback.contactId)
        && Objects.equals(
            this.conversationId, unsupportedCallbackEventAllOfUnsupportedCallback.conversationId)
        && Objects.equals(
            this.channelIdentity, unsupportedCallbackEventAllOfUnsupportedCallback.channelIdentity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        channel, payload, processingMode, id, contactId, conversationId, channelIdentity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnsupportedCallbackEventCallbackImpl {\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("    processingMode: ").append(toIndentedString(processingMode)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
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
  static class Builder implements UnsupportedCallbackEventCallback.Builder {
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<String> payload = OptionalValue.empty();
    OptionalValue<ProcessingMode> processingMode = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<ChannelIdentity> channelIdentity = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAYLOAD)
    public Builder setPayload(String payload) {
      this.payload = OptionalValue.of(payload);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
    public Builder setProcessingMode(ProcessingMode processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_ID)
    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
    public Builder setConversationId(String conversationId) {
      this.conversationId = OptionalValue.of(conversationId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
    public Builder setChannelIdentity(ChannelIdentity channelIdentity) {
      this.channelIdentity = OptionalValue.of(channelIdentity);
      return this;
    }

    public UnsupportedCallbackEventCallback build() {
      return new UnsupportedCallbackEventCallbackImpl(
          channel, payload, processingMode, id, contactId, conversationId, channelIdentity);
    }
  }
}
