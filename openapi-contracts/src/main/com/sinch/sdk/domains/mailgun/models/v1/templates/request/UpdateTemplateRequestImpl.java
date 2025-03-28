package com.sinch.sdk.domains.mailgun.models.v1.templates.request;

import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class UpdateTemplateRequestImpl implements UpdateTemplateRequest {
  private static final long serialVersionUID = 1L;

  public static final String PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public UpdateTemplateRequestImpl() {}

  protected UpdateTemplateRequestImpl(OptionalValue<String> description) {
    this.description = description;
  }

  public String getDescription() {
    return description.orElse(null);
  }

  @Property(PROPERTY_DESCRIPTION)
  public OptionalValue<String> description() {
    return description;
  }

  /**
   * Return true if this PUT-v3-domain_name-templates-template_name-multipart-form-data-RequestBody
   * object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateTemplateRequestImpl puTV3DomainNameTemplatesTemplateNameMultipartFormDataRequestBody =
        (UpdateTemplateRequestImpl) o;
    return Objects.equals(
        this.description,
        puTV3DomainNameTemplatesTemplateNameMultipartFormDataRequestBody.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateTemplateRequestImpl {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

  static class Builder implements UpdateTemplateRequest.Builder {
    OptionalValue<String> description = OptionalValue.empty();

    @Property(value = PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    public UpdateTemplateRequest build() {
      return new UpdateTemplateRequestImpl(description);
    }
  }
}
