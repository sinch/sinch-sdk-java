package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ListMessageImpl.JSON_PROPERTY_TITLE,
  ListMessageImpl.JSON_PROPERTY_DESCRIPTION,
  ListMessageImpl.JSON_PROPERTY_SECTIONS,
  ListMessageImpl.JSON_PROPERTY_MESSAGE_PROPERTIES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListMessageImpl
    implements ListMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_SECTIONS = "sections";

  private OptionalValue<List<ListSection<?>>> sections;

  public static final String JSON_PROPERTY_MESSAGE_PROPERTIES = "message_properties";

  private OptionalValue<ListMessageMessageProperties> messageProperties;

  public ListMessageImpl() {}

  protected ListMessageImpl(
      OptionalValue<String> title,
      OptionalValue<String> description,
      OptionalValue<List<ListSection<?>>> sections,
      OptionalValue<ListMessageMessageProperties> messageProperties) {
    this.title = title;
    this.description = description;
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
  public List<ListSection<?>> getSections() {
    return sections.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SECTIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<ListSection<?>>> sections() {
    return sections;
  }

  @JsonIgnore
  public ListMessageMessageProperties getMessageProperties() {
    return messageProperties.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ListMessageMessageProperties> messageProperties() {
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
    ListMessageImpl listMessage = (ListMessageImpl) o;
    return Objects.equals(this.title, listMessage.title)
        && Objects.equals(this.description, listMessage.description)
        && Objects.equals(this.sections, listMessage.sections)
        && Objects.equals(this.messageProperties, listMessage.messageProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, sections, messageProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListMessageImpl {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
  static class Builder implements ListMessage.Builder {
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<List<ListSection<?>>> sections = OptionalValue.empty();
    OptionalValue<ListMessageMessageProperties> messageProperties = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SECTIONS)
    public Builder setSections(List<ListSection<?>> sections) {
      this.sections = OptionalValue.of(sections);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_PROPERTIES)
    public Builder setMessageProperties(ListMessageMessageProperties messageProperties) {
      this.messageProperties = OptionalValue.of(messageProperties);
      return this;
    }

    public ListMessage build() {
      return new ListMessageImpl(title, description, sections, messageProperties);
    }
  }
}
