package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import java.time.Instant;
import java.util.Objects;

public class ConversationMessageImpl implements ConversationMessage {

  private OptionalValue<ConversationMessageContent> content;

  private OptionalValue<Instant> acceptTime;

  private OptionalValue<ChannelIdentity> channelIdentity;

  private OptionalValue<String> contactId;

  private OptionalValue<String> conversationId;

  private OptionalValue<ConversationDirection> direction;

  private OptionalValue<String> id;

  private OptionalValue<String> metadata;

  private OptionalValue<Boolean> injected;

  private OptionalValue<String> senderId;

  private OptionalValue<ProcessingMode> processingMode;

  public ConversationMessageImpl() {}

  protected ConversationMessageImpl(
      OptionalValue<ConversationMessageContent> content,
      OptionalValue<Instant> acceptTime,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<String> contactId,
      OptionalValue<String> conversationId,
      OptionalValue<ConversationDirection> direction,
      OptionalValue<String> id,
      OptionalValue<String> metadata,
      OptionalValue<Boolean> injected,
      OptionalValue<String> senderId,
      OptionalValue<ProcessingMode> processingMode) {
    this.content = content;
    this.acceptTime = acceptTime;
    this.channelIdentity = channelIdentity;
    this.contactId = contactId;
    this.conversationId = conversationId;
    this.direction = direction;
    this.id = id;
    this.metadata = metadata;
    this.injected = injected;
    this.senderId = senderId;
    this.processingMode = processingMode;
  }

  public ConversationMessageContent getContent() {
    return content.orElse(null);
  }

  public OptionalValue<ConversationMessageContent> content() {
    return content;
  }

  public Instant getAcceptTime() {
    return acceptTime.orElse(null);
  }

  public OptionalValue<Instant> acceptTime() {
    return acceptTime;
  }

  public ChannelIdentity getChannelIdentity() {
    return channelIdentity.orElse(null);
  }

  public OptionalValue<ChannelIdentity> channelIdentity() {
    return channelIdentity;
  }

  public String getContactId() {
    return contactId.orElse(null);
  }

  public OptionalValue<String> contactId() {
    return contactId;
  }

  public String getConversationId() {
    return conversationId.orElse(null);
  }

  public OptionalValue<String> conversationId() {
    return conversationId;
  }

  public ConversationDirection getDirection() {
    return direction.orElse(null);
  }

  public OptionalValue<ConversationDirection> direction() {
    return direction;
  }

  public String getId() {
    return id.orElse(null);
  }

  public OptionalValue<String> id() {
    return id;
  }

  public String getMetadata() {
    return metadata.orElse(null);
  }

  public OptionalValue<String> metadata() {
    return metadata;
  }

  public Boolean getInjected() {
    return injected.orElse(null);
  }

  public OptionalValue<Boolean> injected() {
    return injected;
  }

  @JsonIgnore
  public String getSenderId() {
    return senderId.orElse(null);
  }

  public OptionalValue<String> senderId() {
    return senderId;
  }

  @JsonIgnore
  public ProcessingMode getProcessingMode() {
    return processingMode.orElse(null);
  }

  public OptionalValue<ProcessingMode> processingMode() {
    return processingMode;
  }

  /** Return true if this ConversationMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversationMessageImpl conversationMessage = (ConversationMessageImpl) o;
    return Objects.equals(this.content, conversationMessage.content)
        && Objects.equals(this.acceptTime, conversationMessage.acceptTime)
        && Objects.equals(this.channelIdentity, conversationMessage.channelIdentity)
        && Objects.equals(this.contactId, conversationMessage.contactId)
        && Objects.equals(this.conversationId, conversationMessage.conversationId)
        && Objects.equals(this.direction, conversationMessage.direction)
        && Objects.equals(this.id, conversationMessage.id)
        && Objects.equals(this.metadata, conversationMessage.metadata)
        && Objects.equals(this.injected, conversationMessage.injected)
        && Objects.equals(this.senderId, conversationMessage.senderId)
        && Objects.equals(this.processingMode, conversationMessage.processingMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        content,
        acceptTime,
        channelIdentity,
        contactId,
        conversationId,
        direction,
        id,
        metadata,
        injected,
        senderId,
        processingMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversationMessageImpl {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    acceptTime: ").append(toIndentedString(acceptTime)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    injected: ").append(toIndentedString(injected)).append("\n");
    sb.append("    senderId: ").append(toIndentedString(senderId)).append("\n");
    sb.append("    processingMode: ").append(toIndentedString(processingMode)).append("\n");
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
  static class Builder implements ConversationMessage.Builder {
    OptionalValue<ConversationMessageContent> content = OptionalValue.empty();
    OptionalValue<Instant> acceptTime = OptionalValue.empty();
    OptionalValue<ChannelIdentity> channelIdentity = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<ConversationDirection> direction = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> metadata = OptionalValue.empty();
    OptionalValue<Boolean> injected = OptionalValue.empty();
    OptionalValue<String> senderId = OptionalValue.empty();
    OptionalValue<ProcessingMode> processingMode = OptionalValue.empty();

    public Builder setContent(ConversationMessageContent content) {
      this.content = OptionalValue.of(content);
      return this;
    }

    public Builder setAcceptTime(Instant acceptTime) {
      this.acceptTime = OptionalValue.of(acceptTime);
      return this;
    }

    public Builder setChannelIdentity(ChannelIdentity channelIdentity) {
      this.channelIdentity = OptionalValue.of(channelIdentity);
      return this;
    }

    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    public Builder setConversationId(String conversationId) {
      this.conversationId = OptionalValue.of(conversationId);
      return this;
    }

    public Builder setDirection(ConversationDirection direction) {
      this.direction = OptionalValue.of(direction);
      return this;
    }

    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    public Builder setMetadata(String metadata) {
      this.metadata = OptionalValue.of(metadata);
      return this;
    }

    public Builder setInjected(Boolean injected) {
      this.injected = OptionalValue.of(injected);
      return this;
    }

    public Builder setSenderId(String senderId) {
      this.senderId = OptionalValue.of(senderId);
      return this;
    }

    public Builder setProcessingMode(ProcessingMode processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    public ConversationMessage build() {
      return new ConversationMessageImpl(
          content,
          acceptTime,
          channelIdentity,
          contactId,
          conversationId,
          direction,
          id,
          metadata,
          injected,
          senderId,
          processingMode);
    }
  }
}
