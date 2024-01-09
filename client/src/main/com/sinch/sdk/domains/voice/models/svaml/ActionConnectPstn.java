package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;

public class ActionConnectPstn extends Action {

  private final E164PhoneNumber number;
  private final String locale;
  private final Integer maxDuration;
  private final Integer dialTimeout;
  private final String cli;
  private final Boolean suppressCallbacks;
  private final DualToneMultiFrequency dtmf;
  private final IndicationType indications;
  private final AnsweringMachineDetection answeringMachineDetectionEnabled;

  private ActionConnectPstn(
      E164PhoneNumber number,
      String locale,
      Integer maxDuration,
      Integer dialTimeout,
      String cli,
      Boolean suppressCallbacks,
      DualToneMultiFrequency dtmf,
      IndicationType indications,
      AnsweringMachineDetection answeringMachineDetectionEnabled) {
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

  public E164PhoneNumber getNumber() {
    return number;
  }

  public String getLocale() {
    return locale;
  }

  public Integer getMaxDuration() {
    return maxDuration;
  }

  public Integer getDialTimeout() {
    return dialTimeout;
  }

  public String getCli() {
    return cli;
  }

  public Boolean getSuppressCallbacks() {
    return suppressCallbacks;
  }

  public DualToneMultiFrequency getDtmf() {
    return dtmf;
  }

  public IndicationType getIndications() {
    return indications;
  }

  public AnsweringMachineDetection getAnsweringMachineDetectionEnabled() {
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

    E164PhoneNumber number;
    String locale;
    Integer maxDuration;
    Integer dialTimeout;
    String cli;
    Boolean suppressCallbacks;
    DualToneMultiFrequency dtmf;
    IndicationType indications;
    AnsweringMachineDetection answeringMachineDetectionEnabled;

    public Builder<B> setNumber(E164PhoneNumber number) {
      this.number = number;
      return this;
    }

    public Builder<B> setLocale(String locale) {
      this.locale = locale;
      return this;
    }

    public Builder<B> setMaxDuration(Integer duration) {
      this.maxDuration = duration;
      return this;
    }

    public Builder<B> setDialTimeout(Integer dialTimeout) {
      this.dialTimeout = dialTimeout;
      return this;
    }

    public Builder<B> setCli(String cli) {
      this.cli = cli;
      return this;
    }

    public Builder<B> setSuppressCallbacks(Boolean suppressCallbacks) {
      this.suppressCallbacks = suppressCallbacks;
      return this;
    }

    public Builder<B> setDtmf(DualToneMultiFrequency dtmf) {
      this.dtmf = dtmf;
      return this;
    }

    public Builder<B> setIndications(IndicationType indications) {
      this.indications = indications;
      return this;
    }

    public Builder<B> setAnsweringMachineDetectionEnabled(
        AnsweringMachineDetection answeringMachineDetectionEnabled) {
      this.answeringMachineDetectionEnabled = answeringMachineDetectionEnabled;
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
