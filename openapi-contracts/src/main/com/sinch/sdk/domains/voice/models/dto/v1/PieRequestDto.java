/*
 * Voice API | Sinch
 * The Voice API exposes calling- and conference-related functionality in the Sinch Voice Platform.
 *
 * The version of the OpenAPI document: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sinch.sdk.core.utils.databind.JSONNavigator;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** The request body of a Prompt Input Event. */
@JsonPropertyOrder({
  PieRequestDto.JSON_PROPERTY_EVENT,
  PieRequestDto.JSON_PROPERTY_TIMESTAMP,
  PieRequestDto.JSON_PROPERTY_MENU_RESULT,
  PieRequestDto.JSON_PROPERTY_CUSTOM,
  PieRequestDto.JSON_PROPERTY_APPLICATION_KEY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)

/*@JsonIgnoreProperties(
  value = "event", // ignore manually set event, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the event to be set during deserialization
)*/
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NONE,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "event",
    visible = true)
public class PieRequestDto extends WebhooksEventRequestDto {
  /** Must have the value &#x60;pie&#x60;. */
  public enum EventEnum {
    PIE("pie"),

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

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private OffsetDateTime timestamp;
  private boolean timestampDefined = false;

  public static final String JSON_PROPERTY_MENU_RESULT = "menuResult";
  private PieRequestAllOfMenuResultDto menuResult;
  private boolean menuResultDefined = false;

  public static final String JSON_PROPERTY_CUSTOM = "custom";
  private String custom;
  private boolean customDefined = false;

  public static final String JSON_PROPERTY_APPLICATION_KEY = "applicationKey";
  private String applicationKey;
  private boolean applicationKeyDefined = false;

  public PieRequestDto() {}

  public PieRequestDto event(String event) {
    this.event = event;
    this.eventDefined = true;
    return this;
  }

  /**
   * Must have the value &#x60;pie&#x60;.
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

  public PieRequestDto timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    this.timestampDefined = true;
    return this;
  }

  /**
   * The timestamp in UTC format.
   *
   * @return timestamp
   */
  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  @JsonIgnore
  public boolean getTimestampDefined() {
    return timestampDefined;
  }

  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    this.timestampDefined = true;
  }

  public PieRequestDto menuResult(PieRequestAllOfMenuResultDto menuResult) {
    this.menuResult = menuResult;
    this.menuResultDefined = true;
    return this;
  }

  /**
   * Get menuResult
   *
   * @return menuResult
   */
  @JsonProperty(JSON_PROPERTY_MENU_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public PieRequestAllOfMenuResultDto getMenuResult() {
    return menuResult;
  }

  @JsonIgnore
  public boolean getMenuResultDefined() {
    return menuResultDefined;
  }

  @JsonProperty(JSON_PROPERTY_MENU_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMenuResult(PieRequestAllOfMenuResultDto menuResult) {
    this.menuResult = menuResult;
    this.menuResultDefined = true;
  }

  public PieRequestDto custom(String custom) {
    this.custom = custom;
    this.customDefined = true;
    return this;
  }

  /**
   * A string that can be used to pass custom information related to the call.
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

  public PieRequestDto applicationKey(String applicationKey) {
    this.applicationKey = applicationKey;
    this.applicationKeyDefined = true;
    return this;
  }

  /**
   * The unique application key. You can find it in the Sinch
   * [dashboard](https://dashboard.sinch.com/voice/apps).
   *
   * @return applicationKey
   */
  @JsonProperty(JSON_PROPERTY_APPLICATION_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getApplicationKey() {
    return applicationKey;
  }

  @JsonIgnore
  public boolean getApplicationKeyDefined() {
    return applicationKeyDefined;
  }

  @JsonProperty(JSON_PROPERTY_APPLICATION_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setApplicationKey(String applicationKey) {
    this.applicationKey = applicationKey;
    this.applicationKeyDefined = true;
  }

  @Override
  public PieRequestDto callid(String callid) {
    this.setCallid(callid);
    return this;
  }

  @Override
  public PieRequestDto version(Integer version) {
    this.setVersion(version);
    return this;
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
    PieRequestDto pieRequest = (PieRequestDto) o;
    return Objects.equals(this.event, pieRequest.event)
        && Objects.equals(this.timestamp, pieRequest.timestamp)
        && Objects.equals(this.menuResult, pieRequest.menuResult)
        && Objects.equals(this.custom, pieRequest.custom)
        && Objects.equals(this.applicationKey, pieRequest.applicationKey)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, timestamp, menuResult, custom, applicationKey, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PieRequestDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    menuResult: ").append(toIndentedString(menuResult)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    applicationKey: ").append(toIndentedString(applicationKey)).append("\n");
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

  static {
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("pieRequest", PieRequestDto.class);
    JSONNavigator.registerDiscriminator(PieRequestDto.class, "event", mappings);
  }
}
