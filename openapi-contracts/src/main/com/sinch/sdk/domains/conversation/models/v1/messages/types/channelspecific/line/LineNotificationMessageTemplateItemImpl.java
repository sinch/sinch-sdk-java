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
  LineNotificationMessageTemplateItemImpl.JSON_PROPERTY_ITEM_KEY,
  LineNotificationMessageTemplateItemImpl.JSON_PROPERTY_CONTENT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineNotificationMessageTemplateItemImpl
    implements LineNotificationMessageTemplateItem {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ITEM_KEY = "item_key";

  private OptionalValue<String> itemKey;

  public static final String JSON_PROPERTY_CONTENT = "content";

  private OptionalValue<String> content;

  public LineNotificationMessageTemplateItemImpl() {}

  protected LineNotificationMessageTemplateItemImpl(
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

  /** Return true if this LineNotificationMessageTemplateItem object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineNotificationMessageTemplateItemImpl lineNotificationMessageTemplateItem =
        (LineNotificationMessageTemplateItemImpl) o;
    return Objects.equals(this.itemKey, lineNotificationMessageTemplateItem.itemKey)
        && Objects.equals(this.content, lineNotificationMessageTemplateItem.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemKey, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineNotificationMessageTemplateItemImpl {\n");
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
  static class Builder implements LineNotificationMessageTemplateItem.Builder {
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

    public LineNotificationMessageTemplateItem build() {
      return new LineNotificationMessageTemplateItemImpl(itemKey, content);
    }
  }
}
