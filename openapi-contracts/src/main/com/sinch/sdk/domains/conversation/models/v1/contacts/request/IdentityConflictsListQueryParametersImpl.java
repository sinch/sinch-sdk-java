package com.sinch.sdk.domains.conversation.models.v1.contacts.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class IdentityConflictsListQueryParametersImpl
    implements IdentityConflictsListQueryParameters {

  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;

  private IdentityConflictsListQueryParametersImpl(
      OptionalValue<Integer> pageSize, OptionalValue<String> pageToken) {
    this.pageSize = pageSize;
    this.pageToken = pageToken;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<String> getPageToken() {
    return pageToken;
  }

  /** Return true if this ContactListIdentityConflictsQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityConflictsListQueryParametersImpl contactListIdentityConflictsQueryParameters =
        (IdentityConflictsListQueryParametersImpl) o;
    return Objects.equals(this.pageSize, contactListIdentityConflictsQueryParameters.pageSize)
        && Objects.equals(this.pageToken, contactListIdentityConflictsQueryParameters.pageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageSize, pageToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentityConflictsListQueryParametersImpl {\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageToken: ").append(toIndentedString(pageToken)).append("\n");
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

  static class Builder implements IdentityConflictsListQueryParameters.Builder {
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();

    protected Builder() {}

    protected Builder(IdentityConflictsListQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      IdentityConflictsListQueryParametersImpl parameters =
          (IdentityConflictsListQueryParametersImpl) _parameters;
      this.pageSize = parameters.getPageSize();
      this.pageToken = parameters.getPageToken();
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public Builder setPageToken(String pageToken) {
      this.pageToken = OptionalValue.of(pageToken);
      return this;
    }

    public IdentityConflictsListQueryParameters build() {
      return new IdentityConflictsListQueryParametersImpl(pageSize, pageToken);
    }
  }
}
