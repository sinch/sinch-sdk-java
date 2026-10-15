package com.sinch.sdk.domains.voice.models.v2;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The type of channel used for the call.
 *
 * <p>This value indicates what kind of endpoint the call is connected to (PSTN phone number or
 * WebSocket stream).
 */
public class CallType extends EnumDynamic<String, CallType> {

  /** A call from or to the telephone network. */
  public static final CallType PHONE = new CallType("PHONE");

  /** A call from or to a SIP endpoint. */
  public static final CallType SIP = new CallType("SIP");

  /** A call to a stream. */
  public static final CallType STREAM = new CallType("STREAM");

  /** A call to voice relay service. */
  public static final CallType VOICE_RELAY = new CallType("VOICE_RELAY");

  private static final EnumSupportDynamic<String, CallType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CallType.class, CallType::new, Arrays.asList(PHONE, SIP, STREAM, VOICE_RELAY));

  private CallType(String value) {
    super(value);
  }

  public static Stream<CallType> values() {
    return ENUM_SUPPORT.values();
  }

  public static CallType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CallType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
