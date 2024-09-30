package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  WhatsAppInteractiveHeaderDocumentImpl.JSON_PROPERTY_TYPE,
  WhatsAppInteractiveHeaderDocumentImpl.JSON_PROPERTY_DOCUMENT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppInteractiveHeaderDocumentImpl
    implements WhatsAppInteractiveHeaderDocument,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows
            .WhatsAppInteractiveHeader {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_DOCUMENT = "document";

  private OptionalValue<WhatsAppInteractiveHeaderMedia> document;

  public WhatsAppInteractiveHeaderDocumentImpl() {}

  protected WhatsAppInteractiveHeaderDocumentImpl(
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
    WhatsAppInteractiveHeaderDocumentImpl whatsAppInteractiveDocumentHeader =
        (WhatsAppInteractiveHeaderDocumentImpl) o;
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
    sb.append("class WhatsAppInteractiveHeaderDocumentImpl {\n");
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
  static class Builder implements WhatsAppInteractiveHeaderDocument.Builder {
    OptionalValue<TypeEnum> type =
        OptionalValue.of(WhatsAppInteractiveHeaderDocument.TypeEnum.DOCUMENT);
    OptionalValue<WhatsAppInteractiveHeaderMedia> document = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DOCUMENT)
    public Builder setDocument(WhatsAppInteractiveHeaderMedia document) {
      this.document = OptionalValue.of(document);
      return this;
    }

    public WhatsAppInteractiveHeaderDocument build() {
      return new WhatsAppInteractiveHeaderDocumentImpl(type, document);
    }
  }
}
