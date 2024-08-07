package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.internal.TemplateReferenceInternal;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  TemplateMessageInternalImpl.JSON_PROPERTY_CHANNEL_TEMPLATE,
  TemplateMessageInternalImpl.JSON_PROPERTY_OMNI_TEMPLATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateMessageInternalImpl implements TemplateMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL_TEMPLATE = "channel_template";

  private OptionalValue<Map<ConversationChannel, TemplateReferenceInternal>> channelTemplate;

  public static final String JSON_PROPERTY_OMNI_TEMPLATE = "omni_template";

  private OptionalValue<TemplateReferenceInternal> omniTemplate;

  public TemplateMessageInternalImpl() {}

  protected TemplateMessageInternalImpl(
      OptionalValue<Map<ConversationChannel, TemplateReferenceInternal>> channelTemplate,
      OptionalValue<TemplateReferenceInternal> omniTemplate) {
    this.channelTemplate = channelTemplate;
    this.omniTemplate = omniTemplate;
  }

  @JsonIgnore
  public Map<ConversationChannel, TemplateReferenceInternal> getChannelTemplate() {
    return channelTemplate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<ConversationChannel, TemplateReferenceInternal>> channelTemplate() {
    return channelTemplate;
  }

  @JsonIgnore
  public TemplateReferenceInternal getOmniTemplate() {
    return omniTemplate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OMNI_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TemplateReferenceInternal> omniTemplate() {
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
    TemplateMessageInternalImpl templateMessage = (TemplateMessageInternalImpl) o;
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
    sb.append("class TemplateMessageInternalImpl {\n");
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
  static class Builder implements TemplateMessageInternal.Builder {
    OptionalValue<Map<ConversationChannel, TemplateReferenceInternal>> channelTemplate =
        OptionalValue.empty();
    OptionalValue<TemplateReferenceInternal> omniTemplate = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHANNEL_TEMPLATE)
    public Builder setChannelTemplate(
        Map<ConversationChannel, TemplateReferenceInternal> channelTemplate) {
      this.channelTemplate = OptionalValue.of(channelTemplate);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OMNI_TEMPLATE)
    public Builder setOmniTemplate(TemplateReferenceInternal omniTemplate) {
      this.omniTemplate = OptionalValue.of(omniTemplate);
      return this;
    }

    public TemplateMessageInternal build() {
      return new TemplateMessageInternalImpl(channelTemplate, omniTemplate);
    }
  }
}
