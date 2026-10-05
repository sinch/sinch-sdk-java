package com.sinch.sdk.domains.voice.models.v2.destination.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.destination.Sip.TransportEnum;
import com.sinch.sdk.domains.voice.models.v2.destination.SipCallHeader;
import java.util.List;

@JsonDeserialize(builder = SipInternalImpl.Builder.class)
public interface SipInternal {

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
    return new SipInternalImpl.Builder();
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
    SipInternal build();
  }
}
