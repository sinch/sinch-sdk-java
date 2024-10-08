/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.callouts.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.Domain;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.util.Arrays;
import java.util.stream.Stream;

/** CalloutRequestTTS */
@JsonDeserialize(builder = CalloutRequestTTSImpl.Builder.class)
public interface CalloutRequestTTS
    extends com.sinch.sdk.domains.voice.models.v1.callouts.CalloutRequest {

  /** Gets or Sets method */
  public class MethodEnum extends EnumDynamic<String, MethodEnum> {
    public static final MethodEnum TTS_CALLOUT = new MethodEnum("ttsCallout");

    private static final EnumSupportDynamic<String, MethodEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(MethodEnum.class, MethodEnum::new, Arrays.asList(TTS_CALLOUT));

    private MethodEnum(String value) {
      super(value);
    }

    public static Stream<MethodEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static MethodEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(MethodEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The number that will be displayed as the incoming caller. To set your own CLI, you may use your
   * verified number or your Dashboard number. The number must be in <a
   * href="https://community.sinch.com/t5/Glossary/E-164/ta-p/7537">E.164</a> format.
   *
   * @return cli
   */
  String getCli();

  /**
   * Get destination
   *
   * @return destination
   */
  Destination getDestination();

  /**
   * When the destination picks up, this DTMF tones will be played to the callee. Valid characters
   * in the string are &quot;0&quot;-&quot;9&quot;, &quot;#&quot;, and &quot;w&quot;. A
   * &quot;w&quot; will render a 500 ms pause. For example, &quot;ww1234#w#&quot; will render a 1s
   * pause, the DTMF tones &quot;1&quot;, &quot;2&quot;, &quot;3&quot;, &quot;4&quot; and
   * &quot;#&quot; followed by a 0.5s pause and finally the DTMF tone for &quot;#&quot;. This can be
   * used if the callout destination for instance require a conference PIN code or an extension to
   * be entered.
   *
   * @return dtmf
   */
  DualToneMultiFrequency getDtmf();

  /**
   * Get domain
   *
   * @return domain
   */
  Domain getDomain();

  /**
   * Can be used to input custom data.
   *
   * @return custom
   */
  String getCustom();

  /**
   * The voice and language you want to use for the text-to-speech message. This can either be
   * defined by the ISO 639 locale and language code or by specifying a particular voice. Supported
   * languages and voices are detailed <a
   * href="https://developers.sinch.com/docs/voice/api-reference/voice-locales/">here</a>.
   *
   * @return locale
   */
  String getLocale();

  /**
   * The text that will be spoken in the text-to-speech message. <em>Every application's default
   * maximum characters allowed in text-to-speech is 600 characters. Contact support if you wish
   * this limit to be changed.</em>
   *
   * @return text
   */
  String getText();

  /**
   * An advanced alternative to using <code>text</code>. <strong>TTS</strong> <em>Text To
   * Speech:</em> The equivalent of text but within the prompt property. Example: <em><code>
   * #tts[Hello from Sinch]</code></em> <strong>TTS with SSML</strong> <em>Text To Speech with
   * Speech Synthesis Markup Language (SSML).</em> This is an XML-based markup language for
   * assisting the generation of synthetic speech in the Web and other applications. AWS Polly
   * supports a sub-set of SSML. This allows us to use SSML-enhanced text for additional control
   * over how Polly generates speech from the text. Details and examples of supported tags are <a
   * href="https://docs.aws.amazon.com/polly/latest/dg/supportedtags.html">here</a>
   * <strong>Externally hosted media:</strong> Provide a URL to your own hosted media. Please check
   * <a
   * href="https://developers.sinch.com/docs/voice/api-reference/supported-audio-formats/#limits">here</a>
   * to read about audio content type and usage limits. <em>Every application's default maximum
   * allowed in TTS or TTS SSML is 600 characters. Contact support if you wish this limit to be
   * changed.</em> <em>Several prompts can be used, separated by a semi-colon</em> <code>;</code>
   * Example: <em><code>
   * #tts[Hello from Sinch];#ssml[&lt;speak&gt;&lt;break time=\\\&quot;250ms\\\&quot;/&gt;Have a great day!&lt;/speak&gt;]
   * </code></em>
   *
   * @return prompts
   */
  String getPrompts();

  /**
   * If <code>enableAce</code> is set to <code>true</code> and the application has a callback URL
   * specified, you will receive an ACE callback when the call is answered. When the callback is
   * received, your platform must respond with a svamlet, containing the “connectconf” action in
   * order to add the call to a conference or create the conference if it's the first call. If it's
   * set to <code>false</code>, no ACE event will be sent to your backend.
   *
   * @return enableAce
   */
  Boolean getEnableAce();

  /**
   * If <code>enableDice</code> is set to <code>true</code> and the application has a callback URL
   * specified, you will receive a DiCE callback when the call is disconnected. If it's set to
   * <code>false</code>, no DiCE event will be sent to your backend.
   *
   * @return enableDice
   */
  Boolean getEnableDice();

  /**
   * <b>Note:</b> PIE callbacks are not available for DATA Calls; only PSTN and SIP calls. If <code>
   * enablePie</code> is set to <code>true</code> and the application has a callback URL specified,
   * you will receive a PIE callback after the <code>runMenu</code> action executes and after the
   * configured menu timeout has elapsed with no input. If it's set to <code>false</code>, no PIE
   * events will be sent to your backend.
   *
   * @return enablePie
   */
  Boolean getEnablePie();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CalloutRequestTTSImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param cli see getter
     * @return Current builder
     * @see #getCli
     */
    Builder setCli(String cli);

    /**
     * see getter
     *
     * @param destination see getter
     * @return Current builder
     * @see #getDestination
     */
    Builder setDestination(Destination destination);

    /**
     * see getter
     *
     * @param dtmf see getter
     * @return Current builder
     * @see #getDtmf
     */
    Builder setDtmf(DualToneMultiFrequency dtmf);

    /**
     * see getter
     *
     * @param domain see getter
     * @return Current builder
     * @see #getDomain
     */
    Builder setDomain(Domain domain);

    /**
     * see getter
     *
     * @param custom see getter
     * @return Current builder
     * @see #getCustom
     */
    Builder setCustom(String custom);

    /**
     * see getter
     *
     * @param locale see getter
     * @return Current builder
     * @see #getLocale
     */
    Builder setLocale(String locale);

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
     * @param prompts see getter
     * @return Current builder
     * @see #getPrompts
     */
    Builder setPrompts(String prompts);

    /**
     * see getter
     *
     * @param enableAce see getter
     * @return Current builder
     * @see #getEnableAce
     */
    Builder setEnableAce(Boolean enableAce);

    /**
     * see getter
     *
     * @param enableDice see getter
     * @return Current builder
     * @see #getEnableDice
     */
    Builder setEnableDice(Boolean enableDice);

    /**
     * see getter
     *
     * @param enablePie see getter
     * @return Current builder
     * @see #getEnablePie
     */
    Builder setEnablePie(Boolean enablePie);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CalloutRequestTTS build();
  }
}
