package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

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
  CalendarMessageInternalImpl.JSON_PROPERTY_TITLE,
  CalendarMessageInternalImpl.JSON_PROPERTY_EVENT_START,
  CalendarMessageInternalImpl.JSON_PROPERTY_EVENT_END,
  CalendarMessageInternalImpl.JSON_PROPERTY_EVENT_TITLE,
  CalendarMessageInternalImpl.JSON_PROPERTY_EVENT_DESCRIPTION,
  CalendarMessageInternalImpl.JSON_PROPERTY_FALLBACK_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CalendarMessageInternalImpl implements CalendarMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_EVENT_START = "event_start";

  private OptionalValue<Instant> eventStart;

  public static final String JSON_PROPERTY_EVENT_END = "event_end";

  private OptionalValue<Instant> eventEnd;

  public static final String JSON_PROPERTY_EVENT_TITLE = "event_title";

  private OptionalValue<String> eventTitle;

  public static final String JSON_PROPERTY_EVENT_DESCRIPTION = "event_description";

  private OptionalValue<String> eventDescription;

  public static final String JSON_PROPERTY_FALLBACK_URL = "fallback_url";

  private OptionalValue<String> fallbackUrl;

  public CalendarMessageInternalImpl() {}

  protected CalendarMessageInternalImpl(
      OptionalValue<String> title,
      OptionalValue<Instant> eventStart,
      OptionalValue<Instant> eventEnd,
      OptionalValue<String> eventTitle,
      OptionalValue<String> eventDescription,
      OptionalValue<String> fallbackUrl) {
    this.title = title;
    this.eventStart = eventStart;
    this.eventEnd = eventEnd;
    this.eventTitle = eventTitle;
    this.eventDescription = eventDescription;
    this.fallbackUrl = fallbackUrl;
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

  @JsonIgnore
  public Instant getEventStart() {
    return eventStart.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT_START)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Instant> eventStart() {
    return eventStart;
  }

  @JsonIgnore
  public Instant getEventEnd() {
    return eventEnd.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT_END)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Instant> eventEnd() {
    return eventEnd;
  }

  @JsonIgnore
  public String getEventTitle() {
    return eventTitle.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT_TITLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> eventTitle() {
    return eventTitle;
  }

  @JsonIgnore
  public String getEventDescription() {
    return eventDescription.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> eventDescription() {
    return eventDescription;
  }

  @JsonIgnore
  public String getFallbackUrl() {
    return fallbackUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> fallbackUrl() {
    return fallbackUrl;
  }

  /** Return true if this Calendar_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalendarMessageInternalImpl calendarMessage = (CalendarMessageInternalImpl) o;
    return Objects.equals(this.title, calendarMessage.title)
        && Objects.equals(this.eventStart, calendarMessage.eventStart)
        && Objects.equals(this.eventEnd, calendarMessage.eventEnd)
        && Objects.equals(this.eventTitle, calendarMessage.eventTitle)
        && Objects.equals(this.eventDescription, calendarMessage.eventDescription)
        && Objects.equals(this.fallbackUrl, calendarMessage.fallbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, eventStart, eventEnd, eventTitle, eventDescription, fallbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalendarMessageInternalImpl {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    eventStart: ").append(toIndentedString(eventStart)).append("\n");
    sb.append("    eventEnd: ").append(toIndentedString(eventEnd)).append("\n");
    sb.append("    eventTitle: ").append(toIndentedString(eventTitle)).append("\n");
    sb.append("    eventDescription: ").append(toIndentedString(eventDescription)).append("\n");
    sb.append("    fallbackUrl: ").append(toIndentedString(fallbackUrl)).append("\n");
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
  static class Builder implements CalendarMessageInternal.Builder {
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<Instant> eventStart = OptionalValue.empty();
    OptionalValue<Instant> eventEnd = OptionalValue.empty();
    OptionalValue<String> eventTitle = OptionalValue.empty();
    OptionalValue<String> eventDescription = OptionalValue.empty();
    OptionalValue<String> fallbackUrl = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TITLE, required = true)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_EVENT_START, required = true)
    public Builder setEventStart(Instant eventStart) {
      this.eventStart = OptionalValue.of(eventStart);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_EVENT_END, required = true)
    public Builder setEventEnd(Instant eventEnd) {
      this.eventEnd = OptionalValue.of(eventEnd);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_EVENT_TITLE, required = true)
    public Builder setEventTitle(String eventTitle) {
      this.eventTitle = OptionalValue.of(eventTitle);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENT_DESCRIPTION)
    public Builder setEventDescription(String eventDescription) {
      this.eventDescription = OptionalValue.of(eventDescription);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_FALLBACK_URL, required = true)
    public Builder setFallbackUrl(String fallbackUrl) {
      this.fallbackUrl = OptionalValue.of(fallbackUrl);
      return this;
    }

    public CalendarMessageInternal build() {
      return new CalendarMessageInternalImpl(
          title, eventStart, eventEnd, eventTitle, eventDescription, fallbackUrl);
    }
  }
}
