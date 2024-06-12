package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.StartVerificationResponseDataContent;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationResponseDataImpl.JSON_PROPERTY_ID,
  StartVerificationResponseDataImpl.JSON_PROPERTY_METHOD,
  StartVerificationResponseDataImpl.JSON_PROPERTY_LINKS,
  StartVerificationResponseDataImpl.JSON_PROPERTY_SEAMLESS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationResponseDataImpl
    implements StartVerificationResponseData,
        com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_LINKS = "_links";

  private OptionalValue<List<Link>> links;

  public static final String JSON_PROPERTY_SEAMLESS = "seamless";

  private OptionalValue<StartVerificationResponseDataContent> seamless;

  public StartVerificationResponseDataImpl() {}

  protected StartVerificationResponseDataImpl(
      OptionalValue<String> id,
      OptionalValue<VerificationMethod> method,
      OptionalValue<List<Link>> links,
      OptionalValue<StartVerificationResponseDataContent> seamless) {
    this.id = id;
    this.method = method;
    this.links = links;
    this.seamless = seamless;
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
  public VerificationMethod getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethod> method() {
    return method;
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

  @JsonIgnore
  public StartVerificationResponseDataContent getSeamless() {
    return seamless.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SEAMLESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationResponseDataContent> seamless() {
    return seamless;
  }

  @JsonIgnore
  public String getTargetUri() {
    if (null == seamless || !seamless.isPresent() || null == seamless.get().getTargetUri()) {
      return null;
    }
    return seamless.get().getTargetUri();
  }

  public OptionalValue<String> targetUri() {
    return null != seamless
        ? seamless.map(StartVerificationResponseDataContent::getTargetUri)
        : OptionalValue.empty();
  }

  /** Return true if this StartVerificationDataResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationResponseDataImpl startVerificationDataResponse =
        (StartVerificationResponseDataImpl) o;
    return Objects.equals(this.id, startVerificationDataResponse.id)
        && Objects.equals(this.method, startVerificationDataResponse.method)
        && Objects.equals(this.links, startVerificationDataResponse.links)
        && Objects.equals(this.seamless, startVerificationDataResponse.seamless);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, links, seamless);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationResponseDataImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    seamless: ").append(toIndentedString(seamless)).append("\n");
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
  static class Builder implements StartVerificationResponseData.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.SEAMLESS);
    OptionalValue<List<Link>> links = OptionalValue.empty();
    OptionalValue<StartVerificationResponseDataContent> seamless = OptionalValue.empty();

    StartVerificationResponseDataContent.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    public Builder setLinks(List<Link> links) {
      this.links = OptionalValue.of(links);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SEAMLESS)
    public Builder setSeamless(StartVerificationResponseDataContent seamless) {
      this.seamless = OptionalValue.of(seamless);
      return this;
    }

    @JsonIgnore
    public Builder setTargetUri(String targetUri) {
      getDelegatedBuilder().setTargetUri(targetUri);
      return this;
    }

    private StartVerificationResponseDataContent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = StartVerificationResponseDataContent.builder();
      }
      return this._delegatedBuilder;
    }

    public StartVerificationResponseData build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.seamless = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new StartVerificationResponseDataImpl(id, method, links, seamless);
    }
  }
}
