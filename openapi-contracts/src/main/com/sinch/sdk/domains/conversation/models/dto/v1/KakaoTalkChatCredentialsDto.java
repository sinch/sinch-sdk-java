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
 * If you are including the KakaoTalkChat channel in the &#x60;channel_identifier&#x60; property,
 * you must include this object.
 */
@JsonPropertyOrder({
  KakaoTalkChatCredentialsDto.JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID,
  KakaoTalkChatCredentialsDto.JSON_PROPERTY_API_KEY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class KakaoTalkChatCredentialsDto {
  public static final String JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID = "kakaotalk_plus_friend_id";
  private String kakaotalkPlusFriendId;
  private boolean kakaotalkPlusFriendIdDefined = false;

  public static final String JSON_PROPERTY_API_KEY = "api_key";
  private String apiKey;
  private boolean apiKeyDefined = false;

  public KakaoTalkChatCredentialsDto() {}

  public KakaoTalkChatCredentialsDto kakaotalkPlusFriendId(String kakaotalkPlusFriendId) {
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

  public KakaoTalkChatCredentialsDto apiKey(String apiKey) {
    this.apiKey = apiKey;
    this.apiKeyDefined = true;
    return this;
  }

  /**
   * Get apiKey
   *
   * @return apiKey
   */
  @JsonProperty(JSON_PROPERTY_API_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getApiKey() {
    return apiKey;
  }

  @JsonIgnore
  public boolean getApiKeyDefined() {
    return apiKeyDefined;
  }

  @JsonProperty(JSON_PROPERTY_API_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
    this.apiKeyDefined = true;
  }

  /** Return true if this KakaoTalkChatCredentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KakaoTalkChatCredentialsDto kakaoTalkChatCredentials = (KakaoTalkChatCredentialsDto) o;
    return Objects.equals(
            this.kakaotalkPlusFriendId, kakaoTalkChatCredentials.kakaotalkPlusFriendId)
        && Objects.equals(this.apiKey, kakaoTalkChatCredentials.apiKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kakaotalkPlusFriendId, apiKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KakaoTalkChatCredentialsDto {\n");
    sb.append("    kakaotalkPlusFriendId: ")
        .append(toIndentedString(kakaotalkPlusFriendId))
        .append("\n");
    sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
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
