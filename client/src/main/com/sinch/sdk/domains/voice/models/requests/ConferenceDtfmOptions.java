package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference.Builder;
import java.util.Optional;

/**
 * Options to control how DTMF signals are used by the participant in the conference. For
 * information on how to use this feature, read more
 *
 * @see <a href="https://developers.sinch.com/docs/voice/api-reference/conference-dtmf">Using DTMF
 *     in conferences</a>
 */
public class ConferenceDtfmOptions {

  DtfmModeType mode;
  Integer maxDigits;
  Integer timeoutMills;

  public ConferenceDtfmOptions(DtfmModeType mode, Integer maxDigits, Integer timeoutMills) {
    this.mode = mode;
    this.maxDigits = maxDigits;
    this.timeoutMills = timeoutMills;
  }

  /**
   * Determines what DTMF mode the participant will use in the call.
   *
   * @return DTFM mode
   */
  public Optional<DtfmModeType> getMode() {
    return Optional.ofNullable(mode);
  }

  /**
   * The maximum number of accepted digits before sending the collected input via a PIE callback.
   * The default value is 1. If the value is greater than 1, the PIE callback is triggered by one of
   * the three following events:
   *
   * <p>- No additional digit is entered before the timeoutMills timeout period has elapsed. - The #
   * character is entered. - The maximum number of digits has been entered.
   *
   * @return Max digits
   */
  public Optional<Integer> getMaxDigits() {
    return Optional.ofNullable(maxDigits);
  }

  /**
   * The number of milliseconds that the system will wait between entered digits before triggering
   * the PIE callback
   *
   * @return Timeout in milliseconds
   */
  public Optional<Integer> getTimeoutMills() {
    return Optional.ofNullable(timeoutMills);
  }

  @Override
  public String toString() {
    return "ConferenceDtfmOptions{"
        + "mode="
        + mode
        + ", maxDigits="
        + maxDigits
        + ", timeoutMills="
        + timeoutMills
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    DtfmModeType mode;
    Integer maxDigits;
    Integer timeoutMills;

    public Builder() {}

    public Builder setMode(DtfmModeType mode) {
      this.mode = mode;
      return this;
    }

    public Builder setMaxDigits(Integer maxDigits) {
      this.maxDigits = maxDigits;
      return this;
    }

    public Builder setTimeoutMills(Integer timeoutMills) {
      this.timeoutMills = timeoutMills;
      return this;
    }

    public ConferenceDtfmOptions build() {
      return new ConferenceDtfmOptions(mode, maxDigits, timeoutMills);
    }
  }
}
