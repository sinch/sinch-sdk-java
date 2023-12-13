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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * Allows you to specify or override the final destination of the call. If the final destination of
 * the call is not dialed, this is a required parameter.
 */
@JsonPropertyOrder({
  SvamlActionConnectMxpDestinationDto.JSON_PROPERTY_TYPE,
  SvamlActionConnectMxpDestinationDto.JSON_PROPERTY_ENDPOINT
})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SvamlActionConnectMxpDestinationDto {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";
  private String endpoint;

  public SvamlActionConnectMxpDestinationDto() {}

  public SvamlActionConnectMxpDestinationDto type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The type of the definition.
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(String type) {
    this.type = type;
  }

  public SvamlActionConnectMxpDestinationDto endpoint(String endpoint) {
    this.endpoint = endpoint;
    return this;
  }

  /**
   * The phone number or username of the desired call destination.
   *
   * @return endpoint
   */
  @JsonProperty(JSON_PROPERTY_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getEndpoint() {
    return endpoint;
  }

  @JsonProperty(JSON_PROPERTY_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  /** Return true if this svaml_action_connectMxp_destination object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlActionConnectMxpDestinationDto svamlActionConnectMxpDestination =
        (SvamlActionConnectMxpDestinationDto) o;
    return Objects.equals(this.type, svamlActionConnectMxpDestination.type)
        && Objects.equals(this.endpoint, svamlActionConnectMxpDestination.endpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, endpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlActionConnectMxpDestinationDto {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
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