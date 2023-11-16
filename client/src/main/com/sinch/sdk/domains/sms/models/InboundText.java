package com.sinch.sdk.domains.sms.models;

import java.time.Instant;

/**
 * Incoming SMS Text
 *
 * @since 1.0
 */
public class InboundText extends Inbound<String> {

  /**
   * Text MO class
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
   * @param sentAt When the message left the originating device. Only available if provided by
   *     operator.
   */
  public InboundText(
      String body,
      String from,
      String id,
      Instant receivedAt,
      String to,
      String clientReference,
      String operatorId,
      Instant sentAt) {
    super(body, from, id, receivedAt, to, clientReference, operatorId, sentAt);
  }

  @Override
  public String toString() {
    return "InboundText{} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends Inbound.Builder<String, Builder> {

    protected Builder() {
      super();
    }

    public InboundText build() {
      return new InboundText(body, from, id, receivedAt, to, clientReference, operatorId, sentAt);
    }

    @Override
    protected InboundText.Builder self() {
      return this;
    }
  }
}
