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
 * If you are including the KakaoTalk channel in the <code>channel_identifier</code> property, you
 * must include this object.
 */
@JsonDeserialize(builder = KakaoTalkCredentialsImpl.Builder.class)
public interface KakaoTalkCredentials extends ChannelCredentials {

  /**
   * KakaoTalk Business Channel ID.
   *
   * @return kakaotalkPlusFriendId
   */
  String getKakaotalkPlusFriendId();

  /**
   * KakaoTalk Sender Key.
   *
   * @return kakaotalkSenderKey
   */
  String getKakaotalkSenderKey();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new KakaoTalkCredentialsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param kakaotalkPlusFriendId see getter
     * @return Current builder
     * @see #getKakaotalkPlusFriendId
     */
    Builder setKakaotalkPlusFriendId(String kakaotalkPlusFriendId);

    /**
     * see getter
     *
     * @param kakaotalkSenderKey see getter
     * @return Current builder
     * @see #getKakaotalkSenderKey
     */
    Builder setKakaotalkSenderKey(String kakaotalkSenderKey);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    KakaoTalkCredentials build();
  }
}
