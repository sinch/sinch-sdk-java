package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.line;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.line.buttons.LineNotificationMessageTemplateButton;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  LineNotificationMessageTemplateBodyImpl.JSON_PROPERTY_EMPHASIZED_ITEM,
  LineNotificationMessageTemplateBodyImpl.JSON_PROPERTY_ITEMS,
  LineNotificationMessageTemplateBodyImpl.JSON_PROPERTY_BUTTONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineNotificationMessageTemplateBodyImpl
    implements LineNotificationMessageTemplateBody {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_EMPHASIZED_ITEM = "emphasized_item";

  private OptionalValue<LineNotificationMessageTemplateEmphasizedItem> emphasizedItem;

  public static final String JSON_PROPERTY_ITEMS = "items";

  private OptionalValue<List<LineNotificationMessageTemplateItem>> items;

  public static final String JSON_PROPERTY_BUTTONS = "buttons";

  private OptionalValue<List<LineNotificationMessageTemplateButton>> buttons;

  public LineNotificationMessageTemplateBodyImpl() {}

  protected LineNotificationMessageTemplateBodyImpl(
      OptionalValue<LineNotificationMessageTemplateEmphasizedItem> emphasizedItem,
      OptionalValue<List<LineNotificationMessageTemplateItem>> items,
      OptionalValue<List<LineNotificationMessageTemplateButton>> buttons) {
    this.emphasizedItem = emphasizedItem;
    this.items = items;
    this.buttons = buttons;
  }

  @JsonIgnore
  public LineNotificationMessageTemplateEmphasizedItem getEmphasizedItem() {
    return emphasizedItem.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EMPHASIZED_ITEM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LineNotificationMessageTemplateEmphasizedItem> emphasizedItem() {
    return emphasizedItem;
  }

  @JsonIgnore
  public List<LineNotificationMessageTemplateItem> getItems() {
    return items.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<LineNotificationMessageTemplateItem>> items() {
    return items;
  }

  @JsonIgnore
  public List<LineNotificationMessageTemplateButton> getButtons() {
    return buttons.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BUTTONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<LineNotificationMessageTemplateButton>> buttons() {
    return buttons;
  }

  /** Return true if this LineNotificationMessageTemplateBody object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineNotificationMessageTemplateBodyImpl lineNotificationMessageTemplateBody =
        (LineNotificationMessageTemplateBodyImpl) o;
    return Objects.equals(this.emphasizedItem, lineNotificationMessageTemplateBody.emphasizedItem)
        && Objects.equals(this.items, lineNotificationMessageTemplateBody.items)
        && Objects.equals(this.buttons, lineNotificationMessageTemplateBody.buttons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emphasizedItem, items, buttons);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineNotificationMessageTemplateBodyImpl {\n");
    sb.append("    emphasizedItem: ").append(toIndentedString(emphasizedItem)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    buttons: ").append(toIndentedString(buttons)).append("\n");
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
  static class Builder implements LineNotificationMessageTemplateBody.Builder {
    OptionalValue<LineNotificationMessageTemplateEmphasizedItem> emphasizedItem =
        OptionalValue.empty();
    OptionalValue<List<LineNotificationMessageTemplateItem>> items = OptionalValue.empty();
    OptionalValue<List<LineNotificationMessageTemplateButton>> buttons = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_EMPHASIZED_ITEM)
    public Builder setEmphasizedItem(LineNotificationMessageTemplateEmphasizedItem emphasizedItem) {
      this.emphasizedItem = OptionalValue.of(emphasizedItem);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ITEMS)
    public Builder setItems(List<LineNotificationMessageTemplateItem> items) {
      this.items = OptionalValue.of(items);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BUTTONS)
    public Builder setButtons(List<LineNotificationMessageTemplateButton> buttons) {
      this.buttons = OptionalValue.of(buttons);
      return this;
    }

    public LineNotificationMessageTemplateBody build() {
      return new LineNotificationMessageTemplateBodyImpl(emphasizedItem, items, buttons);
    }
  }
}
