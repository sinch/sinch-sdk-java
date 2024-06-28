package com.sinch.sdk.domains.numbers.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  SearchPatternImpl.JSON_PROPERTY_PATTERN,
  SearchPatternImpl.JSON_PROPERTY_SEARCH_PATTERN
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SearchPatternImpl implements SearchPattern {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PATTERN = "pattern";

  private OptionalValue<String> pattern;

  public static final String JSON_PROPERTY_SEARCH_PATTERN = "searchPattern";

  private OptionalValue<SearchPosition> position;

  public SearchPatternImpl() {}

  protected SearchPatternImpl(
      OptionalValue<String> pattern, OptionalValue<SearchPosition> position) {
    this.pattern = pattern;
    this.position = position;
  }

  @JsonIgnore
  public String getPattern() {
    return pattern.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PATTERN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> pattern() {
    return pattern;
  }

  @JsonIgnore
  public SearchPosition getPosition() {
    return position.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SEARCH_PATTERN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SearchPosition> position() {
    return position;
  }

  /** Return true if this SearchPattern object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchPatternImpl searchPattern = (SearchPatternImpl) o;
    return Objects.equals(this.pattern, searchPattern.pattern)
        && Objects.equals(this.position, searchPattern.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pattern, position);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchPatternImpl {\n");
    sb.append("    pattern: ").append(toIndentedString(pattern)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
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
  static class Builder implements SearchPattern.Builder {
    OptionalValue<String> pattern = OptionalValue.empty();
    OptionalValue<SearchPosition> position = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PATTERN)
    public Builder setPattern(String pattern) {
      this.pattern = OptionalValue.of(pattern);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SEARCH_PATTERN)
    public Builder setPosition(SearchPosition position) {
      this.position = OptionalValue.of(position);
      return this;
    }

    public SearchPattern build() {
      return new SearchPatternImpl(pattern, position);
    }
  }
}
