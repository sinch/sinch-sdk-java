package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Agent&#39;s classification. It can be UNKNOWN_AGENT_TYPE, HUMAN or BOT. */
public class AgentType extends EnumDynamic<String, AgentType> {

  public static final AgentType UNKNOWN_AGENT_TYPE = new AgentType("UNKNOWN_AGENT_TYPE");

  public static final AgentType HUMAN = new AgentType("HUMAN");

  public static final AgentType BOT = new AgentType("BOT");

  private static final EnumSupportDynamic<String, AgentType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          AgentType.class, AgentType::new, Arrays.asList(UNKNOWN_AGENT_TYPE, HUMAN, BOT));

  private AgentType(String value) {
    super(value);
  }

  public static Stream<AgentType> values() {
    return ENUM_SUPPORT.values();
  }

  public static AgentType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(AgentType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
