package com.sinch.sdk.domains.sms.models.v1.batches.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class ListBatchesQueryParametersImpl implements ListBatchesQueryParameters {

  private final OptionalValue<Integer> page;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<List<String>> from;
  private final OptionalValue<Instant> startDate;
  private final OptionalValue<Instant> endDate;
  private final OptionalValue<String> clientReference;

  private ListBatchesQueryParametersImpl(
      OptionalValue<Integer> page,
      OptionalValue<Integer> pageSize,
      OptionalValue<List<String>> from,
      OptionalValue<Instant> startDate,
      OptionalValue<Instant> endDate,
      OptionalValue<String> clientReference) {
    this.page = page;
    this.pageSize = pageSize;
    this.from = from;
    this.startDate = startDate;
    this.endDate = endDate;
    this.clientReference = clientReference;
  }

  public OptionalValue<Integer> getPage() {
    return page;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<List<String>> getFrom() {
    return from;
  }

  public OptionalValue<Instant> getStartDate() {
    return startDate;
  }

  public OptionalValue<Instant> getEndDate() {
    return endDate;
  }

  public OptionalValue<String> getClientReference() {
    return clientReference;
  }

  /** Return true if this ListBatchesQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListBatchesQueryParametersImpl listBatchesQueryParameters = (ListBatchesQueryParametersImpl) o;
    return Objects.equals(this.page, listBatchesQueryParameters.page)
        && Objects.equals(this.pageSize, listBatchesQueryParameters.pageSize)
        && Objects.equals(this.from, listBatchesQueryParameters.from)
        && Objects.equals(this.startDate, listBatchesQueryParameters.startDate)
        && Objects.equals(this.endDate, listBatchesQueryParameters.endDate)
        && Objects.equals(this.clientReference, listBatchesQueryParameters.clientReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, pageSize, from, startDate, endDate, clientReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListBatchesQueryParametersImpl {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

  static class Builder implements ListBatchesQueryParameters.Builder {
    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<List<String>> from = OptionalValue.empty();
    OptionalValue<Instant> startDate = OptionalValue.empty();
    OptionalValue<Instant> endDate = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ListBatchesQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ListBatchesQueryParametersImpl parameters = (ListBatchesQueryParametersImpl) _parameters;
      this.page = parameters.getPage();
      this.pageSize = parameters.getPageSize();
      this.from = parameters.getFrom();
      this.startDate = parameters.getStartDate();
      this.endDate = parameters.getEndDate();
      this.clientReference = parameters.getClientReference();
    }

    public Builder setFrom(String from) {
      setFrom(java.util.Collections.singletonList(from));
      return this;
    }

    public Builder setPage(Integer page) {
      this.page = OptionalValue.of(page);
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public Builder setFrom(List<String> from) {
      this.from = OptionalValue.of(from);
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

    public Builder setClientReference(String clientReference) {
      this.clientReference = OptionalValue.of(clientReference);
      return this;
    }

    public ListBatchesQueryParameters build() {
      return new ListBatchesQueryParametersImpl(
          page, pageSize, from, startDate, endDate, clientReference);
    }
  }
}
