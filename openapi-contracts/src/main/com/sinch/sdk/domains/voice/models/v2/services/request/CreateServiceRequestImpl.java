package com.sinch.sdk.domains.voice.models.v2.services.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.services.CallBehavior;
import java.util.Objects;

@JsonPropertyOrder({
  CreateServiceRequestImpl.JSON_PROPERTY_NAME,
  CreateServiceRequestImpl.JSON_PROPERTY_DESCRIPTION,
  CreateServiceRequestImpl.JSON_PROPERTY_IS_DEFAULT,
  CreateServiceRequestImpl.JSON_PROPERTY_CALL_BEHAVIOR
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CreateServiceRequestImpl implements CreateServiceRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<String> name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_IS_DEFAULT = "isDefault";

  private OptionalValue<Boolean> isDefault;

  public static final String JSON_PROPERTY_CALL_BEHAVIOR = "callBehavior";

  private OptionalValue<CallBehavior> callBehavior;

  private OptionalValue<String> idempotencyKey;

  public CreateServiceRequestImpl() {}

  protected CreateServiceRequestImpl(
      OptionalValue<String> name,
      OptionalValue<String> description,
      OptionalValue<Boolean> isDefault,
      OptionalValue<CallBehavior> callBehavior,
      OptionalValue<String> idempotencyKey) {
    this.name = name;
    this.description = description;
    this.isDefault = isDefault;
    this.callBehavior = callBehavior;
    this.idempotencyKey = idempotencyKey;
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
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
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

  @JsonIgnore
  public String getIdempotencyKey() {
    return idempotencyKey.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> idempotencyKey() {
    return idempotencyKey;
  }

  /** Return true if this CreateServiceRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateServiceRequestImpl createServiceRequest = (CreateServiceRequestImpl) o;
    return Objects.equals(this.name, createServiceRequest.name)
        && Objects.equals(this.description, createServiceRequest.description)
        && Objects.equals(this.isDefault, createServiceRequest.isDefault)
        && Objects.equals(this.callBehavior, createServiceRequest.callBehavior)
        && Objects.equals(this.idempotencyKey, createServiceRequest.idempotencyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, isDefault, callBehavior, idempotencyKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateServiceRequestImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    callBehavior: ").append(toIndentedString(callBehavior)).append("\n");
    sb.append("    idempotencyKey: ").append(toIndentedString(idempotencyKey)).append("\n");
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
  static class Builder implements CreateServiceRequest.Builder {
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<Boolean> isDefault = OptionalValue.empty();
    OptionalValue<CallBehavior> callBehavior = OptionalValue.empty();
    OptionalValue<String> idempotencyKey = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_IS_DEFAULT)
    public Builder setIsDefault(Boolean isDefault) {
      this.isDefault = OptionalValue.of(isDefault);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_BEHAVIOR)
    public Builder setCallBehavior(CallBehavior callBehavior) {
      this.callBehavior = OptionalValue.of(callBehavior);
      return this;
    }

    @JsonIgnore
    public Builder setIdempotencyKey(String idempotencyKey) {
      this.idempotencyKey = OptionalValue.of(idempotencyKey);
      return this;
    }

    public CreateServiceRequest build() {
      return new CreateServiceRequestImpl(
          name, description, isDefault, callBehavior, idempotencyKey);
    }
  }
}
