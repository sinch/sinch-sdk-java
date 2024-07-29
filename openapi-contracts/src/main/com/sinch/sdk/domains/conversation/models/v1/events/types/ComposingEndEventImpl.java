package com.sinch.sdk.domains.conversation.models.v1.events.types;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ComposingEndEventImpl.JSON_PROPERTY_COMPOSING_END_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ComposingEndEventImpl
    implements ComposingEndEvent,
        com.sinch.sdk.domains.conversation.models.v1.events.ContactEvent,
        com.sinch.sdk.domains.conversation.models.v1.events.AppEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMPOSING_END_EVENT = "composing_end_event";

  private OptionalValue<Object> composingEndEvent;

  public ComposingEndEventImpl() {}

  protected ComposingEndEventImpl(OptionalValue<Object> composingEndEvent) {
    this.composingEndEvent = composingEndEvent;
  }

  @JsonIgnore
  public Object getComposingEndEvent() {
    return composingEndEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMPOSING_END_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Object> composingEndEvent() {
    return composingEndEvent;
  }

  /** Return true if this ComposingEndEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComposingEndEventImpl composingEndEventField = (ComposingEndEventImpl) o;
    return Objects.equals(this.composingEndEvent, composingEndEventField.composingEndEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(composingEndEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComposingEndEventImpl {\n");
    sb.append("    composingEndEvent: ").append(toIndentedString(composingEndEvent)).append("\n");
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
  static class Builder implements ComposingEndEvent.Builder {
    OptionalValue<Object> composingEndEvent = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMPOSING_END_EVENT, required = true)
    public Builder setComposingEndEvent(Object composingEndEvent) {
      this.composingEndEvent = OptionalValue.of(composingEndEvent);
      return this;
    }

    public ComposingEndEvent build() {
      return new ComposingEndEventImpl(composingEndEvent);
    }
  }
}
