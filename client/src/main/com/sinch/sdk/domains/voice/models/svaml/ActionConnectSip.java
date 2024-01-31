package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.models.DestinationSip;
import com.sinch.sdk.domains.voice.models.MusicOnHoldType;
import com.sinch.sdk.domains.voice.models.TransportType;
import java.util.Collection;

public class ActionConnectSip extends Action {

  private final OptionalValue<DestinationSip> destination;
  private final OptionalValue<Integer> maxDuration;
  private final OptionalValue<String> cli;
  private final OptionalValue<TransportType> transport;
  private final OptionalValue<Boolean> suppressCallbacks;
  private final OptionalValue<Collection<Pair<String, String>>> callHeaders;
  private final OptionalValue<MusicOnHoldType> musicOnHold;

  private ActionConnectSip(
      OptionalValue<DestinationSip> destination,
      OptionalValue<Integer> maxDuration,
      OptionalValue<String> cli,
      OptionalValue<TransportType> transport,
      OptionalValue<Boolean> suppressCallbacks,
      OptionalValue<Collection<Pair<String, String>>> callHeaders,
      OptionalValue<MusicOnHoldType> musicOnHold) {
    this.destination = destination;
    this.maxDuration = maxDuration;
    this.cli = cli;
    this.transport = transport;
    this.suppressCallbacks = suppressCallbacks;
    this.callHeaders = callHeaders;
    this.musicOnHold = musicOnHold;
  }

  public OptionalValue<DestinationSip> getDestination() {
    return destination;
  }

  public OptionalValue<Integer> getMaxDuration() {
    return maxDuration;
  }

  public OptionalValue<String> getCli() {
    return cli;
  }

  public OptionalValue<TransportType> getTransport() {
    return transport;
  }

  public OptionalValue<Boolean> getSuppressCallbacks() {
    return suppressCallbacks;
  }

  public OptionalValue<Collection<Pair<String, String>>> getCallHeaders() {
    return callHeaders;
  }

  public OptionalValue<MusicOnHoldType> getMusicOnHold() {
    return musicOnHold;
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
        + ", callHeaders="
        + callHeaders
        + ", musicOnHold="
        + musicOnHold
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<DestinationSip> destination = OptionalValue.empty();
    OptionalValue<Integer> maxDuration = OptionalValue.empty();
    OptionalValue<String> cli = OptionalValue.empty();
    OptionalValue<TransportType> transport = OptionalValue.empty();
    OptionalValue<Boolean> suppressCallbacks = OptionalValue.empty();
    OptionalValue<Collection<Pair<String, String>>> callHeaders = OptionalValue.empty();
    OptionalValue<MusicOnHoldType> musicOnHold = OptionalValue.empty();

    public Builder<B> setDestination(DestinationSip destination) {
      this.destination = OptionalValue.of(destination);
      return this;
    }

    public Builder<B> setMaxDuration(Integer maxDuration) {
      this.maxDuration = OptionalValue.of(maxDuration);
      return this;
    }

    public Builder<B> setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    public Builder<B> setTransport(TransportType transport) {
      this.transport = OptionalValue.of(transport);
      return this;
    }

    public Builder<B> setSuppressCallbacks(Boolean suppressCallbacks) {
      this.suppressCallbacks = OptionalValue.of(suppressCallbacks);
      return this;
    }

    public Builder<B> setCallHeaders(Collection<Pair<String, String>> callHeaders) {
      this.callHeaders = OptionalValue.of(callHeaders);
      return this;
    }

    public Builder<B> setMusicOnHold(MusicOnHoldType musicOnHold) {
      this.musicOnHold = OptionalValue.of(musicOnHold);
      return this;
    }

    public ActionConnectSip build() {
      return new ActionConnectSip(
          destination, maxDuration, cli, transport, suppressCallbacks, callHeaders, musicOnHold);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
