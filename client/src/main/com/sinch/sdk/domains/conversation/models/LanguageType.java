package com.sinch.sdk.domains.conversation.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Supported languages
 *
 * @since 1.0
 */
public final class LanguageType extends EnumDynamic<String, LanguageType> {

  /** Afrikaans */
  public static final LanguageType AF = new LanguageType("AF");

  /** Albanian */
  public static final LanguageType SQ = new LanguageType("SQ");

  /** */
  public static final LanguageType AR = new LanguageType("AR");

  /** Azerbaijani */
  public static final LanguageType AZ = new LanguageType("AZ");

  /** Bengali */
  public static final LanguageType BN = new LanguageType("BN");

  /** Bulgarian */
  public static final LanguageType BG = new LanguageType("BG");

  /** Catalan */
  public static final LanguageType CA = new LanguageType("CA");

  /** Chinese */
  public static final LanguageType ZH = new LanguageType("ZH");

  /** Chinese (CHN) */
  public static final LanguageType ZH_CN = new LanguageType("ZH_CN");

  /** Chinese (HKG) */
  public static final LanguageType ZH_HK = new LanguageType("ZH_HK");

  /** Chinese (TAI) */
  public static final LanguageType ZH_TW = new LanguageType("ZH_TW");

  /** Croatian */
  public static final LanguageType HR = new LanguageType("HR");

  /** Czech */
  public static final LanguageType CS = new LanguageType("CS");

  /** Danish */
  public static final LanguageType DA = new LanguageType("DA");

  /** Dutch */
  public static final LanguageType NL = new LanguageType("NL");

  /** English */
  public static final LanguageType EN = new LanguageType("EN");

  /** English (UK) */
  public static final LanguageType EN_GB = new LanguageType("EN_GB");

  /** English (US) */
  public static final LanguageType EN_US = new LanguageType("EN_US");

  /** Estonian */
  public static final LanguageType ET = new LanguageType("ET");

  /** Filipino */
  public static final LanguageType FIL = new LanguageType("FIL");

  /** Finnish */
  public static final LanguageType FI = new LanguageType("FI");

  /** French */
  public static final LanguageType FR = new LanguageType("FR");

  /** German */
  public static final LanguageType DE = new LanguageType("DE");

  /** Greek */
  public static final LanguageType EL = new LanguageType("EL");

  /** Gujarati */
  public static final LanguageType GU = new LanguageType("GU");

  /** Hausa */
  public static final LanguageType HA = new LanguageType("HA");

  /** Hebrew */
  public static final LanguageType HE = new LanguageType("HE");

  /** Hindi */
  public static final LanguageType HI = new LanguageType("HI");

  /** Hungarian */
  public static final LanguageType HU = new LanguageType("HU");

  /** Indonesian */
  public static final LanguageType ID = new LanguageType("ID");

  /** Irish */
  public static final LanguageType GA = new LanguageType("GA");

  /** Italian */
  public static final LanguageType IT = new LanguageType("IT");

  /** Japanese */
  public static final LanguageType JA = new LanguageType("JA");

  /** Kannada */
  public static final LanguageType KN = new LanguageType("KN");

  /** Kazakh */
  public static final LanguageType KK = new LanguageType("KK");

  /** Korean */
  public static final LanguageType KO = new LanguageType("KO");

  /** Lao */
  public static final LanguageType LO = new LanguageType("LO");

  /** Latvian */
  public static final LanguageType LV = new LanguageType("LV");

  /** Lithuanian */
  public static final LanguageType LT = new LanguageType("LT");

  /** Macedonian */
  public static final LanguageType MK = new LanguageType("MK");

  /** Malay */
  public static final LanguageType MS = new LanguageType("MS");

  /** Malayalam */
  public static final LanguageType ML = new LanguageType("ML");

  /** Marathi */
  public static final LanguageType MR = new LanguageType("MR");

  /** Norwegian */
  public static final LanguageType NB = new LanguageType("NB");

  /** Persian */
  public static final LanguageType FA = new LanguageType("FA");

  /** Polish */
  public static final LanguageType PL = new LanguageType("PL");

  /** Portuguese */
  public static final LanguageType PT = new LanguageType("PT");

  /** Portuguese (BR) */
  public static final LanguageType PT_BR = new LanguageType("PT_BR");

  /** Portuguese (PT) */
  public static final LanguageType PT_PT = new LanguageType("PT_PT");

  /** Punjabi */
  public static final LanguageType PA = new LanguageType("PA");

  /** Romanian */
  public static final LanguageType RO = new LanguageType("RO");

  /** Russian */
  public static final LanguageType RU = new LanguageType("RU");

  /** Serbian */
  public static final LanguageType SR = new LanguageType("SR");

  /** Slovak */
  public static final LanguageType SK = new LanguageType("SK");

  /** Slovenian */
  public static final LanguageType SL = new LanguageType("SL");

  /** Spanish */
  public static final LanguageType ES = new LanguageType("ES");

  /** Spanish (ARG) */
  public static final LanguageType ES_AR = new LanguageType("ES_AR");

  /** Spanish (SPA) */
  public static final LanguageType ES_ES = new LanguageType("ES_ES");

  /** Spanish (MEX) */
  public static final LanguageType ES_MX = new LanguageType("ES_MX");

  /** Swahili */
  public static final LanguageType SW = new LanguageType("SW");

  /** Swedish */
  public static final LanguageType SV = new LanguageType("SV");

  /** Tamil */
  public static final LanguageType TA = new LanguageType("TA");

  /** Telugu */
  public static final LanguageType TE = new LanguageType("TE");

  /** Thai */
  public static final LanguageType TH = new LanguageType("TH");

  /** Turkish */
  public static final LanguageType TR = new LanguageType("TR");

  /** Ukrainian */
  public static final LanguageType UK = new LanguageType("UK");

  /** Urdu */
  public static final LanguageType UR = new LanguageType("UR");

  /** Uzbek */
  public static final LanguageType UZ = new LanguageType("UZ");

  /** Vietnamese */
  public static final LanguageType VI = new LanguageType("VI");

  /** Zulu */
  public static final LanguageType ZU = new LanguageType("ZU");

  private static final EnumSupportDynamic<String, LanguageType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          LanguageType.class,
          LanguageType::new,
          Arrays.asList(
              AF, SQ, AR, AZ, BN, BG, CA, ZH, ZH_CN, ZH_HK, ZH_TW, HR, CS, DA, NL, EN, EN_GB, EN_US,
              ET, FIL, FI, FR, DE, EL, GU, HA, HE, HI, HU, ID, GA, IT, JA, KN, KK, KO, LO, LV, LT,
              MK, MS, ML, MR, NB, FA, PL, PT, PT_BR, PT_PT, PA, RO, RU, SR, SK, SL, ES, ES_AR,
              ES_ES, ES_MX, SW, SV, TA, TE, TH, TR, UK, UR, UZ, VI, ZU));

  private LanguageType(String value) {
    super(value);
  }

  public static Stream<LanguageType> values() {
    return ENUM_SUPPORT.values();
  }

  public static LanguageType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(LanguageType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
