package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  PhoneCallRequestEventResponseImpl.JSON_PROPERTY_ACTION,
  PhoneCallRequestEventResponseImpl.JSON_PROPERTY_CALLOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PhoneCallRequestEventResponseImpl implements PhoneCallRequestEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<VerificationEventResponseAction> action;

  public static final String JSON_PROPERTY_CALLOUT = "callout";

  private OptionalValue<PhoneCallRequestEventResponsePhoneCallContent> callout;

  public PhoneCallRequestEventResponseImpl() {}

  protected PhoneCallRequestEventResponseImpl(
      OptionalValue<VerificationEventResponseAction> action,
      OptionalValue<PhoneCallRequestEventResponsePhoneCallContent> callout) {
    this.action = action;
    this.callout = callout;
  }

  @JsonIgnore
  public VerificationEventResponseAction getAction() {
    return action.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationEventResponseAction> action() {
    return action;
  }

  @JsonIgnore
  public PhoneCallRequestEventResponsePhoneCallContent getCallout() {
    return callout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<PhoneCallRequestEventResponsePhoneCallContent> callout() {
    return callout;
  }

  /** Return true if this PhoneCallRequestEventResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneCallRequestEventResponseImpl phoneCallRequestEventResponse =
        (PhoneCallRequestEventResponseImpl) o;
    return Objects.equals(this.action, phoneCallRequestEventResponse.action)
        && Objects.equals(this.callout, phoneCallRequestEventResponse.callout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, callout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneCallRequestEventResponseImpl {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    callout: ").append(toIndentedString(callout)).append("\n");
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
  static class Builder implements PhoneCallRequestEventResponse.Builder {
    OptionalValue<VerificationEventResponseAction> action = OptionalValue.empty();
    OptionalValue<PhoneCallRequestEventResponsePhoneCallContent> callout = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ACTION)
    public Builder setAction(VerificationEventResponseAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLOUT)
    public Builder setCallout(PhoneCallRequestEventResponsePhoneCallContent callout) {
      this.callout = OptionalValue.of(callout);
      return this;
    }

    public PhoneCallRequestEventResponse build() {
      return new PhoneCallRequestEventResponseImpl(action, callout);
    }
  }
}
