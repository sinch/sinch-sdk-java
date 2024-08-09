package com.sinch.sdk.domains.conversation.models.v1.messages.types.list;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ListMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ListMessageInternalImpl;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({ListMessageImpl.JSON_PROPERTY_LIST_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListMessageImpl
    implements ListMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LIST_MESSAGE = "list_message";

  private OptionalValue<ListMessageInternal> listMessage;

  public ListMessageImpl() {}

  protected ListMessageImpl(OptionalValue<ListMessageInternal> listMessage) {
    this.listMessage = listMessage;
  }

  @JsonIgnore
  public ListMessageInternal getListMessage() {
    return listMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ListMessageInternal> listMessage() {
    return listMessage;
  }

  @JsonIgnore
  public String getTitle() {
    if (null == listMessage || !listMessage.isPresent() || null == listMessage.get().getTitle()) {
      return null;
    }
    return listMessage.get().getTitle();
  }

  public OptionalValue<String> title() {
    return null != listMessage && listMessage.isPresent()
        ? listMessage.map(f -> ((ListMessageInternalImpl) f).title()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getDescription() {
    if (null == listMessage
        || !listMessage.isPresent()
        || null == listMessage.get().getDescription()) {
      return null;
    }
    return listMessage.get().getDescription();
  }

  public OptionalValue<String> description() {
    return null != listMessage && listMessage.isPresent()
        ? listMessage
            .map(f -> ((ListMessageInternalImpl) f).description())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public List<ListSection<?>> getSections() {
    if (null == listMessage
        || !listMessage.isPresent()
        || null == listMessage.get().getSections()) {
      return null;
    }
    return listMessage.get().getSections();
  }

  public OptionalValue<List<ListSection<?>>> sections() {
    return null != listMessage && listMessage.isPresent()
        ? listMessage
            .map(f -> ((ListMessageInternalImpl) f).sections())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public ListAdditionalProperties getMessageProperties() {
    if (null == listMessage
        || !listMessage.isPresent()
        || null == listMessage.get().getMessageProperties()) {
      return null;
    }
    return listMessage.get().getMessageProperties();
  }

  public OptionalValue<ListAdditionalProperties> messageProperties() {
    return null != listMessage && listMessage.isPresent()
        ? listMessage
            .map(f -> ((ListMessageInternalImpl) f).messageProperties())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
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
    ListMessageImpl listMessageField = (ListMessageImpl) o;
    return Objects.equals(this.listMessage, listMessageField.listMessage);
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
    OptionalValue<ListMessageInternal> listMessage = OptionalValue.empty();

    ListMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_LIST_MESSAGE, required = true)
    public Builder setListMessage(ListMessageInternal listMessage) {
      this.listMessage = OptionalValue.of(listMessage);
      return this;
    }

    @JsonIgnore
    public Builder setTitle(String title) {
      getDelegatedBuilder().setTitle(title);
      return this;
    }

    @JsonIgnore
    public Builder setDescription(String description) {
      getDelegatedBuilder().setDescription(description);
      return this;
    }

    @JsonIgnore
    public Builder setSections(List<ListSection<?>> sections) {
      getDelegatedBuilder().setSections(sections);
      return this;
    }

    @JsonIgnore
    public Builder setMessageProperties(ListAdditionalProperties messageProperties) {
      getDelegatedBuilder().setMessageProperties(messageProperties);
      return this;
    }

    private ListMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ListMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public ListMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.listMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new ListMessageImpl(listMessage);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<ListMessage>> {
    @Override
    public void serialize(
        OptionalValue<ListMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      ListMessageImpl impl = (ListMessageImpl) value.get();
      jgen.writeObject(impl.getListMessage());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<ListMessage> {
    @Override
    public ListMessage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      ListMessageImpl.Builder builder = new ListMessageImpl.Builder();
      ListMessageInternalImpl deserialized = jp.readValueAs(ListMessageInternalImpl.class);
      builder.setListMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<ListMessage> delegatedConverter(ListMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setListMessage(internal).build());
  }
}
