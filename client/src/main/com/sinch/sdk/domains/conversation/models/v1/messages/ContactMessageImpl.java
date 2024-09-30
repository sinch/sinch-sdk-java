package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.core.models.OptionalValue;

public class ContactMessageImpl<T extends ContactMessageBody> implements ContactMessage<T> {

  private final OptionalValue<T> message;

  private final OptionalValue<ReplyTo> replyTo;

  public ContactMessageImpl(OptionalValue<T> message, OptionalValue<ReplyTo> replyTo) {
    this.message = message;
    this.replyTo = replyTo;
  }

  public T getBody() {
    return message.orElse(null);
  }

  public OptionalValue<T> body() {
    return message;
  }

  public ReplyTo getReplyTo() {
    return replyTo.orElse(null);
  }

  public OptionalValue<ReplyTo> replyTo() {
    return replyTo;
  }

  @Override
  public String toString() {
    return "ContactMessageImpl{" + "message=" + message + ", replyTo=" + replyTo + '}';
  }

  /** Dedicated Builder */
  static class Builder<T extends ContactMessageBody> implements ContactMessage.Builder<T> {

    OptionalValue<T> message = OptionalValue.empty();
    OptionalValue<ReplyTo> replyTo = OptionalValue.empty();

    public Builder<T> setBody(T message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    public Builder<T> setReplyTo(ReplyTo replyTo) {
      this.replyTo = OptionalValue.of(replyTo);
      return this;
    }

    public ContactMessage<T> build() {
      return new ContactMessageImpl<>(message, replyTo);
    }
  }
}
