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
import java.util.Objects;

/**
 * A unique identity of message recipient on a particular channel. For example, the channel identity
 * on SMS, WHATSAPP or VIBERBM is a MSISDN phone number.
 */
@JsonPropertyOrder({
  ChannelIdentityDto.JSON_PROPERTY_CHANNEL,
  ChannelIdentityDto.JSON_PROPERTY_IDENTITY,
  ChannelIdentityDto.JSON_PROPERTY_APP_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChannelIdentityDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_CHANNEL = "channel";
  private ConversationChannelDto channel;
  private boolean channelDefined = false;

  public static final String JSON_PROPERTY_IDENTITY = "identity";
  private String identity;
  private boolean identityDefined = false;

  public static final String JSON_PROPERTY_APP_ID = "app_id";
  private String appId;
  private boolean appIdDefined = false;

  public ChannelIdentityDto() {}

  public ChannelIdentityDto channel(ConversationChannelDto channel) {
    this.channel = channel;
    this.channelDefined = true;
    return this;
  }

  /**
   * Get channel
   *
   * @return channel
   */
  @JsonProperty(JSON_PROPERTY_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public ConversationChannelDto getChannel() {
    return channel;
  }

  @JsonIgnore
  public boolean getChannelDefined() {
    return channelDefined;
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setChannel(ConversationChannelDto channel) {
    this.channel = channel;
    this.channelDefined = true;
  }

  public ChannelIdentityDto identity(String identity) {
    this.identity = identity;
    this.identityDefined = true;
    return this;
  }

  /**
   * The channel identity. This will differ from channel to channel. For example, a phone number for
   * SMS, WhatsApp, and Viber Business.
   *
   * @return identity
   */
  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getIdentity() {
    return identity;
  }

  @JsonIgnore
  public boolean getIdentityDefined() {
    return identityDefined;
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIdentity(String identity) {
    this.identity = identity;
    this.identityDefined = true;
  }

  public ChannelIdentityDto appId(String appId) {
    this.appId = appId;
    this.appIdDefined = true;
    return this;
  }

  /**
   * Required if using a channel that uses app-scoped channel identities. Currently, FB Messenger,
   * Viber Bot, Instagram, Apple Messages for Business, LINE, and WeChat use app-scoped channel
   * identities, which means contacts will have different channel identities on different
   * Conversation API apps. These can be thought of as virtual identities that are app-specific and,
   * therefore, the app_id must be included in the API call.
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

  /** Return true if this ChannelIdentity object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelIdentityDto channelIdentity = (ChannelIdentityDto) o;
    return Objects.equals(this.channel, channelIdentity.channel)
        && Objects.equals(this.identity, channelIdentity.identity)
        && Objects.equals(this.appId, channelIdentity.appId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channel, identity, appId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelIdentityDto {\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
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
