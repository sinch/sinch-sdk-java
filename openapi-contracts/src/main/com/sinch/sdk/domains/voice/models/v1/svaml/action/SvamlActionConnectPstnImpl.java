package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  SvamlActionConnectPstnImpl.JSON_PROPERTY_NAME,
  SvamlActionConnectPstnImpl.JSON_PROPERTY_NUMBER,
  SvamlActionConnectPstnImpl.JSON_PROPERTY_LOCALE,
  SvamlActionConnectPstnImpl.JSON_PROPERTY_MAX_DURATION,
  SvamlActionConnectPstnImpl.JSON_PROPERTY_DIAL_TIMEOUT,
  SvamlActionConnectPstnImpl.JSON_PROPERTY_CLI,
  SvamlActionConnectPstnImpl.JSON_PROPERTY_SUPPRESS_CALLBACKS,
  SvamlActionConnectPstnImpl.JSON_PROPERTY_DTMF,
  SvamlActionConnectPstnImpl.JSON_PROPERTY_INDICATIONS,
  SvamlActionConnectPstnImpl.JSON_PROPERTY_AMD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlActionConnectPstnImpl
    implements SvamlActionConnectPstn,
        com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_NUMBER = "number";

  private OptionalValue<String> number;

  public static final String JSON_PROPERTY_LOCALE = "locale";

  private OptionalValue<String> locale;

  public static final String JSON_PROPERTY_MAX_DURATION = "maxDuration";

  private OptionalValue<Integer> maxDuration;

  public static final String JSON_PROPERTY_DIAL_TIMEOUT = "dialTimeout";

  private OptionalValue<Integer> dialTimeout;

  public static final String JSON_PROPERTY_CLI = "cli";

  private OptionalValue<String> cli;

  public static final String JSON_PROPERTY_SUPPRESS_CALLBACKS = "suppressCallbacks";

  private OptionalValue<Boolean> suppressCallbacks;

  public static final String JSON_PROPERTY_DTMF = "dtmf";

  private OptionalValue<String> dtmf;

  public static final String JSON_PROPERTY_INDICATIONS = "indications";

  private OptionalValue<IndicationsEnum> indications;

  public static final String JSON_PROPERTY_AMD = "amd";

  private OptionalValue<ConnectPstnAnsweringMachineDetection> amd;

  public SvamlActionConnectPstnImpl() {}

  protected SvamlActionConnectPstnImpl(
      OptionalValue<NameEnum> name,
      OptionalValue<String> number,
      OptionalValue<String> locale,
      OptionalValue<Integer> maxDuration,
      OptionalValue<Integer> dialTimeout,
      OptionalValue<String> cli,
      OptionalValue<Boolean> suppressCallbacks,
      OptionalValue<String> dtmf,
      OptionalValue<IndicationsEnum> indications,
      OptionalValue<ConnectPstnAnsweringMachineDetection> amd) {
    this.name = name;
    this.number = number;
    this.locale = locale;
    this.maxDuration = maxDuration;
    this.dialTimeout = dialTimeout;
    this.cli = cli;
    this.suppressCallbacks = suppressCallbacks;
    this.dtmf = dtmf;
    this.indications = indications;
    this.amd = amd;
  }

  @JsonIgnore
  public NameEnum getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<NameEnum> name() {
    return name;
  }

  @JsonIgnore
  public String getNumber() {
    return number.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> number() {
    return number;
  }

  @JsonIgnore
  public String getLocale() {
    return locale.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> locale() {
    return locale;
  }

  @JsonIgnore
  public Integer getMaxDuration() {
    return maxDuration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAX_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> maxDuration() {
    return maxDuration;
  }

  @JsonIgnore
  public Integer getDialTimeout() {
    return dialTimeout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> dialTimeout() {
    return dialTimeout;
  }

  @JsonIgnore
  public String getCli() {
    return cli.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> cli() {
    return cli;
  }

  @JsonIgnore
  public Boolean getSuppressCallbacks() {
    return suppressCallbacks.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SUPPRESS_CALLBACKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> suppressCallbacks() {
    return suppressCallbacks;
  }

  @JsonIgnore
  public String getDtmf() {
    return dtmf.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DTMF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> dtmf() {
    return dtmf;
  }

  @JsonIgnore
  public IndicationsEnum getIndications() {
    return indications.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INDICATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<IndicationsEnum> indications() {
    return indications;
  }

  @JsonIgnore
  public ConnectPstnAnsweringMachineDetection getAmd() {
    return amd.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AMD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConnectPstnAnsweringMachineDetection> amd() {
    return amd;
  }

  /** Return true if this svaml.action.connectPstn object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlActionConnectPstnImpl svamlActionConnectPstn = (SvamlActionConnectPstnImpl) o;
    return Objects.equals(this.name, svamlActionConnectPstn.name)
        && Objects.equals(this.number, svamlActionConnectPstn.number)
        && Objects.equals(this.locale, svamlActionConnectPstn.locale)
        && Objects.equals(this.maxDuration, svamlActionConnectPstn.maxDuration)
        && Objects.equals(this.dialTimeout, svamlActionConnectPstn.dialTimeout)
        && Objects.equals(this.cli, svamlActionConnectPstn.cli)
        && Objects.equals(this.suppressCallbacks, svamlActionConnectPstn.suppressCallbacks)
        && Objects.equals(this.dtmf, svamlActionConnectPstn.dtmf)
        && Objects.equals(this.indications, svamlActionConnectPstn.indications)
        && Objects.equals(this.amd, svamlActionConnectPstn.amd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        name,
        number,
        locale,
        maxDuration,
        dialTimeout,
        cli,
        suppressCallbacks,
        dtmf,
        indications,
        amd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlActionConnectPstnImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    maxDuration: ").append(toIndentedString(maxDuration)).append("\n");
    sb.append("    dialTimeout: ").append(toIndentedString(dialTimeout)).append("\n");
    sb.append("    cli: ").append(toIndentedString(cli)).append("\n");
    sb.append("    suppressCallbacks: ").append(toIndentedString(suppressCallbacks)).append("\n");
    sb.append("    dtmf: ").append(toIndentedString(dtmf)).append("\n");
    sb.append("    indications: ").append(toIndentedString(indications)).append("\n");
    sb.append("    amd: ").append(toIndentedString(amd)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements SvamlActionConnectPstn.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.CONNECT_PSTN);
    OptionalValue<String> number = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();
    OptionalValue<Integer> maxDuration = OptionalValue.empty();
    OptionalValue<Integer> dialTimeout = OptionalValue.empty();
    OptionalValue<String> cli = OptionalValue.empty();
    OptionalValue<Boolean> suppressCallbacks = OptionalValue.empty();
    OptionalValue<String> dtmf = OptionalValue.empty();
    OptionalValue<IndicationsEnum> indications = OptionalValue.empty();
    OptionalValue<ConnectPstnAnsweringMachineDetection> amd = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_NUMBER)
    public Builder setNumber(String number) {
      this.number = OptionalValue.of(number);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LOCALE)
    public Builder setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAX_DURATION)
    public Builder setMaxDuration(Integer maxDuration) {
      this.maxDuration = OptionalValue.of(maxDuration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT)
    public Builder setDialTimeout(Integer dialTimeout) {
      this.dialTimeout = OptionalValue.of(dialTimeout);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CLI)
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SUPPRESS_CALLBACKS)
    public Builder setSuppressCallbacks(Boolean suppressCallbacks) {
      this.suppressCallbacks = OptionalValue.of(suppressCallbacks);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DTMF)
    public Builder setDtmf(String dtmf) {
      this.dtmf = OptionalValue.of(dtmf);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INDICATIONS)
    public Builder setIndications(IndicationsEnum indications) {
      this.indications = OptionalValue.of(indications);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_AMD)
    public Builder setAmd(ConnectPstnAnsweringMachineDetection amd) {
      this.amd = OptionalValue.of(amd);
      return this;
    }

    public SvamlActionConnectPstn build() {
      return new SvamlActionConnectPstnImpl(
          name,
          number,
          locale,
          maxDuration,
          dialTimeout,
          cli,
          suppressCallbacks,
          dtmf,
          indications,
          amd);
    }
  }
}
