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
 * The custom callout, the server initiates a call from the servers that can be controlled by
 * specifying how the call should progress at each call event.
 */
@JsonPropertyOrder({
  CustomCalloutRequestDto.JSON_PROPERTY_CLI,
  CustomCalloutRequestDto.JSON_PROPERTY_DESTINATION,
  CustomCalloutRequestDto.JSON_PROPERTY_DTMF,
  CustomCalloutRequestDto.JSON_PROPERTY_CUSTOM,
  CustomCalloutRequestDto.JSON_PROPERTY_MAX_DURATION,
  CustomCalloutRequestDto.JSON_PROPERTY_ICE,
  CustomCalloutRequestDto.JSON_PROPERTY_ACE,
  CustomCalloutRequestDto.JSON_PROPERTY_PIE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CustomCalloutRequestDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_CLI = "cli";
  private String cli;
  private boolean cliDefined = false;

  public static final String JSON_PROPERTY_DESTINATION = "destination";
  private DestinationDto destination;
  private boolean destinationDefined = false;

  public static final String JSON_PROPERTY_DTMF = "dtmf";
  private String dtmf;
  private boolean dtmfDefined = false;

  public static final String JSON_PROPERTY_CUSTOM = "custom";
  private String custom;
  private boolean customDefined = false;

  public static final String JSON_PROPERTY_MAX_DURATION = "maxDuration";
  private Integer maxDuration;
  private boolean maxDurationDefined = false;

  public static final String JSON_PROPERTY_ICE = "ice";
  private String ice;
  private boolean iceDefined = false;

  public static final String JSON_PROPERTY_ACE = "ace";
  private String ace;
  private boolean aceDefined = false;

  public static final String JSON_PROPERTY_PIE = "pie";
  private String pie;
  private boolean pieDefined = false;

  public CustomCalloutRequestDto() {}

  public CustomCalloutRequestDto cli(String cli) {
    this.cli = cli;
    this.cliDefined = true;
    return this;
  }

  /**
   * The number that will be displayed as the incoming caller, to set your own CLI, you may use your
   * verified number or your Dashboard virtual number, it must be in
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

  public CustomCalloutRequestDto destination(DestinationDto destination) {
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
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public DestinationDto getDestination() {
    return destination;
  }

  @JsonIgnore
  public boolean getDestinationDefined() {
    return destinationDefined;
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDestination(DestinationDto destination) {
    this.destination = destination;
    this.destinationDefined = true;
  }

  public CustomCalloutRequestDto dtmf(String dtmf) {
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

  public CustomCalloutRequestDto custom(String custom) {
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

  public CustomCalloutRequestDto maxDuration(Integer maxDuration) {
    this.maxDuration = maxDuration;
    this.maxDurationDefined = true;
    return this;
  }

  /**
   * The maximum amount of time in seconds that the call will last.
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

  public CustomCalloutRequestDto ice(String ice) {
    this.ice = ice;
    this.iceDefined = true;
    return this;
  }

  /**
   * You can use inline [SVAML](../../../svaml/) to replace a callback URL when using custom
   * callouts. Ensure that the JSON object is escaped correctly. If inline ICE SVAML is passed,
   * exclude *cli* and *destination* properties from the *customCallout* request body. Example:
   * &#x60;&#x60;&#x60;\&quot;{\\\&quot;action\\\&quot;:{\\\&quot;name\\\&quot;:\\\&quot;connectPstn\\\&quot;,\\\&quot;number\\\&quot;:\\\&quot;46000000001\\\&quot;,\\\&quot;maxDuration\\\&quot;:90}}\&quot;&#x60;&#x60;&#x60;
   *
   * @return ice
   */
  @JsonProperty(JSON_PROPERTY_ICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getIce() {
    return ice;
  }

  @JsonIgnore
  public boolean getIceDefined() {
    return iceDefined;
  }

  @JsonProperty(JSON_PROPERTY_ICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIce(String ice) {
    this.ice = ice;
    this.iceDefined = true;
  }

  public CustomCalloutRequestDto ace(String ace) {
    this.ace = ace;
    this.aceDefined = true;
    return this;
  }

  /**
   * You can use inline [SVAML](../../../svaml/) to replace a callback URL when using custom
   * callouts. Ensure that the JSON object is escaped correctly. Example:
   * &#x60;&#x60;&#x60;\&quot;{\\\&quot;action\\\&quot;: {\\\&quot;name\\\&quot;:
   * \\\&quot;RunMenu\\\&quot;,\\\&quot;locale\\\&quot;:
   * \\\&quot;en-US\\\&quot;,\\\&quot;menus\\\&quot;: [{\\\&quot;id\\\&quot;:
   * \\\&quot;main\\\&quot;,\\\&quot;mainPrompt\\\&quot;: \\\&quot;#tts[ Welcome to the main menu.
   * Press 1 for a callback or 2 for a
   * cancel&lt;/speak&gt;]\\\&quot;,\\\&quot;timeoutMills\\\&quot;: 5000,\\\&quot;options\\\&quot;:
   * [ {\\\&quot;dtmf\\\&quot;: \\\&quot;1\\\&quot;,\\\&quot;action\\\&quot;:
   * \\\&quot;return(callback)\\\&quot;}, {\\\&quot;dtmf\\\&quot;:
   * \\\&quot;2\\\&quot;,\\\&quot;action\\\&quot;:
   * \\\&quot;return(cancel)\\\&quot;}]}]}}\&quot;&#x60;&#x60;&#x60;
   *
   * @return ace
   */
  @JsonProperty(JSON_PROPERTY_ACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAce() {
    return ace;
  }

  @JsonIgnore
  public boolean getAceDefined() {
    return aceDefined;
  }

  @JsonProperty(JSON_PROPERTY_ACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAce(String ace) {
    this.ace = ace;
    this.aceDefined = true;
  }

  public CustomCalloutRequestDto pie(String pie) {
    this.pie = pie;
    this.pieDefined = true;
    return this;
  }

  /**
   * &lt;b&gt;Note:&lt;/b&gt; PIE callbacks are not available for DATA Calls; only PSTN and SIP
   * calls. You can use inline [SVAML](../../../svaml/) to replace a callback URL when using custom
   * callouts. Ensure that the JSON object is escaped correctly. A PIE event will contain a value
   * chosen from an IVR choice. Usually a PIE event wil contain a URL to a callback sever that will
   * receive the choice and be able to parse it. This could result in further SVAML or some other
   * application logic function. Example:
   * &#x60;&#x60;&#x60;\&quot;https://your-application-server-host/application\&quot;&#x60;&#x60;&#x60;
   *
   * @return pie
   */
  @JsonProperty(JSON_PROPERTY_PIE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPie() {
    return pie;
  }

  @JsonIgnore
  public boolean getPieDefined() {
    return pieDefined;
  }

  @JsonProperty(JSON_PROPERTY_PIE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPie(String pie) {
    this.pie = pie;
    this.pieDefined = true;
  }

  /** Return true if this customCalloutRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomCalloutRequestDto customCalloutRequest = (CustomCalloutRequestDto) o;
    return Objects.equals(this.cli, customCalloutRequest.cli)
        && Objects.equals(this.destination, customCalloutRequest.destination)
        && Objects.equals(this.dtmf, customCalloutRequest.dtmf)
        && Objects.equals(this.custom, customCalloutRequest.custom)
        && Objects.equals(this.maxDuration, customCalloutRequest.maxDuration)
        && Objects.equals(this.ice, customCalloutRequest.ice)
        && Objects.equals(this.ace, customCalloutRequest.ace)
        && Objects.equals(this.pie, customCalloutRequest.pie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cli, destination, dtmf, custom, maxDuration, ice, ace, pie);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomCalloutRequestDto {\n");
    sb.append("    cli: ").append(toIndentedString(cli)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    dtmf: ").append(toIndentedString(dtmf)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    maxDuration: ").append(toIndentedString(maxDuration)).append("\n");
    sb.append("    ice: ").append(toIndentedString(ice)).append("\n");
    sb.append("    ace: ").append(toIndentedString(ace)).append("\n");
    sb.append("    pie: ").append(toIndentedString(pie)).append("\n");
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
