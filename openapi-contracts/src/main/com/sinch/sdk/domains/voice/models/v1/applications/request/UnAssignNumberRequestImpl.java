package com.sinch.sdk.domains.voice.models.v1.applications.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.applications.Capability;
import java.util.Objects;

@JsonPropertyOrder({
  UnAssignNumberRequestImpl.JSON_PROPERTY_NUMBER,
  UnAssignNumberRequestImpl.JSON_PROPERTY_APPLICATIONKEY,
  UnAssignNumberRequestImpl.JSON_PROPERTY_CAPABILITY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UnAssignNumberRequestImpl implements UnAssignNumberRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NUMBER = "number";

  private OptionalValue<String> number;

  public static final String JSON_PROPERTY_APPLICATIONKEY = "applicationkey";

  private OptionalValue<String> applicationKey;

  public static final String JSON_PROPERTY_CAPABILITY = "capability";

  private OptionalValue<Capability> capability;

  public UnAssignNumberRequestImpl() {}

  protected UnAssignNumberRequestImpl(
      OptionalValue<String> number,
      OptionalValue<String> applicationKey,
      OptionalValue<Capability> capability) {
    this.number = number;
    this.applicationKey = applicationKey;
    this.capability = capability;
  }

  @JsonIgnore
  public String getNumber() {
    return number.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> number() {
    return number;
  }

  @JsonIgnore
  public String getApplicationKey() {
    return applicationKey.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APPLICATIONKEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> applicationKey() {
    return applicationKey;
  }

  @JsonIgnore
  public Capability getCapability() {
    return capability.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAPABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Capability> capability() {
    return capability;
  }

  /** Return true if this unassignNumbers object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnAssignNumberRequestImpl unassignNumbers = (UnAssignNumberRequestImpl) o;
    return Objects.equals(this.number, unassignNumbers.number)
        && Objects.equals(this.applicationKey, unassignNumbers.applicationKey)
        && Objects.equals(this.capability, unassignNumbers.capability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, applicationKey, capability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnAssignNumberRequestImpl {\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    applicationKey: ").append(toIndentedString(applicationKey)).append("\n");
    sb.append("    capability: ").append(toIndentedString(capability)).append("\n");
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
  static class Builder implements UnAssignNumberRequest.Builder {
    OptionalValue<String> number = OptionalValue.empty();
    OptionalValue<String> applicationKey = OptionalValue.empty();
    OptionalValue<Capability> capability = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_NUMBER)
    public Builder setNumber(String number) {
      this.number = OptionalValue.of(number);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APPLICATIONKEY)
    public Builder setApplicationKey(String applicationKey) {
      this.applicationKey = OptionalValue.of(applicationKey);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CAPABILITY)
    public Builder setCapability(Capability capability) {
      this.capability = OptionalValue.of(capability);
      return this;
    }

    public UnAssignNumberRequest build() {
      return new UnAssignNumberRequestImpl(number, applicationKey, capability);
    }
  }
}
