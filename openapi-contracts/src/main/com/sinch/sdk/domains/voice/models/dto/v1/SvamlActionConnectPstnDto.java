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
 * Determines how a PSTN call is connected. Available to use in a response to an [Incoming Call
 * Event](../../voice/tag/Callbacks/#tag/Callbacks/operation/ice) callback.
 */
@JsonPropertyOrder({
  SvamlActionConnectPstnDto.JSON_PROPERTY_NAME,
  SvamlActionConnectPstnDto.JSON_PROPERTY_NUMBER,
  SvamlActionConnectPstnDto.JSON_PROPERTY_LOCALE,
  SvamlActionConnectPstnDto.JSON_PROPERTY_MAX_DURATION,
  SvamlActionConnectPstnDto.JSON_PROPERTY_DIAL_TIMEOUT,
  SvamlActionConnectPstnDto.JSON_PROPERTY_CLI,
  SvamlActionConnectPstnDto.JSON_PROPERTY_SUPPRESS_CALLBACKS,
  SvamlActionConnectPstnDto.JSON_PROPERTY_DTMF,
  SvamlActionConnectPstnDto.JSON_PROPERTY_INDICATIONS,
  SvamlActionConnectPstnDto.JSON_PROPERTY_AMD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlActionConnectPstnDto {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;
  private boolean nameDefined = false;

  public static final String JSON_PROPERTY_NUMBER = "number";
  private String number;
  private boolean numberDefined = false;

  public static final String JSON_PROPERTY_LOCALE = "locale";
  private String locale;
  private boolean localeDefined = false;

  public static final String JSON_PROPERTY_MAX_DURATION = "maxDuration";
  private Integer maxDuration;
  private boolean maxDurationDefined = false;

  public static final String JSON_PROPERTY_DIAL_TIMEOUT = "dialTimeout";
  private Integer dialTimeout;
  private boolean dialTimeoutDefined = false;

  public static final String JSON_PROPERTY_CLI = "cli";
  private String cli;
  private boolean cliDefined = false;

  public static final String JSON_PROPERTY_SUPPRESS_CALLBACKS = "suppressCallbacks";
  private Boolean suppressCallbacks;
  private boolean suppressCallbacksDefined = false;

  public static final String JSON_PROPERTY_DTMF = "dtmf";
  private String dtmf;
  private boolean dtmfDefined = false;

  public static final String JSON_PROPERTY_INDICATIONS = "indications";
  private String indications;
  private boolean indicationsDefined = false;

  public static final String JSON_PROPERTY_AMD = "amd";
  private SvamlActionConnectPstnAmdDto amd;
  private boolean amdDefined = false;

  public SvamlActionConnectPstnDto() {}

  public SvamlActionConnectPstnDto name(String name) {
    this.name = name;
    this.nameDefined = true;
    return this;
  }

  /**
   * The name property. Must have the value &#x60;connectPstn&#x60;.
   *
   * @return name
   */
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getName() {
    return name;
  }

  @JsonIgnore
  public boolean getNameDefined() {
    return nameDefined;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
    this.nameDefined = true;
  }

  public SvamlActionConnectPstnDto number(String number) {
    this.number = number;
    this.numberDefined = true;
    return this;
  }

  /**
   * Used to override where PSTN call is connected. If not specified, the extension the client
   * called is used.
   *
   * @return number
   */
  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getNumber() {
    return number;
  }

  @JsonIgnore
  public boolean getNumberDefined() {
    return numberDefined;
  }

  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumber(String number) {
    this.number = number;
    this.numberDefined = true;
  }

  public SvamlActionConnectPstnDto locale(String locale) {
    this.locale = locale;
    this.localeDefined = true;
    return this;
  }

  /**
   * Specifies the locale. Uses the language code according to &#x60;ISO 639&#x60;, a dash
   * (&#x60;-&#x60;), and a country code according to &#x60;ISO 3166-1 alpha-2&#x60;. If not
   * specified, the default locale of &#x60;en-US&#x60; is used.
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

  public SvamlActionConnectPstnDto maxDuration(Integer maxDuration) {
    this.maxDuration = maxDuration;
    this.maxDurationDefined = true;
    return this;
  }

  /**
   * The max duration of the call in seconds (max 14400 seconds). If the call is still connected at
   * that time, it will be automatically disconnected.
   *
   * @return maxDuration
   */
  @JsonProperty(JSON_PROPERTY_MAX_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getMaxDuration() {
    return maxDuration;
  }

  @JsonIgnore
  public boolean getMaxDurationDefined() {
    return maxDurationDefined;
  }

  @JsonProperty(JSON_PROPERTY_MAX_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxDuration(Integer maxDuration) {
    this.maxDuration = maxDuration;
    this.maxDurationDefined = true;
  }

  public SvamlActionConnectPstnDto dialTimeout(Integer dialTimeout) {
    this.dialTimeout = dialTimeout;
    this.dialTimeoutDefined = true;
    return this;
  }

  /**
   * The max duration the call will wait in ringing unanswered state before terminating with
   * &#x60;&#x60;&#x60;TIMEOUT/NO ANSWER&#x60;&#x60;&#x60; on PSTN leg and
   * &#x60;&#x60;&#x60;NA/BUSY&#x60;&#x60;&#x60;on MXP leg.
   *
   * @return dialTimeout
   */
  @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getDialTimeout() {
    return dialTimeout;
  }

  @JsonIgnore
  public boolean getDialTimeoutDefined() {
    return dialTimeoutDefined;
  }

  @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDialTimeout(Integer dialTimeout) {
    this.dialTimeout = dialTimeout;
    this.dialTimeoutDefined = true;
  }

  public SvamlActionConnectPstnDto cli(String cli) {
    this.cli = cli;
    this.cliDefined = true;
    return this;
  }

  /**
   * Used to override the CLI (or caller ID) of the client. The phone number of the person who
   * initiated the call is shown as the CLI. To set your own CLI, you may use your verified number
   * or your Dashboard virtual number.
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

  public SvamlActionConnectPstnDto suppressCallbacks(Boolean suppressCallbacks) {
    this.suppressCallbacks = suppressCallbacks;
    this.suppressCallbacksDefined = true;
    return this;
  }

  /**
   * If enabled, suppresses [ACE](../../voice/tag/Callbacks/#tag/Callbacks/operation/ace) and
   * [DICE](../../voice/tag/Callbacks/#tag/Callbacks/operation/dice) callbacks for the call.
   *
   * @return suppressCallbacks
   */
  @JsonProperty(JSON_PROPERTY_SUPPRESS_CALLBACKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getSuppressCallbacks() {
    return suppressCallbacks;
  }

  @JsonIgnore
  public boolean getSuppressCallbacksDefined() {
    return suppressCallbacksDefined;
  }

  @JsonProperty(JSON_PROPERTY_SUPPRESS_CALLBACKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSuppressCallbacks(Boolean suppressCallbacks) {
    this.suppressCallbacks = suppressCallbacks;
    this.suppressCallbacksDefined = true;
  }

  public SvamlActionConnectPstnDto dtmf(String dtmf) {
    this.dtmf = dtmf;
    this.dtmfDefined = true;
    return this;
  }

  /**
   * A string that determines the DTMF tones to play to the callee when the call is picked up. Valid
   * characters are: &#x60;0-9&#x60;, &#x60;#&#x60;, and &#x60;w&#x60;. &#x60;w&#x60; renders a
   * 500ms pause. For example, the string &#x60;ww1234#w#&#x60;, plays a 1 second pause, the DTMF
   * tones for &#x60;1&#x60;, &#x60;2&#x60;, &#x60;3&#x60;, &#x60;4&#x60;, and &#x60;#&#x60;,
   * followed by a 500ms pause and finally the &#x60;#&#x60; tone. This is useful if the callout
   * destination requires a conference PIN code or an extension. If there is a calling party, it
   * will hear progress while the DTMF is sent.
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

  public SvamlActionConnectPstnDto indications(String indications) {
    this.indications = indications;
    this.indicationsDefined = true;
    return this;
  }

  /**
   * The locale&#39;s tone to play while ringing.
   *
   * @return indications
   */
  @JsonProperty(JSON_PROPERTY_INDICATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getIndications() {
    return indications;
  }

  @JsonIgnore
  public boolean getIndicationsDefined() {
    return indicationsDefined;
  }

  @JsonProperty(JSON_PROPERTY_INDICATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIndications(String indications) {
    this.indications = indications;
    this.indicationsDefined = true;
  }

  public SvamlActionConnectPstnDto amd(SvamlActionConnectPstnAmdDto amd) {
    this.amd = amd;
    this.amdDefined = true;
    return this;
  }

  /**
   * Get amd
   *
   * @return amd
   */
  @JsonProperty(JSON_PROPERTY_AMD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SvamlActionConnectPstnAmdDto getAmd() {
    return amd;
  }

  @JsonIgnore
  public boolean getAmdDefined() {
    return amdDefined;
  }

  @JsonProperty(JSON_PROPERTY_AMD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAmd(SvamlActionConnectPstnAmdDto amd) {
    this.amd = amd;
    this.amdDefined = true;
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
    SvamlActionConnectPstnDto svamlActionConnectPstn = (SvamlActionConnectPstnDto) o;
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
    sb.append("class SvamlActionConnectPstnDto {\n");
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
}
