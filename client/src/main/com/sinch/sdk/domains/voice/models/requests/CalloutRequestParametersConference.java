package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.MohClassType;
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;

/**
 * The conference callout calls a phone number or a user. When the call is answered, it's connected
 * to a conference room
 */
public class CalloutRequestParametersConference extends CalloutRequestParameters {

  private final OptionalValue<String> conferenceId;
  private final OptionalValue<ConferenceDtfmOptions> dtfmOptions;
  private final OptionalValue<Integer> maxDuration;
  private final OptionalValue<Boolean> enableAce;
  private final OptionalValue<Boolean> enableDice;
  private final OptionalValue<Boolean> enablePie;
  private final OptionalValue<String> locale;
  private final OptionalValue<String> greeting;
  private final OptionalValue<MohClassType> mohClass;
  private final OptionalValue<DomainType> domain;

  private CalloutRequestParametersConference(
      OptionalValue<Destination> destination,
      OptionalValue<E164PhoneNumber> cli,
      OptionalValue<DualToneMultiFrequency> dtfm,
      OptionalValue<String> custom,
      OptionalValue<String> conferenceId,
      OptionalValue<ConferenceDtfmOptions> dtfmOptions,
      OptionalValue<Integer> maxDuration,
      OptionalValue<Boolean> enableAce,
      OptionalValue<Boolean> enableDice,
      OptionalValue<Boolean> enablePie,
      OptionalValue<String> locale,
      OptionalValue<String> greeting,
      OptionalValue<MohClassType> mohClass,
      OptionalValue<DomainType> domain) {
    super(OptionalValue.of(CalloutMethodType.CONFERENCE_CALLOUT), destination, cli, dtfm, custom);

    this.conferenceId = conferenceId;
    this.dtfmOptions = dtfmOptions;
    this.maxDuration = maxDuration;
    this.enableAce = enableAce;
    this.enableDice = enableDice;
    this.enablePie = enablePie;
    this.locale = locale;
    this.greeting = greeting;
    this.mohClass = mohClass;
    this.domain = domain;
  }

  public OptionalValue<String> getConferenceId() {
    return conferenceId;
  }

  public OptionalValue<ConferenceDtfmOptions> getDtfmOptions() {
    return dtfmOptions;
  }

  public OptionalValue<Integer> getMaxDuration() {
    return maxDuration;
  }

  public OptionalValue<Boolean> getEnableAce() {
    return enableAce;
  }

  public OptionalValue<Boolean> getEnableDice() {
    return enableDice;
  }

  public OptionalValue<Boolean> getEnablePie() {
    return enablePie;
  }

  public OptionalValue<String> getLocale() {
    return locale;
  }

  public OptionalValue<String> getGreeting() {
    return greeting;
  }

  public OptionalValue<MohClassType> getMohClass() {
    return mohClass;
  }

  public OptionalValue<DomainType> getDomain() {
    return domain;
  }

