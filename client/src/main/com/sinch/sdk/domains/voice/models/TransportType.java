package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Transport Protocol type */
public class TransportType extends EnumDynamic<String, TransportType> {

  /** User Datagram Protocol */
  public static final TransportType UDP = new TransportType("UDP");

  /** Transmission Control Protocol */
  public static final TransportType TCP = new TransportType("TCP");

  /** Transport Layer Security */
  public static final TransportType TLS = new TransportType("TLS");

  /** */
  private static final EnumSupportDynamic<String, TransportType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          TransportType.class, TransportType::new, Arrays.asList(UDP, TCP, TLS));

  private TransportType(String value) {
    super(value);
  }

  public static Stream<TransportType> values() {
    return ENUM_SUPPORT.values();
  }

  public static TransportType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(TransportType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
