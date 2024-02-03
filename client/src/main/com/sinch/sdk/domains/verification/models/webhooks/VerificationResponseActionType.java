package com.sinch.sdk.domains.verification.models.webhooks;

import com.fasterxml.jackson.annotation.JsonValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Determines whether the verification can be executed. See <a
 * href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post!c=200&amp;path=0/action&amp;t=response">action
 * type response documentation</a>
 *
 * @since 1.0
 */
public class VerificationResponseActionType
    extends EnumDynamic<String, VerificationResponseActionType> {

  /** Action is allowed */
  public static final VerificationResponseActionType ALLOW =
      new VerificationResponseActionType("allow");

  /** >Action is denied */
  public static final VerificationResponseActionType DENY =
      new VerificationResponseActionType("deny");

  /** */
  private static final EnumSupportDynamic<String, VerificationResponseActionType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationResponseActionType.class,
          VerificationResponseActionType::new,
          Arrays.asList(ALLOW, DENY));

  private VerificationResponseActionType(String value) {
    super(value);
  }

  /**
   * Get declared values
   *
   * @return Stream of values
   */
  public static Stream<VerificationResponseActionType> values() {
    return ENUM_SUPPORT.values();
  }

  /**
   * Get value from a string
   *
   * @param value String identifier
   * @return Dynamic enum from value. A new enum is created if value is not yet registered
   */
  public static VerificationResponseActionType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  /**
   * Value of the enum as String
   *
   * @param e The enum identifier
   * @return String identifier of the enum value
   */
  public static String valueOf(VerificationResponseActionType e) {
    return ENUM_SUPPORT.valueOf(e);
  }

  /**
   * Value of the enum as String
   *
   * @return String identifier of the enum value # @since 1.0
   */
  @JsonValue
  public String getValue() {
    return this.value();
  }
}
