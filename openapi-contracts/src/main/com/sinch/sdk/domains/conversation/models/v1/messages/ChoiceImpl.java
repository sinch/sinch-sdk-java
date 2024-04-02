package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ChoiceImpl.JSON_PROPERTY_CALL_MESSAGE,
  ChoiceImpl.JSON_PROPERTY_LOCATION_MESSAGE,
  ChoiceImpl.JSON_PROPERTY_TEXT_MESSAGE,
  ChoiceImpl.JSON_PROPERTY_URL_MESSAGE,
  ChoiceImpl.JSON_PROPERTY_POSTBACK_DATA
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceImpl implements Choice {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CALL_MESSAGE = "call_message";

  private OptionalValue<CallMessage> callMessage;

  public static final String JSON_PROPERTY_LOCATION_MESSAGE = "location_message";

  private OptionalValue<LocationMessage> locationMessage;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";

  private OptionalValue<TextMessage> textMessage;

  public static final String JSON_PROPERTY_URL_MESSAGE = "url_message";

  private OptionalValue<URLMessage> urlMessage;

  public static final String JSON_PROPERTY_POSTBACK_DATA = "postback_data";

  private OptionalValue<Object> postbackData;

  public ChoiceImpl() {}

  protected ChoiceImpl(
      OptionalValue<CallMessage> callMessage,
      OptionalValue<LocationMessage> locationMessage,
      OptionalValue<TextMessage> textMessage,
      OptionalValue<URLMessage> urlMessage,
      OptionalValue<Object> postbackData) {
    this.callMessage = callMessage;
    this.locationMessage = locationMessage;
    this.textMessage = textMessage;
    this.urlMessage = urlMessage;
    this.postbackData = postbackData;
  }

  @JsonIgnore
  public CallMessage getCallMessage() {
    return callMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallMessage> callMessage() {
    return callMessage;
  }

  @JsonIgnore
  public LocationMessage getLocationMessage() {
    return locationMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LocationMessage> locationMessage() {
    return locationMessage;
  }

  @JsonIgnore
  public TextMessage getTextMessage() {
    return textMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TextMessage> textMessage() {
    return textMessage;
  }

  @JsonIgnore
  public URLMessage getUrlMessage() {
    return urlMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<URLMessage> urlMessage() {
    return urlMessage;
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
    ChoiceImpl choice = (ChoiceImpl) o;
    return Objects.equals(this.callMessage, choice.callMessage)
        && Objects.equals(this.locationMessage, choice.locationMessage)
        && Objects.equals(this.textMessage, choice.textMessage)
        && Objects.equals(this.urlMessage, choice.urlMessage)
        && Objects.equals(this.postbackData, choice.postbackData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callMessage, locationMessage, textMessage, urlMessage, postbackData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceImpl {\n");
    sb.append("    callMessage: ").append(toIndentedString(callMessage)).append("\n");
    sb.append("    locationMessage: ").append(toIndentedString(locationMessage)).append("\n");
    sb.append("    textMessage: ").append(toIndentedString(textMessage)).append("\n");
    sb.append("    urlMessage: ").append(toIndentedString(urlMessage)).append("\n");
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
  static class Builder implements Choice.Builder {
    OptionalValue<CallMessage> callMessage = OptionalValue.empty();
    OptionalValue<LocationMessage> locationMessage = OptionalValue.empty();
    OptionalValue<TextMessage> textMessage = OptionalValue.empty();
    OptionalValue<URLMessage> urlMessage = OptionalValue.empty();
    OptionalValue<Object> postbackData = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CALL_MESSAGE)
    public Builder setCallMessage(CallMessage callMessage) {
      this.callMessage = OptionalValue.of(callMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
    public Builder setLocationMessage(LocationMessage locationMessage) {
      this.locationMessage = OptionalValue.of(locationMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
    public Builder setTextMessage(TextMessage textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_URL_MESSAGE)
    public Builder setUrlMessage(URLMessage urlMessage) {
      this.urlMessage = OptionalValue.of(urlMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_POSTBACK_DATA)
    public Builder setPostbackData(Object postbackData) {
      this.postbackData = OptionalValue.of(postbackData);
      return this;
    }

    public Choice build() {
      return new ChoiceImpl(callMessage, locationMessage, textMessage, urlMessage, postbackData);
    }
  }
}
