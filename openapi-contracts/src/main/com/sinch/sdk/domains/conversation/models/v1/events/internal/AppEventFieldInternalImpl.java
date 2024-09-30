package com.sinch.sdk.domains.conversation.models.v1.events.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.events.AppEvent;
import java.util.Objects;

@JsonPropertyOrder({AppEventFieldInternalImpl.JSON_PROPERTY_APP_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AppEventFieldInternalImpl implements AppEventFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_EVENT = "app_event";

  private OptionalValue<AppEvent> appEvent;

  public AppEventFieldInternalImpl() {}

  protected AppEventFieldInternalImpl(OptionalValue<AppEvent> appEvent) {
    this.appEvent = appEvent;
  }

  @JsonIgnore
  public AppEvent getAppEvent() {
    return appEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AppEvent> appEvent() {
    return appEvent;
  }

  /** Return true if this AppEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppEventFieldInternalImpl appEventField = (AppEventFieldInternalImpl) o;
    return Objects.equals(this.appEvent, appEventField.appEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppEventFieldInternalImpl {\n");
    sb.append("    appEvent: ").append(toIndentedString(appEvent)).append("\n");
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
  static class Builder implements AppEventFieldInternal.Builder {
    OptionalValue<AppEvent> appEvent = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_APP_EVENT, required = true)
    public Builder setAppEvent(AppEvent appEvent) {
      this.appEvent = OptionalValue.of(appEvent);
      return this;
    }

    public AppEventFieldInternal build() {
      return new AppEventFieldInternalImpl(appEvent);
    }
  }
}
