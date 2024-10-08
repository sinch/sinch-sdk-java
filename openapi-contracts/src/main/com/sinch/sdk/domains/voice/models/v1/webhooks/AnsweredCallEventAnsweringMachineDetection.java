/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.webhooks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * If <a href="https://developers.sinch.com/docs/voice/api-reference/amd_v2">Answering Machine
 * Detection</a> (AMD) is enabled, this object contains information about whether the call was
 * answered by a machine.
 */
@JsonDeserialize(builder = AnsweredCallEventAnsweringMachineDetectionImpl.Builder.class)
public interface AnsweredCallEventAnsweringMachineDetection {

  /** The determination by the system of who answered the call. */
  public class StatusEnum extends EnumDynamic<String, StatusEnum> {
    public static final StatusEnum MACHINE = new StatusEnum("machine");
    public static final StatusEnum HUMAN = new StatusEnum("human");
    public static final StatusEnum NOTSURE = new StatusEnum("notsure");
    public static final StatusEnum HANGUP = new StatusEnum("hangup");

    private static final EnumSupportDynamic<String, StatusEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            StatusEnum.class, StatusEnum::new, Arrays.asList(MACHINE, HUMAN, NOTSURE, HANGUP));

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
   * The determination by the system of who answered the call.
   *
   * @return status
   */
  StatusEnum getStatus();

  /** The reason that the system used to determine who answered the call. */
  public class ReasonEnum extends EnumDynamic<String, ReasonEnum> {
    public static final ReasonEnum LONGGREETING = new ReasonEnum("longgreeting");
    public static final ReasonEnum INITIALSILENCE = new ReasonEnum("initialsilence");

    private static final EnumSupportDynamic<String, ReasonEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            ReasonEnum.class, ReasonEnum::new, Arrays.asList(LONGGREETING, INITIALSILENCE));

    private ReasonEnum(String value) {
      super(value);
    }

    public static Stream<ReasonEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static ReasonEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(ReasonEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The reason that the system used to determine who answered the call.
   *
   * @return reason
   */
  ReasonEnum getReason();

  /**
   * The length of the call.
   *
   * @return duration
   */
  Integer getDuration();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AnsweredCallEventAnsweringMachineDetectionImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

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
     * @param reason see getter
     * @return Current builder
     * @see #getReason
     */
    Builder setReason(ReasonEnum reason);

    /**
     * see getter
     *
     * @param duration see getter
     * @return Current builder
     * @see #getDuration
     */
    Builder setDuration(Integer duration);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AnsweredCallEventAnsweringMachineDetection build();
  }
}