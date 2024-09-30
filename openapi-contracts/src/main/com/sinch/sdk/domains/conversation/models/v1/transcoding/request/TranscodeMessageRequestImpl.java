package com.sinch.sdk.domains.conversation.models.v1.transcoding.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  TranscodeMessageRequestImpl.JSON_PROPERTY_APP_ID,
  TranscodeMessageRequestImpl.JSON_PROPERTY_APP_MESSAGE,
  TranscodeMessageRequestImpl.JSON_PROPERTY_CHANNELS,
  TranscodeMessageRequestImpl.JSON_PROPERTY_FROM,
  TranscodeMessageRequestImpl.JSON_PROPERTY_TO
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TranscodeMessageRequestImpl implements TranscodeMessageRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_ID = "app_id";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_APP_MESSAGE = "app_message";

  private OptionalValue<AppMessage<?>> appMessage;

  public static final String JSON_PROPERTY_CHANNELS = "channels";

  private OptionalValue<List<ConversationChannel>> channels;

  public static final String JSON_PROPERTY_FROM = "from";

  private OptionalValue<String> from;

  public static final String JSON_PROPERTY_TO = "to";

  private OptionalValue<String> to;

  public TranscodeMessageRequestImpl() {}

  protected TranscodeMessageRequestImpl(
      OptionalValue<String> appId,
      OptionalValue<AppMessage<?>> appMessage,
      OptionalValue<List<ConversationChannel>> channels,
      OptionalValue<String> from,
      OptionalValue<String> to) {
    this.appId = appId;
    this.appMessage = appMessage;
    this.channels = channels;
    this.from = from;
    this.to = to;
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
  public AppMessage<?> getAppMessage() {
    return appMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<AppMessage<?>> appMessage() {
    return appMessage;
  }

  @JsonIgnore
  public List<ConversationChannel> getChannels() {
    return channels.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNELS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<ConversationChannel>> channels() {
    return channels;
  }

  @JsonIgnore
  public String getFrom() {
    return from.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> from() {
    return from;
  }

  @JsonIgnore
  public String getTo() {
    return to.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> to() {
    return to;
  }

  /** Return true if this TranscodeMessageRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TranscodeMessageRequestImpl transcodeMessageRequest = (TranscodeMessageRequestImpl) o;
    return Objects.equals(this.appId, transcodeMessageRequest.appId)
        && Objects.equals(this.appMessage, transcodeMessageRequest.appMessage)
        && Objects.equals(this.channels, transcodeMessageRequest.channels)
        && Objects.equals(this.from, transcodeMessageRequest.from)
        && Objects.equals(this.to, transcodeMessageRequest.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, appMessage, channels, from, to);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranscodeMessageRequestImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    appMessage: ").append(toIndentedString(appMessage)).append("\n");
    sb.append("    channels: ").append(toIndentedString(channels)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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
  static class Builder implements TranscodeMessageRequest.Builder {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<AppMessage<?>> appMessage = OptionalValue.empty();
    OptionalValue<List<ConversationChannel>> channels = OptionalValue.empty();
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<String> to = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APP_MESSAGE)
    public Builder setAppMessage(AppMessage<?> appMessage) {
      this.appMessage = OptionalValue.of(appMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNELS)
    public Builder setChannels(List<ConversationChannel> channels) {
      this.channels = OptionalValue.of(channels);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FROM)
    public Builder setFrom(String from) {
      this.from = OptionalValue.of(from);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TO)
    public Builder setTo(String to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    public TranscodeMessageRequest build() {
      return new TranscodeMessageRequestImpl(appId, appMessage, channels, from, to);
    }
  }
}
