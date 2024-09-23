/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.events.types.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.Agent;

/** Agent Joined Event */
@JsonDeserialize(builder = AgentJoinedEventInternalImpl.Builder.class)
public interface AgentJoinedEventInternal {

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
    return new AgentJoinedEventInternalImpl.Builder();
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
    AgentJoinedEventInternal build();
  }
}