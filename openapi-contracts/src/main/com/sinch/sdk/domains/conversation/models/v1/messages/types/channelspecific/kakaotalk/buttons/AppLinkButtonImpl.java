package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.buttons;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  AppLinkButtonImpl.JSON_PROPERTY_TYPE,
  AppLinkButtonImpl.JSON_PROPERTY_NAME,
  AppLinkButtonImpl.JSON_PROPERTY_SCHEME_IOS,
  AppLinkButtonImpl.JSON_PROPERTY_SCHEME_ANDROID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AppLinkButtonImpl
    implements AppLinkButton,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk
            .buttons.KakaoTalkButton {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<String> name;

  public static final String JSON_PROPERTY_SCHEME_IOS = "scheme_ios";

  private OptionalValue<String> schemeIos;

  public static final String JSON_PROPERTY_SCHEME_ANDROID = "scheme_android";

  private OptionalValue<String> schemeAndroid;

  public AppLinkButtonImpl() {}

  protected AppLinkButtonImpl(
      OptionalValue<TypeEnum> type,
      OptionalValue<String> name,
      OptionalValue<String> schemeIos,
      OptionalValue<String> schemeAndroid) {
    this.type = type;
    this.name = name;
    this.schemeIos = schemeIos;
    this.schemeAndroid = schemeAndroid;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> name() {
    return name;
  }

  @JsonIgnore
  public String getSchemeIos() {
    return schemeIos.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCHEME_IOS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> schemeIos() {
    return schemeIos;
  }

  @JsonIgnore
  public String getSchemeAndroid() {
    return schemeAndroid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCHEME_ANDROID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> schemeAndroid() {
    return schemeAndroid;
  }

  /** Return true if this KakaoTalkAppLinkButton object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppLinkButtonImpl kakaoTalkAppLinkButton = (AppLinkButtonImpl) o;
    return Objects.equals(this.type, kakaoTalkAppLinkButton.type)
        && Objects.equals(this.name, kakaoTalkAppLinkButton.name)
        && Objects.equals(this.schemeIos, kakaoTalkAppLinkButton.schemeIos)
        && Objects.equals(this.schemeAndroid, kakaoTalkAppLinkButton.schemeAndroid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, name, schemeIos, schemeAndroid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppLinkButtonImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    schemeIos: ").append(toIndentedString(schemeIos)).append("\n");
    sb.append("    schemeAndroid: ").append(toIndentedString(schemeAndroid)).append("\n");
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
  static class Builder implements AppLinkButton.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.AL);
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<String> schemeIos = OptionalValue.empty();
    OptionalValue<String> schemeAndroid = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.AL)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.AL, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_NAME, required = true)
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SCHEME_IOS, required = true)
    public Builder setSchemeIos(String schemeIos) {
      this.schemeIos = OptionalValue.of(schemeIos);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SCHEME_ANDROID, required = true)
    public Builder setSchemeAndroid(String schemeAndroid) {
      this.schemeAndroid = OptionalValue.of(schemeAndroid);
      return this;
    }

    public AppLinkButton build() {
      return new AppLinkButtonImpl(type, name, schemeIos, schemeAndroid);
    }
  }
}
