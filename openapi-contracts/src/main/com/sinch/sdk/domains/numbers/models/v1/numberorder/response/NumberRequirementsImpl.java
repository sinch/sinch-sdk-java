package com.sinch.sdk.domains.numbers.models.v1.numberorder.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  NumberRequirementsImpl.JSON_PROPERTY_QUANTITY_ORDERS_SUPPORTED,
  NumberRequirementsImpl.JSON_PROPERTY_FIELDS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class NumberRequirementsImpl implements NumberRequirements {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_QUANTITY_ORDERS_SUPPORTED = "quantityOrdersSupported";

  private OptionalValue<Boolean> quantityOrdersSupported;

  public static final String JSON_PROPERTY_FIELDS = "fields";

  private OptionalValue<Map<String, Object>> fields;

  public NumberRequirementsImpl() {}

  protected NumberRequirementsImpl(
      OptionalValue<Boolean> quantityOrdersSupported, OptionalValue<Map<String, Object>> fields) {
    this.quantityOrdersSupported = quantityOrdersSupported;
    this.fields = fields;
  }

  @JsonIgnore
  public Boolean getQuantityOrdersSupported() {
    return quantityOrdersSupported.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_QUANTITY_ORDERS_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> quantityOrdersSupported() {
    return quantityOrdersSupported;
  }

  @JsonIgnore
  public Map<String, Object> getFields() {
    return fields.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FIELDS)
  @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<String, Object>> fields() {
    return fields;
  }

  /** Return true if this NumberRequirements object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NumberRequirementsImpl numberRequirements = (NumberRequirementsImpl) o;
    return Objects.equals(this.quantityOrdersSupported, numberRequirements.quantityOrdersSupported)
        && Objects.equals(this.fields, numberRequirements.fields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quantityOrdersSupported, fields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumberRequirementsImpl {\n");
    sb.append("    quantityOrdersSupported: ")
        .append(toIndentedString(quantityOrdersSupported))
        .append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
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
  static class Builder implements NumberRequirements.Builder {
    OptionalValue<Boolean> quantityOrdersSupported = OptionalValue.empty();
    OptionalValue<Map<String, Object>> fields = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_QUANTITY_ORDERS_SUPPORTED)
    public Builder setQuantityOrdersSupported(Boolean quantityOrdersSupported) {
      this.quantityOrdersSupported = OptionalValue.of(quantityOrdersSupported);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FIELDS)
    public Builder setFields(Map<String, Object> fields) {
      this.fields = OptionalValue.of(fields);
      return this;
    }

    public NumberRequirements build() {
      return new NumberRequirementsImpl(quantityOrdersSupported, fields);
    }
  }
}
