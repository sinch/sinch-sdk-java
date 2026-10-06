package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.SessionState;
import java.util.Objects;

@JsonPropertyOrder({
  BatchSessionSummaryImpl.JSON_PROPERTY_ID,
  BatchSessionSummaryImpl.JSON_PROPERTY_STATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class BatchSessionSummaryImpl implements BatchSessionSummary {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_STATE = "state";

  private OptionalValue<SessionState> state;

  public BatchSessionSummaryImpl() {}

  protected BatchSessionSummaryImpl(OptionalValue<String> id, OptionalValue<SessionState> state) {
    this.id = id;
    this.state = state;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public SessionState getState() {
    return state.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SessionState> state() {
    return state;
  }

  /** Return true if this BatchSessionSummary object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchSessionSummaryImpl batchSessionSummary = (BatchSessionSummaryImpl) o;
    return Objects.equals(this.id, batchSessionSummary.id)
        && Objects.equals(this.state, batchSessionSummary.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchSessionSummaryImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
  static class Builder implements BatchSessionSummary.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<SessionState> state = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    public Builder setState(SessionState state) {
      this.state = OptionalValue.of(state);
      return this;
    }

    public BatchSessionSummary build() {
      return new BatchSessionSummaryImpl(id, state);
    }
  }
}
