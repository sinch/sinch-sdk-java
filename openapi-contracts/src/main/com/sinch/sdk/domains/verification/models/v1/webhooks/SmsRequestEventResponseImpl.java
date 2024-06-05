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
  SmsRequestEventResponseImpl.JSON_PROPERTY_ACTION,
  SmsRequestEventResponseImpl.JSON_PROPERTY_SMS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SmsRequestEventResponseImpl implements SmsRequestEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<VerificationEventResponseAction> action;

  public static final String JSON_PROPERTY_SMS = "sms";

  private OptionalValue<SmsRequestEventResponseSmsContent> sms;

  public SmsRequestEventResponseImpl() {}

  protected SmsRequestEventResponseImpl(
      OptionalValue<VerificationEventResponseAction> action,
      OptionalValue<SmsRequestEventResponseSmsContent> sms) {
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
  public SmsRequestEventResponseSmsContent getSms() {
    return sms.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SmsRequestEventResponseSmsContent> sms() {
    return sms;
  }

  /** Return true if this SmsRequestEventResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmsRequestEventResponseImpl smsRequestEventResponse = (SmsRequestEventResponseImpl) o;
    return Objects.equals(this.action, smsRequestEventResponse.action)
        && Objects.equals(this.sms, smsRequestEventResponse.sms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, sms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmsRequestEventResponseImpl {\n");
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
  static class Builder implements SmsRequestEventResponse.Builder {
    OptionalValue<VerificationEventResponseAction> action = OptionalValue.empty();
    OptionalValue<SmsRequestEventResponseSmsContent> sms = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ACTION)
    public Builder setAction(VerificationEventResponseAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS)
    public Builder setSms(SmsRequestEventResponseSmsContent sms) {
      this.sms = OptionalValue.of(sms);
      return this;
    }

    public SmsRequestEventResponse build() {
      return new SmsRequestEventResponseImpl(action, sms);
    }
  }
}
