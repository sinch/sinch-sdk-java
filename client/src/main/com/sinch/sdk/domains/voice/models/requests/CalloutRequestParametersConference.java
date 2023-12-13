package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Objects;
import java.util.Optional;

/**
 * The conference callout calls a phone number or a user. When the call is answered, it's connected
 * to a conference room
 */
public class CalloutRequestParametersConference extends CalloutRequestParameters {

  private final String conferenceId;
  private final ConferenceDtfmOptions dtfmOptions;
  private final Integer maxDuration;
  private final Boolean enableAce;
  private final Boolean enableDice;
  private final Boolean enablePie;
  private final String locale;
  private final String greeting;
  private final MohClassType mohClass;
  private final DomainType domain;

  public CalloutRequestParametersConference(
      Destination destination,
      E164PhoneNumber cli,
      String dtfm,
      String custom,
      String conferenceId,
      ConferenceDtfmOptions dtfmOptions,
      Integer maxDuration,
      Boolean enableAce,
      Boolean enableDice,
      Boolean enablePie,
      String locale,
      String greeting,
      MohClassType mohClass,
      DomainType domain) {
    super(CalloutMethodType.CONFERENCE_CALLOUT, destination, cli, dtfm, custom);

    Objects.requireNonNull(conferenceId, "conferenceId is required");
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

  /**
   * @return The conferenceId of the conference to which you want the callee to join. If the
   *     conferenceId doesn't exist a conference room will be created.
   */
  public String getConferenceId() {
    return conferenceId;
  }

  /**
   * @return Options to control how DTMF signals are used by the participant in the conference
   */
  public Optional<ConferenceDtfmOptions> getDtfmOptions() {
    return Optional.ofNullable(dtfmOptions);
  }

  /**
   * The maximum amount of time in seconds that the call will last.
   *
   * @return Max duration value
   */
  public Optional<Integer> getMaxDuration() {
    return Optional.ofNullable(maxDuration);
  }

  /**
   * @return If enableAce is set to true and the application has a callback URL specified, you will
   *     receive an ACE callback when the call is answered. When the callback is received, your
   *     platform must respond with a svamlet containing the connectConf action in order to add the
   *     call to a conference or create the conference if it's the first call. If it's set to false,
   *     no ACE event will be sent to your backend. Note if the call is towards an InApp destination
   *     type: username, then no ACE will be issued when the call is connected, even if enableAce is
   *     present in the callout request.
   */
  public Optional<Boolean> getEnableAce() {
    return Optional.ofNullable(enableAce);
  }

  /**
   * @return If enableDice is set to true and the application has a callback URL specified, you will
   *     receive a DiCE callback when the call is disconnected. If it's set to false, no DiCE event
   *     will be sent to your backend. Note if the call is towards an InApp destination type:
   *     username, then no DICE will be issued at the end of the call, even if enableDice is present
   *     in the callout request.
   */
  public Optional<Boolean> getEnableDice() {
    return Optional.ofNullable(enableDice);
  }

  /**
   * @return If enablePie is set to true and the application has a callback URL specified, you will
   *     receive a PIE callback after a runMenu action, with the information of the action that the
   *     user took. If it's set to false, no PIE event will be sent to your backend.
   */
  public Optional<Boolean> getEnablePie() {
    return Optional.ofNullable(enablePie);
  }

  /**
   * @return The voice and language you want to use for the prompts. This can either be defined by
   *     the ISO 639 locale and language code or by specifying a particular voice.
   * @see <a href="https://developers.sinch.com/docs/voice/api-reference/voice-locales/">Supported
   *     languages and voices are detailed here</a>
   */
  public Optional<String> getLocale() {
    return Optional.ofNullable(locale);
  }

  /**
   * @return The text that will be spoken as a greeting.
   */
  public Optional<String> getGreeting() {
    return Optional.ofNullable(greeting);
  }

  /**
   * @return Means "music-on-hold." It's an optional parameter that specifies what the first
   *     participant should listen to while they're alone in the conference, waiting for other
   *     participants to join.
   */
  public Optional<MohClassType> getMohClass() {
    return Optional.ofNullable(mohClass);
  }

  /**
   * @return domain
   */
  public Optional<DomainType> getDomain() {
    return Optional.ofNullable(domain);
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

    String conferenceId;
    ConferenceDtfmOptions dtfmOptions;
    Integer maxDuration;
    Boolean enableAce;
    Boolean enableDice;
    Boolean enablePie;
    String locale;
    String greeting;
    MohClassType mohClass;
    DomainType domain;

    public Builder() {
      super();
    }

    public Builder setConferenceId(String conferenceId) {
      this.conferenceId = conferenceId;
      return self();
    }

    public Builder setDtfmOptions(ConferenceDtfmOptions dtfmOptions) {
      this.dtfmOptions = dtfmOptions;
      return self();
    }

    public Builder setMaxDuration(Integer maxDuration) {
      this.maxDuration = maxDuration;
      return self();
    }

    public Builder setEnableAce(Boolean enableAce) {
      this.enableAce = enableAce;
      return self();
    }

    public Builder setEnableDice(Boolean enableDice) {
      this.enableDice = enableDice;
      return self();
    }

    public Builder setEnablePie(Boolean enablePie) {
      this.enablePie = enablePie;
      return self();
    }

    public Builder setLocale(String locale) {
      this.locale = locale;
      return self();
    }

    public Builder setGreeting(String greeting) {
      this.greeting = greeting;
      return self();
    }

    public Builder setMohClass(MohClassType mohClass) {
      this.mohClass = mohClass;
      return self();
    }

    public Builder setDomain(DomainType domain) {
      this.domain = domain;
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
