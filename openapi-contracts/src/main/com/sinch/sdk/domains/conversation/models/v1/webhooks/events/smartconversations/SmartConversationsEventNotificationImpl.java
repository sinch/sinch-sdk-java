package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

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
  SmartConversationsEventNotificationImpl.JSON_PROPERTY_CONTACT_ID,
  SmartConversationsEventNotificationImpl.JSON_PROPERTY_CHANNEL_IDENTITY,
  SmartConversationsEventNotificationImpl.JSON_PROPERTY_CHANNEL,
  SmartConversationsEventNotificationImpl.JSON_PROPERTY_MESSAGE_ID,
  SmartConversationsEventNotificationImpl.JSON_PROPERTY_CONVERSATION_ID,
  SmartConversationsEventNotificationImpl.JSON_PROPERTY_ANALYSIS_RESULTS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SmartConversationsEventNotificationImpl
    implements SmartConversationsEventNotification {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";

  private OptionalValue<String> channelIdentity;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<ConversationChannel> channel;

  public static final String JSON_PROPERTY_MESSAGE_ID = "message_id";

  private OptionalValue<String> messageId;

  public static final String JSON_PROPERTY_CONVERSATION_ID = "conversation_id";

  private OptionalValue<String> conversationId;

  public static final String JSON_PROPERTY_ANALYSIS_RESULTS = "analysis_results";

  private OptionalValue<AnalysisResult> analysisResults;

  public SmartConversationsEventNotificationImpl() {}

  protected SmartConversationsEventNotificationImpl(
      OptionalValue<String> contactId,
      OptionalValue<String> channelIdentity,
      OptionalValue<ConversationChannel> channel,
      OptionalValue<String> messageId,
      OptionalValue<String> conversationId,
      OptionalValue<AnalysisResult> analysisResults) {
    this.contactId = contactId;
    this.channelIdentity = channelIdentity;
    this.channel = channel;
    this.messageId = messageId;
    this.conversationId = conversationId;
    this.analysisResults = analysisResults;
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
  public String getChannelIdentity() {
    return channelIdentity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> channelIdentity() {
    return channelIdentity;
  }

  @JsonIgnore
  public ConversationChannel getChannel() {
    return channel.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConversationChannel> channel() {
    return channel;
  }

  @JsonIgnore
  public String getMessageId() {
    return messageId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> messageId() {
    return messageId;
  }

  @JsonIgnore
  public String getConversationId() {
    return conversationId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> conversationId() {
    return conversationId;
  }

  @JsonIgnore
  public AnalysisResult getAnalysisResults() {
    return analysisResults.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ANALYSIS_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AnalysisResult> analysisResults() {
    return analysisResults;
  }

  /**
   * Return true if this SmartConversationsEvent_allOf_smart_conversation_notification object is
   * equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmartConversationsEventNotificationImpl
        smartConversationsEventAllOfSmartConversationNotification =
            (SmartConversationsEventNotificationImpl) o;
    return Objects.equals(
            this.contactId, smartConversationsEventAllOfSmartConversationNotification.contactId)
        && Objects.equals(
            this.channelIdentity,
            smartConversationsEventAllOfSmartConversationNotification.channelIdentity)
        && Objects.equals(
            this.channel, smartConversationsEventAllOfSmartConversationNotification.channel)
        && Objects.equals(
            this.messageId, smartConversationsEventAllOfSmartConversationNotification.messageId)
        && Objects.equals(
            this.conversationId,
            smartConversationsEventAllOfSmartConversationNotification.conversationId)
        && Objects.equals(
            this.analysisResults,
            smartConversationsEventAllOfSmartConversationNotification.analysisResults);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        contactId, channelIdentity, channel, messageId, conversationId, analysisResults);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmartConversationsEventNotificationImpl {\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    analysisResults: ").append(toIndentedString(analysisResults)).append("\n");
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
  static class Builder implements SmartConversationsEventNotification.Builder {
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<String> channelIdentity = OptionalValue.empty();
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<String> messageId = OptionalValue.empty();
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<AnalysisResult> analysisResults = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTACT_ID)
    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
    public Builder setChannelIdentity(String channelIdentity) {
      this.channelIdentity = OptionalValue.of(channelIdentity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
    public Builder setMessageId(String messageId) {
      this.messageId = OptionalValue.of(messageId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
    public Builder setConversationId(String conversationId) {
      this.conversationId = OptionalValue.of(conversationId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ANALYSIS_RESULTS)
    public Builder setAnalysisResults(AnalysisResult analysisResults) {
      this.analysisResults = OptionalValue.of(analysisResults);
      return this;
    }

    public SmartConversationsEventNotification build() {
      return new SmartConversationsEventNotificationImpl(
          contactId, channelIdentity, channel, messageId, conversationId, analysisResults);
    }
  }
}
