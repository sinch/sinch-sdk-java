/*
 * Numbers | Sinch
 * An API service for getting, listing and managing Sinch virtual numbers.
 *
 * The version of the OpenAPI document: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** RentAnyNumberRequestVoiceConfigurationDto */
@JsonPropertyOrder({RentAnyNumberRequestVoiceConfigurationDto.JSON_PROPERTY_APP_ID})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RentAnyNumberRequestVoiceConfigurationDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_APP_ID = "appId";
  private String appId;
  private boolean appIdDefined = false;

  public RentAnyNumberRequestVoiceConfigurationDto() {}

  public RentAnyNumberRequestVoiceConfigurationDto appId(String appId) {
    this.appId = appId;
    this.appIdDefined = true;
    return this;
  }

  /**
   * Your app ID for the Voice API. The &#x60;appId&#x60; can be found in your &lt;a
   * href&#x3D;\&quot;https://dashboard.sinch.com/voice/apps\&quot;
   * target&#x3D;\&quot;_blank\&quot;&gt;Sinch Customer Dashboard&lt;/a&gt; under Voice, then apps.
   *
   * @return appId
   */
  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getAppId() {
    return appId;
  }

  @JsonIgnore
  public boolean getAppIdDefined() {
    return appIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAppId(String appId) {
    this.appId = appId;
    this.appIdDefined = true;
  }

  /** Return true if this RentAnyNumberRequest_voiceConfiguration object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RentAnyNumberRequestVoiceConfigurationDto rentAnyNumberRequestVoiceConfiguration =
        (RentAnyNumberRequestVoiceConfigurationDto) o;
    return Objects.equals(this.appId, rentAnyNumberRequestVoiceConfiguration.appId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RentAnyNumberRequestVoiceConfigurationDto {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
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
