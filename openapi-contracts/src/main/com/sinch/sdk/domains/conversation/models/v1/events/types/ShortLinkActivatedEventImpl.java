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
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.ShortLinkActivatedEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.ShortLinkActivatedEventInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({ShortLinkActivatedEventImpl.JSON_PROPERTY_SHORTLINK_ACTIVATED_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ShortLinkActivatedEventImpl
    implements ShortLinkActivatedEvent,
        com.sinch.sdk.domains.conversation.models.v1.events.ContactMessageEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SHORTLINK_ACTIVATED_EVENT = "shortlink_activated_event";

  private OptionalValue<ShortLinkActivatedEventInternal> shortlinkActivatedEvent;

  public ShortLinkActivatedEventImpl() {}

  protected ShortLinkActivatedEventImpl(
      OptionalValue<ShortLinkActivatedEventInternal> shortlinkActivatedEvent) {
    this.shortlinkActivatedEvent = shortlinkActivatedEvent;
  }

  @JsonIgnore
  public ShortLinkActivatedEventInternal getShortlinkActivatedEvent() {
    return shortlinkActivatedEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SHORTLINK_ACTIVATED_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ShortLinkActivatedEventInternal> shortlinkActivatedEvent() {
    return shortlinkActivatedEvent;
  }

  @JsonIgnore
  public String getPayload() {
    if (null == shortlinkActivatedEvent
        || !shortlinkActivatedEvent.isPresent()
        || null == shortlinkActivatedEvent.get().getPayload()) {
      return null;
    }
    return shortlinkActivatedEvent.get().getPayload();
  }

  public OptionalValue<String> payload() {
    return null != shortlinkActivatedEvent && shortlinkActivatedEvent.isPresent()
        ? shortlinkActivatedEvent
            .map(f -> ((ShortLinkActivatedEventInternalImpl) f).payload())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getTitle() {
    if (null == shortlinkActivatedEvent
        || !shortlinkActivatedEvent.isPresent()
        || null == shortlinkActivatedEvent.get().getTitle()) {
      return null;
    }
    return shortlinkActivatedEvent.get().getTitle();
  }

  public OptionalValue<String> title() {
    return null != shortlinkActivatedEvent && shortlinkActivatedEvent.isPresent()
        ? shortlinkActivatedEvent
            .map(f -> ((ShortLinkActivatedEventInternalImpl) f).title())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getRef() {
    if (null == shortlinkActivatedEvent
        || !shortlinkActivatedEvent.isPresent()
        || null == shortlinkActivatedEvent.get().getRef()) {
      return null;
    }
    return shortlinkActivatedEvent.get().getRef();
  }

  public OptionalValue<String> ref() {
    return null != shortlinkActivatedEvent && shortlinkActivatedEvent.isPresent()
        ? shortlinkActivatedEvent
            .map(f -> ((ShortLinkActivatedEventInternalImpl) f).ref())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getSource() {
    if (null == shortlinkActivatedEvent
        || !shortlinkActivatedEvent.isPresent()
        || null == shortlinkActivatedEvent.get().getSource()) {
      return null;
    }
    return shortlinkActivatedEvent.get().getSource();
  }

  public OptionalValue<String> source() {
    return null != shortlinkActivatedEvent && shortlinkActivatedEvent.isPresent()
        ? shortlinkActivatedEvent
            .map(f -> ((ShortLinkActivatedEventInternalImpl) f).source())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getType() {
    if (null == shortlinkActivatedEvent
        || !shortlinkActivatedEvent.isPresent()
        || null == shortlinkActivatedEvent.get().getType()) {
      return null;
    }
    return shortlinkActivatedEvent.get().getType();
  }

  public OptionalValue<String> type() {
    return null != shortlinkActivatedEvent && shortlinkActivatedEvent.isPresent()
        ? shortlinkActivatedEvent
            .map(f -> ((ShortLinkActivatedEventInternalImpl) f).type())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Boolean getExistingThread() {
    if (null == shortlinkActivatedEvent
        || !shortlinkActivatedEvent.isPresent()
        || null == shortlinkActivatedEvent.get().getExistingThread()) {
      return null;
    }
    return shortlinkActivatedEvent.get().getExistingThread();
  }

  public OptionalValue<Boolean> existingThread() {
    return null != shortlinkActivatedEvent && shortlinkActivatedEvent.isPresent()
        ? shortlinkActivatedEvent
            .map(f -> ((ShortLinkActivatedEventInternalImpl) f).existingThread())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this Short_Link_Activated object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShortLinkActivatedEventImpl shortLinkActivated = (ShortLinkActivatedEventImpl) o;
    return Objects.equals(this.shortlinkActivatedEvent, shortLinkActivated.shortlinkActivatedEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortlinkActivatedEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShortLinkActivatedEventImpl {\n");
    sb.append("    shortlinkActivatedEvent: ")
        .append(toIndentedString(shortlinkActivatedEvent))
        .append("\n");
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
  static class Builder implements ShortLinkActivatedEvent.Builder {
    OptionalValue<ShortLinkActivatedEventInternal> shortlinkActivatedEvent = OptionalValue.empty();

    ShortLinkActivatedEventInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_SHORTLINK_ACTIVATED_EVENT, required = true)
    public Builder setShortlinkActivatedEvent(
        ShortLinkActivatedEventInternal shortlinkActivatedEvent) {
      this.shortlinkActivatedEvent = OptionalValue.of(shortlinkActivatedEvent);
      return this;
    }

    @JsonIgnore
    public Builder setPayload(String payload) {
      getDelegatedBuilder().setPayload(payload);
      return this;
    }

    @JsonIgnore
    public Builder setTitle(String title) {
      getDelegatedBuilder().setTitle(title);
      return this;
    }

    @JsonIgnore
    public Builder setRef(String ref) {
      getDelegatedBuilder().setRef(ref);
      return this;
    }

    @JsonIgnore
    public Builder setSource(String source) {
      getDelegatedBuilder().setSource(source);
      return this;
    }

    @JsonIgnore
    public Builder setType(String type) {
      getDelegatedBuilder().setType(type);
      return this;
    }

    @JsonIgnore
    public Builder setExistingThread(Boolean existingThread) {
      getDelegatedBuilder().setExistingThread(existingThread);
      return this;
    }

    private ShortLinkActivatedEventInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ShortLinkActivatedEventInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public ShortLinkActivatedEvent build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.shortlinkActivatedEvent = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new ShortLinkActivatedEventImpl(shortlinkActivatedEvent);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<ShortLinkActivatedEvent>> {
    @Override
    public void serialize(
        OptionalValue<ShortLinkActivatedEvent> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      ShortLinkActivatedEventImpl impl = (ShortLinkActivatedEventImpl) value.get();
      jgen.writeObject(null != impl ? impl.getShortlinkActivatedEvent() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<ShortLinkActivatedEvent> {
    @Override
    public ShortLinkActivatedEvent deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      ShortLinkActivatedEventImpl.Builder builder = new ShortLinkActivatedEventImpl.Builder();
      ShortLinkActivatedEventInternalImpl deserialized =
          jp.readValueAs(ShortLinkActivatedEventInternalImpl.class);
      builder.setShortlinkActivatedEvent(deserialized);
      return builder.build();
    }
  }

  public static Optional<ShortLinkActivatedEvent> delegatedConverter(
      ShortLinkActivatedEventInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setShortlinkActivatedEvent(internal).build());
  }
}
