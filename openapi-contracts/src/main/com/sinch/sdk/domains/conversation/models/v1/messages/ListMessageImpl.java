package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ListMessageImpl.JSON_PROPERTY_LIST_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListMessageImpl implements ListMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LIST_MESSAGE = "list_message";

  private OptionalValue<ListMessageListMessage> listMessage;

  public ListMessageImpl() {}

  protected ListMessageImpl(OptionalValue<ListMessageListMessage> listMessage) {
    this.listMessage = listMessage;
  }

  @JsonIgnore
  public ListMessageListMessage getListMessage() {
    return listMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ListMessageListMessage> listMessage() {
    return listMessage;
  }

  /** Return true if this ListMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListMessageImpl listMessage = (ListMessageImpl) o;
    return Objects.equals(this.listMessage, listMessage.listMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListMessageImpl {\n");
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
  static class Builder implements ListMessage.Builder {
    OptionalValue<ListMessageListMessage> listMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
    public Builder setListMessage(ListMessageListMessage listMessage) {
      this.listMessage = OptionalValue.of(listMessage);
      return this;
    }

    public ListMessage build() {
      return new ListMessageImpl(listMessage);
    }
  }
}
