package com.sinch.sdk.domains.conversation.models.v1.conversations;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  ConversationImpl.JSON_PROPERTY_ACTIVE,
  ConversationImpl.JSON_PROPERTY_ACTIVE_CHANNEL,
  ConversationImpl.JSON_PROPERTY_APP_ID,
  ConversationImpl.JSON_PROPERTY_CONTACT_ID,
  ConversationImpl.JSON_PROPERTY_METADATA,
  ConversationImpl.JSON_PROPERTY_METADATA_JSON,
  ConversationImpl.JSON_PROPERTY_CORRELATION_ID,
  ConversationImpl.JSON_PROPERTY_ID,
  ConversationImpl.JSON_PROPERTY_LAST_RECEIVED
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConversationImpl implements Conversation {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTIVE = "active";

  private OptionalValue<Boolean> active;

  public static final String JSON_PROPERTY_ACTIVE_CHANNEL = "active_channel";

  private OptionalValue<ConversationChannel> activeChannel;

  public static final String JSON_PROPERTY_APP_ID = "app_id";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_METADATA = "metadata";

  private OptionalValue<String> metadata;

  public static final String JSON_PROPERTY_METADATA_JSON = "metadata_json";

  private OptionalValue<Object> metadataJson;

  public static final String JSON_PROPERTY_CORRELATION_ID = "correlation_id";

  private OptionalValue<String> correlationId;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_LAST_RECEIVED = "last_received";

  private OptionalValue<Instant> lastReceived;

  public ConversationImpl() {}

  protected ConversationImpl(
      OptionalValue<Boolean> active,
      OptionalValue<ConversationChannel> activeChannel,
      OptionalValue<String> appId,
      OptionalValue<String> contactId,
      OptionalValue<String> metadata,
      OptionalValue<Object> metadataJson,
      OptionalValue<String> correlationId,
      OptionalValue<String> id,
      OptionalValue<Instant> lastReceived) {
    this.active = active;
    this.activeChannel = activeChannel;
    this.appId = appId;
    this.contactId = contactId;
    this.metadata = metadata;
    this.metadataJson = metadataJson;
    this.correlationId = correlationId;
    this.id = id;
    this.lastReceived = lastReceived;
  }

  @JsonIgnore
  public Boolean getActive() {
    return active.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> active() {
    return active;
  }

  @JsonIgnore
  public ConversationChannel getActiveChannel() {
    return activeChannel.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTIVE_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConversationChannel> activeChannel() {
    return activeChannel;
  }

  @JsonIgnore
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> appId() {
    return appId;
  }

  @JsonIgnore
  public String getContactId() {
    return contactId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> contactId() {
    return contactId;
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

  @JsonIgnore
  public Object getMetadataJson() {
    return metadataJson.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METADATA_JSON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Object> metadataJson() {
    return metadataJson;
  }

  @JsonIgnore
  public String getCorrelationId() {
    return correlationId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CORRELATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> correlationId() {
    return correlationId;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public Instant getLastReceived() {
    return lastReceived.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> lastReceived() {
    return lastReceived;
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
    ConversationImpl conversation = (ConversationImpl) o;
    return Objects.equals(this.active, conversation.active)
        && Objects.equals(this.activeChannel, conversation.activeChannel)
        && Objects.equals(this.appId, conversation.appId)
        && Objects.equals(this.contactId, conversation.contactId)
        && Objects.equals(this.metadata, conversation.metadata)
        && Objects.equals(this.metadataJson, conversation.metadataJson)
        && Objects.equals(this.correlationId, conversation.correlationId)
        && Objects.equals(this.id, conversation.id)
        && Objects.equals(this.lastReceived, conversation.lastReceived);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        active,
        activeChannel,
        appId,
        contactId,
        metadata,
        metadataJson,
        correlationId,
        id,
        lastReceived);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversationImpl {\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    activeChannel: ").append(toIndentedString(activeChannel)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    metadataJson: ").append(toIndentedString(metadataJson)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastReceived: ").append(toIndentedString(lastReceived)).append("\n");
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
  static class Builder implements Conversation.Builder {
    OptionalValue<Boolean> active = OptionalValue.empty();
    OptionalValue<ConversationChannel> activeChannel = OptionalValue.empty();
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<String> metadata = OptionalValue.empty();
    OptionalValue<Object> metadataJson = OptionalValue.empty();
    OptionalValue<String> correlationId = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<Instant> lastReceived = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ACTIVE)
    public Builder setActive(Boolean active) {
      this.active = OptionalValue.of(active);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACTIVE_CHANNEL)
    public Builder setActiveChannel(ConversationChannel activeChannel) {
      this.activeChannel = OptionalValue.of(activeChannel);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_ID)
    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METADATA)
    public Builder setMetadata(String metadata) {
      this.metadata = OptionalValue.of(metadata);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METADATA_JSON)
    public Builder setMetadataJson(Object metadataJson) {
      this.metadataJson = OptionalValue.of(metadataJson);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CORRELATION_ID)
    public Builder setCorrelationId(String correlationId) {
      this.correlationId = OptionalValue.of(correlationId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LAST_RECEIVED)
    public Builder setLastReceived(Instant lastReceived) {
      this.lastReceived = OptionalValue.of(lastReceived);
      return this;
    }

    public Conversation build() {
      return new ConversationImpl(
          active,
          activeChannel,
          appId,
          contactId,
          metadata,
          metadataJson,
          correlationId,
          id,
          lastReceived);
    }
  }
}
