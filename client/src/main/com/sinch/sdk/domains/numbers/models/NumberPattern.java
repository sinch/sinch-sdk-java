package com.sinch.sdk.domains.numbers.models;

/**
 * An object enabling to identify number by pattern
 *
 * @since 1.0
 */
public class NumberPattern {

  private final String pattern;
  private final SearchPattern searchPattern;

  /**
   * @param pattern Sequence of digits to search for.
   * @param searchPattern The pattern to apply to searches
   */
  public NumberPattern(String pattern, SearchPattern searchPattern) {
    this.pattern = pattern;
    this.searchPattern = searchPattern;
  }

  public String getPattern() {
    return pattern;
  }

  public SearchPattern getSearchPattern() {
    return searchPattern;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "NumberPattern{"
        + "pattern='"
        + pattern
        + '\''
        + ", searchPattern='"
        + searchPattern
        + '\''
        + '}';
  }

  public static class Builder {
    private String pattern;

    private SearchPattern searchPattern;

    private Builder() {}

    public Builder setPattern(String value) {
      this.pattern = value;
      return this;
    }

    public Builder setSearchPattern(SearchPattern value) {
      this.searchPattern = value;
      return this;
    }

    public NumberPattern build() {
      return new NumberPattern(this.pattern, this.searchPattern);
    }
  }
}
