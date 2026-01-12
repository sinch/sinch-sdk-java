package com.sinch.sdk.domains.numbers.models.v1.numberorder.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  CreateQuantityOrderOptionImpl.JSON_PROPERTY_NUMBER_PATTERN,
  CreateQuantityOrderOptionImpl.JSON_PROPERTY_REQUESTED_QUANTITY,
  CreateQuantityOrderOptionImpl.JSON_PROPERTY_SEQUENTIAL,
  CreateQuantityOrderOptionImpl.JSON_PROPERTY_CAPABILITIES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CreateQuantityOrderOptionImpl implements CreateQuantityOrderOption {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NUMBER_PATTERN = "numberPattern";

  private OptionalValue<SearchPattern> numberPattern;

  public static final String JSON_PROPERTY_REQUESTED_QUANTITY = "requestedQuantity";

  private OptionalValue<Integer> requestedQuantity;

  public static final String JSON_PROPERTY_SEQUENTIAL = "sequential";

  private OptionalValue<Boolean> sequential;

  public static final String JSON_PROPERTY_CAPABILITIES = "capabilities";

  private OptionalValue<List<Capability>> capabilities;

  public CreateQuantityOrderOptionImpl() {}

  protected CreateQuantityOrderOptionImpl(
      OptionalValue<SearchPattern> numberPattern,
      OptionalValue<Integer> requestedQuantity,
      OptionalValue<Boolean> sequential,
      OptionalValue<List<Capability>> capabilities) {
    this.numberPattern = numberPattern;
    this.requestedQuantity = requestedQuantity;
    this.sequential = sequential;
    this.capabilities = capabilities;
  }

  @JsonIgnore
  public SearchPattern getNumberPattern() {
    return numberPattern.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_PATTERN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SearchPattern> numberPattern() {
    return numberPattern;
  }

  @JsonIgnore
  public Integer getRequestedQuantity() {
    return requestedQuantity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REQUESTED_QUANTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> requestedQuantity() {
    return requestedQuantity;
  }

  @JsonIgnore
  public Boolean getSequential() {
    return sequential.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SEQUENTIAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> sequential() {
    return sequential;
  }

  @JsonIgnore
  public List<Capability> getCapabilities() {
    return capabilities.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAPABILITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Capability>> capabilities() {
    return capabilities;
  }

  /** Return true if this CreateQuantityOrderOption object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateQuantityOrderOptionImpl createQuantityOrderOption = (CreateQuantityOrderOptionImpl) o;
    return Objects.equals(this.numberPattern, createQuantityOrderOption.numberPattern)
        && Objects.equals(this.requestedQuantity, createQuantityOrderOption.requestedQuantity)
        && Objects.equals(this.sequential, createQuantityOrderOption.sequential)
        && Objects.equals(this.capabilities, createQuantityOrderOption.capabilities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberPattern, requestedQuantity, sequential, capabilities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateQuantityOrderOptionImpl {\n");
    sb.append("    numberPattern: ").append(toIndentedString(numberPattern)).append("\n");
    sb.append("    requestedQuantity: ").append(toIndentedString(requestedQuantity)).append("\n");
    sb.append("    sequential: ").append(toIndentedString(sequential)).append("\n");
    sb.append("    capabilities: ").append(toIndentedString(capabilities)).append("\n");
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
  static class Builder implements CreateQuantityOrderOption.Builder {
    OptionalValue<SearchPattern> numberPattern = OptionalValue.empty();
    OptionalValue<Integer> requestedQuantity = OptionalValue.empty();
    OptionalValue<Boolean> sequential = OptionalValue.empty();
    OptionalValue<List<Capability>> capabilities = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_NUMBER_PATTERN)
    public Builder setNumberPattern(SearchPattern numberPattern) {
      this.numberPattern = OptionalValue.of(numberPattern);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REQUESTED_QUANTITY)
    public Builder setRequestedQuantity(Integer requestedQuantity) {
      this.requestedQuantity = OptionalValue.of(requestedQuantity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SEQUENTIAL)
    public Builder setSequential(Boolean sequential) {
      this.sequential = OptionalValue.of(sequential);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CAPABILITIES)
    public Builder setCapabilities(List<Capability> capabilities) {
      this.capabilities = OptionalValue.of(capabilities);
      return this;
    }

    public CreateQuantityOrderOption build() {
      return new CreateQuantityOrderOptionImpl(
          numberPattern, requestedQuantity, sequential, capabilities);
    }
  }
}
