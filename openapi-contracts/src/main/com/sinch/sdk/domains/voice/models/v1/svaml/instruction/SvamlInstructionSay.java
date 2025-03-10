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

/**
 * Plays a synthesized text-to-speech message to the end user. The message is provided in the text
 * field.
 */
@JsonDeserialize(builder = SvamlInstructionSayImpl.Builder.class)
public interface SvamlInstructionSay
    extends com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction {

  /** The <code>name</code> property. Must have the value <code>say</code>. */
  public class NameEnum extends EnumDynamic<String, NameEnum> {
    public static final NameEnum SAY = new NameEnum("say");

    private static final EnumSupportDynamic<String, NameEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(NameEnum.class, NameEnum::new, Arrays.asList(SAY));

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
   * Contains the message that will be spoken. Default maximum length is 600 characters. To change
   * this limit, please contact support.
   *
   * @return text
   */
  String getText();

  /**
   * The voice and language you want to use for the text-to-speech message. This can either be
   * defined by the ISO 639 locale and language code or by specifying a particular voice. Supported
   * languages and voices are detailed <a
   * href="https://developers.sinch.com/docs/voice/api-reference/voice-locales">here</a>.
   *
   * @return locale
   */
  String getLocale();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SvamlInstructionSayImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param text see getter
     * @return Current builder
     * @see #getText
     */
    Builder setText(String text);

    /**
     * see getter
     *
     * @param locale see getter
     * @return Current builder
     * @see #getLocale
     */
    Builder setLocale(String locale);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SvamlInstructionSay build();
  }
}
