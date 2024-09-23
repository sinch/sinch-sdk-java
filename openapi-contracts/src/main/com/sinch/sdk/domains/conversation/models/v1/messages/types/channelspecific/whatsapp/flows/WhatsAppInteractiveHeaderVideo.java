/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Header of the interactive message with video. */
@JsonDeserialize(builder = WhatsAppInteractiveHeaderVideoImpl.Builder.class)
public interface WhatsAppInteractiveHeaderVideo
    extends com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp
        .flows.WhatsAppInteractiveHeader {

  /** Gets or Sets type */
  public class TypeEnum extends EnumDynamic<String, TypeEnum> {
    public static final TypeEnum VIDEO = new TypeEnum("video");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(VIDEO));

    private TypeEnum(String value) {
      super(value);
    }

    public static Stream<TypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Get video
   *
   * @return video
   */
  WhatsAppInteractiveHeaderMedia getVideo();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new WhatsAppInteractiveHeaderVideoImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param video see getter
     * @return Current builder
     * @see #getVideo
     */
    Builder setVideo(WhatsAppInteractiveHeaderMedia video);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    WhatsAppInteractiveHeaderVideo build();
  }
}