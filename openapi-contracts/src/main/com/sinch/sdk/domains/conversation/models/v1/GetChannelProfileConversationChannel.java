package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The channel. Must be one of the supported channels for this operation. */
public class GetChannelProfileConversationChannel
    extends EnumDynamic<String, GetChannelProfileConversationChannel> {

  public static final GetChannelProfileConversationChannel MESSENGER =
      new GetChannelProfileConversationChannel("MESSENGER");

  public static final GetChannelProfileConversationChannel INSTAGRAM =
      new GetChannelProfileConversationChannel("INSTAGRAM");

  public static final GetChannelProfileConversationChannel VIBER =
      new GetChannelProfileConversationChannel("VIBER");

  public static final GetChannelProfileConversationChannel LINE =
      new GetChannelProfileConversationChannel("LINE");

  private static final EnumSupportDynamic<String, GetChannelProfileConversationChannel>
      ENUM_SUPPORT =
          new EnumSupportDynamic<>(
              GetChannelProfileConversationChannel.class,
              GetChannelProfileConversationChannel::new,
              Arrays.asList(MESSENGER, INSTAGRAM, VIBER, LINE));

  private GetChannelProfileConversationChannel(String value) {
    super(value);
  }

  public static Stream<GetChannelProfileConversationChannel> values() {
    return ENUM_SUPPORT.values();
  }

  public static GetChannelProfileConversationChannel from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(GetChannelProfileConversationChannel e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
