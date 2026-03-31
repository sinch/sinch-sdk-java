package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.carousel;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce.KakaoTalkCommerceMessage;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  CarouselImpl.JSON_PROPERTY_HEAD,
  CarouselImpl.JSON_PROPERTY_LIST,
  CarouselImpl.JSON_PROPERTY_TAIL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CarouselImpl implements Carousel {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_HEAD = "head";

  private OptionalValue<CarouselHead> head;

  public static final String JSON_PROPERTY_LIST = "list";

  private OptionalValue<List<KakaoTalkCommerceMessage>> _list;

  public static final String JSON_PROPERTY_TAIL = "tail";

  private OptionalValue<CarouselTail> tail;

  public CarouselImpl() {}

  protected CarouselImpl(
      OptionalValue<CarouselHead> head,
      OptionalValue<List<KakaoTalkCommerceMessage>> _list,
      OptionalValue<CarouselTail> tail) {
    this.head = head;
    this._list = _list;
    this.tail = tail;
  }

  @JsonIgnore
  public CarouselHead getHead() {
    return head.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HEAD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CarouselHead> head() {
    return head;
  }

  @JsonIgnore
  public List<KakaoTalkCommerceMessage> getList() {
    return _list.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LIST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<KakaoTalkCommerceMessage>> list() {
    return _list;
  }

  @JsonIgnore
  public CarouselTail getTail() {
    return tail.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CarouselTail> tail() {
    return tail;
  }

  /**
   * Return true if this KakaoTalk_carousel_commerce_channel_specific_message_carousel object is
   * equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarouselImpl kakaoTalkCarouselCommerceChannelSpecificMessageCarousel = (CarouselImpl) o;
    return Objects.equals(this.head, kakaoTalkCarouselCommerceChannelSpecificMessageCarousel.head)
        && Objects.equals(this._list, kakaoTalkCarouselCommerceChannelSpecificMessageCarousel._list)
        && Objects.equals(this.tail, kakaoTalkCarouselCommerceChannelSpecificMessageCarousel.tail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(head, _list, tail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarouselImpl {\n");
    sb.append("    head: ").append(toIndentedString(head)).append("\n");
    sb.append("    _list: ").append(toIndentedString(_list)).append("\n");
    sb.append("    tail: ").append(toIndentedString(tail)).append("\n");
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
  static class Builder implements Carousel.Builder {
    OptionalValue<CarouselHead> head = OptionalValue.empty();
    OptionalValue<List<KakaoTalkCommerceMessage>> _list = OptionalValue.empty();
    OptionalValue<CarouselTail> tail = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_HEAD)
    public Builder setHead(CarouselHead head) {
      this.head = OptionalValue.of(head);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_LIST, required = true)
    public Builder setList(List<KakaoTalkCommerceMessage> _list) {
      this._list = OptionalValue.of(_list);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TAIL)
    public Builder setTail(CarouselTail tail) {
      this.tail = OptionalValue.of(tail);
      return this;
    }

    public Carousel build() {
      return new CarouselImpl(head, _list, tail);
    }
  }
}
