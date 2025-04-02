package com.sinch.sdk.domains.mailgun.models.v1.templates.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Template;
import java.util.Objects;

@JsonPropertyOrder({GetTemplateResponseInternalImpl.JSON_PROPERTY_TEMPLATE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GetTemplateResponseInternalImpl implements GetTemplateResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEMPLATE = "template";

  private OptionalValue<Template> template;

  public GetTemplateResponseInternalImpl() {}

  protected GetTemplateResponseInternalImpl(OptionalValue<Template> template) {
    this.template = template;
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

  /**
   * Return true if this github.com-mailgun-temple-httpapi-getTemplateOrVersionResponse object is
   * equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTemplateResponseInternalImpl githubComMailgunTempleHttpapiGetTemplateOrVersionResponse =
        (GetTemplateResponseInternalImpl) o;
    return Objects.equals(
        this.template, githubComMailgunTempleHttpapiGetTemplateOrVersionResponse.template);
  }

  @Override
  public int hashCode() {
    return Objects.hash(template);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTemplateResponseInternalImpl {\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
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
  static class Builder implements GetTemplateResponseInternal.Builder {
    OptionalValue<Template> template = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TEMPLATE, required = true)
    public Builder setTemplate(Template template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    public GetTemplateResponseInternal build() {
      return new GetTemplateResponseInternalImpl(template);
    }
  }
}
