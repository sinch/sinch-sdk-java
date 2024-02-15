package com.sinch.sdk.domains.conversation.adapters.converters;

import com.sinch.sdk.domains.conversation.models.credentials.BasicAuthCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelInstagram;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelKakaoTalk;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelKakaoTalkChat;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelLine;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelMMS;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelMessenger;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelRCS;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelSMS;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelTelegram;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelViber;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelViberBM;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelWeChat;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelWhatsApp;
import com.sinch.sdk.domains.conversation.models.credentials.CredentialState;
import com.sinch.sdk.domains.conversation.models.credentials.CredentialStateStatusType;
import com.sinch.sdk.domains.conversation.models.credentials.Credentials;
import com.sinch.sdk.domains.conversation.models.credentials.InstagramCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.KakaoTalkChatCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.KakaoTalkCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.LineCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.MMSCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.StaticBearerCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.StaticTokenCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.TelegramCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.WeChatCredentials;
import com.sinch.sdk.domains.conversation.models.dto.v1.BasicAuthCredentialDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ConversationChannelCredentialDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ConversationChannelCredentialStateDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ConversationChannelDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.InstagramCredentialsDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.KakaoTalkChatCredentialsDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.KakaoTalkCredentialsDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.LineCredentialsDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.MMSCredentialsDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.StaticBearerCredentialDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.StaticTokenCredentialDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.TelegramCredentialsDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.WeChatCredentialsDto;
import java.util.Collection;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CredentialsDtoConverter {

  private static final Logger LOGGER = Logger.getLogger(CredentialsDtoConverter.class.getName());

  public static Collection<ConversationChannel<?>> convert(
      Collection<ConversationChannelCredentialDto> dto) {
    if (null == dto) {
      return null;
    }
    return dto.stream().map(CredentialsDtoConverter::convert).collect(Collectors.toList());
  }

  public static Collection<ConversationChannelCredentialDto> convertToDto(
      Collection<ConversationChannel<?>> client) {
    if (null == client) {
      return null;
    }
    return client.stream().map(CredentialsDtoConverter::convert).collect(Collectors.toList());
  }

  public static ConversationChannel<?> convert(ConversationChannelCredentialDto dto) {
    if (null == dto || null == dto.getChannel()) {
      return null;
    }

    ConversationChannel.Builder<?, ?> builder;

    switch (dto.getChannel()) {
      case WHATSAPP:
        builder =
            ConversationChannelWhatsApp.builder().setCredentials(convert(dto.getStaticBearer()));
        break;
      case RCS:
        builder = ConversationChannelRCS.builder().setCredentials(convert(dto.getStaticBearer()));
        break;
      case SMS:
        builder = ConversationChannelSMS.builder().setCredentials(convert(dto.getStaticBearer()));
        break;
      case MESSENGER:
        builder =
            ConversationChannelMessenger.builder().setCredentials(convert(dto.getStaticToken()));
        break;
      case VIBER:
        builder = ConversationChannelViber.builder().setCredentials(convert(dto.getStaticToken()));
        break;
      case VIBERBM:
        builder =
            ConversationChannelViberBM.builder().setCredentials(convert(dto.getStaticBearer()));
        break;
      case MMS:
        builder = ConversationChannelMMS.builder().setCredentials(convert(dto.getMmsCredentials()));
        break;
      case INSTAGRAM:
        builder =
            ConversationChannelInstagram.builder()
                .setCredentials(convert(dto.getInstagramCredentials()));
        break;
      case TELEGRAM:
        builder =
            ConversationChannelTelegram.builder()
                .setCredentials(convert(dto.getTelegramCredentials()));
        break;
      case KAKAOTALK:
        builder =
            ConversationChannelKakaoTalk.builder()
                .setCredentials(convert(dto.getKakaotalkCredentials()));
        break;
      case KAKAOTALKCHAT:
        builder =
            ConversationChannelKakaoTalkChat.builder()
                .setCredentials(convert(dto.getKakaotalkchatCredentials()));
        break;
      case LINE:
        builder =
            ConversationChannelLine.builder().setCredentials(convert(dto.getLineCredentials()));
        break;
      case WECHAT:
        builder =
            ConversationChannelWeChat.builder().setCredentials(convert(dto.getWechatCredentials()));
        break;
      default:
        LOGGER.severe("Unexpected" + dto.getChannel());
        return null;
    }
    builder
        .setState(convert(dto.getState()))
        .setCallbackSecret(dto.getCallbackSecret())
        .setChannelKnownId(dto.getChannelKnownId());
    return builder.build();
  }

  public static ConversationChannelCredentialDto convert(ConversationChannel<?> client) {
    if (null == client) {
      return null;
    }

    ConversationChannelCredentialDto dto = new ConversationChannelCredentialDto();
    if (null != client.getChannel()) {
      dto.channel(ConversationChannelDto.fromValue(client.getChannel().value()));
    }

    dto.callbackSecret(client.getCallbackSecret()).channelKnownId(client.getChannelKnownId());
    convert(dto, client.getCredentials());
    return dto;
  }

  private static void convert(ConversationChannelCredentialDto dto, Credentials client) {
    if (null == client) {
      return;
    }

    if (client instanceof MMSCredentials) {
      dto.setMmsCredentials(convert((MMSCredentials) client));
    } else if (client instanceof InstagramCredentials) {
      dto.setInstagramCredentials(convert((InstagramCredentials) client));
    } else if (client instanceof KakaoTalkCredentials) {
      dto.setKakaotalkCredentials(convert((KakaoTalkCredentials) client));
    } else if (client instanceof KakaoTalkChatCredentials) {
      dto.setKakaotalkchatCredentials(convert((KakaoTalkChatCredentials) client));
    } else if (client instanceof StaticBearerCredentials) {
      dto.setStaticBearer(convert((StaticBearerCredentials) client));
    } else if (client instanceof StaticTokenCredentials) {
      dto.setStaticToken(convert((StaticTokenCredentials) client));
    } else if (client instanceof TelegramCredentials) {
      dto.setTelegramCredentials(convert((TelegramCredentials) client));
    } else if (client instanceof LineCredentials) {
      dto.setLineCredentials(convert((LineCredentials) client));
    } else if (client instanceof WeChatCredentials) {
      dto.setWechatCredentials(convert((WeChatCredentials) client));
    } else {
      LOGGER.severe("Unexpected" + dto.getChannel());
    }
  }

  private static MMSCredentials convert(MMSCredentialsDto dto) {
    if (null == dto) {
      return null;
    }
    return MMSCredentials.builder()
        .setAccountId(dto.getAccountId())
        .setApiKey(dto.getApiKey())
        .setDefaultSender(dto.getDefaultSender())
        .setBasicAuth(convert(dto.getBasicAuth()))
        .build();
  }

  private static MMSCredentialsDto convert(MMSCredentials client) {
    if (null == client) {
      return null;
    }
    return new MMSCredentialsDto()
        .accountId(client.getAccountId())
        .apiKey(client.getApiKey())
        .defaultSender(client.getDefaultSender())
        .basicAuth(convert(client.getBasicAuth()));
  }

  private static BasicAuthCredentials convert(BasicAuthCredentialDto dto) {
    if (null == dto) {
      return null;
    }
    return BasicAuthCredentials.builder()
        .setUsername(dto.getUsername())
        .setPassword(dto.getPassword())
        .build();
  }

  private static BasicAuthCredentialDto convert(BasicAuthCredentials client) {
    if (null == client) {
      return null;
    }
    BasicAuthCredentialDto dto = new BasicAuthCredentialDto();
    dto.setUsername(client.getUsername());
    dto.setPassword(client.getPassword());
    return dto;
  }

  private static InstagramCredentials convert(InstagramCredentialsDto dto) {
    if (null == dto) {
      return null;
    }
    return InstagramCredentials.builder()
        .setBusinessAccountId(dto.getBusinessAccountId())
        .setToken(dto.getToken())
        .build();
  }

  private static InstagramCredentialsDto convert(InstagramCredentials client) {
    if (null == client) {
      return null;
    }
    return new InstagramCredentialsDto()
        .businessAccountId(client.getBusinessAccountId())
        .token(client.getToken());
  }

  private static StaticBearerCredentials convert(StaticBearerCredentialDto dto) {
    if (null == dto) {
      return null;
    }
    return StaticBearerCredentials.builder()
        .setClaimedIdentity(dto.getClaimedIdentity())
        .setToken(dto.getToken())
        .build();
  }

  private static StaticBearerCredentialDto convert(StaticBearerCredentials client) {
    if (null == client) {
      return null;
    }
    return new StaticBearerCredentialDto()
        .claimedIdentity(client.getClaimedIdentity())
        .token(client.getToken());
  }

  private static StaticTokenCredentials convert(StaticTokenCredentialDto dto) {
    if (null == dto) {
      return null;
    }
    return StaticTokenCredentials.builder().setToken(dto.getToken()).build();
  }

  private static StaticTokenCredentialDto convert(StaticTokenCredentials client) {
    if (null == client) {
      return null;
    }
    return new StaticTokenCredentialDto().token(client.getToken());
  }

  private static TelegramCredentials convert(TelegramCredentialsDto dto) {
    if (null == dto) {
      return null;
    }
    return TelegramCredentials.builder().setToken(dto.getToken()).build();
  }

  private static TelegramCredentialsDto convert(TelegramCredentials client) {
    if (null == client) {
      return null;
    }
    return new TelegramCredentialsDto().token(client.getToken());
  }

  private static KakaoTalkCredentials convert(KakaoTalkCredentialsDto dto) {
    if (null == dto) {
      return null;
    }
    return KakaoTalkCredentials.builder()
        .setKakaotalkPlusFriendId(dto.getKakaotalkPlusFriendId())
        .setKakaotalkSenderKey(dto.getKakaotalkSenderKey())
        .build();
  }

  private static KakaoTalkChatCredentials convert(KakaoTalkChatCredentialsDto dto) {
    if (null == dto) {
      return null;
    }
    return KakaoTalkChatCredentials.builder()
        .setKakaotalkPlusFriendId(dto.getKakaotalkPlusFriendId())
        .setApiKey(dto.getApiKey())
        .build();
  }

  private static KakaoTalkCredentialsDto convert(KakaoTalkCredentials client) {
    if (null == client) {
      return null;
    }

    return new KakaoTalkCredentialsDto()
        .kakaotalkPlusFriendId(client.getKakaotalkPlusFriendId())
        .kakaotalkSenderKey(client.getKakaotalkSenderKey());
  }

  private static KakaoTalkChatCredentialsDto convert(KakaoTalkChatCredentials client) {
    if (null == client) {
      return null;
    }

    return new KakaoTalkChatCredentialsDto()
        .kakaotalkPlusFriendId(client.getKakaotalkPlusFriendId())
        .apiKey(client.getApiKey());
  }

  private static LineCredentials convert(LineCredentialsDto dto) {
    if (null == dto) {
      return null;
    }
    return LineCredentials.builder().setToken(dto.getToken()).setSecret(dto.getSecret()).build();
  }

  private static LineCredentialsDto convert(LineCredentials client) {
    if (null == client) {
      return null;
    }
    return new LineCredentialsDto().token(client.getToken()).secret(client.getSecret());
  }

  private static WeChatCredentials convert(WeChatCredentialsDto dto) {
    if (null == dto) {
      return null;
    }
    return WeChatCredentials.builder()
        .setAppId(dto.getAppId())
        .setAppSecret(dto.getAppSecret())
        .setToken(dto.getToken())
        .setAesKey(dto.getAesKey())
        .build();
  }

  private static WeChatCredentialsDto convert(WeChatCredentials client) {
    if (null == client) {
      return null;
    }
    return new WeChatCredentialsDto()
        .appId(client.getAppId())
        .appSecret(client.getAppSecret())
        .token(client.getToken())
        .aesKey(client.getAesKey());
  }

  private static CredentialState convert(ConversationChannelCredentialStateDto dto) {
    if (null == dto) {
      return null;
    }
    return CredentialState.builder()
        .setStatus(CredentialStateStatusType.from(dto.getStatus()))
        .setDescription(dto.getDescription())
        .build();
  }
}
