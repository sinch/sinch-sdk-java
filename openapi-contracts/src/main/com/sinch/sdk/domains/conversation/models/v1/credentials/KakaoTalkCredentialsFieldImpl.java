package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({KakaoTalkCredentialsFieldImpl.JSON_PROPERTY_KAKAOTALK_CREDENTIALS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class KakaoTalkCredentialsFieldImpl implements KakaoTalkCredentialsField {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_KAKAOTALK_CREDENTIALS = "kakaotalk_credentials";

  private OptionalValue<KakaoTalkCredentials> kakaotalkCredentials;

  public KakaoTalkCredentialsFieldImpl() {}

  protected KakaoTalkCredentialsFieldImpl(
      OptionalValue<KakaoTalkCredentials> kakaotalkCredentials) {
    this.kakaotalkCredentials = kakaotalkCredentials;
  }

  @JsonIgnore
  public KakaoTalkCredentials getKakaotalkCredentials() {
    return kakaotalkCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KAKAOTALK_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<KakaoTalkCredentials> kakaotalkCredentials() {
    return kakaotalkCredentials;
  }

  /** Return true if this KakaoTalkCredentialsField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KakaoTalkCredentialsFieldImpl kakaoTalkCredentialsField = (KakaoTalkCredentialsFieldImpl) o;
    return Objects.equals(
        this.kakaotalkCredentials, kakaoTalkCredentialsField.kakaotalkCredentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kakaotalkCredentials);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KakaoTalkCredentialsFieldImpl {\n");
    sb.append("    kakaotalkCredentials: ")
        .append(toIndentedString(kakaotalkCredentials))
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
  static class Builder implements KakaoTalkCredentialsField.Builder {
    OptionalValue<KakaoTalkCredentials> kakaotalkCredentials = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_KAKAOTALK_CREDENTIALS)
    public Builder setKakaotalkCredentials(KakaoTalkCredentials kakaotalkCredentials) {
      this.kakaotalkCredentials = OptionalValue.of(kakaotalkCredentials);
      return this;
    }

    public KakaoTalkCredentialsField build() {
      return new KakaoTalkCredentialsFieldImpl(kakaotalkCredentials);
    }
  }
}
