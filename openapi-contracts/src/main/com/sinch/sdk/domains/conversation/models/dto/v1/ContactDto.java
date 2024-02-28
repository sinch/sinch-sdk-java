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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A participant in a conversation typically representing a person. It is associated with a
 * collection of channel identities.
 */
@JsonPropertyOrder({
  ContactDto.JSON_PROPERTY_CHANNEL_IDENTITIES,
  ContactDto.JSON_PROPERTY_CHANNEL_PRIORITY,
  ContactDto.JSON_PROPERTY_DISPLAY_NAME,
  ContactDto.JSON_PROPERTY_EMAIL,
  ContactDto.JSON_PROPERTY_EXTERNAL_ID,
  ContactDto.JSON_PROPERTY_ID,
  ContactDto.JSON_PROPERTY_LANGUAGE,
  ContactDto.JSON_PROPERTY_METADATA
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_CHANNEL_IDENTITIES = "channel_identities";
  private List<ChannelIdentityDto> channelIdentities;
  private boolean channelIdentitiesDefined = false;

  public static final String JSON_PROPERTY_CHANNEL_PRIORITY = "channel_priority";
  private List<ConversationChannelDto> channelPriority;
  private boolean channelPriorityDefined = false;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "display_name";
  private String displayName;
  private boolean displayNameDefined = false;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;
  private boolean emailDefined = false;

  public static final String JSON_PROPERTY_EXTERNAL_ID = "external_id";
  private String externalId;
  private boolean externalIdDefined = false;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;
  private boolean idDefined = false;

  public static final String JSON_PROPERTY_LANGUAGE = "language";
  private String language;
  private boolean languageDefined = false;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private String metadata;
  private boolean metadataDefined = false;

  public ContactDto() {}

  public ContactDto channelIdentities(List<ChannelIdentityDto> channelIdentities) {
    this.channelIdentities = channelIdentities;
    this.channelIdentitiesDefined = true;
    return this;
  }

  public ContactDto addChannelIdentitiesItem(ChannelIdentityDto channelIdentitiesItem) {
    if (this.channelIdentities == null) {
      this.channelIdentities = new ArrayList<>();
    }
    this.channelIdentitiesDefined = true;
    this.channelIdentities.add(channelIdentitiesItem);
    return this;
  }

  /**
   * List of channel identities.
   *
   * @return channelIdentities
   */
  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<ChannelIdentityDto> getChannelIdentities() {
    return channelIdentities;
  }

  @JsonIgnore
  public boolean getChannelIdentitiesDefined() {
    return channelIdentitiesDefined;
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChannelIdentities(List<ChannelIdentityDto> channelIdentities) {
    this.channelIdentities = channelIdentities;
    this.channelIdentitiesDefined = true;
  }

  public ContactDto channelPriority(List<ConversationChannelDto> channelPriority) {
    this.channelPriority = channelPriority;
    this.channelPriorityDefined = true;
    return this;
  }

  public ContactDto addChannelPriorityItem(ConversationChannelDto channelPriorityItem) {
    if (this.channelPriority == null) {
      this.channelPriority = new ArrayList<>();
    }
    this.channelPriorityDefined = true;
    this.channelPriority.add(channelPriorityItem);
    return this;
  }

  /**
   * List of channels defining the channel priority.
   *
   * @return channelPriority
   */
  @JsonProperty(JSON_PROPERTY_CHANNEL_PRIORITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<ConversationChannelDto> getChannelPriority() {
    return channelPriority;
  }

  @JsonIgnore
  public boolean getChannelPriorityDefined() {
    return channelPriorityDefined;
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_PRIORITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChannelPriority(List<ConversationChannelDto> channelPriority) {
    this.channelPriority = channelPriority;
    this.channelPriorityDefined = true;
  }

  public ContactDto displayName(String displayName) {
    this.displayName = displayName;
    this.displayNameDefined = true;
    return this;
  }

  /**
   * The display name. A default &#39;Unknown&#39; will be assigned if left empty.
   *
   * @return displayName
   */
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDisplayName() {
    return displayName;
  }

  @JsonIgnore
  public boolean getDisplayNameDefined() {
    return displayNameDefined;
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
    this.displayNameDefined = true;
  }

  public ContactDto email(String email) {
    this.email = email;
    this.emailDefined = true;
    return this;
  }

  /**
   * Email of the contact.
   *
   * @return email
   */
  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEmail() {
    return email;
  }

  @JsonIgnore
  public boolean getEmailDefined() {
    return emailDefined;
  }

  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmail(String email) {
    this.email = email;
    this.emailDefined = true;
  }

  public ContactDto externalId(String externalId) {
    this.externalId = externalId;
    this.externalIdDefined = true;
    return this;
  }

  /**
   * Contact identifier in an external system.
   *
   * @return externalId
   */
  @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getExternalId() {
    return externalId;
  }

  @JsonIgnore
  public boolean getExternalIdDefined() {
    return externalIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExternalId(String externalId) {
    this.externalId = externalId;
    this.externalIdDefined = true;
  }

  public ContactDto id(String id) {
    this.id = id;
    this.idDefined = true;
    return this;
  }

  /**
   * The ID of the contact.
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

  public ContactDto language(String language) {
    this.language = language;
    this.languageDefined = true;
    return this;
  }

  /**
   * Get language
   *
   * @return language
   */
  @JsonProperty(JSON_PROPERTY_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLanguage() {
    return language;
  }

  @JsonIgnore
  public boolean getLanguageDefined() {
    return languageDefined;
  }

  @JsonProperty(JSON_PROPERTY_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLanguage(String language) {
    this.language = language;
    this.languageDefined = true;
  }

  public ContactDto metadata(String metadata) {
    this.metadata = metadata;
    this.metadataDefined = true;
    return this;
  }

  /**
   * Metadata associated with the contact. Up to 1024 characters long.
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

  /** Return true if this Contact object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactDto contact = (ContactDto) o;
    return Objects.equals(this.channelIdentities, contact.channelIdentities)
        && Objects.equals(this.channelPriority, contact.channelPriority)
        && Objects.equals(this.displayName, contact.displayName)
        && Objects.equals(this.email, contact.email)
        && Objects.equals(this.externalId, contact.externalId)
        && Objects.equals(this.id, contact.id)
        && Objects.equals(this.language, contact.language)
        && Objects.equals(this.metadata, contact.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        channelIdentities, channelPriority, displayName, email, externalId, id, language, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactDto {\n");
    sb.append("    channelIdentities: ").append(toIndentedString(channelIdentities)).append("\n");
    sb.append("    channelPriority: ").append(toIndentedString(channelPriority)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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