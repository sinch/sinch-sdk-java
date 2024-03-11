package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The identifier of the channel you want to include. Must be one of the enum values. */
public class ConversationChannel extends EnumDynamic<String, ConversationChannel> {

  public static final ConversationChannel WHATSAPP = new ConversationChannel("WHATSAPP");

  public static final ConversationChannel RCS = new ConversationChannel("RCS");

  public static final ConversationChannel SMS = new ConversationChannel("SMS");

  public static final ConversationChannel MESSENGER = new ConversationChannel("MESSENGER");

  public static final ConversationChannel VIBER = new ConversationChannel("VIBER");

  public static final ConversationChannel VIBERBM = new ConversationChannel("VIBERBM");

  public static final ConversationChannel MMS = new ConversationChannel("MMS");

  public static final ConversationChannel INSTAGRAM = new ConversationChannel("INSTAGRAM");

  public static final ConversationChannel TELEGRAM = new ConversationChannel("TELEGRAM");

  public static final ConversationChannel KAKAOTALK = new ConversationChannel("KAKAOTALK");

  public static final ConversationChannel KAKAOTALKCHAT = new ConversationChannel("KAKAOTALKCHAT");

  public static final ConversationChannel LINE = new ConversationChannel("LINE");

  public static final ConversationChannel WECHAT = new ConversationChannel("WECHAT");

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
