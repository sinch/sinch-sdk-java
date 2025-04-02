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
import java.util.Objects;

@JsonPropertyOrder({
  ListVersionResponseInternalImpl.JSON_PROPERTY_TEMPLATE,
  ListVersionResponseInternalImpl.JSON_PROPERTY_PAGING
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListVersionResponseInternalImpl implements ListVersionResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEMPLATE = "template";

  private OptionalValue<Template> template;

  public static final String JSON_PROPERTY_PAGING = "paging";

  private OptionalValue<PagingResponse> paging;

  public ListVersionResponseInternalImpl() {}

  protected ListVersionResponseInternalImpl(
      OptionalValue<Template> template, OptionalValue<PagingResponse> paging) {
    this.template = template;
    this.paging = paging;
  }

  @JsonIgnore
  public Template getTemplate() {
    return template.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Template> template() {
    return template;
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

  /**
   * Return true if this github.com-mailgun-temple-httpapi-getVersionsPageResponse object is equal
   * to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListVersionResponseInternalImpl githubComMailgunTempleHttpapiGetVersionsPageResponse =
        (ListVersionResponseInternalImpl) o;
    return Objects.equals(
            this.template, githubComMailgunTempleHttpapiGetVersionsPageResponse.template)
        && Objects.equals(this.paging, githubComMailgunTempleHttpapiGetVersionsPageResponse.paging);
  }

  @Override
  public int hashCode() {
    return Objects.hash(template, paging);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListVersionResponseInternalImpl {\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
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
  static class Builder implements ListVersionResponseInternal.Builder {
    OptionalValue<Template> template = OptionalValue.empty();
    OptionalValue<PagingResponse> paging = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TEMPLATE, required = true)
    public Builder setTemplate(Template template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_PAGING, required = true)
    public Builder setPaging(PagingResponse paging) {
      this.paging = OptionalValue.of(paging);
      return this;
    }

    public ListVersionResponseInternal build() {
      return new ListVersionResponseInternalImpl(template, paging);
    }
  }
}
