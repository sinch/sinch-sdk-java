package com.sinch.sdk.domains.conversation.models.v1.contact.request;

import com.sinch.sdk.core.models.OptionalValue;

public class IdentityConflictsListRequest {

  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;

  private IdentityConflictsListRequest(
      OptionalValue<Integer> pageSize, OptionalValue<String> pageToken) {
    this.pageSize = pageSize;
    this.pageToken = pageToken;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(IdentityConflictsListRequest parameters) {
    return new Builder(parameters);
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<String> getPageToken() {
    return pageToken;
  }

  public static class Builder {

    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();

    private Builder() {}

    private Builder(IdentityConflictsListRequest parameters) {
      if (null == parameters) {
        return;
      }
      parameters.pageSize.ifPresent(this::setPageSize);
      parameters.pageToken.ifPresent(this::setPageToken);
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public Builder setPageToken(String pageToken) {
      this.pageToken = OptionalValue.of(pageToken);
      return this;
    }

    public IdentityConflictsListRequest build() {
      return new IdentityConflictsListRequest(pageSize, pageToken);
    }
  }
}
