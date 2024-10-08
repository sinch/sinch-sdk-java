/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.events.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.Agent;

/** Agent Left Event Type */
@JsonDeserialize(builder = AgentLeftEventImpl.Builder.class)
public interface AgentLeftEvent
    extends com.sinch.sdk.domains.conversation.models.v1.events.AppEvent {

  /**
   * Get agent
   *
   * @return agent
   */
  Agent getAgent();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AgentLeftEventImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param agent see getter
     * @return Current builder
     * @see #getAgent
     */
    Builder setAgent(Agent agent);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AgentLeftEvent build();
  }
}
