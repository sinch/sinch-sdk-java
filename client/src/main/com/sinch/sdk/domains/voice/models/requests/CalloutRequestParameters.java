package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.models.E164PhoneNumber;

public class CalloutRequestParameters {
  private final OptionalValue<CalloutMethodType> method;
  private final OptionalValue<Destination> destination;
  private final OptionalValue<E164PhoneNumber> cli;
  private final OptionalValue<String> dtfm;
  private final OptionalValue<String> custom;

  protected CalloutRequestParameters(
      OptionalValue<CalloutMethodType> method,
      OptionalValue<Destination> destination,
      OptionalValue<E164PhoneNumber> cli,
      OptionalValue<String> dtfm,
      OptionalValue<String> custom) {

    this.method = method;
    this.destination = destination;
    this.cli = cli;
    this.dtfm = dtfm;
    this.custom = custom;
  }

  public OptionalValue<CalloutMethodType> getMethod() {
    return method;
  }

  public OptionalValue<Destination> getDestination() {
    return destination;
  }

  public OptionalValue<E164PhoneNumber> getCli() {
    return cli;
  }

  public OptionalValue<String> getDtfm() {
    return dtfm;
  }

  public OptionalValue<String> getCustom() {
    return custom;
  }

  @Override
  public String toString() {
    return "CalloutRequestParameters{" + "method=" + method + '}';
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<Destination> destination = OptionalValue.empty();
    OptionalValue<E164PhoneNumber> cli = OptionalValue.empty();
    OptionalValue<String> dtfm = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();

    public Builder() {}

    /**
     * @param destination The type of device and number or endpoint to call
     * @return current builder
     */
    public B setDestination(Destination destination) {
      this.destination = OptionalValue.of(destination);
      return self();
    }

    /**
     * @param cli The number that will be displayed as the incoming caller. To set your own CLI, you
     *     may use your verified number or your Dashboard number
     * @return current builder
     */
    public B setCli(E164PhoneNumber cli) {
      this.cli = OptionalValue.of(cli);
      return self();
    }

    /**
     * @param dtfm When the destination picks up, this DTMF tones will be played to the callee.
     *     Valid characters in the string are "0"-"9", "#" and "w". A "w" will render a 500 ms
     *     pause. Example: "ww1234#w#" will render a 1s pause, the DTMF tones "1", "2", "3", "4" and
     *     "#" followed by a 0.5s pause and finally the DTMF tone for "#". This can be used if the
     *     callout destination for instance require a conference PIN code or an extension to be
     *     entered.
     * @return current builder
     */
    public B setDtfm(String dtfm) {
      this.dtfm = OptionalValue.of(dtfm);
      return self();
    }

    /**
     * @param custom Custom data
     * @return current builder
     */
    public B setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return self();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
