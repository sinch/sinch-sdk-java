package com.sinch.sdk.domains.voice.models.v2.sessions.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.Call;
import com.sinch.sdk.domains.voice.models.v2.SessionState;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  SessionImpl.JSON_PROPERTY_SESSION_ID,
  SessionImpl.JSON_PROPERTY_PROJECT_ID,
  SessionImpl.JSON_PROPERTY_SERVICE_ID,
  SessionImpl.JSON_PROPERTY_CALLS,
  SessionImpl.JSON_PROPERTY_CREATE_TIME,
  SessionImpl.JSON_PROPERTY_UPDATE_TIME,
  SessionImpl.JSON_PROPERTY_END_TIME,
  SessionImpl.JSON_PROPERTY_STATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SessionImpl implements Session {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SESSION_ID = "sessionId";

  private OptionalValue<String> sessionId;

  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_SERVICE_ID = "serviceId";

  private OptionalValue<String> serviceId;

  public static final String JSON_PROPERTY_CALLS = "calls";

  private OptionalValue<List<Call>> calls;

  public static final String JSON_PROPERTY_CREATE_TIME = "createTime";

  private OptionalValue<Instant> createTime;

  public static final String JSON_PROPERTY_UPDATE_TIME = "updateTime";

  private OptionalValue<Instant> updateTime;

  public static final String JSON_PROPERTY_END_TIME = "endTime";

  private OptionalValue<Instant> endTime;

  public static final String JSON_PROPERTY_STATE = "state";

  private OptionalValue<SessionState> state;

  public SessionImpl() {}

  protected SessionImpl(
      OptionalValue<String> sessionId,
      OptionalValue<String> projectId,
      OptionalValue<String> serviceId,
      OptionalValue<List<Call>> calls,
      OptionalValue<Instant> createTime,
      OptionalValue<Instant> updateTime,
      OptionalValue<Instant> endTime,
      OptionalValue<SessionState> state) {
    this.sessionId = sessionId;
    this.projectId = projectId;
    this.serviceId = serviceId;
    this.calls = calls;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.endTime = endTime;
    this.state = state;
  }

  @JsonIgnore
  public String getSessionId() {
    return sessionId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SESSION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> sessionId() {
    return sessionId;
  }

  @JsonIgnore
  public String getProjectId() {
    return projectId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> projectId() {
    return projectId;
  }

  @JsonIgnore
  public String getServiceId() {
    return serviceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SERVICE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> serviceId() {
    return serviceId;
  }

  @JsonIgnore
  public List<Call> getCalls() {
    return calls.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<Call>> calls() {
    return calls;
  }

  @JsonIgnore
  public Instant getCreateTime() {
    return createTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Instant> createTime() {
    return createTime;
  }

  @JsonIgnore
  public Instant getUpdateTime() {
    return updateTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> updateTime() {
    return updateTime;
  }

  @JsonIgnore
  public Instant getEndTime() {
    return endTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_END_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> endTime() {
    return endTime;
  }

  @JsonIgnore
  public SessionState getState() {
    return state.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<SessionState> state() {
    return state;
  }

  /** Return true if this Session object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionImpl session = (SessionImpl) o;
    return Objects.equals(this.sessionId, session.sessionId)
        && Objects.equals(this.projectId, session.projectId)
        && Objects.equals(this.serviceId, session.serviceId)
        && Objects.equals(this.calls, session.calls)
        && Objects.equals(this.createTime, session.createTime)
        && Objects.equals(this.updateTime, session.updateTime)
        && Objects.equals(this.endTime, session.endTime)
        && Objects.equals(this.state, session.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        sessionId, projectId, serviceId, calls, createTime, updateTime, endTime, state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SessionImpl {\n");
    sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    calls: ").append(toIndentedString(calls)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
  static class Builder implements Session.Builder {
    OptionalValue<String> sessionId = OptionalValue.empty();
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<String> serviceId = OptionalValue.empty();
    OptionalValue<List<Call>> calls = OptionalValue.empty();
    OptionalValue<Instant> createTime = OptionalValue.empty();
    OptionalValue<Instant> updateTime = OptionalValue.empty();
    OptionalValue<Instant> endTime = OptionalValue.empty();
    OptionalValue<SessionState> state = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_SESSION_ID, required = true)
    public Builder setSessionId(String sessionId) {
      this.sessionId = OptionalValue.of(sessionId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_PROJECT_ID, required = true)
    public Builder setProjectId(String projectId) {
      this.projectId = OptionalValue.of(projectId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SERVICE_ID, required = true)
    public Builder setServiceId(String serviceId) {
      this.serviceId = OptionalValue.of(serviceId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CALLS, required = true)
    public Builder setCalls(List<Call> calls) {
      this.calls = OptionalValue.of(calls);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CREATE_TIME, required = true)
    public Builder setCreateTime(Instant createTime) {
      this.createTime = OptionalValue.of(createTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
    public Builder setUpdateTime(Instant updateTime) {
      this.updateTime = OptionalValue.of(updateTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_END_TIME)
    public Builder setEndTime(Instant endTime) {
      this.endTime = OptionalValue.of(endTime);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_STATE, required = true)
    public Builder setState(SessionState state) {
      this.state = OptionalValue.of(state);
      return this;
    }

    public Session build() {
      return new SessionImpl(
          sessionId, projectId, serviceId, calls, createTime, updateTime, endTime, state);
    }
  }
}
