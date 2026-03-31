package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.image;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ImageImpl.JSON_PROPERTY_IMAGE_URL, ImageImpl.JSON_PROPERTY_IMAGE_LINK})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ImageImpl implements Image {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IMAGE_URL = "image_url";

  private OptionalValue<String> imageUrl;

  public static final String JSON_PROPERTY_IMAGE_LINK = "image_link";

  private OptionalValue<String> imageLink;

  public ImageImpl() {}

  protected ImageImpl(OptionalValue<String> imageUrl, OptionalValue<String> imageLink) {
    this.imageUrl = imageUrl;
    this.imageLink = imageLink;
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
  public String getImageLink() {
    return imageLink.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IMAGE_LINK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> imageLink() {
    return imageLink;
  }

  /** Return true if this KakaoTalkCommerceMessage_image object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImageImpl kakaoTalkCommerceMessageImage = (ImageImpl) o;
    return Objects.equals(this.imageUrl, kakaoTalkCommerceMessageImage.imageUrl)
        && Objects.equals(this.imageLink, kakaoTalkCommerceMessageImage.imageLink);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageUrl, imageLink);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageImpl {\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    imageLink: ").append(toIndentedString(imageLink)).append("\n");
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
  static class Builder implements Image.Builder {
    OptionalValue<String> imageUrl = OptionalValue.empty();
    OptionalValue<String> imageLink = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_IMAGE_URL, required = true)
    public Builder setImageUrl(String imageUrl) {
      this.imageUrl = OptionalValue.of(imageUrl);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_IMAGE_LINK)
    public Builder setImageLink(String imageLink) {
      this.imageLink = OptionalValue.of(imageLink);
      return this;
    }

    public Image build() {
      return new ImageImpl(imageUrl, imageLink);
    }
  }
}
