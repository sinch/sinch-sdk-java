package com.sinch.sdk.domains.voice.models.v2.services;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  EventDestinationConfigurationImpl.JSON_PROPERTY_URL,
  EventDestinationConfigurationImpl.JSON_PROPERTY_FALLBACK_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EventDestinationConfigurationImpl implements EventDestinationConfiguration {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public static final String JSON_PROPERTY_FALLBACK_URL = "fallbackUrl";

  private OptionalValue<String> fallbackUrl;

  public EventDestinationConfigurationImpl() {}

  protected EventDestinationConfigurationImpl(
      OptionalValue<String> url, OptionalValue<String> fallbackUrl) {
    this.url = url;
    this.fallbackUrl = fallbackUrl;
  }

  @JsonIgnore
  public String getUrl() {
    return url.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> url() {
    return url;
  }

  @JsonIgnore
  public String getFallbackUrl() {
    return fallbackUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> fallbackUrl() {
    return fallbackUrl;
  }

  /** Return true if this EventDestinationConfiguration object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventDestinationConfigurationImpl eventDestinationConfiguration =
        (EventDestinationConfigurationImpl) o;
    return Objects.equals(this.url, eventDestinationConfiguration.url)
        && Objects.equals(this.fallbackUrl, eventDestinationConfiguration.fallbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, fallbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventDestinationConfigurationImpl {\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    fallbackUrl: ").append(toIndentedString(fallbackUrl)).append("\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements EventDestinationConfiguration.Builder {
    OptionalValue<String> url = OptionalValue.empty();
    OptionalValue<String> fallbackUrl = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_URL, required = true)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FALLBACK_URL)
    public Builder setFallbackUrl(String fallbackUrl) {
      this.fallbackUrl = OptionalValue.of(fallbackUrl);
      return this;
    }

    public EventDestinationConfiguration build() {
      return new EventDestinationConfigurationImpl(url, fallbackUrl);
    }
  }
}
