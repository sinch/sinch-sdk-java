/*
 * API Overview | Sinch
 * Sinch SMS API is one of the easiest APIs we offer and enables you to add fast and reliable global SMS to your applications. Send single messages, scheduled batch messages, use available message templates and more.
 *
 * The version of the OpenAPI document: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** MediaResponseDto */
@JsonPropertyOrder({
  MediaResponseDto.JSON_PROPERTY_ID,
  MediaResponseDto.JSON_PROPERTY_TO,
  MediaResponseDto.JSON_PROPERTY_FROM,
  MediaResponseDto.JSON_PROPERTY_CANCELED,
  MediaResponseDto.JSON_PROPERTY_BODY,
  MediaResponseDto.JSON_PROPERTY_PARAMETERS,
  MediaResponseDto.JSON_PROPERTY_TYPE,
  MediaResponseDto.JSON_PROPERTY_CREATED_AT,
  MediaResponseDto.JSON_PROPERTY_MODIFIED_AT,
  MediaResponseDto.JSON_PROPERTY_DELIVERY_REPORT,
  MediaResponseDto.JSON_PROPERTY_SEND_AT,
  MediaResponseDto.JSON_PROPERTY_EXPIRE_AT,
  MediaResponseDto.JSON_PROPERTY_CALLBACK_URL,
  MediaResponseDto.JSON_PROPERTY_CLIENT_REFERENCE,
  MediaResponseDto.JSON_PROPERTY_FEEDBACK_ENABLED,
  MediaResponseDto.JSON_PROPERTY_STRICT_VALIDATION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaResponseDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;
  private boolean idDefined = false;

  public static final String JSON_PROPERTY_TO = "to";
  private List<String> to;
  private boolean toDefined = false;

  public static final String JSON_PROPERTY_FROM = "from";
  private String from;
  private boolean fromDefined = false;

  public static final String JSON_PROPERTY_CANCELED = "canceled";
  private Boolean canceled;
  private boolean canceledDefined = false;

  public static final String JSON_PROPERTY_BODY = "body";
  private MediaBodyDto body;
  private boolean bodyDefined = false;

  public static final String JSON_PROPERTY_PARAMETERS = "parameters";
  private ParameterObjDto parameters;
  private boolean parametersDefined = false;

  /** Media message */
  public enum TypeEnum {
    MT_MEDIA("mt_media"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;
  private boolean typeDefined = false;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";
  private OffsetDateTime createdAt;
  private boolean createdAtDefined = false;

  public static final String JSON_PROPERTY_MODIFIED_AT = "modified_at";
  private OffsetDateTime modifiedAt;
  private boolean modifiedAtDefined = false;

  public static final String JSON_PROPERTY_DELIVERY_REPORT = "delivery_report";
  private String deliveryReport;
  private boolean deliveryReportDefined = false;

  public static final String JSON_PROPERTY_SEND_AT = "send_at";
  private OffsetDateTime sendAt;
  private boolean sendAtDefined = false;

  public static final String JSON_PROPERTY_EXPIRE_AT = "expire_at";
  private OffsetDateTime expireAt;
  private boolean expireAtDefined = false;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callback_url";
  private String callbackUrl;
  private boolean callbackUrlDefined = false;

  public static final String JSON_PROPERTY_CLIENT_REFERENCE = "client_reference";
  private String clientReference;
  private boolean clientReferenceDefined = false;

  public static final String JSON_PROPERTY_FEEDBACK_ENABLED = "feedback_enabled";
  private Boolean feedbackEnabled;
  private boolean feedbackEnabledDefined = false;

  public static final String JSON_PROPERTY_STRICT_VALIDATION = "strict_validation";
  private Boolean strictValidation;
  private boolean strictValidationDefined = false;

  public MediaResponseDto() {}

  @JsonCreator
  public MediaResponseDto(
      @JsonProperty(JSON_PROPERTY_ID) String id,
      @JsonProperty(JSON_PROPERTY_CANCELED) Boolean canceled,
      @JsonProperty(JSON_PROPERTY_TYPE) String type,
      @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt,
      @JsonProperty(JSON_PROPERTY_MODIFIED_AT) OffsetDateTime modifiedAt) {
    this();
    this.id = id;
    this.idDefined = true;
    this.canceled = canceled;
    this.canceledDefined = true;
    this.type = type;
    this.typeDefined = true;
    this.createdAt = createdAt;
    this.createdAtDefined = true;
    this.modifiedAt = modifiedAt;
    this.modifiedAtDefined = true;
  }

  /**
   * Unique identifier for batch
   *
   * @return id
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  @JsonIgnore
  public boolean getIdDefined() {
    return idDefined;
  }

  public MediaResponseDto to(List<String> to) {
    this.to = to;
    this.toDefined = true;
    return this;
  }

  public MediaResponseDto addToItem(String toItem) {
    if (this.to == null) {
      this.to = new ArrayList<>();
    }
    this.toDefined = true;
    this.to.add(toItem);
    return this;
  }

  /**
   * List of Phone numbers and group IDs that will receive the batch. [More
   * info](https://community.sinch.com/t5/Glossary/MSISDN/ta-p/7628)
   *
   * @return to
   */
  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getTo() {
    return to;
  }

  @JsonIgnore
  public boolean getToDefined() {
    return toDefined;
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTo(List<String> to) {
    this.to = to;
    this.toDefined = true;
  }

  public MediaResponseDto from(String from) {
    this.from = from;
    this.fromDefined = true;
    return this;
  }

  /**
   * Sender number. Required if Automatic Default Originator not configured.
   *
   * @return from
   */
  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getFrom() {
    return from;
  }

  @JsonIgnore
  public boolean getFromDefined() {
    return fromDefined;
  }

  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFrom(String from) {
    this.from = from;
    this.fromDefined = true;
  }

  /**
   * Indicates if the batch has been canceled or not.
   *
   * @return canceled
   */
  @JsonProperty(JSON_PROPERTY_CANCELED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getCanceled() {
    return canceled;
  }

  @JsonIgnore
  public boolean getCanceledDefined() {
    return canceledDefined;
  }

  public MediaResponseDto body(MediaBodyDto body) {
    this.body = body;
    this.bodyDefined = true;
    return this;
  }

  /**
   * Get body
   *
   * @return body
   */
  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MediaBodyDto getBody() {
    return body;
  }

  @JsonIgnore
  public boolean getBodyDefined() {
    return bodyDefined;
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBody(MediaBodyDto body) {
    this.body = body;
    this.bodyDefined = true;
  }

  public MediaResponseDto parameters(ParameterObjDto parameters) {
    this.parameters = parameters;
    this.parametersDefined = true;
    return this;
  }

  /**
   * Get parameters
   *
   * @return parameters
   */
  @JsonProperty(JSON_PROPERTY_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ParameterObjDto getParameters() {
    return parameters;
  }

  @JsonIgnore
  public boolean getParametersDefined() {
    return parametersDefined;
  }

  @JsonProperty(JSON_PROPERTY_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setParameters(ParameterObjDto parameters) {
    this.parameters = parameters;
    this.parametersDefined = true;
  }

  /**
   * Media message
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getType() {
    return type;
  }

  @JsonIgnore
  public boolean getTypeDefined() {
    return typeDefined;
  }

  /**
   * Timestamp for when batch was created. YYYY-MM-DDThh:mm:ss.SSSZ format
   *
   * @return createdAt
   */
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  @JsonIgnore
  public boolean getCreatedAtDefined() {
    return createdAtDefined;
  }

  /**
   * Timestamp for when batch was last updated. YYYY-MM-DDThh:mm:ss.SSSZ format
   *
   * @return modifiedAt
   */
  @JsonProperty(JSON_PROPERTY_MODIFIED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getModifiedAt() {
    return modifiedAt;
  }

  @JsonIgnore
  public boolean getModifiedAtDefined() {
    return modifiedAtDefined;
  }

  public MediaResponseDto deliveryReport(String deliveryReport) {
    this.deliveryReport = deliveryReport;
    this.deliveryReportDefined = true;
    return this;
  }

  /**
   * Request delivery report callback. Note that delivery reports can be fetched from the API
   * regardless of this setting.
   *
   * @return deliveryReport
   */
  @JsonProperty(JSON_PROPERTY_DELIVERY_REPORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDeliveryReport() {
    return deliveryReport;
  }

  @JsonIgnore
  public boolean getDeliveryReportDefined() {
    return deliveryReportDefined;
  }

  @JsonProperty(JSON_PROPERTY_DELIVERY_REPORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeliveryReport(String deliveryReport) {
    this.deliveryReport = deliveryReport;
    this.deliveryReportDefined = true;
  }

  public MediaResponseDto sendAt(OffsetDateTime sendAt) {
    this.sendAt = sendAt;
    this.sendAtDefined = true;
    return this;
  }

  /**
   * If set in the future the message will be delayed until send_at occurs. Must be before
   * &#x60;expire_at&#x60;. If set in the past messages will be sent immediately.
   * YYYY-MM-DDThh:mm:ss.SSSZ format
   *
   * @return sendAt
   */
  @JsonProperty(JSON_PROPERTY_SEND_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getSendAt() {
    return sendAt;
  }

  @JsonIgnore
  public boolean getSendAtDefined() {
    return sendAtDefined;
  }

  @JsonProperty(JSON_PROPERTY_SEND_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSendAt(OffsetDateTime sendAt) {
    this.sendAt = sendAt;
    this.sendAtDefined = true;
  }

  public MediaResponseDto expireAt(OffsetDateTime expireAt) {
    this.expireAt = expireAt;
    this.expireAtDefined = true;
    return this;
  }

  /**
   * If set the system will stop trying to deliver the message at this point. Must be after
   * &#x60;send_at&#x60;. Default and max is 3 days after send_at. YYYY-MM-DDThh:mm:ss.SSSZ format
   *
   * @return expireAt
   */
  @JsonProperty(JSON_PROPERTY_EXPIRE_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getExpireAt() {
    return expireAt;
  }

  @JsonIgnore
  public boolean getExpireAtDefined() {
    return expireAtDefined;
  }

  @JsonProperty(JSON_PROPERTY_EXPIRE_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExpireAt(OffsetDateTime expireAt) {
    this.expireAt = expireAt;
    this.expireAtDefined = true;
  }

  public MediaResponseDto callbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    this.callbackUrlDefined = true;
    return this;
  }

  /**
   * Override the default callback URL for this batch. Must be valid URL.
   *
   * @return callbackUrl
   */
  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCallbackUrl() {
    return callbackUrl;
  }

  @JsonIgnore
  public boolean getCallbackUrlDefined() {
    return callbackUrlDefined;
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    this.callbackUrlDefined = true;
  }

  public MediaResponseDto clientReference(String clientReference) {
    this.clientReference = clientReference;
    this.clientReferenceDefined = true;
    return this;
  }

  /**
   * The client identifier of a batch message. If set, the identifier will be added in the delivery
   * report/callback of this batch
   *
   * @return clientReference
   */
  @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getClientReference() {
    return clientReference;
  }

  @JsonIgnore
  public boolean getClientReferenceDefined() {
    return clientReferenceDefined;
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClientReference(String clientReference) {
    this.clientReference = clientReference;
    this.clientReferenceDefined = true;
  }

  public MediaResponseDto feedbackEnabled(Boolean feedbackEnabled) {
    this.feedbackEnabled = feedbackEnabled;
    this.feedbackEnabledDefined = true;
    return this;
  }

  /**
   * If set to true then
   * [feedback](/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/deliveryFeedback) is
   * expected after successful delivery.
   *
   * @return feedbackEnabled
   */
  @JsonProperty(JSON_PROPERTY_FEEDBACK_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getFeedbackEnabled() {
    return feedbackEnabled;
  }

  @JsonIgnore
  public boolean getFeedbackEnabledDefined() {
    return feedbackEnabledDefined;
  }

  @JsonProperty(JSON_PROPERTY_FEEDBACK_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFeedbackEnabled(Boolean feedbackEnabled) {
    this.feedbackEnabled = feedbackEnabled;
    this.feedbackEnabledDefined = true;
  }

  public MediaResponseDto strictValidation(Boolean strictValidation) {
    this.strictValidation = strictValidation;
    this.strictValidationDefined = true;
    return this;
  }

  /**
   * Whether or not you want the media included in your message to be checked against [Sinch MMS
   * channel best practices](/docs/mms/bestpractices/). If set to true, your message will be
   * rejected if it doesn&#39;t conform to the listed recommendations, otherwise no validation will
   * be performed.
   *
   * @return strictValidation
   */
  @JsonProperty(JSON_PROPERTY_STRICT_VALIDATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getStrictValidation() {
    return strictValidation;
  }

  @JsonIgnore
  public boolean getStrictValidationDefined() {
    return strictValidationDefined;
  }

  @JsonProperty(JSON_PROPERTY_STRICT_VALIDATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStrictValidation(Boolean strictValidation) {
    this.strictValidation = strictValidation;
    this.strictValidationDefined = true;
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
    MediaResponseDto mediaResponse = (MediaResponseDto) o;
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
    sb.append("class MediaResponseDto {\n");
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
}
