package com.sinch.sdk.domains.conversation.models.v1.messages.types.choice;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest.Builder;

/**
 * Base class for message containing choices/actions.
 *
 * @param <T> Message body content type
 */
@JsonDeserialize(using = ChoiceImpl.ChoiceDeserializer.class)
public interface Choice<T extends ChoiceMessageType> {

  T getMessage();

  /**
   * An optional field. This data will be returned in the ChoiceResponseMessage. The default is
   * message_id_{text, title}.
   *
   * @return postbackData
   */
  Object getPostbackData();

  static <T extends ChoiceMessageType> Builder<T> builder() {
    return new ChoiceImpl.Builder<>();
  }

  /** Dedicated Builder */
  interface Builder<T extends ChoiceMessageType> {

    Builder<T> setMessage(T message);

    /**
     * see getter
     *
     * @param postbackData see getter
     * @return Current builder
     * @see #getPostbackData
     */
    Builder<T> setPostbackData(Object postbackData);

    Choice<T> build();
  }
}
