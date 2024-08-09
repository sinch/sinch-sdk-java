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
import com.sinch.sdk.domains.conversation.models.v1.Agent;
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.AgentLeftEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.AgentLeftEventInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({AgentLeftEventImpl.JSON_PROPERTY_AGENT_LEFT_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AgentLeftEventImpl
    implements AgentLeftEvent, com.sinch.sdk.domains.conversation.models.v1.events.AppEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_AGENT_LEFT_EVENT = "agent_left_event";

  private OptionalValue<AgentLeftEventInternal> agentLeftEvent;

  public AgentLeftEventImpl() {}

  protected AgentLeftEventImpl(OptionalValue<AgentLeftEventInternal> agentLeftEvent) {
    this.agentLeftEvent = agentLeftEvent;
  }

  @JsonIgnore
  public AgentLeftEventInternal getAgentLeftEvent() {
    return agentLeftEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AGENT_LEFT_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AgentLeftEventInternal> agentLeftEvent() {
    return agentLeftEvent;
  }

  @JsonIgnore
  public Agent getAgent() {
    if (null == agentLeftEvent
        || !agentLeftEvent.isPresent()
        || null == agentLeftEvent.get().getAgent()) {
      return null;
    }
    return agentLeftEvent.get().getAgent();
  }

  public OptionalValue<Agent> agent() {
    return null != agentLeftEvent && agentLeftEvent.isPresent()
        ? agentLeftEvent
            .map(f -> ((AgentLeftEventInternalImpl) f).agent())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this AgentLeftEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgentLeftEventImpl agentLeftEventField = (AgentLeftEventImpl) o;
    return Objects.equals(this.agentLeftEvent, agentLeftEventField.agentLeftEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agentLeftEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgentLeftEventImpl {\n");
    sb.append("    agentLeftEvent: ").append(toIndentedString(agentLeftEvent)).append("\n");
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
  static class Builder implements AgentLeftEvent.Builder {
    OptionalValue<AgentLeftEventInternal> agentLeftEvent = OptionalValue.empty();

    AgentLeftEventInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_AGENT_LEFT_EVENT, required = true)
    public Builder setAgentLeftEvent(AgentLeftEventInternal agentLeftEvent) {
      this.agentLeftEvent = OptionalValue.of(agentLeftEvent);
      return this;
    }

    @JsonIgnore
    public Builder setAgent(Agent agent) {
      getDelegatedBuilder().setAgent(agent);
      return this;
    }

    private AgentLeftEventInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = AgentLeftEventInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public AgentLeftEvent build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.agentLeftEvent = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new AgentLeftEventImpl(agentLeftEvent);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<AgentLeftEvent>> {
    @Override
    public void serialize(
        OptionalValue<AgentLeftEvent> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      AgentLeftEventImpl impl = (AgentLeftEventImpl) value.get();
      jgen.writeObject(impl.getAgentLeftEvent());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<AgentLeftEvent> {
    @Override
    public AgentLeftEvent deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      AgentLeftEventImpl.Builder builder = new AgentLeftEventImpl.Builder();
      AgentLeftEventInternalImpl deserialized = jp.readValueAs(AgentLeftEventInternalImpl.class);
      builder.setAgentLeftEvent(deserialized);
      return builder.build();
    }
  }

  public static Optional<AgentLeftEvent> delegatedConverter(AgentLeftEventInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setAgentLeftEvent(internal).build());
  }
}
