package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  KakaoTalkCredentialsImpl.JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID,
  KakaoTalkCredentialsImpl.JSON_PROPERTY_KAKAOTALK_SENDER_KEY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class KakaoTalkCredentialsImpl implements KakaoTalkCredentials, ChannelCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID = "kakaotalk_plus_friend_id";

  private OptionalValue<String> kakaotalkPlusFriendId;

  public static final String JSON_PROPERTY_KAKAOTALK_SENDER_KEY = "kakaotalk_sender_key";

  private OptionalValue<String> kakaotalkSenderKey;

  public KakaoTalkCredentialsImpl() {}

  protected KakaoTalkCredentialsImpl(
      OptionalValue<String> kakaotalkPlusFriendId, OptionalValue<String> kakaotalkSenderKey) {
    this.kakaotalkPlusFriendId = kakaotalkPlusFriendId;
    this.kakaotalkSenderKey = kakaotalkSenderKey;
  }

  @JsonIgnore
  public String getKakaotalkPlusFriendId() {
    return kakaotalkPlusFriendId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> kakaotalkPlusFriendId() {
    return kakaotalkPlusFriendId;
  }

  @JsonIgnore
  public String getKakaotalkSenderKey() {
    return kakaotalkSenderKey.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KAKAOTALK_SENDER_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> kakaotalkSenderKey() {
    return kakaotalkSenderKey;
  }

  /** Return true if this KakaoTalk_Credentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KakaoTalkCredentialsImpl kakaoTalkCredentials = (KakaoTalkCredentialsImpl) o;
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
    sb.append("class KakaoTalkCredentialsImpl {\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements KakaoTalkCredentials.Builder {
    OptionalValue<String> kakaotalkPlusFriendId = OptionalValue.empty();
    OptionalValue<String> kakaotalkSenderKey = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID)
    public Builder setKakaotalkPlusFriendId(String kakaotalkPlusFriendId) {
      this.kakaotalkPlusFriendId = OptionalValue.of(kakaotalkPlusFriendId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_KAKAOTALK_SENDER_KEY)
    public Builder setKakaotalkSenderKey(String kakaotalkSenderKey) {
      this.kakaotalkSenderKey = OptionalValue.of(kakaotalkSenderKey);
      return this;
    }

    public KakaoTalkCredentials build() {
      return new KakaoTalkCredentialsImpl(kakaotalkPlusFriendId, kakaotalkSenderKey);
    }
  }
}
