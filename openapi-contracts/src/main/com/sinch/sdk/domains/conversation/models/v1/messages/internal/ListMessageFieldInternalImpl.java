package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListMessage;
import java.util.Objects;

@JsonPropertyOrder({ListMessageFieldInternalImpl.JSON_PROPERTY_LIST_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListMessageFieldInternalImpl implements ListMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LIST_MESSAGE = "list_message";

  private OptionalValue<ListMessage> listMessage;

  public ListMessageFieldInternalImpl() {}

  protected ListMessageFieldInternalImpl(OptionalValue<ListMessage> listMessage) {
    this.listMessage = listMessage;
  }

  @JsonIgnore
  public ListMessage getListMessage() {
    return listMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ListMessage> listMessage() {
    return listMessage;
  }

  /** Return true if this ListMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListMessageFieldInternalImpl listMessageField = (ListMessageFieldInternalImpl) o;
    return Objects.equals(this.listMessage, listMessageField.listMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListMessageFieldInternalImpl {\n");
    sb.append("    listMessage: ").append(toIndentedString(listMessage)).append("\n");
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
  static class Builder implements ListMessageFieldInternal.Builder {
    OptionalValue<ListMessage> listMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
    public Builder setListMessage(ListMessage listMessage) {
      this.listMessage = OptionalValue.of(listMessage);
      return this;
    }

    public ListMessageFieldInternal build() {
      return new ListMessageFieldInternalImpl(listMessage);
    }
  }
}
