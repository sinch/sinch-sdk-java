package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.menu.MenuItem;
import com.sinch.sdk.domains.voice.models.v2.svaml.menu.MenuPrompt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Fluent creator of a menu item, given to the lambdas of {@link MenuCreator#item(String, Consumer)}
 * and {@link Menu#item(Consumer)}
 *
 * <p>Calling {@link #match} more than once for the same input, or {@link #onFailure} more than
 * once, appends the commands.
 *
 * @since 2.4
 */
public final class MenuItemCreator {

  private MenuPrompt prompt;
  private MenuPrompt repeatPrompt;
  private Integer inputTimeoutDurationSeconds;
  private Integer repeatCount;
  private Integer minimumInputLength;
  private Integer maximumInputLength;
  private String terminatingSequence;
  private List<MenuItem.InputMethodsEnum> inputMethods;
  private final Map<String, List<SvamlCommand>> matches = new LinkedHashMap<>();
  private List<SvamlCommand> onFailure;

  MenuItemCreator() {}

  /**
   * Set the prompt played when the menu starts. It is also the repeat prompt when none is set
   *
   * @param prompt Lambda filling the prompt
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator prompt(Consumer<PromptCreator> prompt) {
    return prompt(Menu.prompt(prompt));
  }

  /**
   * Set the prompt played when the menu starts. It is also the repeat prompt when none is set
   *
   * @param prompt Prompt, e.g. built with {@link Menu#prompt(Consumer)} to share it
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator prompt(MenuPrompt prompt) {
    this.prompt = Objects.requireNonNull(prompt, "prompt must not be null");
    return this;
  }

  /**
   * Set the prompt played when the menu is repeated, after a timeout or an input that does not
   * match. The API only accepts it when a prompt is also set
   *
   * @param repeatPrompt Lambda filling the prompt
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator repeatPrompt(Consumer<PromptCreator> repeatPrompt) {
    return repeatPrompt(Menu.prompt(repeatPrompt));
  }

  /**
   * Set the prompt played when the menu is repeated, after a timeout or an input that does not
   * match. The API only accepts it when a prompt is also set
   *
   * @param repeatPrompt Prompt, e.g. built with {@link Menu#prompt(Consumer)} to share it
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator repeatPrompt(MenuPrompt repeatPrompt) {
    this.repeatPrompt = Objects.requireNonNull(repeatPrompt, "repeatPrompt must not be null");
    return this;
  }

  /**
   * Set how long to wait for input before the attempt times out
   *
   * @param seconds Timeout in seconds, from 1 to 60. The API default is 5
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator inputTimeoutDurationSeconds(int seconds) {
    this.inputTimeoutDurationSeconds = seconds;
    return this;
  }

  /**
   * Set how many times the menu is repeated, after a timeout or an input that does not match
   *
   * @param repeatCount Maximum number of repetitions, from 0 to 10. The API default is 2
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator repeatCount(int repeatCount) {
    this.repeatCount = repeatCount;
    return this;
  }

  /**
   * Set the number of input characters required before the input is evaluated
   *
   * @param length Minimum input length, from 1 to 100. The API default is 1
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator minimumInputLength(int length) {
    this.minimumInputLength = length;
    return this;
  }

  /**
   * Set the number of input characters that triggers the evaluation of the input
   *
   * @param length Maximum input length, from 1 to 100. The API default is 1
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator maximumInputLength(int length) {
    this.maximumInputLength = length;
    return this;
  }

  /**
   * Set the characters that end the input and trigger its evaluation, e.g. <code>#</code>. They are
   * included in the evaluated input
   *
   * @param terminatingSequence Terminating sequence: digits, <code>*</code> and <code>#</code>, at
   *     most 10 characters
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator terminatingSequence(String terminatingSequence) {
    this.terminatingSequence =
        Objects.requireNonNull(terminatingSequence, "terminatingSequence must not be null");
    return this;
  }

  /**
   * Set the accepted input methods. The API default is <code>DTMF</code>
   *
   * @param inputMethods Input methods
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator inputMethods(MenuItem.InputMethodsEnum... inputMethods) {
    Objects.requireNonNull(inputMethods, "inputMethods must not be null");
    List<MenuItem.InputMethodsEnum> list = new ArrayList<>();
    for (MenuItem.InputMethodsEnum inputMethod : Arrays.asList(inputMethods)) {
      list.add(Objects.requireNonNull(inputMethod, "inputMethod must not be null"));
    }
    this.inputMethods = list;
    return this;
  }

  /**
   * Add commands to run when the input matches
   *
   * <p>The inputs are evaluated in the order they are first added: the first one that matches runs
   * its commands. At most 50 inputs per item.
   *
   * <p>The input can be a regular expression, e.g. <code>[2-4]</code>, so the star tone must be
   * escaped: write <code>"\\*"</code> to match it.
   *
   * @param input Literal string or regular expression, 1 to 256 characters
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator match(String input, SvamlCommand... commands) {
    Objects.requireNonNull(input, "input must not be null");
    matches.put(input, Commands.append(matches.get(input), commands));
    return this;
  }

  /**
   * Add commands to run when the input matches
   *
   * <p>The inputs are evaluated in the order they are first added: the first one that matches runs
   * its commands. At most 50 inputs per item.
   *
   * <p>The input can be a regular expression, e.g. <code>[2-4]</code>, so the star tone must be
   * escaped: write <code>"\\*"</code> to match it.
   *
   * @param input Literal string or regular expression, 1 to 256 characters
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator match(String input, Collection<? extends SvamlCommand> commands) {
    Objects.requireNonNull(input, "input must not be null");
    matches.put(input, Commands.append(matches.get(input), commands));
    return this;
  }

  /**
   * Add commands to run when no input matches once the repeat limit is reached
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator onFailure(SvamlCommand... commands) {
    onFailure = Commands.append(onFailure, commands);
    return this;
  }

  /**
   * Add commands to run when no input matches once the repeat limit is reached
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public MenuItemCreator onFailure(Collection<? extends SvamlCommand> commands) {
    onFailure = Commands.append(onFailure, commands);
    return this;
  }

  MenuItem build() {
    MenuItem.Builder builder = MenuItem.builder();
    if (null != prompt) {
      builder.setPrompt(prompt);
    }
    if (null != repeatPrompt) {
      builder.setRepeatPrompt(repeatPrompt);
    }
    if (null != inputTimeoutDurationSeconds) {
      builder.setInputTimeoutDurationSeconds(inputTimeoutDurationSeconds);
    }
    if (null != repeatCount) {
      builder.setRepeatCount(repeatCount);
    }
    if (null != minimumInputLength) {
      builder.setMinimumInputLength(minimumInputLength);
    }
    if (null != maximumInputLength) {
      builder.setMaximumInputLength(maximumInputLength);
    }
    if (null != terminatingSequence) {
      builder.setTerminatingSequence(terminatingSequence);
    }
    if (null != inputMethods) {
      builder.setInputMethods(new ArrayList<>(inputMethods));
    }
    if (!matches.isEmpty()) {
      Map<String, List<SvamlCommand>> copy = new LinkedHashMap<>();
      matches.forEach((input, commands) -> copy.put(input, Commands.copy(commands)));
      builder.setMatches(copy);
    }
    if (null != onFailure) {
      builder.setOnFailure(Commands.copy(onFailure));
    }
    return builder.build();
  }
}
