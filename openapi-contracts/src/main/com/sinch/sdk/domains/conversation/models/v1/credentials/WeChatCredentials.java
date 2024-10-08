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
 * If you are including the WeChat channel in the <code>channel_identifier</code> property, you must
 * include this object.
 */
@JsonDeserialize(builder = WeChatCredentialsImpl.Builder.class)
public interface WeChatCredentials extends ChannelCredentials {

  /**
   * The AppID(Developer ID) for the WeChat channel to which you are connecting.
   *
   * @return appId
   */
  String getAppId();

  /**
   * The AppSecret(Developer Password) for the WeChat channel to which you are connecting.
   *
   * @return appSecret
   */
  String getAppSecret();

  /**
   * The Token for the WeChat channel to which you are connecting.
   *
   * @return token
   */
  String getToken();

  /**
   * The Encoding AES Key for the WeChat channel to which you are connecting.
   *
   * @return aesKey
   */
  String getAesKey();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new WeChatCredentialsImpl.Builder();
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
     * @param appSecret see getter
     * @return Current builder
     * @see #getAppSecret
     */
    Builder setAppSecret(String appSecret);

    /**
     * see getter
     *
     * @param token see getter
     * @return Current builder
     * @see #getToken
     */
    Builder setToken(String token);

    /**
     * see getter
     *
     * @param aesKey see getter
     * @return Current builder
     * @see #getAesKey
     */
    Builder setAesKey(String aesKey);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    WeChatCredentials build();
  }
}
