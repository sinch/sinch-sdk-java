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
  BinaryRequestImpl.JSON_PROPERTY_TO,
  BinaryRequestImpl.JSON_PROPERTY_FROM,
  BinaryRequestImpl.JSON_PROPERTY_BODY,
  BinaryRequestImpl.JSON_PROPERTY_UDH,
  BinaryRequestImpl.JSON_PROPERTY_TYPE,
  BinaryRequestImpl.JSON_PROPERTY_DELIVERY_REPORT,
  BinaryRequestImpl.JSON_PROPERTY_SEND_AT,
  BinaryRequestImpl.JSON_PROPERTY_EXPIRE_AT,
  BinaryRequestImpl.JSON_PROPERTY_CALLBACK_URL,
  BinaryRequestImpl.JSON_PROPERTY_CLIENT_REFERENCE,
  BinaryRequestImpl.JSON_PROPERTY_FEEDBACK_ENABLED,
  BinaryRequestImpl.JSON_PROPERTY_FROM_TON,
  BinaryRequestImpl.JSON_PROPERTY_FROM_NPI
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class BinaryRequestImpl implements BinaryRequest, BatchRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TO = "to";

  private OptionalValue<List<String>> to;

  public static final String JSON_PROPERTY_FROM = "from";

  private OptionalValue<String> from;

  public static final String JSON_PROPERTY_BODY = "body";

  private OptionalValue<String> body;

  public static final String JSON_PROPERTY_UDH = "udh";

  private OptionalValue<String> udh;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

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

  public static final String JSON_PROPERTY_FROM_TON = "from_ton";

  private OptionalValue<Integer> fromTon;

  public static final String JSON_PROPERTY_FROM_NPI = "from_npi";

  private OptionalValue<Integer> fromNpi;

  public BinaryRequestImpl() {}

  protected BinaryRequestImpl(
      OptionalValue<List<String>> to,
      OptionalValue<String> from,
      OptionalValue<String> body,
      OptionalValue<String> udh,
      OptionalValue<TypeEnum> type,
      OptionalValue<DeliveryReportType> deliveryReport,
      OptionalValue<Instant> sendAt,
      OptionalValue<Instant> expireAt,
      OptionalValue<String> callbackUrl,
      OptionalValue<String> clientReference,
      OptionalValue<Boolean> feedbackEnabled,
      OptionalValue<Integer> fromTon,
      OptionalValue<Integer> fromNpi) {
    this.to = to;
    this.from = from;
    this.body = body;
    this.udh = udh;
    this.type = type;
    this.deliveryReport = deliveryReport;
    this.sendAt = sendAt;
    this.expireAt = expireAt;
    this.callbackUrl = callbackUrl;
    this.clientReference = clientReference;
    this.feedbackEnabled = feedbackEnabled;
    this.fromTon = fromTon;
    this.fromNpi = fromNpi;
  }

  @JsonIgnore
  public List<String> getTo() {
    return to.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<String>> to() {
    return to;
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
  public String getBody() {
    return body.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> body() {
    return body;
  }

  @JsonIgnore
  public String getUdh() {
    return udh.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UDH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> udh() {
    return udh;
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

  /** Return true if this Binary object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BinaryRequestImpl binary = (BinaryRequestImpl) o;
    return Objects.equals(this.to, binary.to)
        && Objects.equals(this.from, binary.from)
        && Objects.equals(this.body, binary.body)
        && Objects.equals(this.udh, binary.udh)
        && Objects.equals(this.type, binary.type)
        && Objects.equals(this.deliveryReport, binary.deliveryReport)
        && Objects.equals(this.sendAt, binary.sendAt)
        && Objects.equals(this.expireAt, binary.expireAt)
        && Objects.equals(this.callbackUrl, binary.callbackUrl)
        && Objects.equals(this.clientReference, binary.clientReference)
        && Objects.equals(this.feedbackEnabled, binary.feedbackEnabled)
        && Objects.equals(this.fromTon, binary.fromTon)
        && Objects.equals(this.fromNpi, binary.fromNpi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        to,
        from,
        body,
        udh,
        type,
        deliveryReport,
        sendAt,
        expireAt,
        callbackUrl,
        clientReference,
        feedbackEnabled,
        fromTon,
        fromNpi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BinaryRequestImpl {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    udh: ").append(toIndentedString(udh)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    deliveryReport: ").append(toIndentedString(deliveryReport)).append("\n");
    sb.append("    sendAt: ").append(toIndentedString(sendAt)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
    sb.append("    feedbackEnabled: ").append(toIndentedString(feedbackEnabled)).append("\n");
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
  static class Builder implements BinaryRequest.Builder {
    OptionalValue<List<String>> to = OptionalValue.empty();
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<String> body = OptionalValue.empty();
    OptionalValue<String> udh = OptionalValue.empty();
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.MT_BINARY);
    OptionalValue<DeliveryReportType> deliveryReport = OptionalValue.empty();
    OptionalValue<Instant> sendAt = OptionalValue.empty();
    OptionalValue<Instant> expireAt = OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();
    OptionalValue<Boolean> feedbackEnabled = OptionalValue.empty();
    OptionalValue<Integer> fromTon = OptionalValue.empty();
    OptionalValue<Integer> fromNpi = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TO)
    public Builder setTo(List<String> to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FROM)
    public Builder setFrom(String from) {
      this.from = OptionalValue.of(from);
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

    public BinaryRequest build() {
      return new BinaryRequestImpl(
          to,
          from,
          body,
          udh,
          type,
          deliveryReport,
          sendAt,
          expireAt,
          callbackUrl,
          clientReference,
          feedbackEnabled,
          fromTon,
          fromNpi);
    }
  }
}
