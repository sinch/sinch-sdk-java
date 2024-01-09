package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Domains type */
public class IndicationType extends EnumDynamic<String, IndicationType> {

  public static final IndicationType AUSTRIA = new IndicationType("at");
  public static final IndicationType AUSTRALIA = new IndicationType("au");
  public static final IndicationType BULGARIA = new IndicationType("bg");
  public static final IndicationType BRAZIL = new IndicationType("br");
  public static final IndicationType BELGIUM = new IndicationType("be");
  public static final IndicationType SWITZERLAND = new IndicationType("ch");
  public static final IndicationType CHILE = new IndicationType("cl");
  public static final IndicationType CHINA = new IndicationType("cn");
  public static final IndicationType CZECH_REPUBLIC = new IndicationType("cz");
  public static final IndicationType GERMANY = new IndicationType("de");
  public static final IndicationType DENMARK = new IndicationType("dk");
  public static final IndicationType ESTONIA = new IndicationType("ee");
  public static final IndicationType SPAIN = new IndicationType("es");
  public static final IndicationType FINLAND = new IndicationType("fi");
  public static final IndicationType FRANCE = new IndicationType("fr");
  public static final IndicationType GREECE = new IndicationType("gr");
  public static final IndicationType HUNGARY = new IndicationType("hu");
  public static final IndicationType ISRAEL = new IndicationType("il");
  public static final IndicationType INDIA = new IndicationType("in");
  public static final IndicationType ITALY = new IndicationType("it");
  public static final IndicationType LITHUANIA = new IndicationType("lt");
  public static final IndicationType JAPAN = new IndicationType("jp");
  public static final IndicationType MEXICO = new IndicationType("mx");
  public static final IndicationType MALAYSIA = new IndicationType("my");
  public static final IndicationType NETHERLANDS = new IndicationType("nl");
  public static final IndicationType NORWAY = new IndicationType("no");
  public static final IndicationType NEW_ZEALAND = new IndicationType("nz");
  public static final IndicationType PHILIPPINES = new IndicationType("ph");
  public static final IndicationType POLAND = new IndicationType("pl");
  public static final IndicationType PORTUGAL = new IndicationType("pt");
  public static final IndicationType RUSSIA = new IndicationType("ru");
  public static final IndicationType SWEDEN = new IndicationType("se");
  public static final IndicationType SINGAPORE = new IndicationType("sg");
  public static final IndicationType THAILAND = new IndicationType("th");
  public static final IndicationType UNITED_KINGDOM = new IndicationType("uk");
  public static final IndicationType UNITED_STATES = new IndicationType("us");
  public static final IndicationType TAIWAN = new IndicationType("tw");
  public static final IndicationType VENEZUELA = new IndicationType("ve");
  public static final IndicationType SOUTH_AFRICA = new IndicationType("za");

  /** */
  private static final EnumSupportDynamic<String, IndicationType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          IndicationType.class,
          IndicationType::new,
          Arrays.asList(
              AUSTRIA,
              AUSTRALIA,
              BULGARIA,
              BRAZIL,
              BELGIUM,
              SWITZERLAND,
              CHILE,
              CHINA,
              CZECH_REPUBLIC,
              GERMANY,
              DENMARK,
              ESTONIA,
              SPAIN,
              FINLAND,
              FRANCE,
              GREECE,
              HUNGARY,
              ISRAEL,
              INDIA,
              ITALY,
              LITHUANIA,
              JAPAN,
              MEXICO,
              MALAYSIA,
              NETHERLANDS,
              NORWAY,
              NEW_ZEALAND,
              PHILIPPINES,
              POLAND,
              PORTUGAL,
              RUSSIA,
              SWEDEN,
              SINGAPORE,
              THAILAND,
              UNITED_KINGDOM,
              UNITED_STATES,
              TAIWAN,
              VENEZUELA,
              SOUTH_AFRICA));

  private IndicationType(String value) {
    super(value);
  }

  public static Stream<IndicationType> values() {
    return ENUM_SUPPORT.values();
  }

  public static IndicationType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(IndicationType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
