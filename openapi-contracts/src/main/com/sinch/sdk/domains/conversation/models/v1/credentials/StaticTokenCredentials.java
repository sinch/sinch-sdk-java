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

package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** This object is required for channels which use a static token credential for authentication. */
@JsonDeserialize(builder = StaticTokenCredentialsImpl.Builder.class)
public interface StaticTokenCredentials {

  /**
   * The static token for the channel.
   *
   * @return token
   */
  String getToken();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StaticTokenCredentialsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param token see getter
     * @return Current builder
     * @see #getToken
     */
    Builder setToken(String token);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StaticTokenCredentials build();
  }
}
