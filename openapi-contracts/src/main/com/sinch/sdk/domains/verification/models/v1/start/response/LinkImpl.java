package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  LinkImpl.JSON_PROPERTY_REL,
  LinkImpl.JSON_PROPERTY_HREF,
  LinkImpl.JSON_PROPERTY_METHOD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LinkImpl implements Link {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REL = "rel";

  private OptionalValue<String> rel;

  public static final String JSON_PROPERTY_HREF = "href";

  private OptionalValue<String> href;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<String> method;

  public LinkImpl() {}

  protected LinkImpl(
      OptionalValue<String> rel, OptionalValue<String> href, OptionalValue<String> method) {
    this.rel = rel;
    this.href = href;
    this.method = method;
  }

  @JsonIgnore
  public String getRel() {
    return rel.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> rel() {
    return rel;
  }

  @JsonIgnore
  public String getHref() {
    return href.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HREF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> href() {
    return href;
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

  /** Return true if this Links object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinkImpl links = (LinkImpl) o;
    return Objects.equals(this.rel, links.rel)
        && Objects.equals(this.href, links.href)
        && Objects.equals(this.method, links.method);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rel, href, method);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LinkImpl {\n");
    sb.append("    rel: ").append(toIndentedString(rel)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
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
  static class Builder implements Link.Builder {
    OptionalValue<String> rel = OptionalValue.empty();
    OptionalValue<String> href = OptionalValue.empty();
    OptionalValue<String> method = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_REL)
    public Builder setRel(String rel) {
      this.rel = OptionalValue.of(rel);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_HREF)
    public Builder setHref(String href) {
      this.href = OptionalValue.of(href);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METHOD)
    public Builder setMethod(String method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    public Link build() {
      return new LinkImpl(rel, href, method);
    }
  }
}
