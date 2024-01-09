package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;

/**
 * The text-to-speech callout calls a phone number and plays a synthesized text messages or
 * pre-recorded sound files.
 */
public class CalloutRequestParametersTTS extends CalloutRequestParameters {

  private final OptionalValue<Boolean> enableAce;
  private final OptionalValue<Boolean> enableDice;
  private final OptionalValue<Boolean> enablePie;
  private final OptionalValue<String> locale;
  private final OptionalValue<String> text;
  private final OptionalValue<String> prompts;
  private final OptionalValue<DomainType> domain;

  private CalloutRequestParametersTTS(
      OptionalValue<Destination> destination,
      OptionalValue<E164PhoneNumber> cli,
      OptionalValue<DualToneMultiFrequency> dtfm,
      OptionalValue<String> custom,
      OptionalValue<Boolean> enableAce,
      OptionalValue<Boolean> enableDice,
      OptionalValue<Boolean> enablePie,
      OptionalValue<String> locale,
      OptionalValue<DomainType> domain,
      OptionalValue<String> text,
      OptionalValue<String> prompts) {
    super(OptionalValue.of(CalloutMethodType.TTS_CALLOUT), destination, cli, dtfm, custom);

    this.enableAce = enableAce;
    this.enableDice = enableDice;
    this.enablePie = enablePie;
    this.locale = locale;
    this.text = text;
    this.prompts = prompts;
    this.domain = domain;
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

  public OptionalValue<DomainType> getDomain() {
    return domain;
  }

  public OptionalValue<String> getText() {
    return text;
  }

  public OptionalValue<String> getPrompts() {
    return prompts;
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

    OptionalValue<Boolean> enableAce = OptionalValue.empty();
    OptionalValue<Boolean> enableDice = OptionalValue.empty();
    OptionalValue<Boolean> enablePie = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();
    OptionalValue<DomainType> domain = OptionalValue.empty();
    OptionalValue<String> text = OptionalValue.empty();
    OptionalValue<String> prompts = OptionalValue.empty();

    public Builder() {
      super();
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
     * @param enableAce set if enabled or not
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
     * @param enableDice set if enabled or not
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
     * @param enablePie set if enabled or not
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
     * @param domain Domain value to be used
     * @return current builder
     */
    public Builder setDomain(DomainType domain) {
      this.domain = OptionalValue.of(domain);
      return self();
    }

    /**
     * Every application's default maximum characters allowed in text-to-speech is 600 characters.
     * Contact support if you wish this limit to be changed.
     *
     * @param text The text that will be spoken in the text-to-speech message
     * @return current builder
     */
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return self();
    }

    /**
     * An advanced alternative to using text.
     *
     * <dl>
     *   <dt>TTS Text To Speech
     *   <dd>The equivalent of text but within the prompt property.
     *       <p>Example: #tts[Hello from Sinch]
     *   <dt>TTS with SSML Text To Speech with Speech Synthesis Markup Language (SSML)
     *   <dd>This is an XML-based markup language for assisting the generation of synthetic speech
     *       in the Web and other applications. AWS Polly supports a sub-set of SSML. This allows us
     *       to use SSML-enhanced text for additional control over how Polly generates speech from
     *       the text. Details and examples of supported tags @link <a
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
     * @param prompts The text to be used
     * @return current builder
     */
    public Builder setPrompts(String prompts) {
      this.prompts = OptionalValue.of(prompts);
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
