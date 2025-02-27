package com.sinch.sdk.domains.sms.models.v1.inbounds;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import java.util.Objects;

@JsonPropertyOrder({
  MediaMessageBodyDetailsImpl.JSON_PROPERTY_CODE,
  MediaMessageBodyDetailsImpl.JSON_PROPERTY_CONTENT_TYPE,
  MediaMessageBodyDetailsImpl.JSON_PROPERTY_STATUS,
  MediaMessageBodyDetailsImpl.JSON_PROPERTY_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaMessageBodyDetailsImpl implements MediaMessageBodyDetails {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<Integer> code;

  public static final String JSON_PROPERTY_CONTENT_TYPE = "content_type";

  private OptionalValue<String> contentType;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<StatusEnum> StatusEnum;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public MediaMessageBodyDetailsImpl() {}

  protected MediaMessageBodyDetailsImpl(
      OptionalValue<Integer> code,
      OptionalValue<String> contentType,
      OptionalValue<StatusEnum> StatusEnum,
      OptionalValue<String> url) {
    this.code = code;
    this.contentType = contentType;
    this.StatusEnum = StatusEnum;
    this.url = url;
  }

  @JsonIgnore
  public String getStatus() {
    return statusEnum().map(EnumDynamic::value).orElse(null);
  }

  @JsonIgnore
  public Integer getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> code() {
    return code;
  }

  @JsonIgnore
  public String getContentType() {
    return contentType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> contentType() {
    return contentType;
  }

  @JsonIgnore
  public StatusEnum getStatusEnum() {
    return StatusEnum.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<StatusEnum> statusEnum() {
    return StatusEnum;
  }

  @JsonIgnore
  public String getUrl() {
    return url.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> url() {
    return url;
  }

  /** Return true if this MmsMedia object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaMessageBodyDetailsImpl mmsMedia = (MediaMessageBodyDetailsImpl) o;
    return Objects.equals(this.code, mmsMedia.code)
        && Objects.equals(this.contentType, mmsMedia.contentType)
        && Objects.equals(this.StatusEnum, mmsMedia.StatusEnum)
        && Objects.equals(this.url, mmsMedia.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, contentType, StatusEnum, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaMessageBodyDetailsImpl {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    StatusEnum: ").append(toIndentedString(StatusEnum)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
  static class Builder implements MediaMessageBodyDetails.Builder {
    OptionalValue<Integer> code = OptionalValue.empty();
    OptionalValue<String> contentType = OptionalValue.empty();
    OptionalValue<StatusEnum> StatusEnum = OptionalValue.empty();
    OptionalValue<String> url = OptionalValue.empty();

    public Builder setStatus(String status) {
      setStatusEnum(MediaMessageBodyDetails.StatusEnum.from(status));
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CODE)
    public Builder setCode(Integer code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
    public Builder setContentType(String contentType) {
      this.contentType = OptionalValue.of(contentType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatusEnum(StatusEnum StatusEnum) {
      this.StatusEnum = OptionalValue.of(StatusEnum);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_URL)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    public MediaMessageBodyDetails build() {
      return new MediaMessageBodyDetailsImpl(code, contentType, StatusEnum, url);
    }
  }
}
