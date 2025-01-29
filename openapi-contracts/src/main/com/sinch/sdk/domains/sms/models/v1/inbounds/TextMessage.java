/*
 * API Overview | Sinch
 *
 * OpenAPI document version: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.v1.inbounds;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Stream;

/** Text MO */
@JsonDeserialize(builder = TextMessageImpl.Builder.class)
public interface TextMessage extends InboundMessage {

  /**
   * If this inbound message is in response to a previously sent message that contained a client
   * reference, then this field contains <em>that</em> client reference. Utilizing this feature
   * requires additional setup on your account. Contact your <a
   * href="https://dashboard.sinch.com/settings/account-details">account manager</a> to enable this
   * feature.
   *
   * @return clientReference
   */
  String getClientReference();

  /**
   * The phone number that sent the message. <a
   * href="https://community.sinch.com/t5/Glossary/MSISDN/ta-p/7628">More info</a>
   *
   * @return from
   */
  String getFrom();

  /**
   * The ID of this inbound message.
   *
   * @return id
   */
  String getId();

  /**
   * The MCC/MNC of the sender's operator if known.
   *
   * @return operatorId
   */
  String getOperatorId();

  /**
   * When the system received the message. Formatted as <a
   * href="https://en.wikipedia.org/wiki/ISO_8601">ISO-8601</a>: <code>YYYY-MM-DDThh:mm:ss.SSSZ
   * </code>.
   *
   * @return receivedAt
   */
  Instant getReceivedAt();

  /**
   * When the message left the originating device. Only available if provided by operator. Formatted
   * as <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO-8601</a>: <code>
   * YYYY-MM-DDThh:mm:ss.SSSZ</code>.
   *
   * @return sentAt
   */
  Instant getSentAt();

  /**
   * The Sinch phone number or short code to which the message was sent.
   *
   * @return to
   */
  String getTo();

  /** Regular SMS */
  public class TypeEnum extends EnumDynamic<String, TypeEnum> {
    public static final TypeEnum MO_TEXT = new TypeEnum("mo_text");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(MO_TEXT));

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
   * Get body
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
    return new TextMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param clientReference see getter
     * @return Current builder
     * @see #getClientReference
     */
    Builder setClientReference(String clientReference);

    /**
     * see getter
     *
     * @param from see getter
     * @return Current builder
     * @see #getFrom
     */
    Builder setFrom(String from);

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see #getId
     */
    Builder setId(String id);

    /**
     * see getter
     *
     * @param operatorId see getter
     * @return Current builder
     * @see #getOperatorId
     */
    Builder setOperatorId(String operatorId);

    /**
     * see getter
     *
     * @param receivedAt see getter
     * @return Current builder
     * @see #getReceivedAt
     */
    Builder setReceivedAt(Instant receivedAt);

    /**
     * see getter
     *
     * @param sentAt see getter
     * @return Current builder
     * @see #getSentAt
     */
    Builder setSentAt(Instant sentAt);

    /**
     * see getter
     *
     * @param to see getter
     * @return Current builder
     * @see #getTo
     */
    Builder setTo(String to);

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
    TextMessage build();
  }
}
