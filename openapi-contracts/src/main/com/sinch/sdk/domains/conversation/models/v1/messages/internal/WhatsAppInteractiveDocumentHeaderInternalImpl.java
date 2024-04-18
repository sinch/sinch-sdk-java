package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.WhatsAppInteractiveHeaderMedia;
import java.util.Objects;

@JsonPropertyOrder({
  WhatsAppInteractiveDocumentHeaderInternalImpl.JSON_PROPERTY_TYPE,
  WhatsAppInteractiveDocumentHeaderInternalImpl.JSON_PROPERTY_DOCUMENT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppInteractiveDocumentHeaderInternalImpl
    implements WhatsAppInteractiveDocumentHeaderInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_DOCUMENT = "document";

  private OptionalValue<WhatsAppInteractiveHeaderMedia> document;

  public WhatsAppInteractiveDocumentHeaderInternalImpl() {}

  protected WhatsAppInteractiveDocumentHeaderInternalImpl(
      OptionalValue<TypeEnum> type, OptionalValue<WhatsAppInteractiveHeaderMedia> document) {
    this.type = type;
    this.document = document;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public WhatsAppInteractiveHeaderMedia getDocument() {
    return document.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DOCUMENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<WhatsAppInteractiveHeaderMedia> document() {
    return document;
  }

  /** Return true if this WhatsAppInteractiveDocumentHeader object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WhatsAppInteractiveDocumentHeaderInternalImpl whatsAppInteractiveDocumentHeader =
        (WhatsAppInteractiveDocumentHeaderInternalImpl) o;
    return Objects.equals(this.type, whatsAppInteractiveDocumentHeader.type)
        && Objects.equals(this.document, whatsAppInteractiveDocumentHeader.document);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, document);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WhatsAppInteractiveDocumentHeaderInternalImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
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
  static class Builder implements WhatsAppInteractiveDocumentHeaderInternal.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.empty();
    OptionalValue<WhatsAppInteractiveHeaderMedia> document = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(TypeEnum type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DOCUMENT)
    public Builder setDocument(WhatsAppInteractiveHeaderMedia document) {
      this.document = OptionalValue.of(document);
      return this;
    }

    public WhatsAppInteractiveDocumentHeaderInternal build() {
      return new WhatsAppInteractiveDocumentHeaderInternalImpl(type, document);
    }
  }
}
