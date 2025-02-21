package com.sinch.sdk.domains.sms.models.v1.batches.request;

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
  UpdateMediaRequestImpl.JSON_PROPERTY_FROM,
  UpdateMediaRequestImpl.JSON_PROPERTY_TYPE,
  UpdateMediaRequestImpl.JSON_PROPERTY_TO_ADD,
  UpdateMediaRequestImpl.JSON_PROPERTY_TO_REMOVE,
  UpdateMediaRequestImpl.JSON_PROPERTY_DELIVERY_REPORT,
  UpdateMediaRequestImpl.JSON_PROPERTY_SEND_AT,
  UpdateMediaRequestImpl.JSON_PROPERTY_EXPIRE_AT,
  UpdateMediaRequestImpl.JSON_PROPERTY_CALLBACK_URL,
  UpdateMediaRequestImpl.JSON_PROPERTY_CLIENT_REFERENCE,
  UpdateMediaRequestImpl.JSON_PROPERTY_FEEDBACK_ENABLED,
  UpdateMediaRequestImpl.JSON_PROPERTY_BODY,
  UpdateMediaRequestImpl.JSON_PROPERTY_PARAMETERS,
  UpdateMediaRequestImpl.JSON_PROPERTY_STRICT_VALIDATION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UpdateMediaRequestImpl implements UpdateMediaRequest, UpdateBatchRequest {
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

  private OptionalValue<MediaBody> body;

  public static final String JSON_PROPERTY_PARAMETERS = "parameters";

  private OptionalValue<Map<String, Map<String, String>>> parameters;

  public static final String JSON_PROPERTY_STRICT_VALIDATION = "strict_validation";

  private OptionalValue<Boolean> strictValidation;

  public UpdateMediaRequestImpl() {}

  protected UpdateMediaRequestImpl(
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
      OptionalValue<MediaBody> body,
      OptionalValue<Map<String, Map<String, String>>> parameters,
      OptionalValue<Boolean> strictValidation) {
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
    this.parameters = parameters;
    this.strictValidation = strictValidation;
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
  public Boolean getStrictValidation() {
    return strictValidation.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STRICT_VALIDATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> strictValidation() {
    return strictValidation;
  }

  /** Return true if this update_media_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateMediaRequestImpl updateMediaMessage = (UpdateMediaRequestImpl) o;
    return Objects.equals(this.from, updateMediaMessage.from)
        && Objects.equals(this.type, updateMediaMessage.type)
        && Objects.equals(this.toAdd, updateMediaMessage.toAdd)
        && Objects.equals(this.toRemove, updateMediaMessage.toRemove)
        && Objects.equals(this.deliveryReport, updateMediaMessage.deliveryReport)
        && Objects.equals(this.sendAt, updateMediaMessage.sendAt)
        && Objects.equals(this.expireAt, updateMediaMessage.expireAt)
        && Objects.equals(this.callbackUrl, updateMediaMessage.callbackUrl)
        && Objects.equals(this.clientReference, updateMediaMessage.clientReference)
        && Objects.equals(this.feedbackEnabled, updateMediaMessage.feedbackEnabled)
        && Objects.equals(this.body, updateMediaMessage.body)
        && Objects.equals(this.parameters, updateMediaMessage.parameters)
        && Objects.equals(this.strictValidation, updateMediaMessage.strictValidation);
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
        parameters,
        strictValidation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateMediaRequestImpl {\n");
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
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
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
  static class Builder implements UpdateMediaRequest.Builder {
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.MT_MEDIA);
    OptionalValue<List<String>> toAdd = OptionalValue.empty();
    OptionalValue<List<String>> toRemove = OptionalValue.empty();
    OptionalValue<DeliveryReportType> deliveryReport = OptionalValue.empty();
    OptionalValue<Instant> sendAt = OptionalValue.empty();
    OptionalValue<Instant> expireAt = OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();
    OptionalValue<Boolean> feedbackEnabled = OptionalValue.empty();
    OptionalValue<MediaBody> body = OptionalValue.empty();
    OptionalValue<Map<String, Map<String, String>>> parameters = OptionalValue.empty();
    OptionalValue<Boolean> strictValidation = OptionalValue.empty();

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
    public Builder setBody(MediaBody body) {
      this.body = OptionalValue.of(body);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PARAMETERS)
    public Builder setParameters(Map<String, Map<String, String>> parameters) {
      this.parameters = OptionalValue.of(parameters);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STRICT_VALIDATION)
    public Builder setStrictValidation(Boolean strictValidation) {
      this.strictValidation = OptionalValue.of(strictValidation);
      return this;
    }

    public UpdateMediaRequest build() {
      return new UpdateMediaRequestImpl(
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
          parameters,
          strictValidation);
    }
  }
}
