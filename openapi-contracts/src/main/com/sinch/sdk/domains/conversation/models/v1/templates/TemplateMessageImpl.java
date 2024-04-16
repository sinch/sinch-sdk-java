package com.sinch.sdk.domains.conversation.models.v1.templates;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  TemplateMessageImpl.JSON_PROPERTY_CHANNEL_TEMPLATE,
  TemplateMessageImpl.JSON_PROPERTY_OMNI_TEMPLATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateMessageImpl implements TemplateMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL_TEMPLATE = "channel_template";

  private OptionalValue<Map<ConversationChannel, TemplateReference>> channelTemplate;

  public static final String JSON_PROPERTY_OMNI_TEMPLATE = "omni_template";

  private OptionalValue<TemplateReference> omniTemplate;

  public TemplateMessageImpl() {}

  protected TemplateMessageImpl(
      OptionalValue<Map<ConversationChannel, TemplateReference>> channelTemplate,
      OptionalValue<TemplateReference> omniTemplate) {
    this.channelTemplate = channelTemplate;
    this.omniTemplate = omniTemplate;
  }

  @JsonIgnore
  public Map<ConversationChannel, TemplateReference> getChannelTemplate() {
    return channelTemplate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<ConversationChannel, TemplateReference>> channelTemplate() {
    return channelTemplate;
  }

  @JsonIgnore
  public TemplateReference getOmniTemplate() {
    return omniTemplate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OMNI_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TemplateReference> omniTemplate() {
    return omniTemplate;
  }

  /** Return true if this Template_Message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateMessageImpl templateMessage = (TemplateMessageImpl) o;
    return Objects.equals(this.channelTemplate, templateMessage.channelTemplate)
        && Objects.equals(this.omniTemplate, templateMessage.omniTemplate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelTemplate, omniTemplate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateMessageImpl {\n");
    sb.append("    channelTemplate: ").append(toIndentedString(channelTemplate)).append("\n");
    sb.append("    omniTemplate: ").append(toIndentedString(omniTemplate)).append("\n");
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
  static class Builder implements TemplateMessage.Builder {
    OptionalValue<Map<ConversationChannel, TemplateReference>> channelTemplate =
        OptionalValue.empty();
    OptionalValue<TemplateReference> omniTemplate = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHANNEL_TEMPLATE)
    public Builder setChannelTemplate(Map<ConversationChannel, TemplateReference> channelTemplate) {
      this.channelTemplate = OptionalValue.of(channelTemplate);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OMNI_TEMPLATE)
    public Builder setOmniTemplate(TemplateReference omniTemplate) {
      this.omniTemplate = OptionalValue.of(omniTemplate);
      return this;
    }

    public TemplateMessage build() {
      return new TemplateMessageImpl(channelTemplate, omniTemplate);
    }
  }
}
