package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  LastMessagesByChannelIdentityListQueryParametersImpl.JSON_PROPERTY_CHANNEL_IDENTITIES,
  LastMessagesByChannelIdentityListQueryParametersImpl.JSON_PROPERTY_CONTACT_IDS,
  LastMessagesByChannelIdentityListQueryParametersImpl.JSON_PROPERTY_APP_ID,
  LastMessagesByChannelIdentityListQueryParametersImpl.JSON_PROPERTY_MESSAGES_SOURCE,
  LastMessagesByChannelIdentityListQueryParametersImpl.JSON_PROPERTY_PAGE_SIZE,
  LastMessagesByChannelIdentityListQueryParametersImpl.JSON_PROPERTY_PAGE_TOKEN,
  LastMessagesByChannelIdentityListQueryParametersImpl.JSON_PROPERTY_VIEW,
  LastMessagesByChannelIdentityListQueryParametersImpl.JSON_PROPERTY_START_TIME,
  LastMessagesByChannelIdentityListQueryParametersImpl.JSON_PROPERTY_END_TIME,
  LastMessagesByChannelIdentityListQueryParametersImpl.JSON_PROPERTY_CHANNEL,
  LastMessagesByChannelIdentityListQueryParametersImpl.JSON_PROPERTY_DIRECTION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LastMessagesByChannelIdentityListQueryParametersImpl
    implements LastMessagesByChannelIdentityListQueryParameters {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITIES = "channel_identities";

  private OptionalValue<List<String>> channelIdentities;

  public static final String JSON_PROPERTY_CONTACT_IDS = "contact_ids";

  private OptionalValue<List<String>> contactIds;

  public static final String JSON_PROPERTY_APP_ID = "app_id";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_MESSAGES_SOURCE = "messages_source";

  private OptionalValue<MessageSource> messagesSource;

  public static final String JSON_PROPERTY_PAGE_SIZE = "page_size";

  private OptionalValue<Integer> pageSize;

  public static final String JSON_PROPERTY_PAGE_TOKEN = "page_token";

  private OptionalValue<String> pageToken;

  public static final String JSON_PROPERTY_VIEW = "view";

  private OptionalValue<ConversationMessagesView> view;

  public static final String JSON_PROPERTY_START_TIME = "start_time";

  private OptionalValue<Instant> startTime;

  public static final String JSON_PROPERTY_END_TIME = "end_time";

  private OptionalValue<Instant> endTime;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<ConversationChannel> channel;

  public static final String JSON_PROPERTY_DIRECTION = "direction";

  private OptionalValue<ConversationDirection> direction;

  public LastMessagesByChannelIdentityListQueryParametersImpl() {}

  protected LastMessagesByChannelIdentityListQueryParametersImpl(
      OptionalValue<List<String>> channelIdentities,
      OptionalValue<List<String>> contactIds,
      OptionalValue<String> appId,
      OptionalValue<MessageSource> messagesSource,
      OptionalValue<Integer> pageSize,
      OptionalValue<String> pageToken,
      OptionalValue<ConversationMessagesView> view,
      OptionalValue<Instant> startTime,
      OptionalValue<Instant> endTime,
      OptionalValue<ConversationChannel> channel,
      OptionalValue<ConversationDirection> direction) {
    this.channelIdentities = channelIdentities;
    this.contactIds = contactIds;
    this.appId = appId;
    this.messagesSource = messagesSource;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
    this.view = view;
    this.startTime = startTime;
    this.endTime = endTime;
    this.channel = channel;
    this.direction = direction;
  }

  @JsonIgnore
  public List<String> getChannelIdentities() {
    return channelIdentities.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> channelIdentities() {
    return channelIdentities;
  }

  @JsonIgnore
  public List<String> getContactIds() {
    return contactIds.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> contactIds() {
    return contactIds;
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
  public MessageSource getMessagesSource() {
    return messagesSource.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGES_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MessageSource> messagesSource() {
    return messagesSource;
  }

  @JsonIgnore
  public Integer getPageSize() {
    return pageSize.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAGE_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> pageSize() {
    return pageSize;
  }

  @JsonIgnore
  public String getPageToken() {
    return pageToken.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAGE_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> pageToken() {
    return pageToken;
  }

  @JsonIgnore
  public ConversationMessagesView getView() {
    return view.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VIEW)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConversationMessagesView> view() {
    return view;
  }

  @JsonIgnore
  public Instant getStartTime() {
    return startTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_START_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> startTime() {
    return startTime;
  }

  @JsonIgnore
  public Instant getEndTime() {
    return endTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_END_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> endTime() {
    return endTime;
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
  public ConversationDirection getDirection() {
    return direction.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConversationDirection> direction() {
    return direction;
  }

  /** Return true if this ListMessagesByChannelIdentityRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LastMessagesByChannelIdentityListQueryParametersImpl listMessagesByChannelIdentityRequest =
        (LastMessagesByChannelIdentityListQueryParametersImpl) o;
    return Objects.equals(
            this.channelIdentities, listMessagesByChannelIdentityRequest.channelIdentities)
        && Objects.equals(this.contactIds, listMessagesByChannelIdentityRequest.contactIds)
        && Objects.equals(this.appId, listMessagesByChannelIdentityRequest.appId)
        && Objects.equals(this.messagesSource, listMessagesByChannelIdentityRequest.messagesSource)
        && Objects.equals(this.pageSize, listMessagesByChannelIdentityRequest.pageSize)
        && Objects.equals(this.pageToken, listMessagesByChannelIdentityRequest.pageToken)
        && Objects.equals(this.view, listMessagesByChannelIdentityRequest.view)
        && Objects.equals(this.startTime, listMessagesByChannelIdentityRequest.startTime)
        && Objects.equals(this.endTime, listMessagesByChannelIdentityRequest.endTime)
        && Objects.equals(this.channel, listMessagesByChannelIdentityRequest.channel)
        && Objects.equals(this.direction, listMessagesByChannelIdentityRequest.direction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        channelIdentities,
        contactIds,
        appId,
        messagesSource,
        pageSize,
        pageToken,
        view,
        startTime,
        endTime,
        channel,
        direction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LastMessagesByChannelIdentityListQueryParametersImpl {\n");
    sb.append("    channelIdentities: ").append(toIndentedString(channelIdentities)).append("\n");
    sb.append("    contactIds: ").append(toIndentedString(contactIds)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    messagesSource: ").append(toIndentedString(messagesSource)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageToken: ").append(toIndentedString(pageToken)).append("\n");
    sb.append("    view: ").append(toIndentedString(view)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
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
  static class Builder implements LastMessagesByChannelIdentityListQueryParameters.Builder {
    OptionalValue<List<String>> channelIdentities = OptionalValue.empty();
    OptionalValue<List<String>> contactIds = OptionalValue.empty();
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<MessageSource> messagesSource = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();
    OptionalValue<ConversationMessagesView> view = OptionalValue.empty();
    OptionalValue<Instant> startTime = OptionalValue.empty();
    OptionalValue<Instant> endTime = OptionalValue.empty();
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<ConversationDirection> direction = OptionalValue.empty();

    protected Builder() {}

    protected Builder(LastMessagesByChannelIdentityListQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      LastMessagesByChannelIdentityListQueryParametersImpl parameters =
          (LastMessagesByChannelIdentityListQueryParametersImpl) _parameters;
      this.channelIdentities = parameters.channelIdentities;
      this.contactIds = parameters.contactIds;
      this.appId = parameters.appId;
      this.messagesSource = parameters.messagesSource;
      this.pageSize = parameters.pageSize;
      this.pageToken = parameters.pageToken;
      this.view = parameters.view;
      this.startTime = parameters.startTime;
      this.endTime = parameters.endTime;
      this.channel = parameters.channel;
      this.direction = parameters.direction;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITIES)
    public Builder setChannelIdentities(List<String> channelIdentities) {
      this.channelIdentities = OptionalValue.of(channelIdentities);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_IDS)
    public Builder setContactIds(List<String> contactIds) {
      this.contactIds = OptionalValue.of(contactIds);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGES_SOURCE)
    public Builder setMessagesSource(MessageSource messagesSource) {
      this.messagesSource = OptionalValue.of(messagesSource);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAGE_SIZE)
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAGE_TOKEN)
    public Builder setPageToken(String pageToken) {
      this.pageToken = OptionalValue.of(pageToken);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VIEW)
    public Builder setView(ConversationMessagesView view) {
      this.view = OptionalValue.of(view);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_START_TIME)
    public Builder setStartTime(Instant startTime) {
      this.startTime = OptionalValue.of(startTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_END_TIME)
    public Builder setEndTime(Instant endTime) {
      this.endTime = OptionalValue.of(endTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DIRECTION)
    public Builder setDirection(ConversationDirection direction) {
      this.direction = OptionalValue.of(direction);
      return this;
    }

    public LastMessagesByChannelIdentityListQueryParameters build() {
      return new LastMessagesByChannelIdentityListQueryParametersImpl(
          channelIdentities,
          contactIds,
          appId,
          messagesSource,
          pageSize,
          pageToken,
          view,
          startTime,
          endTime,
          channel,
          direction);
    }
  }
}
