package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.models.DestinationSip;
import com.sinch.sdk.domains.voice.models.MohClassType;
import com.sinch.sdk.domains.voice.models.TransportType;
import java.util.Collection;

public class ActionConnectSip extends Action {

  private final DestinationSip destination;
  private final Integer maxDuration;
  private final String cli;
  private final TransportType transport;
  private final Boolean suppressCallbacks;
  private final Collection<Pair<String, String>> callheaders;
  private final MohClassType moh;

  private ActionConnectSip(
      DestinationSip destination,
      Integer maxDuration,
      String cli,
      TransportType transport,
      Boolean suppressCallbacks,
      Collection<Pair<String, String>> callheaders,
      MohClassType moh) {
    this.destination = destination;
    this.maxDuration = maxDuration;
    this.cli = cli;
    this.transport = transport;
    this.suppressCallbacks = suppressCallbacks;
    this.callheaders = callheaders;
    this.moh = moh;
  }

  public DestinationSip getDestination() {
    return destination;
  }

  public Integer getMaxDuration() {
    return maxDuration;
  }

  public String getCli() {
    return cli;
  }

  public TransportType getTransport() {
    return transport;
  }

  public Boolean getSuppressCallbacks() {
    return suppressCallbacks;
  }

  public Collection<Pair<String, String>> getCallheaders() {
    return callheaders;
  }

  public MohClassType getMoh() {
    return moh;
  }

  @Override
  public String toString() {
    return "ActionConnectSip{"
        + "destination="
        + destination
        + ", maxDuration="
        + maxDuration
        + ", cli='"
        + cli
        + '\''
        + ", transport="
        + transport
        + ", suppressCallbacks="
        + suppressCallbacks
        + ", callheaders="
        + callheaders
        + ", moh="
        + moh
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    DestinationSip destination;
    Integer maxDuration;
    String cli;
    TransportType transport;
    Boolean suppressCallbacks;
    Collection<Pair<String, String>> callheaders;
    MohClassType moh;

    public Builder<B> setDestination(DestinationSip destination) {
      this.destination = destination;
      return this;
    }

    public Builder<B> setMaxDuration(Integer maxDuration) {
      this.maxDuration = maxDuration;
      return this;
    }

    public Builder<B> setCli(String cli) {
      this.cli = cli;
      return this;
    }

    public Builder<B> setTransport(TransportType transport) {
      this.transport = transport;
      return this;
    }

    public Builder<B> setSuppressCallbacks(Boolean suppressCallbacks) {
      this.suppressCallbacks = suppressCallbacks;
      return this;
    }

    public Builder<B> setCallheaders(Collection<Pair<String, String>> callheaders) {
      this.callheaders = callheaders;
      return this;
    }

    public Builder<B> setMoh(MohClassType moh) {
      this.moh = moh;
      return this;
    }

    public ActionConnectSip build() {
      return new ActionConnectSip(
          destination, maxDuration, cli, transport, suppressCallbacks, callheaders, moh);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
