package com.sinch.sdk.domains.conversation.models.v1.app;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets RetentionPolicyType */
public class RetentionPolicyType extends EnumDynamic<String, RetentionPolicyType> {

  /**
   * The default retention policy where messages older than ttl_days are automatically deleted from
   * Conversation API database.
   */
  public static final RetentionPolicyType MESSAGE_EXPIRE_POLICY =
      new RetentionPolicyType("MESSAGE_EXPIRE_POLICY");

  /**
   * The conversation expire policy only considers the last message in a conversation. If the last
   * message is older that ttl_days the entire conversation is deleted. The difference with
   * MESSAGE_EXPIRE_POLICY is that messages with accept_time older than ttl_days are persisted as
   * long as there is a newer message in the same conversation.
   */
  public static final RetentionPolicyType CONVERSATION_EXPIRE_POLICY =
      new RetentionPolicyType("CONVERSATION_EXPIRE_POLICY");

  /**
   * Persist policy does not delete old messages or conversations. Please note that message storage
   * might be subject to additional charges in the future.
   */
  public static final RetentionPolicyType PERSIST_RETENTION_POLICY =
      new RetentionPolicyType("PERSIST_RETENTION_POLICY");

  private static final EnumSupportDynamic<String, RetentionPolicyType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          RetentionPolicyType.class,
          RetentionPolicyType::new,
          Arrays.asList(
              MESSAGE_EXPIRE_POLICY, CONVERSATION_EXPIRE_POLICY, PERSIST_RETENTION_POLICY));

  private RetentionPolicyType(String value) {
    super(value);
  }

  public static Stream<RetentionPolicyType> values() {
    return ENUM_SUPPORT.values();
  }

  public static RetentionPolicyType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(RetentionPolicyType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
