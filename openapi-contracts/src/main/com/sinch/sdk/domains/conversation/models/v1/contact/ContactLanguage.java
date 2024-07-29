package com.sinch.sdk.domains.conversation.models.v1.contact;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets ContactLanguage */
public class ContactLanguage extends EnumDynamic<String, ContactLanguage> {

  /** Afrikaans */
  public static final ContactLanguage AF = new ContactLanguage("AF");

  /** Albanian */
  public static final ContactLanguage SQ = new ContactLanguage("SQ");

  /** Arabic */
  public static final ContactLanguage AR = new ContactLanguage("AR");

  /** Azerbaijani */
  public static final ContactLanguage AZ = new ContactLanguage("AZ");

  /** Bengali */
  public static final ContactLanguage BN = new ContactLanguage("BN");

  /** Bulgarian */
  public static final ContactLanguage BG = new ContactLanguage("BG");

  /** Catalan */
  public static final ContactLanguage CA = new ContactLanguage("CA");

  /** Chinese */
  public static final ContactLanguage ZH = new ContactLanguage("ZH");

  /** Chinese (CHN) */
  public static final ContactLanguage ZH_CN = new ContactLanguage("ZH_CN");

  /** Chinese (HKG) */
  public static final ContactLanguage ZH_HK = new ContactLanguage("ZH_HK");

  /** Chinese (TAI) */
  public static final ContactLanguage ZH_TW = new ContactLanguage("ZH_TW");

  /** Croatian */
  public static final ContactLanguage HR = new ContactLanguage("HR");

  /** Czech */
  public static final ContactLanguage CS = new ContactLanguage("CS");

  /** Danish */
  public static final ContactLanguage DA = new ContactLanguage("DA");

  /** Dutch */
  public static final ContactLanguage NL = new ContactLanguage("NL");

  /** English */
  public static final ContactLanguage EN = new ContactLanguage("EN");

  /** English (UK) */
  public static final ContactLanguage EN_GB = new ContactLanguage("EN_GB");

  /** English (US) */
  public static final ContactLanguage EN_US = new ContactLanguage("EN_US");

  /** Estonian */
  public static final ContactLanguage ET = new ContactLanguage("ET");

  /** Filipino */
  public static final ContactLanguage FIL = new ContactLanguage("FIL");

  /** Finnish */
  public static final ContactLanguage FI = new ContactLanguage("FI");

  /** French */
  public static final ContactLanguage FR = new ContactLanguage("FR");

  /** German */
  public static final ContactLanguage DE = new ContactLanguage("DE");

  /** Greek */
  public static final ContactLanguage EL = new ContactLanguage("EL");

  /** Gujarati */
  public static final ContactLanguage GU = new ContactLanguage("GU");

  /** Hausa */
  public static final ContactLanguage HA = new ContactLanguage("HA");

  /** Hebrew */
  public static final ContactLanguage HE = new ContactLanguage("HE");

  /** Hindi */
  public static final ContactLanguage HI = new ContactLanguage("HI");

  /** Hungarian */
  public static final ContactLanguage HU = new ContactLanguage("HU");

  /** Indonesian */
  public static final ContactLanguage ID = new ContactLanguage("ID");

  /** Irish */
  public static final ContactLanguage GA = new ContactLanguage("GA");

  /** Italian */
  public static final ContactLanguage IT = new ContactLanguage("IT");

  /** Japanese */
  public static final ContactLanguage JA = new ContactLanguage("JA");

  /** Kannada */
  public static final ContactLanguage KN = new ContactLanguage("KN");

  /** Kazakh */
  public static final ContactLanguage KK = new ContactLanguage("KK");

  /** Korean */
  public static final ContactLanguage KO = new ContactLanguage("KO");

  /** Lao */
  public static final ContactLanguage LO = new ContactLanguage("LO");

  /** Latvian */
  public static final ContactLanguage LV = new ContactLanguage("LV");

  /** Lithuanian */
  public static final ContactLanguage LT = new ContactLanguage("LT");

