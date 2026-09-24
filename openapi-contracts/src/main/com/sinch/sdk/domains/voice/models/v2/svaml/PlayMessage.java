package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * An audio file playback message item. The platform fetches and plays the audio file at the
 * provided URL on the call.
 */
@JsonDeserialize(builder = PlayMessageImpl.Builder.class)
public interface PlayMessage extends Message {

  /** The type property. Must have the value <code>PLAY</code>. */
  public class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>PLAY</code> type. */
    public static final TypeEnum PLAY = new TypeEnum("PLAY");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(PLAY));

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
   * Get play
   *
   * <p>Field is required
   *
   * @return play
   */
  Play getPlay();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PlayMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param play see getter
     * @return Current builder
     * @see #getPlay
     */
    Builder setPlay(Play play);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PlayMessage build();
  }
}
