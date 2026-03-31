package com.sinch.sdk.domains.voice.models.v1.applications;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({EventDestinationsImpl.JSON_PROPERTY_URL})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EventDestinationsImpl implements EventDestinations {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<EventDestinationTarget> target;

  public EventDestinationsImpl() {}

  protected EventDestinationsImpl(OptionalValue<EventDestinationTarget> target) {
    this.target = target;
  }

  @JsonIgnore
  public EventDestinationTarget getTarget() {
    return target.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<EventDestinationTarget> target() {
    return target;
  }

  /** Return true if this callbacks object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventDestinationsImpl callbacks = (EventDestinationsImpl) o;
    return Objects.equals(this.target, callbacks.target);
  }

  @Override
  public int hashCode() {
    return Objects.hash(target);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventDestinationsImpl {\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
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
  static class Builder implements EventDestinations.Builder {
    OptionalValue<EventDestinationTarget> target = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_URL)
    public Builder setTarget(EventDestinationTarget target) {
      this.target = OptionalValue.of(target);
      return this;
    }

    public EventDestinations build() {
      return new EventDestinationsImpl(target);
    }
  }
}
