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
  WeChatCredentialsImpl.JSON_PROPERTY_APP_ID,
  WeChatCredentialsImpl.JSON_PROPERTY_APP_SECRET,
  WeChatCredentialsImpl.JSON_PROPERTY_TOKEN,
  WeChatCredentialsImpl.JSON_PROPERTY_AES_KEY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WeChatCredentialsImpl implements WeChatCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_ID = "app_id";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_APP_SECRET = "app_secret";

  private OptionalValue<String> appSecret;

  public static final String JSON_PROPERTY_TOKEN = "token";

  private OptionalValue<String> token;

  public static final String JSON_PROPERTY_AES_KEY = "aes_key";

  private OptionalValue<String> aesKey;

  public WeChatCredentialsImpl() {}

  protected WeChatCredentialsImpl(
      OptionalValue<String> appId,
      OptionalValue<String> appSecret,
      OptionalValue<String> token,
      OptionalValue<String> aesKey) {
    this.appId = appId;
    this.appSecret = appSecret;
    this.token = token;
    this.aesKey = aesKey;
  }

  @JsonIgnore
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> appId() {
    return appId;
  }

  @JsonIgnore
  public String getAppSecret() {
    return appSecret.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_SECRET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> appSecret() {
    return appSecret;
  }

  @JsonIgnore
  public String getToken() {
    return token.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> token() {
    return token;
  }

  @JsonIgnore
  public String getAesKey() {
    return aesKey.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AES_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> aesKey() {
    return aesKey;
  }

  /** Return true if this WeChatCredentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeChatCredentialsImpl weChatCredentials = (WeChatCredentialsImpl) o;
    return Objects.equals(this.appId, weChatCredentials.appId)
        && Objects.equals(this.appSecret, weChatCredentials.appSecret)
        && Objects.equals(this.token, weChatCredentials.token)
        && Objects.equals(this.aesKey, weChatCredentials.aesKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, appSecret, token, aesKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeChatCredentialsImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    appSecret: ").append(toIndentedString(appSecret)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    aesKey: ").append(toIndentedString(aesKey)).append("\n");
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
  static class Builder implements WeChatCredentials.Builder {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<String> appSecret = OptionalValue.empty();
    OptionalValue<String> token = OptionalValue.empty();
    OptionalValue<String> aesKey = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APP_SECRET)
    public Builder setAppSecret(String appSecret) {
      this.appSecret = OptionalValue.of(appSecret);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TOKEN)
    public Builder setToken(String token) {
      this.token = OptionalValue.of(token);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_AES_KEY)
    public Builder setAesKey(String aesKey) {
      this.aesKey = OptionalValue.of(aesKey);
      return this;
    }

    public WeChatCredentials build() {
      return new WeChatCredentialsImpl(appId, appSecret, token, aesKey);
    }
  }
}
