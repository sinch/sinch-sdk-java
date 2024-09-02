package com.sinch.sdk.domains.conversation.templates.models.v1.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateV1;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({V1ListTemplatesResponseInternalImpl.JSON_PROPERTY_TEMPLATES})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class V1ListTemplatesResponseInternalImpl implements V1ListTemplatesResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEMPLATES = "templates";

  private OptionalValue<List<TemplateV1>> templates;

  public V1ListTemplatesResponseInternalImpl() {}

  protected V1ListTemplatesResponseInternalImpl(OptionalValue<List<TemplateV1>> templates) {
    this.templates = templates;
  }

  @JsonIgnore
  public List<TemplateV1> getTemplates() {
    return templates.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<TemplateV1>> templates() {
    return templates;
  }

  /** Return true if this v1ListTemplatesResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ListTemplatesResponseInternalImpl v1ListTemplatesResponse =
        (V1ListTemplatesResponseInternalImpl) o;
    return Objects.equals(this.templates, v1ListTemplatesResponse.templates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ListTemplatesResponseInternalImpl {\n");
    sb.append("    templates: ").append(toIndentedString(templates)).append("\n");
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
  static class Builder implements V1ListTemplatesResponseInternal.Builder {
    OptionalValue<List<TemplateV1>> templates = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEMPLATES)
    public Builder setTemplates(List<TemplateV1> templates) {
      this.templates = OptionalValue.of(templates);
      return this;
    }

    public V1ListTemplatesResponseInternal build() {
      return new V1ListTemplatesResponseInternalImpl(templates);
    }
  }
}
