package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationResponseSeamlessImpl.JSON_PROPERTY_ID,
  StartVerificationResponseSeamlessImpl.JSON_PROPERTY_METHOD,
  StartVerificationResponseSeamlessImpl.JSON_PROPERTY_SEAMLESS,
  StartVerificationResponseSeamlessImpl.JSON_PROPERTY_LINKS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationResponseSeamlessImpl
    implements StartVerificationResponseSeamless,
        com.sinch.sdk.domains.verification.models.v1.response.StartVerificationResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<String> method;

  public static final String JSON_PROPERTY_SEAMLESS = "seamless";

  private OptionalValue<StartVerificationResponseSeamlessContent> seamless;

  public static final String JSON_PROPERTY_LINKS = "_links";

  private OptionalValue<List<Link>> links;

  public StartVerificationResponseSeamlessImpl() {}

  protected StartVerificationResponseSeamlessImpl(
      OptionalValue<String> id,
      OptionalValue<String> method,
      OptionalValue<StartVerificationResponseSeamlessContent> seamless,
      OptionalValue<List<Link>> links) {
    this.id = id;
    this.method = method;
    this.seamless = seamless;
    this.links = links;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public String getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> method() {
    return method;
  }

  @JsonIgnore
  public StartVerificationResponseSeamlessContent getSeamless() {
    return seamless.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SEAMLESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationResponseSeamlessContent> seamless() {
    return seamless;
  }

  @JsonIgnore
  public List<Link> getLinks() {
    return links.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Link>> links() {
    return links;
  }

  /** Return true if this DataInitiateVerificationResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationResponseSeamlessImpl dataInitiateVerificationResponse =
        (StartVerificationResponseSeamlessImpl) o;
    return Objects.equals(this.id, dataInitiateVerificationResponse.id)
        && Objects.equals(this.method, dataInitiateVerificationResponse.method)
        && Objects.equals(this.seamless, dataInitiateVerificationResponse.seamless)
        && Objects.equals(this.links, dataInitiateVerificationResponse.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, seamless, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationResponseSeamlessImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    seamless: ").append(toIndentedString(seamless)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
  static class Builder implements StartVerificationResponseSeamless.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> method = OptionalValue.empty();
    OptionalValue<StartVerificationResponseSeamlessContent> seamless = OptionalValue.empty();
    OptionalValue<List<Link>> links = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METHOD)
    public Builder setMethod(String method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SEAMLESS)
    public Builder setSeamless(StartVerificationResponseSeamlessContent seamless) {
      this.seamless = OptionalValue.of(seamless);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    public Builder setLinks(List<Link> links) {
      this.links = OptionalValue.of(links);
      return this;
    }

    public StartVerificationResponseSeamless build() {
      return new StartVerificationResponseSeamlessImpl(id, method, seamless, links);
    }
  }
}
