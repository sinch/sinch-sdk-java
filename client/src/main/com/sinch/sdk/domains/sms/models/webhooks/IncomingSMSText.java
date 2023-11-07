package com.sinch.sdk.domains.sms.models.webhooks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * Incoming SMS Text
 *
 * @since 1.0
 */
public class IncomingSMSText extends BaseIncomingSMS<String> {

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
   * @param sendAt When the message left the originating device. Only available if provided by
   *     operator.
   */
  @JsonCreator
  public IncomingSMSText(
      @JsonProperty(JSON_PROPERTY_BODY) String body,
      @JsonProperty(JSON_PROPERTY_FROM) String from,
      @JsonProperty(JSON_PROPERTY_ID) String id,
      @JsonProperty(JSON_PROPERTY_RECEIVED_AT) OffsetDateTime receivedAt,
      @JsonProperty(JSON_PROPERTY_TO) String to,
      @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE) String clientReference,
      @JsonProperty(JSON_PROPERTY_OPERATOR_ID) String operatorId,
      @JsonProperty(JSON_PROPERTY_SENT_AT) OffsetDateTime sendAt) {
    super(body, from, id, receivedAt, to, clientReference, operatorId, sendAt);
  }

  @Override
  public String toString() {
    return "IncomingSMSText{} " + super.toString();
  }
}
