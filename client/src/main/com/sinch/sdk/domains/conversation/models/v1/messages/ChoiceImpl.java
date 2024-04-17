package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.core.models.OptionalValue;

public class ChoiceImpl<T> implements Choice<T> {

  private final OptionalValue<T> message;

  private final OptionalValue<Object> postbackData;

  public ChoiceImpl(OptionalValue<T> message, OptionalValue<Object> postbackData) {
    this.message = message;
    this.postbackData = postbackData;
  }

  public T getMessage() {
    return message.orElse(null);
  }

  public OptionalValue<T> message() {
    return message;
  }

  public Object getPostbackData() {
    return postbackData.orElse(null);
  }

  public OptionalValue<Object> postbackData() {
    return postbackData;
  }

  @Override
  public String toString() {
    return "ChoiceImpl{" + "message=" + message + ", postbackData=" + postbackData + '}';
  }

  /** Dedicated Builder */
  static class Builder<T> implements Choice.Builder<T> {

    OptionalValue<T> message = OptionalValue.empty();

    OptionalValue<Object> postbackData = OptionalValue.empty();

    public Builder<T> setMessage(T message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    public Builder<T> setPostbackData(Object postbackData) {
      this.postbackData = OptionalValue.of(postbackData);
      return this;
    }

    public ChoiceImpl<T> build() {
      return new ChoiceImpl<>(message, postbackData);
    }
  }
}
