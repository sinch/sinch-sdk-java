package com.sinch.sdk.domains.conversation.models.v1.events.types;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ReadMessageEventImpl.JSON_PROPERTY_READ_MESSAGE_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ReadMessageEventImpl
    implements ReadMessageEvent, com.sinch.sdk.domains.conversation.models.v1.events.AppEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_READ_MESSAGE_EVENT = "read_message_event";

  private OptionalValue<Object> readMessageEvent;

  public ReadMessageEventImpl() {}

  protected ReadMessageEventImpl(OptionalValue<Object> readMessageEvent) {
    this.readMessageEvent = readMessageEvent;
  }

  @JsonIgnore
  public Object getReadMessageEvent() {
    return readMessageEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_READ_MESSAGE_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Object> readMessageEvent() {
    return readMessageEvent;
  }

  /** Return true if this ReadMessageEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReadMessageEventImpl readMessageEventField = (ReadMessageEventImpl) o;
    return Objects.equals(this.readMessageEvent, readMessageEventField.readMessageEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(readMessageEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReadMessageEventImpl {\n");
    sb.append("    readMessageEvent: ").append(toIndentedString(readMessageEvent)).append("\n");
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
  static class Builder implements ReadMessageEvent.Builder {
    OptionalValue<Object> readMessageEvent = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_READ_MESSAGE_EVENT, required = true)
    public Builder setReadMessageEvent(Object readMessageEvent) {
      this.readMessageEvent = OptionalValue.of(readMessageEvent);
      return this;
    }

    public ReadMessageEvent build() {
      return new ReadMessageEventImpl(readMessageEvent);
    }
  }
}
