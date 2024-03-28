package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ListItemImpl.JSON_PROPERTY_ITEM})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListItemImpl implements ListItem {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ITEM = "item";

  private OptionalValue<ListItemItem> item;

  public ListItemImpl() {}

  protected ListItemImpl(OptionalValue<ListItemItem> item) {
    this.item = item;
  }

  @JsonIgnore
  public ListItemItem getItem() {
    return item.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ITEM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ListItemItem> item() {
    return item;
  }

  /** Return true if this ListItem object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListItemImpl listItem = (ListItemImpl) o;
    return Objects.equals(this.item, listItem.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListItemImpl {\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
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
  static class Builder implements ListItem.Builder {
    OptionalValue<ListItemItem> item = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ITEM)
    public Builder setItem(ListItemItem item) {
      this.item = OptionalValue.of(item);
      return this;
    }

    public ListItem build() {
      return new ListItemImpl(item);
    }
  }
}
