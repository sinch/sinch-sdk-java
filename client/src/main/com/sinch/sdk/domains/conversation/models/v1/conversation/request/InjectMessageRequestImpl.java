package com.sinch.sdk.domains.conversation.models.v1.conversation.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectMessageRequestBaseImpl.Builder;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessageBody;
import java.time.Instant;

public class InjectMessageRequestImpl extends InjectMessageRequestBaseImpl
    implements InjectMessageRequest {

  @JsonIgnore
  public ConversationMessageBody getBody() {
    return appMessage()
        .map(f -> (ConversationMessageBody) f)
        .orElseGet(() -> contactMessage().orElse(null));
  }

  protected InjectMessageRequestImpl(
      OptionalValue<AppMessage<?>> appMessage,
      OptionalValue<ContactMessage<?>> contactMessage,
      OptionalValue<Instant> acceptTime,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<String> contactId,
      OptionalValue<ConversationDirection> direction,
      OptionalValue<String> conversationId,
      OptionalValue<String> senderId,
      OptionalValue<ProcessingMode> processingMode,
      OptionalValue<String> metadata) {
    super(
        appMessage,
        contactMessage,
        acceptTime,
        channelIdentity,
        contactId,
        direction,
        conversationId,
        senderId,
        processingMode,
        metadata);
  }

  static class Builder<B extends Builder<B>> extends InjectMessageRequestBaseImpl.Builder<B>
      implements InjectMessageRequest.Builder<B> {

    public B setBody(ConversationMessageBody body) {
      if (body instanceof AppMessage) {
        this.appMessage = OptionalValue.of((AppMessage<?>) body);
      } else if (body instanceof ContactMessage) {
        this.contactMessage = OptionalValue.of((ContactMessage<?>) body);
      } else {
        throw new IllegalStateException("Unexpected value: " + body);
      }
      return self();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    public InjectMessageRequest build() {
      return new InjectMessageRequestImpl(
          appMessage,
          contactMessage,
          acceptTime,
          channelIdentity,
          contactId,
          direction,
          conversationId,
          senderId,
          processingMode,
          metadata);
    }
  }
}
