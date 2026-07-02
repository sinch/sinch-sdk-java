package com.sinch.sdk.domains.numberlookup.models.v2.errors;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  LookupErrorImpl.JSON_PROPERTY_STATUS,
  LookupErrorImpl.JSON_PROPERTY_TITLE,
  LookupErrorImpl.JSON_PROPERTY_DETAIL,
  LookupErrorImpl.JSON_PROPERTY_TYPE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LookupErrorImpl implements LookupError {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<Integer> status;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_DETAIL = "detail";

  private OptionalValue<String> detail;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<String> type;

  public LookupErrorImpl() {}

  protected LookupErrorImpl(
      OptionalValue<Integer> status,
      OptionalValue<String> title,
      OptionalValue<String> detail,
      OptionalValue<String> type) {
    this.status = status;
    this.title = title;
    this.detail = detail;
    this.type = type;
  }

  @JsonIgnore
  public Integer getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> status() {
    return status;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> title() {
    return title;
  }

  @JsonIgnore
  public String getDetail() {
    return detail.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> detail() {
    return detail;
  }

  @JsonIgnore
  public String getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> type() {
    return type;
  }

  /** Return true if this ErrorResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LookupErrorImpl errorResponse = (LookupErrorImpl) o;
    return Objects.equals(this.status, errorResponse.status)
        && Objects.equals(this.title, errorResponse.title)
        && Objects.equals(this.detail, errorResponse.detail)
        && Objects.equals(this.type, errorResponse.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, title, detail, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LookupErrorImpl {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
  static class Builder implements LookupError.Builder {
    OptionalValue<Integer> status = OptionalValue.empty();
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<String> detail = OptionalValue.empty();
    OptionalValue<String> type = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(Integer status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DETAIL)
    public Builder setDetail(String detail) {
      this.detail = OptionalValue.of(detail);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(String type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    public LookupError build() {
      return new LookupErrorImpl(status, title, detail, type);
    }
  }
}
