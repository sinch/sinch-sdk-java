package com.sinch.sdk.domains.conversation.models.v1.messages.types.calendar;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CalendarMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CalendarMessageInternalImpl;
import java.io.IOException;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({CalendarMessageImpl.JSON_PROPERTY_CALENDAR_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CalendarMessageImpl
    implements CalendarMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageType {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CALENDAR_MESSAGE = "calendar_message";

  private OptionalValue<CalendarMessageInternal> calendarMessage;

  public CalendarMessageImpl() {}

  protected CalendarMessageImpl(OptionalValue<CalendarMessageInternal> calendarMessage) {
    this.calendarMessage = calendarMessage;
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
  public String getTitle() {
    if (null == calendarMessage
        || !calendarMessage.isPresent()
        || null == calendarMessage.get().getTitle()) {
      return null;
    }
    return calendarMessage.get().getTitle();
  }

  public OptionalValue<String> title() {
    return null != calendarMessage && calendarMessage.isPresent()
        ? calendarMessage
            .map(f -> ((CalendarMessageInternalImpl) f).title())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Instant getEventStart() {
    if (null == calendarMessage
        || !calendarMessage.isPresent()
        || null == calendarMessage.get().getEventStart()) {
      return null;
    }
    return calendarMessage.get().getEventStart();
  }

  public OptionalValue<Instant> eventStart() {
    return null != calendarMessage && calendarMessage.isPresent()
        ? calendarMessage
            .map(f -> ((CalendarMessageInternalImpl) f).eventStart())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Instant getEventEnd() {
    if (null == calendarMessage
        || !calendarMessage.isPresent()
        || null == calendarMessage.get().getEventEnd()) {
      return null;
    }
    return calendarMessage.get().getEventEnd();
  }

  public OptionalValue<Instant> eventEnd() {
    return null != calendarMessage && calendarMessage.isPresent()
        ? calendarMessage
            .map(f -> ((CalendarMessageInternalImpl) f).eventEnd())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getEventTitle() {
    if (null == calendarMessage
        || !calendarMessage.isPresent()
        || null == calendarMessage.get().getEventTitle()) {
      return null;
    }
    return calendarMessage.get().getEventTitle();
  }

  public OptionalValue<String> eventTitle() {
    return null != calendarMessage && calendarMessage.isPresent()
        ? calendarMessage
            .map(f -> ((CalendarMessageInternalImpl) f).eventTitle())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getEventDescription() {
    if (null == calendarMessage
        || !calendarMessage.isPresent()
        || null == calendarMessage.get().getEventDescription()) {
      return null;
    }
    return calendarMessage.get().getEventDescription();
  }

  public OptionalValue<String> eventDescription() {
    return null != calendarMessage && calendarMessage.isPresent()
        ? calendarMessage
            .map(f -> ((CalendarMessageInternalImpl) f).eventDescription())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getFallbackUrl() {
    if (null == calendarMessage
        || !calendarMessage.isPresent()
        || null == calendarMessage.get().getFallbackUrl()) {
      return null;
    }
    return calendarMessage.get().getFallbackUrl();
  }

  public OptionalValue<String> fallbackUrl() {
    return null != calendarMessage && calendarMessage.isPresent()
        ? calendarMessage
            .map(f -> ((CalendarMessageInternalImpl) f).fallbackUrl())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this CalendarMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalendarMessageImpl calendarMessageField = (CalendarMessageImpl) o;
    return Objects.equals(this.calendarMessage, calendarMessageField.calendarMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(calendarMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalendarMessageImpl {\n");
    sb.append("    calendarMessage: ").append(toIndentedString(calendarMessage)).append("\n");
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
  static class Builder implements CalendarMessage.Builder {
    OptionalValue<CalendarMessageInternal> calendarMessage = OptionalValue.empty();

    CalendarMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_CALENDAR_MESSAGE, required = true)
    public Builder setCalendarMessage(CalendarMessageInternal calendarMessage) {
      this.calendarMessage = OptionalValue.of(calendarMessage);
      return this;
    }

    @JsonIgnore
    public Builder setTitle(String title) {
      getDelegatedBuilder().setTitle(title);
      return this;
    }

    @JsonIgnore
    public Builder setEventStart(Instant eventStart) {
      getDelegatedBuilder().setEventStart(eventStart);
      return this;
    }

    @JsonIgnore
    public Builder setEventEnd(Instant eventEnd) {
      getDelegatedBuilder().setEventEnd(eventEnd);
      return this;
    }

    @JsonIgnore
    public Builder setEventTitle(String eventTitle) {
      getDelegatedBuilder().setEventTitle(eventTitle);
      return this;
    }

    @JsonIgnore
    public Builder setEventDescription(String eventDescription) {
      getDelegatedBuilder().setEventDescription(eventDescription);
      return this;
    }

    @JsonIgnore
    public Builder setFallbackUrl(String fallbackUrl) {
      getDelegatedBuilder().setFallbackUrl(fallbackUrl);
      return this;
    }

    private CalendarMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = CalendarMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public CalendarMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.calendarMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new CalendarMessageImpl(calendarMessage);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<CalendarMessage>> {
    @Override
    public void serialize(
        OptionalValue<CalendarMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      CalendarMessageImpl impl = (CalendarMessageImpl) value.get();
      jgen.writeObject(null != impl ? impl.getCalendarMessage() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<CalendarMessage> {
    @Override
    public CalendarMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      CalendarMessageImpl.Builder builder = new CalendarMessageImpl.Builder();
      CalendarMessageInternalImpl deserialized = jp.readValueAs(CalendarMessageInternalImpl.class);
      builder.setCalendarMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<CalendarMessage> delegatedConverter(CalendarMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setCalendarMessage(internal).build());
  }
}
