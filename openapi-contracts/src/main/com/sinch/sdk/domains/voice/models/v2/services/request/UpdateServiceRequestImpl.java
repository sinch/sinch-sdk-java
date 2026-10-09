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
  UpdateServiceRequestImpl.JSON_PROPERTY_NAME,
  UpdateServiceRequestImpl.JSON_PROPERTY_DESCRIPTION,
  UpdateServiceRequestImpl.JSON_PROPERTY_IS_DEFAULT,
  UpdateServiceRequestImpl.JSON_PROPERTY_CALL_BEHAVIOR
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UpdateServiceRequestImpl implements UpdateServiceRequest {
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

  public UpdateServiceRequestImpl() {}

  protected UpdateServiceRequestImpl(
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
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
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

  /** Return true if this UpdateServiceRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateServiceRequestImpl updateServiceRequest = (UpdateServiceRequestImpl) o;
    return Objects.equals(this.name, updateServiceRequest.name)
        && Objects.equals(this.description, updateServiceRequest.description)
        && Objects.equals(this.isDefault, updateServiceRequest.isDefault)
        && Objects.equals(this.callBehavior, updateServiceRequest.callBehavior)
        && Objects.equals(this.idempotencyKey, updateServiceRequest.idempotencyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, isDefault, callBehavior, idempotencyKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateServiceRequestImpl {\n");
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
  static class Builder implements UpdateServiceRequest.Builder {
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<Boolean> isDefault = OptionalValue.empty();
    OptionalValue<CallBehavior> callBehavior = OptionalValue.empty();
    OptionalValue<String> idempotencyKey = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_NAME)
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    public Builder setAsDefault() {
      return setIsDefault(true);
    }

    // used by Jackson only: the public builder exposes setAsDefault()
    @JsonProperty(JSON_PROPERTY_IS_DEFAULT)
    Builder setIsDefault(Boolean isDefault) {
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

    public UpdateServiceRequest build() {
      return new UpdateServiceRequestImpl(
          name, description, isDefault, callBehavior, idempotencyKey);
    }
  }
}
