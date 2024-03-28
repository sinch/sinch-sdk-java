package com.sinch.sdk.domains.conversation.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage;
import java.util.Objects;

@JsonPropertyOrder({
  InjectMessageRequestMessageImpl.JSON_PROPERTY_APP_MESSAGE,
  InjectMessageRequestMessageImpl.JSON_PROPERTY_CONTACT_MESSAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class InjectMessageRequestMessageImpl implements InjectMessageRequestMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_MESSAGE = "app_message";

  private OptionalValue<AppMessage> appMessage;

  public static final String JSON_PROPERTY_CONTACT_MESSAGE = "contact_message";

  private OptionalValue<ContactMessage> contactMessage;

  public InjectMessageRequestMessageImpl() {}

  protected InjectMessageRequestMessageImpl(
      OptionalValue<AppMessage> appMessage, OptionalValue<ContactMessage> contactMessage) {
    this.appMessage = appMessage;
    this.contactMessage = contactMessage;
  }

  @JsonIgnore
  public AppMessage getAppMessage() {
    return appMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AppMessage> appMessage() {
    return appMessage;
  }

  @JsonIgnore
  public ContactMessage getContactMessage() {
    return contactMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactMessage> contactMessage() {
    return contactMessage;
  }

  /** Return true if this InjectMessageRequest_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InjectMessageRequestMessageImpl injectMessageRequestMessage =
        (InjectMessageRequestMessageImpl) o;
    return Objects.equals(this.appMessage, injectMessageRequestMessage.appMessage)
        && Objects.equals(this.contactMessage, injectMessageRequestMessage.contactMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appMessage, contactMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InjectMessageRequestMessageImpl {\n");
    sb.append("    appMessage: ").append(toIndentedString(appMessage)).append("\n");
    sb.append("    contactMessage: ").append(toIndentedString(contactMessage)).append("\n");
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
  static class Builder implements InjectMessageRequestMessage.Builder {
    OptionalValue<AppMessage> appMessage = OptionalValue.empty();
    OptionalValue<ContactMessage> contactMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_MESSAGE)
    public Builder setAppMessage(AppMessage appMessage) {
      this.appMessage = OptionalValue.of(appMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_MESSAGE)
    public Builder setContactMessage(ContactMessage contactMessage) {
      this.contactMessage = OptionalValue.of(contactMessage);
      return this;
    }

    public InjectMessageRequestMessage build() {
      return new InjectMessageRequestMessageImpl(appMessage, contactMessage);
    }
  }
}
