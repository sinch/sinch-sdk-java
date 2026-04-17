package com.sinch.sdk.domains.conversation.models.v1.consents.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class ConsentsListQueryParametersImpl implements ConsentsListQueryParameters {

  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;

  private ConsentsListQueryParametersImpl(
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

  /** Return true if this ConsentsGetConsentsQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentsListQueryParametersImpl consentsGetConsentsQueryParameters =
        (ConsentsListQueryParametersImpl) o;
    return Objects.equals(this.pageSize, consentsGetConsentsQueryParameters.pageSize)
        && Objects.equals(this.pageToken, consentsGetConsentsQueryParameters.pageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageSize, pageToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentsListQueryParametersImpl {\n");
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

  static class Builder implements ConsentsListQueryParameters.Builder {
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ConsentsListQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ConsentsListQueryParametersImpl parameters = (ConsentsListQueryParametersImpl) _parameters;
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

    public ConsentsListQueryParameters build() {
      return new ConsentsListQueryParametersImpl(pageSize, pageToken);
    }
  }
}
