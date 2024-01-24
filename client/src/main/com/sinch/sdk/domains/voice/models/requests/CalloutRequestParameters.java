package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;

public class CalloutRequestParameters {
  private final OptionalValue<Destination> destination;
  private final OptionalValue<E164PhoneNumber> cli;
  private final OptionalValue<DualToneMultiFrequency> dtfm;
  private final OptionalValue<String> custom;

  protected CalloutRequestParameters(
      OptionalValue<Destination> destination,
      OptionalValue<E164PhoneNumber> cli,
      OptionalValue<DualToneMultiFrequency> dtfm,
      OptionalValue<String> custom) {

    this.destination = destination;
    this.cli = cli;
    this.dtfm = dtfm;
    this.custom = custom;
  }

  /**
   * Destination getter
   *
   * @see Builder#setDestination(Destination)
   */
  public OptionalValue<Destination> getDestination() {
    return destination;
  }

  /**
   * Cli getter
   *
   * @see Builder#setCli(E164PhoneNumber)
   */
  public OptionalValue<E164PhoneNumber> getCli() {
    return cli;
  }

  /**
   * Dual Tone Multi Frequency getter
   *
   * @see Builder#setDtfm(DualToneMultiFrequency)
   */
  public OptionalValue<DualToneMultiFrequency> getDtfm() {
    return dtfm;
  }

  /**
   * Custom value getter
   *
   * @see Builder#setCustom(String)
   */
  public OptionalValue<String> getCustom() {
    return custom;
  }

  @Override
  public String toString() {
    return "";
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<Destination> destination = OptionalValue.empty();
    OptionalValue<E164PhoneNumber> cli = OptionalValue.empty();
    OptionalValue<DualToneMultiFrequency> dtfm = OptionalValue.empty();
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
     * @return current builder
     */
    public B setDtfm(DualToneMultiFrequency dtfm) {
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
