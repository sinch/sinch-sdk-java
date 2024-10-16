package com.sinch.sdk.domains.voice.models.v1.callouts.request.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.Domain;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationTextToSpeech;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.util.Objects;

@JsonPropertyOrder({
  TtsCalloutInternalImpl.JSON_PROPERTY_CLI,
  TtsCalloutInternalImpl.JSON_PROPERTY_DESTINATION,
  TtsCalloutInternalImpl.JSON_PROPERTY_DTMF,
  TtsCalloutInternalImpl.JSON_PROPERTY_DOMAIN,
  TtsCalloutInternalImpl.JSON_PROPERTY_CUSTOM,
  TtsCalloutInternalImpl.JSON_PROPERTY_LOCALE,
  TtsCalloutInternalImpl.JSON_PROPERTY_TEXT,
  TtsCalloutInternalImpl.JSON_PROPERTY_PROMPTS,
  TtsCalloutInternalImpl.JSON_PROPERTY_ENABLE_ACE,
  TtsCalloutInternalImpl.JSON_PROPERTY_ENABLE_DICE,
  TtsCalloutInternalImpl.JSON_PROPERTY_ENABLE_PIE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TtsCalloutInternalImpl implements TtsCalloutInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLI = "cli";

  private OptionalValue<String> cli;

  public static final String JSON_PROPERTY_DESTINATION = "destination";

  private OptionalValue<DestinationTextToSpeech> destination;

  public static final String JSON_PROPERTY_DTMF = "dtmf";

  private OptionalValue<DualToneMultiFrequency> dtmf;

  public static final String JSON_PROPERTY_DOMAIN = "domain";

  private OptionalValue<Domain> domain;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_LOCALE = "locale";

  private OptionalValue<String> locale;

  public static final String JSON_PROPERTY_TEXT = "text";

  private OptionalValue<String> text;

  public static final String JSON_PROPERTY_PROMPTS = "prompts";

  private OptionalValue<String> prompts;

  public static final String JSON_PROPERTY_ENABLE_ACE = "enableAce";

  private OptionalValue<Boolean> enableAce;

  public static final String JSON_PROPERTY_ENABLE_DICE = "enableDice";

  private OptionalValue<Boolean> enableDice;

  public static final String JSON_PROPERTY_ENABLE_PIE = "enablePie";

  private OptionalValue<Boolean> enablePie;

  public TtsCalloutInternalImpl() {}

  protected TtsCalloutInternalImpl(
      OptionalValue<String> cli,
      OptionalValue<DestinationTextToSpeech> destination,
      OptionalValue<DualToneMultiFrequency> dtmf,
      OptionalValue<Domain> domain,
      OptionalValue<String> custom,
      OptionalValue<String> locale,
      OptionalValue<String> text,
      OptionalValue<String> prompts,
      OptionalValue<Boolean> enableAce,
      OptionalValue<Boolean> enableDice,
      OptionalValue<Boolean> enablePie) {
    this.cli = cli;
    this.destination = destination;
    this.dtmf = dtmf;
    this.domain = domain;
    this.custom = custom;
    this.locale = locale;
    this.text = text;
    this.prompts = prompts;
    this.enableAce = enableAce;
    this.enableDice = enableDice;
    this.enablePie = enablePie;
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
  public DestinationTextToSpeech getDestination() {
    return destination.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<DestinationTextToSpeech> destination() {
    return destination;
  }

  @JsonIgnore
  public DualToneMultiFrequency getDtmf() {
    return dtmf.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DTMF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DualToneMultiFrequency> dtmf() {
    return dtmf;
  }

  @JsonIgnore
  public Domain getDomain() {
    return domain.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DOMAIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Domain> domain() {
    return domain;
  }

  @JsonIgnore
  public String getCustom() {
    return custom.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> custom() {
    return custom;
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
  public String getText() {
    return text.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> text() {
    return text;
  }

  @JsonIgnore
  public String getPrompts() {
    return prompts.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROMPTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> prompts() {
    return prompts;
  }

  @JsonIgnore
  public Boolean getEnableAce() {
    return enableAce.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENABLE_ACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> enableAce() {
    return enableAce;
  }

  @JsonIgnore
  public Boolean getEnableDice() {
    return enableDice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENABLE_DICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> enableDice() {
    return enableDice;
  }

  @JsonIgnore
  public Boolean getEnablePie() {
    return enablePie.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENABLE_PIE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> enablePie() {
    return enablePie;
  }

  /** Return true if this ttsCallout object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TtsCalloutInternalImpl ttsCallout = (TtsCalloutInternalImpl) o;
    return Objects.equals(this.cli, ttsCallout.cli)
        && Objects.equals(this.destination, ttsCallout.destination)
        && Objects.equals(this.dtmf, ttsCallout.dtmf)
        && Objects.equals(this.domain, ttsCallout.domain)
        && Objects.equals(this.custom, ttsCallout.custom)
        && Objects.equals(this.locale, ttsCallout.locale)
        && Objects.equals(this.text, ttsCallout.text)
        && Objects.equals(this.prompts, ttsCallout.prompts)
        && Objects.equals(this.enableAce, ttsCallout.enableAce)
        && Objects.equals(this.enableDice, ttsCallout.enableDice)
        && Objects.equals(this.enablePie, ttsCallout.enablePie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        cli,
        destination,
        dtmf,
        domain,
        custom,
        locale,
        text,
        prompts,
        enableAce,
        enableDice,
        enablePie);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TtsCalloutInternalImpl {\n");
    sb.append("    cli: ").append(toIndentedString(cli)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    dtmf: ").append(toIndentedString(dtmf)).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    prompts: ").append(toIndentedString(prompts)).append("\n");
    sb.append("    enableAce: ").append(toIndentedString(enableAce)).append("\n");
    sb.append("    enableDice: ").append(toIndentedString(enableDice)).append("\n");
    sb.append("    enablePie: ").append(toIndentedString(enablePie)).append("\n");
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
  static class Builder implements TtsCalloutInternal.Builder {
    OptionalValue<String> cli = OptionalValue.empty();
    OptionalValue<DestinationTextToSpeech> destination = OptionalValue.empty();
    OptionalValue<DualToneMultiFrequency> dtmf = OptionalValue.empty();
    OptionalValue<Domain> domain = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();
    OptionalValue<String> text = OptionalValue.empty();
    OptionalValue<String> prompts = OptionalValue.empty();
    OptionalValue<Boolean> enableAce = OptionalValue.empty();
    OptionalValue<Boolean> enableDice = OptionalValue.empty();
    OptionalValue<Boolean> enablePie = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CLI)
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESTINATION)
    public Builder setDestination(DestinationTextToSpeech destination) {
      this.destination = OptionalValue.of(destination);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DTMF)
    public Builder setDtmf(DualToneMultiFrequency dtmf) {
      this.dtmf = OptionalValue.of(dtmf);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DOMAIN)
    public Builder setDomain(Domain domain) {
      this.domain = OptionalValue.of(domain);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM)
    public Builder setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LOCALE)
    public Builder setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT)
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROMPTS)
    public Builder setPrompts(String prompts) {
      this.prompts = OptionalValue.of(prompts);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ENABLE_ACE)
    public Builder setEnableAce(Boolean enableAce) {
      this.enableAce = OptionalValue.of(enableAce);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ENABLE_DICE)
    public Builder setEnableDice(Boolean enableDice) {
      this.enableDice = OptionalValue.of(enableDice);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ENABLE_PIE)
    public Builder setEnablePie(Boolean enablePie) {
      this.enablePie = OptionalValue.of(enablePie);
      return this;
    }

    public TtsCalloutInternal build() {
      return new TtsCalloutInternalImpl(
          cli,
          destination,
          dtmf,
          domain,
          custom,
          locale,
          text,
          prompts,
          enableAce,
          enableDice,
          enablePie);
    }
  }
}
