package com.sinch.sdk.domains.conversation.models.v1.conversation.response;

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
  InjectEventResponseImpl.JSON_PROPERTY_EVENT_ID,
  InjectEventResponseImpl.JSON_PROPERTY_ACCEPTED_TIME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class InjectEventResponseImpl implements InjectEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_EVENT_ID = "event_id";

  private OptionalValue<String> eventId;

  public static final String JSON_PROPERTY_ACCEPTED_TIME = "accepted_time";

  private OptionalValue<Instant> acceptedTime;

  public InjectEventResponseImpl() {}

  protected InjectEventResponseImpl(
      OptionalValue<String> eventId, OptionalValue<Instant> acceptedTime) {
    this.eventId = eventId;
    this.acceptedTime = acceptedTime;
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

  @JsonIgnore
  public Instant getAcceptedTime() {
    return acceptedTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> acceptedTime() {
    return acceptedTime;
  }

  /** Return true if this InjectEventResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InjectEventResponseImpl injectEventResponse = (InjectEventResponseImpl) o;
    return Objects.equals(this.eventId, injectEventResponse.eventId)
        && Objects.equals(this.acceptedTime, injectEventResponse.acceptedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventId, acceptedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InjectEventResponseImpl {\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    acceptedTime: ").append(toIndentedString(acceptedTime)).append("\n");
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
  static class Builder implements InjectEventResponse.Builder {
    OptionalValue<String> eventId = OptionalValue.empty();
    OptionalValue<Instant> acceptedTime = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_EVENT_ID)
    public Builder setEventId(String eventId) {
      this.eventId = OptionalValue.of(eventId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME)
    public Builder setAcceptedTime(Instant acceptedTime) {
      this.acceptedTime = OptionalValue.of(acceptedTime);
      return this;
    }

    public InjectEventResponse build() {
      return new InjectEventResponseImpl(eventId, acceptedTime);
    }
  }
}
