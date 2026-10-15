package com.sinch.sdk.domains.voice.models.v2.services.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.PaginationLinks;
import com.sinch.sdk.domains.voice.models.v2.PaginationMeta;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceShortResponse;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ServicesListResponseInternalImpl.JSON_PROPERTY_SERVICES,
  ServicesListResponseInternalImpl.JSON_PROPERTY_LINKS,
  ServicesListResponseInternalImpl.JSON_PROPERTY_META
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ServicesListResponseInternalImpl implements ServicesListResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SERVICES = "services";

  private OptionalValue<List<ServiceShortResponse>> services;

  public static final String JSON_PROPERTY_LINKS = "links";

  private OptionalValue<PaginationLinks> links;

  public static final String JSON_PROPERTY_META = "meta";

  private OptionalValue<PaginationMeta> meta;

  public ServicesListResponseInternalImpl() {}

  protected ServicesListResponseInternalImpl(
      OptionalValue<List<ServiceShortResponse>> services,
      OptionalValue<PaginationLinks> links,
      OptionalValue<PaginationMeta> meta) {
    this.services = services;
    this.links = links;
    this.meta = meta;
  }

  @JsonIgnore
  public List<ServiceShortResponse> getServices() {
    return services.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SERVICES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<ServiceShortResponse>> services() {
    return services;
  }

  @JsonIgnore
  public PaginationLinks getLinks() {
    return links.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<PaginationLinks> links() {
    return links;
  }

  @JsonIgnore
  public PaginationMeta getMeta() {
    return meta.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_META)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<PaginationMeta> meta() {
    return meta;
  }

  /** Return true if this ServicesListResponseInternal object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServicesListResponseInternalImpl servicesListResponseInternal =
        (ServicesListResponseInternalImpl) o;
    return Objects.equals(this.services, servicesListResponseInternal.services)
        && Objects.equals(this.links, servicesListResponseInternal.links)
        && Objects.equals(this.meta, servicesListResponseInternal.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(services, links, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServicesListResponseInternalImpl {\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
  static class Builder implements ServicesListResponseInternal.Builder {
    OptionalValue<List<ServiceShortResponse>> services = OptionalValue.empty();
    OptionalValue<PaginationLinks> links = OptionalValue.empty();
    OptionalValue<PaginationMeta> meta = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_SERVICES, required = true)
    public Builder setServices(List<ServiceShortResponse> services) {
      this.services = OptionalValue.of(services);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_LINKS, required = true)
    public Builder setLinks(PaginationLinks links) {
      this.links = OptionalValue.of(links);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_META, required = true)
    public Builder setMeta(PaginationMeta meta) {
      this.meta = OptionalValue.of(meta);
      return this;
    }

    public ServicesListResponseInternal build() {
      return new ServicesListResponseInternalImpl(services, links, meta);
    }
  }
}
