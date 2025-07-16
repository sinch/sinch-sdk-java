package com.sinch.sdk.domains.numbers.models.v1.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The pattern to apply to searches. */
public class SearchPosition extends EnumDynamic<String, SearchPosition> {

  /** Numbers that start with the provided sequence of digits. */
  public static final SearchPosition START = new SearchPosition("START");

  /** Numbers that contain the sequence of digits entered. */
  public static final SearchPosition CONTAINS = new SearchPosition("CONTAINS");

  /** Numbers that end with the sequence of digits entered. */
  public static final SearchPosition END = new SearchPosition("END");

  private static final EnumSupportDynamic<String, SearchPosition> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          SearchPosition.class, SearchPosition::new, Arrays.asList(START, CONTAINS, END));

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
