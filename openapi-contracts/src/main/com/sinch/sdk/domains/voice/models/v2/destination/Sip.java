package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.List;

@JsonDeserialize(builder = SipImpl.Builder.class)
public interface Sip extends CallDestination {

  /** Gets or Sets transport */
  public class TransportEnum extends EnumDynamic<String, TransportEnum> {
    public static final TransportEnum UDP = new TransportEnum("UDP");

    public static final TransportEnum TCP = new TransportEnum("TCP");

    public static final TransportEnum TLS = new TransportEnum("TLS");

    private static final EnumSupportDynamic<String, TransportEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            TransportEnum.class, TransportEnum::new, Arrays.asList(UDP, TCP, TLS));

    private TransportEnum(String value) {
      super(value);
    }

    public static java.util.stream.Stream<TransportEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TransportEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TransportEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * SIP URI of the destination endpoint. Both <code>sip:</code> (unencrypted) and <code>sips:
   * </code> (TLS-encrypted) schemes are supported.
   *
   * <p>Field is required
   *
   * @return endpoint
   */
  String getEndpoint();

  /**
   * Transport protocol to use for the SIP signalling channel.
   *
   * <p>If omitted, the platform selects a default based on the URI scheme: <code>UDP</code> for
   * <code>sip:</code> and <code>TLS</code> for <code>sips:</code>. Setting this explicitly
   * overrides that default — for example, to force <code>TCP</code> for a <code>sip:</code> URI or
   * to use <code>TLS</code> without switching to the <code>sips:</code> scheme.
   *
   * @return transport
   */
  TransportEnum getTransport();

  /**
   * Custom SIP headers to be sent in the call setup.
   *
   * @return callHeaders
   */
  List<SipCallHeader> getCallHeaders();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SipImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param endpoint see getter
     * @return Current builder
     * @see #getEndpoint
     */
    Builder setEndpoint(String endpoint);

    /**
     * see getter
     *
     * @param transport see getter
     * @return Current builder
     * @see #getTransport
     */
    Builder setTransport(TransportEnum transport);

    /**
     * see getter
     *
     * @param callHeaders see getter
     * @return Current builder
     * @see #getCallHeaders
     */
    Builder setCallHeaders(List<SipCallHeader> callHeaders);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Sip build();
  }
}
