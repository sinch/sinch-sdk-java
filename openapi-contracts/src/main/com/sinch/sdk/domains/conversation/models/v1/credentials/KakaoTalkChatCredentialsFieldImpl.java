package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({KakaoTalkChatCredentialsFieldImpl.JSON_PROPERTY_KAKAOTALKCHAT_CREDENTIALS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class KakaoTalkChatCredentialsFieldImpl implements KakaoTalkChatCredentialsField {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_KAKAOTALKCHAT_CREDENTIALS = "kakaotalkchat_credentials";

  private OptionalValue<KakaoTalkChatCredentials> kakaotalkchatCredentials;

  public KakaoTalkChatCredentialsFieldImpl() {}

  protected KakaoTalkChatCredentialsFieldImpl(
      OptionalValue<KakaoTalkChatCredentials> kakaotalkchatCredentials) {
    this.kakaotalkchatCredentials = kakaotalkchatCredentials;
  }

  @JsonIgnore
  public KakaoTalkChatCredentials getKakaotalkchatCredentials() {
    return kakaotalkchatCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KAKAOTALKCHAT_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<KakaoTalkChatCredentials> kakaotalkchatCredentials() {
    return kakaotalkchatCredentials;
  }

  /** Return true if this KakaoTalkChatCredentialsField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KakaoTalkChatCredentialsFieldImpl kakaoTalkChatCredentialsField =
        (KakaoTalkChatCredentialsFieldImpl) o;
    return Objects.equals(
        this.kakaotalkchatCredentials, kakaoTalkChatCredentialsField.kakaotalkchatCredentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kakaotalkchatCredentials);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KakaoTalkChatCredentialsFieldImpl {\n");
    sb.append("    kakaotalkchatCredentials: ")
        .append(toIndentedString(kakaotalkchatCredentials))
        .append("\n");
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
  static class Builder implements KakaoTalkChatCredentialsField.Builder {
    OptionalValue<KakaoTalkChatCredentials> kakaotalkchatCredentials = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_KAKAOTALKCHAT_CREDENTIALS)
    public Builder setKakaotalkchatCredentials(KakaoTalkChatCredentials kakaotalkchatCredentials) {
      this.kakaotalkchatCredentials = OptionalValue.of(kakaotalkchatCredentials);
      return this;
    }

    public KakaoTalkChatCredentialsField build() {
      return new KakaoTalkChatCredentialsFieldImpl(kakaotalkchatCredentials);
    }
  }
}
