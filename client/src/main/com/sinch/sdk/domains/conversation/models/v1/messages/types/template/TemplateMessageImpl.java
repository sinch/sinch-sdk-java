package com.sinch.sdk.domains.conversation.models.v1.messages.types.template;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.TemplateReference;
import java.util.Map;
import java.util.Objects;

public class TemplateMessageImpl implements TemplateMessage {
  private static final long serialVersionUID = 1L;

  private OptionalValue<Map<ConversationChannel, TemplateReference>> channelTemplate;

  private OptionalValue<TemplateReference> omniTemplate;

  public TemplateMessageImpl() {}

  protected TemplateMessageImpl(
      OptionalValue<Map<ConversationChannel, TemplateReference>> channelTemplate,
      OptionalValue<TemplateReference> omniTemplate) {
    this.channelTemplate = channelTemplate;
    this.omniTemplate = omniTemplate;
  }

  public Map<ConversationChannel, TemplateReference> getChannelTemplate() {
    return channelTemplate.orElse(null);
  }

  public OptionalValue<Map<ConversationChannel, TemplateReference>> channelTemplate() {
    return channelTemplate;
  }

  public TemplateReference getOmniTemplate() {
    return omniTemplate.orElse(null);
  }

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

  static class Builder implements TemplateMessage.Builder {
    OptionalValue<Map<ConversationChannel, TemplateReference>> channelTemplate =
        OptionalValue.empty();
    OptionalValue<TemplateReference> omniTemplate = OptionalValue.empty();

    public Builder setChannelTemplate(Map<ConversationChannel, TemplateReference> channelTemplate) {
      this.channelTemplate = OptionalValue.of(channelTemplate);
      return this;
    }

    public Builder setOmniTemplate(TemplateReference omniTemplate) {
      this.omniTemplate = OptionalValue.of(omniTemplate);
      return this;
    }

    public TemplateMessageImpl build() {
      return new TemplateMessageImpl(channelTemplate, omniTemplate);
    }
  }
}
