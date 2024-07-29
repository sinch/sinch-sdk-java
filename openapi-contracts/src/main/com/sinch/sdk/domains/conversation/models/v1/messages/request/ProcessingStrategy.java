package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Overrides the app's <a href="../../../../../conversation/processing-modes/">Processing Mode</a>.
 * Default value is <code>DEFAULT</code>.
 */
public class ProcessingStrategy extends EnumDynamic<String, ProcessingStrategy> {

  /** The request will inherit the app's configured processing mode. */
  public static final ProcessingStrategy DEFAULT = new ProcessingStrategy("DEFAULT");

  /**
   * Forces the request to be processed in dispatch mode (without storing contacts and
   * conversations), regardless of the app's configured processing mode.
   */
  public static final ProcessingStrategy DISPATCH_ONLY = new ProcessingStrategy("DISPATCH_ONLY");

  private static final EnumSupportDynamic<String, ProcessingStrategy> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ProcessingStrategy.class, ProcessingStrategy::new, Arrays.asList(DEFAULT, DISPATCH_ONLY));

  private ProcessingStrategy(String value) {
    super(value);
  }

  public static Stream<ProcessingStrategy> values() {
    return ENUM_SUPPORT.values();
  }

  public static ProcessingStrategy from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ProcessingStrategy e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
