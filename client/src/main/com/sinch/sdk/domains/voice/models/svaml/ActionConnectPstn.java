package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;

public class ActionConnectPstn extends Action {

  private final OptionalValue<E164PhoneNumber> number;
  private final OptionalValue<String> locale;
  private final OptionalValue<Integer> maxDuration;
  private final OptionalValue<Integer> dialTimeout;
  private final OptionalValue<String> cli;
  private final OptionalValue<Boolean> suppressCallbacks;
  private final OptionalValue<DualToneMultiFrequency> dtmf;
  private final OptionalValue<IndicationType> indications;
  private final OptionalValue<AnsweringMachineDetection> answeringMachineDetectionEnabled;

  private ActionConnectPstn(
      OptionalValue<E164PhoneNumber> number,
      OptionalValue<String> locale,
      OptionalValue<Integer> maxDuration,
      OptionalValue<Integer> dialTimeout,
      OptionalValue<String> cli,
      OptionalValue<Boolean> suppressCallbacks,
      OptionalValue<DualToneMultiFrequency> dtmf,
      OptionalValue<IndicationType> indications,
      OptionalValue<AnsweringMachineDetection> answeringMachineDetectionEnabled) {
    this.number = number;
    this.locale = locale;
    this.maxDuration = maxDuration;
    this.dialTimeout = dialTimeout;
    this.cli = cli;
    this.suppressCallbacks = suppressCallbacks;
    this.dtmf = dtmf;
    this.indications = indications;
    this.answeringMachineDetectionEnabled = answeringMachineDetectionEnabled;
  }

  public OptionalValue<E164PhoneNumber> getNumber() {
    return number;
  }

  public OptionalValue<String> getLocale() {
    return locale;
  }

  public OptionalValue<Integer> getMaxDuration() {
    return maxDuration;
  }

  public OptionalValue<Integer> getDialTimeout() {
    return dialTimeout;
  }

  public OptionalValue<String> getCli() {
    return cli;
  }

  public OptionalValue<Boolean> getSuppressCallbacks() {
    return suppressCallbacks;
  }

  public OptionalValue<DualToneMultiFrequency> getDtmf() {
    return dtmf;
  }

  public OptionalValue<IndicationType> getIndications() {
    return indications;
  }

  public OptionalValue<AnsweringMachineDetection> getAnsweringMachineDetectionEnabled() {
    return answeringMachineDetectionEnabled;
  }

  @Override
  public String toString() {
    return "ActionConnectPstn{"
        + "number="
        + number
        + ", locale='"
        + locale
        + '\''
        + ", maxDuration="
        + maxDuration
        + ", dialTimeout="
        + dialTimeout
        + ", cli='"
        + cli
        + '\''
        + ", suppressCallbacks="
        + suppressCallbacks
        + ", dtmf="
        + dtmf
        + ", indications="
        + indications
        + ", answeringMachineDetectionEnabled="
        + answeringMachineDetectionEnabled
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<E164PhoneNumber> number = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();
    OptionalValue<Integer> maxDuration = OptionalValue.empty();
    OptionalValue<Integer> dialTimeout = OptionalValue.empty();
    OptionalValue<String> cli = OptionalValue.empty();
    OptionalValue<Boolean> suppressCallbacks = OptionalValue.empty();
    OptionalValue<DualToneMultiFrequency> dtmf = OptionalValue.empty();
    OptionalValue<IndicationType> indications = OptionalValue.empty();
    OptionalValue<AnsweringMachineDetection> answeringMachineDetectionEnabled =
        OptionalValue.empty();

    public Builder<B> setNumber(E164PhoneNumber number) {
      this.number = OptionalValue.of(number);
      return this;
    }

    public Builder<B> setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    public Builder<B> setMaxDuration(Integer duration) {
      this.maxDuration = OptionalValue.of(duration);
      return this;
    }

    public Builder<B> setDialTimeout(Integer dialTimeout) {
      this.dialTimeout = OptionalValue.of(dialTimeout);
      return this;
    }

    public Builder<B> setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    public Builder<B> setSuppressCallbacks(Boolean suppressCallbacks) {
      this.suppressCallbacks = OptionalValue.of(suppressCallbacks);
      return this;
    }

    public Builder<B> setDtmf(DualToneMultiFrequency dtmf) {
      this.dtmf = OptionalValue.of(dtmf);
      return this;
    }

    public Builder<B> setIndications(IndicationType indications) {
      this.indications = OptionalValue.of(indications);
      return this;
    }

    public Builder<B> setAnsweringMachineDetectionEnabled(
        AnsweringMachineDetection answeringMachineDetectionEnabled) {
      this.answeringMachineDetectionEnabled = OptionalValue.of(answeringMachineDetectionEnabled);
      return this;
    }

    public ActionConnectPstn build() {
      return new ActionConnectPstn(
          number,
          locale,
          maxDuration,
          dialTimeout,
          cli,
          suppressCallbacks,
          dtmf,
          indications,
          answeringMachineDetectionEnabled);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
