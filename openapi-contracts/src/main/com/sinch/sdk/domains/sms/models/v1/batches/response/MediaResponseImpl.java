package com.sinch.sdk.domains.sms.models.v1.batches.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.v1.batches.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.v1.batches.MediaBody;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  MediaResponseImpl.JSON_PROPERTY_ID,
  MediaResponseImpl.JSON_PROPERTY_TO,
  MediaResponseImpl.JSON_PROPERTY_FROM,
  MediaResponseImpl.JSON_PROPERTY_CANCELED,
  MediaResponseImpl.JSON_PROPERTY_BODY,
  MediaResponseImpl.JSON_PROPERTY_PARAMETERS,
  MediaResponseImpl.JSON_PROPERTY_TYPE,
  MediaResponseImpl.JSON_PROPERTY_CREATED_AT,
  MediaResponseImpl.JSON_PROPERTY_MODIFIED_AT,
  MediaResponseImpl.JSON_PROPERTY_DELIVERY_REPORT,
  MediaResponseImpl.JSON_PROPERTY_SEND_AT,
  MediaResponseImpl.JSON_PROPERTY_EXPIRE_AT,
  MediaResponseImpl.JSON_PROPERTY_CALLBACK_URL,
  MediaResponseImpl.JSON_PROPERTY_CLIENT_REFERENCE,
  MediaResponseImpl.JSON_PROPERTY_FEEDBACK_ENABLED,
  MediaResponseImpl.JSON_PROPERTY_STRICT_VALIDATION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaResponseImpl implements MediaResponse, BatchResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_TO = "to";

  private OptionalValue<List<String>> to;

  public static final String JSON_PROPERTY_FROM = "from";

  private OptionalValue<String> from;

  public static final String JSON_PROPERTY_CANCELED = "canceled";

  private OptionalValue<Boolean> canceled;

  public static final String JSON_PROPERTY_BODY = "body";

  private OptionalValue<MediaBody> body;

  public static final String JSON_PROPERTY_PARAMETERS = "parameters";

  private OptionalValue<Map<String, Map<String, String>>> parameters;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";

  private OptionalValue<Instant> createdAt;

  public static final String JSON_PROPERTY_MODIFIED_AT = "modified_at";

  private OptionalValue<Instant> modifiedAt;

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

  public static final String JSON_PROPERTY_STRICT_VALIDATION = "strict_validation";

  private OptionalValue<Boolean> strictValidation;

  public MediaResponseImpl() {}

  protected MediaResponseImpl(
      OptionalValue<String> id,
      OptionalValue<List<String>> to,
      OptionalValue<String> from,
      OptionalValue<Boolean> canceled,
      OptionalValue<MediaBody> body,
      OptionalValue<Map<String, Map<String, String>>> parameters,
      OptionalValue<TypeEnum> type,
      OptionalValue<Instant> createdAt,
      OptionalValue<Instant> modifiedAt,
      OptionalValue<DeliveryReportType> deliveryReport,
      OptionalValue<Instant> sendAt,
      OptionalValue<Instant> expireAt,
      OptionalValue<String> callbackUrl,
      OptionalValue<String> clientReference,
      OptionalValue<Boolean> feedbackEnabled,
      OptionalValue<Boolean> strictValidation) {
    this.id = id;
    this.to = to;
    this.from = from;
    this.canceled = canceled;
    this.body = body;
    this.parameters = parameters;
    this.type = type;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.deliveryReport = deliveryReport;
    this.sendAt = sendAt;
    this.expireAt = expireAt;
    this.callbackUrl = callbackUrl;
    this.clientReference = clientReference;
    this.feedbackEnabled = feedbackEnabled;
    this.strictValidation = strictValidation;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public List<String> getTo() {
    return to.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
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
  public Boolean getCanceled() {
    return canceled.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Boolean> canceled() {
    return canceled;
  }

  @JsonIgnore
  public MediaBody getBody() {
    return body.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaBody> body() {
    return body;
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
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public Instant getCreatedAt() {
    return createdAt.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> createdAt() {
    return createdAt;
  }

  @JsonIgnore
  public Instant getModifiedAt() {
    return modifiedAt.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> modifiedAt() {
    return modifiedAt;
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
  public Boolean getStrictValidation() {
    return strictValidation.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STRICT_VALIDATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> strictValidation() {
    return strictValidation;
  }

  /** Return true if this MediaResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaResponseImpl mediaResponse = (MediaResponseImpl) o;
    return Objects.equals(this.id, mediaResponse.id)
        && Objects.equals(this.to, mediaResponse.to)
        && Objects.equals(this.from, mediaResponse.from)
        && Objects.equals(this.canceled, mediaResponse.canceled)
        && Objects.equals(this.body, mediaResponse.body)
        && Objects.equals(this.parameters, mediaResponse.parameters)
        && Objects.equals(this.type, mediaResponse.type)
        && Objects.equals(this.createdAt, mediaResponse.createdAt)
        && Objects.equals(this.modifiedAt, mediaResponse.modifiedAt)
        && Objects.equals(this.deliveryReport, mediaResponse.deliveryReport)
        && Objects.equals(this.sendAt, mediaResponse.sendAt)
        && Objects.equals(this.expireAt, mediaResponse.expireAt)
        && Objects.equals(this.callbackUrl, mediaResponse.callbackUrl)
        && Objects.equals(this.clientReference, mediaResponse.clientReference)
        && Objects.equals(this.feedbackEnabled, mediaResponse.feedbackEnabled)
        && Objects.equals(this.strictValidation, mediaResponse.strictValidation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        to,
        from,
        canceled,
        body,
        parameters,
        type,
        createdAt,
        modifiedAt,
        deliveryReport,
        sendAt,
        expireAt,
        callbackUrl,
        clientReference,
        feedbackEnabled,
        strictValidation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaResponseImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    canceled: ").append(toIndentedString(canceled)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
    sb.append("    deliveryReport: ").append(toIndentedString(deliveryReport)).append("\n");
    sb.append("    sendAt: ").append(toIndentedString(sendAt)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
    sb.append("    feedbackEnabled: ").append(toIndentedString(feedbackEnabled)).append("\n");
    sb.append("    strictValidation: ").append(toIndentedString(strictValidation)).append("\n");
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
  static class Builder implements MediaResponse.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<List<String>> to = OptionalValue.empty();
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<Boolean> canceled = OptionalValue.empty();
    OptionalValue<MediaBody> body = OptionalValue.empty();
    OptionalValue<Map<String, Map<String, String>>> parameters = OptionalValue.empty();
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.MT_MEDIA);
    OptionalValue<Instant> createdAt = OptionalValue.empty();
    OptionalValue<Instant> modifiedAt = OptionalValue.empty();
    OptionalValue<DeliveryReportType> deliveryReport = OptionalValue.empty();
    OptionalValue<Instant> sendAt = OptionalValue.empty();
    OptionalValue<Instant> expireAt = OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();
    OptionalValue<Boolean> feedbackEnabled = OptionalValue.empty();
    OptionalValue<Boolean> strictValidation = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

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

    @JsonProperty(JSON_PROPERTY_CANCELED)
    public Builder setCanceled(Boolean canceled) {
      this.canceled = OptionalValue.of(canceled);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BODY)
    public Builder setBody(MediaBody body) {
      this.body = OptionalValue.of(body);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PARAMETERS)
    public Builder setParameters(Map<String, Map<String, String>> parameters) {
      this.parameters = OptionalValue.of(parameters);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    public Builder setCreatedAt(Instant createdAt) {
      this.createdAt = OptionalValue.of(createdAt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MODIFIED_AT)
    public Builder setModifiedAt(Instant modifiedAt) {
      this.modifiedAt = OptionalValue.of(modifiedAt);
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

    @JsonProperty(JSON_PROPERTY_STRICT_VALIDATION)
    public Builder setStrictValidation(Boolean strictValidation) {
      this.strictValidation = OptionalValue.of(strictValidation);
      return this;
    }

    public MediaResponse build() {
      return new MediaResponseImpl(
          id,
          to,
          from,
          canceled,
          body,
          parameters,
          type,
          createdAt,
          modifiedAt,
          deliveryReport,
          sendAt,
          expireAt,
          callbackUrl,
          clientReference,
          feedbackEnabled,
          strictValidation);
    }
  }
}
