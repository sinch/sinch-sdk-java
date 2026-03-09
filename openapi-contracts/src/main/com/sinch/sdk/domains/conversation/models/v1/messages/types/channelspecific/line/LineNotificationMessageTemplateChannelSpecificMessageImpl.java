package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.line;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  LineNotificationMessageTemplateChannelSpecificMessageImpl.JSON_PROPERTY_TEMPLATE_KEY,
  LineNotificationMessageTemplateChannelSpecificMessageImpl.JSON_PROPERTY_BODY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineNotificationMessageTemplateChannelSpecificMessageImpl
    implements LineNotificationMessageTemplateChannelSpecificMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEMPLATE_KEY = "template_key";

  private OptionalValue<String> templateKey;

  public static final String JSON_PROPERTY_BODY = "body";

  private OptionalValue<LineNotificationMessageTemplateBody> body;

  public LineNotificationMessageTemplateChannelSpecificMessageImpl() {}

  protected LineNotificationMessageTemplateChannelSpecificMessageImpl(
      OptionalValue<String> templateKey, OptionalValue<LineNotificationMessageTemplateBody> body) {
    this.templateKey = templateKey;
    this.body = body;
  }

  @JsonIgnore
  public String getTemplateKey() {
    return templateKey.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> templateKey() {
    return templateKey;
  }

  @JsonIgnore
  public LineNotificationMessageTemplateBody getBody() {
    return body.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LineNotificationMessageTemplateBody> body() {
    return body;
  }

  /**
   * Return true if this LineNotificationMessageTemplateChannelSpecificMessage object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineNotificationMessageTemplateChannelSpecificMessageImpl
        lineNotificationMessageTemplateChannelSpecificMessage =
            (LineNotificationMessageTemplateChannelSpecificMessageImpl) o;
    return Objects.equals(
            this.templateKey, lineNotificationMessageTemplateChannelSpecificMessage.templateKey)
        && Objects.equals(this.body, lineNotificationMessageTemplateChannelSpecificMessage.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templateKey, body);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineNotificationMessageTemplateChannelSpecificMessageImpl {\n");
    sb.append("    templateKey: ").append(toIndentedString(templateKey)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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
  static class Builder implements LineNotificationMessageTemplateChannelSpecificMessage.Builder {
    OptionalValue<String> templateKey = OptionalValue.empty();
    OptionalValue<LineNotificationMessageTemplateBody> body = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TEMPLATE_KEY, required = true)
    public Builder setTemplateKey(String templateKey) {
      this.templateKey = OptionalValue.of(templateKey);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BODY)
    public Builder setBody(LineNotificationMessageTemplateBody body) {
      this.body = OptionalValue.of(body);
      return this;
    }

    public LineNotificationMessageTemplateChannelSpecificMessage build() {
      return new LineNotificationMessageTemplateChannelSpecificMessageImpl(templateKey, body);
    }
  }
}
