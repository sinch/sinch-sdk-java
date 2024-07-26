package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.TemplateReference;
import java.util.Objects;

@JsonPropertyOrder({TemplateReferenceFieldInternalImpl.JSON_PROPERTY_TEMPLATE_REFERENCE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateReferenceFieldInternalImpl implements TemplateReferenceFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEMPLATE_REFERENCE = "template_reference";

  private OptionalValue<TemplateReference> templateReference;

  public TemplateReferenceFieldInternalImpl() {}

  protected TemplateReferenceFieldInternalImpl(OptionalValue<TemplateReference> templateReference) {
    this.templateReference = templateReference;
  }

  @JsonIgnore
  public TemplateReference getTemplateReference() {
    return templateReference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TemplateReference> templateReference() {
    return templateReference;
  }

  /** Return true if this TemplateReferenceField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateReferenceFieldInternalImpl templateReferenceField =
        (TemplateReferenceFieldInternalImpl) o;
    return Objects.equals(this.templateReference, templateReferenceField.templateReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templateReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateReferenceFieldInternalImpl {\n");
    sb.append("    templateReference: ").append(toIndentedString(templateReference)).append("\n");
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
  static class Builder implements TemplateReferenceFieldInternal.Builder {
    OptionalValue<TemplateReference> templateReference = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEMPLATE_REFERENCE)
    public Builder setTemplateReference(TemplateReference templateReference) {
      this.templateReference = OptionalValue.of(templateReference);
      return this;
    }

    public TemplateReferenceFieldInternal build() {
      return new TemplateReferenceFieldInternalImpl(templateReference);
    }
  }
}
