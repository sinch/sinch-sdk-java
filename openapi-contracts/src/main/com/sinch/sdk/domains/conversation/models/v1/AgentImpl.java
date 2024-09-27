package com.sinch.sdk.domains.conversation.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  AgentImpl.JSON_PROPERTY_DISPLAY_NAME,
  AgentImpl.JSON_PROPERTY_TYPE,
  AgentImpl.JSON_PROPERTY_PICTURE_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AgentImpl implements Agent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "display_name";

  private OptionalValue<String> displayName;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<AgentType> type;

  public static final String JSON_PROPERTY_PICTURE_URL = "picture_url";

  private OptionalValue<String> pictureUrl;

  public AgentImpl() {}

  protected AgentImpl(
      OptionalValue<String> displayName,
      OptionalValue<AgentType> type,
      OptionalValue<String> pictureUrl) {
    this.displayName = displayName;
    this.type = type;
    this.pictureUrl = pictureUrl;
  }

  @JsonIgnore
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> displayName() {
    return displayName;
  }

  @JsonIgnore
  public AgentType getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AgentType> type() {
    return type;
  }

  @JsonIgnore
  public String getPictureUrl() {
    return pictureUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PICTURE_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> pictureUrl() {
    return pictureUrl;
  }

  /** Return true if this Agent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgentImpl agent = (AgentImpl) o;
    return Objects.equals(this.displayName, agent.displayName)
        && Objects.equals(this.type, agent.type)
        && Objects.equals(this.pictureUrl, agent.pictureUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, type, pictureUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgentImpl {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    pictureUrl: ").append(toIndentedString(pictureUrl)).append("\n");
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
  static class Builder implements Agent.Builder {
    OptionalValue<String> displayName = OptionalValue.empty();
    OptionalValue<AgentType> type = OptionalValue.empty();
    OptionalValue<String> pictureUrl = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    public Builder setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(AgentType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PICTURE_URL)
    public Builder setPictureUrl(String pictureUrl) {
      this.pictureUrl = OptionalValue.of(pictureUrl);
      return this;
    }

    public Agent build() {
      return new AgentImpl(displayName, type, pictureUrl);
    }
  }
}
