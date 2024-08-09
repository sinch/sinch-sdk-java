package com.sinch.sdk.domains.conversation.models.v1.events.types;

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
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.GenericEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.GenericEventInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({GenericEventImpl.JSON_PROPERTY_GENERIC_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GenericEventImpl
    implements GenericEvent,
        com.sinch.sdk.domains.conversation.models.v1.events.AppEvent,
        com.sinch.sdk.domains.conversation.models.v1.events.ContactEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_GENERIC_EVENT = "generic_event";

  private OptionalValue<GenericEventInternal> genericEvent;

  public GenericEventImpl() {}

  protected GenericEventImpl(OptionalValue<GenericEventInternal> genericEvent) {
    this.genericEvent = genericEvent;
  }

  @JsonIgnore
  public GenericEventInternal getGenericEvent() {
    return genericEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_GENERIC_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<GenericEventInternal> genericEvent() {
    return genericEvent;
  }

  @JsonIgnore
  public Object getPayload() {
    if (null == genericEvent
        || !genericEvent.isPresent()
        || null == genericEvent.get().getPayload()) {
      return null;
    }
    return genericEvent.get().getPayload();
  }

  public OptionalValue<Object> payload() {
    return null != genericEvent && genericEvent.isPresent()
        ? genericEvent
            .map(f -> ((GenericEventInternalImpl) f).payload())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this GenericEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericEventImpl genericEventField = (GenericEventImpl) o;
    return Objects.equals(this.genericEvent, genericEventField.genericEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(genericEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenericEventImpl {\n");
    sb.append("    genericEvent: ").append(toIndentedString(genericEvent)).append("\n");
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
  static class Builder implements GenericEvent.Builder {
    OptionalValue<GenericEventInternal> genericEvent = OptionalValue.empty();

    GenericEventInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_GENERIC_EVENT, required = true)
    public Builder setGenericEvent(GenericEventInternal genericEvent) {
      this.genericEvent = OptionalValue.of(genericEvent);
      return this;
    }

    @JsonIgnore
    public Builder setPayload(Object payload) {
      getDelegatedBuilder().setPayload(payload);
      return this;
    }

    private GenericEventInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = GenericEventInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public GenericEvent build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.genericEvent = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new GenericEventImpl(genericEvent);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<GenericEvent>> {
    @Override
    public void serialize(
        OptionalValue<GenericEvent> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      GenericEventImpl impl = (GenericEventImpl) value.get();
      jgen.writeObject(impl.getGenericEvent());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<GenericEvent> {
    @Override
    public GenericEvent deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      GenericEventImpl.Builder builder = new GenericEventImpl.Builder();
      GenericEventInternalImpl deserialized = jp.readValueAs(GenericEventInternalImpl.class);
      builder.setGenericEvent(deserialized);
      return builder.build();
    }
  }

  public static Optional<GenericEvent> delegatedConverter(GenericEventInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setGenericEvent(internal).build());
  }
}
