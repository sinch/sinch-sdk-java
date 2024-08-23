package com.sinch.sdk.domains.conversation.templates.models.v2.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({V2ListTemplatesResponseInternalImpl.JSON_PROPERTY_TEMPLATES})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class V2ListTemplatesResponseInternalImpl implements V2ListTemplatesResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEMPLATES = "templates";

  private OptionalValue<List<TemplateV2>> templates;

  public V2ListTemplatesResponseInternalImpl() {}

  protected V2ListTemplatesResponseInternalImpl(OptionalValue<List<TemplateV2>> templates) {
    this.templates = templates;
  }

  @JsonIgnore
  public List<TemplateV2> getTemplates() {
    return templates.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<TemplateV2>> templates() {
    return templates;
  }

  /** Return true if this v2ListTemplatesResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V2ListTemplatesResponseInternalImpl v2ListTemplatesResponse =
        (V2ListTemplatesResponseInternalImpl) o;
    return Objects.equals(this.templates, v2ListTemplatesResponse.templates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V2ListTemplatesResponseInternalImpl {\n");
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
  static class Builder implements V2ListTemplatesResponseInternal.Builder {
    OptionalValue<List<TemplateV2>> templates = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEMPLATES)
    public Builder setTemplates(List<TemplateV2> templates) {
      this.templates = OptionalValue.of(templates);
      return this;
    }

    public V2ListTemplatesResponseInternal build() {
      return new V2ListTemplatesResponseInternalImpl(templates);
    }
  }
}
