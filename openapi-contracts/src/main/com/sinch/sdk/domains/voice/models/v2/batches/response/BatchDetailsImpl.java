package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({BatchDetailsImpl.JSON_PROPERTY_SESSIONS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class BatchDetailsImpl implements BatchDetails {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SESSIONS = "sessions";

  private OptionalValue<List<BatchSessionSummary>> sessions;

  public BatchDetailsImpl() {}

  protected BatchDetailsImpl(OptionalValue<List<BatchSessionSummary>> sessions) {
    this.sessions = sessions;
  }

  @JsonIgnore
  public List<BatchSessionSummary> getSessions() {
    return sessions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SESSIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<BatchSessionSummary>> sessions() {
    return sessions;
  }

  /** Return true if this BatchDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchDetailsImpl batchDetails = (BatchDetailsImpl) o;
    return Objects.equals(this.sessions, batchDetails.sessions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchDetailsImpl {\n");
    sb.append("    sessions: ").append(toIndentedString(sessions)).append("\n");
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
  static class Builder implements BatchDetails.Builder {
    OptionalValue<List<BatchSessionSummary>> sessions = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_SESSIONS, required = true)
    public Builder setSessions(List<BatchSessionSummary> sessions) {
      this.sessions = OptionalValue.of(sessions);
      return this;
    }

    public BatchDetails build() {
      return new BatchDetailsImpl(sessions);
    }
  }
}