  @Override
  public String toString() {
    return "CalloutRequestParametersConference{"
        + "conferenceId='"
        + conferenceId
        + '\''
        + ", dtfmOptions="
        + dtfmOptions
        + ", maxDuration="
        + maxDuration
        + ", enableAce="
        + enableAce
        + ", enableDice="
        + enableDice
        + ", enablePie="
        + enablePie
        + ", locale='"
        + locale
        + '\''
        + ", greeting='"
        + greeting
        + '\''
        + ", mohClass="
        + mohClass
        + ", domain="
        + domain
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends CalloutRequestParameters.Builder<Builder> {

    OptionalValue<String> conferenceId = OptionalValue.empty();
    OptionalValue<ConferenceDtfmOptions> dtfmOptions = OptionalValue.empty();
    OptionalValue<Integer> maxDuration = OptionalValue.empty();
    OptionalValue<Boolean> enableAce = OptionalValue.empty();
    OptionalValue<Boolean> enableDice = OptionalValue.empty();
    OptionalValue<Boolean> enablePie = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();
    OptionalValue<String> greeting = OptionalValue.empty();
    OptionalValue<MohClassType> mohClass = OptionalValue.empty();
    OptionalValue<DomainType> domain = OptionalValue.empty();

    public Builder() {
      super();
    }

    /**
     * @param conferenceId The conferenceId of the conference to which you want the callee to join.
     *     If the * conferenceId doesn't exist a conference room will be created.
     * @return current builder
     */
    public Builder setConferenceId(String conferenceId) {
      this.conferenceId = OptionalValue.of(conferenceId);
      return self();
    }

    /**
     * @param dtfmOptions Options to control how DTMF signals are used by the participant in the
     *     conference
     * @return current builder
     */
    public Builder setDtfmOptions(ConferenceDtfmOptions dtfmOptions) {
      this.dtfmOptions = OptionalValue.of(dtfmOptions);
      return self();
    }

    /**
     * The maximum amount of time in seconds that the call will last.
     *
     * @param maxDuration Max duration value
     * @return current builder
     */
    public Builder setMaxDuration(Integer maxDuration) {
      this.maxDuration = OptionalValue.of(maxDuration);
      return self();
    }

    /**
     * If enableAce is set to true and the application has a callback URL specified, you will
     * receive an ACE callback when the call is answered. When the callback is received, your
     * platform must respond with a svamlet containing the connectConf action in order to add the
     * call to a conference or create the conference if it's the first call. If it's set to false,
     * no ACE event will be sent to your backend. Note if the call is towards an InApp destination
     * type: username, then no ACE will be issued when the call is connected, even if enableAce is
     * present in the callout request.
     *
     * @param enableAce is enabled or not
     * @return current builder
     */
    public Builder setEnableAce(Boolean enableAce) {
      this.enableAce = OptionalValue.of(enableAce);
      return self();
    }

    /**
     * If enableDice is set to true and the application has a callback URL specified, you will
     * receive a DiCE callback when the call is disconnected. If it's set to false, no DiCE event
     * will be sent to your backend. Note if the call is towards an InApp destination type:
     * username, then no DICE will be issued at the end of the call, even if enableDice is present
     * in the callout request.
     *
     * @param enableDice is enabled or not
     * @return current builder
     */
    public Builder setEnableDice(Boolean enableDice) {
      this.enableDice = OptionalValue.of(enableDice);
      return self();
    }

    /**
     * If enablePie is set to true and the application has a callback URL specified, you will
     * receive a PIE callback after a runMenu action, with the information of the action that the
     * user took. If it's set to false, no PIE event will be sent to your backend.
     *
     * @param enablePie is enabled or not
     * @return current builder
     */
    public Builder setEnablePie(Boolean enablePie) {
      this.enablePie = OptionalValue.of(enablePie);
      return self();
    }

    /**
     * The voice and language you want to use for the prompts. This can either be defined by the ISO
     * 639 locale and language code or by specifying a particular voice.
     *
     * @see <a href="https://developers.sinch.com/docs/voice/api-reference/voice-locales/">Supported
     *     languages and voices are detailed here</a>
     * @param locale The locale to be used
     * @return current builder
     */
    public Builder setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return self();
    }

    /**
     * Set the text that will be spoken as a greeting.
     *
     * @param greeting the text value
     * @return current builder
     */
    public Builder setGreeting(String greeting) {
      this.greeting = OptionalValue.of(greeting);
      return self();
    }

    /**
     * Means "music-on-hold." It's an optional parameter that specifies what the first participant
     * should listen to while they're alone in the conference, waiting for other participants to
     * join.
     *
     * @param mohClass The music-on-hold to be used
     * @return current builder
     */
    public Builder setMohClass(MohClassType mohClass) {
      this.mohClass = OptionalValue.of(mohClass);
      return self();
    }

    /**
     * @param domain Domain to be used
     * @return current builder
     */
    public Builder setDomain(DomainType domain) {
      this.domain = OptionalValue.of(domain);
      return self();
    }

    public CalloutRequestParametersConference build() {
      return new CalloutRequestParametersConference(
          destination,
          cli,
          dtfm,
          custom,
          conferenceId,
          dtfmOptions,
          maxDuration,
          enableAce,
          enableDice,
          enablePie,
          locale,
          greeting,
          mohClass,
          domain);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
