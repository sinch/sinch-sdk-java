package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The most probable sentiment of the analyzed text. */
public class Sentiment extends EnumDynamic<String, Sentiment> {

  /** The sentiment of the text is most likely positive. */
  public static final Sentiment POSITIVE = new Sentiment("positive");

  /** The sentiment of the text is most likely negative. */
  public static final Sentiment NEGATIVE = new Sentiment("negative");

  /** The sentiment of the text is most likely neutral. */
  public static final Sentiment NEUTRAL = new Sentiment("neutral");

  private static final EnumSupportDynamic<String, Sentiment> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          Sentiment.class, Sentiment::new, Arrays.asList(POSITIVE, NEGATIVE, NEUTRAL));

  private Sentiment(String value) {
    super(value);
  }

  public static Stream<Sentiment> values() {
    return ENUM_SUPPORT.values();
  }

  public static Sentiment from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(Sentiment e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
