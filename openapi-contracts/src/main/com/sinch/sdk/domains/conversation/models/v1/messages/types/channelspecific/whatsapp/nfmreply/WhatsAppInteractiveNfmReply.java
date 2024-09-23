/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.nfmreply;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The interactive nfm reply message. */
@JsonDeserialize(builder = WhatsAppInteractiveNfmReplyImpl.Builder.class)
public interface WhatsAppInteractiveNfmReply {

  /** The nfm reply message type. */
  public class NameEnum extends EnumDynamic<String, NameEnum> {
    public static final NameEnum FLOW = new NameEnum("flow");
    public static final NameEnum ADDRESS_MESSAGE = new NameEnum("address_message");

    private static final EnumSupportDynamic<String, NameEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            NameEnum.class, NameEnum::new, Arrays.asList(FLOW, ADDRESS_MESSAGE));

    private NameEnum(String value) {
      super(value);
    }

    public static Stream<NameEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static NameEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(NameEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The nfm reply message type.
   *
   * @return name
   */
  NameEnum getName();

  /**
   * The JSON specific data.
   *
   * @return responseJson
   */
  String getResponseJson();

  /**
   * The message body.
   *
   * @return body
   */
  String getBody();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new WhatsAppInteractiveNfmReplyImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param name see getter
     * @return Current builder
     * @see #getName
     */
    Builder setName(NameEnum name);

    /**
     * see getter
     *
     * @param responseJson see getter
     * @return Current builder
     * @see #getResponseJson
     */
    Builder setResponseJson(String responseJson);

    /**
     * see getter
     *
     * @param body see getter
     * @return Current builder
     * @see #getBody
     */
    Builder setBody(String body);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    WhatsAppInteractiveNfmReply build();
  }
}