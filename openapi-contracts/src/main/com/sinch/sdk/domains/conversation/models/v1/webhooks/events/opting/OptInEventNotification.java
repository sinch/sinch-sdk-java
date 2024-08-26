/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.opting;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import java.util.Arrays;
import java.util.stream.Stream;

/** OptInEventNotification */
@JsonDeserialize(builder = OptInEventNotificationImpl.Builder.class)
public interface OptInEventNotification {

  /**
   * ID generated when making an opt-in registration request. Can be used to detect duplicates.
   *
   * @return requestId
   */
  String getRequestId();

  /**
   * The ID of the contact which is the subject of the opt-in. Will be empty if processing_mode is
   * DISPATCH.
   *
   * @return contactId
   */
  String getContactId();

  /**
   * Get channel
   *
   * @return channel
   */
  ConversationChannel getChannel();

  /**
   * The channel identity. For example, a phone number for SMS, WhatsApp and Viber Business.
   *
   * @return identity
   */
  String getIdentity();

  /** Status of the opt-in registration. */
  public class StatusEnum extends EnumDynamic<String, StatusEnum> {
    public static final StatusEnum SUCCEEDED = new StatusEnum("OPT_IN_SUCCEEDED");
    public static final StatusEnum FAILED = new StatusEnum("OPT_IN_FAILED");
    public static final StatusEnum STATUS_UNSPECIFIED = new StatusEnum("OPT_IN_STATUS_UNSPECIFIED");

    private static final EnumSupportDynamic<String, StatusEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            StatusEnum.class,
            StatusEnum::new,
            Arrays.asList(SUCCEEDED, FAILED, STATUS_UNSPECIFIED));

    private StatusEnum(String value) {
      super(value);
    }

    public static Stream<StatusEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static StatusEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(StatusEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Status of the opt-in registration.
   *
   * @return status
   */
  StatusEnum getStatus();

  /**
   * Get errorDetails
   *
   * @return errorDetails
   */
  OptInEventNotificationErrorDetails getErrorDetails();

  /**
   * Get processingMode
   *
   * @return processingMode
   */
  ProcessingMode getProcessingMode();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new OptInEventNotificationImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param requestId see getter
     * @return Current builder
     * @see #getRequestId
     */
    Builder setRequestId(String requestId);

    /**
     * see getter
     *
     * @param contactId see getter
     * @return Current builder
     * @see #getContactId
     */
    Builder setContactId(String contactId);

    /**
     * see getter
     *
     * @param channel see getter
     * @return Current builder
     * @see #getChannel
     */
    Builder setChannel(ConversationChannel channel);

    /**
     * see getter
     *
     * @param identity see getter
     * @return Current builder
     * @see #getIdentity
     */
    Builder setIdentity(String identity);

    /**
     * see getter
     *
     * @param status see getter
     * @return Current builder
     * @see #getStatus
     */
    Builder setStatus(StatusEnum status);

    /**
     * see getter
     *
     * @param errorDetails see getter
     * @return Current builder
     * @see #getErrorDetails
     */
    Builder setErrorDetails(OptInEventNotificationErrorDetails errorDetails);

    /**
     * see getter
     *
     * @param processingMode see getter
     * @return Current builder
     * @see #getProcessingMode
     */
    Builder setProcessingMode(ProcessingMode processingMode);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    OptInEventNotification build();
  }
}
