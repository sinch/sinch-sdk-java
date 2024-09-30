package com.sinch.sdk.domains.conversation.models.v1.events.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ShortLinkActivatedEventInternalImpl.JSON_PROPERTY_PAYLOAD,
  ShortLinkActivatedEventInternalImpl.JSON_PROPERTY_TITLE,
  ShortLinkActivatedEventInternalImpl.JSON_PROPERTY_REF,
  ShortLinkActivatedEventInternalImpl.JSON_PROPERTY_SOURCE,
  ShortLinkActivatedEventInternalImpl.JSON_PROPERTY_TYPE,
  ShortLinkActivatedEventInternalImpl.JSON_PROPERTY_EXISTING_THREAD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ShortLinkActivatedEventInternalImpl implements ShortLinkActivatedEventInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PAYLOAD = "payload";

  private OptionalValue<String> payload;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_REF = "ref";

  private OptionalValue<String> ref;

  public static final String JSON_PROPERTY_SOURCE = "source";

  private OptionalValue<String> source;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<String> type;

  public static final String JSON_PROPERTY_EXISTING_THREAD = "existing_thread";

  private OptionalValue<Boolean> existingThread;

  public ShortLinkActivatedEventInternalImpl() {}

  protected ShortLinkActivatedEventInternalImpl(
      OptionalValue<String> payload,
      OptionalValue<String> title,
      OptionalValue<String> ref,
      OptionalValue<String> source,
      OptionalValue<String> type,
      OptionalValue<Boolean> existingThread) {
    this.payload = payload;
    this.title = title;
    this.ref = ref;
    this.source = source;
    this.type = type;
    this.existingThread = existingThread;
  }

  @JsonIgnore
  public String getPayload() {
    return payload.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAYLOAD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> payload() {
    return payload;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> title() {
    return title;
  }

  @JsonIgnore
  public String getRef() {
    return ref.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> ref() {
    return ref;
  }

  @JsonIgnore
  public String getSource() {
    return source.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> source() {
    return source;
  }

  @JsonIgnore
  public String getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> type() {
    return type;
  }

  @JsonIgnore
  public Boolean getExistingThread() {
    return existingThread.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXISTING_THREAD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> existingThread() {
    return existingThread;
  }

  /** Return true if this ShortLinkActivatedEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShortLinkActivatedEventInternalImpl shortLinkActivatedEvent =
        (ShortLinkActivatedEventInternalImpl) o;
    return Objects.equals(this.payload, shortLinkActivatedEvent.payload)
        && Objects.equals(this.title, shortLinkActivatedEvent.title)
        && Objects.equals(this.ref, shortLinkActivatedEvent.ref)
        && Objects.equals(this.source, shortLinkActivatedEvent.source)
        && Objects.equals(this.type, shortLinkActivatedEvent.type)
        && Objects.equals(this.existingThread, shortLinkActivatedEvent.existingThread);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payload, title, ref, source, type, existingThread);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShortLinkActivatedEventInternalImpl {\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    ref: ").append(toIndentedString(ref)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    existingThread: ").append(toIndentedString(existingThread)).append("\n");
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
  static class Builder implements ShortLinkActivatedEventInternal.Builder {
    OptionalValue<String> payload = OptionalValue.empty();
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<String> ref = OptionalValue.empty();
    OptionalValue<String> source = OptionalValue.empty();
    OptionalValue<String> type = OptionalValue.empty();
    OptionalValue<Boolean> existingThread = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PAYLOAD)
    public Builder setPayload(String payload) {
      this.payload = OptionalValue.of(payload);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REF)
    public Builder setRef(String ref) {
      this.ref = OptionalValue.of(ref);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SOURCE)
    public Builder setSource(String source) {
      this.source = OptionalValue.of(source);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(String type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EXISTING_THREAD)
    public Builder setExistingThread(Boolean existingThread) {
      this.existingThread = OptionalValue.of(existingThread);
      return this;
    }

    public ShortLinkActivatedEventInternal build() {
      return new ShortLinkActivatedEventInternalImpl(
          payload, title, ref, source, type, existingThread);
    }
  }
}
