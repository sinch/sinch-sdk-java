package com.sinch.sdk.domains.conversation.models.v1.contact.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.ContactLanguage;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ContactCreateRequestImpl.JSON_PROPERTY_CHANNEL_IDENTITIES,
  ContactCreateRequestImpl.JSON_PROPERTY_CHANNEL_PRIORITY,
  ContactCreateRequestImpl.JSON_PROPERTY_DISPLAY_NAME,
  ContactCreateRequestImpl.JSON_PROPERTY_EMAIL,
  ContactCreateRequestImpl.JSON_PROPERTY_EXTERNAL_ID,
  ContactCreateRequestImpl.JSON_PROPERTY_LANGUAGE,
  ContactCreateRequestImpl.JSON_PROPERTY_METADATA
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactCreateRequestImpl implements ContactCreateRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITIES = "channel_identities";

  private OptionalValue<List<ChannelIdentity>> channelIdentities;

  public static final String JSON_PROPERTY_CHANNEL_PRIORITY = "channel_priority";

  private OptionalValue<List<ConversationChannel>> channelPriority;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "display_name";

  private OptionalValue<String> displayName;

  public static final String JSON_PROPERTY_EMAIL = "email";

  private OptionalValue<String> email;

  public static final String JSON_PROPERTY_EXTERNAL_ID = "external_id";

  private OptionalValue<String> externalId;

  public static final String JSON_PROPERTY_LANGUAGE = "language";

  private OptionalValue<ContactLanguage> language;

  public static final String JSON_PROPERTY_METADATA = "metadata";

  private OptionalValue<String> metadata;

  public ContactCreateRequestImpl() {}

  protected ContactCreateRequestImpl(
      OptionalValue<List<ChannelIdentity>> channelIdentities,
      OptionalValue<List<ConversationChannel>> channelPriority,
      OptionalValue<String> displayName,
      OptionalValue<String> email,
      OptionalValue<String> externalId,
      OptionalValue<ContactLanguage> language,
      OptionalValue<String> metadata) {
    this.channelIdentities = channelIdentities;
    this.channelPriority = channelPriority;
    this.displayName = displayName;
    this.email = email;
    this.externalId = externalId;
    this.language = language;
    this.metadata = metadata;
  }

  @JsonIgnore
  public List<ChannelIdentity> getChannelIdentities() {
    return channelIdentities.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITIES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<ChannelIdentity>> channelIdentities() {
    return channelIdentities;
  }

  @JsonIgnore
  public List<ConversationChannel> getChannelPriority() {
    return channelPriority.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_PRIORITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<ConversationChannel>> channelPriority() {
    return channelPriority;
  }

  @JsonIgnore
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> displayName() {
    return displayName;
  }

  @JsonIgnore
  public String getEmail() {
    return email.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> email() {
    return email;
  }

  @JsonIgnore
  public String getExternalId() {
    return externalId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> externalId() {
    return externalId;
  }

  @JsonIgnore
  public ContactLanguage getLanguage() {
    return language.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ContactLanguage> language() {
    return language;
  }

  @JsonIgnore
  public String getMetadata() {
    return metadata.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> metadata() {
    return metadata;
  }

  /** Return true if this ContactCreateRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactCreateRequestImpl contactCreateRequest = (ContactCreateRequestImpl) o;
    return Objects.equals(this.channelIdentities, contactCreateRequest.channelIdentities)
        && Objects.equals(this.channelPriority, contactCreateRequest.channelPriority)
        && Objects.equals(this.displayName, contactCreateRequest.displayName)
        && Objects.equals(this.email, contactCreateRequest.email)
        && Objects.equals(this.externalId, contactCreateRequest.externalId)
        && Objects.equals(this.language, contactCreateRequest.language)
        && Objects.equals(this.metadata, contactCreateRequest.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        channelIdentities, channelPriority, displayName, email, externalId, language, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactCreateRequestImpl {\n");
    sb.append("    channelIdentities: ").append(toIndentedString(channelIdentities)).append("\n");
    sb.append("    channelPriority: ").append(toIndentedString(channelPriority)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements ContactCreateRequest.Builder {
    OptionalValue<List<ChannelIdentity>> channelIdentities = OptionalValue.empty();
    OptionalValue<List<ConversationChannel>> channelPriority = OptionalValue.empty();
    OptionalValue<String> displayName = OptionalValue.empty();
    OptionalValue<String> email = OptionalValue.empty();
    OptionalValue<String> externalId = OptionalValue.empty();
    OptionalValue<ContactLanguage> language = OptionalValue.empty();
    OptionalValue<String> metadata = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITIES)
    public Builder setChannelIdentities(List<ChannelIdentity> channelIdentities) {
      this.channelIdentities = OptionalValue.of(channelIdentities);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_PRIORITY)
    public Builder setChannelPriority(List<ConversationChannel> channelPriority) {
      this.channelPriority = OptionalValue.of(channelPriority);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    public Builder setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EMAIL)
    public Builder setEmail(String email) {
      this.email = OptionalValue.of(email);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
    public Builder setExternalId(String externalId) {
      this.externalId = OptionalValue.of(externalId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LANGUAGE)
    public Builder setLanguage(ContactLanguage language) {
      this.language = OptionalValue.of(language);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METADATA)
    public Builder setMetadata(String metadata) {
      this.metadata = OptionalValue.of(metadata);
      return this;
    }

    public ContactCreateRequest build() {
      return new ContactCreateRequestImpl(
          channelIdentities, channelPriority, displayName, email, externalId, language, metadata);
    }
  }
}
