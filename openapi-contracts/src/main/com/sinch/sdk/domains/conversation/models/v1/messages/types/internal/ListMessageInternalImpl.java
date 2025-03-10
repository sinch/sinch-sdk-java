package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListAdditionalProperties;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListSection;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ListMessageInternalImpl.JSON_PROPERTY_TITLE,
  ListMessageInternalImpl.JSON_PROPERTY_DESCRIPTION,
  ListMessageInternalImpl.JSON_PROPERTY_MEDIA,
  ListMessageInternalImpl.JSON_PROPERTY_SECTIONS,
  ListMessageInternalImpl.JSON_PROPERTY_MESSAGE_PROPERTIES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListMessageInternalImpl implements ListMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_MEDIA = "media";

  private OptionalValue<MediaMessage> media;

  public static final String JSON_PROPERTY_SECTIONS = "sections";

  private OptionalValue<List<ListSection<?>>> sections;

  public static final String JSON_PROPERTY_MESSAGE_PROPERTIES = "message_properties";

  private OptionalValue<ListAdditionalProperties> messageProperties;

  public ListMessageInternalImpl() {}

  protected ListMessageInternalImpl(
      OptionalValue<String> title,
      OptionalValue<String> description,
      OptionalValue<MediaMessage> media,
      OptionalValue<List<ListSection<?>>> sections,
      OptionalValue<ListAdditionalProperties> messageProperties) {
    this.title = title;
    this.description = description;
    this.media = media;
    this.sections = sections;
    this.messageProperties = messageProperties;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> title() {
    return title;
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> description() {
    return description;
  }

  @JsonIgnore
  public MediaMessage getMedia() {
    return media.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaMessage> media() {
    return media;
  }

  @JsonIgnore
  public List<ListSection<?>> getSections() {
    return sections.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SECTIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<ListSection<?>>> sections() {
    return sections;
  }

  @JsonIgnore
  public ListAdditionalProperties getMessageProperties() {
    return messageProperties.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ListAdditionalProperties> messageProperties() {
    return messageProperties;
  }

  /** Return true if this List_Message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListMessageInternalImpl listMessage = (ListMessageInternalImpl) o;
    return Objects.equals(this.title, listMessage.title)
        && Objects.equals(this.description, listMessage.description)
        && Objects.equals(this.media, listMessage.media)
        && Objects.equals(this.sections, listMessage.sections)
        && Objects.equals(this.messageProperties, listMessage.messageProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, media, sections, messageProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListMessageInternalImpl {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    media: ").append(toIndentedString(media)).append("\n");
    sb.append("    sections: ").append(toIndentedString(sections)).append("\n");
    sb.append("    messageProperties: ").append(toIndentedString(messageProperties)).append("\n");
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
  static class Builder implements ListMessageInternal.Builder {
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<MediaMessage> media = OptionalValue.empty();
    OptionalValue<List<ListSection<?>>> sections = OptionalValue.empty();
    OptionalValue<ListAdditionalProperties> messageProperties = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TITLE, required = true)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MEDIA)
    public Builder setMedia(MediaMessage media) {
      this.media = OptionalValue.of(media);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SECTIONS, required = true)
    public Builder setSections(List<ListSection<?>> sections) {
      this.sections = OptionalValue.of(sections);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_PROPERTIES)
    public Builder setMessageProperties(ListAdditionalProperties messageProperties) {
      this.messageProperties = OptionalValue.of(messageProperties);
      return this;
    }

    public ListMessageInternal build() {
      return new ListMessageInternalImpl(title, description, media, sections, messageProperties);
    }
  }
}
