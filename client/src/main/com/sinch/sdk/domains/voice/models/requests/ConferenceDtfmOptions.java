package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference.Builder;

/**
 * Options to control how DTMF signals are used by the participant in the conference. For
 * information on how to use this feature, read more
 *
 * @see <a href="https://developers.sinch.com/docs/voice/api-reference/conference-dtmf">Using DTMF
 *     in conferences</a>
 */
public class ConferenceDtfmOptions {

  OptionalValue<DtfmModeType> mode;
  OptionalValue<Integer> maxDigits;
  OptionalValue<Integer> timeoutMills;

  public ConferenceDtfmOptions(
      OptionalValue<DtfmModeType> mode,
      OptionalValue<Integer> maxDigits,
      OptionalValue<Integer> timeoutMills) {
    this.mode = mode;
    this.maxDigits = maxDigits;
    this.timeoutMills = timeoutMills;
  }

  public OptionalValue<DtfmModeType> getMode() {
    return mode;
  }

  public OptionalValue<Integer> getMaxDigits() {
    return maxDigits;
  }

  public OptionalValue<Integer> getTimeoutMills() {
    return timeoutMills;
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

    OptionalValue<DtfmModeType> mode = OptionalValue.empty();
    OptionalValue<Integer> maxDigits = OptionalValue.empty();
    OptionalValue<Integer> timeoutMills = OptionalValue.empty();

    public Builder() {}

    /**
     * Determines what DTMF mode the participant will use in the call.
     *
     * @param mode DTFM mode
     * @return current builder
     */
    public Builder setMode(DtfmModeType mode) {
      this.mode = OptionalValue.of(mode);
      return this;
    }

    /**
     * The maximum number of accepted digits before sending the collected input via a PIE callback.
     * The default value is 1. If the value is greater than 1, the PIE callback is triggered by one
     * of the three following events:
     *
     * <p>- No additional digit is entered before the timeoutMills timeout period has elapsed. - The
     * # character is entered. - The maximum number of digits has been entered.
     *
     * @param maxDigits Max digits
     * @return current builder
     */
    public Builder setMaxDigits(Integer maxDigits) {
      this.maxDigits = OptionalValue.of(maxDigits);
      return this;
    }

    /**
     * The number of milliseconds that the system will wait between entered digits before triggering
     * the PIE callback
     *
     * @param timeoutMills Timeout in milliseconds
     * @return current builder
     */
    public Builder setTimeoutMills(Integer timeoutMills) {
      this.timeoutMills = OptionalValue.of(timeoutMills);
      return this;
    }

    public ConferenceDtfmOptions build() {
      return new ConferenceDtfmOptions(mode, maxDigits, timeoutMills);
    }
  }
}
