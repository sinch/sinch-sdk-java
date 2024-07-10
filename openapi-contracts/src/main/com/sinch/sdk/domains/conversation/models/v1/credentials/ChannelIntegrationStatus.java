package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Status of the channel credentials integration */
public class ChannelIntegrationStatus extends EnumDynamic<String, ChannelIntegrationStatus> {

  /** Initial status when the channel has been activated in the front-end. */
  public static final ChannelIntegrationStatus PENDING = new ChannelIntegrationStatus("PENDING");

  /**
   * Credentials have been successfully validated and exchanged for a long-lived token. This status
   * is used by default for channels in which the credential can't be validated.
   */
  public static final ChannelIntegrationStatus ACTIVE = new ChannelIntegrationStatus("ACTIVE");

  /** Failed to validate credentials and acquire a long-lived token. */
  public static final ChannelIntegrationStatus FAILING = new ChannelIntegrationStatus("FAILING");

  private static final EnumSupportDynamic<String, ChannelIntegrationStatus> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ChannelIntegrationStatus.class,
          ChannelIntegrationStatus::new,
          Arrays.asList(PENDING, ACTIVE, FAILING));

  private ChannelIntegrationStatus(String value) {
    super(value);
  }

  public static Stream<ChannelIntegrationStatus> values() {
    return ENUM_SUPPORT.values();
  }

  public static ChannelIntegrationStatus from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ChannelIntegrationStatus e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
