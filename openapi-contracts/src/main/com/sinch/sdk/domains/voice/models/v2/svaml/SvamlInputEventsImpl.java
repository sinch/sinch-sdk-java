package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({SvamlInputEventsImpl.JSON_PROPERTY_ON_HANGUP})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlInputEventsImpl implements SvamlInputEvents {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ON_HANGUP = "onHangup";

  private OptionalValue<List<SvamlCommand>> onHangup;

  public SvamlInputEventsImpl() {}

  protected SvamlInputEventsImpl(OptionalValue<List<SvamlCommand>> onHangup) {
    this.onHangup = onHangup;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnHangup() {
    return onHangup.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_HANGUP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onHangup() {
    return onHangup;
  }

  /** Return true if this SvamlInputEvents object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlInputEventsImpl svamlInputEvents = (SvamlInputEventsImpl) o;
    return Objects.equals(this.onHangup, svamlInputEvents.onHangup);
  }

  @Override
  public int hashCode() {
    return Objects.hash(onHangup);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlInputEventsImpl {\n");
    sb.append("    onHangup: ").append(toIndentedString(onHangup)).append("\n");
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
  static class Builder implements SvamlInputEvents.Builder {
    OptionalValue<List<SvamlCommand>> onHangup = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ON_HANGUP)
    public Builder setOnHangup(List<SvamlCommand> onHangup) {
      this.onHangup = OptionalValue.of(onHangup);
      return this;
    }

    public SvamlInputEvents build() {
      return new SvamlInputEventsImpl(onHangup);
    }
  }
}
