package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Credentials State Status values
 *
 * @since 1.0
 */
public final class CredentialStateStatusType
    extends EnumDynamic<String, CredentialStateStatusType> {

  public static final CredentialStateStatusType PENDING = new CredentialStateStatusType("PENDING");
  public static final CredentialStateStatusType ACTIVE = new CredentialStateStatusType("ACTIVE");
  public static final CredentialStateStatusType FAILING = new CredentialStateStatusType("FAILING");

  private static final EnumSupportDynamic<String, CredentialStateStatusType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CredentialStateStatusType.class,
          CredentialStateStatusType::new,
          Arrays.asList(PENDING, ACTIVE, FAILING));

  private CredentialStateStatusType(String value) {
    super(value);
  }

  public static Stream<CredentialStateStatusType> values() {
    return ENUM_SUPPORT.values();
  }

  public static CredentialStateStatusType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CredentialStateStatusType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
