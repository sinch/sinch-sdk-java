package com.sinch.sdk.domains.mailgun.models.v1.templates.request;

import com.sinch.sdk.core.databind.annotation.FormSerialize;
import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.databind.annotation.Required;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.Pair;
import java.util.Collection;
import java.util.Objects;

public class CreateTemplateWithVersionRequestImpl
    implements CreateTemplateWithVersionRequest,
        com.sinch.sdk.domains.mailgun.models.v1.templates.request.CreateTemplateRequest {
  private static final long serialVersionUID = 1L;

  public static final String PROPERTY_NAME = "name";

  private OptionalValue<String> name;

  public static final String PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String PROPERTY_CREATED_BY = "createdBy";

  private OptionalValue<String> createdBy;

  public static final String PROPERTY_TEMPLATE = "template";

  private OptionalValue<String> template;

  public static final String PROPERTY_TAG = "tag";

  private OptionalValue<String> tag;

  public static final String PROPERTY_COMMENT = "comment";

  private OptionalValue<String> comment;

  public static final String PROPERTY_HEADERS = "headers";

  private OptionalValue<Collection<Pair<String, String>>> headers;

  public CreateTemplateWithVersionRequestImpl() {}

  protected CreateTemplateWithVersionRequestImpl(
      OptionalValue<String> name,
      OptionalValue<String> description,
      OptionalValue<String> createdBy,
      OptionalValue<String> template,
      OptionalValue<String> tag,
      OptionalValue<String> comment,
      OptionalValue<Collection<Pair<String, String>>> headers) {
    this.name = name;
    this.description = description;
    this.createdBy = createdBy;
    this.template = template;
    this.tag = tag;
    this.comment = comment;
    this.headers = headers;
  }

  public String getName() {
    return name.orElse(null);
  }

  @Required
  @Property(PROPERTY_NAME)
  public OptionalValue<String> name() {
    return name;
  }

  public String getDescription() {
    return description.orElse(null);
  }

  @Property(PROPERTY_DESCRIPTION)
  public OptionalValue<String> description() {
    return description;
  }

  public String getCreatedBy() {
    return createdBy.orElse(null);
  }

  @Property(PROPERTY_CREATED_BY)
  public OptionalValue<String> createdBy() {
    return createdBy;
  }

  public String getTemplate() {
    return template.orElse(null);
  }

  @Property(PROPERTY_TEMPLATE)
  public OptionalValue<String> template() {
    return template;
  }

  public String getTag() {
    return tag.orElse(null);
  }

  @Property(PROPERTY_TAG)
  public OptionalValue<String> tag() {
    return tag;
  }

  public String getComment() {
    return comment.orElse(null);
  }

  @Property(PROPERTY_COMMENT)
  public OptionalValue<String> comment() {
    return comment;
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

  /** Return true if this CreateTemplateWithVersionRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTemplateWithVersionRequestImpl createTemplateWithVersionRequest =
        (CreateTemplateWithVersionRequestImpl) o;
    return Objects.equals(this.name, createTemplateWithVersionRequest.name)
        && Objects.equals(this.description, createTemplateWithVersionRequest.description)
        && Objects.equals(this.createdBy, createTemplateWithVersionRequest.createdBy)
        && Objects.equals(this.template, createTemplateWithVersionRequest.template)
        && Objects.equals(this.tag, createTemplateWithVersionRequest.tag)
        && Objects.equals(this.comment, createTemplateWithVersionRequest.comment)
        && Objects.equals(this.headers, createTemplateWithVersionRequest.headers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, createdBy, template, tag, comment, headers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTemplateWithVersionRequestImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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

  static class Builder implements CreateTemplateWithVersionRequest.Builder {
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<String> createdBy = OptionalValue.empty();
    OptionalValue<String> template = OptionalValue.empty();
    OptionalValue<String> tag = OptionalValue.empty();
    OptionalValue<String> comment = OptionalValue.empty();
    OptionalValue<Collection<Pair<String, String>>> headers = OptionalValue.empty();

    @Property(value = PROPERTY_NAME)
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @Property(value = PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    @Property(value = PROPERTY_CREATED_BY)
    public Builder setCreatedBy(String createdBy) {
      this.createdBy = OptionalValue.of(createdBy);
      return this;
    }

    @Property(value = PROPERTY_TEMPLATE)
    public Builder setTemplate(String template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    @Property(value = PROPERTY_TAG)
    public Builder setTag(String tag) {
      this.tag = OptionalValue.of(tag);
      return this;
    }

    @Property(value = PROPERTY_COMMENT)
    public Builder setComment(String comment) {
      this.comment = OptionalValue.of(comment);
      return this;
    }

    @Property(value = PROPERTY_HEADERS)
    public Builder setHeaders(Collection<Pair<String, String>> headers) {
      this.headers = OptionalValue.of(headers);
      return this;
    }

    public CreateTemplateWithVersionRequest build() {
      return new CreateTemplateWithVersionRequestImpl(
          name, description, createdBy, template, tag, comment, headers);
    }
  }
}
