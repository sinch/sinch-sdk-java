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
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.status.StatusSource;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationResultEventImpl.JSON_PROPERTY_ID,
  VerificationResultEventImpl.JSON_PROPERTY_EVENT,
  VerificationResultEventImpl.JSON_PROPERTY_IDENTITY,
  VerificationResultEventImpl.JSON_PROPERTY_REFERENCE,
  VerificationResultEventImpl.JSON_PROPERTY_CUSTOM,
  VerificationResultEventImpl.JSON_PROPERTY_METHOD,
  VerificationResultEventImpl.JSON_PROPERTY_STATUS,
  VerificationResultEventImpl.JSON_PROPERTY_REASON,
  VerificationResultEventImpl.JSON_PROPERTY_SOURCE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationResultEventImpl
    implements VerificationResultEvent,
        com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_EVENT = "event";

  private OptionalValue<EventEnum> event;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<Identity> identity;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<VerificationStatus> status;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<VerificationStatusReason> reason;

  public static final String JSON_PROPERTY_SOURCE = "source";

  private OptionalValue<StatusSource> source;

  public VerificationResultEventImpl() {}

  protected VerificationResultEventImpl(
      OptionalValue<String> id,
      OptionalValue<EventEnum> event,
      OptionalValue<Identity> identity,
      OptionalValue<String> reference,
      OptionalValue<String> custom,
      OptionalValue<VerificationMethod> method,
      OptionalValue<VerificationStatus> status,
      OptionalValue<VerificationStatusReason> reason,
      OptionalValue<StatusSource> source) {
    this.id = id;
    this.event = event;
    this.identity = identity;
    this.reference = reference;
    this.custom = custom;
    this.method = method;
    this.status = status;
    this.reason = reason;
    this.source = source;
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
  public VerificationMethod getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethod> method() {
    return method;
  }

  @JsonIgnore
  public VerificationStatus getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationStatus> status() {
    return status;
  }

  @JsonIgnore
  public VerificationStatusReason getReason() {
    return reason.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStatusReason> reason() {
    return reason;
  }

  @JsonIgnore
  public StatusSource getSource() {
    return source.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StatusSource> source() {
    return source;
  }

  /** Return true if this VerificationResultEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationResultEventImpl verificationResultEvent = (VerificationResultEventImpl) o;
    return Objects.equals(this.id, verificationResultEvent.id)
        && Objects.equals(this.event, verificationResultEvent.event)
        && Objects.equals(this.identity, verificationResultEvent.identity)
        && Objects.equals(this.reference, verificationResultEvent.reference)
        && Objects.equals(this.custom, verificationResultEvent.custom)
        && Objects.equals(this.method, verificationResultEvent.method)
        && Objects.equals(this.status, verificationResultEvent.status)
        && Objects.equals(this.reason, verificationResultEvent.reason)
        && Objects.equals(this.source, verificationResultEvent.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, event, identity, reference, custom, method, status, reason, source);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationResultEventImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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
  static class Builder implements VerificationResultEvent.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<EventEnum> event = OptionalValue.empty();
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.empty();
    OptionalValue<VerificationStatus> status = OptionalValue.empty();
    OptionalValue<VerificationStatusReason> reason = OptionalValue.empty();
    OptionalValue<StatusSource> source = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENT)
    public Builder setEvent(EventEnum event) {
      this.event = OptionalValue.of(event);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_IDENTITY)
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

    @JsonProperty(JSON_PROPERTY_METHOD)
    public Builder setMethod(VerificationMethod method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(VerificationStatus status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REASON)
    public Builder setReason(VerificationStatusReason reason) {
      this.reason = OptionalValue.of(reason);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SOURCE)
    public Builder setSource(StatusSource source) {
      this.source = OptionalValue.of(source);
      return this;
    }

    public VerificationResultEvent build() {
      return new VerificationResultEventImpl(
          id, event, identity, reference, custom, method, status, reason, source);
    }
  }
}
