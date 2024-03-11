package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({WeChatCredentialsFieldImpl.JSON_PROPERTY_WECHAT_CREDENTIALS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WeChatCredentialsFieldImpl implements WeChatCredentialsField {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_WECHAT_CREDENTIALS = "wechat_credentials";

  private OptionalValue<WeChatCredentials> wechatCredentials;

  public WeChatCredentialsFieldImpl() {}

  protected WeChatCredentialsFieldImpl(OptionalValue<WeChatCredentials> wechatCredentials) {
    this.wechatCredentials = wechatCredentials;
  }

  @JsonIgnore
  public WeChatCredentials getWechatCredentials() {
    return wechatCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WECHAT_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<WeChatCredentials> wechatCredentials() {
    return wechatCredentials;
  }

  /** Return true if this WeChatCredentialsField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeChatCredentialsFieldImpl weChatCredentialsField = (WeChatCredentialsFieldImpl) o;
    return Objects.equals(this.wechatCredentials, weChatCredentialsField.wechatCredentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(wechatCredentials);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeChatCredentialsFieldImpl {\n");
    sb.append("    wechatCredentials: ").append(toIndentedString(wechatCredentials)).append("\n");
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
  static class Builder implements WeChatCredentialsField.Builder {
    OptionalValue<WeChatCredentials> wechatCredentials = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_WECHAT_CREDENTIALS)
    public Builder setWechatCredentials(WeChatCredentials wechatCredentials) {
      this.wechatCredentials = OptionalValue.of(wechatCredentials);
      return this;
    }

    public WeChatCredentialsField build() {
      return new WeChatCredentialsFieldImpl(wechatCredentials);
    }
  }
}
