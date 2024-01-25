package com.sinch.sdk.domains.conversation.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Type of channel
 *
 * @since 1.0
 */
public final class ChannelType extends EnumDynamic<String, ChannelType> {

  public static final ChannelType WHATSAPP = new ChannelType("WHATSAPP");
  public static final ChannelType RCS = new ChannelType("RCS");
  public static final ChannelType SMS = new ChannelType("SMS");
  public static final ChannelType MESSENGER = new ChannelType("MESSENGER");
  public static final ChannelType VIBER = new ChannelType("VIBER");
  public static final ChannelType VIBERBM = new ChannelType("VIBERBM");
  public static final ChannelType MMS = new ChannelType("MMS");
  public static final ChannelType INSTAGRAM = new ChannelType("INSTAGRAM");
  public static final ChannelType TELEGRAM = new ChannelType("TELEGRAM");
  public static final ChannelType KAKAO_TALK = new ChannelType("KAKAOTALK");
  public static final ChannelType KAKAO_TALK_CHAT = new ChannelType("KAKAOTALKCHAT");
  public static final ChannelType LINE = new ChannelType("LINE");
  public static final ChannelType WECHAT = new ChannelType("WECHAT");

  private static final EnumSupportDynamic<String, ChannelType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ChannelType.class,
          ChannelType::new,
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
              KAKAO_TALK,
              KAKAO_TALK_CHAT,
              LINE,
              WECHAT));

  private ChannelType(String value) {
    super(value);
  }

  public static Stream<ChannelType> values() {
    return ENUM_SUPPORT.values();
  }

  public static ChannelType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ChannelType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
