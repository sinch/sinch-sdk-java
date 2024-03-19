package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  TemplateMessageTemplateMessageImpl.JSON_PROPERTY_CHANNEL_TEMPLATE,
  TemplateMessageTemplateMessageImpl.JSON_PROPERTY_OMNI_TEMPLATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateMessageTemplateMessageImpl implements TemplateMessageTemplateMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL_TEMPLATE = "channel_template";

  private OptionalValue<Map<String, TemplateReference>> channelTemplate;

  public static final String JSON_PROPERTY_OMNI_TEMPLATE = "omni_template";

  private OptionalValue<TemplateReference> omniTemplate;

  public TemplateMessageTemplateMessageImpl() {}

  protected TemplateMessageTemplateMessageImpl(
      OptionalValue<Map<String, TemplateReference>> channelTemplate,
      OptionalValue<TemplateReference> omniTemplate) {
    this.channelTemplate = channelTemplate;
    this.omniTemplate = omniTemplate;
  }

  @JsonIgnore
  public Map<String, TemplateReference> getChannelTemplate() {
    return channelTemplate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<String, TemplateReference>> channelTemplate() {
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

  /** Return true if this TemplateMessage_template_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateMessageTemplateMessageImpl templateMessageTemplateMessage =
        (TemplateMessageTemplateMessageImpl) o;
    return Objects.equals(this.channelTemplate, templateMessageTemplateMessage.channelTemplate)
        && Objects.equals(this.omniTemplate, templateMessageTemplateMessage.omniTemplate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelTemplate, omniTemplate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateMessageTemplateMessageImpl {\n");
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
  static class Builder implements TemplateMessageTemplateMessage.Builder {
    OptionalValue<Map<String, TemplateReference>> channelTemplate = OptionalValue.empty();
    OptionalValue<TemplateReference> omniTemplate = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHANNEL_TEMPLATE)
    public Builder setChannelTemplate(Map<String, TemplateReference> channelTemplate) {
      this.channelTemplate = OptionalValue.of(channelTemplate);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OMNI_TEMPLATE)
    public Builder setOmniTemplate(TemplateReference omniTemplate) {
      this.omniTemplate = OptionalValue.of(omniTemplate);
      return this;
    }

    public TemplateMessageTemplateMessage build() {
      return new TemplateMessageTemplateMessageImpl(channelTemplate, omniTemplate);
    }
  }
}
