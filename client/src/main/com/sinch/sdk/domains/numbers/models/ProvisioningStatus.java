package com.sinch.sdk.domains.numbers.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Provisioning Status
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/error-codes/provisioning-errors/">https://developers.sinch.com/docs/numbers/api-reference/error-codes/provisioning-errors/</a>
 * @since 1.0
 */
public final class ProvisioningStatus extends EnumDynamic<ProvisioningStatus> {

  public static final ProvisioningStatus PROVISIONING_STATUS_UNSPECIFIED =
      new ProvisioningStatus("PROVISIONING_STATUS_UNSPECIFIED");
  public static final ProvisioningStatus WAITING = new ProvisioningStatus("WAITING");
  public static final ProvisioningStatus IN_PROGRESS = new ProvisioningStatus("IN_PROGRESS");
  public static final ProvisioningStatus FAILED = new ProvisioningStatus("FAILED");
  public static final ProvisioningStatus UNKNOWN_DEFAULT_OPEN_API =
      new ProvisioningStatus("UNKNOWN_DEFAULT_OPEN_API");

  private static final EnumSupportDynamic<ProvisioningStatus> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ProvisioningStatus.class,
          ProvisioningStatus::new,
          Arrays.asList(
              PROVISIONING_STATUS_UNSPECIFIED,
              WAITING,
              IN_PROGRESS,
              FAILED,
              UNKNOWN_DEFAULT_OPEN_API));

  ProvisioningStatus(String value) {
    super(value);
  }

  public static Stream<ProvisioningStatus> values() {
    return ENUM_SUPPORT.values();
  }

  public static ProvisioningStatus from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ProvisioningStatus e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
