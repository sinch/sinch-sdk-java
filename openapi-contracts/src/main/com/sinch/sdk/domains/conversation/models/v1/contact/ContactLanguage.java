package com.sinch.sdk.domains.conversation.models.v1.contact;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets ContactLanguage */
public class ContactLanguage extends EnumDynamic<String, ContactLanguage> {

  public static final ContactLanguage AF = new ContactLanguage("AF");

  public static final ContactLanguage SQ = new ContactLanguage("SQ");

  public static final ContactLanguage AR = new ContactLanguage("AR");

  public static final ContactLanguage AZ = new ContactLanguage("AZ");

  public static final ContactLanguage BN = new ContactLanguage("BN");

  public static final ContactLanguage BG = new ContactLanguage("BG");

  public static final ContactLanguage CA = new ContactLanguage("CA");

  public static final ContactLanguage ZH = new ContactLanguage("ZH");

  public static final ContactLanguage ZH_CN = new ContactLanguage("ZH_CN");

  public static final ContactLanguage ZH_HK = new ContactLanguage("ZH_HK");

  public static final ContactLanguage ZH_TW = new ContactLanguage("ZH_TW");

  public static final ContactLanguage HR = new ContactLanguage("HR");

  public static final ContactLanguage CS = new ContactLanguage("CS");

  public static final ContactLanguage DA = new ContactLanguage("DA");

  public static final ContactLanguage NL = new ContactLanguage("NL");

  public static final ContactLanguage EN = new ContactLanguage("EN");

  public static final ContactLanguage EN_GB = new ContactLanguage("EN_GB");

  public static final ContactLanguage EN_US = new ContactLanguage("EN_US");

  public static final ContactLanguage ET = new ContactLanguage("ET");

  public static final ContactLanguage FIL = new ContactLanguage("FIL");

  public static final ContactLanguage FI = new ContactLanguage("FI");

  public static final ContactLanguage FR = new ContactLanguage("FR");

  public static final ContactLanguage DE = new ContactLanguage("DE");

  public static final ContactLanguage EL = new ContactLanguage("EL");

  public static final ContactLanguage GU = new ContactLanguage("GU");

  public static final ContactLanguage HA = new ContactLanguage("HA");

  public static final ContactLanguage HE = new ContactLanguage("HE");

  public static final ContactLanguage HI = new ContactLanguage("HI");

  public static final ContactLanguage HU = new ContactLanguage("HU");

  public static final ContactLanguage ID = new ContactLanguage("ID");

  public static final ContactLanguage GA = new ContactLanguage("GA");

  public static final ContactLanguage IT = new ContactLanguage("IT");

  public static final ContactLanguage JA = new ContactLanguage("JA");

  public static final ContactLanguage KN = new ContactLanguage("KN");

  public static final ContactLanguage KK = new ContactLanguage("KK");

  public static final ContactLanguage KO = new ContactLanguage("KO");

  public static final ContactLanguage LO = new ContactLanguage("LO");

  public static final ContactLanguage LV = new ContactLanguage("LV");

  public static final ContactLanguage LT = new ContactLanguage("LT");

  public static final ContactLanguage MK = new ContactLanguage("MK");

  public static final ContactLanguage MS = new ContactLanguage("MS");

  public static final ContactLanguage ML = new ContactLanguage("ML");

  public static final ContactLanguage MR = new ContactLanguage("MR");

  public static final ContactLanguage NB = new ContactLanguage("NB");

  public static final ContactLanguage FA = new ContactLanguage("FA");

  public static final ContactLanguage PL = new ContactLanguage("PL");

  public static final ContactLanguage PT = new ContactLanguage("PT");

  public static final ContactLanguage PT_BR = new ContactLanguage("PT_BR");

  public static final ContactLanguage PT_PT = new ContactLanguage("PT_PT");

  public static final ContactLanguage PA = new ContactLanguage("PA");

  public static final ContactLanguage RO = new ContactLanguage("RO");

  public static final ContactLanguage RU = new ContactLanguage("RU");

  public static final ContactLanguage SR = new ContactLanguage("SR");

  public static final ContactLanguage SK = new ContactLanguage("SK");

  public static final ContactLanguage SL = new ContactLanguage("SL");

  public static final ContactLanguage ES = new ContactLanguage("ES");

  public static final ContactLanguage ES_AR = new ContactLanguage("ES_AR");

  public static final ContactLanguage ES_ES = new ContactLanguage("ES_ES");

  public static final ContactLanguage ES_MX = new ContactLanguage("ES_MX");

  public static final ContactLanguage SW = new ContactLanguage("SW");

  public static final ContactLanguage SV = new ContactLanguage("SV");

  public static final ContactLanguage TA = new ContactLanguage("TA");

  public static final ContactLanguage TE = new ContactLanguage("TE");

  public static final ContactLanguage TH = new ContactLanguage("TH");

  public static final ContactLanguage TR = new ContactLanguage("TR");

  public static final ContactLanguage UK = new ContactLanguage("UK");

  public static final ContactLanguage UR = new ContactLanguage("UR");

  public static final ContactLanguage UZ = new ContactLanguage("UZ");

  public static final ContactLanguage VI = new ContactLanguage("VI");

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
