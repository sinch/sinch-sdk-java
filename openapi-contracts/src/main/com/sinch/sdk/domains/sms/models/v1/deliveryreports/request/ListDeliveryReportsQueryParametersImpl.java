package com.sinch.sdk.domains.sms.models.v1.deliveryreports.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryReceiptErrorCode;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryStatus;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class ListDeliveryReportsQueryParametersImpl implements ListDeliveryReportsQueryParameters {

  private final OptionalValue<Integer> page;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<Instant> startDate;
  private final OptionalValue<Instant> endDate;
  private final OptionalValue<List<DeliveryStatus>> status;
  private final OptionalValue<List<DeliveryReceiptErrorCode>> code;
  private final OptionalValue<String> clientReference;

  private ListDeliveryReportsQueryParametersImpl(
      OptionalValue<Integer> page,
      OptionalValue<Integer> pageSize,
      OptionalValue<Instant> startDate,
      OptionalValue<Instant> endDate,
      OptionalValue<List<DeliveryStatus>> status,
      OptionalValue<List<DeliveryReceiptErrorCode>> code,
      OptionalValue<String> clientReference) {
    this.page = page;
    this.pageSize = pageSize;
    this.startDate = startDate;
    this.endDate = endDate;
    this.status = status;
    this.code = code;
    this.clientReference = clientReference;
  }

  public OptionalValue<Integer> getPage() {
    return page;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<Instant> getStartDate() {
    return startDate;
  }

  public OptionalValue<Instant> getEndDate() {
    return endDate;
  }

  public OptionalValue<List<DeliveryStatus>> getStatus() {
    return status;
  }

  public OptionalValue<List<DeliveryReceiptErrorCode>> getCode() {
    return code;
  }

  public OptionalValue<String> getClientReference() {
    return clientReference;
  }

  /** Return true if this GetDeliveryReportsQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListDeliveryReportsQueryParametersImpl getDeliveryReportsQueryParameters =
        (ListDeliveryReportsQueryParametersImpl) o;
    return Objects.equals(this.page, getDeliveryReportsQueryParameters.page)
        && Objects.equals(this.pageSize, getDeliveryReportsQueryParameters.pageSize)
        && Objects.equals(this.startDate, getDeliveryReportsQueryParameters.startDate)
        && Objects.equals(this.endDate, getDeliveryReportsQueryParameters.endDate)
        && Objects.equals(this.status, getDeliveryReportsQueryParameters.status)
        && Objects.equals(this.code, getDeliveryReportsQueryParameters.code)
        && Objects.equals(this.clientReference, getDeliveryReportsQueryParameters.clientReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, pageSize, startDate, endDate, status, code, clientReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListDeliveryReportsQueryParametersImpl {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
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

  static class Builder implements ListDeliveryReportsQueryParameters.Builder {
    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<Instant> startDate = OptionalValue.empty();
    OptionalValue<Instant> endDate = OptionalValue.empty();
    OptionalValue<List<DeliveryStatus>> status = OptionalValue.empty();
    OptionalValue<List<DeliveryReceiptErrorCode>> code = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ListDeliveryReportsQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ListDeliveryReportsQueryParametersImpl parameters =
          (ListDeliveryReportsQueryParametersImpl) _parameters;
      this.page = parameters.getPage();
      this.pageSize = parameters.getPageSize();
      this.startDate = parameters.getStartDate();
      this.endDate = parameters.getEndDate();
      this.status = parameters.getStatus();
      this.code = parameters.getCode();
      this.clientReference = parameters.getClientReference();
    }

    public Builder setPage(Integer page) {
      this.page = OptionalValue.of(page);
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public Builder setStartDate(Instant startDate) {
      this.startDate = OptionalValue.of(startDate);
      return this;
    }

    public Builder setEndDate(Instant endDate) {
      this.endDate = OptionalValue.of(endDate);
      return this;
    }

    public Builder setStatus(List<DeliveryStatus> status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    public Builder setCode(List<DeliveryReceiptErrorCode> code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    public Builder setClientReference(String clientReference) {
      this.clientReference = OptionalValue.of(clientReference);
      return this;
    }

    public ListDeliveryReportsQueryParameters build() {
      return new ListDeliveryReportsQueryParametersImpl(
          page, pageSize, startDate, endDate, status, code, clientReference);
    }
  }
}
