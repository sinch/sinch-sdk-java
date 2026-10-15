package com.sinch.sdk.domains.voice.models.v2.calls.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  StartCallResponseImpl.JSON_PROPERTY_PROJECT_ID,
  StartCallResponseImpl.JSON_PROPERTY_SERVICE_ID,
  StartCallResponseImpl.JSON_PROPERTY_SESSION_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartCallResponseImpl implements StartCallResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_SERVICE_ID = "serviceId";

  private OptionalValue<String> serviceId;

  public static final String JSON_PROPERTY_SESSION_ID = "sessionId";

  private OptionalValue<String> sessionId;

  public StartCallResponseImpl() {}

  protected StartCallResponseImpl(
      OptionalValue<String> projectId,
      OptionalValue<String> serviceId,
      OptionalValue<String> sessionId) {
    this.projectId = projectId;
    this.serviceId = serviceId;
    this.sessionId = sessionId;
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
  public String getSessionId() {
    return sessionId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SESSION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> sessionId() {
    return sessionId;
  }

  /** Return true if this StartCallResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartCallResponseImpl startCallResponse = (StartCallResponseImpl) o;
    return Objects.equals(this.projectId, startCallResponse.projectId)
        && Objects.equals(this.serviceId, startCallResponse.serviceId)
        && Objects.equals(this.sessionId, startCallResponse.sessionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, serviceId, sessionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartCallResponseImpl {\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
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
  static class Builder implements StartCallResponse.Builder {
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<String> serviceId = OptionalValue.empty();
    OptionalValue<String> sessionId = OptionalValue.empty();

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

    @JsonProperty(value = JSON_PROPERTY_SESSION_ID, required = true)
    public Builder setSessionId(String sessionId) {
      this.sessionId = OptionalValue.of(sessionId);
      return this;
    }

    public StartCallResponse build() {
      return new StartCallResponseImpl(projectId, serviceId, sessionId);
    }
  }
}
