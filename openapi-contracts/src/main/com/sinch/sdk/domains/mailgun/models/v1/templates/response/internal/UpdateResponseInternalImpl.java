package com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  UpdateResponseInternalImpl.JSON_PROPERTY_MESSAGE,
  UpdateResponseInternalImpl.JSON_PROPERTY_TEMPLATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UpdateResponseInternalImpl implements UpdateResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public static final String JSON_PROPERTY_TEMPLATE = "template";

  private OptionalValue<UpdatedTemplateInternal> template;

  public UpdateResponseInternalImpl() {}

  protected UpdateResponseInternalImpl(
      OptionalValue<String> message, OptionalValue<UpdatedTemplateInternal> template) {
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
  public UpdatedTemplateInternal getTemplate() {
    return template.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<UpdatedTemplateInternal> template() {
    return template;
  }

  /**
   * Return true if this github.com-mailgun-temple-httpapi-updateOrDeleteTempateOrVersionResponse
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
    UpdateResponseInternalImpl githubComMailgunTempleHttpapiUpdateOrDeleteTempateOrVersionResponse =
        (UpdateResponseInternalImpl) o;
    return Objects.equals(
            this.message,
            githubComMailgunTempleHttpapiUpdateOrDeleteTempateOrVersionResponse.message)
        && Objects.equals(
            this.template,
            githubComMailgunTempleHttpapiUpdateOrDeleteTempateOrVersionResponse.template);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, template);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateResponseInternalImpl {\n");
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
  static class Builder implements UpdateResponseInternal.Builder {
    OptionalValue<String> message = OptionalValue.empty();
    OptionalValue<UpdatedTemplateInternal> template = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_MESSAGE, required = true)
    public Builder setMessage(String message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_TEMPLATE, required = true)
    public Builder setTemplate(UpdatedTemplateInternal template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    public UpdateResponseInternal build() {
      return new UpdateResponseInternalImpl(message, template);
    }
  }
}
