package com.sinch.sdk.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Conversation Region
 *
 * <p>Available Conversation Regions. Regions are tied to a specific Conversation API URL
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/#base-url">https://developers.sinch.com/docs/conversation/api-reference/#base-url</a>
 * @since 1.0
 */
public class ConversationRegion extends EnumDynamic<String, ConversationRegion> {

  /** United States */
  public static final ConversationRegion US = new ConversationRegion("us");

  /** European Union */
  public static final ConversationRegion EU = new ConversationRegion("eu");

  /** Brazil */
  public static final ConversationRegion BR = new ConversationRegion("br");

  private static final EnumSupportDynamic<String, ConversationRegion> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ConversationRegion.class, ConversationRegion::new, Arrays.asList(US, EU, BR));

  private ConversationRegion(String value) {
    super(value);
  }

  /**
   * Get list of regions
   *
   * @return List of known region
   */
  public static Stream<ConversationRegion> values() {
    return ENUM_SUPPORT.values();
  }

  /**
   * Get region from a String
   *
   * @param value String region identifier. Create an Region instance if not known at compilation
   * @return ConversationRegion identified by the string
   */
  public static ConversationRegion from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  /**
   * Get region string identifier
   *
   * @param value region identifier
   * @return String value identifier for region
   */
  public static String valueOf(ConversationRegion value) {
    return ENUM_SUPPORT.valueOf(value);
  }
}
