package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.domains.verification.models.requests.VerificationReportRequestParameters.Builder;
import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Objects;
import java.util.Optional;

public class CalloutRequestParameters {
  private final CalloutMethodType method;
  private final Destination destination;
  private final E164PhoneNumber cli;
  private final String dtfm;
  private final String custom;

  public CalloutRequestParameters(
      CalloutMethodType method,
      Destination destination,
      E164PhoneNumber cli,
      String dtfm,
      String custom) {

    Objects.requireNonNull(method, "method is required");
    Objects.requireNonNull(destination, "destination  is required");

    this.method = method;
    this.destination = destination;
    this.cli = cli;
    this.dtfm = dtfm;
    this.custom = custom;
  }

  /**
   * @return the type of callout.
   */
  public CalloutMethodType getMethod() {
    return method;
  }

  /**
   * @return The type of device and number or endpoint to call
   */
  public Destination getDestination() {
    return destination;
  }

  /**
   * @return The number that will be displayed as the incoming caller. To set your own CLI, you may
   *     use your verified number or your Dashboard number
   */
  public Optional<E164PhoneNumber> getCli() {
    return Optional.ofNullable(cli);
  }

  /**
   * @return When the destination picks up, this DTMF tones will be played to the callee. Valid
   *     characters in the string are "0"-"9", "#" and "w". A "w" will render a 500 ms pause.
   *     Example: "ww1234#w#" will render a 1s pause, the DTMF tones "1", "2", "3", "4" and "#"
   *     followed by a 0.5s pause and finally the DTMF tone for "#". This can be used if the callout
   *     destination for instance require a conference PIN code or an extension to be entered.
   */
  public Optional<String> getDtfm() {
    return Optional.ofNullable(dtfm);
  }

  /**
   * @return Custom data
   */
  public Optional<String> getCustom() {
    return Optional.ofNullable(custom);
  }

  @Override
  public String toString() {
    return "CalloutRequestParameters{" + "method=" + method + '}';
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    Destination destination;
    E164PhoneNumber cli;
    String dtfm;
    String custom;

    public Builder() {}

    public B setDestination(Destination destination) {
      this.destination = destination;
      return self();
    }

    public B setCli(E164PhoneNumber cli) {
      this.cli = cli;
      return self();
    }

    public B setDtfm(String dtfm) {
      this.dtfm = dtfm;
      return self();
    }

    public B setCustom(String custom) {
      this.custom = custom;
      return self();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
