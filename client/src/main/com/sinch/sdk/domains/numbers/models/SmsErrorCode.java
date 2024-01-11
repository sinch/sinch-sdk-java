package com.sinch.sdk.domains.numbers.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Errors used in SMS Scheduled Provisioning configuration by the Numbers API
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/error-codes/provisioning-errors/">https://developers.sinch.com/docs/numbers/api-reference/error-codes/provisioning-errors/</a>
 * @since 1.0
 */
public final class SmsErrorCode extends EnumDynamic<String, SmsErrorCode> {
  public static final SmsErrorCode ERROR_CODE_UNSPECIFIED =
      new SmsErrorCode("ERROR_CODE_UNSPECIFIED");
  public static final SmsErrorCode INTERNAL_ERROR = new SmsErrorCode("INTERNAL_ERROR");
  public static final SmsErrorCode SMS_PROVISIONING_FAILED =
      new SmsErrorCode("SMS_PROVISIONING_FAILED");
  public static final SmsErrorCode CAMPAIGN_PROVISIONING_FAILED =
      new SmsErrorCode("CAMPAIGN_PROVISIONING_FAILED");
  public static final SmsErrorCode CAMPAIGN_NOT_AVAILABLE =
      new SmsErrorCode("CAMPAIGN_NOT_AVAILABLE");
  public static final SmsErrorCode EXCEEDED_10DLC_LIMIT = new SmsErrorCode("EXCEEDED_10DLC_LIMIT");
  public static final SmsErrorCode NUMBER_PROVISIONING_FAILED =
      new SmsErrorCode("NUMBER_PROVISIONING_FAILED");
  public static final SmsErrorCode PARTNER_SERVICE_UNAVAILABLE =
      new SmsErrorCode("PARTNER_SERVICE_UNAVAILABLE");
  public static final SmsErrorCode CAMPAIGN_PENDING_ACCEPTANCE =
      new SmsErrorCode("CAMPAIGN_PENDING_ACCEPTANCE");
  public static final SmsErrorCode MNO_SHARING_ERROR = new SmsErrorCode("MNO_SHARING_ERROR");
  public static final SmsErrorCode CAMPAIGN_EXPIRED = new SmsErrorCode("CAMPAIGN_EXPIRED");
  public static final SmsErrorCode CAMPAIGN_MNO_REJECTED =
      new SmsErrorCode("CAMPAIGN_MNO_REJECTED");
  public static final SmsErrorCode CAMPAIGN_MNO_SUSPENDED =
      new SmsErrorCode("CAMPAIGN_MNO_SUSPENDED");
  public static final SmsErrorCode CAMPAIGN_MNO_REVIEW = new SmsErrorCode("CAMPAIGN_MNO_REVIEW");
  public static final SmsErrorCode INSUFFICIENT_BALANCE = new SmsErrorCode("INSUFFICIENT_BALANCE");
  public static final SmsErrorCode MOCK_CAMPAIGN_NOT_ALLOWED =
      new SmsErrorCode("MOCK_CAMPAIGN_NOT_ALLOWED");
  public static final SmsErrorCode TFN_NOT_ALLOWED = new SmsErrorCode("TFN_NOT_ALLOWED");
  public static final SmsErrorCode INVALID_NNID = new SmsErrorCode("INVALID_NNID");
  public static final SmsErrorCode UNKNOWN_DEFAULT_OPEN_API =
      new SmsErrorCode("UNKNOWN_DEFAULT_OPEN_API");

  private static final EnumSupportDynamic<String, SmsErrorCode> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          SmsErrorCode.class,
          SmsErrorCode::new,
          Arrays.asList(
              ERROR_CODE_UNSPECIFIED,
              INTERNAL_ERROR,
              SMS_PROVISIONING_FAILED,
              CAMPAIGN_PROVISIONING_FAILED,
              CAMPAIGN_NOT_AVAILABLE,
              EXCEEDED_10DLC_LIMIT,
              NUMBER_PROVISIONING_FAILED,
              PARTNER_SERVICE_UNAVAILABLE,
              CAMPAIGN_PENDING_ACCEPTANCE,
              MNO_SHARING_ERROR,
              CAMPAIGN_EXPIRED,
              CAMPAIGN_MNO_REJECTED,
              CAMPAIGN_MNO_SUSPENDED,
              CAMPAIGN_MNO_REVIEW,
              INSUFFICIENT_BALANCE,
              MOCK_CAMPAIGN_NOT_ALLOWED,
              TFN_NOT_ALLOWED,
              INVALID_NNID,
              UNKNOWN_DEFAULT_OPEN_API));

  SmsErrorCode(String value) {
    super(value);
  }

  public static Stream<SmsErrorCode> values() {
    return ENUM_SUPPORT.values();
  }

  public static SmsErrorCode from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(SmsErrorCode e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
