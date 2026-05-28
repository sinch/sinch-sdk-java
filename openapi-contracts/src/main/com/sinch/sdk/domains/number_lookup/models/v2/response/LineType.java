package com.sinch.sdk.domains.number_lookup.models.v2.response;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Represents the type of a phone line. */
public class LineType extends EnumDynamic<String, LineType> {

  /** A landline phone number. */
  public static final LineType LANDLINE = new LineType("Landline");

  /** A mobile network phone number. */
  public static final LineType MOBILE = new LineType("Mobile");

  /** A Voice over IP phone number. */
  public static final LineType VO_IP = new LineType("VoIP");

  /** A specialty type of number, such as a satellite phone or fax line. */
  public static final LineType SPECIAL = new LineType("Special");

  /** A freephone type phone number. */
  public static final LineType FREEPHONE = new LineType("Freephone");

  /** Another type. */
  public static final LineType OTHER = new LineType("Other");

  private static final EnumSupportDynamic<String, LineType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          LineType.class,
          LineType::new,
          Arrays.asList(LANDLINE, MOBILE, VO_IP, SPECIAL, FREEPHONE, OTHER));

  private LineType(String value) {
    super(value);
  }

  public static Stream<LineType> values() {
    return ENUM_SUPPORT.values();
  }

  public static LineType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(LineType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
