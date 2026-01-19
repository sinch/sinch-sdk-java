package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class MessagesDeleteQueryParametersImpl implements MessagesDeleteQueryParameters {

  private final OptionalValue<MessagesSource> messagesSource;

  private MessagesDeleteQueryParametersImpl(OptionalValue<MessagesSource> messagesSource) {
    this.messagesSource = messagesSource;
  }

  public OptionalValue<MessagesSource> getMessagesSource() {
    return messagesSource;
  }

  /** Return true if this MessagesDeleteMessageQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessagesDeleteQueryParametersImpl messagesDeleteMessageQueryParameters =
        (MessagesDeleteQueryParametersImpl) o;
    return Objects.equals(this.messagesSource, messagesDeleteMessageQueryParameters.messagesSource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messagesSource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessagesDeleteQueryParametersImpl {\n");
    sb.append("    messagesSource: ").append(toIndentedString(messagesSource)).append("\n");
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

  static class Builder implements MessagesDeleteQueryParameters.Builder {
    OptionalValue<MessagesSource> messagesSource = OptionalValue.empty();

    protected Builder() {}

    protected Builder(MessagesDeleteQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      MessagesDeleteQueryParametersImpl parameters =
          (MessagesDeleteQueryParametersImpl) _parameters;
      this.messagesSource = parameters.getMessagesSource();
    }

    public Builder setMessagesSource(MessagesSource messagesSource) {
      this.messagesSource = OptionalValue.of(messagesSource);
      return this;
    }

    public MessagesDeleteQueryParameters build() {
      return new MessagesDeleteQueryParametersImpl(messagesSource);
    }
  }
}
