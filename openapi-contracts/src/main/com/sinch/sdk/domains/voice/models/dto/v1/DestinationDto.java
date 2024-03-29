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

/** The type of device and number or endpoint to call. */
@JsonPropertyOrder({DestinationDto.JSON_PROPERTY_TYPE, DestinationDto.JSON_PROPERTY_ENDPOINT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DestinationDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_TYPE = "type";
  private DestinationTypeDto type;
  private boolean typeDefined = false;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";
  private String endpoint;
  private boolean endpointDefined = false;

  public DestinationDto() {}

  public DestinationDto type(DestinationTypeDto type) {
    this.type = type;
    this.typeDefined = true;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public DestinationTypeDto getType() {
    return type;
  }

  @JsonIgnore
  public boolean getTypeDefined() {
    return typeDefined;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(DestinationTypeDto type) {
    this.type = type;
    this.typeDefined = true;
  }

  public DestinationDto endpoint(String endpoint) {
    this.endpoint = endpoint;
    this.endpointDefined = true;
    return this;
  }

  /**
   * If the type is &#x60;number&#x60; the value of the endpoint is a phone number. If the type is
   * &#x60;username&#x60; the value is the username for a data endpoint.
   *
   * @return endpoint
   */
  @JsonProperty(JSON_PROPERTY_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getEndpoint() {
    return endpoint;
  }

  @JsonIgnore
  public boolean getEndpointDefined() {
    return endpointDefined;
  }

  @JsonProperty(JSON_PROPERTY_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
    this.endpointDefined = true;
  }

  /** Return true if this destination object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinationDto destination = (DestinationDto) o;
    return Objects.equals(this.type, destination.type)
        && Objects.equals(this.endpoint, destination.endpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, endpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DestinationDto {\n");
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
