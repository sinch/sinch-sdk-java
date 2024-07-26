package com.sinch.sdk.domains.conversation.models.v1.conversation.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({InjectEventRequestImpl.JSON_PROPERTY_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class InjectEventRequestImpl implements InjectEventRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_EVENT = "event";

  private OptionalValue<InjectConversationEventRequest> event;

  public InjectEventRequestImpl() {}

  protected InjectEventRequestImpl(OptionalValue<InjectConversationEventRequest> event) {
    this.event = event;
  }

  @JsonIgnore
  public InjectConversationEventRequest getEvent() {
    return event.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<InjectConversationEventRequest> event() {
    return event;
  }

  /** Return true if this InjectEventRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InjectEventRequestImpl injectEventRequest = (InjectEventRequestImpl) o;
    return Objects.equals(this.event, injectEventRequest.event);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InjectEventRequestImpl {\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
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
  static class Builder implements InjectEventRequest.Builder {
    OptionalValue<InjectConversationEventRequest> event = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_EVENT)
    public Builder setEvent(InjectConversationEventRequest event) {
      this.event = OptionalValue.of(event);
      return this;
    }

    public InjectEventRequest build() {
      return new InjectEventRequestImpl(event);
    }
  }
}
