package com.sinch.sdk.domains.conversation.templates.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets typeChannel */
public class TemplateChannel extends EnumDynamic<String, TemplateChannel> {

  /** Unspecified channel. */
  public static final TemplateChannel UNSPECIFIED = new TemplateChannel("UNSPECIFIED");

  /** Conversation channel. */
  public static final TemplateChannel CONVERSATION = new TemplateChannel("CONVERSATION");

  /** The Facebook Messenger channel. */
  public static final TemplateChannel MESSENGER = new TemplateChannel("MESSENGER");

  /** The WhatsApp channel. */
  public static final TemplateChannel WHATSAPP = new TemplateChannel("WHATSAPP");

  /** The RCS channel. */
  public static final TemplateChannel RCS = new TemplateChannel("RCS");

  /** The SMS channel. */
  public static final TemplateChannel SMS = new TemplateChannel("SMS");

  /** The Viber Business Messages channel. */
  public static final TemplateChannel VIBERBM = new TemplateChannel("VIBERBM");

  /** The Telegram channel. */
  public static final TemplateChannel TELEGRAM = new TemplateChannel("TELEGRAM");

  /** The Instagram channel. */
  public static final TemplateChannel INSTAGRAM = new TemplateChannel("INSTAGRAM");

  /** The KakaoTalk channel. */
  public static final TemplateChannel KAKAOTALK = new TemplateChannel("KAKAOTALK");

  /** The Apple Messages for Business channel. */
  public static final TemplateChannel APPLEBC = new TemplateChannel("APPLEBC");

  private static final EnumSupportDynamic<String, TemplateChannel> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          TemplateChannel.class,
          TemplateChannel::new,
          Arrays.asList(
              UNSPECIFIED,
              CONVERSATION,
              MESSENGER,
              WHATSAPP,
              RCS,
              SMS,
              VIBERBM,
              TELEGRAM,
              INSTAGRAM,
              KAKAOTALK,
              APPLEBC));

  private TemplateChannel(String value) {
    super(value);
  }

  public static Stream<TemplateChannel> values() {
    return ENUM_SUPPORT.values();
  }

  public static TemplateChannel from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(TemplateChannel e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
