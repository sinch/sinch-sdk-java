package com.sinch.sdk.domains.conversation.models.v1.events.types;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ComposingEventImpl.JSON_PROPERTY_COMPOSING_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ComposingEventImpl
    implements ComposingEvent,
        com.sinch.sdk.domains.conversation.models.v1.events.AppEvent,
        com.sinch.sdk.domains.conversation.models.v1.events.ContactEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMPOSING_EVENT = "composing_event";

  private OptionalValue<Object> composingEvent;

  public ComposingEventImpl() {}

  protected ComposingEventImpl(OptionalValue<Object> composingEvent) {
    this.composingEvent = composingEvent;
  }

  @JsonIgnore
  public Object getComposingEvent() {
    return composingEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMPOSING_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Object> composingEvent() {
    return composingEvent;
  }

  /** Return true if this ComposingEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComposingEventImpl composingEventField = (ComposingEventImpl) o;
    return Objects.equals(this.composingEvent, composingEventField.composingEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(composingEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComposingEventImpl {\n");
    sb.append("    composingEvent: ").append(toIndentedString(composingEvent)).append("\n");
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
  static class Builder implements ComposingEvent.Builder {
    OptionalValue<Object> composingEvent = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMPOSING_EVENT, required = true)
    public Builder setComposingEvent(Object composingEvent) {
      this.composingEvent = OptionalValue.of(composingEvent);
      return this;
    }

    public ComposingEvent build() {
      return new ComposingEventImpl(composingEvent);
    }
  }
}
