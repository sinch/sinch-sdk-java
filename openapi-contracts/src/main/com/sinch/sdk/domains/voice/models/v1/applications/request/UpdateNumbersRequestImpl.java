package com.sinch.sdk.domains.voice.models.v1.applications.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.applications.Capability;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  UpdateNumbersRequestImpl.JSON_PROPERTY_NUMBERS,
  UpdateNumbersRequestImpl.JSON_PROPERTY_APPLICATIONKEY,
  UpdateNumbersRequestImpl.JSON_PROPERTY_CAPABILITY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UpdateNumbersRequestImpl implements UpdateNumbersRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NUMBERS = "numbers";

  private OptionalValue<List<String>> numbers;

  public static final String JSON_PROPERTY_APPLICATIONKEY = "applicationkey";

  private OptionalValue<String> applicationKey;

  public static final String JSON_PROPERTY_CAPABILITY = "capability";

  private OptionalValue<Capability> capability;

  public UpdateNumbersRequestImpl() {}

  protected UpdateNumbersRequestImpl(
      OptionalValue<List<String>> numbers,
      OptionalValue<String> applicationKey,
      OptionalValue<Capability> capability) {
    this.numbers = numbers;
    this.applicationKey = applicationKey;
    this.capability = capability;
  }

  @JsonIgnore
  public List<String> getNumbers() {
    return numbers.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> numbers() {
    return numbers;
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

  /** Return true if this updateNumbers object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateNumbersRequestImpl updateNumbers = (UpdateNumbersRequestImpl) o;
    return Objects.equals(this.numbers, updateNumbers.numbers)
        && Objects.equals(this.applicationKey, updateNumbers.applicationKey)
        && Objects.equals(this.capability, updateNumbers.capability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers, applicationKey, capability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateNumbersRequestImpl {\n");
    sb.append("    numbers: ").append(toIndentedString(numbers)).append("\n");
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
  static class Builder implements UpdateNumbersRequest.Builder {
    OptionalValue<List<String>> numbers = OptionalValue.empty();
    OptionalValue<String> applicationKey = OptionalValue.empty();
    OptionalValue<Capability> capability = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_NUMBERS)
    public Builder setNumbers(List<String> numbers) {
      this.numbers = OptionalValue.of(numbers);
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

    public UpdateNumbersRequest build() {
      return new UpdateNumbersRequestImpl(numbers, applicationKey, capability);
    }
  }
}
