/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.app;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** This object contains additional settings related to callback processing. */
@JsonDeserialize(builder = CallbackSettingsImpl.Builder.class)
public interface CallbackSettings {

  /**
   * Optional. Secret can be used to sign contents of delivery receipts for a message that was sent
   * with the default <code>callback_url</code> overridden. You can then use the secret to verify
   * the signature.
   *
   * @return secretForOverriddenCallbackUrls
   */
  String getSecretForOverriddenCallbackUrls();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CallbackSettingsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param secretForOverriddenCallbackUrls see getter
     * @return Current builder
     * @see #getSecretForOverriddenCallbackUrls
     */
    Builder setSecretForOverriddenCallbackUrls(String secretForOverriddenCallbackUrls);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CallbackSettings build();
  }
}
