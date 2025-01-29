package com.sinch.sdk.domains.sms.models.v1.inbounds;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  MediaMessageBodyDetailsImpl.JSON_PROPERTY_URL,
  MediaMessageBodyDetailsImpl.JSON_PROPERTY_CONTENT_TYPE,
  MediaMessageBodyDetailsImpl.JSON_PROPERTY_STATUS,
  MediaMessageBodyDetailsImpl.JSON_PROPERTY_CODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaMessageBodyDetailsImpl implements MediaMessageBodyDetails {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public static final String JSON_PROPERTY_CONTENT_TYPE = "contentType";

  private OptionalValue<String> contentType;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<String> status;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<Integer> code;

  public MediaMessageBodyDetailsImpl() {}

  protected MediaMessageBodyDetailsImpl(
      OptionalValue<String> url,
      OptionalValue<String> contentType,
      OptionalValue<String> status,
      OptionalValue<Integer> code) {
    this.url = url;
    this.contentType = contentType;
    this.status = status;
    this.code = code;
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

  @JsonIgnore
  public String getContentType() {
    return contentType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> contentType() {
    return contentType;
  }

  @JsonIgnore
  public String getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> status() {
    return status;
  }

  @JsonIgnore
  public Integer getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> code() {
    return code;
  }

  /** Return true if this MOMediaBody_media_inner object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaMessageBodyDetailsImpl moMediaBodyMediaInner = (MediaMessageBodyDetailsImpl) o;
    return Objects.equals(this.url, moMediaBodyMediaInner.url)
        && Objects.equals(this.contentType, moMediaBodyMediaInner.contentType)
        && Objects.equals(this.status, moMediaBodyMediaInner.status)
        && Objects.equals(this.code, moMediaBodyMediaInner.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, contentType, status, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaMessageBodyDetailsImpl {\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
    OptionalValue<String> url = OptionalValue.empty();
    OptionalValue<String> contentType = OptionalValue.empty();
    OptionalValue<String> status = OptionalValue.empty();
    OptionalValue<Integer> code = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_URL)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
    public Builder setContentType(String contentType) {
      this.contentType = OptionalValue.of(contentType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(String status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CODE)
    public Builder setCode(Integer code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    public MediaMessageBodyDetails build() {
      return new MediaMessageBodyDetailsImpl(url, contentType, status, code);
    }
  }
}
