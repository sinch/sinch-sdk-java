package com.sinch.sdk.domains.conversation.models.v1.messages.types.list;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({ListSectionImpl.JSON_PROPERTY_TITLE, ListSectionImpl.JSON_PROPERTY_ITEMS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListSectionImpl<T> implements ListSection<T> {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_ITEMS = "items";

  private OptionalValue<List<ListItem<T>>> items;

  public ListSectionImpl() {}

  protected ListSectionImpl(OptionalValue<String> title, OptionalValue<List<ListItem<T>>> items) {
    this.title = title;
    this.items = items;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> title() {
    return title;
  }

  @JsonIgnore
  public List<ListItem<T>> getItems() {
    return items.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<ListItem<T>>> items() {
    return items;
  }

  /** Return true if this ListSection object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListSectionImpl listSection = (ListSectionImpl) o;
    return Objects.equals(this.title, listSection.title)
        && Objects.equals(this.items, listSection.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListSectionImpl {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
  static class Builder<T> implements ListSection.Builder<T> {
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<List<ListItem<T>>> items = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder<T> setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ITEMS, required = true)
    public Builder<T> setItems(List<ListItem<T>> items) {
      this.items = OptionalValue.of(items);
      return this;
    }

    public ListSection<T> build() {
      return new ListSectionImpl<T>(title, items);
    }
  }
}
