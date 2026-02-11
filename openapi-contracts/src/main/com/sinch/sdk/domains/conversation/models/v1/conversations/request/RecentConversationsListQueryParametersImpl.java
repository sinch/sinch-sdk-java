package com.sinch.sdk.domains.conversation.models.v1.conversations.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class RecentConversationsListQueryParametersImpl
    implements RecentConversationsListQueryParameters {

  private final OptionalValue<String> appId;
  private final OptionalValue<Boolean> onlyActive;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;
  private final OptionalValue<OrderEnum> order;

  private RecentConversationsListQueryParametersImpl(
      OptionalValue<String> appId,
      OptionalValue<Boolean> onlyActive,
      OptionalValue<Integer> pageSize,
      OptionalValue<String> pageToken,
      OptionalValue<OrderEnum> order) {
    this.appId = appId;
    this.onlyActive = onlyActive;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
    this.order = order;
  }

  public OptionalValue<String> getAppId() {
    return appId;
  }

  public OptionalValue<Boolean> getOnlyActive() {
    return onlyActive;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<String> getPageToken() {
    return pageToken;
  }

  public OptionalValue<OrderEnum> getOrder() {
    return order;
  }

  /**
   * Return true if this ConversationListRecentConversationsQueryParameters object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecentConversationsListQueryParametersImpl conversationListRecentConversationsQueryParameters =
        (RecentConversationsListQueryParametersImpl) o;
    return Objects.equals(this.appId, conversationListRecentConversationsQueryParameters.appId)
        && Objects.equals(
            this.onlyActive, conversationListRecentConversationsQueryParameters.onlyActive)
        && Objects.equals(
            this.pageSize, conversationListRecentConversationsQueryParameters.pageSize)
        && Objects.equals(
            this.pageToken, conversationListRecentConversationsQueryParameters.pageToken)
        && Objects.equals(this.order, conversationListRecentConversationsQueryParameters.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, onlyActive, pageSize, pageToken, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecentConversationsListQueryParametersImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    onlyActive: ").append(toIndentedString(onlyActive)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageToken: ").append(toIndentedString(pageToken)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

  static class Builder implements RecentConversationsListQueryParameters.Builder {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<Boolean> onlyActive = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();
    OptionalValue<OrderEnum> order = OptionalValue.empty();

    protected Builder() {}

    protected Builder(RecentConversationsListQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      RecentConversationsListQueryParametersImpl parameters =
          (RecentConversationsListQueryParametersImpl) _parameters;
      this.appId = parameters.getAppId();
      this.onlyActive = parameters.getOnlyActive();
      this.pageSize = parameters.getPageSize();
      this.pageToken = parameters.getPageToken();
      this.order = parameters.getOrder();
    }

    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    public Builder setOnlyActive(Boolean onlyActive) {
      this.onlyActive = OptionalValue.of(onlyActive);
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public Builder setPageToken(String pageToken) {
      this.pageToken = OptionalValue.of(pageToken);
      return this;
    }

    public Builder setOrder(OrderEnum order) {
      this.order = OptionalValue.of(order);
      return this;
    }

    public RecentConversationsListQueryParameters build() {
      return new RecentConversationsListQueryParametersImpl(
          appId, onlyActive, pageSize, pageToken, order);
    }
  }
}
