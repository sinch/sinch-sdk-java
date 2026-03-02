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
  LineNotificationMessageTemplateEmphasizedItemImpl.JSON_PROPERTY_ITEM_KEY,
  LineNotificationMessageTemplateEmphasizedItemImpl.JSON_PROPERTY_CONTENT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineNotificationMessageTemplateEmphasizedItemImpl
    implements LineNotificationMessageTemplateEmphasizedItem {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ITEM_KEY = "item_key";

  private OptionalValue<String> itemKey;

  public static final String JSON_PROPERTY_CONTENT = "content";

  private OptionalValue<String> content;

  public LineNotificationMessageTemplateEmphasizedItemImpl() {}

  protected LineNotificationMessageTemplateEmphasizedItemImpl(
      OptionalValue<String> itemKey, OptionalValue<String> content) {
    this.itemKey = itemKey;
    this.content = content;
  }

  @JsonIgnore
  public String getItemKey() {
    return itemKey.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ITEM_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> itemKey() {
    return itemKey;
  }

  @JsonIgnore
  public String getContent() {
    return content.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> content() {
    return content;
  }

  /** Return true if this LineNotificationMessageTemplateEmphasizedItem object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineNotificationMessageTemplateEmphasizedItemImpl
        lineNotificationMessageTemplateEmphasizedItem =
            (LineNotificationMessageTemplateEmphasizedItemImpl) o;
    return Objects.equals(this.itemKey, lineNotificationMessageTemplateEmphasizedItem.itemKey)
        && Objects.equals(this.content, lineNotificationMessageTemplateEmphasizedItem.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemKey, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineNotificationMessageTemplateEmphasizedItemImpl {\n");
    sb.append("    itemKey: ").append(toIndentedString(itemKey)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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
  static class Builder implements LineNotificationMessageTemplateEmphasizedItem.Builder {
    OptionalValue<String> itemKey = OptionalValue.empty();
    OptionalValue<String> content = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ITEM_KEY, required = true)
    public Builder setItemKey(String itemKey) {
      this.itemKey = OptionalValue.of(itemKey);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CONTENT, required = true)
    public Builder setContent(String content) {
      this.content = OptionalValue.of(content);
      return this;
    }

    public LineNotificationMessageTemplateEmphasizedItem build() {
      return new LineNotificationMessageTemplateEmphasizedItemImpl(itemKey, content);
    }
  }
}
