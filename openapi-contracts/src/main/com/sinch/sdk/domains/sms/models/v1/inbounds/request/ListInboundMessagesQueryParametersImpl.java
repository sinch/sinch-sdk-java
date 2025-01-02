package com.sinch.sdk.domains.sms.models.v1.inbounds.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Collection;
import java.util.Objects;

public class ListInboundMessagesQueryParametersImpl implements ListInboundMessagesQueryParameters {

  private final OptionalValue<Integer> page;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<Collection<String>> to;
  private final OptionalValue<Instant> startDate;
  private final OptionalValue<Instant> endDate;
  private final OptionalValue<String> clientReference;

  private ListInboundMessagesQueryParametersImpl(
      OptionalValue<Integer> page,
      OptionalValue<Integer> pageSize,
      OptionalValue<Collection<String>> to,
      OptionalValue<Instant> startDate,
      OptionalValue<Instant> endDate,
      OptionalValue<String> clientReference) {
    this.page = page;
    this.pageSize = pageSize;
    this.to = to;
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

  public OptionalValue<Collection<String>> getTo() {
    return to;
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

  /** Return true if this ListInboundMessagesQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListInboundMessagesQueryParametersImpl listInboundMessagesQueryParameters =
        (ListInboundMessagesQueryParametersImpl) o;
    return Objects.equals(this.page, listInboundMessagesQueryParameters.page)
        && Objects.equals(this.pageSize, listInboundMessagesQueryParameters.pageSize)
        && Objects.equals(this.to, listInboundMessagesQueryParameters.to)
        && Objects.equals(this.startDate, listInboundMessagesQueryParameters.startDate)
        && Objects.equals(this.endDate, listInboundMessagesQueryParameters.endDate)
        && Objects.equals(this.clientReference, listInboundMessagesQueryParameters.clientReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, pageSize, to, startDate, endDate, clientReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListInboundMessagesQueryParametersImpl {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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

  static class Builder implements ListInboundMessagesQueryParameters.Builder {
    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<Collection<String>> to = OptionalValue.empty();
    OptionalValue<Instant> startDate = OptionalValue.empty();
    OptionalValue<Instant> endDate = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ListInboundMessagesQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ListInboundMessagesQueryParametersImpl parameters =
          (ListInboundMessagesQueryParametersImpl) _parameters;
      this.page = parameters.getPage();
      this.pageSize = parameters.getPageSize();
      this.to = parameters.getTo();
      this.startDate = parameters.getStartDate();
      this.endDate = parameters.getEndDate();
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

    public Builder setTo(Collection<String> to) {
      this.to = OptionalValue.of(to);
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

    public ListInboundMessagesQueryParameters build() {
      return new ListInboundMessagesQueryParametersImpl(
          page, pageSize, to, startDate, endDate, clientReference);
    }
  }
}
