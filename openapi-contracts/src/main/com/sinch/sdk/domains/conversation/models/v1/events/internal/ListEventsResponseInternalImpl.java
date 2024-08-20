package com.sinch.sdk.domains.conversation.models.v1.events.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.events.ConversationEvent;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ListEventsResponseInternalImpl.JSON_PROPERTY_EVENTS,
  ListEventsResponseInternalImpl.JSON_PROPERTY_NEXT_PAGE_TOKEN
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListEventsResponseInternalImpl implements ListEventsResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_EVENTS = "events";

  private OptionalValue<List<ConversationEvent>> events;

  public static final String JSON_PROPERTY_NEXT_PAGE_TOKEN = "next_page_token";

  private OptionalValue<String> nextPageToken;

  public ListEventsResponseInternalImpl() {}

  protected ListEventsResponseInternalImpl(
      OptionalValue<List<ConversationEvent>> events, OptionalValue<String> nextPageToken) {
    this.events = events;
    this.nextPageToken = nextPageToken;
  }

  @JsonIgnore
  public List<ConversationEvent> getEvents() {
    return events.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<ConversationEvent>> events() {
    return events;
  }

  @JsonIgnore
  public String getNextPageToken() {
    return nextPageToken.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> nextPageToken() {
    return nextPageToken;
  }

  /** Return true if this ListEventsResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListEventsResponseInternalImpl listEventsResponse = (ListEventsResponseInternalImpl) o;
    return Objects.equals(this.events, listEventsResponse.events)
        && Objects.equals(this.nextPageToken, listEventsResponse.nextPageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(events, nextPageToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListEventsResponseInternalImpl {\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("    nextPageToken: ").append(toIndentedString(nextPageToken)).append("\n");
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
  static class Builder implements ListEventsResponseInternal.Builder {
    OptionalValue<List<ConversationEvent>> events = OptionalValue.empty();
    OptionalValue<String> nextPageToken = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_EVENTS)
    public Builder setEvents(List<ConversationEvent> events) {
      this.events = OptionalValue.of(events);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
    public Builder setNextPageToken(String nextPageToken) {
      this.nextPageToken = OptionalValue.of(nextPageToken);
      return this;
    }

    public ListEventsResponseInternal build() {
      return new ListEventsResponseInternalImpl(events, nextPageToken);
    }
  }
}
