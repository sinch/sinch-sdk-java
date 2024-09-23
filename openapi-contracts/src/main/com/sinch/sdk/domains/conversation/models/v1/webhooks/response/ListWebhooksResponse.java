/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import java.util.List;

/** ListWebhooksResponse */
@JsonDeserialize(builder = ListWebhooksResponseImpl.Builder.class)
public interface ListWebhooksResponse {

  /**
   * List of webhooks belonging to a specific project ID and app ID
   *
   * @return webhooks
   */
  List<Webhook> getWebhooks();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ListWebhooksResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param webhooks see getter
     * @return Current builder
     * @see #getWebhooks
     */
    Builder setWebhooks(List<Webhook> webhooks);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ListWebhooksResponse build();
  }
}