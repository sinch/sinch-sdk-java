package com.sinch.sdk.domains.conversation.models.v1.app.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.credentials.AppleBcCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.InstagramCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.KakaoTalkChatCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.KakaoTalkCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.LineCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.MMSCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticBearerCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticTokenCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.TelegramCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.WeChatCredentials;
import java.util.Objects;

@JsonPropertyOrder({
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_STATIC_BEARER,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_STATIC_TOKEN,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_MMS_CREDENTIALS,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_KAKAOTALK_CREDENTIALS,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_TELEGRAM_CREDENTIALS,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_LINE_CREDENTIALS,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_WECHAT_CREDENTIALS,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_INSTAGRAM_CREDENTIALS,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_APPLEBC_CREDENTIALS,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_KAKAOTALKCHAT_CREDENTIALS,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_CALLBACK_SECRET,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_CHANNEL,
  ConversationChannelCredentialRequestImpl.JSON_PROPERTY_CHANNEL_KNOWN_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConversationChannelCredentialRequestImpl
    implements ConversationChannelCredentialRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_STATIC_BEARER = "static_bearer";

  private OptionalValue<StaticBearerCredentials> staticBearer;

  public static final String JSON_PROPERTY_STATIC_TOKEN = "static_token";

  private OptionalValue<StaticTokenCredentials> staticToken;

  public static final String JSON_PROPERTY_MMS_CREDENTIALS = "mms_credentials";

  private OptionalValue<MMSCredentials> mmsCredentials;

  public static final String JSON_PROPERTY_KAKAOTALK_CREDENTIALS = "kakaotalk_credentials";

  private OptionalValue<KakaoTalkCredentials> kakaotalkCredentials;

  public static final String JSON_PROPERTY_TELEGRAM_CREDENTIALS = "telegram_credentials";

  private OptionalValue<TelegramCredentials> telegramCredentials;

  public static final String JSON_PROPERTY_LINE_CREDENTIALS = "line_credentials";

  private OptionalValue<LineCredentials> lineCredentials;

  public static final String JSON_PROPERTY_WECHAT_CREDENTIALS = "wechat_credentials";

  private OptionalValue<WeChatCredentials> wechatCredentials;

  public static final String JSON_PROPERTY_INSTAGRAM_CREDENTIALS = "instagram_credentials";

  private OptionalValue<InstagramCredentials> instagramCredentials;

  public static final String JSON_PROPERTY_APPLEBC_CREDENTIALS = "applebc_credentials";

  private OptionalValue<AppleBcCredentials> applebcCredentials;

  public static final String JSON_PROPERTY_KAKAOTALKCHAT_CREDENTIALS = "kakaotalkchat_credentials";

  private OptionalValue<KakaoTalkChatCredentials> kakaotalkchatCredentials;

  public static final String JSON_PROPERTY_CALLBACK_SECRET = "callback_secret";

  private OptionalValue<String> callbackSecret;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<ConversationChannel> channel;

  public static final String JSON_PROPERTY_CHANNEL_KNOWN_ID = "channel_known_id";

  private OptionalValue<String> channelKnownId;

  public ConversationChannelCredentialRequestImpl() {}

  protected ConversationChannelCredentialRequestImpl(
      OptionalValue<StaticBearerCredentials> staticBearer,
      OptionalValue<StaticTokenCredentials> staticToken,
      OptionalValue<MMSCredentials> mmsCredentials,
      OptionalValue<KakaoTalkCredentials> kakaotalkCredentials,
      OptionalValue<TelegramCredentials> telegramCredentials,
      OptionalValue<LineCredentials> lineCredentials,
      OptionalValue<WeChatCredentials> wechatCredentials,
      OptionalValue<InstagramCredentials> instagramCredentials,
      OptionalValue<AppleBcCredentials> applebcCredentials,
      OptionalValue<KakaoTalkChatCredentials> kakaotalkchatCredentials,
      OptionalValue<String> callbackSecret,
      OptionalValue<ConversationChannel> channel,
      OptionalValue<String> channelKnownId) {
    this.staticBearer = staticBearer;
    this.staticToken = staticToken;
    this.mmsCredentials = mmsCredentials;
    this.kakaotalkCredentials = kakaotalkCredentials;
    this.telegramCredentials = telegramCredentials;
    this.lineCredentials = lineCredentials;
    this.wechatCredentials = wechatCredentials;
    this.instagramCredentials = instagramCredentials;
    this.applebcCredentials = applebcCredentials;
    this.kakaotalkchatCredentials = kakaotalkchatCredentials;
    this.callbackSecret = callbackSecret;
    this.channel = channel;
    this.channelKnownId = channelKnownId;
  }

  @JsonIgnore
  public StaticBearerCredentials getStaticBearer() {
    return staticBearer.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATIC_BEARER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StaticBearerCredentials> staticBearer() {
    return staticBearer;
  }

  @JsonIgnore
  public StaticTokenCredentials getStaticToken() {
    return staticToken.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATIC_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StaticTokenCredentials> staticToken() {
    return staticToken;
  }

  @JsonIgnore
  public MMSCredentials getMmsCredentials() {
    return mmsCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MMS_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MMSCredentials> mmsCredentials() {
    return mmsCredentials;
  }

  @JsonIgnore
  public KakaoTalkCredentials getKakaotalkCredentials() {
    return kakaotalkCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KAKAOTALK_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<KakaoTalkCredentials> kakaotalkCredentials() {
    return kakaotalkCredentials;
  }

  @JsonIgnore
  public TelegramCredentials getTelegramCredentials() {
    return telegramCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TELEGRAM_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TelegramCredentials> telegramCredentials() {
    return telegramCredentials;
  }

  @JsonIgnore
  public LineCredentials getLineCredentials() {
    return lineCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINE_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LineCredentials> lineCredentials() {
    return lineCredentials;
  }

  @JsonIgnore
  public WeChatCredentials getWechatCredentials() {
    return wechatCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WECHAT_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<WeChatCredentials> wechatCredentials() {
    return wechatCredentials;
  }

  @JsonIgnore
  public InstagramCredentials getInstagramCredentials() {
    return instagramCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INSTAGRAM_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<InstagramCredentials> instagramCredentials() {
    return instagramCredentials;
  }

  @JsonIgnore
  public AppleBcCredentials getApplebcCredentials() {
    return applebcCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APPLEBC_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AppleBcCredentials> applebcCredentials() {
    return applebcCredentials;
  }

  @JsonIgnore
  public KakaoTalkChatCredentials getKakaotalkchatCredentials() {
    return kakaotalkchatCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KAKAOTALKCHAT_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<KakaoTalkChatCredentials> kakaotalkchatCredentials() {
    return kakaotalkchatCredentials;
  }

  @JsonIgnore
  public String getCallbackSecret() {
    return callbackSecret.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_SECRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callbackSecret() {
    return callbackSecret;
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
  public String getChannelKnownId() {
    return channelKnownId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_KNOWN_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> channelKnownId() {
    return channelKnownId;
  }

  /** Return true if this ConversationChannelCredentialRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversationChannelCredentialRequestImpl conversationChannelCredentialRequest =
        (ConversationChannelCredentialRequestImpl) o;
    return Objects.equals(this.staticBearer, conversationChannelCredentialRequest.staticBearer)
        && Objects.equals(this.staticToken, conversationChannelCredentialRequest.staticToken)
        && Objects.equals(this.mmsCredentials, conversationChannelCredentialRequest.mmsCredentials)
        && Objects.equals(
            this.kakaotalkCredentials, conversationChannelCredentialRequest.kakaotalkCredentials)
        && Objects.equals(
            this.telegramCredentials, conversationChannelCredentialRequest.telegramCredentials)
        && Objects.equals(
            this.lineCredentials, conversationChannelCredentialRequest.lineCredentials)
        && Objects.equals(
            this.wechatCredentials, conversationChannelCredentialRequest.wechatCredentials)
        && Objects.equals(
            this.instagramCredentials, conversationChannelCredentialRequest.instagramCredentials)
        && Objects.equals(
            this.applebcCredentials, conversationChannelCredentialRequest.applebcCredentials)
        && Objects.equals(
            this.kakaotalkchatCredentials,
            conversationChannelCredentialRequest.kakaotalkchatCredentials)
        && Objects.equals(this.callbackSecret, conversationChannelCredentialRequest.callbackSecret)
        && Objects.equals(this.channel, conversationChannelCredentialRequest.channel)
        && Objects.equals(this.channelKnownId, conversationChannelCredentialRequest.channelKnownId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        staticBearer,
        staticToken,
        mmsCredentials,
        kakaotalkCredentials,
        telegramCredentials,
        lineCredentials,
        wechatCredentials,
        instagramCredentials,
        applebcCredentials,
        kakaotalkchatCredentials,
        callbackSecret,
        channel,
        channelKnownId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversationChannelCredentialRequestImpl {\n");
    sb.append("    staticBearer: ").append(toIndentedString(staticBearer)).append("\n");
    sb.append("    staticToken: ").append(toIndentedString(staticToken)).append("\n");
    sb.append("    mmsCredentials: ").append(toIndentedString(mmsCredentials)).append("\n");
    sb.append("    kakaotalkCredentials: ")
        .append(toIndentedString(kakaotalkCredentials))
        .append("\n");
    sb.append("    telegramCredentials: ")
        .append(toIndentedString(telegramCredentials))
        .append("\n");
    sb.append("    lineCredentials: ").append(toIndentedString(lineCredentials)).append("\n");
    sb.append("    wechatCredentials: ").append(toIndentedString(wechatCredentials)).append("\n");
    sb.append("    instagramCredentials: ")
        .append(toIndentedString(instagramCredentials))
        .append("\n");
    sb.append("    applebcCredentials: ").append(toIndentedString(applebcCredentials)).append("\n");
    sb.append("    kakaotalkchatCredentials: ")
        .append(toIndentedString(kakaotalkchatCredentials))
        .append("\n");
    sb.append("    callbackSecret: ").append(toIndentedString(callbackSecret)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    channelKnownId: ").append(toIndentedString(channelKnownId)).append("\n");
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
  static class Builder implements ConversationChannelCredentialRequest.Builder {
    OptionalValue<StaticBearerCredentials> staticBearer = OptionalValue.empty();
    OptionalValue<StaticTokenCredentials> staticToken = OptionalValue.empty();
    OptionalValue<MMSCredentials> mmsCredentials = OptionalValue.empty();
    OptionalValue<KakaoTalkCredentials> kakaotalkCredentials = OptionalValue.empty();
    OptionalValue<TelegramCredentials> telegramCredentials = OptionalValue.empty();
    OptionalValue<LineCredentials> lineCredentials = OptionalValue.empty();
    OptionalValue<WeChatCredentials> wechatCredentials = OptionalValue.empty();
    OptionalValue<InstagramCredentials> instagramCredentials = OptionalValue.empty();
    OptionalValue<AppleBcCredentials> applebcCredentials = OptionalValue.empty();
    OptionalValue<KakaoTalkChatCredentials> kakaotalkchatCredentials = OptionalValue.empty();
    OptionalValue<String> callbackSecret = OptionalValue.empty();
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<String> channelKnownId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_STATIC_BEARER)
    public Builder setStaticBearer(StaticBearerCredentials staticBearer) {
      this.staticBearer = OptionalValue.of(staticBearer);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATIC_TOKEN)
    public Builder setStaticToken(StaticTokenCredentials staticToken) {
      this.staticToken = OptionalValue.of(staticToken);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MMS_CREDENTIALS)
    public Builder setMmsCredentials(MMSCredentials mmsCredentials) {
      this.mmsCredentials = OptionalValue.of(mmsCredentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_KAKAOTALK_CREDENTIALS)
    public Builder setKakaotalkCredentials(KakaoTalkCredentials kakaotalkCredentials) {
      this.kakaotalkCredentials = OptionalValue.of(kakaotalkCredentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TELEGRAM_CREDENTIALS)
    public Builder setTelegramCredentials(TelegramCredentials telegramCredentials) {
      this.telegramCredentials = OptionalValue.of(telegramCredentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINE_CREDENTIALS)
    public Builder setLineCredentials(LineCredentials lineCredentials) {
      this.lineCredentials = OptionalValue.of(lineCredentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_WECHAT_CREDENTIALS)
    public Builder setWechatCredentials(WeChatCredentials wechatCredentials) {
      this.wechatCredentials = OptionalValue.of(wechatCredentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INSTAGRAM_CREDENTIALS)
    public Builder setInstagramCredentials(InstagramCredentials instagramCredentials) {
      this.instagramCredentials = OptionalValue.of(instagramCredentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APPLEBC_CREDENTIALS)
    public Builder setApplebcCredentials(AppleBcCredentials applebcCredentials) {
      this.applebcCredentials = OptionalValue.of(applebcCredentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_KAKAOTALKCHAT_CREDENTIALS)
    public Builder setKakaotalkchatCredentials(KakaoTalkChatCredentials kakaotalkchatCredentials) {
      this.kakaotalkchatCredentials = OptionalValue.of(kakaotalkchatCredentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLBACK_SECRET)
    public Builder setCallbackSecret(String callbackSecret) {
      this.callbackSecret = OptionalValue.of(callbackSecret);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_KNOWN_ID)
    public Builder setChannelKnownId(String channelKnownId) {
      this.channelKnownId = OptionalValue.of(channelKnownId);
      return this;
    }

    public ConversationChannelCredentialRequest build() {
      return new ConversationChannelCredentialRequestImpl(
          staticBearer,
          staticToken,
          mmsCredentials,
          kakaotalkCredentials,
          telegramCredentials,
          lineCredentials,
          wechatCredentials,
          instagramCredentials,
          applebcCredentials,
          kakaotalkchatCredentials,
          callbackSecret,
          channel,
          channelKnownId);
    }
  }
}
