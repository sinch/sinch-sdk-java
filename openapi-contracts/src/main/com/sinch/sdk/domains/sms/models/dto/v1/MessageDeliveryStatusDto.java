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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/** Array with status objects. Only status codes with at least one recipient will be listed. */
@JsonPropertyOrder({
  MessageDeliveryStatusDto.JSON_PROPERTY_CODE,
  MessageDeliveryStatusDto.JSON_PROPERTY_COUNT,
  MessageDeliveryStatusDto.JSON_PROPERTY_RECIPIENTS,
  MessageDeliveryStatusDto.JSON_PROPERTY_STATUS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessageDeliveryStatusDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_CODE = "code";
  private Integer code;
  private boolean codeDefined = false;

  public static final String JSON_PROPERTY_COUNT = "count";
  private Integer count;
  private boolean countDefined = false;

  public static final String JSON_PROPERTY_RECIPIENTS = "recipients";
  private Set<String> recipients;
  private boolean recipientsDefined = false;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;
  private boolean statusDefined = false;

  public MessageDeliveryStatusDto() {}

  public MessageDeliveryStatusDto code(Integer code) {
    this.code = code;
    this.codeDefined = true;
    return this;
  }

  /**
   * The detailed status code.
   *
   * @return code
   */
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Integer getCode() {
    return code;
  }

  @JsonIgnore
  public boolean getCodeDefined() {
    return codeDefined;
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCode(Integer code) {
    this.code = code;
    this.codeDefined = true;
  }

  public MessageDeliveryStatusDto count(Integer count) {
    this.count = count;
    this.countDefined = true;
    return this;
  }

  /**
   * The number of messages that currently has this code. minimum: 1
   *
   * @return count
   */
  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Integer getCount() {
    return count;
  }

  @JsonIgnore
  public boolean getCountDefined() {
    return countDefined;
  }

  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCount(Integer count) {
    this.count = count;
    this.countDefined = true;
  }

  public MessageDeliveryStatusDto recipients(Set<String> recipients) {
    this.recipients = recipients;
    this.recipientsDefined = true;
    return this;
  }

  public MessageDeliveryStatusDto addRecipientsItem(String recipientsItem) {
    if (this.recipients == null) {
      this.recipients = new LinkedHashSet<>();
    }
    this.recipientsDefined = true;
    this.recipients.add(recipientsItem);
    return this;
  }

  /**
   * Only for &#x60;full&#x60; report. A list of the phone number recipients which messages has this
   * status code.
   *
   * @return recipients
   */
  @JsonProperty(JSON_PROPERTY_RECIPIENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Set<String> getRecipients() {
    return recipients;
  }

  @JsonIgnore
  public boolean getRecipientsDefined() {
    return recipientsDefined;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  @JsonProperty(JSON_PROPERTY_RECIPIENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRecipients(Set<String> recipients) {
    this.recipients = recipients;
    this.recipientsDefined = true;
  }

  public MessageDeliveryStatusDto status(String status) {
    this.status = status;
    this.statusDefined = true;
    return this;
  }

  /**
   * The simplified status as described in _Delivery Report Statuses_.
   *
   * @return status
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getStatus() {
    return status;
  }

  @JsonIgnore
  public boolean getStatusDefined() {
    return statusDefined;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(String status) {
    this.status = status;
    this.statusDefined = true;
  }

  /** Return true if this MessageDeliveryStatus object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageDeliveryStatusDto messageDeliveryStatus = (MessageDeliveryStatusDto) o;
    return Objects.equals(this.code, messageDeliveryStatus.code)
        && Objects.equals(this.count, messageDeliveryStatus.count)
        && Objects.equals(this.recipients, messageDeliveryStatus.recipients)
        && Objects.equals(this.status, messageDeliveryStatus.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, count, recipients, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageDeliveryStatusDto {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
