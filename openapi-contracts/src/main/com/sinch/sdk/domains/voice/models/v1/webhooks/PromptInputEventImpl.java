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
  PromptInputEventImpl.JSON_PROPERTY_EVENT,
  PromptInputEventImpl.JSON_PROPERTY_TIMESTAMP,
  PromptInputEventImpl.JSON_PROPERTY_MENU_RESULT,
  PromptInputEventImpl.JSON_PROPERTY_CUSTOM,
  PromptInputEventImpl.JSON_PROPERTY_APPLICATION_KEY,
  PromptInputEventImpl.JSON_PROPERTY_CALLID,
  PromptInputEventImpl.JSON_PROPERTY_VERSION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)

/*@JsonIgnoreProperties(
  value = "event", // ignore manually set event, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the event to be set during deserialization
)*/
/*@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "event", visible = true)
 */

public class PromptInputEventImpl implements PromptInputEvent, VoiceWebhookEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_EVENT = "event";

  private OptionalValue<WebhooksEventRequestType> event;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";

  private OptionalValue<Instant> timestamp;

  public static final String JSON_PROPERTY_MENU_RESULT = "menuResult";

  private OptionalValue<MenuResult> menuResult;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_APPLICATION_KEY = "applicationKey";

  private OptionalValue<String> applicationKey;

  public static final String JSON_PROPERTY_CALLID = "callid";

  private OptionalValue<String> callid;

  public static final String JSON_PROPERTY_VERSION = "version";

  private OptionalValue<Integer> version;

  public PromptInputEventImpl() {}

  protected PromptInputEventImpl(
      OptionalValue<WebhooksEventRequestType> event,
      OptionalValue<Instant> timestamp,
      OptionalValue<MenuResult> menuResult,
      OptionalValue<String> custom,
      OptionalValue<String> applicationKey,
      OptionalValue<String> callid,
      OptionalValue<Integer> version) {
    this.event = event;
    this.timestamp = timestamp;
    this.menuResult = menuResult;
    this.custom = custom;
    this.applicationKey = applicationKey;
    this.callid = callid;
    this.version = version;
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
  public Instant getTimestamp() {
    return timestamp.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> timestamp() {
    return timestamp;
  }

  @JsonIgnore
  public MenuResult getMenuResult() {
    return menuResult.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MENU_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MenuResult> menuResult() {
    return menuResult;
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

  /** Return true if this pieRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PromptInputEventImpl pieRequest = (PromptInputEventImpl) o;
    return Objects.equals(this.event, pieRequest.event)
        && Objects.equals(this.timestamp, pieRequest.timestamp)
        && Objects.equals(this.menuResult, pieRequest.menuResult)
        && Objects.equals(this.custom, pieRequest.custom)
        && Objects.equals(this.applicationKey, pieRequest.applicationKey)
        && Objects.equals(this.callid, pieRequest.callid)
        && Objects.equals(this.version, pieRequest.version)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        event, timestamp, menuResult, custom, applicationKey, callid, version, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PromptInputEventImpl {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    menuResult: ").append(toIndentedString(menuResult)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    applicationKey: ").append(toIndentedString(applicationKey)).append("\n");
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
  static class Builder implements PromptInputEvent.Builder {
    OptionalValue<WebhooksEventRequestType> event = OptionalValue.of(WebhooksEventRequestType.PIE);
    OptionalValue<Instant> timestamp = OptionalValue.empty();
    OptionalValue<MenuResult> menuResult = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<String> applicationKey = OptionalValue.empty();
    OptionalValue<String> callid = OptionalValue.empty();
    OptionalValue<Integer> version = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TIMESTAMP)
    public Builder setTimestamp(Instant timestamp) {
      this.timestamp = OptionalValue.of(timestamp);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MENU_RESULT)
    public Builder setMenuResult(MenuResult menuResult) {
      this.menuResult = OptionalValue.of(menuResult);
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

    public PromptInputEvent build() {
      return new PromptInputEventImpl(
          event, timestamp, menuResult, custom, applicationKey, callid, version);
    }
  }
}