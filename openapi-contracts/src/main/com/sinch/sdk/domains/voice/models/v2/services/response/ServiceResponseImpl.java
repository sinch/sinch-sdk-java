package com.sinch.sdk.domains.voice.models.v2.services.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.services.CallBehavior;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  ServiceResponseImpl.JSON_PROPERTY_SERVICE_ID,
  ServiceResponseImpl.JSON_PROPERTY_PROJECT_ID,
  ServiceResponseImpl.JSON_PROPERTY_CREATE_TIME,
  ServiceResponseImpl.JSON_PROPERTY_UPDATE_TIME,
  ServiceResponseImpl.JSON_PROPERTY_NAME,
  ServiceResponseImpl.JSON_PROPERTY_DESCRIPTION,
  ServiceResponseImpl.JSON_PROPERTY_IS_DEFAULT,
  ServiceResponseImpl.JSON_PROPERTY_CALL_BEHAVIOR
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ServiceResponseImpl implements ServiceResponse {
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

  public static final String JSON_PROPERTY_CALL_BEHAVIOR = "callBehavior";

  private OptionalValue<CallBehavior> callBehavior;

  public ServiceResponseImpl() {}

  protected ServiceResponseImpl(
      OptionalValue<String> serviceId,
      OptionalValue<String> projectId,
      OptionalValue<Instant> createTime,
      OptionalValue<Instant> updateTime,
      OptionalValue<String> name,
      OptionalValue<String> description,
      OptionalValue<Boolean> isDefault,
      OptionalValue<CallBehavior> callBehavior) {
    this.serviceId = serviceId;
    this.projectId = projectId;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.name = name;
    this.description = description;
    this.isDefault = isDefault;
    this.callBehavior = callBehavior;
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

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> name() {
    return name;
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

  @JsonIgnore
  public Boolean getIsDefault() {
    return isDefault.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IS_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Boolean> isDefault() {
    return isDefault;
  }

  @JsonIgnore
  public CallBehavior getCallBehavior() {
    return callBehavior.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_BEHAVIOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallBehavior> callBehavior() {
    return callBehavior;
  }

  /** Return true if this ServiceResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceResponseImpl serviceResponse = (ServiceResponseImpl) o;
    return Objects.equals(this.serviceId, serviceResponse.serviceId)
        && Objects.equals(this.projectId, serviceResponse.projectId)
        && Objects.equals(this.createTime, serviceResponse.createTime)
        && Objects.equals(this.updateTime, serviceResponse.updateTime)
        && Objects.equals(this.name, serviceResponse.name)
        && Objects.equals(this.description, serviceResponse.description)
        && Objects.equals(this.isDefault, serviceResponse.isDefault)
        && Objects.equals(this.callBehavior, serviceResponse.callBehavior);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        serviceId, projectId, createTime, updateTime, name, description, isDefault, callBehavior);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceResponseImpl {\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    callBehavior: ").append(toIndentedString(callBehavior)).append("\n");
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
  static class Builder implements ServiceResponse.Builder {
    OptionalValue<String> serviceId = OptionalValue.empty();
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<Instant> createTime = OptionalValue.empty();
    OptionalValue<Instant> updateTime = OptionalValue.empty();
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<Boolean> isDefault = OptionalValue.empty();
    OptionalValue<CallBehavior> callBehavior = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_CALL_BEHAVIOR)
    public Builder setCallBehavior(CallBehavior callBehavior) {
      this.callBehavior = OptionalValue.of(callBehavior);
      return this;
    }

    public ServiceResponse build() {
      return new ServiceResponseImpl(
          serviceId, projectId, createTime, updateTime, name, description, isDefault, callBehavior);
    }
  }
}
