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
  ProblemDetailsImpl.JSON_PROPERTY_TYPE,
  ProblemDetailsImpl.JSON_PROPERTY_TITLE,
  ProblemDetailsImpl.JSON_PROPERTY_STATUS,
  ProblemDetailsImpl.JSON_PROPERTY_TRACE_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ProblemDetailsImpl implements ProblemDetails {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<String> type;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<Integer> status;

  public static final String JSON_PROPERTY_TRACE_ID = "traceId";

  private OptionalValue<String> traceId;

  public ProblemDetailsImpl() {}

  protected ProblemDetailsImpl(
      OptionalValue<String> type,
      OptionalValue<String> title,
      OptionalValue<Integer> status,
      OptionalValue<String> traceId) {
    this.type = type;
    this.title = title;
    this.status = status;
    this.traceId = traceId;
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
  public Integer getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> status() {
    return status;
  }

  @JsonIgnore
  public String getTraceId() {
    return traceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRACE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> traceId() {
    return traceId;
  }

  /** Return true if this ProblemDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProblemDetailsImpl problemDetails = (ProblemDetailsImpl) o;
    return Objects.equals(this.type, problemDetails.type)
        && Objects.equals(this.title, problemDetails.title)
        && Objects.equals(this.status, problemDetails.status)
        && Objects.equals(this.traceId, problemDetails.traceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, status, traceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProblemDetailsImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    traceId: ").append(toIndentedString(traceId)).append("\n");
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
  static class Builder implements ProblemDetails.Builder {
    OptionalValue<String> type = OptionalValue.empty();
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<Integer> status = OptionalValue.empty();
    OptionalValue<String> traceId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(String type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(Integer status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TRACE_ID)
    public Builder setTraceId(String traceId) {
      this.traceId = OptionalValue.of(traceId);
      return this;
    }

    public ProblemDetails build() {
      return new ProblemDetailsImpl(type, title, status, traceId);
    }
  }
}
