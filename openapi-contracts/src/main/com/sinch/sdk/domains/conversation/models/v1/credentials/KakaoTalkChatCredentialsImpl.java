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
  KakaoTalkChatCredentialsImpl.JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID,
  KakaoTalkChatCredentialsImpl.JSON_PROPERTY_API_KEY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class KakaoTalkChatCredentialsImpl implements KakaoTalkChatCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID = "kakaotalk_plus_friend_id";

  private OptionalValue<String> kakaotalkPlusFriendId;

  public static final String JSON_PROPERTY_API_KEY = "api_key";

  private OptionalValue<String> apiKey;

  public KakaoTalkChatCredentialsImpl() {}

  protected KakaoTalkChatCredentialsImpl(
      OptionalValue<String> kakaotalkPlusFriendId, OptionalValue<String> apiKey) {
    this.kakaotalkPlusFriendId = kakaotalkPlusFriendId;
    this.apiKey = apiKey;
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
  public String getApiKey() {
    return apiKey.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_API_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> apiKey() {
    return apiKey;
  }

  /** Return true if this KakaoTalkChat_Credentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KakaoTalkChatCredentialsImpl kakaoTalkChatCredentials = (KakaoTalkChatCredentialsImpl) o;
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
    sb.append("class KakaoTalkChatCredentialsImpl {\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements KakaoTalkChatCredentials.Builder {
    OptionalValue<String> kakaotalkPlusFriendId = OptionalValue.empty();
    OptionalValue<String> apiKey = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_KAKAOTALK_PLUS_FRIEND_ID)
    public Builder setKakaotalkPlusFriendId(String kakaotalkPlusFriendId) {
      this.kakaotalkPlusFriendId = OptionalValue.of(kakaotalkPlusFriendId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_API_KEY)
    public Builder setApiKey(String apiKey) {
      this.apiKey = OptionalValue.of(apiKey);
      return this;
    }

    public KakaoTalkChatCredentials build() {
      return new KakaoTalkChatCredentialsImpl(kakaotalkPlusFriendId, apiKey);
    }
  }
}
