package com.sinch.sdk.domains.voice.models.v2.sinchevents;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Identifies the type of call event that triggered this Sinch Event notification.
 *
 * <p>Call-related events always start with <code>call.</code> followed by the type of event that
 * triggered them. Events triggered by the {@link
 * com.sinch.sdk.domains.voice.models.v2.svaml.customevents.CustomEventCommand} are dynamic and
 * follow the pattern <code>call.customEvent.&lt;customEventName&gt;</code>: they are not listed as
 * constants and are returned as a dynamic value. The API sends them as <code>
 * call.webhook.&lt;customEventName&gt;</code>, and <code>parseEvent</code> renames them.
 */
public class SinchEventType extends EnumDynamic<String, SinchEventType> {

  /** Triggered when an inbound call arrives on a service configured with a webhook URL. */
  public static final SinchEventType CALL_INCOMING = new SinchEventType("call.incoming");

  /** Triggered when an outbound call is answered by the recipient. */
  public static final SinchEventType CALL_ANSWERED = new SinchEventType("call.answered");

  /** Triggered when the outbound call recipient is busy. */
  public static final SinchEventType CALL_BUSY = new SinchEventType("call.busy");

  /** Triggered when the outbound call is rejected by the recipient. */
  public static final SinchEventType CALL_REJECTED = new SinchEventType("call.rejected");

  /** Triggered when the outbound call was not answered within the dial timeout. */
  public static final SinchEventType CALL_TIMEOUT = new SinchEventType("call.timeout");

  /** Triggered when the call is disconnected. */
  public static final SinchEventType CALL_HANGUP = new SinchEventType("call.hangup");

  /** Triggered when the call could not be set up. */
  public static final SinchEventType CALL_FAILED = new SinchEventType("call.failed");

  /** Triggered when answering machine detection determines that a human answered the call. */
  public static final SinchEventType CALL_AMD_HUMAN = new SinchEventType("call.amd.human");

  /** Triggered when answering machine detection determines that a machine answered the call. */
  public static final SinchEventType CALL_AMD_MACHINE = new SinchEventType("call.amd.machine");

  /** Triggered when answering machine detection detects a voicemail beep. */
  public static final SinchEventType CALL_AMD_BEEP = new SinchEventType("call.amd.beep");

  /**
   * Triggered when answering machine detection cannot determine whether a human, machine, or beep
   * was detected.
   */
  public static final SinchEventType CALL_AMD_UNKNOWN = new SinchEventType("call.amd.unknown");

  /** Triggered when all messages in a <code>messages</code> sequence have finished playing. */
  public static final SinchEventType CALL_MESSAGE_FINISHED =
      new SinchEventType("call.message.finished");

  /**
   * Triggered when a recording is successfully stopped. This event does not guarantee that the
   * recorded file has been delivered to the configured destination yet.
   */
  public static final SinchEventType CALL_RECORDING_FINISHED =
      new SinchEventType("call.recording.finished");

  /** Triggered when recording could not be started. */
  public static final SinchEventType CALL_RECORDING_FAILED =
      new SinchEventType("call.recording.failed");

  /** Triggered when a menu completes and input is received from the user or the menu fails. */
  public static final SinchEventType CALL_MENU = new SinchEventType("call.menu");

  private static final EnumSupportDynamic<String, SinchEventType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          SinchEventType.class,
          SinchEventType::new,
          Arrays.asList(
              CALL_INCOMING,
              CALL_ANSWERED,
              CALL_BUSY,
              CALL_REJECTED,
              CALL_TIMEOUT,
              CALL_HANGUP,
              CALL_FAILED,
              CALL_AMD_HUMAN,
              CALL_AMD_MACHINE,
              CALL_AMD_BEEP,
              CALL_AMD_UNKNOWN,
              CALL_MESSAGE_FINISHED,
              CALL_RECORDING_FINISHED,
              CALL_RECORDING_FAILED,
              CALL_MENU));

  private SinchEventType(String value) {
    super(value);
  }

  public static Stream<SinchEventType> values() {
    return ENUM_SUPPORT.values();
  }

  public static SinchEventType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(SinchEventType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
