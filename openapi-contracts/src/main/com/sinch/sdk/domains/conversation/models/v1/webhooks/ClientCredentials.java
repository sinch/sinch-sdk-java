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

/** Optional. Used for OAuth2 authentication. */
@JsonDeserialize(builder = ClientCredentialsImpl.Builder.class)
public interface ClientCredentials {

  /**
   * The Client ID that will be used in the OAuth2 Client Credentials flow.
   *
   * @return clientId
   */
  String getClientId();

  /**
   * The Client Secret that will be used in the OAuth2 Client Credentials flow.
   *
   * @return clientSecret
   */
  String getClientSecret();

  /**
   * The endpoint that will be used in the OAuth2 Client Credentials flow. Expected to return a JSON
   * with an access token and <code>expires_in</code> value (in seconds). The <code>expires_in
   * </code> value, which must be a minimum of 30 seconds and a maximum of 3600 seconds, is how long
   * Sinch will save the access token before asking for a new one.
   *
   * @return endpoint
   */
  String getEndpoint();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ClientCredentialsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param clientId see getter
     * @return Current builder
     * @see #getClientId
     */
    Builder setClientId(String clientId);

    /**
     * see getter
     *
     * @param clientSecret see getter
     * @return Current builder
     * @see #getClientSecret
     */
    Builder setClientSecret(String clientSecret);

    /**
     * see getter
     *
     * @param endpoint see getter
     * @return Current builder
     * @see #getEndpoint
     */
    Builder setEndpoint(String endpoint);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ClientCredentials build();
  }
}