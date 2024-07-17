package com.sinch.sdk.domains.numbers.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The error codes that show the reason of failure of a scheduled provisioning */
public class SmsErrorCode extends EnumDynamic<String, SmsErrorCode> {

  /** Code not specified. */
  public static final SmsErrorCode ERROR_CODE_UNSPECIFIED =
      new SmsErrorCode("ERROR_CODE_UNSPECIFIED");

  /** Internal server error. */
  public static final SmsErrorCode INTERNAL_ERROR = new SmsErrorCode("INTERNAL_ERROR");

  /** Provisioning for SMS failed. */
  public static final SmsErrorCode SMS_PROVISIONING_FAILED =
      new SmsErrorCode("SMS_PROVISIONING_FAILED");

  /** Provisioning for campaign failed. */
  public static final SmsErrorCode CAMPAIGN_PROVISIONING_FAILED =
      new SmsErrorCode("CAMPAIGN_PROVISIONING_FAILED");

  /** The specified campaign is not available. */
  public static final SmsErrorCode CAMPAIGN_NOT_AVAILABLE =
      new SmsErrorCode("CAMPAIGN_NOT_AVAILABLE");

  /** Exceeded the 10DLC limit. */
  public static final SmsErrorCode EXCEEDED_10DLC_LIMIT = new SmsErrorCode("EXCEEDED_10DLC_LIMIT");

  /** Failed to provision the number. */
  public static final SmsErrorCode NUMBER_PROVISIONING_FAILED =
      new SmsErrorCode("NUMBER_PROVISIONING_FAILED");

  /** The third party service is unavailable. */
  public static final SmsErrorCode PARTNER_SERVICE_UNAVAILABLE =
      new SmsErrorCode("PARTNER_SERVICE_UNAVAILABLE");

  /** The campaign is awaiting acceptance. */
  public static final SmsErrorCode CAMPAIGN_PENDING_ACCEPTANCE =
      new SmsErrorCode("CAMPAIGN_PENDING_ACCEPTANCE");

  /** Sharing error. */
  public static final SmsErrorCode MNO_SHARING_ERROR = new SmsErrorCode("MNO_SHARING_ERROR");

  /** The specific campaign has expired. */
  public static final SmsErrorCode CAMPAIGN_EXPIRED = new SmsErrorCode("CAMPAIGN_EXPIRED");

  /** The MNO for the campaign was rejected. */
  public static final SmsErrorCode CAMPAIGN_MNO_REJECTED =
      new SmsErrorCode("CAMPAIGN_MNO_REJECTED");

  /** The MNO for the campaign was suspended. */
  public static final SmsErrorCode CAMPAIGN_MNO_SUSPENDED =
      new SmsErrorCode("CAMPAIGN_MNO_SUSPENDED");

  /** The MNO for the campaign is under review. */
  public static final SmsErrorCode CAMPAIGN_MNO_REVIEW = new SmsErrorCode("CAMPAIGN_MNO_REVIEW");

  /** The credit balance for the account is insufficient to cover the fees. */
  public static final SmsErrorCode INSUFFICIENT_BALANCE = new SmsErrorCode("INSUFFICIENT_BALANCE");

  /** Mock campaign is not permitted. */
  public static final SmsErrorCode MOCK_CAMPAIGN_NOT_ALLOWED =
      new SmsErrorCode("MOCK_CAMPAIGN_NOT_ALLOWED");

  /** The Toll-Free number is not allowed. */
  public static final SmsErrorCode TFN_NOT_ALLOWED = new SmsErrorCode("TFN_NOT_ALLOWED");

  /** The specified NNID is invalid. */
  public static final SmsErrorCode INVALID_NNID = new SmsErrorCode("INVALID_NNID");

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
              INVALID_NNID));

  private SmsErrorCode(String value) {
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
