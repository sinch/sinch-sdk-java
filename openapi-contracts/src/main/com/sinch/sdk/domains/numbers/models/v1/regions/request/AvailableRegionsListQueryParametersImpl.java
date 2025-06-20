package com.sinch.sdk.domains.numbers.models.v1.regions.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import java.util.List;
import java.util.Objects;

public class AvailableRegionsListQueryParametersImpl
    implements AvailableRegionsListQueryParameters {

  private final OptionalValue<List<NumberType>> types;

  private AvailableRegionsListQueryParametersImpl(OptionalValue<List<NumberType>> types) {
    this.types = types;
  }

  public OptionalValue<List<NumberType>> getTypes() {
    return types;
  }

  /** Return true if this NumberServiceListAvailableRegionsQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableRegionsListQueryParametersImpl numberServiceListAvailableRegionsQueryParameters =
        (AvailableRegionsListQueryParametersImpl) o;
    return Objects.equals(this.types, numberServiceListAvailableRegionsQueryParameters.types);
  }

  @Override
  public int hashCode() {
    return Objects.hash(types);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableRegionsListQueryParametersImpl {\n");
    sb.append("    types: ").append(toIndentedString(types)).append("\n");
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

  static class Builder implements AvailableRegionsListQueryParameters.Builder {
    OptionalValue<List<NumberType>> types = OptionalValue.empty();

    protected Builder() {}

    protected Builder(AvailableRegionsListQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      AvailableRegionsListQueryParametersImpl parameters =
          (AvailableRegionsListQueryParametersImpl) _parameters;
      this.types = parameters.getTypes();
    }

    public Builder setTypes(List<NumberType> types) {
      this.types = OptionalValue.of(types);
      return this;
    }

    public AvailableRegionsListQueryParameters build() {
      return new AvailableRegionsListQueryParametersImpl(types);
    }
  }
}
