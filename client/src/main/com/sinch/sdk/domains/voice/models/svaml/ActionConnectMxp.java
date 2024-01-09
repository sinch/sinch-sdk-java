package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.models.Destination;
import java.util.Collection;

public class ActionConnectMxp extends Action {

  private final Destination destination;
  private final Collection<Pair<String, String>> callheaders;

  private ActionConnectMxp(Destination destination, Collection<Pair<String, String>> callheaders) {
    this.destination = destination;
    this.callheaders = callheaders;
  }

  public Destination getDestination() {
    return destination;
  }

  public Collection<Pair<String, String>> getCallheaders() {
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

    Destination destination;
    Collection<Pair<String, String>> callheaders;

    public Builder<B> setDestination(Destination destination) {
      this.destination = destination;
      return this;
    }

    public Builder<B> setCallheaders(Collection<Pair<String, String>> callheaders) {
      this.callheaders = callheaders;
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
