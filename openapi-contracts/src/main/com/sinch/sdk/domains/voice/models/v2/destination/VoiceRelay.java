package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;

/**
 * Routes the call through the Voice Relay service, enabling real-time speech-to-text (STT) and
 * text-to-speech (TTS) via a WebSocket connection to the application backend.
 */
@JsonDeserialize(builder = VoiceRelayImpl.Builder.class)
public interface VoiceRelay extends CallDestination {

  /** The type property. Must have the value <code>VOICE_RELAY</code>. */
  public class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>VOICE_RELAY</code> type. */
    public static final TypeEnum VOICE_RELAY = new TypeEnum("VOICE_RELAY");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(VOICE_RELAY));

    private TypeEnum(String value) {
      super(value);
    }

    public static java.util.stream.Stream<TypeEnum> values() {
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
   * Get voiceRelay
   *
   * <p>Field is required
   *
   * @return voiceRelay
   */
  VoiceRelayDetails getVoiceRelay();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VoiceRelayImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param voiceRelay see getter
     * @return Current builder
     * @see #getVoiceRelay
     */
    Builder setVoiceRelay(VoiceRelayDetails voiceRelay);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VoiceRelay build();
  }
}
