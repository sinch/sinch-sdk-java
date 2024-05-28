/*
 * Verification | Sinch
 * Verify users with SMS, flash calls (missed calls), a regular call, or data verification.
 *
 * The version of the OpenAPI document: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/** VerificationResultEventDto */
@JsonPropertyOrder({
  VerificationResultEventDto.JSON_PROPERTY_ID,
  VerificationResultEventDto.JSON_PROPERTY_EVENT,
  VerificationResultEventDto.JSON_PROPERTY_METHOD,
  VerificationResultEventDto.JSON_PROPERTY_IDENTITY,
  VerificationResultEventDto.JSON_PROPERTY_STATUS,
  VerificationResultEventDto.JSON_PROPERTY_REASON,
  VerificationResultEventDto.JSON_PROPERTY_REFERENCE,
  VerificationResultEventDto.JSON_PROPERTY_SOURCE,
  VerificationResultEventDto.JSON_PROPERTY_CUSTOM
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationResultEventDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_ID = "id";
  private String id;
  private boolean idDefined = false;

  /** The type of the event. */
  public enum EventEnum {
    VERIFICATIONRESULTEVENT("VerificationResultEvent"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    EventEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EventEnum fromValue(String value) {
      for (EventEnum b : EventEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_EVENT = "event";
  private String event;
  private boolean eventDefined = false;

  /** The verification method. */
  public enum MethodEnum {
    SMS("sms"),

    FLASHCALL("flashcall"),

    CALLOUT("callout"),

    SEAMLESS("seamless"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    MethodEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MethodEnum fromValue(String value) {
      for (MethodEnum b : MethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_METHOD = "method";
  private String method;
  private boolean methodDefined = false;

  public static final String JSON_PROPERTY_IDENTITY = "identity";
  private IdentityDto identity;
  private boolean identityDefined = false;

  public static final String JSON_PROPERTY_STATUS = "status";
  private VerificationStatusDto status;
  private boolean statusDefined = false;

  public static final String JSON_PROPERTY_REASON = "reason";
  private VerificationStatusReasonDto reason;
  private boolean reasonDefined = false;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;
  private boolean referenceDefined = false;

  /** Free text that the client is sending, used to show if the call/SMS was intercepted or not. */
  public enum SourceEnum {
    INTERCEPTED("intercepted"),

    MANUAL("manual"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    SourceEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SourceEnum fromValue(String value) {
      for (SourceEnum b : SourceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_SOURCE = "source";
  private String source;
  private boolean sourceDefined = false;

  public static final String JSON_PROPERTY_CUSTOM = "custom";
  private String custom;
  private boolean customDefined = false;

  public VerificationResultEventDto() {}

  public VerificationResultEventDto id(String id) {
    this.id = id;
    this.idDefined = true;
    return this;
  }

  /**
   * The ID of the verification request.
   *
   * @return id
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getId() {
    return id;
  }

  @JsonIgnore
  public boolean getIdDefined() {
    return idDefined;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
    this.idDefined = true;
  }

  public VerificationResultEventDto event(String event) {
    this.event = event;
    this.eventDefined = true;
    return this;
  }

  /**
   * The type of the event.
   *
   * @return event
   */
  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getEvent() {
    return event;
  }

  @JsonIgnore
  public boolean getEventDefined() {
    return eventDefined;
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEvent(String event) {
    this.event = event;
    this.eventDefined = true;
  }

  public VerificationResultEventDto method(String method) {
    this.method = method;
    this.methodDefined = true;
    return this;
  }

  /**
   * The verification method.
   *
   * @return method
   */
  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getMethod() {
    return method;
  }

  @JsonIgnore
  public boolean getMethodDefined() {
    return methodDefined;
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMethod(String method) {
    this.method = method;
    this.methodDefined = true;
  }

  public VerificationResultEventDto identity(IdentityDto identity) {
    this.identity = identity;
    this.identityDefined = true;
    return this;
  }

  /**
   * Get identity
   *
   * @return identity
   */
  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public IdentityDto getIdentity() {
    return identity;
  }

  @JsonIgnore
  public boolean getIdentityDefined() {
    return identityDefined;
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIdentity(IdentityDto identity) {
    this.identity = identity;
    this.identityDefined = true;
  }

  public VerificationResultEventDto status(VerificationStatusDto status) {
    this.status = status;
    this.statusDefined = true;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public VerificationStatusDto getStatus() {
    return status;
  }

  @JsonIgnore
  public boolean getStatusDefined() {
    return statusDefined;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(VerificationStatusDto status) {
    this.status = status;
    this.statusDefined = true;
  }

  public VerificationResultEventDto reason(VerificationStatusReasonDto reason) {
    this.reason = reason;
    this.reasonDefined = true;
    return this;
  }

  /**
   * Get reason
   *
   * @return reason
   */
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationStatusReasonDto getReason() {
    return reason;
  }

  @JsonIgnore
  public boolean getReasonDefined() {
    return reasonDefined;
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReason(VerificationStatusReasonDto reason) {
    this.reason = reason;
    this.reasonDefined = true;
  }

  public VerificationResultEventDto reference(String reference) {
    this.reference = reference;
    this.referenceDefined = true;
    return this;
  }

  /**
   * The reference ID that was optionally passed together with the verification request.
   *
   * @return reference
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReference() {
    return reference;
  }

  @JsonIgnore
  public boolean getReferenceDefined() {
    return referenceDefined;
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReference(String reference) {
    this.reference = reference;
    this.referenceDefined = true;
  }

  public VerificationResultEventDto source(String source) {
    this.source = source;
    this.sourceDefined = true;
    return this;
  }

  /**
   * Free text that the client is sending, used to show if the call/SMS was intercepted or not.
   *
   * @return source
   */
  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSource() {
    return source;
  }

  @JsonIgnore
  public boolean getSourceDefined() {
    return sourceDefined;
  }

  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSource(String source) {
    this.source = source;
    this.sourceDefined = true;
  }

  public VerificationResultEventDto custom(String custom) {
    this.custom = custom;
    this.customDefined = true;
    return this;
  }

  /**
   * A custom string that can be provided during a verification request.
   *
   * @return custom
   */
  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCustom() {
    return custom;
  }

  @JsonIgnore
  public boolean getCustomDefined() {
    return customDefined;
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustom(String custom) {
    this.custom = custom;
    this.customDefined = true;
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
    VerificationResultEventDto verificationResultEvent = (VerificationResultEventDto) o;
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
    sb.append("class VerificationResultEventDto {\n");
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
}
