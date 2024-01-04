/*
 * API Overview | Sinch
 * Sinch SMS API is one of the easiest APIs we offer and enables you to add fast and reliable global SMS to your applications. Send single messages, scheduled batch messages, use available message templates and more.
 *
 * The version of the OpenAPI document: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * The name of the parameter that will be replaced in the message body. Letters A-Z and a-z, digits
 * 0-9 and .-_ allowed.
 */
@JsonPropertyOrder({
  ParameterObjParameterKeyDto.JSON_PROPERTY_LEFT_CURLY_BRACKET_MSISDN_RIGHT_CURLY_BRACKET,
  ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ParameterObjParameterKeyDto {
  public static final String JSON_PROPERTY_LEFT_CURLY_BRACKET_MSISDN_RIGHT_CURLY_BRACKET =
      "{msisdn}";
  private String leftCurlyBracketMsisdnRightCurlyBracket;
  private boolean leftCurlyBracketMsisdnRightCurlyBracketDefined = false;

  public static final String JSON_PROPERTY_DEFAULT = "default";
  private String _default;
  private boolean _defaultDefined = false;

  public ParameterObjParameterKeyDto() {}

  public ParameterObjParameterKeyDto leftCurlyBracketMsisdnRightCurlyBracket(
      String leftCurlyBracketMsisdnRightCurlyBracket) {
    this.leftCurlyBracketMsisdnRightCurlyBracket = leftCurlyBracketMsisdnRightCurlyBracket;
    this.leftCurlyBracketMsisdnRightCurlyBracketDefined = true;
    return this;
  }

  /**
   * The key is the recipient that should have the &#x60;parameter_key&#x60; replaced with the value
   *
   * @return leftCurlyBracketMsisdnRightCurlyBracket
   */
  @JsonProperty(JSON_PROPERTY_LEFT_CURLY_BRACKET_MSISDN_RIGHT_CURLY_BRACKET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLeftCurlyBracketMsisdnRightCurlyBracket() {
    return leftCurlyBracketMsisdnRightCurlyBracket;
  }

  @JsonIgnore
  public boolean getLeftCurlyBracketMsisdnRightCurlyBracketDefined() {
    return leftCurlyBracketMsisdnRightCurlyBracketDefined;
  }

  @JsonProperty(JSON_PROPERTY_LEFT_CURLY_BRACKET_MSISDN_RIGHT_CURLY_BRACKET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLeftCurlyBracketMsisdnRightCurlyBracket(
      String leftCurlyBracketMsisdnRightCurlyBracket) {
    this.leftCurlyBracketMsisdnRightCurlyBracket = leftCurlyBracketMsisdnRightCurlyBracket;
    this.leftCurlyBracketMsisdnRightCurlyBracketDefined = true;
  }

  public ParameterObjParameterKeyDto _default(String _default) {
    this._default = _default;
    this._defaultDefined = true;
    return this;
  }

  /**
   * The fall-back value for omitted recipient phone numbers &lt;a
   * href&#x3D;\&quot;https://community.sinch.com/t5/Glossary/MSISDN/ta-p/7628\&quot;
   * target&#x3D;\&quot;_blank\&quot;&gt;MSISDNs&lt;/a&gt;.
   *
   * @return _default
   */
  @JsonProperty(JSON_PROPERTY_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDefault() {
    return _default;
  }

  @JsonIgnore
  public boolean getDefaultDefined() {
    return _defaultDefined;
  }

  @JsonProperty(JSON_PROPERTY_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDefault(String _default) {
    this._default = _default;
    this._defaultDefined = true;
  }

  /** Return true if this parameterObj__parameter_key_ object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParameterObjParameterKeyDto parameterObjParameterKey = (ParameterObjParameterKeyDto) o;
    return Objects.equals(
            this.leftCurlyBracketMsisdnRightCurlyBracket,
            parameterObjParameterKey.leftCurlyBracketMsisdnRightCurlyBracket)
        && Objects.equals(this._default, parameterObjParameterKey._default);
  }

  @Override
  public int hashCode() {
    return Objects.hash(leftCurlyBracketMsisdnRightCurlyBracket, _default);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParameterObjParameterKeyDto {\n");
    sb.append("    leftCurlyBracketMsisdnRightCurlyBracket: ")
        .append(toIndentedString(leftCurlyBracketMsisdnRightCurlyBracket))
        .append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
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
