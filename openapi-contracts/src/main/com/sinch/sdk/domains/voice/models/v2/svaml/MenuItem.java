package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Defines a single menu step, including prompts, input handling rules, input-to-command matches,
 * and failure handling.
 *
 * <p>Each collected input is matched against the values in the <code>matches</code> property. If no
 * match succeeds, the <code>onFail</code> commands are executed.
 *
 * <p>If neither <code>matches</code> nor <code>onFail</code> is defined and the service call
 * behavior is set to <code>WEBHOOK</code>, a webhook request is sent including the collected input.
 */
@JsonDeserialize(builder = MenuItemImpl.Builder.class)
public interface MenuItem {

  /** Gets or Sets inputMethods */
  public class InputMethodsEnum extends EnumDynamic<String, InputMethodsEnum> {
    public static final InputMethodsEnum DTMF = new InputMethodsEnum("DTMF");

    private static final EnumSupportDynamic<String, InputMethodsEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            InputMethodsEnum.class, InputMethodsEnum::new, Arrays.asList(DTMF));

    private InputMethodsEnum(String value) {
      super(value);
    }

    public static Stream<InputMethodsEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static InputMethodsEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(InputMethodsEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Prompt played when this menu starts.
   *
   * <p>This prompt is also used as the repeat prompt when repeatPrompt is not defined for the menu.
   *
   * @return prompt
   */
  MenuPrompt getPrompt();

  /**
   * Prompt played when the menu is repeated.
   *
   * <p>Repeats occur when input times out or when the provided input does not match any menu match
   * item.
   *
   * @return repeatPrompt
   */
  MenuPrompt getRepeatPrompt();

  /**
   * Maximum number of seconds to wait for user input before the input attempt times out.
   *
   * @return inputTimeoutDurationSeconds
   */
  Integer getInputTimeoutDurationSeconds();

  /**
   * Maximum number of times the menu is repeated.
   *
   * <p>A repeat occurs when input times out or when the provided input does not match any menu
   * match item.
   *
   * @return repeatCount
   */
  Integer getRepeatCount();

  /**
   * Minimum number of input characters required before the menu evaluates the collected input.
   *
   * @return minimumInputLength
   */
  Integer getMinimumInputLength();

  /**
   * Maximum number of input characters that triggers the menu to evaluate the collected input.
   *
   * @return maximumInputLength
   */
  Integer getMaximumInputLength();

  /**
   * Character sequence that signals the end of input and triggers immediate evaluation.
   *
   * <p>Useful when variable-length input is allowed and shorter valid options should be submitted
   * without waiting for timeout or maximum length.
   *
   * <p>The terminating sequence value is included in the evaluated input.
   *
   * @return terminatingSequence
   */
  String getTerminatingSequence();

  /**
   * Input methods accepted for this menu when collecting user input.
   *
   * @return inputMethods
   */
  List<InputMethodsEnum> getInputMethods();

  /**
   * Items matched against the collected input. Maximum number of allowed match expressions is 50.
   *
   * <p>Defined as a dictionary where each property name is a literal or a regular expression
   * string.
   *
   * <p>Values are evaluated in the order they are defined.
   *
   * @return matches
   */
  Map<String, List<SvamlCommand>> getMatches();

  /**
   * SVAML commands executed when the menu fails to collect a matching input.
   *
   * <p>This handler runs after the repeat limit is reached without any input matching a menu match
   * item.
   *
   * @return onFail
   */
  List<SvamlCommand> getOnFail();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MenuItemImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param prompt see getter
     * @return Current builder
     * @see #getPrompt
     */
    Builder setPrompt(MenuPrompt prompt);

    /**
     * see getter
     *
     * @param repeatPrompt see getter
     * @return Current builder
     * @see #getRepeatPrompt
     */
    Builder setRepeatPrompt(MenuPrompt repeatPrompt);

    /**
     * see getter
     *
     * @param inputTimeoutDurationSeconds see getter
     * @return Current builder
     * @see #getInputTimeoutDurationSeconds
     */
    Builder setInputTimeoutDurationSeconds(Integer inputTimeoutDurationSeconds);

    /**
     * see getter
     *
     * @param repeatCount see getter
     * @return Current builder
     * @see #getRepeatCount
     */
    Builder setRepeatCount(Integer repeatCount);

    /**
     * see getter
     *
     * @param minimumInputLength see getter
     * @return Current builder
     * @see #getMinimumInputLength
     */
    Builder setMinimumInputLength(Integer minimumInputLength);

    /**
     * see getter
     *
     * @param maximumInputLength see getter
     * @return Current builder
     * @see #getMaximumInputLength
     */
    Builder setMaximumInputLength(Integer maximumInputLength);

    /**
     * see getter
     *
     * @param terminatingSequence see getter
     * @return Current builder
     * @see #getTerminatingSequence
     */
    Builder setTerminatingSequence(String terminatingSequence);

    /**
     * see getter
     *
     * @param inputMethods see getter
     * @return Current builder
     * @see #getInputMethods
     */
    Builder setInputMethods(List<InputMethodsEnum> inputMethods);

    /**
     * see getter
     *
     * @param matches see getter
     * @return Current builder
     * @see #getMatches
     */
    Builder setMatches(Map<String, List<SvamlCommand>> matches);

    /**
     * see getter
     *
     * @param onFail see getter
     * @return Current builder
     * @see #getOnFail
     */
    Builder setOnFail(List<SvamlCommand> onFail);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MenuItem build();
  }
}
