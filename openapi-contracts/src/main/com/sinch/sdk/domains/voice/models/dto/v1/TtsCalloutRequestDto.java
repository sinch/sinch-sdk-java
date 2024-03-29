/*
 * Voice API | Sinch
 * The Voice API exposes calling- and conference-related functionality in the Sinch Voice Platform.
 *
 * The version of the OpenAPI document: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * The text-to-speech callout calls a phone number and plays a synthesized text messages or
 * pre-recorded sound files.
 */
@JsonPropertyOrder({
  TtsCalloutRequestDto.JSON_PROPERTY_DESTINATION,
  TtsCalloutRequestDto.JSON_PROPERTY_CLI,
  TtsCalloutRequestDto.JSON_PROPERTY_DTMF,
  TtsCalloutRequestDto.JSON_PROPERTY_DOMAIN,
  TtsCalloutRequestDto.JSON_PROPERTY_CUSTOM,
  TtsCalloutRequestDto.JSON_PROPERTY_LOCALE,
  TtsCalloutRequestDto.JSON_PROPERTY_TEXT,
  TtsCalloutRequestDto.JSON_PROPERTY_PROMPTS,
  TtsCalloutRequestDto.JSON_PROPERTY_ENABLE_ACE,
  TtsCalloutRequestDto.JSON_PROPERTY_ENABLE_DICE,
  TtsCalloutRequestDto.JSON_PROPERTY_ENABLE_PIE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TtsCalloutRequestDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_DESTINATION = "destination";
  private DestinationDto destination;
  private boolean destinationDefined = false;

  public static final String JSON_PROPERTY_CLI = "cli";
  private String cli;
  private boolean cliDefined = false;

  public static final String JSON_PROPERTY_DTMF = "dtmf";
  private String dtmf;
  private boolean dtmfDefined = false;

  public static final String JSON_PROPERTY_DOMAIN = "domain";
  private DomainDto domain;
  private boolean domainDefined = false;

  public static final String JSON_PROPERTY_CUSTOM = "custom";
  private String custom;
  private boolean customDefined = false;

  public static final String JSON_PROPERTY_LOCALE = "locale";
  private String locale;
  private boolean localeDefined = false;

  public static final String JSON_PROPERTY_TEXT = "text";
  private String text;
  private boolean textDefined = false;

  public static final String JSON_PROPERTY_PROMPTS = "prompts";
  private String prompts;
  private boolean promptsDefined = false;

  public static final String JSON_PROPERTY_ENABLE_ACE = "enableAce";
  private Boolean enableAce;
  private boolean enableAceDefined = false;

  public static final String JSON_PROPERTY_ENABLE_DICE = "enableDice";
  private Boolean enableDice;
  private boolean enableDiceDefined = false;

  public static final String JSON_PROPERTY_ENABLE_PIE = "enablePie";
  private Boolean enablePie;
  private boolean enablePieDefined = false;

  public TtsCalloutRequestDto() {}

  public TtsCalloutRequestDto destination(DestinationDto destination) {
    this.destination = destination;
    this.destinationDefined = true;
    return this;
  }

  /**
   * Get destination
   *
   * @return destination
   */
  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public DestinationDto getDestination() {
    return destination;
  }

  @JsonIgnore
  public boolean getDestinationDefined() {
    return destinationDefined;
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDestination(DestinationDto destination) {
    this.destination = destination;
    this.destinationDefined = true;
  }

  public TtsCalloutRequestDto cli(String cli) {
    this.cli = cli;
    this.cliDefined = true;
    return this;
  }

  /**
   * The number that will be displayed as the incoming caller. To set your own CLI, you may use your
   * verified number or your Dashboard number. The number must be in
   * [E.164](https://community.sinch.com/t5/Glossary/E-164/ta-p/7537) format.
   *
   * @return cli
   */
  @JsonProperty(JSON_PROPERTY_CLI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCli() {
    return cli;
  }

  @JsonIgnore
  public boolean getCliDefined() {
    return cliDefined;
  }

  @JsonProperty(JSON_PROPERTY_CLI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCli(String cli) {
    this.cli = cli;
    this.cliDefined = true;
  }

  public TtsCalloutRequestDto dtmf(String dtmf) {
    this.dtmf = dtmf;
    this.dtmfDefined = true;
    return this;
  }

  /**
   * When the destination picks up, this DTMF tones will be played to the callee. Valid characters
   * in the string are \&quot;0\&quot;-\&quot;9\&quot;, \&quot;#\&quot;, and \&quot;w\&quot;. A
   * \&quot;w\&quot; will render a 500 ms pause. For example, \&quot;ww1234#w#\&quot; will render a
   * 1s pause, the DTMF tones \&quot;1\&quot;, \&quot;2\&quot;, \&quot;3\&quot;, \&quot;4\&quot; and
   * \&quot;#\&quot; followed by a 0.5s pause and finally the DTMF tone for \&quot;#\&quot;. This
   * can be used if the callout destination for instance require a conference PIN code or an
   * extension to be entered.
   *
   * @return dtmf
   */
  @JsonProperty(JSON_PROPERTY_DTMF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDtmf() {
    return dtmf;
  }

  @JsonIgnore
  public boolean getDtmfDefined() {
    return dtmfDefined;
  }

  @JsonProperty(JSON_PROPERTY_DTMF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDtmf(String dtmf) {
    this.dtmf = dtmf;
    this.dtmfDefined = true;
  }

  public TtsCalloutRequestDto domain(DomainDto domain) {
    this.domain = domain;
    this.domainDefined = true;
    return this;
  }

  /**
   * Get domain
   *
   * @return domain
   */
  @JsonProperty(JSON_PROPERTY_DOMAIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public DomainDto getDomain() {
    return domain;
  }

  @JsonIgnore
  public boolean getDomainDefined() {
    return domainDefined;
  }

  @JsonProperty(JSON_PROPERTY_DOMAIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDomain(DomainDto domain) {
    this.domain = domain;
    this.domainDefined = true;
  }

  public TtsCalloutRequestDto custom(String custom) {
    this.custom = custom;
    this.customDefined = true;
    return this;
  }

  /**
   * Can be used to input custom data.
   *
   * @return custom
   */
  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCustom() {
    return custom;
  }

  @JsonIgnore
  public boolean getCustomDefined() {
    return customDefined;
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustom(String custom) {
    this.custom = custom;
    this.customDefined = true;
  }

  public TtsCalloutRequestDto locale(String locale) {
    this.locale = locale;
    this.localeDefined = true;
    return this;
  }

  /**
   * The voice and language you want to use for the text-to-speech message. This can either be
   * defined by the ISO 639 locale and language code or by specifying a particular voice. Supported
   * languages and voices are detailed [here](../../../voice-locales/).
   *
   * @return locale
   */
  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLocale() {
    return locale;
  }

  @JsonIgnore
  public boolean getLocaleDefined() {
    return localeDefined;
  }

  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocale(String locale) {
    this.locale = locale;
    this.localeDefined = true;
  }

  public TtsCalloutRequestDto text(String text) {
    this.text = text;
    this.textDefined = true;
    return this;
  }

  /**
   * The text that will be spoken in the text-to-speech message. _Every application&#39;s default
   * maximum characters allowed in text-to-speech is 600 characters. Contact support if you wish
   * this limit to be changed._
   *
   * @return text
   */
  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getText() {
    return text;
  }

  @JsonIgnore
  public boolean getTextDefined() {
    return textDefined;
  }

  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setText(String text) {
    this.text = text;
    this.textDefined = true;
  }

  public TtsCalloutRequestDto prompts(String prompts) {
    this.prompts = prompts;
    this.promptsDefined = true;
    return this;
  }

  /**
   * An advanced alternative to using &#x60;&#x60;&#x60;text&#x60;&#x60;&#x60;. __TTS__ _Text To
   * Speech:_ The equivalent of text but within the prompt property. Example:
   * _&#x60;&#x60;&#x60;#tts[Hello from Sinch]&#x60;&#x60;&#x60;_ __TTS with SSML__ _Text To Speech
   * with Speech Synthesis Markup Language (SSML)._ This is an XML-based markup language for
   * assisting the generation of synthetic speech in the Web and other applications. AWS Polly
   * supports a sub-set of SSML. This allows us to use SSML-enhanced text for additional control
   * over how Polly generates speech from the text. Details and examples of supported tags are
   * [here](https://docs.aws.amazon.com/polly/latest/dg/supportedtags.html) __Externally hosted
   * media:__ Provide a URL to your own hosted media. Please check
   * [here](../../../supported-audio-formats/#limits) to read about audio content type and usage
   * limits. _Every application&#39;s default maximum allowed in TTS or TTS SSML is 600 characters.
   * Contact support if you wish this limit to be changed._ _Several prompts can be used, separated
   * by a semi-colon_ &#x60;&#x60;&#x60;;&#x60;&#x60;&#x60; Example: _&#x60;&#x60;&#x60;#tts[Hello
   * from Sinch];#ssml[&lt;speak&gt;&lt;break time&#x3D;\\\&quot;250ms\\\&quot;/&gt;Have a great
   * day!&lt;/speak&gt;]&#x60;&#x60;&#x60;_
   *
   * @return prompts
   */
  @JsonProperty(JSON_PROPERTY_PROMPTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPrompts() {
    return prompts;
  }

  @JsonIgnore
  public boolean getPromptsDefined() {
    return promptsDefined;
  }

  @JsonProperty(JSON_PROPERTY_PROMPTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrompts(String prompts) {
    this.prompts = prompts;
    this.promptsDefined = true;
  }

  public TtsCalloutRequestDto enableAce(Boolean enableAce) {
    this.enableAce = enableAce;
    this.enableAceDefined = true;
    return this;
  }

  /**
   * If &#x60;enableAce&#x60; is set to &#x60;true&#x60; and the application has a callback URL
   * specified, you will receive an ACE callback when the call is answered. When the callback is
   * received, your platform must respond with a svamlet, containing the “connectconf” action in
   * order to add the call to a conference or create the conference if it&#39;s the first call. If
   * it&#39;s set to &#x60;false&#x60;, no ACE event will be sent to your backend.
   *
   * @return enableAce
   */
  @JsonProperty(JSON_PROPERTY_ENABLE_ACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getEnableAce() {
    return enableAce;
  }

  @JsonIgnore
  public boolean getEnableAceDefined() {
    return enableAceDefined;
  }

  @JsonProperty(JSON_PROPERTY_ENABLE_ACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnableAce(Boolean enableAce) {
    this.enableAce = enableAce;
    this.enableAceDefined = true;
  }

  public TtsCalloutRequestDto enableDice(Boolean enableDice) {
    this.enableDice = enableDice;
    this.enableDiceDefined = true;
    return this;
  }

  /**
   * If &#x60;enableDice&#x60; is set to &#x60;true&#x60; and the application has a callback URL
   * specified, you will receive a DiCE callback when the call is disconnected. If it&#39;s set to
   * &#x60;false&#x60;, no DiCE event will be sent to your backend.
   *
   * @return enableDice
   */
  @JsonProperty(JSON_PROPERTY_ENABLE_DICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getEnableDice() {
    return enableDice;
  }

  @JsonIgnore
  public boolean getEnableDiceDefined() {
    return enableDiceDefined;
  }

  @JsonProperty(JSON_PROPERTY_ENABLE_DICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnableDice(Boolean enableDice) {
    this.enableDice = enableDice;
    this.enableDiceDefined = true;
  }

  public TtsCalloutRequestDto enablePie(Boolean enablePie) {
    this.enablePie = enablePie;
    this.enablePieDefined = true;
    return this;
  }

  /**
   * &lt;b&gt;Note:&lt;/b&gt; PIE callbacks are not available for DATA Calls; only PSTN and SIP
   * calls. If &#x60;enablePie&#x60; is set to &#x60;true&#x60; and the application has a callback
   * URL specified, you will receive a PIE callback after the &#x60;runMenu&#x60; action executes
   * and after the configured menu timeout has elapsed with no input. If it&#39;s set to
   * &#x60;false&#x60;, no PIE events will be sent to your backend.
   *
   * @return enablePie
   */
  @JsonProperty(JSON_PROPERTY_ENABLE_PIE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getEnablePie() {
    return enablePie;
  }

  @JsonIgnore
  public boolean getEnablePieDefined() {
    return enablePieDefined;
  }

  @JsonProperty(JSON_PROPERTY_ENABLE_PIE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnablePie(Boolean enablePie) {
    this.enablePie = enablePie;
    this.enablePieDefined = true;
  }

  /** Return true if this ttsCalloutRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TtsCalloutRequestDto ttsCalloutRequest = (TtsCalloutRequestDto) o;
    return Objects.equals(this.destination, ttsCalloutRequest.destination)
        && Objects.equals(this.cli, ttsCalloutRequest.cli)
        && Objects.equals(this.dtmf, ttsCalloutRequest.dtmf)
        && Objects.equals(this.domain, ttsCalloutRequest.domain)
        && Objects.equals(this.custom, ttsCalloutRequest.custom)
        && Objects.equals(this.locale, ttsCalloutRequest.locale)
        && Objects.equals(this.text, ttsCalloutRequest.text)
        && Objects.equals(this.prompts, ttsCalloutRequest.prompts)
        && Objects.equals(this.enableAce, ttsCalloutRequest.enableAce)
        && Objects.equals(this.enableDice, ttsCalloutRequest.enableDice)
        && Objects.equals(this.enablePie, ttsCalloutRequest.enablePie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        destination,
        cli,
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
    sb.append("class TtsCalloutRequestDto {\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    cli: ").append(toIndentedString(cli)).append("\n");
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
}
