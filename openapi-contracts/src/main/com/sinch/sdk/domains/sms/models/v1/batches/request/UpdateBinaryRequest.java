/*
 * API Overview | Sinch
 *
 * OpenAPI document version: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.v1.batches.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.sms.models.v1.batches.DeliveryReportType;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/** Update binary message */
@JsonDeserialize(builder = UpdateBinaryRequestImpl.Builder.class)
public interface UpdateBinaryRequest extends UpdateBatchRequest, BatchRequest {

  /**
   * Sender number. Must be valid phone number, short code or alphanumeric.
   *
   * @return from
   */
  String getFrom();

  /** SMS in binary format */
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
   * List of phone numbers and group IDs to add to the batch.
   *
   * @return toAdd
   */
  List<String> getToAdd();

  /**
   * List of phone numbers and group IDs to remove from the batch.
   *
   * @return toRemove
   */
  List<String> getToRemove();

  /**
   * Get deliveryReport
   *
   * @return deliveryReport
   */
  DeliveryReportType getDeliveryReport();

  /**
   * If set, in the future the message will be delayed until <code>send_at</code> occurs. Formatted
   * as <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO-8601</a>: <code>
   * YYYY-MM-DDThh:mm:ss.SSSZ</code>. Constraints: Must be before expire_at. If set in the past,
   * messages will be sent immediately.
   *
   * @return sendAt
   */
  Instant getSendAt();

  /**
   * If set, the system will stop trying to deliver the message at this point. Constraints: Must be
   * after <code>send_at</code> Default: 3 days after <code>send_at</code>
   *
   * @return expireAt
   */
  Instant getExpireAt();

  /**
   * Override the default callback URL for this batch. Constraints: Must be valid URL.
   *
   * @return callbackUrl
   */
  String getCallbackUrl();

  /**
   * The client identifier of a batch message. If set, the identifier will be added in the delivery
   * report/callback of this batch
   *
   * @return clientReference
   */
  String getClientReference();

  /**
   * If set to <code>true</code>, then <a
   * href="/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/deliveryFeedback">feedback</a>
   * is expected after successful delivery.
   *
   * @return feedbackEnabled
   */
  Boolean getFeedbackEnabled();

  /**
   * The message content Base64 encoded. Max 140 bytes together with udh.
   *
   * @return body
   */
  String getBody();

  /**
   * The UDH header of a binary message HEX encoded. Max 140 bytes together with body.
   *
   * @return udh
   */
  String getUdh();

  /**
   * The type of number for the sender number. Use to override the automatic detection.
   *
   * <p>minimum: 0 maximum: 6
   *
   * @return fromTon
   */
  Integer getFromTon();

  /**
   * Number Plan Indicator for the sender number. Use to override the automatic detection.
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
    return new UpdateBinaryRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

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
     * @param toAdd see getter
     * @return Current builder
     * @see #getToAdd
     */
    Builder setToAdd(List<String> toAdd);

    /**
     * see getter
     *
     * @param toRemove see getter
     * @return Current builder
     * @see #getToRemove
     */
    Builder setToRemove(List<String> toRemove);

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
    UpdateBinaryRequest build();
  }
}
