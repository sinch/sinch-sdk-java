/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Starts a recording of the call. */
@JsonDeserialize(builder = SvamlInstructionStartRecordingImpl.Builder.class)
public interface SvamlInstructionStartRecording
    extends com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction {

  /** The <code>name</code> property. Must have the value <code>startRecording</code>. */
  public class NameEnum extends EnumDynamic<String, NameEnum> {
    public static final NameEnum START_RECORDING = new NameEnum("startRecording");

    private static final EnumSupportDynamic<String, NameEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(NameEnum.class, NameEnum::new, Arrays.asList(START_RECORDING));

    private NameEnum(String value) {
      super(value);
    }

    public static Stream<NameEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static NameEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(NameEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Get options
   *
   * @return options
   */
  StartRecordingOptions getOptions();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SvamlInstructionStartRecordingImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param options see getter
     * @return Current builder
     * @see #getOptions
     */
    Builder setOptions(StartRecordingOptions options);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SvamlInstructionStartRecording build();
  }
}
