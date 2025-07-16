package com.sinch.sdk.domains.conversation.models.v1.messages.types.list;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ListAdditionalPropertiesImpl.JSON_PROPERTY_CATALOG_ID,
  ListAdditionalPropertiesImpl.JSON_PROPERTY_MENU,
  ListAdditionalPropertiesImpl.JSON_PROPERTY_WHATSAPP_HEADER
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListAdditionalPropertiesImpl implements ListAdditionalProperties {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CATALOG_ID = "catalog_id";

  private OptionalValue<String> catalogId;

  public static final String JSON_PROPERTY_MENU = "menu";

  private OptionalValue<String> menu;

  public static final String JSON_PROPERTY_WHATSAPP_HEADER = "whatsapp_header";

  private OptionalValue<String> whatsappHeader;

  public ListAdditionalPropertiesImpl() {}

  protected ListAdditionalPropertiesImpl(
      OptionalValue<String> catalogId,
      OptionalValue<String> menu,
      OptionalValue<String> whatsappHeader) {
    this.catalogId = catalogId;
    this.menu = menu;
    this.whatsappHeader = whatsappHeader;
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

  @JsonIgnore
  public String getWhatsappHeader() {
    return whatsappHeader.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WHATSAPP_HEADER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> whatsappHeader() {
    return whatsappHeader;
  }

  /** Return true if this List_Message_message_properties object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListAdditionalPropertiesImpl listMessageMessageProperties = (ListAdditionalPropertiesImpl) o;
    return Objects.equals(this.catalogId, listMessageMessageProperties.catalogId)
        && Objects.equals(this.menu, listMessageMessageProperties.menu)
        && Objects.equals(this.whatsappHeader, listMessageMessageProperties.whatsappHeader);
  }

  @Override
  public int hashCode() {
    return Objects.hash(catalogId, menu, whatsappHeader);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListAdditionalPropertiesImpl {\n");
    sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
    sb.append("    menu: ").append(toIndentedString(menu)).append("\n");
    sb.append("    whatsappHeader: ").append(toIndentedString(whatsappHeader)).append("\n");
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
  static class Builder implements ListAdditionalProperties.Builder {
    OptionalValue<String> catalogId = OptionalValue.empty();
    OptionalValue<String> menu = OptionalValue.empty();
    OptionalValue<String> whatsappHeader = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_WHATSAPP_HEADER)
    public Builder setWhatsappHeader(String whatsappHeader) {
      this.whatsappHeader = OptionalValue.of(whatsappHeader);
      return this;
    }

    public ListAdditionalProperties build() {
      return new ListAdditionalPropertiesImpl(catalogId, menu, whatsappHeader);
    }
  }
}
