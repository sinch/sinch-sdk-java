package com.sinch.sdk.domains.voice.models.v2.calls.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class StartCallQueryParametersImpl implements StartCallQueryParameters {

  private final OptionalValue<String> serviceId;

  private StartCallQueryParametersImpl(OptionalValue<String> serviceId) {
    this.serviceId = serviceId;
  }

  public OptionalValue<String> getServiceId() {
    return serviceId;
  }

  /** Return true if this StartCallQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartCallQueryParametersImpl parameters = (StartCallQueryParametersImpl) o;
    return Objects.equals(this.serviceId, parameters.serviceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartCallQueryParametersImpl {\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
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

  static class Builder implements StartCallQueryParameters.Builder {
    OptionalValue<String> serviceId = OptionalValue.empty();

    protected Builder() {}

    protected Builder(StartCallQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      StartCallQueryParametersImpl parameters = (StartCallQueryParametersImpl) _parameters;
      this.serviceId = parameters.getServiceId();
    }

    public Builder setServiceId(String serviceId) {
      this.serviceId = OptionalValue.of(serviceId);
      return this;
    }

    public StartCallQueryParameters build() {
      return new StartCallQueryParametersImpl(serviceId);
    }
  }
}
