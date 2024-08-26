/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** FlowChannelSpecificMessageFlowActionPayload */
@JsonDeserialize(builder = FlowChannelSpecificMessageFlowActionPayloadImpl.Builder.class)
public interface FlowChannelSpecificMessageFlowActionPayload {

  /**
   * The ID of the screen displayed first. This must be an entry screen.
   *
   * @return screen
   */
  String getScreen();

  /**
   * Data for the first screen.
   *
   * @return data
   */
  Object getData();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new FlowChannelSpecificMessageFlowActionPayloadImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param screen see getter
     * @return Current builder
     * @see #getScreen
     */
    Builder setScreen(String screen);

    /**
     * see getter
     *
     * @param data see getter
     * @return Current builder
     * @see #getData
     */
    Builder setData(Object data);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    FlowChannelSpecificMessageFlowActionPayload build();
  }
}
