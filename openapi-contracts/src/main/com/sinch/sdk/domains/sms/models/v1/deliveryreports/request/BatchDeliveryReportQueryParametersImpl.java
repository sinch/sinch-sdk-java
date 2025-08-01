package com.sinch.sdk.domains.sms.models.v1.deliveryreports.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryReceiptStatusCode;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryStatus;
import java.util.List;
import java.util.Objects;

public class BatchDeliveryReportQueryParametersImpl implements BatchDeliveryReportQueryParameters {

  private final OptionalValue<QueryReportType> type;
  private final OptionalValue<List<DeliveryStatus>> status;
  private final OptionalValue<List<DeliveryReceiptStatusCode>> code;

  private BatchDeliveryReportQueryParametersImpl(
      OptionalValue<QueryReportType> type,
      OptionalValue<List<DeliveryStatus>> status,
      OptionalValue<List<DeliveryReceiptStatusCode>> code) {
    this.type = type;
    this.status = status;
    this.code = code;
  }

  public OptionalValue<QueryReportType> getType() {
    return type;
  }

  public OptionalValue<List<DeliveryStatus>> getStatus() {
    return status;
  }

  public OptionalValue<List<DeliveryReceiptStatusCode>> getCode() {
    return code;
  }

  /** Return true if this GetDeliveryReportByBatchIdQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchDeliveryReportQueryParametersImpl getDeliveryReportByBatchIdQueryParameters =
        (BatchDeliveryReportQueryParametersImpl) o;
    return Objects.equals(this.type, getDeliveryReportByBatchIdQueryParameters.type)
        && Objects.equals(this.status, getDeliveryReportByBatchIdQueryParameters.status)
        && Objects.equals(this.code, getDeliveryReportByBatchIdQueryParameters.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, status, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchDeliveryReportQueryParametersImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

  static class Builder implements BatchDeliveryReportQueryParameters.Builder {
    OptionalValue<QueryReportType> type = OptionalValue.empty();
    OptionalValue<List<DeliveryStatus>> status = OptionalValue.empty();
    OptionalValue<List<DeliveryReceiptStatusCode>> code = OptionalValue.empty();

    protected Builder() {}

    protected Builder(BatchDeliveryReportQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      BatchDeliveryReportQueryParametersImpl parameters =
          (BatchDeliveryReportQueryParametersImpl) _parameters;
      this.type = parameters.getType();
      this.status = parameters.getStatus();
      this.code = parameters.getCode();
    }

    public Builder setType(QueryReportType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    public Builder setStatus(List<DeliveryStatus> status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    public Builder setCode(List<DeliveryReceiptStatusCode> code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    public BatchDeliveryReportQueryParameters build() {
      return new BatchDeliveryReportQueryParametersImpl(type, status, code);
    }
  }
}
