/*
 * API Overview | Sinch
 *
 * OpenAPI document version: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.v1.batches.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.sms.models.v1.batches.DeliveryReportType;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/** BinaryResponse */
@JsonDeserialize(builder = BinaryResponseImpl.Builder.class)
public interface BinaryResponse extends BatchResponse {

  /**
   * Unique identifier for batch.
   *
   * @return id
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  String getId();

  /**
   * A list of phone numbers and group IDs that have received the batch. <a
   * href="https://community.sinch.com/t5/Glossary/MSISDN/ta-p/7628">More info</a>.
   *
   * @return to
   */
  List<String> getTo();

  /**
   * The sender number provided. Required if the Automatic Default Originator is not configured.
   *
   * @return from
   */
  String getFrom();

  /**
   * Indicates whether or not the batch has been canceled.
   *
   * @return canceled
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  Boolean getCanceled();

  /**
   * The message content provided. Base64 encoded.
   *
   * @return body
   */
  String getBody();

  /**
   * The <a href="https://community.sinch.com/t5/Glossary/UDH-User-Data-Header/ta-p/7776">UDH</a>
   * header of a binary message HEX encoded. Max 140 bytes including the <code>body</code>.
   *
   * @return udh
   */
  String getUdh();

  /**
   * SMS in <a href="https://community.sinch.com/t5/Glossary/Binary-SMS/ta-p/7470">binary</a>
   * format.
   */
  public class TypeEnum extends EnumDynamic<String, TypeEnum> {
    public static final TypeEnum MT_BINARY = new TypeEnum("mt_binary");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(MT_BINARY));

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
   * Timestamp for when batch was created. Formatted as <a
   * href="https://en.wikipedia.org/wiki/ISO_8601">ISO-8601</a>. For example: <code>
   * YYYY-MM-DDThh:mm:ss.SSSZ</code>.
   *
   * @return createdAt
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  Instant getCreatedAt();

  /**
   * Timestamp for when batch was last updated. Formatted as <a
   * href="https://en.wikipedia.org/wiki/ISO_8601">ISO-8601</a>. For example: <code>
   * YYYY-MM-DDThh:mm:ss.SSSZ</code>.
   *
   * @return modifiedAt
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  Instant getModifiedAt();

  /**
   * The delivery report callback option selected. Will be either <code>none</code>, <code>summary
   * </code>, <code>full</code>, <code>per_recipient</code>, or <code>per_recipient_final</code>.
   *
   * @return deliveryReport
   */
  DeliveryReportType getDeliveryReport();

  /**
   * If set, the date and time the message should be delivered. Formatted as <a
   * href="https://en.wikipedia.org/wiki/ISO_8601">ISO-8601</a>. For example: <code>
   * YYYY-MM-DDThh:mm:ss.SSSZ</code>.
   *
   * @return sendAt
   */
  Instant getSendAt();

  /**
   * If set, the date and time the message will expire. Formatted as <a
   * href="https://en.wikipedia.org/wiki/ISO_8601">ISO-8601</a>. For example: <code>
   * YYYY-MM-DDThh:mm:ss.SSSZ</code>.
   *
   * @return expireAt
   */
  Instant getExpireAt();

  /**
   * The callback URL provided in the request.
   *
   * @return callbackUrl
   */
  String getCallbackUrl();

  /**
   * The string input to identify this batch message. If set, the identifier will be added in the
   * delivery report/callback of this batch.
   *
   * @return clientReference
   */
  String getClientReference();

  /**
   * If set to true, then <a
   * href="/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/deliveryFeedback">feedback</a>
   * is expected after successful delivery.
   *
   * @return feedbackEnabled
   */
  Boolean getFeedbackEnabled();

  /**
   * The type of number for the sender number.
   *
   * <p>minimum: 0 maximum: 6
   *
   * @return fromTon
   */
  Integer getFromTon();

  /**
   * Number Plan Indicator for the sender number.
   *
   * <p>minimum: 0 maximum: 18
   *
   * @return fromNpi
   */
  Integer getFromNpi();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new BinaryResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see #getId
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setId(String id);

    /**
     * see getter
     *
     * @param to see getter
     * @return Current builder
     * @see #getTo
     */
    Builder setTo(List<String> to);

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
     * @param canceled see getter
     * @return Current builder
     * @see #getCanceled
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setCanceled(Boolean canceled);

    /**
     * see getter
     *
     * @param body see getter
     * @return Current builder
     * @see #getBody
     */
    Builder setBody(String body);

    /**
     * see getter
     *
     * @param udh see getter
     * @return Current builder
     * @see #getUdh
     */
    Builder setUdh(String udh);

    /**
     * see getter
     *
     * @param createdAt see getter
     * @return Current builder
     * @see #getCreatedAt
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setCreatedAt(Instant createdAt);

    /**
     * see getter
     *
     * @param modifiedAt see getter
     * @return Current builder
     * @see #getModifiedAt
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setModifiedAt(Instant modifiedAt);

    /**
     * see getter
     *
     * @param deliveryReport see getter
     * @return Current builder
     * @see #getDeliveryReport
     */
    Builder setDeliveryReport(DeliveryReportType deliveryReport);

    /**
     * see getter
     *
     * @param sendAt see getter
     * @return Current builder
     * @see #getSendAt
     */
    Builder setSendAt(Instant sendAt);

    /**
     * see getter
     *
     * @param expireAt see getter
     * @return Current builder
     * @see #getExpireAt
     */
    Builder setExpireAt(Instant expireAt);

    /**
     * see getter
     *
     * @param callbackUrl see getter
     * @return Current builder
     * @see #getCallbackUrl
     */
    Builder setCallbackUrl(String callbackUrl);

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
     * @param feedbackEnabled see getter
     * @return Current builder
     * @see #getFeedbackEnabled
     */
    Builder setFeedbackEnabled(Boolean feedbackEnabled);

    /**
     * see getter
     *
     * @param fromTon see getter
     * @return Current builder
     * @see #getFromTon
     */
    Builder setFromTon(Integer fromTon);

    /**
     * see getter
     *
     * @param fromNpi see getter
     * @return Current builder
     * @see #getFromNpi
     */
    Builder setFromNpi(Integer fromNpi);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    BinaryResponse build();
  }
}