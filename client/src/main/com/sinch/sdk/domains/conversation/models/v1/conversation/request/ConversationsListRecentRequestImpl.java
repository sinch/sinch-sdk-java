package com.sinch.sdk.domains.conversation.models.v1.conversation.request;

import java.util.Optional;

public class ConversationsListRecentRequestImpl implements ConversationsListRecentRequest {

  final Boolean onlyActive;
  final String appId;
  final Integer pageSize;
  final String pageToken;
  final OrderEnum order;

  public ConversationsListRecentRequestImpl(
      Boolean onlyActive, String appId, Integer pageSize, String pageToken, OrderEnum order) {
    this.onlyActive = onlyActive;
    this.appId = appId;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
    this.order = order;
  }

  @Override
  public Optional<Boolean> getOnlyActive() {
    return Optional.ofNullable(onlyActive);
  }

  @Override
  public Optional<String> getAppId() {
    return Optional.ofNullable(appId);
  }

  @Override
  public Optional<Integer> getPageSize() {
    return Optional.ofNullable(pageSize);
  }

  @Override
  public Optional<String> getPageToken() {
    return Optional.ofNullable(pageToken);
  }

  @Override
  public Optional<OrderEnum> getOrder() {
    return Optional.ofNullable(order);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(ConversationsListRecentRequest parameters) {
    return new Builder(parameters);
  }

  public static class Builder implements ConversationsListRecentRequest.Builder {

    Boolean onlyActive;
    String appId;
    Integer pageSize;
    String pageToken;
    OrderEnum order;

    Builder() {}

    Builder(ConversationsListRecentRequest parameters) {

      parameters.getOnlyActive().ifPresent(this::setOnlyActive);
      parameters.getAppId().ifPresent(this::setAppId);
      parameters.getPageSize().ifPresent(this::setPageSize);
      parameters.getPageToken().ifPresent(this::setPageToken);
      parameters.getOrder().ifPresent(this::setOrder);
    }

    @Override
    public Builder setOnlyActive(Boolean onlyActive) {
      this.onlyActive = onlyActive;
      return this;
    }

    @Override
    public Builder setAppId(String appId) {
      this.appId = appId;
      return this;
    }

    @Override
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    @Override
    public Builder setPageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    @Override
    public Builder setOrder(OrderEnum order) {
      this.order = order;
      return this;
    }

    public ConversationsListRecentRequest build() {
      return new ConversationsListRecentRequestImpl(onlyActive, appId, pageSize, pageToken, order);
    }
  }
}
