package com.sinch.sdk.domains.numbers.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;

/**
 * Search pattern for numbers
 *
 * @since 1.0
 */
public final class SearchPattern extends EnumDynamic<String, SearchPattern> {
  /**
   * Numbers that begin with the @see NumberPattern.getPattern entered.
   *
   * <p>Often used to search for a specific area code. When using START, a plus sign (+) must be
   * included and URL encoded, so %2B.
   *
   * <p>For example, to search for area code 206 in the US, you would enter, %2b1206
   */
  public static final SearchPattern START = new SearchPattern("START");

  /**
   * The number pattern entered is contained somewhere in the number, the location being undefined.
   */
  public static final SearchPattern CONTAINS = new SearchPattern("CONTAINS");

  /** The number ends with the number pattern entered. */
  public static final SearchPattern END = new SearchPattern("END");

  private static final EnumSupportDynamic<String, SearchPattern> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          SearchPattern.class, SearchPattern::new, Arrays.asList(START, CONTAINS, END));

  private SearchPattern(String value) {
    super(value);
  }
}
