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
  WebLinkButtonImpl.JSON_PROPERTY_TYPE,
  WebLinkButtonImpl.JSON_PROPERTY_NAME,
  WebLinkButtonImpl.JSON_PROPERTY_LINK_MO,
  WebLinkButtonImpl.JSON_PROPERTY_LINK_PC
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WebLinkButtonImpl
    implements WebLinkButton,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk
            .buttons.KakaoTalkButton {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<String> name;

  public static final String JSON_PROPERTY_LINK_MO = "link_mo";

  private OptionalValue<String> linkMo;

  public static final String JSON_PROPERTY_LINK_PC = "link_pc";

  private OptionalValue<String> linkPc;

  public WebLinkButtonImpl() {}

  protected WebLinkButtonImpl(
      OptionalValue<TypeEnum> type,
      OptionalValue<String> name,
      OptionalValue<String> linkMo,
      OptionalValue<String> linkPc) {
    this.type = type;
    this.name = name;
    this.linkMo = linkMo;
    this.linkPc = linkPc;
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
  public String getLinkMo() {
    return linkMo.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINK_MO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> linkMo() {
    return linkMo;
  }

  @JsonIgnore
  public String getLinkPc() {
    return linkPc.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINK_PC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> linkPc() {
    return linkPc;
  }

  /** Return true if this KakaoTalkWebLinkButton object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebLinkButtonImpl kakaoTalkWebLinkButton = (WebLinkButtonImpl) o;
    return Objects.equals(this.type, kakaoTalkWebLinkButton.type)
        && Objects.equals(this.name, kakaoTalkWebLinkButton.name)
        && Objects.equals(this.linkMo, kakaoTalkWebLinkButton.linkMo)
        && Objects.equals(this.linkPc, kakaoTalkWebLinkButton.linkPc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, name, linkMo, linkPc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebLinkButtonImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    linkMo: ").append(toIndentedString(linkMo)).append("\n");
    sb.append("    linkPc: ").append(toIndentedString(linkPc)).append("\n");
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
  static class Builder implements WebLinkButton.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.WL);
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<String> linkMo = OptionalValue.empty();
    OptionalValue<String> linkPc = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.WL)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.WL, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_NAME, required = true)
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_LINK_MO, required = true)
    public Builder setLinkMo(String linkMo) {
      this.linkMo = OptionalValue.of(linkMo);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINK_PC)
    public Builder setLinkPc(String linkPc) {
      this.linkPc = OptionalValue.of(linkPc);
      return this;
    }

    public WebLinkButton build() {
      return new WebLinkButtonImpl(type, name, linkMo, linkPc);
    }
  }
}
