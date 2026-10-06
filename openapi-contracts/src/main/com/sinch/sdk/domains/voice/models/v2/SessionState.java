package com.sinch.sdk.domains.voice.models.v2;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The state of the current session. Sessions can either be in a &quot;transitional&quot; or
 * &quot;final&quot; state. Sessions in a transitional state are ongoing. Sessions in a final state
 * will not send any more events.
 */
public class SessionState extends EnumDynamic<String, SessionState> {

  /** The session is queued, no calls have been initiated for this session. Transitional state. */
  public static final SessionState QUEUED = new SessionState("QUEUED");

  /** At least one call has been initiated or received for this session. Transitional state. */
  public static final SessionState IN_PROGRESS = new SessionState("IN_PROGRESS");

  /** The session was completed. Final state. */
  public static final SessionState COMPLETED = new SessionState("COMPLETED");

  /**
   * The call session was not initiated before the batch time-to-live (TTL) elapsed. Final state.
   */
  public static final SessionState EXPIRED = new SessionState("EXPIRED");

  private static final EnumSupportDynamic<String, SessionState> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          SessionState.class,
          SessionState::new,
          Arrays.asList(QUEUED, IN_PROGRESS, COMPLETED, EXPIRED));

  private SessionState(String value) {
    super(value);
  }

  public static Stream<SessionState> values() {
    return ENUM_SUPPORT.values();
  }

  public static SessionState from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(SessionState e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
