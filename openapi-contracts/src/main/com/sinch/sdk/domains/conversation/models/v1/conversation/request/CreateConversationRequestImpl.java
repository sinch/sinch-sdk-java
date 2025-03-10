package com.sinch.sdk.domains.conversation.models.v1.conversation.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Objects;

@JsonPropertyOrder({
  CreateConversationRequestImpl.JSON_PROPERTY_ACTIVE,
  CreateConversationRequestImpl.JSON_PROPERTY_ACTIVE_CHANNEL,
  CreateConversationRequestImpl.JSON_PROPERTY_APP_ID,
  CreateConversationRequestImpl.JSON_PROPERTY_CONTACT_ID,
  CreateConversationRequestImpl.JSON_PROPERTY_METADATA,
  CreateConversationRequestImpl.JSON_PROPERTY_METADATA_JSON,
  CreateConversationRequestImpl.JSON_PROPERTY_CORRELATION_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CreateConversationRequestImpl implements CreateConversationRequest {
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

  public CreateConversationRequestImpl() {}

  protected CreateConversationRequestImpl(
      OptionalValue<Boolean> active,
      OptionalValue<ConversationChannel> activeChannel,
      OptionalValue<String> appId,
      OptionalValue<String> contactId,
      OptionalValue<String> metadata,
      OptionalValue<Object> metadataJson,
      OptionalValue<String> correlationId) {
    this.active = active;
    this.activeChannel = activeChannel;
    this.appId = appId;
    this.contactId = contactId;
    this.metadata = metadata;
    this.metadataJson = metadataJson;
    this.correlationId = correlationId;
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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> appId() {
    return appId;
  }

  @JsonIgnore
  public String getContactId() {
    return contactId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
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

  /** Return true if this CreateConversationRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateConversationRequestImpl createConversationRequest = (CreateConversationRequestImpl) o;
    return Objects.equals(this.active, createConversationRequest.active)
        && Objects.equals(this.activeChannel, createConversationRequest.activeChannel)
        && Objects.equals(this.appId, createConversationRequest.appId)
        && Objects.equals(this.contactId, createConversationRequest.contactId)
        && Objects.equals(this.metadata, createConversationRequest.metadata)
        && Objects.equals(this.metadataJson, createConversationRequest.metadataJson)
        && Objects.equals(this.correlationId, createConversationRequest.correlationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        active, activeChannel, appId, contactId, metadata, metadataJson, correlationId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateConversationRequestImpl {\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    activeChannel: ").append(toIndentedString(activeChannel)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements CreateConversationRequest.Builder {
    OptionalValue<Boolean> active = OptionalValue.empty();
    OptionalValue<ConversationChannel> activeChannel = OptionalValue.empty();
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<String> metadata = OptionalValue.empty();
    OptionalValue<Object> metadataJson = OptionalValue.empty();
    OptionalValue<String> correlationId = OptionalValue.empty();

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

    @JsonProperty(value = JSON_PROPERTY_APP_ID, required = true)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CONTACT_ID, required = true)
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

    public CreateConversationRequest build() {
      return new CreateConversationRequestImpl(
          active, activeChannel, appId, contactId, metadata, metadataJson, correlationId);
    }
  }
}
