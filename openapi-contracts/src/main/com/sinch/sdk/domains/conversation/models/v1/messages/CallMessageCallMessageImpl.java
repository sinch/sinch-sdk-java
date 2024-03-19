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
  CallMessageCallMessageImpl.JSON_PROPERTY_PHONE_NUMBER,
  CallMessageCallMessageImpl.JSON_PROPERTY_TITLE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallMessageCallMessageImpl implements CallMessageCallMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phone_number";

  private OptionalValue<String> phoneNumber;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public CallMessageCallMessageImpl() {}

  protected CallMessageCallMessageImpl(
      OptionalValue<String> phoneNumber, OptionalValue<String> title) {
    this.phoneNumber = phoneNumber;
    this.title = title;
  }

  @JsonIgnore
  public String getPhoneNumber() {
    return phoneNumber.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> phoneNumber() {
    return phoneNumber;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> title() {
    return title;
  }

  /** Return true if this CallMessage_call_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallMessageCallMessageImpl callMessageCallMessage = (CallMessageCallMessageImpl) o;
    return Objects.equals(this.phoneNumber, callMessageCallMessage.phoneNumber)
        && Objects.equals(this.title, callMessageCallMessage.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phoneNumber, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallMessageCallMessageImpl {\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements CallMessageCallMessage.Builder {
    OptionalValue<String> phoneNumber = OptionalValue.empty();
    OptionalValue<String> title = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = OptionalValue.of(phoneNumber);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    public CallMessageCallMessage build() {
      return new CallMessageCallMessageImpl(phoneNumber, title);
    }
  }
}
