/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** A message type for sending WhatsApp Flows. */
@JsonDeserialize(builder = FlowChannelSpecificMessageImpl.Builder.class)
public interface FlowChannelSpecificMessage
    extends com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific
        .ChannelSpecificMessage {

  /**
   * Get header
   *
   * @return header
   */
  WhatsAppInteractiveHeader getHeader();

  /**
   * Get body
   *
   * @return body
   */
  WhatsAppInteractiveBody getBody();

  /**
   * Get footer
   *
   * @return footer
   */
  WhatsAppInteractiveFooter getFooter();

  /**
   * ID of the Flow.
   *
   * @return flowId
   */
  String getFlowId();

  /**
   * Generated token which is an identifier.
   *
   * @return flowToken
   */
  String getFlowToken();

  /** The mode in which the flow is. */
  public class FlowModeEnum extends EnumDynamic<String, FlowModeEnum> {
    public static final FlowModeEnum DRAFT = new FlowModeEnum("draft");
    public static final FlowModeEnum PUBLISHED = new FlowModeEnum("published");

    private static final EnumSupportDynamic<String, FlowModeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            FlowModeEnum.class, FlowModeEnum::new, Arrays.asList(DRAFT, PUBLISHED));

    private FlowModeEnum(String value) {
      super(value);
    }

    public static Stream<FlowModeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static FlowModeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(FlowModeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The mode in which the flow is.
   *
   * @return flowMode
   */
  FlowModeEnum getFlowMode();

  /**
   * Text which is displayed on the Call To Action button (20 characters maximum, emoji not
   * supported).
   *
   * @return flowCta
   */
  String getFlowCta();

  /** Gets or Sets flowAction */
  public class FlowActionEnum extends EnumDynamic<String, FlowActionEnum> {
    public static final FlowActionEnum NAVIGATE = new FlowActionEnum("navigate");
    public static final FlowActionEnum DATA_EXCHANGE = new FlowActionEnum("data_exchange");

    private static final EnumSupportDynamic<String, FlowActionEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            FlowActionEnum.class, FlowActionEnum::new, Arrays.asList(NAVIGATE, DATA_EXCHANGE));

    private FlowActionEnum(String value) {
      super(value);
    }

    public static Stream<FlowActionEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static FlowActionEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(FlowActionEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Get flowAction
   *
   * @return flowAction
   */
  FlowActionEnum getFlowAction();

  /**
   * Get flowActionPayload
   *
   * @return flowActionPayload
   */
  FlowChannelSpecificMessageFlowActionPayload getFlowActionPayload();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new FlowChannelSpecificMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param header see getter
     * @return Current builder
     * @see #getHeader
     */
    Builder setHeader(WhatsAppInteractiveHeader header);

    /**
     * see getter
     *
     * @param body see getter
     * @return Current builder
     * @see #getBody
     */
    Builder setBody(WhatsAppInteractiveBody body);

    /**
     * see getter
     *
     * @param footer see getter
     * @return Current builder
     * @see #getFooter
     */
    Builder setFooter(WhatsAppInteractiveFooter footer);

    /**
     * see getter
     *
     * @param flowId see getter
     * @return Current builder
     * @see #getFlowId
     */
    Builder setFlowId(String flowId);

    /**
     * see getter
     *
     * @param flowToken see getter
     * @return Current builder
     * @see #getFlowToken
     */
    Builder setFlowToken(String flowToken);

    /**
     * see getter
     *
     * @param flowMode see getter
     * @return Current builder
     * @see #getFlowMode
     */
    Builder setFlowMode(FlowModeEnum flowMode);

    /**
     * see getter
     *
     * @param flowCta see getter
     * @return Current builder
     * @see #getFlowCta
     */
    Builder setFlowCta(String flowCta);

    /**
     * see getter
     *
     * @param flowAction see getter
     * @return Current builder
     * @see #getFlowAction
     */
    Builder setFlowAction(FlowActionEnum flowAction);

    /**
     * see getter
     *
     * @param flowActionPayload see getter
     * @return Current builder
     * @see #getFlowActionPayload
     */
    Builder setFlowActionPayload(FlowChannelSpecificMessageFlowActionPayload flowActionPayload);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    FlowChannelSpecificMessage build();
  }
}
