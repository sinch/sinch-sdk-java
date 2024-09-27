package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The identifier of the channel you want to include. Must be one of the enum values. */
public class ConversationChannel extends EnumDynamic<String, ConversationChannel> {

  /** The WhatsApp channel. */
  public static final ConversationChannel WHATSAPP = new ConversationChannel("WHATSAPP");

  /** The RCS channel. */
  public static final ConversationChannel RCS = new ConversationChannel("RCS");

  /** The SMS channel. */
  public static final ConversationChannel SMS = new ConversationChannel("SMS");

  /** The Facebook Messenger channel. */
  public static final ConversationChannel MESSENGER = new ConversationChannel("MESSENGER");

  /** The Viber Bot channel. */
  public static final ConversationChannel VIBER = new ConversationChannel("VIBER");

  /** The Viber Business Messages channel. */
  public static final ConversationChannel VIBERBM = new ConversationChannel("VIBERBM");

  /** The MMS channel. */
  public static final ConversationChannel MMS = new ConversationChannel("MMS");

  /** The Instagram channel. */
  public static final ConversationChannel INSTAGRAM = new ConversationChannel("INSTAGRAM");

  /** The Telegram channel. */
  public static final ConversationChannel TELEGRAM = new ConversationChannel("TELEGRAM");

  /** The KakaoTalk channel. */
  public static final ConversationChannel KAKAOTALK = new ConversationChannel("KAKAOTALK");

  /** The KakaoTalk chat channel (used primarily in ConsultationTalk). */
  public static final ConversationChannel KAKAOTALKCHAT = new ConversationChannel("KAKAOTALKCHAT");

  /** The LINE channel. */
  public static final ConversationChannel LINE = new ConversationChannel("LINE");

  /** The WeChat channel. */
  public static final ConversationChannel WECHAT = new ConversationChannel("WECHAT");

  /** The Apple Messages for Business channel. */
  public static final ConversationChannel APPLEBC = new ConversationChannel("APPLEBC");

  private static final EnumSupportDynamic<String, ConversationChannel> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ConversationChannel.class,
          ConversationChannel::new,
          Arrays.asList(
              WHATSAPP,
              RCS,
              SMS,
              MESSENGER,
              VIBER,
              VIBERBM,
              MMS,
              INSTAGRAM,
              TELEGRAM,
              KAKAOTALK,
              KAKAOTALKCHAT,
              LINE,
              WECHAT,
              APPLEBC));

  private ConversationChannel(String value) {
    super(value);
  }

  public static Stream<ConversationChannel> values() {
    return ENUM_SUPPORT.values();
  }

  public static ConversationChannel from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ConversationChannel e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
