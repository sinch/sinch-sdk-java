package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageMessage;
import com.sinch.sdk.domains.conversation.models.v1.request.MessageQueue;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  SendMessageRequestImpl.JSON_PROPERTY_APP_ID,
  SendMessageRequestImpl.JSON_PROPERTY_CALLBACK_URL,
  SendMessageRequestImpl.JSON_PROPERTY_CHANNEL_PRIORITY_ORDER,
  SendMessageRequestImpl.JSON_PROPERTY_CHANNEL_PROPERTIES,
  SendMessageRequestImpl.JSON_PROPERTY_MESSAGE,
  SendMessageRequestImpl.JSON_PROPERTY_MESSAGE_METADATA,
  SendMessageRequestImpl.JSON_PROPERTY_CONVERSATION_METADATA,
  SendMessageRequestImpl.JSON_PROPERTY_QUEUE,
  SendMessageRequestImpl.JSON_PROPERTY_RECIPIENT,
  SendMessageRequestImpl.JSON_PROPERTY_TTL,
  SendMessageRequestImpl.JSON_PROPERTY_PROCESSING_STRATEGY,
  SendMessageRequestImpl.JSON_PROPERTY_CORRELATION_ID,
  SendMessageRequestImpl.JSON_PROPERTY_CONVERSATION_METADATA_UPDATE_STRATEGY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SendMessageRequestImpl<T extends AppMessageMessage> implements SendMessageRequest<T> {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_ID = "app_id";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callback_url";

  private OptionalValue<String> callbackUrl;

  public static final String JSON_PROPERTY_CHANNEL_PRIORITY_ORDER = "channel_priority_order";

  private OptionalValue<List<ConversationChannel>> channelPriorityOrder;

  public static final String JSON_PROPERTY_CHANNEL_PROPERTIES = "channel_properties";

  private OptionalValue<Map<String, String>> channelProperties;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<AppMessage<T>> message;

  public static final String JSON_PROPERTY_MESSAGE_METADATA = "message_metadata";

  private OptionalValue<String> messageMetadata;

  public static final String JSON_PROPERTY_CONVERSATION_METADATA = "conversation_metadata";

  private OptionalValue<Object> conversationMetadata;

  public static final String JSON_PROPERTY_QUEUE = "queue";

  private OptionalValue<MessageQueue> queue;

  public static final String JSON_PROPERTY_RECIPIENT = "recipient";

  private OptionalValue<Recipient> recipient;

  public static final String JSON_PROPERTY_TTL = "ttl";

  private OptionalValue<Integer> ttl;

  public static final String JSON_PROPERTY_PROCESSING_STRATEGY = "processing_strategy";

  private OptionalValue<ProcessingStrategy> processingStrategy;

  public static final String JSON_PROPERTY_CORRELATION_ID = "correlation_id";

  private OptionalValue<String> correlationId;

  public static final String JSON_PROPERTY_CONVERSATION_METADATA_UPDATE_STRATEGY =
      "conversation_metadata_update_strategy";

  private OptionalValue<MetadataUpdateStrategy> conversationMetadataUpdateStrategy;

  public SendMessageRequestImpl() {}

  protected SendMessageRequestImpl(
      OptionalValue<String> appId,
      OptionalValue<String> callbackUrl,
      OptionalValue<List<ConversationChannel>> channelPriorityOrder,
      OptionalValue<Map<String, String>> channelProperties,
      OptionalValue<AppMessage<T>> message,
      OptionalValue<String> messageMetadata,
      OptionalValue<Object> conversationMetadata,
      OptionalValue<MessageQueue> queue,
      OptionalValue<Recipient> recipient,
      OptionalValue<Integer> ttl,
      OptionalValue<ProcessingStrategy> processingStrategy,
      OptionalValue<String> correlationId,
      OptionalValue<MetadataUpdateStrategy> conversationMetadataUpdateStrategy) {
    this.appId = appId;
    this.callbackUrl = callbackUrl;
    this.channelPriorityOrder = channelPriorityOrder;
    this.channelProperties = channelProperties;
    this.message = message;
    this.messageMetadata = messageMetadata;
    this.conversationMetadata = conversationMetadata;
    this.queue = queue;
    this.recipient = recipient;
    this.ttl = ttl;
    this.processingStrategy = processingStrategy;
    this.correlationId = correlationId;
    this.conversationMetadataUpdateStrategy = conversationMetadataUpdateStrategy;
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
  public String getCallbackUrl() {
    return callbackUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callbackUrl() {
    return callbackUrl;
  }

  @JsonIgnore
  public List<ConversationChannel> getChannelPriorityOrder() {
    return channelPriorityOrder.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_PRIORITY_ORDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<ConversationChannel>> channelPriorityOrder() {
    return channelPriorityOrder;
  }

  @JsonIgnore
  public Map<String, String> getChannelProperties() {
    return channelProperties.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<String, String>> channelProperties() {
    return channelProperties;
  }

  @JsonIgnore
  public AppMessage<T> getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<AppMessage<T>> message() {
    return message;
  }

  @JsonIgnore
  public String getMessageMetadata() {
    return messageMetadata.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> messageMetadata() {
    return messageMetadata;
  }

  @JsonIgnore
  public Object getConversationMetadata() {
    return conversationMetadata.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONVERSATION_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Object> conversationMetadata() {
    return conversationMetadata;
  }

  @JsonIgnore
  public MessageQueue getQueue() {
    return queue.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_QUEUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MessageQueue> queue() {
    return queue;
  }

  @JsonIgnore
  public Recipient getRecipient() {
    return recipient.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Recipient> recipient() {
    return recipient;
  }

  @JsonIgnore
  public Integer getTtl() {
    return ttl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TTL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> ttl() {
    return ttl;
  }

  @JsonIgnore
  public ProcessingStrategy getProcessingStrategy() {
    return processingStrategy.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_STRATEGY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProcessingStrategy> processingStrategy() {
    return processingStrategy;
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
  public MetadataUpdateStrategy getConversationMetadataUpdateStrategy() {
    return conversationMetadataUpdateStrategy.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONVERSATION_METADATA_UPDATE_STRATEGY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MetadataUpdateStrategy> conversationMetadataUpdateStrategy() {
    return conversationMetadataUpdateStrategy;
  }

  /** Return true if this SendMessageRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMessageRequestImpl sendMessageRequest = (SendMessageRequestImpl) o;
    return Objects.equals(this.appId, sendMessageRequest.appId)
        && Objects.equals(this.callbackUrl, sendMessageRequest.callbackUrl)
        && Objects.equals(this.channelPriorityOrder, sendMessageRequest.channelPriorityOrder)
        && Objects.equals(this.channelProperties, sendMessageRequest.channelProperties)
        && Objects.equals(this.message, sendMessageRequest.message)
        && Objects.equals(this.messageMetadata, sendMessageRequest.messageMetadata)
        && Objects.equals(this.conversationMetadata, sendMessageRequest.conversationMetadata)
        && Objects.equals(this.queue, sendMessageRequest.queue)
        && Objects.equals(this.recipient, sendMessageRequest.recipient)
        && Objects.equals(this.ttl, sendMessageRequest.ttl)
        && Objects.equals(this.processingStrategy, sendMessageRequest.processingStrategy)
        && Objects.equals(this.correlationId, sendMessageRequest.correlationId)
        && Objects.equals(
            this.conversationMetadataUpdateStrategy,
            sendMessageRequest.conversationMetadataUpdateStrategy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        appId,
        callbackUrl,
        channelPriorityOrder,
        channelProperties,
        message,
        messageMetadata,
        conversationMetadata,
        queue,
        recipient,
        ttl,
        processingStrategy,
        correlationId,
        conversationMetadataUpdateStrategy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMessageRequestImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    channelPriorityOrder: ")
        .append(toIndentedString(channelPriorityOrder))
        .append("\n");
    sb.append("    channelProperties: ").append(toIndentedString(channelProperties)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    messageMetadata: ").append(toIndentedString(messageMetadata)).append("\n");
    sb.append("    conversationMetadata: ")
        .append(toIndentedString(conversationMetadata))
        .append("\n");
    sb.append("    queue: ").append(toIndentedString(queue)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
    sb.append("    processingStrategy: ").append(toIndentedString(processingStrategy)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    conversationMetadataUpdateStrategy: ")
        .append(toIndentedString(conversationMetadataUpdateStrategy))
        .append("\n");
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
  static class Builder<T extends AppMessageMessage> implements SendMessageRequest.Builder<T> {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();
    OptionalValue<List<ConversationChannel>> channelPriorityOrder = OptionalValue.empty();
    OptionalValue<Map<String, String>> channelProperties = OptionalValue.empty();
    OptionalValue<AppMessage<T>> message = OptionalValue.empty();
    OptionalValue<String> messageMetadata = OptionalValue.empty();
    OptionalValue<Object> conversationMetadata = OptionalValue.empty();
    OptionalValue<MessageQueue> queue = OptionalValue.empty();
    OptionalValue<Recipient> recipient = OptionalValue.empty();
    OptionalValue<Integer> ttl = OptionalValue.empty();
    OptionalValue<ProcessingStrategy> processingStrategy = OptionalValue.empty();
    OptionalValue<String> correlationId = OptionalValue.empty();
    OptionalValue<MetadataUpdateStrategy> conversationMetadataUpdateStrategy =
        OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder<T> setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
    public Builder<T> setCallbackUrl(String callbackUrl) {
      this.callbackUrl = OptionalValue.of(callbackUrl);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_PRIORITY_ORDER)
    public Builder<T> setChannelPriorityOrder(List<ConversationChannel> channelPriorityOrder) {
      this.channelPriorityOrder = OptionalValue.of(channelPriorityOrder);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_PROPERTIES)
    public Builder<T> setChannelProperties(Map<String, String> channelProperties) {
      this.channelProperties = OptionalValue.of(channelProperties);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder<T> setMessage(AppMessage<T> message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_METADATA)
    public Builder<T> setMessageMetadata(String messageMetadata) {
      this.messageMetadata = OptionalValue.of(messageMetadata);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONVERSATION_METADATA)
    public Builder<T> setConversationMetadata(Object conversationMetadata) {
      this.conversationMetadata = OptionalValue.of(conversationMetadata);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_QUEUE)
    public Builder<T> setQueue(MessageQueue queue) {
      this.queue = OptionalValue.of(queue);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RECIPIENT)
    public Builder<T> setRecipient(Recipient recipient) {
      this.recipient = OptionalValue.of(recipient);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TTL)
    public Builder<T> setTtl(Integer ttl) {
      this.ttl = OptionalValue.of(ttl);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSING_STRATEGY)
    public Builder<T> setProcessingStrategy(ProcessingStrategy processingStrategy) {
      this.processingStrategy = OptionalValue.of(processingStrategy);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CORRELATION_ID)
    public Builder<T> setCorrelationId(String correlationId) {
      this.correlationId = OptionalValue.of(correlationId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONVERSATION_METADATA_UPDATE_STRATEGY)
    public Builder<T> setConversationMetadataUpdateStrategy(
        MetadataUpdateStrategy conversationMetadataUpdateStrategy) {
      this.conversationMetadataUpdateStrategy =
          OptionalValue.of(conversationMetadataUpdateStrategy);
      return this;
    }

    public SendMessageRequest<T> build() {
      return new SendMessageRequestImpl<T>(
          appId,
          callbackUrl,
          channelPriorityOrder,
          channelProperties,
          message,
          messageMetadata,
          conversationMetadata,
          queue,
          recipient,
          ttl,
          processingStrategy,
          correlationId,
          conversationMetadataUpdateStrategy);
    }
  }
}
