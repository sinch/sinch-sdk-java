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
  NotFoundErrorDetailsImpl.JSON_PROPERTY_TYPE,
  NotFoundErrorDetailsImpl.JSON_PROPERTY_RESOURCE_TYPE,
  NotFoundErrorDetailsImpl.JSON_PROPERTY_RESOURCE_NAME,
  NotFoundErrorDetailsImpl.JSON_PROPERTY_OWNER,
  NotFoundErrorDetailsImpl.JSON_PROPERTY_DESCRIPTION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class NotFoundErrorDetailsImpl implements NotFoundErrorDetails {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<String> type;

  public static final String JSON_PROPERTY_RESOURCE_TYPE = "resourceType";

  private OptionalValue<String> resourceType;

  public static final String JSON_PROPERTY_RESOURCE_NAME = "resourceName";

  private OptionalValue<String> resourceName;

  public static final String JSON_PROPERTY_OWNER = "owner";

  private OptionalValue<String> owner;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public NotFoundErrorDetailsImpl() {}

  protected NotFoundErrorDetailsImpl(
      OptionalValue<String> type,
      OptionalValue<String> resourceType,
      OptionalValue<String> resourceName,
      OptionalValue<String> owner,
      OptionalValue<String> description) {
    this.type = type;
    this.resourceType = resourceType;
    this.resourceName = resourceName;
    this.owner = owner;
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
  public String getResourceType() {
    return resourceType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> resourceType() {
    return resourceType;
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
  public String getOwner() {
    return owner.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OWNER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> owner() {
    return owner;
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

  /** Return true if this NotFoundErrorDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotFoundErrorDetailsImpl notFoundErrorDetails = (NotFoundErrorDetailsImpl) o;
    return Objects.equals(this.type, notFoundErrorDetails.type)
        && Objects.equals(this.resourceType, notFoundErrorDetails.resourceType)
        && Objects.equals(this.resourceName, notFoundErrorDetails.resourceName)
        && Objects.equals(this.owner, notFoundErrorDetails.owner)
        && Objects.equals(this.description, notFoundErrorDetails.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, resourceType, resourceName, owner, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotFoundErrorDetailsImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    resourceName: ").append(toIndentedString(resourceName)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
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
  static class Builder implements NotFoundErrorDetails.Builder {
    OptionalValue<String> type = OptionalValue.empty();
    OptionalValue<String> resourceType = OptionalValue.empty();
    OptionalValue<String> resourceName = OptionalValue.empty();
    OptionalValue<String> owner = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(String type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
    public Builder setResourceType(String resourceType) {
      this.resourceType = OptionalValue.of(resourceType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_NAME)
    public Builder setResourceName(String resourceName) {
      this.resourceName = OptionalValue.of(resourceName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OWNER)
    public Builder setOwner(String owner) {
      this.owner = OptionalValue.of(owner);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    public NotFoundErrorDetails build() {
      return new NotFoundErrorDetailsImpl(type, resourceType, resourceName, owner, description);
    }
  }
}
