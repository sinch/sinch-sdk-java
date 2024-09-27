package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({TemplateMessageFieldInternalImpl.JSON_PROPERTY_TEMPLATE_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateMessageFieldInternalImpl implements TemplateMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEMPLATE_MESSAGE = "template_message";

  private OptionalValue<TemplateMessageInternal> templateMessage;

  public TemplateMessageFieldInternalImpl() {}

  protected TemplateMessageFieldInternalImpl(
      OptionalValue<TemplateMessageInternal> templateMessage) {
    this.templateMessage = templateMessage;
  }

  @JsonIgnore
  public TemplateMessageInternal getTemplateMessage() {
    return templateMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TemplateMessageInternal> templateMessage() {
    return templateMessage;
  }

  /** Return true if this TemplateMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateMessageFieldInternalImpl templateMessageField = (TemplateMessageFieldInternalImpl) o;
    return Objects.equals(this.templateMessage, templateMessageField.templateMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templateMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateMessageFieldInternalImpl {\n");
    sb.append("    templateMessage: ").append(toIndentedString(templateMessage)).append("\n");
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
  static class Builder implements TemplateMessageFieldInternal.Builder {
    OptionalValue<TemplateMessageInternal> templateMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEMPLATE_MESSAGE)
    public Builder setTemplateMessage(TemplateMessageInternal templateMessage) {
      this.templateMessage = OptionalValue.of(templateMessage);
      return this;
    }

    public TemplateMessageFieldInternal build() {
      return new TemplateMessageFieldInternalImpl(templateMessage);
    }
  }
}
