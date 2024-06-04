package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationResultEventImpl.JSON_PROPERTY_ID,
  VerificationResultEventImpl.JSON_PROPERTY_EVENT,
  VerificationResultEventImpl.JSON_PROPERTY_METHOD,
  VerificationResultEventImpl.JSON_PROPERTY_IDENTITY,
  VerificationResultEventImpl.JSON_PROPERTY_STATUS,
  VerificationResultEventImpl.JSON_PROPERTY_REASON,
  VerificationResultEventImpl.JSON_PROPERTY_REFERENCE,
  VerificationResultEventImpl.JSON_PROPERTY_SOURCE,
  VerificationResultEventImpl.JSON_PROPERTY_CUSTOM
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationResultEventImpl implements VerificationResultEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_EVENT = "event";

  private OptionalValue<EventEnum> event;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<IdentityInternal> identity;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<VerificationStatus> status;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<VerificationStatusReason> reason;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_SOURCE = "source";

  private OptionalValue<SourceEnum> source;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public VerificationResultEventImpl() {}

  protected VerificationResultEventImpl(
      OptionalValue<String> id,
      OptionalValue<EventEnum> event,
      OptionalValue<MethodEnum> method,
      OptionalValue<IdentityInternal> identity,
      OptionalValue<VerificationStatus> status,
      OptionalValue<VerificationStatusReason> reason,
      OptionalValue<String> reference,
      OptionalValue<SourceEnum> source,
      OptionalValue<String> custom) {
    this.id = id;
    this.event = event;
    this.method = method;
    this.identity = identity;
    this.status = status;
    this.reason = reason;
    this.reference = reference;
    this.source = source;
    this.custom = custom;
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
  public MethodEnum getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<MethodEnum> method() {
    return method;
  }

  @JsonIgnore
  public IdentityInternal getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<IdentityInternal> identity() {
    return identity;
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
  public String getReference() {
    return reference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> reference() {
    return reference;
  }

  @JsonIgnore
  public SourceEnum getSource() {
    return source.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SourceEnum> source() {
    return source;
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
        && Objects.equals(this.method, verificationResultEvent.method)
        && Objects.equals(this.identity, verificationResultEvent.identity)
        && Objects.equals(this.status, verificationResultEvent.status)
        && Objects.equals(this.reason, verificationResultEvent.reason)
        && Objects.equals(this.reference, verificationResultEvent.reference)
        && Objects.equals(this.source, verificationResultEvent.source)
        && Objects.equals(this.custom, verificationResultEvent.custom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, event, method, identity, status, reason, reference, source, custom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationResultEventImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
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
    OptionalValue<MethodEnum> method = OptionalValue.empty();
    OptionalValue<IdentityInternal> identity = OptionalValue.empty();
    OptionalValue<VerificationStatus> status = OptionalValue.empty();
    OptionalValue<VerificationStatusReason> reason = OptionalValue.empty();
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<SourceEnum> source = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_METHOD)
    public Builder setMethod(MethodEnum method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    public Builder setIdentity(IdentityInternal identity) {
      this.identity = OptionalValue.of(identity);
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

    @JsonProperty(JSON_PROPERTY_REFERENCE)
    public Builder setReference(String reference) {
      this.reference = OptionalValue.of(reference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SOURCE)
    public Builder setSource(SourceEnum source) {
      this.source = OptionalValue.of(source);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM)
    public Builder setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return this;
    }

    public VerificationResultEvent build() {
      return new VerificationResultEventImpl(
          id, event, method, identity, status, reason, reference, source, custom);
    }
  }
}