package com.sinch.sdk.domains.voice.models.v2.calls.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.CallReason;
import com.sinch.sdk.domains.voice.models.v2.CallResult;
import com.sinch.sdk.domains.voice.models.v2.CallType;
import java.time.Instant;
import java.util.Objects;

public class ListCallsQueryParametersImpl implements ListCallsQueryParameters {

  private final OptionalValue<String> serviceId;
  private final OptionalValue<String> from;
  private final OptionalValue<String> to;
  private final OptionalValue<CallType> callType;
  private final OptionalValue<Instant> startTime;
  private final OptionalValue<Instant> endTime;
  private final OptionalValue<CallResult> callResult;
  private final OptionalValue<CallReason> callReason;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<Integer> page;

  private ListCallsQueryParametersImpl(
      OptionalValue<String> serviceId,
      OptionalValue<String> from,
      OptionalValue<String> to,
      OptionalValue<CallType> callType,
      OptionalValue<Instant> startTime,
      OptionalValue<Instant> endTime,
      OptionalValue<CallResult> callResult,
      OptionalValue<CallReason> callReason,
      OptionalValue<Integer> pageSize,
      OptionalValue<Integer> page) {
    this.serviceId = serviceId;
    this.from = from;
    this.to = to;
    this.callType = callType;
    this.startTime = startTime;
    this.endTime = endTime;
    this.callResult = callResult;
    this.callReason = callReason;
    this.pageSize = pageSize;
    this.page = page;
  }

  public OptionalValue<String> getServiceId() {
    return serviceId;
  }

  public OptionalValue<String> getFrom() {
    return from;
  }

  public OptionalValue<String> getTo() {
    return to;
  }

  public OptionalValue<CallType> getCallType() {
    return callType;
  }

  public OptionalValue<Instant> getStartTime() {
    return startTime;
  }

  public OptionalValue<Instant> getEndTime() {
    return endTime;
  }

  public OptionalValue<CallResult> getCallResult() {
    return callResult;
  }

  public OptionalValue<CallReason> getCallReason() {
    return callReason;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<Integer> getPage() {
    return page;
  }

  /** Return true if this ListCallsQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListCallsQueryParametersImpl parameters = (ListCallsQueryParametersImpl) o;
    return Objects.equals(this.serviceId, parameters.serviceId)
        && Objects.equals(this.from, parameters.from)
        && Objects.equals(this.to, parameters.to)
        && Objects.equals(this.callType, parameters.callType)
        && Objects.equals(this.startTime, parameters.startTime)
        && Objects.equals(this.endTime, parameters.endTime)
        && Objects.equals(this.callResult, parameters.callResult)
        && Objects.equals(this.callReason, parameters.callReason)
        && Objects.equals(this.pageSize, parameters.pageSize)
        && Objects.equals(this.page, parameters.page);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        serviceId, from, to, callType, startTime, endTime, callResult, callReason, pageSize, page);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListCallsQueryParametersImpl {\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    callType: ").append(toIndentedString(callType)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    callResult: ").append(toIndentedString(callResult)).append("\n");
    sb.append("    callReason: ").append(toIndentedString(callReason)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
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

  static class Builder implements ListCallsQueryParameters.Builder {
    OptionalValue<String> serviceId = OptionalValue.empty();
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<String> to = OptionalValue.empty();
    OptionalValue<CallType> callType = OptionalValue.empty();
    OptionalValue<Instant> startTime = OptionalValue.empty();
    OptionalValue<Instant> endTime = OptionalValue.empty();
    OptionalValue<CallResult> callResult = OptionalValue.empty();
    OptionalValue<CallReason> callReason = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<Integer> page = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ListCallsQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ListCallsQueryParametersImpl parameters = (ListCallsQueryParametersImpl) _parameters;
      this.serviceId = parameters.getServiceId();
      this.from = parameters.getFrom();
      this.to = parameters.getTo();
      this.callType = parameters.getCallType();
      this.startTime = parameters.getStartTime();
      this.endTime = parameters.getEndTime();
      this.callResult = parameters.getCallResult();
      this.callReason = parameters.getCallReason();
      this.pageSize = parameters.getPageSize();
      this.page = parameters.getPage();
    }

    public Builder setServiceId(String serviceId) {
      this.serviceId = OptionalValue.of(serviceId);
      return this;
    }

    public Builder setFrom(String from) {
      this.from = OptionalValue.of(from);
      return this;
    }

    public Builder setTo(String to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    public Builder setCallType(CallType callType) {
      this.callType = OptionalValue.of(callType);
      return this;
    }

    public Builder setStartTime(Instant startTime) {
      this.startTime = OptionalValue.of(startTime);
      return this;
    }

    public Builder setEndTime(Instant endTime) {
      this.endTime = OptionalValue.of(endTime);
      return this;
    }

    public Builder setCallResult(CallResult callResult) {
      this.callResult = OptionalValue.of(callResult);
      return this;
    }

    public Builder setCallReason(CallReason callReason) {
      this.callReason = OptionalValue.of(callReason);
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public Builder setPage(Integer page) {
      this.page = OptionalValue.of(page);
      return this;
    }

    public ListCallsQueryParameters build() {
      return new ListCallsQueryParametersImpl(
          serviceId,
          from,
          to,
          callType,
          startTime,
          endTime,
          callResult,
          callReason,
          pageSize,
          page);
    }
  }
}
