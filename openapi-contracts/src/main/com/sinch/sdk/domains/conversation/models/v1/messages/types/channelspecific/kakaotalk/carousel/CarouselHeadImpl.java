package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.carousel;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  CarouselHeadImpl.JSON_PROPERTY_HEADER,
  CarouselHeadImpl.JSON_PROPERTY_CONTENT,
  CarouselHeadImpl.JSON_PROPERTY_IMAGE_URL,
  CarouselHeadImpl.JSON_PROPERTY_LINK_MO,
  CarouselHeadImpl.JSON_PROPERTY_LINK_PC,
  CarouselHeadImpl.JSON_PROPERTY_SCHEME_IOS,
  CarouselHeadImpl.JSON_PROPERTY_SCHEME_ANDROID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CarouselHeadImpl implements CarouselHead {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_HEADER = "header";

  private OptionalValue<String> header;

  public static final String JSON_PROPERTY_CONTENT = "content";

  private OptionalValue<String> content;

  public static final String JSON_PROPERTY_IMAGE_URL = "image_url";

  private OptionalValue<String> imageUrl;

  public static final String JSON_PROPERTY_LINK_MO = "link_mo";

  private OptionalValue<String> linkMo;

  public static final String JSON_PROPERTY_LINK_PC = "link_pc";

  private OptionalValue<String> linkPc;

  public static final String JSON_PROPERTY_SCHEME_IOS = "scheme_ios";

  private OptionalValue<String> schemeIos;

  public static final String JSON_PROPERTY_SCHEME_ANDROID = "scheme_android";

  private OptionalValue<String> schemeAndroid;

  public CarouselHeadImpl() {}

  protected CarouselHeadImpl(
      OptionalValue<String> header,
      OptionalValue<String> content,
      OptionalValue<String> imageUrl,
      OptionalValue<String> linkMo,
      OptionalValue<String> linkPc,
      OptionalValue<String> schemeIos,
      OptionalValue<String> schemeAndroid) {
    this.header = header;
    this.content = content;
    this.imageUrl = imageUrl;
    this.linkMo = linkMo;
    this.linkPc = linkPc;
    this.schemeIos = schemeIos;
    this.schemeAndroid = schemeAndroid;
  }

  @JsonIgnore
  public String getHeader() {
    return header.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HEADER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> header() {
    return header;
  }

  @JsonIgnore
  public String getContent() {
    return content.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> content() {
    return content;
  }

  @JsonIgnore
  public String getImageUrl() {
    return imageUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IMAGE_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> imageUrl() {
    return imageUrl;
  }

  @JsonIgnore
  public String getLinkMo() {
    return linkMo.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINK_MO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
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

  @JsonIgnore
  public String getSchemeIos() {
    return schemeIos.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCHEME_IOS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> schemeIos() {
    return schemeIos;
  }

  @JsonIgnore
  public String getSchemeAndroid() {
    return schemeAndroid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCHEME_ANDROID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> schemeAndroid() {
    return schemeAndroid;
  }

  /**
   * Return true if this KakaoTalk_carousel_commerce_channel_specific_message_carousel_head object
   * is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarouselHeadImpl kakaoTalkCarouselCommerceChannelSpecificMessageCarouselHead =
        (CarouselHeadImpl) o;
    return Objects.equals(
            this.header, kakaoTalkCarouselCommerceChannelSpecificMessageCarouselHead.header)
        && Objects.equals(
            this.content, kakaoTalkCarouselCommerceChannelSpecificMessageCarouselHead.content)
        && Objects.equals(
            this.imageUrl, kakaoTalkCarouselCommerceChannelSpecificMessageCarouselHead.imageUrl)
        && Objects.equals(
            this.linkMo, kakaoTalkCarouselCommerceChannelSpecificMessageCarouselHead.linkMo)
        && Objects.equals(
            this.linkPc, kakaoTalkCarouselCommerceChannelSpecificMessageCarouselHead.linkPc)
        && Objects.equals(
            this.schemeIos, kakaoTalkCarouselCommerceChannelSpecificMessageCarouselHead.schemeIos)
        && Objects.equals(
            this.schemeAndroid,
            kakaoTalkCarouselCommerceChannelSpecificMessageCarouselHead.schemeAndroid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, content, imageUrl, linkMo, linkPc, schemeIos, schemeAndroid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarouselHeadImpl {\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    linkMo: ").append(toIndentedString(linkMo)).append("\n");
    sb.append("    linkPc: ").append(toIndentedString(linkPc)).append("\n");
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
  static class Builder implements CarouselHead.Builder {
    OptionalValue<String> header = OptionalValue.empty();
    OptionalValue<String> content = OptionalValue.empty();
    OptionalValue<String> imageUrl = OptionalValue.empty();
    OptionalValue<String> linkMo = OptionalValue.empty();
    OptionalValue<String> linkPc = OptionalValue.empty();
    OptionalValue<String> schemeIos = OptionalValue.empty();
    OptionalValue<String> schemeAndroid = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_HEADER, required = true)
    public Builder setHeader(String header) {
      this.header = OptionalValue.of(header);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CONTENT, required = true)
    public Builder setContent(String content) {
      this.content = OptionalValue.of(content);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_IMAGE_URL, required = true)
    public Builder setImageUrl(String imageUrl) {
      this.imageUrl = OptionalValue.of(imageUrl);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINK_MO)
    public Builder setLinkMo(String linkMo) {
      this.linkMo = OptionalValue.of(linkMo);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINK_PC)
    public Builder setLinkPc(String linkPc) {
      this.linkPc = OptionalValue.of(linkPc);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCHEME_IOS)
    public Builder setSchemeIos(String schemeIos) {
      this.schemeIos = OptionalValue.of(schemeIos);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCHEME_ANDROID)
    public Builder setSchemeAndroid(String schemeAndroid) {
      this.schemeAndroid = OptionalValue.of(schemeAndroid);
      return this;
    }

    public CarouselHead build() {
      return new CarouselHeadImpl(
          header, content, imageUrl, linkMo, linkPc, schemeIos, schemeAndroid);
    }
  }
}
