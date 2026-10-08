package com.sinch.sdk.domains.voice.models.v2.calls.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.Call;
import com.sinch.sdk.domains.voice.models.v2.PaginationLinks;
import com.sinch.sdk.domains.voice.models.v2.PaginationMeta;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  CallsListResponseInternalImpl.JSON_PROPERTY_CALLS,
  CallsListResponseInternalImpl.JSON_PROPERTY_LINKS,
  CallsListResponseInternalImpl.JSON_PROPERTY_META
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallsListResponseInternalImpl implements CallsListResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CALLS = "calls";

  private OptionalValue<List<Call>> calls;

  public static final String JSON_PROPERTY_LINKS = "links";

  private OptionalValue<PaginationLinks> links;

  public static final String JSON_PROPERTY_META = "meta";

  private OptionalValue<PaginationMeta> meta;

  public CallsListResponseInternalImpl() {}

  protected CallsListResponseInternalImpl(
      OptionalValue<List<Call>> calls,
      OptionalValue<PaginationLinks> links,
      OptionalValue<PaginationMeta> meta) {
    this.calls = calls;
    this.links = links;
    this.meta = meta;
  }

  @JsonIgnore
  public List<Call> getCalls() {
    return calls.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<Call>> calls() {
    return calls;
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

  /** Return true if this CallsListResponseInternal object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallsListResponseInternalImpl callsListResponseInternal = (CallsListResponseInternalImpl) o;
    return Objects.equals(this.calls, callsListResponseInternal.calls)
        && Objects.equals(this.links, callsListResponseInternal.links)
        && Objects.equals(this.meta, callsListResponseInternal.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(calls, links, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallsListResponseInternalImpl {\n");
    sb.append("    calls: ").append(toIndentedString(calls)).append("\n");
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
  static class Builder implements CallsListResponseInternal.Builder {
    OptionalValue<List<Call>> calls = OptionalValue.empty();
    OptionalValue<PaginationLinks> links = OptionalValue.empty();
    OptionalValue<PaginationMeta> meta = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CALLS, required = true)
    public Builder setCalls(List<Call> calls) {
      this.calls = OptionalValue.of(calls);
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

    public CallsListResponseInternal build() {
      return new CallsListResponseInternalImpl(calls, links, meta);
    }
  }
}
