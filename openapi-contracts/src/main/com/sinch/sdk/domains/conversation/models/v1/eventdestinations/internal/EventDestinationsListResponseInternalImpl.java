package com.sinch.sdk.domains.conversation.models.v1.eventdestinations.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.eventdestinations.EventDestination;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({EventDestinationsListResponseInternalImpl.JSON_PROPERTY_WEBHOOKS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EventDestinationsListResponseInternalImpl
    implements EventDestinationsListResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_WEBHOOKS = "webhooks";

  private OptionalValue<List<EventDestination>> eventDestinations;

  public EventDestinationsListResponseInternalImpl() {}

  protected EventDestinationsListResponseInternalImpl(
      OptionalValue<List<EventDestination>> eventDestinations) {
    this.eventDestinations = eventDestinations;
  }

  @JsonIgnore
  public List<EventDestination> getEventDestinations() {
    return eventDestinations.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WEBHOOKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<EventDestination>> eventDestinations() {
    return eventDestinations;
  }

  /** Return true if this ListWebhooksResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventDestinationsListResponseInternalImpl listWebhooksResponse =
        (EventDestinationsListResponseInternalImpl) o;
    return Objects.equals(this.eventDestinations, listWebhooksResponse.eventDestinations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventDestinations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventDestinationsListResponseInternalImpl {\n");
    sb.append("    eventDestinations: ").append(toIndentedString(eventDestinations)).append("\n");
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
  static class Builder implements EventDestinationsListResponseInternal.Builder {
    OptionalValue<List<EventDestination>> eventDestinations = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_WEBHOOKS)
    public Builder setEventDestinations(List<EventDestination> eventDestinations) {
      this.eventDestinations = OptionalValue.of(eventDestinations);
      return this;
    }

    public EventDestinationsListResponseInternal build() {
      return new EventDestinationsListResponseInternalImpl(eventDestinations);
    }
  }
}
