package com.sinch.sdk.domains.voice.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  AnsweredCallEventImpl.JSON_PROPERTY_TIMESTAMP,
  AnsweredCallEventImpl.JSON_PROPERTY_CUSTOM,
  AnsweredCallEventImpl.JSON_PROPERTY_APPLICATION_KEY,
  AnsweredCallEventImpl.JSON_PROPERTY_EVENT,
  AnsweredCallEventImpl.JSON_PROPERTY_AMD,
  AnsweredCallEventImpl.JSON_PROPERTY_CALLID,
  AnsweredCallEventImpl.JSON_PROPERTY_VERSION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)

/*@JsonIgnoreProperties(
  value = "event", // ignore manually set event, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the event to be set during deserialization
)*/
/*@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "event", visible = true)
 */

public class AnsweredCallEventImpl
    implements AnsweredCallEvent, VoiceWebhookEvent, VoiceWebhookCallEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";

  private OptionalValue<Instant> timestamp;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_APPLICATION_KEY = "applicationKey";

  private OptionalValue<String> applicationKey;

  public static final String JSON_PROPERTY_EVENT = "event";

  private OptionalValue<WebhooksEventRequestType> event;

  public static final String JSON_PROPERTY_AMD = "amd";

  private OptionalValue<AnsweredCallEventAnsweringMachineDetection> amd;

  public static final String JSON_PROPERTY_CALLID = "callid";

  private OptionalValue<String> callid;

  public static final String JSON_PROPERTY_VERSION = "version";

  private OptionalValue<Integer> version;

  public AnsweredCallEventImpl() {}

  protected AnsweredCallEventImpl(
      OptionalValue<Instant> timestamp,
      OptionalValue<String> custom,
      OptionalValue<String> applicationKey,
      OptionalValue<WebhooksEventRequestType> event,
      OptionalValue<AnsweredCallEventAnsweringMachineDetection> amd,
      OptionalValue<String> callid,
      OptionalValue<Integer> version) {
    this.timestamp = timestamp;
    this.custom = custom;
    this.applicationKey = applicationKey;
    this.event = event;
    this.amd = amd;
    this.callid = callid;
    this.version = version;
  }

  @JsonIgnore
  public Instant getTimestamp() {
    return timestamp.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> timestamp() {
    return timestamp;
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
  public String getApplicationKey() {
    return applicationKey.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APPLICATION_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> applicationKey() {
    return applicationKey;
  }

  @JsonIgnore
  public WebhooksEventRequestType getEvent() {
    return event.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<WebhooksEventRequestType> event() {
    return event;
  }

  @JsonIgnore
  public AnsweredCallEventAnsweringMachineDetection getAmd() {
    return amd.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AMD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AnsweredCallEventAnsweringMachineDetection> amd() {
    return amd;
  }

  @JsonIgnore
  public String getCallid() {
    return callid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callid() {
    return callid;
  }

  @JsonIgnore
  public Integer getVersion() {
    return version.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> version() {
    return version;
  }

  /** Return true if this aceRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnsweredCallEventImpl aceRequest = (AnsweredCallEventImpl) o;
    return Objects.equals(this.timestamp, aceRequest.timestamp)
        && Objects.equals(this.custom, aceRequest.custom)
        && Objects.equals(this.applicationKey, aceRequest.applicationKey)
        && Objects.equals(this.event, aceRequest.event)
        && Objects.equals(this.amd, aceRequest.amd)
        && Objects.equals(this.callid, aceRequest.callid)
        && Objects.equals(this.version, aceRequest.version)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        timestamp, custom, applicationKey, event, amd, callid, version, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnsweredCallEventImpl {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    applicationKey: ").append(toIndentedString(applicationKey)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    amd: ").append(toIndentedString(amd)).append("\n");
    sb.append("    callid: ").append(toIndentedString(callid)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
  static class Builder implements AnsweredCallEvent.Builder {
    OptionalValue<Instant> timestamp = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<String> applicationKey = OptionalValue.empty();
    OptionalValue<WebhooksEventRequestType> event = OptionalValue.of(WebhooksEventRequestType.ACE);
    OptionalValue<AnsweredCallEventAnsweringMachineDetection> amd = OptionalValue.empty();
    OptionalValue<String> callid = OptionalValue.empty();
    OptionalValue<Integer> version = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TIMESTAMP)
    public Builder setTimestamp(Instant timestamp) {
      this.timestamp = OptionalValue.of(timestamp);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM)
    public Builder setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APPLICATION_KEY)
    public Builder setApplicationKey(String applicationKey) {
      this.applicationKey = OptionalValue.of(applicationKey);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_AMD)
    public Builder setAmd(AnsweredCallEventAnsweringMachineDetection amd) {
      this.amd = OptionalValue.of(amd);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLID)
    public Builder setCallid(String callid) {
      this.callid = OptionalValue.of(callid);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    public Builder setVersion(Integer version) {
      this.version = OptionalValue.of(version);
      return this;
    }

    public AnsweredCallEvent build() {
      return new AnsweredCallEventImpl(
          timestamp, custom, applicationKey, event, amd, callid, version);
    }
  }
}