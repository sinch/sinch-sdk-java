package com.sinch.sdk.domains.conversation.templates.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets typeChannel */
public class TemplateChannel extends EnumDynamic<String, TemplateChannel> {

  public static final TemplateChannel UNSPECIFIED = new TemplateChannel("UNSPECIFIED");

  public static final TemplateChannel CONVERSATION = new TemplateChannel("CONVERSATION");

  public static final TemplateChannel MESSENGER = new TemplateChannel("MESSENGER");

  public static final TemplateChannel WHATSAPP = new TemplateChannel("WHATSAPP");

  public static final TemplateChannel RCS = new TemplateChannel("RCS");

  public static final TemplateChannel SMS = new TemplateChannel("SMS");

  public static final TemplateChannel VIBER = new TemplateChannel("VIBER");

  public static final TemplateChannel VIBERBM = new TemplateChannel("VIBERBM");

  public static final TemplateChannel TELEGRAM = new TemplateChannel("TELEGRAM");

  public static final TemplateChannel INSTAGRAM = new TemplateChannel("INSTAGRAM");

  public static final TemplateChannel KAKAOTALK = new TemplateChannel("KAKAOTALK");

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
              VIBER,
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
