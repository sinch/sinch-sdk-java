package com.sinch.sdk.domains.numbers.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The pattern to apply to searches */
public class SearchPosition extends EnumDynamic<String, SearchPosition> {

  /** Numbers that begin with the pattern entered */
  public static final SearchPosition START = new SearchPosition("START");

  /** The number ends with the pattern entered */
  public static final SearchPosition END = new SearchPosition("END");

  /** The pattern entered is contained somewhere in the number, the location being undefined */
  public static final SearchPosition CONTAINS = new SearchPosition("CONTAINS");

  private static final EnumSupportDynamic<String, SearchPosition> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          SearchPosition.class, SearchPosition::new, Arrays.asList(START, END, CONTAINS));

  private SearchPosition(String value) {
    super(value);
  }

  public static Stream<SearchPosition> values() {
    return ENUM_SUPPORT.values();
  }

  public static SearchPosition from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(SearchPosition e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
