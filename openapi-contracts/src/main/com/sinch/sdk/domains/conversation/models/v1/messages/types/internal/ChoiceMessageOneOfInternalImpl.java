package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ChoiceMessageOneOfInternalImpl.JSON_PROPERTY_CALL_MESSAGE,
  ChoiceMessageOneOfInternalImpl.JSON_PROPERTY_LOCATION_MESSAGE,
  ChoiceMessageOneOfInternalImpl.JSON_PROPERTY_TEXT_MESSAGE,
  ChoiceMessageOneOfInternalImpl.JSON_PROPERTY_URL_MESSAGE,
  ChoiceMessageOneOfInternalImpl.JSON_PROPERTY_CALENDAR_MESSAGE,
  ChoiceMessageOneOfInternalImpl.JSON_PROPERTY_SHARE_LOCATION_MESSAGE,
  ChoiceMessageOneOfInternalImpl.JSON_PROPERTY_POSTBACK_DATA
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceMessageOneOfInternalImpl implements ChoiceMessageOneOfInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CALL_MESSAGE = "call_message";

  private OptionalValue<CallMessageInternal> callMessage;

  public static final String JSON_PROPERTY_LOCATION_MESSAGE = "location_message";

  private OptionalValue<LocationMessageInternal> locationMessage;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";

  private OptionalValue<TextMessageInternal> textMessage;

  public static final String JSON_PROPERTY_URL_MESSAGE = "url_message";

  private OptionalValue<UrlMessageInternal> urlMessage;

  public static final String JSON_PROPERTY_CALENDAR_MESSAGE = "calendar_message";

  private OptionalValue<CalendarMessageInternal> calendarMessage;

  public static final String JSON_PROPERTY_SHARE_LOCATION_MESSAGE = "share_location_message";

  private OptionalValue<ShareLocationMessageInternal> shareLocationMessage;

  public static final String JSON_PROPERTY_POSTBACK_DATA = "postback_data";

  private OptionalValue<Object> postbackData;

  public ChoiceMessageOneOfInternalImpl() {}

  protected ChoiceMessageOneOfInternalImpl(
      OptionalValue<CallMessageInternal> callMessage,
      OptionalValue<LocationMessageInternal> locationMessage,
      OptionalValue<TextMessageInternal> textMessage,
      OptionalValue<UrlMessageInternal> urlMessage,
      OptionalValue<CalendarMessageInternal> calendarMessage,
      OptionalValue<ShareLocationMessageInternal> shareLocationMessage,
      OptionalValue<Object> postbackData) {
    this.callMessage = callMessage;
    this.locationMessage = locationMessage;
    this.textMessage = textMessage;
    this.urlMessage = urlMessage;
    this.calendarMessage = calendarMessage;
    this.shareLocationMessage = shareLocationMessage;
    this.postbackData = postbackData;
  }

  @JsonIgnore
  public CallMessageInternal getCallMessage() {
    return callMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallMessageInternal> callMessage() {
    return callMessage;
  }

  @JsonIgnore
  public LocationMessageInternal getLocationMessage() {
    return locationMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LocationMessageInternal> locationMessage() {
    return locationMessage;
  }

  @JsonIgnore
  public TextMessageInternal getTextMessage() {
    return textMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TextMessageInternal> textMessage() {
    return textMessage;
  }

  @JsonIgnore
  public UrlMessageInternal getUrlMessage() {
    return urlMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<UrlMessageInternal> urlMessage() {
    return urlMessage;
  }

  @JsonIgnore
  public CalendarMessageInternal getCalendarMessage() {
    return calendarMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALENDAR_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CalendarMessageInternal> calendarMessage() {
    return calendarMessage;
  }

  @JsonIgnore
  public ShareLocationMessageInternal getShareLocationMessage() {
    return shareLocationMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SHARE_LOCATION_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ShareLocationMessageInternal> shareLocationMessage() {
    return shareLocationMessage;
  }

  @JsonIgnore
  public Object getPostbackData() {
    return postbackData.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_POSTBACK_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Object> postbackData() {
    return postbackData;
  }

  /** Return true if this Choice object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceMessageOneOfInternalImpl choice = (ChoiceMessageOneOfInternalImpl) o;
    return Objects.equals(this.callMessage, choice.callMessage)
        && Objects.equals(this.locationMessage, choice.locationMessage)
        && Objects.equals(this.textMessage, choice.textMessage)
        && Objects.equals(this.urlMessage, choice.urlMessage)
        && Objects.equals(this.calendarMessage, choice.calendarMessage)
        && Objects.equals(this.shareLocationMessage, choice.shareLocationMessage)
        && Objects.equals(this.postbackData, choice.postbackData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        callMessage,
        locationMessage,
        textMessage,
        urlMessage,
        calendarMessage,
        shareLocationMessage,
        postbackData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceMessageOneOfInternalImpl {\n");
    sb.append("    callMessage: ").append(toIndentedString(callMessage)).append("\n");
    sb.append("    locationMessage: ").append(toIndentedString(locationMessage)).append("\n");
    sb.append("    textMessage: ").append(toIndentedString(textMessage)).append("\n");
    sb.append("    urlMessage: ").append(toIndentedString(urlMessage)).append("\n");
    sb.append("    calendarMessage: ").append(toIndentedString(calendarMessage)).append("\n");
    sb.append("    shareLocationMessage: ")
        .append(toIndentedString(shareLocationMessage))
        .append("\n");
    sb.append("    postbackData: ").append(toIndentedString(postbackData)).append("\n");
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
  static class Builder implements ChoiceMessageOneOfInternal.Builder {
    OptionalValue<CallMessageInternal> callMessage = OptionalValue.empty();
    OptionalValue<LocationMessageInternal> locationMessage = OptionalValue.empty();
    OptionalValue<TextMessageInternal> textMessage = OptionalValue.empty();
    OptionalValue<UrlMessageInternal> urlMessage = OptionalValue.empty();
    OptionalValue<CalendarMessageInternal> calendarMessage = OptionalValue.empty();
    OptionalValue<ShareLocationMessageInternal> shareLocationMessage = OptionalValue.empty();
    OptionalValue<Object> postbackData = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CALL_MESSAGE)
    public Builder setCallMessage(CallMessageInternal callMessage) {
      this.callMessage = OptionalValue.of(callMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
    public Builder setLocationMessage(LocationMessageInternal locationMessage) {
      this.locationMessage = OptionalValue.of(locationMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
    public Builder setTextMessage(TextMessageInternal textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_URL_MESSAGE)
    public Builder setUrlMessage(UrlMessageInternal urlMessage) {
      this.urlMessage = OptionalValue.of(urlMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALENDAR_MESSAGE)
    public Builder setCalendarMessage(CalendarMessageInternal calendarMessage) {
      this.calendarMessage = OptionalValue.of(calendarMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SHARE_LOCATION_MESSAGE)
    public Builder setShareLocationMessage(ShareLocationMessageInternal shareLocationMessage) {
      this.shareLocationMessage = OptionalValue.of(shareLocationMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_POSTBACK_DATA)
    public Builder setPostbackData(Object postbackData) {
      this.postbackData = OptionalValue.of(postbackData);
      return this;
    }

    public ChoiceMessageOneOfInternal build() {
      return new ChoiceMessageOneOfInternalImpl(
          callMessage,
          locationMessage,
          textMessage,
          urlMessage,
          calendarMessage,
          shareLocationMessage,
          postbackData);
    }
  }
}
