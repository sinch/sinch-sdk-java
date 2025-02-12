package com.sinch.sdk.domains.sms.models.v1.deliveryreports.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Kind of delivery report */
public class QueryReportType extends EnumDynamic<String, QueryReportType> {

  /** Will count the number of messages sent per status. */
  public static final QueryReportType SUMMARY = new QueryReportType("summary");

  /** Report give that of a <code>summary</code> report but in addition, lists phone numbers. */
  public static final QueryReportType FULL = new QueryReportType("full");

  private static final EnumSupportDynamic<String, QueryReportType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          QueryReportType.class, QueryReportType::new, Arrays.asList(SUMMARY, FULL));

  private QueryReportType(String value) {
    super(value);
  }

  public static Stream<QueryReportType> values() {
    return ENUM_SUPPORT.values();
  }

  public static QueryReportType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(QueryReportType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
