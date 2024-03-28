package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets ReasonCode */
public class ReasonCode extends EnumDynamic<String, ReasonCode> {

  public static final ReasonCode UNKNOWN = new ReasonCode("UNKNOWN");

  public static final ReasonCode INTERNAL_ERROR = new ReasonCode("INTERNAL_ERROR");

  public static final ReasonCode RATE_LIMITED = new ReasonCode("RATE_LIMITED");

  public static final ReasonCode RECIPIENT_INVALID_CHANNEL_IDENTITY =
      new ReasonCode("RECIPIENT_INVALID_CHANNEL_IDENTITY");

  public static final ReasonCode RECIPIENT_NOT_REACHABLE =
      new ReasonCode("RECIPIENT_NOT_REACHABLE");

  public static final ReasonCode RECIPIENT_NOT_OPTED_IN = new ReasonCode("RECIPIENT_NOT_OPTED_IN");

  public static final ReasonCode OUTSIDE_ALLOWED_SENDING_WINDOW =
      new ReasonCode("OUTSIDE_ALLOWED_SENDING_WINDOW");

  public static final ReasonCode CHANNEL_FAILURE = new ReasonCode("CHANNEL_FAILURE");

  public static final ReasonCode CHANNEL_BAD_CONFIGURATION =
      new ReasonCode("CHANNEL_BAD_CONFIGURATION");

  public static final ReasonCode CHANNEL_CONFIGURATION_MISSING =
      new ReasonCode("CHANNEL_CONFIGURATION_MISSING");

  public static final ReasonCode MEDIA_TYPE_UNSUPPORTED = new ReasonCode("MEDIA_TYPE_UNSUPPORTED");

  public static final ReasonCode MEDIA_TOO_LARGE = new ReasonCode("MEDIA_TOO_LARGE");

  public static final ReasonCode MEDIA_NOT_REACHABLE = new ReasonCode("MEDIA_NOT_REACHABLE");

  public static final ReasonCode NO_CHANNELS_LEFT = new ReasonCode("NO_CHANNELS_LEFT");

  public static final ReasonCode TEMPLATE_NOT_FOUND = new ReasonCode("TEMPLATE_NOT_FOUND");

  public static final ReasonCode TEMPLATE_INSUFFICIENT_PARAMETERS =
      new ReasonCode("TEMPLATE_INSUFFICIENT_PARAMETERS");

  public static final ReasonCode TEMPLATE_NON_EXISTING_LANGUAGE_OR_VERSION =
      new ReasonCode("TEMPLATE_NON_EXISTING_LANGUAGE_OR_VERSION");

  public static final ReasonCode DELIVERY_TIMED_OUT = new ReasonCode("DELIVERY_TIMED_OUT");

  public static final ReasonCode DELIVERY_REJECTED_DUE_TO_POLICY =
      new ReasonCode("DELIVERY_REJECTED_DUE_TO_POLICY");

  public static final ReasonCode CONTACT_NOT_FOUND = new ReasonCode("CONTACT_NOT_FOUND");

  public static final ReasonCode BAD_REQUEST = new ReasonCode("BAD_REQUEST");

  public static final ReasonCode UNKNOWN_APP = new ReasonCode("UNKNOWN_APP");

  public static final ReasonCode NO_CHANNEL_IDENTITY_FOR_CONTACT =
      new ReasonCode("NO_CHANNEL_IDENTITY_FOR_CONTACT");

  public static final ReasonCode CHANNEL_REJECT = new ReasonCode("CHANNEL_REJECT");

  public static final ReasonCode NO_PERMISSION = new ReasonCode("NO_PERMISSION");

  public static final ReasonCode NO_PROFILE_AVAILABLE = new ReasonCode("NO_PROFILE_AVAILABLE");

  public static final ReasonCode UNSUPPORTED_OPERATION = new ReasonCode("UNSUPPORTED_OPERATION");

  private static final EnumSupportDynamic<String, ReasonCode> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ReasonCode.class,
          ReasonCode::new,
          Arrays.asList(
              UNKNOWN,
              INTERNAL_ERROR,
              RATE_LIMITED,
              RECIPIENT_INVALID_CHANNEL_IDENTITY,
              RECIPIENT_NOT_REACHABLE,
              RECIPIENT_NOT_OPTED_IN,
              OUTSIDE_ALLOWED_SENDING_WINDOW,
              CHANNEL_FAILURE,
              CHANNEL_BAD_CONFIGURATION,
              CHANNEL_CONFIGURATION_MISSING,
              MEDIA_TYPE_UNSUPPORTED,
              MEDIA_TOO_LARGE,
              MEDIA_NOT_REACHABLE,
              NO_CHANNELS_LEFT,
              TEMPLATE_NOT_FOUND,
              TEMPLATE_INSUFFICIENT_PARAMETERS,
              TEMPLATE_NON_EXISTING_LANGUAGE_OR_VERSION,
              DELIVERY_TIMED_OUT,
              DELIVERY_REJECTED_DUE_TO_POLICY,
              CONTACT_NOT_FOUND,
              BAD_REQUEST,
              UNKNOWN_APP,
              NO_CHANNEL_IDENTITY_FOR_CONTACT,
              CHANNEL_REJECT,
              NO_PERMISSION,
              NO_PROFILE_AVAILABLE,
              UNSUPPORTED_OPERATION));

  private ReasonCode(String value) {
    super(value);
  }

  public static Stream<ReasonCode> values() {
    return ENUM_SUPPORT.values();
  }

  public static ReasonCode from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ReasonCode e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
