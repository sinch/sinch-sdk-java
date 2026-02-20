package com.sinch.sdk.domains.conversation.models.v1.conversations.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import java.util.Objects;

public class ConversationsUpdateQueryParametersImpl implements ConversationsUpdateQueryParameters {

  private final OptionalValue<MetadataUpdateStrategy> metadataUpdateStrategy;

  private ConversationsUpdateQueryParametersImpl(
      OptionalValue<MetadataUpdateStrategy> metadataUpdateStrategy) {
    this.metadataUpdateStrategy = metadataUpdateStrategy;
  }

  public OptionalValue<MetadataUpdateStrategy> getMetadataUpdateStrategy() {
    return metadataUpdateStrategy;
  }

  /** Return true if this ConversationUpdateConversationQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversationsUpdateQueryParametersImpl conversationUpdateConversationQueryParameters =
        (ConversationsUpdateQueryParametersImpl) o;
    return Objects.equals(
        this.metadataUpdateStrategy,
        conversationUpdateConversationQueryParameters.metadataUpdateStrategy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadataUpdateStrategy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversationsUpdateQueryParametersImpl {\n");
    sb.append("    metadataUpdateStrategy: ")
        .append(toIndentedString(metadataUpdateStrategy))
        .append("\n");
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

  static class Builder implements ConversationsUpdateQueryParameters.Builder {
    OptionalValue<MetadataUpdateStrategy> metadataUpdateStrategy = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ConversationsUpdateQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ConversationsUpdateQueryParametersImpl parameters =
          (ConversationsUpdateQueryParametersImpl) _parameters;
      this.metadataUpdateStrategy = parameters.getMetadataUpdateStrategy();
    }

    public Builder setMetadataUpdateStrategy(MetadataUpdateStrategy metadataUpdateStrategy) {
      this.metadataUpdateStrategy = OptionalValue.of(metadataUpdateStrategy);
      return this;
    }

    public ConversationsUpdateQueryParameters build() {
      return new ConversationsUpdateQueryParametersImpl(metadataUpdateStrategy);
    }
  }
}
