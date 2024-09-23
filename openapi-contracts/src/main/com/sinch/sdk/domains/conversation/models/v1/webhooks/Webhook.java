/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/** Represents a destination for receiving callbacks from the Conversation API. */
@JsonDeserialize(builder = WebhookImpl.Builder.class)
public interface Webhook {

  /**
   * The app that this webhook belongs to.
   *
   * @return appId
   */
  String getAppId();

  /**
   * Get clientCredentials
   *
   * @return clientCredentials
   */
  ClientCredentials getClientCredentials();

  /**
   * The ID of the webhook.
   *
   * @return id
   */
  String getId();

  /**
   * Optional secret be used to sign contents of webhooks sent by the Conversation API. You can then
   * use the secret to verify the signature.
   *
   * @return secret
   */
  String getSecret();

  /**
   * The target url where events should be sent to. Maximum URL length is 742. The
   * conversation-api.*.sinch.com subdomains are forbidden.
   *
   * @return target
   */
  String getTarget();

  /**
   * Get targetType
   *
   * @return targetType
   */
  WebhookTargetType getTargetType();

  /**
   * An array of triggers that should trigger the webhook and result in an event being sent to the
   * target url. Refer to the list of <a
   * href="/docs/conversation/callbacks#webhook-triggers">Webhook Triggers</a> for a complete list.
   *
   * @return triggers
   */
  List<WebhookTrigger> getTriggers();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new WebhookImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param appId see getter
     * @return Current builder
     * @see #getAppId
     */
    Builder setAppId(String appId);

    /**
     * see getter
     *
     * @param clientCredentials see getter
     * @return Current builder
     * @see #getClientCredentials
     */
    Builder setClientCredentials(ClientCredentials clientCredentials);

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see #getId
     */
    Builder setId(String id);

    /**
     * see getter
     *
     * @param secret see getter
     * @return Current builder
     * @see #getSecret
     */
    Builder setSecret(String secret);

    /**
     * see getter
     *
     * @param target see getter
     * @return Current builder
     * @see #getTarget
     */
    Builder setTarget(String target);

    /**
     * see getter
     *
     * @param targetType see getter
     * @return Current builder
     * @see #getTargetType
     */
    Builder setTargetType(WebhookTargetType targetType);

    /**
     * see getter
     *
     * @param triggers see getter
     * @return Current builder
     * @see #getTriggers
     */
    Builder setTriggers(List<WebhookTrigger> triggers);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Webhook build();
  }
}