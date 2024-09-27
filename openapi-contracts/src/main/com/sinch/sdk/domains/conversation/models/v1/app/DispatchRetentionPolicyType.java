package com.sinch.sdk.domains.conversation.models.v1.app;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets DispatchRetentionPolicyType */
public class DispatchRetentionPolicyType extends EnumDynamic<String, DispatchRetentionPolicyType> {

  /**
   * Removes all messages, sent or received by the app, older than the TTL days specified in the
   * policy.
   */
  public static final DispatchRetentionPolicyType MESSAGE_EXPIRE_POLICY =
      new DispatchRetentionPolicyType("MESSAGE_EXPIRE_POLICY");

  private static final EnumSupportDynamic<String, DispatchRetentionPolicyType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DispatchRetentionPolicyType.class,
          DispatchRetentionPolicyType::new,
          Arrays.asList(MESSAGE_EXPIRE_POLICY));

  private DispatchRetentionPolicyType(String value) {
    super(value);
  }

  public static Stream<DispatchRetentionPolicyType> values() {
    return ENUM_SUPPORT.values();
  }

  public static DispatchRetentionPolicyType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DispatchRetentionPolicyType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
