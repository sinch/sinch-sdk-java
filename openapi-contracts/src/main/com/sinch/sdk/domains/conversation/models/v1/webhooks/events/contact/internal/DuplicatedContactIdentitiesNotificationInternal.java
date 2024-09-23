/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.DuplicatedIdentities;
import java.util.List;

/** DuplicatedContactIdentitiesNotificationInternal */
@JsonDeserialize(builder = DuplicatedContactIdentitiesNotificationInternalImpl.Builder.class)
public interface DuplicatedContactIdentitiesNotificationInternal {

  /**
   * Get duplicatedIdentities
   *
   * @return duplicatedIdentities
   */
  List<DuplicatedIdentities> getDuplicatedIdentities();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new DuplicatedContactIdentitiesNotificationInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param duplicatedIdentities see getter
     * @return Current builder
     * @see #getDuplicatedIdentities
     */
    Builder setDuplicatedIdentities(List<DuplicatedIdentities> duplicatedIdentities);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    DuplicatedContactIdentitiesNotificationInternal build();
  }
}