  /** Macedonian */
  public static final ContactLanguage MK = new ContactLanguage("MK");

  /** Malay */
  public static final ContactLanguage MS = new ContactLanguage("MS");

  /** Malayalam */
  public static final ContactLanguage ML = new ContactLanguage("ML");

  /** Marathi */
  public static final ContactLanguage MR = new ContactLanguage("MR");

  /** Norwegian */
  public static final ContactLanguage NB = new ContactLanguage("NB");

  /** Persian */
  public static final ContactLanguage FA = new ContactLanguage("FA");

  /** Polish */
  public static final ContactLanguage PL = new ContactLanguage("PL");

  /** Portuguese */
  public static final ContactLanguage PT = new ContactLanguage("PT");

  /** Portuguese (BR) */
  public static final ContactLanguage PT_BR = new ContactLanguage("PT_BR");

  /** Portuguese (PT) */
  public static final ContactLanguage PT_PT = new ContactLanguage("PT_PT");

  /** Punjabi */
  public static final ContactLanguage PA = new ContactLanguage("PA");

  /** Romanian */
  public static final ContactLanguage RO = new ContactLanguage("RO");

  /** Russian */
  public static final ContactLanguage RU = new ContactLanguage("RU");

  /** Serbian */
  public static final ContactLanguage SR = new ContactLanguage("SR");

  /** Slovak */
  public static final ContactLanguage SK = new ContactLanguage("SK");

  /** Slovenian */
  public static final ContactLanguage SL = new ContactLanguage("SL");

  /** Spanish */
  public static final ContactLanguage ES = new ContactLanguage("ES");

  /** Spanish (ARG) */
  public static final ContactLanguage ES_AR = new ContactLanguage("ES_AR");

  /** Spanish (SPA) */
  public static final ContactLanguage ES_ES = new ContactLanguage("ES_ES");

  /** Spanish (MEX) */
  public static final ContactLanguage ES_MX = new ContactLanguage("ES_MX");

  /** Swahili */
  public static final ContactLanguage SW = new ContactLanguage("SW");

  /** Swedish */
  public static final ContactLanguage SV = new ContactLanguage("SV");

  /** Tamil */
  public static final ContactLanguage TA = new ContactLanguage("TA");

  /** Telugu */
  public static final ContactLanguage TE = new ContactLanguage("TE");

  /** Thai */
  public static final ContactLanguage TH = new ContactLanguage("TH");

  /** Turkish */
  public static final ContactLanguage TR = new ContactLanguage("TR");

  /** Ukrainian */
  public static final ContactLanguage UK = new ContactLanguage("UK");

  /** Urdu */
  public static final ContactLanguage UR = new ContactLanguage("UR");

  /** Uzbek */
  public static final ContactLanguage UZ = new ContactLanguage("UZ");

  /** Vietnamese */
  public static final ContactLanguage VI = new ContactLanguage("VI");

  /** Zulu */
  public static final ContactLanguage ZU = new ContactLanguage("ZU");

  private static final EnumSupportDynamic<String, ContactLanguage> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ContactLanguage.class,
          ContactLanguage::new,
          Arrays.asList(
              AF, SQ, AR, AZ, BN, BG, CA, ZH, ZH_CN, ZH_HK, ZH_TW, HR, CS, DA, NL, EN, EN_GB, EN_US,
              ET, FIL, FI, FR, DE, EL, GU, HA, HE, HI, HU, ID, GA, IT, JA, KN, KK, KO, LO, LV, LT,
              MK, MS, ML, MR, NB, FA, PL, PT, PT_BR, PT_PT, PA, RO, RU, SR, SK, SL, ES, ES_AR,
              ES_ES, ES_MX, SW, SV, TA, TE, TH, TR, UK, UR, UZ, VI, ZU));

  private ContactLanguage(String value) {
    super(value);
  }

  public static Stream<ContactLanguage> values() {
    return ENUM_SUPPORT.values();
  }

  public static ContactLanguage from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ContactLanguage e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
