package com.sinch.sdk.domains.voice.models.v1.callouts.request.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.Domain;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceDtmfOptions;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.util.Objects;

@JsonPropertyOrder({
  ConferenceCalloutInternalImpl.JSON_PROPERTY_CLI,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_DESTINATION,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_DTMF,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_CUSTOM,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_CONFERENCE_ID,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_MAX_DURATION,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_ENABLE_ACE,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_ENABLE_DICE,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_ENABLE_PIE,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_LOCALE,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_GREETING,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_MOH_CLASS,
  ConferenceCalloutInternalImpl.JSON_PROPERTY_DOMAIN
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConferenceCalloutInternalImpl implements ConferenceCalloutInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLI = "cli";

  private OptionalValue<String> cli;

  public static final String JSON_PROPERTY_DESTINATION = "destination";

  private OptionalValue<Destination> destination;

  public static final String JSON_PROPERTY_DTMF = "dtmf";

  private OptionalValue<DualToneMultiFrequency> dtmf;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_CONFERENCE_ID = "conferenceId";

  private OptionalValue<String> conferenceId;

  public static final String JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS = "conferenceDtmfOptions";

  private OptionalValue<ConferenceDtmfOptions> conferenceDtmfOptions;

  public static final String JSON_PROPERTY_MAX_DURATION = "maxDuration";

  private OptionalValue<Integer> maxDuration;

  public static final String JSON_PROPERTY_ENABLE_ACE = "enableAce";

  private OptionalValue<Boolean> enableAce;

  public static final String JSON_PROPERTY_ENABLE_DICE = "enableDice";

  private OptionalValue<Boolean> enableDice;

  public static final String JSON_PROPERTY_ENABLE_PIE = "enablePie";

  private OptionalValue<Boolean> enablePie;

  public static final String JSON_PROPERTY_LOCALE = "locale";

  private OptionalValue<String> locale;

  public static final String JSON_PROPERTY_GREETING = "greeting";

  private OptionalValue<String> greeting;

  public static final String JSON_PROPERTY_MOH_CLASS = "mohClass";

  private OptionalValue<MusicOnHold> MusicOnHold;

  public static final String JSON_PROPERTY_DOMAIN = "domain";

  private OptionalValue<Domain> domain;

  public ConferenceCalloutInternalImpl() {}

  protected ConferenceCalloutInternalImpl(
      OptionalValue<String> cli,
      OptionalValue<Destination> destination,
      OptionalValue<DualToneMultiFrequency> dtmf,
      OptionalValue<String> custom,
      OptionalValue<String> conferenceId,
      OptionalValue<ConferenceDtmfOptions> conferenceDtmfOptions,
      OptionalValue<Integer> maxDuration,
      OptionalValue<Boolean> enableAce,
      OptionalValue<Boolean> enableDice,
      OptionalValue<Boolean> enablePie,
      OptionalValue<String> locale,
      OptionalValue<String> greeting,
      OptionalValue<MusicOnHold> MusicOnHold,
      OptionalValue<Domain> domain) {
    this.cli = cli;
    this.destination = destination;
    this.dtmf = dtmf;
    this.custom = custom;
    this.conferenceId = conferenceId;
    this.conferenceDtmfOptions = conferenceDtmfOptions;
    this.maxDuration = maxDuration;
    this.enableAce = enableAce;
    this.enableDice = enableDice;
    this.enablePie = enablePie;
    this.locale = locale;
    this.greeting = greeting;
    this.MusicOnHold = MusicOnHold;
    this.domain = domain;
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
  public Destination getDestination() {
    return destination.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Destination> destination() {
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
  public String getCustom() {
    return custom.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> custom() {
    return custom;
  }

  @JsonIgnore
  public String getConferenceId() {
    return conferenceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONFERENCE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> conferenceId() {
    return conferenceId;
  }

  @JsonIgnore
  public ConferenceDtmfOptions getConferenceDtmfOptions() {
    return conferenceDtmfOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConferenceDtmfOptions> conferenceDtmfOptions() {
    return conferenceDtmfOptions;
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
  public String getGreeting() {
    return greeting.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_GREETING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> greeting() {
    return greeting;
  }

  @JsonIgnore
  public MusicOnHold getMusicOnHold() {
    return MusicOnHold.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MOH_CLASS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MusicOnHold> musicOnHold() {
    return MusicOnHold;
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

  /** Return true if this conferenceCallout object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConferenceCalloutInternalImpl conferenceCallout = (ConferenceCalloutInternalImpl) o;
    return Objects.equals(this.cli, conferenceCallout.cli)
        && Objects.equals(this.destination, conferenceCallout.destination)
        && Objects.equals(this.dtmf, conferenceCallout.dtmf)
        && Objects.equals(this.custom, conferenceCallout.custom)
        && Objects.equals(this.conferenceId, conferenceCallout.conferenceId)
        && Objects.equals(this.conferenceDtmfOptions, conferenceCallout.conferenceDtmfOptions)
        && Objects.equals(this.maxDuration, conferenceCallout.maxDuration)
        && Objects.equals(this.enableAce, conferenceCallout.enableAce)
        && Objects.equals(this.enableDice, conferenceCallout.enableDice)
        && Objects.equals(this.enablePie, conferenceCallout.enablePie)
        && Objects.equals(this.locale, conferenceCallout.locale)
        && Objects.equals(this.greeting, conferenceCallout.greeting)
        && Objects.equals(this.MusicOnHold, conferenceCallout.MusicOnHold)
        && Objects.equals(this.domain, conferenceCallout.domain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        cli,
        destination,
        dtmf,
        custom,
        conferenceId,
        conferenceDtmfOptions,
        maxDuration,
        enableAce,
        enableDice,
        enablePie,
        locale,
        greeting,
        MusicOnHold,
        domain);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConferenceCalloutInternalImpl {\n");
    sb.append("    cli: ").append(toIndentedString(cli)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    dtmf: ").append(toIndentedString(dtmf)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    conferenceId: ").append(toIndentedString(conferenceId)).append("\n");
    sb.append("    conferenceDtmfOptions: ")
        .append(toIndentedString(conferenceDtmfOptions))
        .append("\n");
    sb.append("    maxDuration: ").append(toIndentedString(maxDuration)).append("\n");
    sb.append("    enableAce: ").append(toIndentedString(enableAce)).append("\n");
    sb.append("    enableDice: ").append(toIndentedString(enableDice)).append("\n");
    sb.append("    enablePie: ").append(toIndentedString(enablePie)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    greeting: ").append(toIndentedString(greeting)).append("\n");
    sb.append("    MusicOnHold: ").append(toIndentedString(MusicOnHold)).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
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
  static class Builder implements ConferenceCalloutInternal.Builder {
    OptionalValue<String> cli = OptionalValue.empty();
    OptionalValue<Destination> destination = OptionalValue.empty();
    OptionalValue<DualToneMultiFrequency> dtmf = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<String> conferenceId = OptionalValue.empty();
    OptionalValue<ConferenceDtmfOptions> conferenceDtmfOptions = OptionalValue.empty();
    OptionalValue<Integer> maxDuration = OptionalValue.empty();
    OptionalValue<Boolean> enableAce = OptionalValue.empty();
    OptionalValue<Boolean> enableDice = OptionalValue.empty();
    OptionalValue<Boolean> enablePie = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();
    OptionalValue<String> greeting = OptionalValue.empty();
    OptionalValue<MusicOnHold> MusicOnHold = OptionalValue.empty();
    OptionalValue<Domain> domain = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CLI)
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESTINATION)
    public Builder setDestination(Destination destination) {
      this.destination = OptionalValue.of(destination);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DTMF)
    public Builder setDtmf(DualToneMultiFrequency dtmf) {
      this.dtmf = OptionalValue.of(dtmf);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM)
    public Builder setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONFERENCE_ID)
    public Builder setConferenceId(String conferenceId) {
      this.conferenceId = OptionalValue.of(conferenceId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS)
    public Builder setConferenceDtmfOptions(ConferenceDtmfOptions conferenceDtmfOptions) {
      this.conferenceDtmfOptions = OptionalValue.of(conferenceDtmfOptions);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAX_DURATION)
    public Builder setMaxDuration(Integer maxDuration) {
      this.maxDuration = OptionalValue.of(maxDuration);
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

    @JsonProperty(JSON_PROPERTY_LOCALE)
    public Builder setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_GREETING)
    public Builder setGreeting(String greeting) {
      this.greeting = OptionalValue.of(greeting);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MOH_CLASS)
    public Builder setMusicOnHold(MusicOnHold MusicOnHold) {
      this.MusicOnHold = OptionalValue.of(MusicOnHold);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DOMAIN)
    public Builder setDomain(Domain domain) {
      this.domain = OptionalValue.of(domain);
      return this;
    }

    public ConferenceCalloutInternal build() {
      return new ConferenceCalloutInternalImpl(
          cli,
          destination,
          dtmf,
          custom,
          conferenceId,
          conferenceDtmfOptions,
          maxDuration,
          enableAce,
          enableDice,
          enablePie,
          locale,
          greeting,
          MusicOnHold,
          domain);
    }
  }
}
