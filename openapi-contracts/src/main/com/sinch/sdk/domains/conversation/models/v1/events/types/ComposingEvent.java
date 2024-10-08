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
import java.util.Collections;

/** Composing */
@JsonDeserialize(builder = ComposingEventImpl.Builder.class)
public interface ComposingEvent
    extends com.sinch.sdk.domains.conversation.models.v1.events.AppEvent,
        com.sinch.sdk.domains.conversation.models.v1.events.ContactEvent {

  /** Default EMPTY message to be used to send a ComposingEvent */
  ComposingEvent EMPTY =
      new ComposingEventImpl.Builder().setComposingEvent(Collections.EMPTY_MAP).build();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ComposingEventImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ComposingEvent build();
  }
}
