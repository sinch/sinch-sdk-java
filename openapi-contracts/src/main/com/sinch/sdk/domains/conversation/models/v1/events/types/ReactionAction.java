package com.sinch.sdk.domains.conversation.models.v1.events.types;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Type of action */
public class ReactionAction extends EnumDynamic<String, ReactionAction> {

  /** Unrecognized type of action */
  public static final ReactionAction UNKNOWN = new ReactionAction("REACTION_ACTION_UNKNOWN");

  /** User placed some emoji reaction */
  public static final ReactionAction REACT = new ReactionAction("REACTION_ACTION_REACT");

  /** User removed previously placed emoji reaction */
  public static final ReactionAction UNREACT = new ReactionAction("REACTION_ACTION_UNREACT");

  private static final EnumSupportDynamic<String, ReactionAction> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ReactionAction.class, ReactionAction::new, Arrays.asList(UNKNOWN, REACT, UNREACT));

  private ReactionAction(String value) {
    super(value);
  }

  public static Stream<ReactionAction> values() {
    return ENUM_SUPPORT.values();
  }

  public static ReactionAction from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ReactionAction e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
