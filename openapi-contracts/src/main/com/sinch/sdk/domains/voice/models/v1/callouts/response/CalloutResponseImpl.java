package com.sinch.sdk.domains.voice.models.v1.callouts.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({CalloutResponseImpl.JSON_PROPERTY_CALL_ID})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CalloutResponseImpl implements CalloutResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CALL_ID = "callId";

  private OptionalValue<String> callId;

  public CalloutResponseImpl() {}

  protected CalloutResponseImpl(OptionalValue<String> callId) {
    this.callId = callId;
  }

  @JsonIgnore
  public String getCallId() {
    return callId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callId() {
    return callId;
  }

  /** Return true if this getCalloutResponseObj object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalloutResponseImpl getCalloutResponseObj = (CalloutResponseImpl) o;
    return Objects.equals(this.callId, getCalloutResponseObj.callId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalloutResponseImpl {\n");
    sb.append("    callId: ").append(toIndentedString(callId)).append("\n");
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
  static class Builder implements CalloutResponse.Builder {
    OptionalValue<String> callId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CALL_ID)
    public Builder setCallId(String callId) {
      this.callId = OptionalValue.of(callId);
      return this;
    }

    public CalloutResponse build() {
      return new CalloutResponseImpl(callId);
    }
  }
}
