/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * A collection of messages exchanged between a contact and an app. Conversations are normally
 * created on the fly by Conversation API once a message is sent and there is no active conversation
 * already. There can be only one active conversation at any given time between a particular contact
 * and an app.
 */
@JsonPropertyOrder({
  ConversationDto.JSON_PROPERTY_ACTIVE,
  ConversationDto.JSON_PROPERTY_ACTIVE_CHANNEL,
  ConversationDto.JSON_PROPERTY_APP_ID,
  ConversationDto.JSON_PROPERTY_CONTACT_ID,
  ConversationDto.JSON_PROPERTY_ID,
  ConversationDto.JSON_PROPERTY_LAST_RECEIVED,
  ConversationDto.JSON_PROPERTY_METADATA,
  ConversationDto.JSON_PROPERTY_METADATA_JSON,
  ConversationDto.JSON_PROPERTY_CORRELATION_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConversationDto {
  public static final String JSON_PROPERTY_ACTIVE = "active";
  private Boolean active;
  private boolean activeDefined = false;

  public static final String JSON_PROPERTY_ACTIVE_CHANNEL = "active_channel";
  private ConversationChannelDto activeChannel;
  private boolean activeChannelDefined = false;

  public static final String JSON_PROPERTY_APP_ID = "app_id";
  private String appId;
  private boolean appIdDefined = false;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";
  private String contactId;
  private boolean contactIdDefined = false;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;
  private boolean idDefined = false;

  public static final String JSON_PROPERTY_LAST_RECEIVED = "last_received";
  private OffsetDateTime lastReceived;
  private boolean lastReceivedDefined = false;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private String metadata;
  private boolean metadataDefined = false;

  public static final String JSON_PROPERTY_METADATA_JSON = "metadata_json";
  private Object metadataJson;
  private boolean metadataJsonDefined = false;

  public static final String JSON_PROPERTY_CORRELATION_ID = "correlation_id";
  private String correlationId;
  private boolean correlationIdDefined = false;

  public ConversationDto() {}

  @JsonCreator
  public ConversationDto(@JsonProperty(JSON_PROPERTY_LAST_RECEIVED) OffsetDateTime lastReceived) {
    this();
    this.lastReceived = lastReceived;
    this.lastReceivedDefined = true;
  }

  public ConversationDto active(Boolean active) {
    this.active = active;
    this.activeDefined = true;
    return this;
  }

  /**
   * Flag for whether this conversation is active.
   *
   * @return active
   */
  @JsonProperty(JSON_PROPERTY_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getActive() {
    return active;
  }

  @JsonIgnore
  public boolean getActiveDefined() {
    return activeDefined;
  }

  @JsonProperty(JSON_PROPERTY_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setActive(Boolean active) {
    this.active = active;
    this.activeDefined = true;
  }

  public ConversationDto activeChannel(ConversationChannelDto activeChannel) {
    this.activeChannel = activeChannel;
    this.activeChannelDefined = true;
    return this;
  }

  /**
   * Get activeChannel
   *
   * @return activeChannel
   */
  @JsonProperty(JSON_PROPERTY_ACTIVE_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ConversationChannelDto getActiveChannel() {
    return activeChannel;
  }

  @JsonIgnore
  public boolean getActiveChannelDefined() {
    return activeChannelDefined;
  }

  @JsonProperty(JSON_PROPERTY_ACTIVE_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setActiveChannel(ConversationChannelDto activeChannel) {
    this.activeChannel = activeChannel;
    this.activeChannelDefined = true;
  }

  public ConversationDto appId(String appId) {
    this.appId = appId;
    this.appIdDefined = true;
    return this;
  }

  /**
   * The ID of the participating app.
   *
   * @return appId
   */
  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAppId() {
    return appId;
  }

  @JsonIgnore
  public boolean getAppIdDefined() {
    return appIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAppId(String appId) {
    this.appId = appId;
    this.appIdDefined = true;
  }

  public ConversationDto contactId(String contactId) {
    this.contactId = contactId;
    this.contactIdDefined = true;
    return this;
  }

  /**
   * The ID of the participating contact.
   *
   * @return contactId
   */
  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getContactId() {
    return contactId;
  }

  @JsonIgnore
  public boolean getContactIdDefined() {
    return contactIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContactId(String contactId) {
    this.contactId = contactId;
    this.contactIdDefined = true;
  }

  public ConversationDto id(String id) {
    this.id = id;
    this.idDefined = true;
    return this;
  }

  /**
   * The ID of the conversation.
   *
   * @return id
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  @JsonIgnore
  public boolean getIdDefined() {
    return idDefined;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
    this.idDefined = true;
  }

  /**
   * The timestamp of the latest message in the conversation. The timestamp will be Thursday January
   * 01, 1970 00:00:00 UTC if the conversation contains no messages.
   *
   * @return lastReceived
   */
  @JsonProperty(JSON_PROPERTY_LAST_RECEIVED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getLastReceived() {
    return lastReceived;
  }

  @JsonIgnore
  public boolean getLastReceivedDefined() {
    return lastReceivedDefined;
  }

  public ConversationDto metadata(String metadata) {
    this.metadata = metadata;
    this.metadataDefined = true;
    return this;
  }

  /**
   * Arbitrary data set by the Conversation API clients. Up to 1024 characters long.
   *
   * @return metadata
   */
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMetadata() {
    return metadata;
  }

  @JsonIgnore
  public boolean getMetadataDefined() {
    return metadataDefined;
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMetadata(String metadata) {
    this.metadata = metadata;
    this.metadataDefined = true;
  }

  public ConversationDto metadataJson(Object metadataJson) {
    this.metadataJson = metadataJson;
    this.metadataJsonDefined = true;
    return this;
  }

  /**
   * Arbitrary data set by the Conversation API clients and/or provided in the
   * &#x60;conversation_metadata&#x60; field of a SendMessageRequest. A valid JSON object.
   *
   * @return metadataJson
   */
  @JsonProperty(JSON_PROPERTY_METADATA_JSON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Object getMetadataJson() {
    return metadataJson;
  }

  @JsonIgnore
  public boolean getMetadataJsonDefined() {
    return metadataJsonDefined;
  }

  @JsonProperty(JSON_PROPERTY_METADATA_JSON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMetadataJson(Object metadataJson) {
    this.metadataJson = metadataJson;
    this.metadataJsonDefined = true;
  }

  public ConversationDto correlationId(String correlationId) {
    this.correlationId = correlationId;
    this.correlationIdDefined = true;
    return this;
  }

  /**
   * not documented
   *
   * @return correlationId
   */
  @JsonProperty(JSON_PROPERTY_CORRELATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCorrelationId() {
    return correlationId;
  }

  @JsonIgnore
  public boolean getCorrelationIdDefined() {
    return correlationIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_CORRELATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
    this.correlationIdDefined = true;
  }

  /** Return true if this Conversation object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversationDto conversation = (ConversationDto) o;
    return Objects.equals(this.active, conversation.active)
        && Objects.equals(this.activeChannel, conversation.activeChannel)
        && Objects.equals(this.appId, conversation.appId)
        && Objects.equals(this.contactId, conversation.contactId)
        && Objects.equals(this.id, conversation.id)
        && Objects.equals(this.lastReceived, conversation.lastReceived)
        && Objects.equals(this.metadata, conversation.metadata)
        && Objects.equals(this.metadataJson, conversation.metadataJson)
        && Objects.equals(this.correlationId, conversation.correlationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        active,
        activeChannel,
        appId,
        contactId,
        id,
        lastReceived,
        metadata,
        metadataJson,
        correlationId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversationDto {\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    activeChannel: ").append(toIndentedString(activeChannel)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastReceived: ").append(toIndentedString(lastReceived)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    metadataJson: ").append(toIndentedString(metadataJson)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
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
