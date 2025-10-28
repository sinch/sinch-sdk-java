package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.Identity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationSmsDeliveredEventImpl.JSON_PROPERTY_ID,
  VerificationSmsDeliveredEventImpl.JSON_PROPERTY_EVENT,
  VerificationSmsDeliveredEventImpl.JSON_PROPERTY_METHOD,
  VerificationSmsDeliveredEventImpl.JSON_PROPERTY_IDENTITY,
  VerificationSmsDeliveredEventImpl.JSON_PROPERTY_REFERENCE,
  VerificationSmsDeliveredEventImpl.JSON_PROPERTY_CUSTOM,
  VerificationSmsDeliveredEventImpl.JSON_PROPERTY_SMS_RESULT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationSmsDeliveredEventImpl
    implements VerificationSmsDeliveredEvent,
        com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_EVENT = "event";

  private OptionalValue<EventEnum> event;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<Identity> identity;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_SMS_RESULT = "smsResult";

  private OptionalValue<SmsResultEnum> smsResult;

  public VerificationSmsDeliveredEventImpl() {}

  protected VerificationSmsDeliveredEventImpl(
      OptionalValue<String> id,
      OptionalValue<EventEnum> event,
      OptionalValue<VerificationMethod> method,
      OptionalValue<Identity> identity,
      OptionalValue<String> reference,
      OptionalValue<String> custom,
      OptionalValue<SmsResultEnum> smsResult) {
    this.id = id;
    this.event = event;
    this.method = method;
    this.identity = identity;
    this.reference = reference;
    this.custom = custom;
    this.smsResult = smsResult;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public EventEnum getEvent() {
    return event.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<EventEnum> event() {
    return event;
  }

  @JsonIgnore
  public VerificationMethod getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethod> method() {
    return method;
  }

  @JsonIgnore
  public Identity getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Identity> identity() {
    return identity;
  }

  @JsonIgnore
  public String getReference() {
    return reference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> reference() {
    return reference;
  }

  @JsonIgnore
  public String getCustom() {
    return custom.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> custom() {
    return custom;
  }

  @JsonIgnore
  public SmsResultEnum getSmsResult() {
    return smsResult.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<SmsResultEnum> smsResult() {
    return smsResult;
  }

  /** Return true if this VerificationSmsDeliveredEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationSmsDeliveredEventImpl verificationSmsDeliveredEvent =
        (VerificationSmsDeliveredEventImpl) o;
    return Objects.equals(this.id, verificationSmsDeliveredEvent.id)
        && Objects.equals(this.event, verificationSmsDeliveredEvent.event)
        && Objects.equals(this.method, verificationSmsDeliveredEvent.method)
        && Objects.equals(this.identity, verificationSmsDeliveredEvent.identity)
        && Objects.equals(this.reference, verificationSmsDeliveredEvent.reference)
        && Objects.equals(this.custom, verificationSmsDeliveredEvent.custom)
        && Objects.equals(this.smsResult, verificationSmsDeliveredEvent.smsResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, event, method, identity, reference, custom, smsResult);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationSmsDeliveredEventImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    smsResult: ").append(toIndentedString(smsResult)).append("\n");
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
  static class Builder implements VerificationSmsDeliveredEvent.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<EventEnum> event = OptionalValue.of(EventEnum.VERIFICATION_SMS_DELIVERED_EVENT);
    OptionalValue<VerificationMethod> method = OptionalValue.empty();
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<SmsResultEnum> smsResult = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ID, required = true)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_EVENT, required = true)
    Builder setEvent(EventEnum event) {
      if (!Objects.equals(event, EventEnum.VERIFICATION_SMS_DELIVERED_EVENT)) {
        throw new IllegalArgumentException(
            String.format(
                "'event' must be '%s' (is '%s')",
                EventEnum.VERIFICATION_SMS_DELIVERED_EVENT, event));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_METHOD, required = true)
    public Builder setMethod(VerificationMethod method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_IDENTITY, required = true)
    public Builder setIdentity(Identity identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REFERENCE)
    public Builder setReference(String reference) {
      this.reference = OptionalValue.of(reference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM)
    public Builder setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SMS_RESULT, required = true)
    public Builder setSmsResult(SmsResultEnum smsResult) {
      this.smsResult = OptionalValue.of(smsResult);
      return this;
    }

    public VerificationSmsDeliveredEvent build() {
      return new VerificationSmsDeliveredEventImpl(
          id, event, method, identity, reference, custom, smsResult);
    }
  }
}
