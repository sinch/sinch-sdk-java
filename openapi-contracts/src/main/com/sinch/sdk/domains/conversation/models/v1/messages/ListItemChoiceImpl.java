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
  ListItemChoiceImpl.JSON_PROPERTY_TITLE,
  ListItemChoiceImpl.JSON_PROPERTY_DESCRIPTION,
  ListItemChoiceImpl.JSON_PROPERTY_MEDIA,
  ListItemChoiceImpl.JSON_PROPERTY_POSTBACK_DATA
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListItemChoiceImpl implements ListItemChoice {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_MEDIA = "media";

  private OptionalValue<ListItemMediaMessage> media;

  public static final String JSON_PROPERTY_POSTBACK_DATA = "postback_data";

  private OptionalValue<String> postbackData;

  public ListItemChoiceImpl() {}

  protected ListItemChoiceImpl(
      OptionalValue<String> title,
      OptionalValue<String> description,
      OptionalValue<ListItemMediaMessage> media,
      OptionalValue<String> postbackData) {
    this.title = title;
    this.description = description;
    this.media = media;
    this.postbackData = postbackData;
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
  public ListItemMediaMessage getMedia() {
    return media.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ListItemMediaMessage> media() {
    return media;
  }

  @JsonIgnore
  public String getPostbackData() {
    return postbackData.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_POSTBACK_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> postbackData() {
    return postbackData;
  }

  /** Return true if this ListItemChoice object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListItemChoiceImpl listItemChoice = (ListItemChoiceImpl) o;
    return Objects.equals(this.title, listItemChoice.title)
        && Objects.equals(this.description, listItemChoice.description)
        && Objects.equals(this.media, listItemChoice.media)
        && Objects.equals(this.postbackData, listItemChoice.postbackData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, media, postbackData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListItemChoiceImpl {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    media: ").append(toIndentedString(media)).append("\n");
    sb.append("    postbackData: ").append(toIndentedString(postbackData)).append("\n");
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
  static class Builder implements ListItemChoice.Builder {
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<ListItemMediaMessage> media = OptionalValue.empty();
    OptionalValue<String> postbackData = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_MEDIA)
    public Builder setMedia(ListItemMediaMessage media) {
      this.media = OptionalValue.of(media);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_POSTBACK_DATA)
    public Builder setPostbackData(String postbackData) {
      this.postbackData = OptionalValue.of(postbackData);
      return this;
    }

    public ListItemChoice build() {
      return new ListItemChoiceImpl(title, description, media, postbackData);
    }
  }
}
