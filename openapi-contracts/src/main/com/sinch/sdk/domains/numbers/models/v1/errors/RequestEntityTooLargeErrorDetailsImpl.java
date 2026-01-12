package com.sinch.sdk.domains.numbers.models.v1.errors;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  RequestEntityTooLargeErrorDetailsImpl.JSON_PROPERTY_TYPE,
  RequestEntityTooLargeErrorDetailsImpl.JSON_PROPERTY_RESOURCE_NAME,
  RequestEntityTooLargeErrorDetailsImpl.JSON_PROPERTY_DESCRIPTION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RequestEntityTooLargeErrorDetailsImpl implements RequestEntityTooLargeErrorDetails {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<String> type;

  public static final String JSON_PROPERTY_RESOURCE_NAME = "resourceName";

  private OptionalValue<String> resourceName;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public RequestEntityTooLargeErrorDetailsImpl() {}

  protected RequestEntityTooLargeErrorDetailsImpl(
      OptionalValue<String> type,
      OptionalValue<String> resourceName,
      OptionalValue<String> description) {
    this.type = type;
    this.resourceName = resourceName;
    this.description = description;
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
  public String getResourceName() {
    return resourceName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> resourceName() {
    return resourceName;
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> description() {
    return description;
  }

  /** Return true if this RequestEntityTooLargeErrorDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestEntityTooLargeErrorDetailsImpl requestEntityTooLargeErrorDetails =
        (RequestEntityTooLargeErrorDetailsImpl) o;
    return Objects.equals(this.type, requestEntityTooLargeErrorDetails.type)
        && Objects.equals(this.resourceName, requestEntityTooLargeErrorDetails.resourceName)
        && Objects.equals(this.description, requestEntityTooLargeErrorDetails.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, resourceName, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestEntityTooLargeErrorDetailsImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    resourceName: ").append(toIndentedString(resourceName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
  static class Builder implements RequestEntityTooLargeErrorDetails.Builder {
    OptionalValue<String> type = OptionalValue.empty();
    OptionalValue<String> resourceName = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(String type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_NAME)
    public Builder setResourceName(String resourceName) {
      this.resourceName = OptionalValue.of(resourceName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    public RequestEntityTooLargeErrorDetails build() {
      return new RequestEntityTooLargeErrorDetailsImpl(type, resourceName, description);
    }
  }
}
