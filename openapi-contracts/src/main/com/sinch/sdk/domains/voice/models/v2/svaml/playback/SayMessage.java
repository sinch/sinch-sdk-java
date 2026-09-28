package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * A text-to-speech (TTS) message item. The platform synthesizes the provided text into speech and
 * plays it on the call.
 */
@JsonDeserialize(builder = SayMessageImpl.Builder.class)
public interface SayMessage extends Message {

  /** The type property. Must have the value <code>SAY</code>. */
  public class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>SAY</code> type. */
    public static final TypeEnum SAY = new TypeEnum("SAY");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(SAY));

    private TypeEnum(String value) {
      super(value);
    }

    public static Stream<TypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Get say
   *
   * <p>Field is required
   *
   * @return say
   */
  Say getSay();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SayMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param say see getter
     * @return Current builder
     * @see #getSay
     */
    Builder setSay(Say say);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SayMessage build();
  }
}
