package com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Template;
import java.util.Objects;

@JsonPropertyOrder({
  CreateResponseInternalImpl.JSON_PROPERTY_MESSAGE,
  CreateResponseInternalImpl.JSON_PROPERTY_TEMPLATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CreateResponseInternalImpl implements CreateResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public static final String JSON_PROPERTY_TEMPLATE = "template";

  private OptionalValue<Template> template;

  public CreateResponseInternalImpl() {}

  protected CreateResponseInternalImpl(
      OptionalValue<String> message, OptionalValue<Template> template) {
    this.message = message;
    this.template = template;
  }

  @JsonIgnore
  public String getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> message() {
    return message;
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
   * Return true if this github.com-mailgun-temple-httpapi-createTemplateOrVersionResponse object is
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
    CreateResponseInternalImpl githubComMailgunTempleHttpapiCreateTemplateOrVersionResponse =
        (CreateResponseInternalImpl) o;
    return Objects.equals(
            this.message, githubComMailgunTempleHttpapiCreateTemplateOrVersionResponse.message)
        && Objects.equals(
            this.template, githubComMailgunTempleHttpapiCreateTemplateOrVersionResponse.template);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, template);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateResponseInternalImpl {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
  static class Builder implements CreateResponseInternal.Builder {
    OptionalValue<String> message = OptionalValue.empty();
    OptionalValue<Template> template = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_MESSAGE, required = true)
    public Builder setMessage(String message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_TEMPLATE, required = true)
    public Builder setTemplate(Template template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    public CreateResponseInternal build() {
      return new CreateResponseInternalImpl(message, template);
    }
  }
}
