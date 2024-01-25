/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** Message for triggering a call. */
@JsonPropertyOrder({CallMessageDto.JSON_PROPERTY_PHONE_NUMBER, CallMessageDto.JSON_PROPERTY_TITLE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallMessageDto {
  public static final String JSON_PROPERTY_PHONE_NUMBER = "phone_number";
  private String phoneNumber;
  private boolean phoneNumberDefined = false;

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;
  private boolean titleDefined = false;

  public CallMessageDto() {}

  public CallMessageDto phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    this.phoneNumberDefined = true;
    return this;
  }

  /**
   * Phone number in E.164 with leading +.
   *
   * @return phoneNumber
   */
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  @JsonIgnore
  public boolean getPhoneNumberDefined() {
    return phoneNumberDefined;
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    this.phoneNumberDefined = true;
  }

  public CallMessageDto title(String title) {
    this.title = title;
    this.titleDefined = true;
    return this;
  }

  /**
   * Title shown close to the phone number. The title is clickable in some cases.
   *
   * @return title
   */
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getTitle() {
    return title;
  }

  @JsonIgnore
  public boolean getTitleDefined() {
    return titleDefined;
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTitle(String title) {
    this.title = title;
    this.titleDefined = true;
  }

  /** Return true if this CallMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallMessageDto callMessage = (CallMessageDto) o;
    return Objects.equals(this.phoneNumber, callMessage.phoneNumber)
        && Objects.equals(this.title, callMessage.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phoneNumber, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallMessageDto {\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
