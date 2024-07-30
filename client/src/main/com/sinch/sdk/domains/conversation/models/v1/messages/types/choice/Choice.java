package com.sinch.sdk.domains.conversation.models.v1.messages.types.choice;

public interface Choice<T> {

  T getMessage();

  /**
   * An optional field. This data will be returned in the ChoiceResponseMessage. The default is
   * message_id_{text, title}.
   *
   * @return postbackData
   */
  Object getPostbackData();

  /** Dedicated Builder */
  interface Builder<T> {

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
