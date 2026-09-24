package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;

/** Routes the call to a WebSocket stream endpoint for real-time audio processing. */
@JsonDeserialize(builder = StreamImpl.Builder.class)
public interface Stream extends CallDestination {

  /** The type property. Must have the value <code>STREAM</code>. */
  public class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>STREAM</code> type. */
    public static final TypeEnum STREAM = new TypeEnum("STREAM");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(STREAM));

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
   * Get stream
   *
   * <p>Field is required
   *
   * @return stream
   */
  StreamDetails getStream();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StreamImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param stream see getter
     * @return Current builder
     * @see #getStream
     */
    Builder setStream(StreamDetails stream);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Stream build();
  }
}
