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
  SMSRequestEventResponseImpl.JSON_PROPERTY_ACTION,
  SMSRequestEventResponseImpl.JSON_PROPERTY_SMS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SMSRequestEventResponseImpl implements SMSRequestEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<VerificationEventResponseAction> action;

  public static final String JSON_PROPERTY_SMS = "sms";

  private OptionalValue<SMSRequestEventResponseSMSContent> sms;

  public SMSRequestEventResponseImpl() {}

  protected SMSRequestEventResponseImpl(
      OptionalValue<VerificationEventResponseAction> action,
      OptionalValue<SMSRequestEventResponseSMSContent> sms) {
    this.action = action;
    this.sms = sms;
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
  public SMSRequestEventResponseSMSContent getSms() {
    return sms.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SMSRequestEventResponseSMSContent> sms() {
    return sms;
  }

  /** Return true if this SMSRequestEventResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SMSRequestEventResponseImpl smSRequestEventResponse = (SMSRequestEventResponseImpl) o;
    return Objects.equals(this.action, smSRequestEventResponse.action)
        && Objects.equals(this.sms, smSRequestEventResponse.sms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, sms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SMSRequestEventResponseImpl {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    sms: ").append(toIndentedString(sms)).append("\n");
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
  static class Builder implements SMSRequestEventResponse.Builder {
    OptionalValue<VerificationEventResponseAction> action = OptionalValue.empty();
    OptionalValue<SMSRequestEventResponseSMSContent> sms = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ACTION)
    public Builder setAction(VerificationEventResponseAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS)
    public Builder setSms(SMSRequestEventResponseSMSContent sms) {
      this.sms = OptionalValue.of(sms);
      return this;
    }

    public SMSRequestEventResponse build() {
      return new SMSRequestEventResponseImpl(action, sms);
    }
  }
}
