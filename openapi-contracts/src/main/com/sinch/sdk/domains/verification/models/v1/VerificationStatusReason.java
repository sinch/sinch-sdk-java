package com.sinch.sdk.domains.verification.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Displays the reason why a verification has &#x60;FAILED&#x60;, was &#x60;DENIED&#x60;, or was
 * &#x60;ABORTED&#x60;.
 */
public class VerificationStatusReason extends EnumDynamic<String, VerificationStatusReason> {

  public static final VerificationStatusReason FRAUD = new VerificationStatusReason("Fraud");

  public static final VerificationStatusReason NOT_ENOUGH_CREDIT =
      new VerificationStatusReason("Not enough credit");

  public static final VerificationStatusReason BLOCKED = new VerificationStatusReason("Blocked");

  public static final VerificationStatusReason DENIED_BY_CALLBACK =
      new VerificationStatusReason("Denied by callback");

  public static final VerificationStatusReason INVALID_CALLBACK =
      new VerificationStatusReason("Invalid callback");

  public static final VerificationStatusReason INTERNAL_ERROR =
      new VerificationStatusReason("Internal error");

  public static final VerificationStatusReason DESTINATION_DENIED =
      new VerificationStatusReason("Destination denied");

  public static final VerificationStatusReason NETWORK_ERROR_OR_NUMBER_UNREACHABLE =
      new VerificationStatusReason("Network error or number unreachable");

  public static final VerificationStatusReason FAILED_PENDING =
      new VerificationStatusReason("Failed pending");

  public static final VerificationStatusReason SMS_DELIVERY_FAILURE =
      new VerificationStatusReason("SMS delivery failure");

  public static final VerificationStatusReason INVALID_CLI =
      new VerificationStatusReason("Invalid CLI");

  public static final VerificationStatusReason INVALID_CODE =
      new VerificationStatusReason("Invalid code");

  public static final VerificationStatusReason EXPIRED = new VerificationStatusReason("Expired");

  public static final VerificationStatusReason HUNG_UP_WITHOUT_ENTERING_VALID_CODE =
      new VerificationStatusReason("Hung up without entering valid code");

  private static final EnumSupportDynamic<String, VerificationStatusReason> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationStatusReason.class,
          VerificationStatusReason::new,
          Arrays.asList(
              FRAUD,
              NOT_ENOUGH_CREDIT,
              BLOCKED,
              DENIED_BY_CALLBACK,
              INVALID_CALLBACK,
              INTERNAL_ERROR,
              DESTINATION_DENIED,
              NETWORK_ERROR_OR_NUMBER_UNREACHABLE,
              FAILED_PENDING,
              SMS_DELIVERY_FAILURE,
              INVALID_CLI,
              INVALID_CODE,
              EXPIRED,
              HUNG_UP_WITHOUT_ENTERING_VALID_CODE));

  private VerificationStatusReason(String value) {
    super(value);
  }

  public static Stream<VerificationStatusReason> values() {
    return ENUM_SUPPORT.values();
  }

  public static VerificationStatusReason from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VerificationStatusReason e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
