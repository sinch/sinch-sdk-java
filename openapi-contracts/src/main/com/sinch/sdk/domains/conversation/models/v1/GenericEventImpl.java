package com.sinch.sdk.domains.conversation.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({GenericEventImpl.JSON_PROPERTY_PAYLOAD})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GenericEventImpl implements GenericEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PAYLOAD = "payload";

  private OptionalValue<Object> payload;

  public GenericEventImpl() {}

  protected GenericEventImpl(OptionalValue<Object> payload) {
    this.payload = payload;
  }

  @JsonIgnore
  public Object getPayload() {
    return payload.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAYLOAD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Object> payload() {
    return payload;
  }

  /** Return true if this Generic_Event object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericEventImpl genericEvent = (GenericEventImpl) o;
    return Objects.equals(this.payload, genericEvent.payload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payload);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenericEventImpl {\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
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
    OptionalValue<Object> payload = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PAYLOAD)
    public Builder setPayload(Object payload) {
      this.payload = OptionalValue.of(payload);
      return this;
    }

    public GenericEvent build() {
      return new GenericEventImpl(payload);
    }
  }
}
