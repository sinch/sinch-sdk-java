package com.sinch.sdk.domains.mailgun.models.v1.templates.request;

import com.sinch.sdk.core.databind.annotation.FormSerialize;
import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.Pair;
import java.util.Collection;
import java.util.Objects;

public class UpdateVersionRequestImpl implements UpdateVersionRequest {
  private static final long serialVersionUID = 1L;

  public static final String PROPERTY_TEMPLATE = "template";

  private OptionalValue<String> template;

  public static final String PROPERTY_COMMENT = "comment";

  private OptionalValue<String> comment;

  public static final String PROPERTY_ACTIVE = "active";

  private OptionalValue<Boolean> active;

  public static final String PROPERTY_HEADERS = "headers";

  private OptionalValue<Collection<Pair<String, String>>> headers;

  public UpdateVersionRequestImpl() {}

  protected UpdateVersionRequestImpl(
      OptionalValue<String> template,
      OptionalValue<String> comment,
      OptionalValue<Boolean> active,
      OptionalValue<Collection<Pair<String, String>>> headers) {
    this.template = template;
    this.comment = comment;
    this.active = active;
    this.headers = headers;
  }

  public String getTemplate() {
    return template.orElse(null);
  }

  @Property(PROPERTY_TEMPLATE)
  public OptionalValue<String> template() {
    return template;
  }

  public String getComment() {
    return comment.orElse(null);
  }

  @Property(PROPERTY_COMMENT)
  public OptionalValue<String> comment() {
    return comment;
  }

  public Boolean getActive() {
    return active.orElse(null);
  }

  @Property(PROPERTY_ACTIVE)
  @FormSerialize(using = com.sinch.sdk.domains.mailgun.api.v1.adapters.BooleanFormSerializer.class)
  public OptionalValue<Boolean> active() {
    return active;
  }

  public Collection<Pair<String, String>> getHeaders() {
    return headers.orElse(null);
  }

  @Property(PROPERTY_HEADERS)
  @FormSerialize(
      using = com.sinch.sdk.domains.mailgun.api.v1.adapters.ListOfPairFormSerializer.class)
  public OptionalValue<Collection<Pair<String, String>>> headers() {
    return headers;
  }

  /**
   * Return true if this
   * PUT-v3-domain_name-templates-template_name-versions-version_name-multipart-form-data-RequestBody
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
    UpdateVersionRequestImpl
        puTV3DomainNameTemplatesTemplateNameVersionsVersionNameMultipartFormDataRequestBody =
            (UpdateVersionRequestImpl) o;
    return Objects.equals(
            this.template,
            puTV3DomainNameTemplatesTemplateNameVersionsVersionNameMultipartFormDataRequestBody
                .template)
        && Objects.equals(
            this.comment,
            puTV3DomainNameTemplatesTemplateNameVersionsVersionNameMultipartFormDataRequestBody
                .comment)
        && Objects.equals(
            this.active,
            puTV3DomainNameTemplatesTemplateNameVersionsVersionNameMultipartFormDataRequestBody
                .active)
        && Objects.equals(
            this.headers,
            puTV3DomainNameTemplatesTemplateNameVersionsVersionNameMultipartFormDataRequestBody
                .headers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(template, comment, active, headers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateVersionRequestImpl {\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
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

  static class Builder implements UpdateVersionRequest.Builder {
    OptionalValue<String> template = OptionalValue.empty();
    OptionalValue<String> comment = OptionalValue.empty();
    OptionalValue<Boolean> active = OptionalValue.empty();
    OptionalValue<Collection<Pair<String, String>>> headers = OptionalValue.empty();

    @Property(value = PROPERTY_TEMPLATE)
    public Builder setTemplate(String template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    @Property(value = PROPERTY_COMMENT)
    public Builder setComment(String comment) {
      this.comment = OptionalValue.of(comment);
      return this;
    }

    @Property(value = PROPERTY_ACTIVE)
    public Builder setActive(Boolean active) {
      this.active = OptionalValue.of(active);
      return this;
    }

    @Property(value = PROPERTY_HEADERS)
    public Builder setHeaders(Collection<Pair<String, String>> headers) {
      this.headers = OptionalValue.of(headers);
      return this;
    }

    public UpdateVersionRequest build() {
      return new UpdateVersionRequestImpl(template, comment, active, headers);
    }
  }
}
