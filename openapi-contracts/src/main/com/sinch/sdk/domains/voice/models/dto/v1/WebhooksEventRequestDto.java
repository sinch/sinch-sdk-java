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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sinch.sdk.core.utils.databind.JSONNavigator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** WebhooksEventRequestDto */
@JsonPropertyOrder({
  WebhooksEventRequestDto.JSON_PROPERTY_EVENT,
  WebhooksEventRequestDto.JSON_PROPERTY_CALLID,
  WebhooksEventRequestDto.JSON_PROPERTY_VERSION
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
@JsonSubTypes({
  @JsonSubTypes.Type(value = AceRequestDto.class, name = "aceRequest"),
  @JsonSubTypes.Type(value = DiceRequestDto.class, name = "diceRequest"),
  @JsonSubTypes.Type(value = IceRequestDto.class, name = "iceRequest"),
  @JsonSubTypes.Type(value = NotifyRequestDto.class, name = "notifyRequest"),
  @JsonSubTypes.Type(value = PieRequestDto.class, name = "pieRequest"),
})
public class WebhooksEventRequestDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_EVENT = "event";
  private String event;
  private boolean eventDefined = false;

  public static final String JSON_PROPERTY_CALLID = "callid";
  private String callid;
  private boolean callidDefined = false;

  public static final String JSON_PROPERTY_VERSION = "version";
  private Integer version;
  private boolean versionDefined = false;

  public WebhooksEventRequestDto() {}

  public WebhooksEventRequestDto event(String event) {
    this.event = event;
    this.eventDefined = true;
    return this;
  }

  /**
   * Get event
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

  public WebhooksEventRequestDto callid(String callid) {
    this.callid = callid;
    this.callidDefined = true;
    return this;
  }

  /**
   * The unique ID assigned to this call.
   *
   * @return callid
   */
  @JsonProperty(JSON_PROPERTY_CALLID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCallid() {
    return callid;
  }

  @JsonIgnore
  public boolean getCallidDefined() {
    return callidDefined;
  }

  @JsonProperty(JSON_PROPERTY_CALLID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallid(String callid) {
    this.callid = callid;
    this.callidDefined = true;
  }

  public WebhooksEventRequestDto version(Integer version) {
    this.version = version;
    this.versionDefined = true;
    return this;
  }

  /**
   * The current API version.
   *
   * @return version
   */
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getVersion() {
    return version;
  }

  @JsonIgnore
  public boolean getVersionDefined() {
    return versionDefined;
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVersion(Integer version) {
    this.version = version;
    this.versionDefined = true;
  }

  /** Return true if this webhooksEventRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhooksEventRequestDto webhooksEventRequest = (WebhooksEventRequestDto) o;
    return Objects.equals(this.event, webhooksEventRequest.event)
        && Objects.equals(this.callid, webhooksEventRequest.callid)
        && Objects.equals(this.version, webhooksEventRequest.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, callid, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhooksEventRequestDto {\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
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

  static {
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("aceRequest", AceRequestDto.class);
    mappings.put("diceRequest", DiceRequestDto.class);
    mappings.put("iceRequest", IceRequestDto.class);
    mappings.put("notifyRequest", NotifyRequestDto.class);
    mappings.put("pieRequest", PieRequestDto.class);
    mappings.put("webhooksEventRequest", WebhooksEventRequestDto.class);
    JSONNavigator.registerDiscriminator(WebhooksEventRequestDto.class, "event", mappings);
  }
}
