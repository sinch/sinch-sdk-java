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
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.AgentJoinedEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.AgentJoinedEventInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({AgentJoinedEventImpl.JSON_PROPERTY_AGENT_JOINED_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AgentJoinedEventImpl
    implements AgentJoinedEvent, com.sinch.sdk.domains.conversation.models.v1.events.AppEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_AGENT_JOINED_EVENT = "agent_joined_event";

  private OptionalValue<AgentJoinedEventInternal> agentJoinedEvent;

  public AgentJoinedEventImpl() {}

  protected AgentJoinedEventImpl(OptionalValue<AgentJoinedEventInternal> agentJoinedEvent) {
    this.agentJoinedEvent = agentJoinedEvent;
  }

  @JsonIgnore
  public AgentJoinedEventInternal getAgentJoinedEvent() {
    return agentJoinedEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AGENT_JOINED_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AgentJoinedEventInternal> agentJoinedEvent() {
    return agentJoinedEvent;
  }

  @JsonIgnore
  public Agent getAgent() {
    if (null == agentJoinedEvent
        || !agentJoinedEvent.isPresent()
        || null == agentJoinedEvent.get().getAgent()) {
      return null;
    }
    return agentJoinedEvent.get().getAgent();
  }

  public OptionalValue<Agent> agent() {
    return null != agentJoinedEvent && agentJoinedEvent.isPresent()
        ? agentJoinedEvent
            .map(f -> ((AgentJoinedEventInternalImpl) f).agent())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this AgentJoinedEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgentJoinedEventImpl agentJoinedEventField = (AgentJoinedEventImpl) o;
    return Objects.equals(this.agentJoinedEvent, agentJoinedEventField.agentJoinedEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agentJoinedEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgentJoinedEventImpl {\n");
    sb.append("    agentJoinedEvent: ").append(toIndentedString(agentJoinedEvent)).append("\n");
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
  static class Builder implements AgentJoinedEvent.Builder {
    OptionalValue<AgentJoinedEventInternal> agentJoinedEvent = OptionalValue.empty();

    AgentJoinedEventInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_AGENT_JOINED_EVENT, required = true)
    public Builder setAgentJoinedEvent(AgentJoinedEventInternal agentJoinedEvent) {
      this.agentJoinedEvent = OptionalValue.of(agentJoinedEvent);
      return this;
    }

    @JsonIgnore
    public Builder setAgent(Agent agent) {
      getDelegatedBuilder().setAgent(agent);
      return this;
    }

    private AgentJoinedEventInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = AgentJoinedEventInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public AgentJoinedEvent build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.agentJoinedEvent = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new AgentJoinedEventImpl(agentJoinedEvent);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<AgentJoinedEvent>> {
    @Override
    public void serialize(
        OptionalValue<AgentJoinedEvent> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      AgentJoinedEventImpl impl = (AgentJoinedEventImpl) value.get();
      jgen.writeObject(null != impl ? impl.getAgentJoinedEvent() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<AgentJoinedEvent> {
    @Override
    public AgentJoinedEvent deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      AgentJoinedEventImpl.Builder builder = new AgentJoinedEventImpl.Builder();
      AgentJoinedEventInternalImpl deserialized =
          jp.readValueAs(AgentJoinedEventInternalImpl.class);
      builder.setAgentJoinedEvent(deserialized);
      return builder.build();
    }
  }

  public static Optional<AgentJoinedEvent> delegatedConverter(AgentJoinedEventInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setAgentJoinedEvent(internal).build());
  }
}
