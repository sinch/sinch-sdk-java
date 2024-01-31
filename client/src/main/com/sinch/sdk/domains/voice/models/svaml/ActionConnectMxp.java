package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.models.Destination;
import java.util.Collection;

public class ActionConnectMxp extends Action {

  private final OptionalValue<Destination> destination;
  private final OptionalValue<Collection<Pair<String, String>>> callheaders;

  private ActionConnectMxp(
      OptionalValue<Destination> destination,
      OptionalValue<Collection<Pair<String, String>>> callheaders) {
    this.destination = destination;
    this.callheaders = callheaders;
  }

  public OptionalValue<Destination> getDestination() {
    return destination;
  }

  public OptionalValue<Collection<Pair<String, String>>> getCallheaders() {
    return callheaders;
  }

  @Override
  public String toString() {
    return "ActionConnectMxp{"
        + "destination="
        + destination
        + ", callheaders="
        + callheaders
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<Destination> destination = OptionalValue.empty();
    OptionalValue<Collection<Pair<String, String>>> callheaders = OptionalValue.empty();

    public Builder<B> setDestination(Destination destination) {
      this.destination = OptionalValue.of(destination);
      return this;
    }

    public Builder<B> setCallheaders(Collection<Pair<String, String>> callheaders) {
      this.callheaders = OptionalValue.of(callheaders);
      return this;
    }

    public ActionConnectMxp build() {
      return new ActionConnectMxp(destination, callheaders);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
