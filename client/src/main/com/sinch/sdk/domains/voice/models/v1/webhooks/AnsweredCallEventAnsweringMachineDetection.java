package com.sinch.sdk.domains.voice.models.v1.webhooks;

/**
 * @deprecated
 * @see AnsweringMachineDetection to be used in place of
 */
@Deprecated
public interface AnsweredCallEventAnsweringMachineDetection extends AnsweringMachineDetection {

  /** The determination by the system of who answered the call. */
  public class StatusEnum {
    public static final AnsweringMachineDetection.StatusEnum MACHINE =
        AnsweringMachineDetection.StatusEnum.MACHINE;
    public static final AnsweringMachineDetection.StatusEnum HUMAN =
        AnsweringMachineDetection.StatusEnum.HUMAN;
    public static final AnsweringMachineDetection.StatusEnum NOTSURE =
        AnsweringMachineDetection.StatusEnum.NOTSURE;
    public static final AnsweringMachineDetection.StatusEnum HANGUP =
        AnsweringMachineDetection.StatusEnum.HANGUP;
  }

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AnsweredCallEventAnsweringMachineDetectionImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends AnsweringMachineDetection.Builder {}
}
