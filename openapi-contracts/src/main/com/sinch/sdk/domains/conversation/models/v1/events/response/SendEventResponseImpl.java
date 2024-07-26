package com.sinch.sdk.domains.conversation.models.v1.events.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  SendEventResponseImpl.JSON_PROPERTY_ACCEPTED_TIME,
  SendEventResponseImpl.JSON_PROPERTY_EVENT_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SendEventResponseImpl implements SendEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACCEPTED_TIME = "accepted_time";

  private OptionalValue<Instant> acceptedTime;

  public static final String JSON_PROPERTY_EVENT_ID = "event_id";

  private OptionalValue<String> eventId;

  public SendEventResponseImpl() {}

  protected SendEventResponseImpl(
      OptionalValue<Instant> acceptedTime, OptionalValue<String> eventId) {
    this.acceptedTime = acceptedTime;
    this.eventId = eventId;
  }

  @JsonIgnore
  public Instant getAcceptedTime() {
    return acceptedTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> acceptedTime() {
    return acceptedTime;
  }

  @JsonIgnore
  public String getEventId() {
    return eventId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> eventId() {
    return eventId;
  }

  /** Return true if this SendEventResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendEventResponseImpl sendEventResponse = (SendEventResponseImpl) o;
    return Objects.equals(this.acceptedTime, sendEventResponse.acceptedTime)
        && Objects.equals(this.eventId, sendEventResponse.eventId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acceptedTime, eventId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendEventResponseImpl {\n");
    sb.append("    acceptedTime: ").append(toIndentedString(acceptedTime)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
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
  static class Builder implements SendEventResponse.Builder {
    OptionalValue<Instant> acceptedTime = OptionalValue.empty();
    OptionalValue<String> eventId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME)
    public Builder setAcceptedTime(Instant acceptedTime) {
      this.acceptedTime = OptionalValue.of(acceptedTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENT_ID)
    public Builder setEventId(String eventId) {
      this.eventId = OptionalValue.of(eventId);
      return this;
    }

    public SendEventResponse build() {
      return new SendEventResponseImpl(acceptedTime, eventId);
    }
  }
}
