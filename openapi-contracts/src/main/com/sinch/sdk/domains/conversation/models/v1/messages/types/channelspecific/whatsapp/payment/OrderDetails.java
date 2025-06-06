/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveBody;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveFooter;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeader;

/** OrderDetails */
@JsonDeserialize(builder = OrderDetailsImpl.Builder.class)
public interface OrderDetails
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
   * Get payment
   *
   * @return payment
   */
  OrderDetailsPayment getPayment();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new OrderDetailsImpl.Builder();
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
     * @param payment see getter
     * @return Current builder
     * @see #getPayment
     */
    Builder setPayment(OrderDetailsPayment payment);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    OrderDetails build();
  }
}
