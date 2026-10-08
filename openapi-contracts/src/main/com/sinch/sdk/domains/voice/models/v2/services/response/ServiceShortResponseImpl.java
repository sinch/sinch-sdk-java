package com.sinch.sdk.domains.voice.models.v2.services.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  ServiceShortResponseImpl.JSON_PROPERTY_SERVICE_ID,
  ServiceShortResponseImpl.JSON_PROPERTY_PROJECT_ID,
  ServiceShortResponseImpl.JSON_PROPERTY_CREATE_TIME,
  ServiceShortResponseImpl.JSON_PROPERTY_UPDATE_TIME,
  ServiceShortResponseImpl.JSON_PROPERTY_NAME,
  ServiceShortResponseImpl.JSON_PROPERTY_DESCRIPTION,
  ServiceShortResponseImpl.JSON_PROPERTY_IS_DEFAULT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ServiceShortResponseImpl implements ServiceShortResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SERVICE_ID = "serviceId";

  private OptionalValue<String> serviceId;

  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_CREATE_TIME = "createTime";

  private OptionalValue<Instant> createTime;

  public static final String JSON_PROPERTY_UPDATE_TIME = "updateTime";

  private OptionalValue<Instant> updateTime;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<String> name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_IS_DEFAULT = "isDefault";

  private OptionalValue<Boolean> isDefault;

  public ServiceShortResponseImpl() {}

  protected ServiceShortResponseImpl(
      OptionalValue<String> serviceId,
      OptionalValue<String> projectId,
      OptionalValue<Instant> createTime,
      OptionalValue<Instant> updateTime,
      OptionalValue<String> name,
      OptionalValue<String> description,
      OptionalValue<Boolean> isDefault) {
    this.serviceId = serviceId;
    this.projectId = projectId;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.name = name;
    this.description = description;
    this.isDefault = isDefault;
  }

  @JsonIgnore
  public String getServiceId() {
    return serviceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SERVICE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> serviceId() {
    return serviceId;
  }

  @JsonIgnore
  public String getProjectId() {
    return projectId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> projectId() {
    return projectId;
  }

  @JsonIgnore
  public Instant getCreateTime() {
    return createTime.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> createTime() {
    return createTime;
  }

  @JsonIgnore
  public Instant getUpdateTime() {
    return updateTime.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> updateTime() {
    return updateTime;
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> name() {
    return name;
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> description() {
    return description;
  }

  @JsonIgnore
  public Boolean getIsDefault() {
    return isDefault.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Boolean> isDefault() {
    return isDefault;
  }

  /** Return true if this ServiceShortResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceShortResponseImpl serviceShortResponse = (ServiceShortResponseImpl) o;
    return Objects.equals(this.serviceId, serviceShortResponse.serviceId)
        && Objects.equals(this.projectId, serviceShortResponse.projectId)
        && Objects.equals(this.createTime, serviceShortResponse.createTime)
        && Objects.equals(this.updateTime, serviceShortResponse.updateTime)
        && Objects.equals(this.name, serviceShortResponse.name)
        && Objects.equals(this.description, serviceShortResponse.description)
        && Objects.equals(this.isDefault, serviceShortResponse.isDefault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceId, projectId, createTime, updateTime, name, description, isDefault);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceShortResponseImpl {\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
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
  static class Builder implements ServiceShortResponse.Builder {
    OptionalValue<String> serviceId = OptionalValue.empty();
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<Instant> createTime = OptionalValue.empty();
    OptionalValue<Instant> updateTime = OptionalValue.empty();
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<Boolean> isDefault = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_SERVICE_ID, required = true)
    public Builder setServiceId(String serviceId) {
      this.serviceId = OptionalValue.of(serviceId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_PROJECT_ID, required = true)
    public Builder setProjectId(String projectId) {
      this.projectId = OptionalValue.of(projectId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CREATE_TIME, required = true)
    public Builder setCreateTime(Instant createTime) {
      this.createTime = OptionalValue.of(createTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
    public Builder setUpdateTime(Instant updateTime) {
      this.updateTime = OptionalValue.of(updateTime);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_NAME, required = true)
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_IS_DEFAULT, required = true)
    public Builder setIsDefault(Boolean isDefault) {
      this.isDefault = OptionalValue.of(isDefault);
      return this;
    }

    public ServiceShortResponse build() {
      return new ServiceShortResponseImpl(
          serviceId, projectId, createTime, updateTime, name, description, isDefault);
    }
  }
}
