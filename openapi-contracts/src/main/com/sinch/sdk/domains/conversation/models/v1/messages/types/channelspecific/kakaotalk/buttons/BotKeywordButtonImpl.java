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
  BotKeywordButtonImpl.JSON_PROPERTY_TYPE,
  BotKeywordButtonImpl.JSON_PROPERTY_NAME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class BotKeywordButtonImpl
    implements BotKeywordButton,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk
            .buttons.KakaoTalkButton {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<String> name;

  public BotKeywordButtonImpl() {}

  protected BotKeywordButtonImpl(OptionalValue<TypeEnum> type, OptionalValue<String> name) {
    this.type = type;
    this.name = name;
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

  /** Return true if this KakaoTalkBotKeywordButton object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BotKeywordButtonImpl kakaoTalkBotKeywordButton = (BotKeywordButtonImpl) o;
    return Objects.equals(this.type, kakaoTalkBotKeywordButton.type)
        && Objects.equals(this.name, kakaoTalkBotKeywordButton.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BotKeywordButtonImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
  static class Builder implements BotKeywordButton.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.BK);
    OptionalValue<String> name = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.BK)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.BK, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_NAME, required = true)
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    public BotKeywordButton build() {
      return new BotKeywordButtonImpl(type, name);
    }
  }
}
