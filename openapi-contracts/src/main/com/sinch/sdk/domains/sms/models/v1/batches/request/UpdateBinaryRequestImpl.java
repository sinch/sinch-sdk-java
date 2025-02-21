package com.sinch.sdk.domains.sms.models.v1.batches.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.v1.batches.DeliveryReportType;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  UpdateBinaryRequestImpl.JSON_PROPERTY_FROM,
  UpdateBinaryRequestImpl.JSON_PROPERTY_TYPE,
  UpdateBinaryRequestImpl.JSON_PROPERTY_TO_ADD,
  UpdateBinaryRequestImpl.JSON_PROPERTY_TO_REMOVE,
  UpdateBinaryRequestImpl.JSON_PROPERTY_DELIVERY_REPORT,
  UpdateBinaryRequestImpl.JSON_PROPERTY_SEND_AT,
  UpdateBinaryRequestImpl.JSON_PROPERTY_EXPIRE_AT,
  UpdateBinaryRequestImpl.JSON_PROPERTY_CALLBACK_URL,
  UpdateBinaryRequestImpl.JSON_PROPERTY_CLIENT_REFERENCE,
  UpdateBinaryRequestImpl.JSON_PROPERTY_FEEDBACK_ENABLED,
  UpdateBinaryRequestImpl.JSON_PROPERTY_BODY,
  UpdateBinaryRequestImpl.JSON_PROPERTY_UDH,
  UpdateBinaryRequestImpl.JSON_PROPERTY_FROM_TON,
  UpdateBinaryRequestImpl.JSON_PROPERTY_FROM_NPI
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UpdateBinaryRequestImpl implements UpdateBinaryRequest, UpdateBatchRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_FROM = "from";

  private OptionalValue<String> from;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_TO_ADD = "to_add";

  private OptionalValue<List<String>> toAdd;

  public static final String JSON_PROPERTY_TO_REMOVE = "to_remove";

  private OptionalValue<List<String>> toRemove;

  public static final String JSON_PROPERTY_DELIVERY_REPORT = "delivery_report";

  private OptionalValue<DeliveryReportType> deliveryReport;

  public static final String JSON_PROPERTY_SEND_AT = "send_at";

  private OptionalValue<Instant> sendAt;

  public static final String JSON_PROPERTY_EXPIRE_AT = "expire_at";

  private OptionalValue<Instant> expireAt;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callback_url";

  private OptionalValue<String> callbackUrl;

  public static final String JSON_PROPERTY_CLIENT_REFERENCE = "client_reference";

  private OptionalValue<String> clientReference;

  public static final String JSON_PROPERTY_FEEDBACK_ENABLED = "feedback_enabled";

  private OptionalValue<Boolean> feedbackEnabled;

  public static final String JSON_PROPERTY_BODY = "body";

  private OptionalValue<String> body;

  public static final String JSON_PROPERTY_UDH = "udh";

  private OptionalValue<String> udh;

  public static final String JSON_PROPERTY_FROM_TON = "from_ton";

  private OptionalValue<Integer> fromTon;

  public static final String JSON_PROPERTY_FROM_NPI = "from_npi";

  private OptionalValue<Integer> fromNpi;

  public UpdateBinaryRequestImpl() {}

  protected UpdateBinaryRequestImpl(
      OptionalValue<String> from,
      OptionalValue<TypeEnum> type,
      OptionalValue<List<String>> toAdd,
      OptionalValue<List<String>> toRemove,
      OptionalValue<DeliveryReportType> deliveryReport,
      OptionalValue<Instant> sendAt,
      OptionalValue<Instant> expireAt,
      OptionalValue<String> callbackUrl,
      OptionalValue<String> clientReference,
      OptionalValue<Boolean> feedbackEnabled,
      OptionalValue<String> body,
      OptionalValue<String> udh,
      OptionalValue<Integer> fromTon,
      OptionalValue<Integer> fromNpi) {
    this.from = from;
    this.type = type;
    this.toAdd = toAdd;
    this.toRemove = toRemove;
    this.deliveryReport = deliveryReport;
    this.sendAt = sendAt;
    this.expireAt = expireAt;
    this.callbackUrl = callbackUrl;
    this.clientReference = clientReference;
    this.feedbackEnabled = feedbackEnabled;
    this.body = body;
    this.udh = udh;
    this.fromTon = fromTon;
    this.fromNpi = fromNpi;
  }

  @JsonIgnore
  public String getFrom() {
    return from.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> from() {
    return from;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public List<String> getToAdd() {
    return toAdd.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO_ADD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> toAdd() {
    return toAdd;
  }

  @JsonIgnore
  public List<String> getToRemove() {
    return toRemove.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO_REMOVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> toRemove() {
    return toRemove;
  }

  @JsonIgnore
  public DeliveryReportType getDeliveryReport() {
    return deliveryReport.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DELIVERY_REPORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DeliveryReportType> deliveryReport() {
    return deliveryReport;
  }

  @JsonIgnore
  public Instant getSendAt() {
    return sendAt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SEND_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> sendAt() {
    return sendAt;
  }

  @JsonIgnore
  public Instant getExpireAt() {
    return expireAt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXPIRE_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> expireAt() {
    return expireAt;
  }

  @JsonIgnore
  public String getCallbackUrl() {
    return callbackUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callbackUrl() {
    return callbackUrl;
  }

  @JsonIgnore
  public String getClientReference() {
    return clientReference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> clientReference() {
    return clientReference;
  }

  @JsonIgnore
  public Boolean getFeedbackEnabled() {
    return feedbackEnabled.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FEEDBACK_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> feedbackEnabled() {
    return feedbackEnabled;
  }

  @JsonIgnore
  public String getBody() {
    return body.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> body() {
    return body;
  }

  @JsonIgnore
  public String getUdh() {
    return udh.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UDH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> udh() {
    return udh;
  }

  @JsonIgnore
  public Integer getFromTon() {
    return fromTon.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FROM_TON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> fromTon() {
    return fromTon;
  }

  @JsonIgnore
  public Integer getFromNpi() {
    return fromNpi.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FROM_NPI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> fromNpi() {
    return fromNpi;
  }

  /** Return true if this update_binary_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateBinaryRequestImpl updateBinaryMessage = (UpdateBinaryRequestImpl) o;
    return Objects.equals(this.from, updateBinaryMessage.from)
        && Objects.equals(this.type, updateBinaryMessage.type)
        && Objects.equals(this.toAdd, updateBinaryMessage.toAdd)
        && Objects.equals(this.toRemove, updateBinaryMessage.toRemove)
        && Objects.equals(this.deliveryReport, updateBinaryMessage.deliveryReport)
        && Objects.equals(this.sendAt, updateBinaryMessage.sendAt)
        && Objects.equals(this.expireAt, updateBinaryMessage.expireAt)
        && Objects.equals(this.callbackUrl, updateBinaryMessage.callbackUrl)
        && Objects.equals(this.clientReference, updateBinaryMessage.clientReference)
        && Objects.equals(this.feedbackEnabled, updateBinaryMessage.feedbackEnabled)
        && Objects.equals(this.body, updateBinaryMessage.body)
        && Objects.equals(this.udh, updateBinaryMessage.udh)
        && Objects.equals(this.fromTon, updateBinaryMessage.fromTon)
        && Objects.equals(this.fromNpi, updateBinaryMessage.fromNpi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        from,
        type,
        toAdd,
        toRemove,
        deliveryReport,
        sendAt,
        expireAt,
        callbackUrl,
        clientReference,
        feedbackEnabled,
        body,
        udh,
        fromTon,
        fromNpi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateBinaryRequestImpl {\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    toAdd: ").append(toIndentedString(toAdd)).append("\n");
    sb.append("    toRemove: ").append(toIndentedString(toRemove)).append("\n");
    sb.append("    deliveryReport: ").append(toIndentedString(deliveryReport)).append("\n");
    sb.append("    sendAt: ").append(toIndentedString(sendAt)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
    sb.append("    feedbackEnabled: ").append(toIndentedString(feedbackEnabled)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    udh: ").append(toIndentedString(udh)).append("\n");
    sb.append("    fromTon: ").append(toIndentedString(fromTon)).append("\n");
    sb.append("    fromNpi: ").append(toIndentedString(fromNpi)).append("\n");
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
  static class Builder implements UpdateBinaryRequest.Builder {
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.MT_BINARY);
    OptionalValue<List<String>> toAdd = OptionalValue.empty();
    OptionalValue<List<String>> toRemove = OptionalValue.empty();
    OptionalValue<DeliveryReportType> deliveryReport = OptionalValue.empty();
    OptionalValue<Instant> sendAt = OptionalValue.empty();
    OptionalValue<Instant> expireAt = OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();
    OptionalValue<Boolean> feedbackEnabled = OptionalValue.empty();
    OptionalValue<String> body = OptionalValue.empty();
    OptionalValue<String> udh = OptionalValue.empty();
    OptionalValue<Integer> fromTon = OptionalValue.empty();
    OptionalValue<Integer> fromNpi = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_FROM)
    public Builder setFrom(String from) {
      this.from = OptionalValue.of(from);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TO_ADD)
    public Builder setToAdd(List<String> toAdd) {
      this.toAdd = OptionalValue.of(toAdd);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TO_REMOVE)
    public Builder setToRemove(List<String> toRemove) {
      this.toRemove = OptionalValue.of(toRemove);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DELIVERY_REPORT)
    public Builder setDeliveryReport(DeliveryReportType deliveryReport) {
      this.deliveryReport = OptionalValue.of(deliveryReport);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SEND_AT)
    public Builder setSendAt(Instant sendAt) {
      this.sendAt = OptionalValue.of(sendAt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EXPIRE_AT)
    public Builder setExpireAt(Instant expireAt) {
      this.expireAt = OptionalValue.of(expireAt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
    public Builder setCallbackUrl(String callbackUrl) {
      this.callbackUrl = OptionalValue.of(callbackUrl);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
    public Builder setClientReference(String clientReference) {
      this.clientReference = OptionalValue.of(clientReference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FEEDBACK_ENABLED)
    public Builder setFeedbackEnabled(Boolean feedbackEnabled) {
      this.feedbackEnabled = OptionalValue.of(feedbackEnabled);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BODY)
    public Builder setBody(String body) {
      this.body = OptionalValue.of(body);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_UDH)
    public Builder setUdh(String udh) {
      this.udh = OptionalValue.of(udh);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FROM_TON)
    public Builder setFromTon(Integer fromTon) {
      this.fromTon = OptionalValue.of(fromTon);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FROM_NPI)
    public Builder setFromNpi(Integer fromNpi) {
      this.fromNpi = OptionalValue.of(fromNpi);
      return this;
    }

    public UpdateBinaryRequest build() {
      return new UpdateBinaryRequestImpl(
          from,
          type,
          toAdd,
          toRemove,
          deliveryReport,
          sendAt,
          expireAt,
          callbackUrl,
          clientReference,
          feedbackEnabled,
          body,
          udh,
          fromTon,
          fromNpi);
    }
  }
}
