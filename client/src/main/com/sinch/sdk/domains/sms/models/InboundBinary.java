package com.sinch.sdk.domains.sms.models;

import java.time.Instant;

/**
 * Incoming SMS Binary
 *
 * @since 1.0
 */
public class InboundBinary extends Inbound<String> {

  private final String udh;

  /**
   * Binary MO class
   *
   * @param body The message content Base64 encoded. Max 140 bytes together with udh.
   * @param from The phone number that sent the message. @see <a
   *     href="https://community.sinch.com/t5/Glossary/MSISDN/ta-p/7628">https://community.sinch.com/t5/Glossary/MSISDN/ta-p/7628</a>
   * @param id The ID of this inbound message.
   * @param receivedAt When the system received the message.
   * @param to The Sinch phone number or short code to which the message was sent.
   * @param clientReference If this inbound message is in response to a previously sent message that
   *     contained a client reference, then this field contains that client reference. Utilizing
   *     this feature requires additional setup on your account. Contact your account manager to
   *     enable this feature.
   * @param operatorId The MCC/MNC of the sender's operator if known.
   * @param sendAt When the message left the originating device. Only available if provided by
   *     operator.
   * @param udh The UDH header of a binary message HEX encoded. Max 140 bytes together with body.
   */
  public InboundBinary(
      String body,
      String from,
      String id,
      Instant receivedAt,
      String to,
      String clientReference,
      String operatorId,
      Instant sendAt,
      String udh) {
    super(body, from, id, receivedAt, to, clientReference, operatorId, sendAt);
    this.udh = udh;
  }

  public String getUdh() {
    return udh;
  }

  @Override
  public String toString() {
    return "InboundBinary{" + "udh='" + udh + '\'' + "} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends Inbound.Builder<String, Builder> {

    String udh;

    protected Builder() {
      super();
    }

    public Builder setUdh(String udh) {
      this.udh = udh;
      return this;
    }

    public InboundBinary build() {
      return new InboundBinary(
          body, from, id, receivedAt, to, clientReference, operatorId, sentAt, udh);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
