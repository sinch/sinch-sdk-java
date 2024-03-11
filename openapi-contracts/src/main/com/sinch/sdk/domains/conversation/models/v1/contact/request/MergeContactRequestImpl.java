package com.sinch.sdk.domains.conversation.models.v1.contact.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  MergeContactRequestImpl.JSON_PROPERTY_SOURCE_ID,
  MergeContactRequestImpl.JSON_PROPERTY_STRATEGY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MergeContactRequestImpl implements MergeContactRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SOURCE_ID = "source_id";

  private OptionalValue<String> sourceId;

  public static final String JSON_PROPERTY_STRATEGY = "strategy";

  private OptionalValue<ConversationMergeStrategy> strategy;

  public MergeContactRequestImpl() {}

  protected MergeContactRequestImpl(
      OptionalValue<String> sourceId, OptionalValue<ConversationMergeStrategy> strategy) {
    this.sourceId = sourceId;
    this.strategy = strategy;
  }

  @JsonIgnore
  public String getSourceId() {
    return sourceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SOURCE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> sourceId() {
    return sourceId;
  }

  @JsonIgnore
  public ConversationMergeStrategy getStrategy() {
    return strategy.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STRATEGY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConversationMergeStrategy> strategy() {
    return strategy;
  }

  /** Return true if this MergeContactRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MergeContactRequestImpl mergeContactRequest = (MergeContactRequestImpl) o;
    return Objects.equals(this.sourceId, mergeContactRequest.sourceId)
        && Objects.equals(this.strategy, mergeContactRequest.strategy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceId, strategy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MergeContactRequestImpl {\n");
    sb.append("    sourceId: ").append(toIndentedString(sourceId)).append("\n");
    sb.append("    strategy: ").append(toIndentedString(strategy)).append("\n");
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
  static class Builder implements MergeContactRequest.Builder {
    OptionalValue<String> sourceId = OptionalValue.empty();
    OptionalValue<ConversationMergeStrategy> strategy = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SOURCE_ID)
    public Builder setSourceId(String sourceId) {
      this.sourceId = OptionalValue.of(sourceId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STRATEGY)
    public Builder setStrategy(ConversationMergeStrategy strategy) {
      this.strategy = OptionalValue.of(strategy);
      return this;
    }

    public MergeContactRequest build() {
      return new MergeContactRequestImpl(sourceId, strategy);
    }
  }
}
