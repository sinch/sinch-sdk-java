package com.sinch.sdk.domains.voice.models.v2.sinchevents;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.Call;
import java.util.Objects;

@JsonPropertyOrder({
  VoiceSinchEventImpl.JSON_PROPERTY_EVENT,
  VoiceSinchEventImpl.JSON_PROPERTY_CALL,
  VoiceSinchEventImpl.JSON_PROPERTY_MENU
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VoiceSinchEventImpl implements VoiceSinchEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_EVENT = "event";

  private OptionalValue<SinchEventType> event;

  public static final String JSON_PROPERTY_CALL = "call";

  private OptionalValue<Call> call;

  public static final String JSON_PROPERTY_MENU = "menu";

  private OptionalValue<MenuInput> menu;

  public VoiceSinchEventImpl() {}

  protected VoiceSinchEventImpl(
      OptionalValue<SinchEventType> event,
      OptionalValue<Call> call,
      OptionalValue<MenuInput> menu) {
    this.event = event;
    this.call = call;
    this.menu = menu;
  }

  @JsonIgnore
  public SinchEventType getEvent() {
    return event.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<SinchEventType> event() {
    return event;
  }

  @JsonIgnore
  public Call getCall() {
    return call.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Call> call() {
    return call;
  }

  @JsonIgnore
  public MenuInput getMenu() {
    return menu.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MENU)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MenuInput> menu() {
    return menu;
  }

  /** Return true if this VoiceSinchEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoiceSinchEventImpl voiceSinchEvent = (VoiceSinchEventImpl) o;
    return Objects.equals(this.event, voiceSinchEvent.event)
        && Objects.equals(this.call, voiceSinchEvent.call)
        && Objects.equals(this.menu, voiceSinchEvent.menu);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, call, menu);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoiceSinchEventImpl {\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    call: ").append(toIndentedString(call)).append("\n");
    sb.append("    menu: ").append(toIndentedString(menu)).append("\n");
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
  static class Builder implements VoiceSinchEvent.Builder {
    OptionalValue<SinchEventType> event = OptionalValue.empty();
    OptionalValue<Call> call = OptionalValue.empty();
    OptionalValue<MenuInput> menu = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_EVENT, required = true)
    public Builder setEvent(SinchEventType event) {
      this.event = OptionalValue.of(event);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CALL, required = true)
    public Builder setCall(Call call) {
      this.call = OptionalValue.of(call);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MENU)
    public Builder setMenu(MenuInput menu) {
      this.menu = OptionalValue.of(menu);
      return this;
    }

    public VoiceSinchEvent build() {
      return new VoiceSinchEventImpl(event, call, menu);
    }
  }
}
