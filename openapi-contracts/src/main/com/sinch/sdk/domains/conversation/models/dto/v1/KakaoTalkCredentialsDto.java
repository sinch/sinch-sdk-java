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

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * If you are including the KakaoTalk channel in the &#x60;channel_identifier&#x60; property, you
 * must include this object.
 */
@JsonPropertyOrder({
  KakaoTalkCredentialsDto.JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID,
  KakaoTalkCredentialsDto.JSON_PROPERTY_KAKAOTALK_SENDER_KEY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class KakaoTalkCredentialsDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID = "kakaotalk_plus_friend_id";
  private String kakaotalkPlusFriendId;
  private boolean kakaotalkPlusFriendIdDefined = false;

  public static final String JSON_PROPERTY_KAKAOTALK_SENDER_KEY = "kakaotalk_sender_key";
  private String kakaotalkSenderKey;
  private boolean kakaotalkSenderKeyDefined = false;

  public KakaoTalkCredentialsDto() {}

  public KakaoTalkCredentialsDto kakaotalkPlusFriendId(String kakaotalkPlusFriendId) {
    this.kakaotalkPlusFriendId = kakaotalkPlusFriendId;
    this.kakaotalkPlusFriendIdDefined = true;
    return this;
  }

  /**
   * KakaoTalk Business Channel ID.
   *
   * @return kakaotalkPlusFriendId
   */
  @JsonProperty(JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getKakaotalkPlusFriendId() {
    return kakaotalkPlusFriendId;
  }

  @JsonIgnore
  public boolean getKakaotalkPlusFriendIdDefined() {
    return kakaotalkPlusFriendIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKakaotalkPlusFriendId(String kakaotalkPlusFriendId) {
    this.kakaotalkPlusFriendId = kakaotalkPlusFriendId;
    this.kakaotalkPlusFriendIdDefined = true;
  }

  public KakaoTalkCredentialsDto kakaotalkSenderKey(String kakaotalkSenderKey) {
    this.kakaotalkSenderKey = kakaotalkSenderKey;
    this.kakaotalkSenderKeyDefined = true;
    return this;
  }

  /**
   * KakaoTalk Sender Key.
   *
   * @return kakaotalkSenderKey
   */
  @JsonProperty(JSON_PROPERTY_KAKAOTALK_SENDER_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getKakaotalkSenderKey() {
    return kakaotalkSenderKey;
  }

  @JsonIgnore
  public boolean getKakaotalkSenderKeyDefined() {
    return kakaotalkSenderKeyDefined;
  }

  @JsonProperty(JSON_PROPERTY_KAKAOTALK_SENDER_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKakaotalkSenderKey(String kakaotalkSenderKey) {
    this.kakaotalkSenderKey = kakaotalkSenderKey;
    this.kakaotalkSenderKeyDefined = true;
  }

  /** Return true if this KakaoTalkCredentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KakaoTalkCredentialsDto kakaoTalkCredentials = (KakaoTalkCredentialsDto) o;
    return Objects.equals(this.kakaotalkPlusFriendId, kakaoTalkCredentials.kakaotalkPlusFriendId)
        && Objects.equals(this.kakaotalkSenderKey, kakaoTalkCredentials.kakaotalkSenderKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kakaotalkPlusFriendId, kakaotalkSenderKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KakaoTalkCredentialsDto {\n");
    sb.append("    kakaotalkPlusFriendId: ")
        .append(toIndentedString(kakaotalkPlusFriendId))
        .append("\n");
    sb.append("    kakaotalkSenderKey: ").append(toIndentedString(kakaotalkSenderKey)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}