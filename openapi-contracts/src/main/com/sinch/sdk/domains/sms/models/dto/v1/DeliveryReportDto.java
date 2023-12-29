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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** DeliveryReportDto */
@JsonPropertyOrder({
  DeliveryReportDto.JSON_PROPERTY_BATCH_ID,
  DeliveryReportDto.JSON_PROPERTY_STATUSES,
  DeliveryReportDto.JSON_PROPERTY_TOTAL_MESSAGE_COUNT,
  DeliveryReportDto.JSON_PROPERTY_TYPE,
  DeliveryReportDto.JSON_PROPERTY_CLIENT_REFERENCE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DeliveryReportDto {
  public static final String JSON_PROPERTY_BATCH_ID = "batch_id";
  private String batchId;
  private boolean batchIdDefined = false;

  public static final String JSON_PROPERTY_STATUSES = "statuses";
  private List<MessageDeliveryStatusDto> statuses;
  private boolean statusesDefined = false;

  public static final String JSON_PROPERTY_TOTAL_MESSAGE_COUNT = "total_message_count";
  private Integer totalMessageCount;
  private boolean totalMessageCountDefined = false;

  /** The delivery report type. */
  public enum TypeEnum {
    SMS("delivery_report_sms"),

    MMS("delivery_report_mms"),

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

  public static final String JSON_PROPERTY_CLIENT_REFERENCE = "client_reference";
  private String clientReference;
  private boolean clientReferenceDefined = false;

  public DeliveryReportDto() {}

  @JsonCreator
  public DeliveryReportDto(@JsonProperty(JSON_PROPERTY_BATCH_ID) String batchId) {
    this();
    this.batchId = batchId;
    this.batchIdDefined = true;
  }

  /**
   * The ID of the batch this delivery report belongs to.
   *
   * @return batchId
   */
  @JsonProperty(JSON_PROPERTY_BATCH_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getBatchId() {
    return batchId;
  }

  @JsonIgnore
  public boolean getBatchIdDefined() {
    return batchIdDefined;
  }

  public DeliveryReportDto statuses(List<MessageDeliveryStatusDto> statuses) {
    this.statuses = statuses;
    this.statusesDefined = true;
    return this;
  }

  public DeliveryReportDto addStatusesItem(MessageDeliveryStatusDto statusesItem) {
    if (this.statuses == null) {
      this.statuses = new ArrayList<>();
    }
    this.statusesDefined = true;
    this.statuses.add(statusesItem);
    return this;
  }

  /**
   * Array with status objects. Only status codes with at least one recipient will be listed.
   *
   * @return statuses
   */
  @JsonProperty(JSON_PROPERTY_STATUSES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public List<MessageDeliveryStatusDto> getStatuses() {
    return statuses;
  }

  @JsonIgnore
  public boolean getStatusesDefined() {
    return statusesDefined;
  }

  @JsonProperty(JSON_PROPERTY_STATUSES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatuses(List<MessageDeliveryStatusDto> statuses) {
    this.statuses = statuses;
    this.statusesDefined = true;
  }

  public DeliveryReportDto totalMessageCount(Integer totalMessageCount) {
    this.totalMessageCount = totalMessageCount;
    this.totalMessageCountDefined = true;
    return this;
  }

  /**
   * The total number of messages in the batch. minimum: 0
   *
   * @return totalMessageCount
   */
  @JsonProperty(JSON_PROPERTY_TOTAL_MESSAGE_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Integer getTotalMessageCount() {
    return totalMessageCount;
  }

  @JsonIgnore
  public boolean getTotalMessageCountDefined() {
    return totalMessageCountDefined;
  }

  @JsonProperty(JSON_PROPERTY_TOTAL_MESSAGE_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTotalMessageCount(Integer totalMessageCount) {
    this.totalMessageCount = totalMessageCount;
    this.totalMessageCountDefined = true;
  }

  public DeliveryReportDto type(String type) {
    this.type = type;
    this.typeDefined = true;
    return this;
  }

  /**
   * The delivery report type.
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getType() {
    return type;
  }

  @JsonIgnore
  public boolean getTypeDefined() {
    return typeDefined;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(String type) {
    this.type = type;
    this.typeDefined = true;
  }

  public DeliveryReportDto clientReference(String clientReference) {
    this.clientReference = clientReference;
    this.clientReferenceDefined = true;
    return this;
  }

  /**
   * The client identifier of the batch this delivery report belongs to, if set when submitting
   * batch.
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

  /** Return true if this DeliveryReport object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeliveryReportDto deliveryReport = (DeliveryReportDto) o;
    return Objects.equals(this.batchId, deliveryReport.batchId)
        && Objects.equals(this.statuses, deliveryReport.statuses)
        && Objects.equals(this.totalMessageCount, deliveryReport.totalMessageCount)
        && Objects.equals(this.type, deliveryReport.type)
        && Objects.equals(this.clientReference, deliveryReport.clientReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(batchId, statuses, totalMessageCount, type, clientReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliveryReportDto {\n");
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
    sb.append("    totalMessageCount: ").append(toIndentedString(totalMessageCount)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
}
