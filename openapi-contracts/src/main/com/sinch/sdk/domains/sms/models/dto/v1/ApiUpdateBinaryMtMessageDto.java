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

/** ApiUpdateBinaryMtMessageDto */
@JsonPropertyOrder({
  ApiUpdateBinaryMtMessageDto.JSON_PROPERTY_FROM,
  ApiUpdateBinaryMtMessageDto.JSON_PROPERTY_TYPE,
  ApiUpdateBinaryMtMessageDto.JSON_PROPERTY_TO_ADD,
  ApiUpdateBinaryMtMessageDto.JSON_PROPERTY_TO_REMOVE,
  ApiUpdateBinaryMtMessageDto.JSON_PROPERTY_DELIVERY_REPORT,
  ApiUpdateBinaryMtMessageDto.JSON_PROPERTY_SEND_AT,
  ApiUpdateBinaryMtMessageDto.JSON_PROPERTY_EXPIRE_AT,
  ApiUpdateBinaryMtMessageDto.JSON_PROPERTY_CALLBACK_URL,
  ApiUpdateBinaryMtMessageDto.JSON_PROPERTY_BODY,
  ApiUpdateBinaryMtMessageDto.JSON_PROPERTY_UDH
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ApiUpdateBinaryMtMessageDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_FROM = "from";
  private String from;
  private boolean fromDefined = false;

  /** SMS in binary format */
  public enum TypeEnum {
    MT_BINARY("mt_binary"),

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

  public static final String JSON_PROPERTY_BODY = "body";
  private String body;
  private boolean bodyDefined = false;

  public static final String JSON_PROPERTY_UDH = "udh";
  private String udh;
  private boolean udhDefined = false;

  public ApiUpdateBinaryMtMessageDto() {}

  public ApiUpdateBinaryMtMessageDto from(String from) {
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

  public ApiUpdateBinaryMtMessageDto type(String type) {
    this.type = type;
    this.typeDefined = true;
    return this;
  }

  /**
   * SMS in binary format
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

  public ApiUpdateBinaryMtMessageDto toAdd(List<String> toAdd) {
    this.toAdd = toAdd;
    this.toAddDefined = true;
    return this;
  }

  public ApiUpdateBinaryMtMessageDto addToAddItem(String toAddItem) {
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

  public ApiUpdateBinaryMtMessageDto toRemove(List<String> toRemove) {
    this.toRemove = toRemove;
    this.toRemoveDefined = true;
    return this;
  }

  public ApiUpdateBinaryMtMessageDto addToRemoveItem(String toRemoveItem) {
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

  public ApiUpdateBinaryMtMessageDto deliveryReport(String deliveryReport) {
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

  public ApiUpdateBinaryMtMessageDto sendAt(OffsetDateTime sendAt) {
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

  public ApiUpdateBinaryMtMessageDto expireAt(OffsetDateTime expireAt) {
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

  public ApiUpdateBinaryMtMessageDto callbackUrl(String callbackUrl) {
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

  public ApiUpdateBinaryMtMessageDto body(String body) {
    this.body = body;
    this.bodyDefined = true;
    return this;
  }

  /**
   * The message content Base64 encoded. Max 140 bytes together with udh.
   *
   * @return body
   */
  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getBody() {
    return body;
  }

  @JsonIgnore
  public boolean getBodyDefined() {
    return bodyDefined;
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBody(String body) {
    this.body = body;
    this.bodyDefined = true;
  }

  public ApiUpdateBinaryMtMessageDto udh(String udh) {
    this.udh = udh;
    this.udhDefined = true;
    return this;
  }

  /**
   * The UDH header of a binary message HEX encoded. Max 140 bytes together with body.
   *
   * @return udh
   */
  @JsonProperty(JSON_PROPERTY_UDH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getUdh() {
    return udh;
  }

  @JsonIgnore
  public boolean getUdhDefined() {
    return udhDefined;
  }

  @JsonProperty(JSON_PROPERTY_UDH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUdh(String udh) {
    this.udh = udh;
    this.udhDefined = true;
  }

  /** Return true if this ApiUpdateBinaryMtMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiUpdateBinaryMtMessageDto apiUpdateBinaryMtMessage = (ApiUpdateBinaryMtMessageDto) o;
    return Objects.equals(this.from, apiUpdateBinaryMtMessage.from)
        && Objects.equals(this.type, apiUpdateBinaryMtMessage.type)
        && Objects.equals(this.toAdd, apiUpdateBinaryMtMessage.toAdd)
        && Objects.equals(this.toRemove, apiUpdateBinaryMtMessage.toRemove)
        && Objects.equals(this.deliveryReport, apiUpdateBinaryMtMessage.deliveryReport)
        && Objects.equals(this.sendAt, apiUpdateBinaryMtMessage.sendAt)
        && Objects.equals(this.expireAt, apiUpdateBinaryMtMessage.expireAt)
        && Objects.equals(this.callbackUrl, apiUpdateBinaryMtMessage.callbackUrl)
        && Objects.equals(this.body, apiUpdateBinaryMtMessage.body)
        && Objects.equals(this.udh, apiUpdateBinaryMtMessage.udh);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        from, type, toAdd, toRemove, deliveryReport, sendAt, expireAt, callbackUrl, body, udh);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiUpdateBinaryMtMessageDto {\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    toAdd: ").append(toIndentedString(toAdd)).append("\n");
    sb.append("    toRemove: ").append(toIndentedString(toRemove)).append("\n");
    sb.append("    deliveryReport: ").append(toIndentedString(deliveryReport)).append("\n");
    sb.append("    sendAt: ").append(toIndentedString(sendAt)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    udh: ").append(toIndentedString(udh)).append("\n");
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
