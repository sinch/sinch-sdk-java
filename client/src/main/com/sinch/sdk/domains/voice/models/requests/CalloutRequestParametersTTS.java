package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Optional;

/**
 * The text-to-speech callout calls a phone number and plays a synthesized text messages or
 * pre-recorded sound files.
 */
public class CalloutRequestParametersTTS extends CalloutRequestParameters {

  private final Boolean enableAce;
  private final Boolean enableDice;
  private final Boolean enablePie;
  private final String locale;
  private final String text;
  private final String prompts;
  private final DomainType domain;

  public CalloutRequestParametersTTS(
      Destination destination,
      E164PhoneNumber cli,
      String dtfm,
      String custom,
      Boolean enableAce,
      Boolean enableDice,
      Boolean enablePie,
      String locale,
      DomainType domain,
      String text,
      String prompts) {
    super(CalloutMethodType.TTS_CALLOUT, destination, cli, dtfm, custom);

    this.enableAce = enableAce;
    this.enableDice = enableDice;
    this.enablePie = enablePie;
    this.locale = locale;
    this.text = text;
    this.prompts = prompts;
    this.domain = domain;
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
   * @return domain
   */
  public Optional<DomainType> getDomain() {
    return Optional.ofNullable(domain);
  }

  /**
   * Every application's default maximum characters allowed in text-to-speech is 600 characters.
   * Contact support if you wish this limit to be changed.
   *
   * @return The text that will be spoken in the text-to-speech message
   */
  public Optional<String> getText() {
    return Optional.ofNullable(text);
  }

  /**
   * An advanced alternative to using text.
   *
   * <dl>
   *   <dt>TTS Text To Speech
   *   <dd>The equivalent of text but within the prompt property.
   *       <p>Example: #tts[Hello from Sinch]
   *   <dt>TTS with SSML Text To Speech with Speech Synthesis Markup Language (SSML)
   *   <dd>This is an XML-based markup language for assisting the generation of synthetic speech in
   *       the Web and other applications. AWS Polly supports a sub-set of SSML. This allows us to
   *       use SSML-enhanced text for additional control over how Polly generates speech from the
   *       text. Details and examples of supported tags @link <a
   *       href="https://docs.aws.amazon.com/polly/latest/dg/supportedtags.html">are here</a>
   *   <dt>Externally hosted media
   *   <dd>Provide a URL to your own hosted media. Please check @link <a
   *       href="https://developers.sinch.com/docs/voice/api-reference/supported-audio-formats/#limits">here</a>
   *       to read about audio content type and usage limits.
   * </dl>
   *
   * <p>Every application's default maximum allowed in TTS or TTS SSML is 600 characters. Contact
   * support if you wish this limit to be changed. Several prompts can be used, separated by a
   * semi-colon ;
   *
   * <p>Example: <code>
   * #tts[Hello from Sinch];#ssml[&lt;speak&gt;&lt;break time="250ms"/&gt;Have a great day!&lt;/speak&gt;]
   * </code>
   *
   * @return The text to be used
   */
  public Optional<String> getPrompts() {
    return Optional.ofNullable(prompts);
  }

  @Override
  public String toString() {
    return "CalloutRequestParametersTTS{"
        + "enableAce="
        + enableAce
        + ", enableDice="
        + enableDice
        + ", enablePie="
        + enablePie
        + ", locale='"
        + locale
        + '\''
        + ", text='"
        + text
        + '\''
        + ", prompts='"
        + prompts
        + '\''
        + ", domain="
        + domain
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends CalloutRequestParameters.Builder<Builder> {

    Boolean enableAce;
    Boolean enableDice;
    Boolean enablePie;
    String locale;
    DomainType domain;
    String text;
    String prompts;

    public Builder() {
      super();
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

    public Builder setDomain(DomainType domain) {
      this.domain = domain;
      return self();
    }

    public Builder setText(String text) {
      this.text = text;
      return self();
    }

    public Builder setPrompts(String prompts) {
      this.prompts = prompts;
      return self();
    }

    public CalloutRequestParametersTTS build() {
      return new CalloutRequestParametersTTS(
          destination,
          cli,
          dtfm,
          custom,
          enableAce,
          enableDice,
          enablePie,
          locale,
          domain,
          text,
          prompts);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
