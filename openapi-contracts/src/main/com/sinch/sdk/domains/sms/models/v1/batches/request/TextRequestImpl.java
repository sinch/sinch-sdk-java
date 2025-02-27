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
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  TextRequestImpl.JSON_PROPERTY_TO,
  TextRequestImpl.JSON_PROPERTY_FROM,
  TextRequestImpl.JSON_PROPERTY_PARAMETERS,
  TextRequestImpl.JSON_PROPERTY_BODY,
  TextRequestImpl.JSON_PROPERTY_TYPE,
  TextRequestImpl.JSON_PROPERTY_DELIVERY_REPORT,
  TextRequestImpl.JSON_PROPERTY_SEND_AT,
  TextRequestImpl.JSON_PROPERTY_EXPIRE_AT,
  TextRequestImpl.JSON_PROPERTY_CALLBACK_URL,
  TextRequestImpl.JSON_PROPERTY_CLIENT_REFERENCE,
  TextRequestImpl.JSON_PROPERTY_FEEDBACK_ENABLED,
  TextRequestImpl.JSON_PROPERTY_FLASH_MESSAGE,
  TextRequestImpl.JSON_PROPERTY_TRUNCATE_CONCAT,
  TextRequestImpl.JSON_PROPERTY_MAX_NUMBER_OF_MESSAGE_PARTS,
  TextRequestImpl.JSON_PROPERTY_FROM_TON,
  TextRequestImpl.JSON_PROPERTY_FROM_NPI
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TextRequestImpl implements TextRequest, BatchRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TO = "to";

  private OptionalValue<List<String>> to;

  public static final String JSON_PROPERTY_FROM = "from";

  private OptionalValue<String> from;

  public static final String JSON_PROPERTY_PARAMETERS = "parameters";

  private OptionalValue<Map<String, Map<String, String>>> parameters;

  public static final String JSON_PROPERTY_BODY = "body";

  private OptionalValue<String> body;

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

  public static final String JSON_PROPERTY_FLASH_MESSAGE = "flash_message";

  private OptionalValue<Boolean> flashMessage;

  public static final String JSON_PROPERTY_TRUNCATE_CONCAT = "truncate_concat";

  private OptionalValue<Boolean> truncateConcat;

  public static final String JSON_PROPERTY_MAX_NUMBER_OF_MESSAGE_PARTS =
      "max_number_of_message_parts";

  private OptionalValue<Integer> maxNumberOfMessageParts;

  public static final String JSON_PROPERTY_FROM_TON = "from_ton";

  private OptionalValue<Integer> fromTon;

  public static final String JSON_PROPERTY_FROM_NPI = "from_npi";

  private OptionalValue<Integer> fromNpi;

  public TextRequestImpl() {}

  protected TextRequestImpl(
      OptionalValue<List<String>> to,
      OptionalValue<String> from,
      OptionalValue<Map<String, Map<String, String>>> parameters,
      OptionalValue<String> body,
      OptionalValue<TypeEnum> type,
      OptionalValue<DeliveryReportType> deliveryReport,
      OptionalValue<Instant> sendAt,
      OptionalValue<Instant> expireAt,
      OptionalValue<String> callbackUrl,
      OptionalValue<String> clientReference,
      OptionalValue<Boolean> feedbackEnabled,
      OptionalValue<Boolean> flashMessage,
      OptionalValue<Boolean> truncateConcat,
      OptionalValue<Integer> maxNumberOfMessageParts,
      OptionalValue<Integer> fromTon,
      OptionalValue<Integer> fromNpi) {
    this.to = to;
    this.from = from;
    this.parameters = parameters;
    this.body = body;
    this.type = type;
    this.deliveryReport = deliveryReport;
    this.sendAt = sendAt;
    this.expireAt = expireAt;
    this.callbackUrl = callbackUrl;
    this.clientReference = clientReference;
    this.feedbackEnabled = feedbackEnabled;
    this.flashMessage = flashMessage;
    this.truncateConcat = truncateConcat;
    this.maxNumberOfMessageParts = maxNumberOfMessageParts;
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
  public Map<String, Map<String, String>> getParameters() {
    return parameters.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<String, Map<String, String>>> parameters() {
    return parameters;
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
  public Boolean getFlashMessage() {
    return flashMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLASH_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> flashMessage() {
    return flashMessage;
  }

  @JsonIgnore
  public Boolean getTruncateConcat() {
    return truncateConcat.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRUNCATE_CONCAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> truncateConcat() {
    return truncateConcat;
  }

  @JsonIgnore
  public Integer getMaxNumberOfMessageParts() {
    return maxNumberOfMessageParts.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAX_NUMBER_OF_MESSAGE_PARTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> maxNumberOfMessageParts() {
    return maxNumberOfMessageParts;
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

  /** Return true if this Text object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TextRequestImpl text = (TextRequestImpl) o;
    return Objects.equals(this.to, text.to)
        && Objects.equals(this.from, text.from)
        && Objects.equals(this.parameters, text.parameters)
        && Objects.equals(this.body, text.body)
        && Objects.equals(this.type, text.type)
        && Objects.equals(this.deliveryReport, text.deliveryReport)
        && Objects.equals(this.sendAt, text.sendAt)
        && Objects.equals(this.expireAt, text.expireAt)
        && Objects.equals(this.callbackUrl, text.callbackUrl)
        && Objects.equals(this.clientReference, text.clientReference)
        && Objects.equals(this.feedbackEnabled, text.feedbackEnabled)
        && Objects.equals(this.flashMessage, text.flashMessage)
        && Objects.equals(this.truncateConcat, text.truncateConcat)
        && Objects.equals(this.maxNumberOfMessageParts, text.maxNumberOfMessageParts)
        && Objects.equals(this.fromTon, text.fromTon)
        && Objects.equals(this.fromNpi, text.fromNpi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        to,
        from,
        parameters,
        body,
        type,
        deliveryReport,
        sendAt,
        expireAt,
        callbackUrl,
        clientReference,
        feedbackEnabled,
        flashMessage,
        truncateConcat,
        maxNumberOfMessageParts,
        fromTon,
        fromNpi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TextRequestImpl {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    deliveryReport: ").append(toIndentedString(deliveryReport)).append("\n");
    sb.append("    sendAt: ").append(toIndentedString(sendAt)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
    sb.append("    feedbackEnabled: ").append(toIndentedString(feedbackEnabled)).append("\n");
    sb.append("    flashMessage: ").append(toIndentedString(flashMessage)).append("\n");
    sb.append("    truncateConcat: ").append(toIndentedString(truncateConcat)).append("\n");
    sb.append("    maxNumberOfMessageParts: ")
        .append(toIndentedString(maxNumberOfMessageParts))
        .append("\n");
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
  static class Builder implements TextRequest.Builder {
    OptionalValue<List<String>> to = OptionalValue.empty();
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<Map<String, Map<String, String>>> parameters = OptionalValue.empty();
    OptionalValue<String> body = OptionalValue.empty();
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.MT_TEXT);
    OptionalValue<DeliveryReportType> deliveryReport = OptionalValue.empty();
    OptionalValue<Instant> sendAt = OptionalValue.empty();
    OptionalValue<Instant> expireAt = OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();
    OptionalValue<Boolean> feedbackEnabled = OptionalValue.empty();
    OptionalValue<Boolean> flashMessage = OptionalValue.empty();
    OptionalValue<Boolean> truncateConcat = OptionalValue.empty();
    OptionalValue<Integer> maxNumberOfMessageParts = OptionalValue.empty();
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

    @JsonProperty(JSON_PROPERTY_PARAMETERS)
    public Builder setParameters(Map<String, Map<String, String>> parameters) {
      this.parameters = OptionalValue.of(parameters);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BODY)
    public Builder setBody(String body) {
      this.body = OptionalValue.of(body);
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

    @JsonProperty(JSON_PROPERTY_FLASH_MESSAGE)
    public Builder setFlashMessage(Boolean flashMessage) {
      this.flashMessage = OptionalValue.of(flashMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TRUNCATE_CONCAT)
    public Builder setTruncateConcat(Boolean truncateConcat) {
      this.truncateConcat = OptionalValue.of(truncateConcat);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAX_NUMBER_OF_MESSAGE_PARTS)
    public Builder setMaxNumberOfMessageParts(Integer maxNumberOfMessageParts) {
      this.maxNumberOfMessageParts = OptionalValue.of(maxNumberOfMessageParts);
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

    public TextRequest build() {
      return new TextRequestImpl(
          to,
          from,
          parameters,
          body,
          type,
          deliveryReport,
          sendAt,
          expireAt,
          callbackUrl,
          clientReference,
          feedbackEnabled,
          flashMessage,
          truncateConcat,
          maxNumberOfMessageParts,
          fromTon,
          fromNpi);
    }
  }
}
