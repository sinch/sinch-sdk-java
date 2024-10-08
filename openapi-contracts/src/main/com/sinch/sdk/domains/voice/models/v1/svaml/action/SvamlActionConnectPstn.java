/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Determines how a PSTN call is connected. Available to use in a response to an <a
 * href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/ice">Incoming
 * Call Event</a> callback.
 */
@JsonDeserialize(builder = SvamlActionConnectPstnImpl.Builder.class)
public interface SvamlActionConnectPstn
    extends com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction {

  /** The name property. Must have the value <code>connectPstn</code>. */
  public class NameEnum extends EnumDynamic<String, NameEnum> {
    public static final NameEnum CONNECT_PSTN = new NameEnum("connectPstn");

    private static final EnumSupportDynamic<String, NameEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(NameEnum.class, NameEnum::new, Arrays.asList(CONNECT_PSTN));

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
   * Used to override where PSTN call is connected. If not specified, the extension the client
   * called is used.
   *
   * @return number
   */
  String getNumber();

  /**
   * Specifies the locale. Uses the language code according to <code>ISO 639</code>, a dash (<code>-
   * </code>), and a country code according to <code>ISO 3166-1 alpha-2</code>. If not specified,
   * the default locale of <code>en-US</code> is used.
   *
   * @return locale
   */
  String getLocale();

  /**
   * The max duration of the call in seconds (max 14400 seconds). If the call is still connected at
   * that time, it will be automatically disconnected.
   *
   * @return maxDuration
   */
  Integer getMaxDuration();

  /**
   * The max duration the call will wait in ringing unanswered state before terminating with <code>
   * TIMEOUT/NO ANSWER</code> on PSTN leg and <code>NA/BUSY</code>on MXP leg.
   *
   * @return dialTimeout
   */
  Integer getDialTimeout();

  /**
   * Used to override the CLI (or caller ID) of the client. The phone number of the person who
   * initiated the call is shown as the CLI. To set your own CLI, you may use your verified number
   * or your Dashboard virtual number.
   *
   * @return cli
   */
  String getCli();

  /**
   * If enabled, suppresses <a
   * href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/ace">ACE</a>
   * and <a
   * href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/dice">DICE</a>
   * callbacks for the call.
   *
   * @return suppressCallbacks
   */
  Boolean getSuppressCallbacks();

  /**
   * A string that determines the DTMF tones to play to the callee when the call is picked up. Valid
   * characters are: <code>0-9</code>, <code>#</code>, and <code>w</code>. <code>w</code> renders a
   * 500ms pause. For example, the string <code>ww1234#w#</code>, plays a 1 second pause, the DTMF
   * tones for <code>1</code>, <code>2</code>, <code>3</code>, <code>4</code>, and <code>#</code>,
   * followed by a 500ms pause and finally the <code>#</code> tone. This is useful if the callout
   * destination requires a conference PIN code or an extension. If there is a calling party, it
   * will hear progress while the DTMF is sent.
   *
   * @return dtmf
   */
  String getDtmf();

  /** The locale's tone to play while ringing. */
  public class IndicationsEnum extends EnumDynamic<String, IndicationsEnum> {
    public static final IndicationsEnum AT = new IndicationsEnum("at");
    public static final IndicationsEnum AU = new IndicationsEnum("au");
    public static final IndicationsEnum BG = new IndicationsEnum("bg");
    public static final IndicationsEnum BR = new IndicationsEnum("br");
    public static final IndicationsEnum BE = new IndicationsEnum("be");
    public static final IndicationsEnum CH = new IndicationsEnum("ch");
    public static final IndicationsEnum CL = new IndicationsEnum("cl");
    public static final IndicationsEnum CN = new IndicationsEnum("cn");
    public static final IndicationsEnum CZ = new IndicationsEnum("cz");
    public static final IndicationsEnum DE = new IndicationsEnum("de");
    public static final IndicationsEnum DK = new IndicationsEnum("dk");
    public static final IndicationsEnum EE = new IndicationsEnum("ee");
    public static final IndicationsEnum ES = new IndicationsEnum("es");
    public static final IndicationsEnum FI = new IndicationsEnum("fi");
    public static final IndicationsEnum FR = new IndicationsEnum("fr");
    public static final IndicationsEnum GR = new IndicationsEnum("gr");
    public static final IndicationsEnum HU = new IndicationsEnum("hu");
    public static final IndicationsEnum IL = new IndicationsEnum("il");
    public static final IndicationsEnum IN = new IndicationsEnum("in");
    public static final IndicationsEnum IT = new IndicationsEnum("it");
    public static final IndicationsEnum LT = new IndicationsEnum("lt");
    public static final IndicationsEnum JP = new IndicationsEnum("jp");
    public static final IndicationsEnum MX = new IndicationsEnum("mx");
    public static final IndicationsEnum MY = new IndicationsEnum("my");
    public static final IndicationsEnum NL = new IndicationsEnum("nl");
    public static final IndicationsEnum FALSE = new IndicationsEnum("false");
    public static final IndicationsEnum NZ = new IndicationsEnum("nz");
    public static final IndicationsEnum PH = new IndicationsEnum("ph");
    public static final IndicationsEnum PL = new IndicationsEnum("pl");
    public static final IndicationsEnum PT = new IndicationsEnum("pt");
    public static final IndicationsEnum RU = new IndicationsEnum("ru");
    public static final IndicationsEnum SE = new IndicationsEnum("se");
    public static final IndicationsEnum SG = new IndicationsEnum("sg");
    public static final IndicationsEnum TH = new IndicationsEnum("th");
    public static final IndicationsEnum UK = new IndicationsEnum("uk");
    public static final IndicationsEnum US = new IndicationsEnum("us");
    public static final IndicationsEnum TW = new IndicationsEnum("tw");
    public static final IndicationsEnum VE = new IndicationsEnum("ve");
    public static final IndicationsEnum ZA = new IndicationsEnum("za");

    private static final EnumSupportDynamic<String, IndicationsEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            IndicationsEnum.class,
            IndicationsEnum::new,
            Arrays.asList(
                AT, AU, BG, BR, BE, CH, CL, CN, CZ, DE, DK, EE, ES, FI, FR, GR, HU, IL, IN, IT, LT,
                JP, MX, MY, NL, FALSE, NZ, PH, PL, PT, RU, SE, SG, TH, UK, US, TW, VE, ZA));

    private IndicationsEnum(String value) {
      super(value);
    }

    public static Stream<IndicationsEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static IndicationsEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(IndicationsEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The locale's tone to play while ringing.
   *
   * @return indications
   */
  IndicationsEnum getIndications();

  /**
   * Get amd
   *
   * @return amd
   */
  ConnectPstnAnsweringMachineDetection getAmd();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SvamlActionConnectPstnImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param number see getter
     * @return Current builder
     * @see #getNumber
     */
    Builder setNumber(String number);

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
     * @param maxDuration see getter
     * @return Current builder
     * @see #getMaxDuration
     */
    Builder setMaxDuration(Integer maxDuration);

    /**
     * see getter
     *
     * @param dialTimeout see getter
     * @return Current builder
     * @see #getDialTimeout
     */
    Builder setDialTimeout(Integer dialTimeout);

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
     * @param suppressCallbacks see getter
     * @return Current builder
     * @see #getSuppressCallbacks
     */
    Builder setSuppressCallbacks(Boolean suppressCallbacks);

    /**
     * see getter
     *
     * @param dtmf see getter
     * @return Current builder
     * @see #getDtmf
     */
    Builder setDtmf(String dtmf);

    /**
     * see getter
     *
     * @param indications see getter
     * @return Current builder
     * @see #getIndications
     */
    Builder setIndications(IndicationsEnum indications);

    /**
     * see getter
     *
     * @param amd see getter
     * @return Current builder
     * @see #getAmd
     */
    Builder setAmd(ConnectPstnAnsweringMachineDetection amd);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SvamlActionConnectPstn build();
  }
}
