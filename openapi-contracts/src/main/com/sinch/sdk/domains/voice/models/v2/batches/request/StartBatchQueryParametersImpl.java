package com.sinch.sdk.domains.voice.models.v2.batches.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class StartBatchQueryParametersImpl implements StartBatchQueryParameters {

  private final OptionalValue<String> serviceId;

  private StartBatchQueryParametersImpl(OptionalValue<String> serviceId) {
    this.serviceId = serviceId;
  }

  public OptionalValue<String> getServiceId() {
    return serviceId;
  }

  /** Return true if this StartBatchQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartBatchQueryParametersImpl parameters = (StartBatchQueryParametersImpl) o;
    return Objects.equals(this.serviceId, parameters.serviceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartBatchQueryParametersImpl {\n");
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

  static class Builder implements StartBatchQueryParameters.Builder {
    OptionalValue<String> serviceId = OptionalValue.empty();

    protected Builder() {}

    protected Builder(StartBatchQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      StartBatchQueryParametersImpl parameters = (StartBatchQueryParametersImpl) _parameters;
      this.serviceId = parameters.getServiceId();
    }

    public Builder setServiceId(String serviceId) {
      this.serviceId = OptionalValue.of(serviceId);
      return this;
    }

    public StartBatchQueryParameters build() {
      return new StartBatchQueryParametersImpl(serviceId);
    }
  }
}
