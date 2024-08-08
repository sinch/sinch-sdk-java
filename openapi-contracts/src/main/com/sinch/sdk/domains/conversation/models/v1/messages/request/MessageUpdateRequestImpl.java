package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({MessageUpdateRequestImpl.JSON_PROPERTY_METADATA})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessageUpdateRequestImpl implements MessageUpdateRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METADATA = "metadata";

  private OptionalValue<String> metadata;

  public MessageUpdateRequestImpl() {}

  protected MessageUpdateRequestImpl(OptionalValue<String> metadata) {
    this.metadata = metadata;
  }

  @JsonIgnore
  public String getMetadata() {
    return metadata.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> metadata() {
    return metadata;
  }

  /** Return true if this UpdateMessageMetadataRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageUpdateRequestImpl updateMessageMetadataRequest = (MessageUpdateRequestImpl) o;
    return Objects.equals(this.metadata, updateMessageMetadataRequest.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageUpdateRequestImpl {\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
  static class Builder implements MessageUpdateRequest.Builder {
    OptionalValue<String> metadata = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_METADATA)
    public Builder setMetadata(String metadata) {
      this.metadata = OptionalValue.of(metadata);
      return this;
    }

    public MessageUpdateRequest build() {
      return new MessageUpdateRequestImpl(metadata);
    }
  }
}
