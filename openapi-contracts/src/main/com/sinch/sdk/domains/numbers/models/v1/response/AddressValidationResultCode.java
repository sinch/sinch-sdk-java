package com.sinch.sdk.domains.numbers.models.v1.response;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Enum representing the result of address validation. */
public class AddressValidationResultCode extends EnumDynamic<String, AddressValidationResultCode> {

  /** Undetermined Result */
  public static final AddressValidationResultCode ADDRESS_VALIDATION_RESULT_CODE_UNSPECIFIED =
      new AddressValidationResultCode("ADDRESS_VALIDATION_RESULT_CODE_UNSPECIFIED");

  /** The address is perfect as sent */
  public static final AddressValidationResultCode EXACT_MATCH =
      new AddressValidationResultCode("EXACT_MATCH");

  /** The result was a close enough match and has been corrected */
  public static final AddressValidationResultCode NEAR_MATCH =
      new AddressValidationResultCode("NEAR_MATCH");

  /** The result is not close enough */
  public static final AddressValidationResultCode NO_MATCH =
      new AddressValidationResultCode("NO_MATCH");

  private static final EnumSupportDynamic<String, AddressValidationResultCode> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          AddressValidationResultCode.class,
          AddressValidationResultCode::new,
          Arrays.asList(
              ADDRESS_VALIDATION_RESULT_CODE_UNSPECIFIED, EXACT_MATCH, NEAR_MATCH, NO_MATCH));

  private AddressValidationResultCode(String value) {
    super(value);
  }

  public static Stream<AddressValidationResultCode> values() {
    return ENUM_SUPPORT.values();
  }

  public static AddressValidationResultCode from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(AddressValidationResultCode e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
