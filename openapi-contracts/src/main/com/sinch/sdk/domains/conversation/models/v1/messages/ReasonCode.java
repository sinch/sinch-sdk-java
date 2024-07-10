package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets ReasonCode */
public class ReasonCode extends EnumDynamic<String, ReasonCode> {

  /** UNKNOWN is used if no other code can be used to describe the encountered error. */
  public static final ReasonCode UNKNOWN = new ReasonCode("UNKNOWN");

  /** An internal error occurred. Please save the entire callback if you want to report an error. */
  public static final ReasonCode INTERNAL_ERROR = new ReasonCode("INTERNAL_ERROR");

  /** The message or event was not sent due to rate limiting. */
  public static final ReasonCode RATE_LIMITED = new ReasonCode("RATE_LIMITED");

  /** The channel recipient identity was malformed. */
  public static final ReasonCode RECIPIENT_INVALID_CHANNEL_IDENTITY =
      new ReasonCode("RECIPIENT_INVALID_CHANNEL_IDENTITY");

  /** It was not possible to reach the contact, or channel recipient identity, on the channel. */
  public static final ReasonCode RECIPIENT_NOT_REACHABLE =
      new ReasonCode("RECIPIENT_NOT_REACHABLE");

  /** The contact, or channel recipient identity, has not opt-ed in on the channel. */
  public static final ReasonCode RECIPIENT_NOT_OPTED_IN = new ReasonCode("RECIPIENT_NOT_OPTED_IN");

  /**
   * The allowed sending window has expired. See the channel documentation for more information
   * about how the sending window works for the different channels.
   */
  public static final ReasonCode OUTSIDE_ALLOWED_SENDING_WINDOW =
      new ReasonCode("OUTSIDE_ALLOWED_SENDING_WINDOW");

  /**
   * The channel failed to accept the message. The Conversation API performs multiple retries in
   * case of transient errors.
   */
  public static final ReasonCode CHANNEL_FAILURE = new ReasonCode("CHANNEL_FAILURE");

  /**
   * The configuration of the channel for the used App is wrong. The bad configuration caused the
   * channel to reject the message. Please see the <a
   * href="/docs/conversation/channel-support/">channel support documentation page</a> for how to
   * set it up correctly.
   */
  public static final ReasonCode CHANNEL_BAD_CONFIGURATION =
      new ReasonCode("CHANNEL_BAD_CONFIGURATION");

  /**
   * The configuration of the channel is missing from the used App. Please see the <a
   * href="/docs/conversation/channel-support/">channel support documentation</a> page for how to
   * set it up correctly.
   */
  public static final ReasonCode CHANNEL_CONFIGURATION_MISSING =
      new ReasonCode("CHANNEL_CONFIGURATION_MISSING");

  /**
   * Some of the referenced media files is of a unsupported media type. Please read the <a
   * href="/docs/conversation/channel-support/">channel support documentation</a> page to find out
   * the limitations on media that the different channels impose.
   */
  public static final ReasonCode MEDIA_TYPE_UNSUPPORTED = new ReasonCode("MEDIA_TYPE_UNSUPPORTED");

  /**
   * Some of the referenced media files are too large. Please read the <a
   * href="/docs/conversation/channel-support/">channel support documentation</a> to find out the
   * limitations on file size that the different channels impose.
   */
  public static final ReasonCode MEDIA_TOO_LARGE = new ReasonCode("MEDIA_TOO_LARGE");

  /**
   * The provided media link was not accessible from the Conversation API or from the underlying
   * channels. Please make sure that the media file is accessible.
   */
  public static final ReasonCode MEDIA_NOT_REACHABLE = new ReasonCode("MEDIA_NOT_REACHABLE");

  /**
   * No channels to try to send the message to. This error will occur if one attempts to send a
   * message to a channel with no channel identities or if all applicable channels have been
   * attempted.
   */
  public static final ReasonCode NO_CHANNELS_LEFT = new ReasonCode("NO_CHANNELS_LEFT");

  /** The referenced template was not found. */
  public static final ReasonCode TEMPLATE_NOT_FOUND = new ReasonCode("TEMPLATE_NOT_FOUND");

  /**
   * Sufficient template parameters was not given. All parameters defined in the template must be
   * provided when sending a template message.
   */
  public static final ReasonCode TEMPLATE_INSUFFICIENT_PARAMETERS =
      new ReasonCode("TEMPLATE_INSUFFICIENT_PARAMETERS");

  /**
   * The selected language, or version, of the referenced template did not exist. Please check the
   * available versions and languages of the template.
   */
  public static final ReasonCode TEMPLATE_NON_EXISTING_LANGUAGE_OR_VERSION =
      new ReasonCode("TEMPLATE_NON_EXISTING_LANGUAGE_OR_VERSION");

  /**
   * The message delivery, or event delivery, failed due to a channel-imposed timeout. See the <a
   * href="/docs/conversation/channel-support/">channel support documentation</a> page for further
   * details about how the different channels behave.
   */
  public static final ReasonCode DELIVERY_TIMED_OUT = new ReasonCode("DELIVERY_TIMED_OUT");

  /**
   * The message or event was rejected by the channel due to a policy. Some channels have specific
   * policies that must be met to send a message. See the <a
   * href="/docs/conversation/channel-support/">channel support documentation</a> page for more
   * information about when this error will be triggered.
   */
  public static final ReasonCode DELIVERY_REJECTED_DUE_TO_POLICY =
      new ReasonCode("DELIVERY_REJECTED_DUE_TO_POLICY");

  /** The provided Contact ID did not exist. */
  public static final ReasonCode CONTACT_NOT_FOUND = new ReasonCode("CONTACT_NOT_FOUND");

  /**
   * Conversation API validates send requests in two different stages. The first stage is right
   * before the message is enqueued. If this first validation fails the API responds with 400 Bad
   * Request and the request is discarded immediately. The second validation kicks in during message
   * processing and it normally contains channel specific validation rules. Failures during second
   * request validation are delivered as callbacks to <code>MESSAGE_DELIVERY (EVENT_DELIVERY)</code>
   * webhooks with ReasonCode <code>BAD_REQUEST</code>.
   */
  public static final ReasonCode BAD_REQUEST = new ReasonCode("BAD_REQUEST");

  /**
   * The used App is missing. This error may occur when the app is removed during message
   * processing.
   */
  public static final ReasonCode UNKNOWN_APP = new ReasonCode("UNKNOWN_APP");

  /**
   * The contact has no channel identities set up, or the contact has no channels set up for the
   * resolved channel priorities.
   */
  public static final ReasonCode NO_CHANNEL_IDENTITY_FOR_CONTACT =
      new ReasonCode("NO_CHANNEL_IDENTITY_FOR_CONTACT");

  /**
   * Generic error for channel permanently rejecting a message. Only used if no other better
   * matching error can be used.
   */
  public static final ReasonCode CHANNEL_REJECT = new ReasonCode("CHANNEL_REJECT");

  /** No permission to perform action. */
  public static final ReasonCode NO_PERMISSION = new ReasonCode("NO_PERMISSION");

  /** No available profile data for user. */
  public static final ReasonCode NO_PROFILE_AVAILABLE = new ReasonCode("NO_PROFILE_AVAILABLE");

  /** Generic error for channel unsupported operations. */
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
