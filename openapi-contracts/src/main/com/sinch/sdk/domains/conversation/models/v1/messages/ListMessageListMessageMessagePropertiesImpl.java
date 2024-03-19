package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ListMessageListMessageMessagePropertiesImpl.JSON_PROPERTY_CATALOG_ID,
  ListMessageListMessageMessagePropertiesImpl.JSON_PROPERTY_MENU
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListMessageListMessageMessagePropertiesImpl
    implements ListMessageListMessageMessageProperties {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CATALOG_ID = "catalog_id";

  private OptionalValue<String> catalogId;

  public static final String JSON_PROPERTY_MENU = "menu";

  private OptionalValue<String> menu;

  public ListMessageListMessageMessagePropertiesImpl() {}

  protected ListMessageListMessageMessagePropertiesImpl(
      OptionalValue<String> catalogId, OptionalValue<String> menu) {
    this.catalogId = catalogId;
    this.menu = menu;
  }

  @JsonIgnore
  public String getCatalogId() {
    return catalogId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CATALOG_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> catalogId() {
    return catalogId;
  }

  @JsonIgnore
  public String getMenu() {
    return menu.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MENU)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> menu() {
    return menu;
  }

  /** Return true if this ListMessage_list_message_message_properties object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListMessageListMessageMessagePropertiesImpl listMessageListMessageMessageProperties =
        (ListMessageListMessageMessagePropertiesImpl) o;
    return Objects.equals(this.catalogId, listMessageListMessageMessageProperties.catalogId)
        && Objects.equals(this.menu, listMessageListMessageMessageProperties.menu);
  }

  @Override
  public int hashCode() {
    return Objects.hash(catalogId, menu);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListMessageListMessageMessagePropertiesImpl {\n");
    sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
    sb.append("    menu: ").append(toIndentedString(menu)).append("\n");
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
  static class Builder implements ListMessageListMessageMessageProperties.Builder {
    OptionalValue<String> catalogId = OptionalValue.empty();
    OptionalValue<String> menu = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CATALOG_ID)
    public Builder setCatalogId(String catalogId) {
      this.catalogId = OptionalValue.of(catalogId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MENU)
    public Builder setMenu(String menu) {
      this.menu = OptionalValue.of(menu);
      return this;
    }

    public ListMessageListMessageMessageProperties build() {
      return new ListMessageListMessageMessagePropertiesImpl(catalogId, menu);
    }
  }
}
