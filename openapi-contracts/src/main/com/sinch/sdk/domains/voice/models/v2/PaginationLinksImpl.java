package com.sinch.sdk.domains.voice.models.v2;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  PaginationLinksImpl.JSON_PROPERTY_FIRST,
  PaginationLinksImpl.JSON_PROPERTY_LAST,
  PaginationLinksImpl.JSON_PROPERTY_NEXT,
  PaginationLinksImpl.JSON_PROPERTY_PREV,
  PaginationLinksImpl.JSON_PROPERTY_SELF
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PaginationLinksImpl implements PaginationLinks {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_FIRST = "first";

  private OptionalValue<String> first;

  public static final String JSON_PROPERTY_LAST = "last";

  private OptionalValue<String> last;

  public static final String JSON_PROPERTY_NEXT = "next";

  private OptionalValue<String> next;

  public static final String JSON_PROPERTY_PREV = "prev";

  private OptionalValue<String> prev;

  public static final String JSON_PROPERTY_SELF = "self";

  private OptionalValue<String> self;

  public PaginationLinksImpl() {}

  protected PaginationLinksImpl(
      OptionalValue<String> first,
      OptionalValue<String> last,
      OptionalValue<String> next,
      OptionalValue<String> prev,
      OptionalValue<String> self) {
    this.first = first;
    this.last = last;
    this.next = next;
    this.prev = prev;
    this.self = self;
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
  public String getLast() {
    return last.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LAST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> last() {
    return last;
  }

  @JsonIgnore
  public String getNext() {
    return next.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> next() {
    return next;
  }

  @JsonIgnore
  public String getPrev() {
    return prev.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PREV)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> prev() {
    return prev;
  }

  @JsonIgnore
  public String getSelf() {
    return self.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> self() {
    return self;
  }

  /** Return true if this PaginationLinks object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginationLinksImpl paginationLinks = (PaginationLinksImpl) o;
    return Objects.equals(this.first, paginationLinks.first)
        && Objects.equals(this.last, paginationLinks.last)
        && Objects.equals(this.next, paginationLinks.next)
        && Objects.equals(this.prev, paginationLinks.prev)
        && Objects.equals(this.self, paginationLinks.self);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, last, next, prev, self);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginationLinksImpl {\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
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
  static class Builder implements PaginationLinks.Builder {
    OptionalValue<String> first = OptionalValue.empty();
    OptionalValue<String> last = OptionalValue.empty();
    OptionalValue<String> next = OptionalValue.empty();
    OptionalValue<String> prev = OptionalValue.empty();
    OptionalValue<String> self = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_FIRST, required = true)
    public Builder setFirst(String first) {
      this.first = OptionalValue.of(first);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_LAST, required = true)
    public Builder setLast(String last) {
      this.last = OptionalValue.of(last);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NEXT)
    public Builder setNext(String next) {
      this.next = OptionalValue.of(next);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PREV)
    public Builder setPrev(String prev) {
      this.prev = OptionalValue.of(prev);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SELF, required = true)
    public Builder setSelf(String self) {
      this.self = OptionalValue.of(self);
      return this;
    }

    public PaginationLinks build() {
      return new PaginationLinksImpl(first, last, next, prev, self);
    }
  }
}
