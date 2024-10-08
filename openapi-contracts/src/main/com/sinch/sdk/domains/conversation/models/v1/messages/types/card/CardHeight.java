package com.sinch.sdk.domains.conversation.models.v1.messages.types.card;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** You can set the desired size of the card in the message. */
public class CardHeight extends EnumDynamic<String, CardHeight> {

  /** The height of the card is unspecified. */
  public static final CardHeight UNSPECIFIED_HEIGHT = new CardHeight("UNSPECIFIED_HEIGHT");

  /** The shortest card height. */
  public static final CardHeight SHORT = new CardHeight("SHORT");

  /** Medium card height. */
  public static final CardHeight MEDIUM = new CardHeight("MEDIUM");

  /** The tallest card height. */
  public static final CardHeight TALL = new CardHeight("TALL");

  private static final EnumSupportDynamic<String, CardHeight> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CardHeight.class,
          CardHeight::new,
          Arrays.asList(UNSPECIFIED_HEIGHT, SHORT, MEDIUM, TALL));

  private CardHeight(String value) {
    super(value);
  }

  public static Stream<CardHeight> values() {
    return ENUM_SUPPORT.values();
  }

  public static CardHeight from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CardHeight e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
