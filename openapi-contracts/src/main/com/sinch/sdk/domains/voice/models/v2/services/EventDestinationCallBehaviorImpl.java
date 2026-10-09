package com.sinch.sdk.domains.voice.models.v2.services;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.Objects;

@JsonPropertyOrder({
  EventDestinationCallBehaviorImpl.JSON_PROPERTY_TYPE,
  EventDestinationCallBehaviorImpl.JSON_PROPERTY_WEBHOOK
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EventDestinationCallBehaviorImpl
    implements EventDestinationCallBehavior, CallBehavior {
  private static final long serialVersionUID = 1L;

  /** The type property. Must have the value <code>WEBHOOK</code>. */
  public static class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** Calls are handled by sending Sinch Events to the configured event destination. */
    public static final TypeEnum WEBHOOK = new TypeEnum("WEBHOOK");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(WEBHOOK));

    private TypeEnum(String value) {
      super(value);
    }

    public static java.util.stream.Stream<TypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_WEBHOOK = "webhook";

  private OptionalValue<EventDestinationConfiguration> eventDestination;

  public EventDestinationCallBehaviorImpl() {}

  protected EventDestinationCallBehaviorImpl(
      OptionalValue<TypeEnum> type, OptionalValue<EventDestinationConfiguration> eventDestination) {
    this.type = type;
    this.eventDestination = eventDestination;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public EventDestinationConfiguration getEventDestination() {
    return eventDestination.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WEBHOOK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<EventDestinationConfiguration> eventDestination() {
    return eventDestination;
  }

  /** Return true if this EventDestinationCallBehavior object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventDestinationCallBehaviorImpl eventDestinationCallBehavior =
        (EventDestinationCallBehaviorImpl) o;
    return Objects.equals(this.type, eventDestinationCallBehavior.type)
        && Objects.equals(this.eventDestination, eventDestinationCallBehavior.eventDestination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, eventDestination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventDestinationCallBehaviorImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    eventDestination: ").append(toIndentedString(eventDestination)).append("\n");
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
  static class Builder implements EventDestinationCallBehavior.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.WEBHOOK);
    OptionalValue<EventDestinationConfiguration> eventDestination = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.WEBHOOK)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.WEBHOOK, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_WEBHOOK, required = true)
    public Builder setEventDestination(EventDestinationConfiguration eventDestination) {
      this.eventDestination = OptionalValue.of(eventDestination);
      return this;
    }

    public EventDestinationCallBehavior build() {
      return new EventDestinationCallBehaviorImpl(type, eventDestination);
    }
  }
}
