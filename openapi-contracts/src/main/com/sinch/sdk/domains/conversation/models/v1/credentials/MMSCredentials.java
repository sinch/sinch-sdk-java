/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * If you are including the MMS channel in the <code>channel_identifier</code> property, you must
 * include this object.
 */
@JsonDeserialize(builder = MMSCredentialsImpl.Builder.class)
public interface MMSCredentials extends ChannelCredentials {

  /**
   * MMS Account ID.
   *
   * @return accountId
   */
  String getAccountId();

  /**
   * MMS API Key.
   *
   * @return apiKey
   */
  String getApiKey();

  /**
   * Get basicAuth
   *
   * @return basicAuth
   */
  BasicAuthCredentials getBasicAuth();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MMSCredentialsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param accountId see getter
     * @return Current builder
     * @see #getAccountId
     */
    Builder setAccountId(String accountId);

    /**
     * see getter
     *
     * @param apiKey see getter
     * @return Current builder
     * @see #getApiKey
     */
    Builder setApiKey(String apiKey);

    /**
     * see getter
     *
     * @param basicAuth see getter
     * @return Current builder
     * @see #getBasicAuth
     */
    Builder setBasicAuth(BasicAuthCredentials basicAuth);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MMSCredentials build();
  }
}
