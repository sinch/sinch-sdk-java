package com.sinch.sdk.domains.mailgun.models.v1.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  PagingResponseImpl.JSON_PROPERTY_PREVIOUS,
  PagingResponseImpl.JSON_PROPERTY_FIRST,
  PagingResponseImpl.JSON_PROPERTY_NEXT,
  PagingResponseImpl.JSON_PROPERTY_LAST
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PagingResponseImpl implements PagingResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PREVIOUS = "previous";

  private OptionalValue<String> previous;

  public static final String JSON_PROPERTY_FIRST = "first";

  private OptionalValue<String> first;

  public static final String JSON_PROPERTY_NEXT = "next";

  private OptionalValue<String> next;

  public static final String JSON_PROPERTY_LAST = "last";

  private OptionalValue<String> last;

  public PagingResponseImpl() {}

  protected PagingResponseImpl(
      OptionalValue<String> previous,
      OptionalValue<String> first,
      OptionalValue<String> next,
      OptionalValue<String> last) {
    this.previous = previous;
    this.first = first;
    this.next = next;
    this.last = last;
  }

  @JsonIgnore
  public String getPrevious() {
    return previous.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PREVIOUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> previous() {
    return previous;
  }

  @JsonIgnore
  public String getFirst() {
    return first.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> first() {
    return first;
  }

  @JsonIgnore
  public String getNext() {
    return next.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> next() {
    return next;
  }

  @JsonIgnore
  public String getLast() {
    return last.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LAST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> last() {
    return last;
  }

  /**
   * Return true if this github.com-mailgun-scaffold-httpapi-paging-PagingResponse object is equal
   * to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PagingResponseImpl githubComMailgunScaffoldHttpapiPagingPagingResponse = (PagingResponseImpl) o;
    return Objects.equals(
            this.previous, githubComMailgunScaffoldHttpapiPagingPagingResponse.previous)
        && Objects.equals(this.first, githubComMailgunScaffoldHttpapiPagingPagingResponse.first)
        && Objects.equals(this.next, githubComMailgunScaffoldHttpapiPagingPagingResponse.next)
        && Objects.equals(this.last, githubComMailgunScaffoldHttpapiPagingPagingResponse.last);
  }

  @Override
  public int hashCode() {
    return Objects.hash(previous, first, next, last);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PagingResponseImpl {\n");
    sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
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
  static class Builder implements PagingResponse.Builder {
    OptionalValue<String> previous = OptionalValue.empty();
    OptionalValue<String> first = OptionalValue.empty();
    OptionalValue<String> next = OptionalValue.empty();
    OptionalValue<String> last = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_PREVIOUS, required = true)
    public Builder setPrevious(String previous) {
      this.previous = OptionalValue.of(previous);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_FIRST, required = true)
    public Builder setFirst(String first) {
      this.first = OptionalValue.of(first);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_NEXT, required = true)
    public Builder setNext(String next) {
      this.next = OptionalValue.of(next);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_LAST, required = true)
    public Builder setLast(String last) {
      this.last = OptionalValue.of(last);
      return this;
    }

    public PagingResponse build() {
      return new PagingResponseImpl(previous, first, next, last);
    }
  }
}
