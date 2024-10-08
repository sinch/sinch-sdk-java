package com.sinch.sdk.domains.voice.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Can be of type <code>number</code> for PSTN endpoints or of type <code>username</code> for data
 * endpoints.
 */
public class DestinationType extends EnumDynamic<String, DestinationType> {

  /** A e.164 formatted number for PSTN endpoints. */
  public static final DestinationType NUMBER = new DestinationType("number");

  /** A e.164 formatted number for PSTN endpoints. */
  public static final DestinationType NUMBER2 = new DestinationType("Number");

  /** A username for data endpoints. */
  public static final DestinationType USERNAME = new DestinationType("username");

  /** A username for data endpoints. */
  public static final DestinationType USERNAME2 = new DestinationType("Username");

  /** A SIP address for SIP infrastructures. */
  public static final DestinationType SIP = new DestinationType("sip");

  /** A <a href="https://community.sinch.com/t5/Glossary/DID/ta-p/7530">DID</a> service. */
  public static final DestinationType DID = new DestinationType("did");

  private static final EnumSupportDynamic<String, DestinationType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DestinationType.class,
          DestinationType::new,
          Arrays.asList(NUMBER, NUMBER2, USERNAME, USERNAME2, SIP, DID));

  private DestinationType(String value) {
    super(value);
  }

  public static Stream<DestinationType> values() {
    return ENUM_SUPPORT.values();
  }

  public static DestinationType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DestinationType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
