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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** ApiUpdateMtMessageDto */
@JsonPropertyOrder({
  ApiUpdateMtMessageDto.JSON_PROPERTY_FROM,
  ApiUpdateMtMessageDto.JSON_PROPERTY_TYPE,
  ApiUpdateMtMessageDto.JSON_PROPERTY_TO_ADD,
  ApiUpdateMtMessageDto.JSON_PROPERTY_TO_REMOVE,
  ApiUpdateMtMessageDto.JSON_PROPERTY_DELIVERY_REPORT,
  ApiUpdateMtMessageDto.JSON_PROPERTY_SEND_AT,
  ApiUpdateMtMessageDto.JSON_PROPERTY_EXPIRE_AT,
  ApiUpdateMtMessageDto.JSON_PROPERTY_CALLBACK_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ApiUpdateMtMessageDto {
  public static final String JSON_PROPERTY_FROM = "from";
  private String from;
  private boolean fromDefined = false;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;
  private boolean typeDefined = false;

  public static final String JSON_PROPERTY_TO_ADD = "to_add";
  private List<String> toAdd;
  private boolean toAddDefined = false;

  public static final String JSON_PROPERTY_TO_REMOVE = "to_remove";
  private List<String> toRemove;
  private boolean toRemoveDefined = false;

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

  public ApiUpdateMtMessageDto() {}

  public ApiUpdateMtMessageDto from(String from) {
    this.from = from;
    this.fromDefined = true;
    return this;
  }

  /**
   * Sender number. Must be valid phone number, short code or alphanumeric.
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

  public ApiUpdateMtMessageDto type(String type) {
    this.type = type;
    this.typeDefined = true;
    return this;
  }

  /**
   * Get type
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

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
    this.typeDefined = true;
  }

  public ApiUpdateMtMessageDto toAdd(List<String> toAdd) {
    this.toAdd = toAdd;
    this.toAddDefined = true;
    return this;
  }

  public ApiUpdateMtMessageDto addToAddItem(String toAddItem) {
    if (this.toAdd == null) {
      this.toAdd = new ArrayList<>();
    }
    this.toAddDefined = true;
    this.toAdd.add(toAddItem);
    return this;
  }

  /**
   * List of phone numbers and group IDs to add to the batch.
   *
   * @return toAdd
   */
  @JsonProperty(JSON_PROPERTY_TO_ADD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getToAdd() {
    return toAdd;
  }

  @JsonIgnore
  public boolean getToAddDefined() {
    return toAddDefined;
  }

  @JsonProperty(JSON_PROPERTY_TO_ADD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setToAdd(List<String> toAdd) {
    this.toAdd = toAdd;
    this.toAddDefined = true;
  }

  public ApiUpdateMtMessageDto toRemove(List<String> toRemove) {
    this.toRemove = toRemove;
    this.toRemoveDefined = true;
    return this;
  }

  public ApiUpdateMtMessageDto addToRemoveItem(String toRemoveItem) {
    if (this.toRemove == null) {
      this.toRemove = new ArrayList<>();
    }
    this.toRemoveDefined = true;
    this.toRemove.add(toRemoveItem);
    return this;
  }

  /**
   * List of phone numbers and group IDs to remove from the batch.
   *
   * @return toRemove
   */
  @JsonProperty(JSON_PROPERTY_TO_REMOVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getToRemove() {
    return toRemove;
  }

  @JsonIgnore
  public boolean getToRemoveDefined() {
    return toRemoveDefined;
  }

  @JsonProperty(JSON_PROPERTY_TO_REMOVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setToRemove(List<String> toRemove) {
    this.toRemove = toRemove;
    this.toRemoveDefined = true;
  }

  public ApiUpdateMtMessageDto deliveryReport(String deliveryReport) {
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

  public ApiUpdateMtMessageDto sendAt(OffsetDateTime sendAt) {
    this.sendAt = sendAt;
    this.sendAtDefined = true;
    return this;
  }

  /**
   * If set, in the future the message will be delayed until &#x60;send_at&#x60; occurs. Formatted
   * as &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_8601\&quot;
   * target&#x3D;\&quot;_blank\&quot;&gt;ISO-8601&lt;/a&gt;: &#x60;YYYY-MM-DDThh:mm:ss.SSSZ&#x60;.
   * Constraints: Must be before expire_at. If set in the past, messages will be sent immediately.
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

  public ApiUpdateMtMessageDto expireAt(OffsetDateTime expireAt) {
    this.expireAt = expireAt;
    this.expireAtDefined = true;
    return this;
  }

  /**
   * If set, the system will stop trying to deliver the message at this point. Constraints: Must be
   * after &#x60;send_at&#x60; Default: 3 days after &#x60;send_at&#x60;
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

  public ApiUpdateMtMessageDto callbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    this.callbackUrlDefined = true;
    return this;
  }

  /**
   * Override the default callback URL for this batch. Constraints: Must be valid URL.
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

  /** Return true if this ApiUpdateMtMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiUpdateMtMessageDto apiUpdateMtMessage = (ApiUpdateMtMessageDto) o;
    return Objects.equals(this.from, apiUpdateMtMessage.from)
        && Objects.equals(this.type, apiUpdateMtMessage.type)
        && Objects.equals(this.toAdd, apiUpdateMtMessage.toAdd)
        && Objects.equals(this.toRemove, apiUpdateMtMessage.toRemove)
        && Objects.equals(this.deliveryReport, apiUpdateMtMessage.deliveryReport)
        && Objects.equals(this.sendAt, apiUpdateMtMessage.sendAt)
        && Objects.equals(this.expireAt, apiUpdateMtMessage.expireAt)
        && Objects.equals(this.callbackUrl, apiUpdateMtMessage.callbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, type, toAdd, toRemove, deliveryReport, sendAt, expireAt, callbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiUpdateMtMessageDto {\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    toAdd: ").append(toIndentedString(toAdd)).append("\n");
    sb.append("    toRemove: ").append(toIndentedString(toRemove)).append("\n");
    sb.append("    deliveryReport: ").append(toIndentedString(deliveryReport)).append("\n");
    sb.append("    sendAt: ").append(toIndentedString(sendAt)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
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
