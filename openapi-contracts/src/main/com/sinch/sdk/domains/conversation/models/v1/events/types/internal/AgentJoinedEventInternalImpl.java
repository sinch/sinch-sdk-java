package com.sinch.sdk.domains.conversation.models.v1.events.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.Agent;
import java.util.Objects;

@JsonPropertyOrder({AgentJoinedEventInternalImpl.JSON_PROPERTY_AGENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AgentJoinedEventInternalImpl implements AgentJoinedEventInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_AGENT = "agent";

  private OptionalValue<Agent> agent;

  public AgentJoinedEventInternalImpl() {}

  protected AgentJoinedEventInternalImpl(OptionalValue<Agent> agent) {
    this.agent = agent;
  }

  @JsonIgnore
  public Agent getAgent() {
    return agent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AGENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Agent> agent() {
    return agent;
  }

  /** Return true if this Agent_Joined_Event object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgentJoinedEventInternalImpl agentJoinedEvent = (AgentJoinedEventInternalImpl) o;
    return Objects.equals(this.agent, agentJoinedEvent.agent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgentJoinedEventInternalImpl {\n");
    sb.append("    agent: ").append(toIndentedString(agent)).append("\n");
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
  static class Builder implements AgentJoinedEventInternal.Builder {
    OptionalValue<Agent> agent = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_AGENT, required = true)
    public Builder setAgent(Agent agent) {
      this.agent = OptionalValue.of(agent);
      return this;
    }

    public AgentJoinedEventInternal build() {
      return new AgentJoinedEventInternalImpl(agent);
    }
  }
}
