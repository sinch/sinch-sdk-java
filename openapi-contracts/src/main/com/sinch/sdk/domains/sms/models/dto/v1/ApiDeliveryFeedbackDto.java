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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** ApiDeliveryFeedbackDto */
@JsonPropertyOrder({ApiDeliveryFeedbackDto.JSON_PROPERTY_RECIPIENTS})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ApiDeliveryFeedbackDto {
  public static final String JSON_PROPERTY_RECIPIENTS = "recipients";
  private List<String> recipients = new ArrayList<>();

  public ApiDeliveryFeedbackDto() {}

  public ApiDeliveryFeedbackDto recipients(List<String> recipients) {
    this.recipients = recipients;
    return this;
  }

  public ApiDeliveryFeedbackDto addRecipientsItem(String recipientsItem) {
    if (this.recipients == null) {
      this.recipients = new ArrayList<>();
    }
    this.recipients.add(recipientsItem);
    return this;
  }

  /**
   * A list of phone numbers (MSISDNs) that have successfully received the message. The key is
   * required, however, the value can be an empty array (&#x60;[]&#x60;) for *a batch*. If the
   * feedback was enabled for *a group*, at least one phone number is required.
   *
   * @return recipients
   */
  @JsonProperty(JSON_PROPERTY_RECIPIENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public List<String> getRecipients() {
    return recipients;
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRecipients(List<String> recipients) {
    this.recipients = recipients;
  }

  /** Return true if this ApiDeliveryFeedback object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiDeliveryFeedbackDto apiDeliveryFeedback = (ApiDeliveryFeedbackDto) o;
    return Objects.equals(this.recipients, apiDeliveryFeedback.recipients);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipients);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiDeliveryFeedbackDto {\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
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
