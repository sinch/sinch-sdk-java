package com.sinch.sdk.domains.numbers.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The provisioning status. It will be either <code>WAITING</code>, <code>IN_PROGRESS</code> or
 * <code>FAILED</code>. If the provisioning fails, a reason for the failure will be provided.
 */
public class ProvisioningStatus extends EnumDynamic<String, ProvisioningStatus> {

  /** The status is currently unknown. */
  public static final ProvisioningStatus PROVISIONING_STATUS_UNSPECIFIED =
      new ProvisioningStatus("PROVISIONING_STATUS_UNSPECIFIED");

  /** Waiting to be provisioned. */
  public static final ProvisioningStatus WAITING = new ProvisioningStatus("WAITING");

  /** Provisioning in progress. */
  public static final ProvisioningStatus IN_PROGRESS = new ProvisioningStatus("IN_PROGRESS");

  /** Provisioning has failed. */
  public static final ProvisioningStatus FAILED = new ProvisioningStatus("FAILED");

  private static final EnumSupportDynamic<String, ProvisioningStatus> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ProvisioningStatus.class,
          ProvisioningStatus::new,
          Arrays.asList(PROVISIONING_STATUS_UNSPECIFIED, WAITING, IN_PROGRESS, FAILED));

  private ProvisioningStatus(String value) {
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
