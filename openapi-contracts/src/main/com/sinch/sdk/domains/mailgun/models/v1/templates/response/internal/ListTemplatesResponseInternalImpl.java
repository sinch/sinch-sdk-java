package com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.mailgun.models.v1.response.internal.PagingResponse;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Template;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ListTemplatesResponseInternalImpl.JSON_PROPERTY_ITEMS,
  ListTemplatesResponseInternalImpl.JSON_PROPERTY_PAGING
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListTemplatesResponseInternalImpl implements ListTemplatesResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ITEMS = "items";

  private OptionalValue<List<Template>> items;

  public static final String JSON_PROPERTY_PAGING = "paging";

  private OptionalValue<PagingResponse> paging;

  public ListTemplatesResponseInternalImpl() {}

  protected ListTemplatesResponseInternalImpl(
      OptionalValue<List<Template>> items, OptionalValue<PagingResponse> paging) {
    this.items = items;
    this.paging = paging;
  }

  @JsonIgnore
  public List<Template> getItems() {
    return items.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<Template>> items() {
    return items;
  }

  @JsonIgnore
  public PagingResponse getPaging() {
    return paging.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAGING)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<PagingResponse> paging() {
    return paging;
  }

  /** Return true if this github.com-mailgun-temple-httpapi-getPageResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListTemplatesResponseInternalImpl githubComMailgunTempleHttpapiGetPageResponse =
        (ListTemplatesResponseInternalImpl) o;
    return Objects.equals(this.items, githubComMailgunTempleHttpapiGetPageResponse.items)
        && Objects.equals(this.paging, githubComMailgunTempleHttpapiGetPageResponse.paging);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, paging);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListTemplatesResponseInternalImpl {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    paging: ").append(toIndentedString(paging)).append("\n");
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
  static class Builder implements ListTemplatesResponseInternal.Builder {
    OptionalValue<List<Template>> items = OptionalValue.empty();
    OptionalValue<PagingResponse> paging = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ITEMS, required = true)
    public Builder setItems(List<Template> items) {
      this.items = OptionalValue.of(items);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_PAGING, required = true)
    public Builder setPaging(PagingResponse paging) {
      this.paging = OptionalValue.of(paging);
      return this;
    }

    public ListTemplatesResponseInternal build() {
      return new ListTemplatesResponseInternalImpl(items, paging);
    }
  }
}
