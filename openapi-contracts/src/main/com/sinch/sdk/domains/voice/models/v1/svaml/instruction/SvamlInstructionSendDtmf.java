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

/** Plays DTMF tones in the call. */
@JsonDeserialize(builder = SvamlInstructionSendDtmfImpl.Builder.class)
public interface SvamlInstructionSendDtmf
    extends com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction {

  /** The <code>name</code> property. Must have the value <code>sendDtmf</code>. */
  public class NameEnum extends EnumDynamic<String, NameEnum> {
    public static final NameEnum SEND_DTMF = new NameEnum("sendDtmf");

    private static final EnumSupportDynamic<String, NameEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(NameEnum.class, NameEnum::new, Arrays.asList(SEND_DTMF));

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
   * A string that determines the DTMF tones to play to the callee when the call is picked up. Valid
   * characters are: <code>0-9</code>, <code>#</code>, and <code>w</code>. <code>w</code> renders a
   * 500ms pause. For example, the string <code>ww1234#w#</code>, plays a 1 second pause, the DTMF
   * tones for <code>1</code>, <code>2</code>, <code>3</code>, <code>4</code>, and <code>#</code>,
   * followed by a 500ms pause and finally the <code>#</code> tone. This is useful if the callout
   * destination requires a conference PIN code or an extension. If there is a calling party, it
   * will hear progress while the DTMF is sent.
   *
   * @return value
   */
  String getValue();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SvamlInstructionSendDtmfImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param value see getter
     * @return Current builder
     * @see #getValue
     */
    Builder setValue(String value);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SvamlInstructionSendDtmf build();
  }
}
