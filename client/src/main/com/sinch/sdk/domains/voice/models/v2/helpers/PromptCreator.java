package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.svaml.menu.MenuPrompt;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.Message;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * Fluent creator of a menu prompt, given to the lambdas of {@link MenuItemCreator#prompt} and
 * {@link Menu#prompt}
 *
 * <p>Messages are played in the order they are added, at most 10.
 *
 * @since 2.4
 */
public final class PromptCreator {

  private final List<Message> messages = new ArrayList<>();
  private Boolean allowBargeIn;

  PromptCreator() {}

  /**
   * Add a text-to-speech message in plain text
   *
   * @param text Text to synthesize
   * @param voiceName Voice used for speech synthesis
   * @return This creator
   * @since 2.4
   */
  public PromptCreator text(String text, String voiceName) {
    messages.add(Messages.sayMessage(text, voiceName, null));
    return this;
  }

  /**
   * Add a text-to-speech message in SSML
   *
   * @param ssml SSML document (<code>&lt;speak&gt;...&lt;/speak&gt;</code>) to synthesize
   * @param voiceName Voice used for speech synthesis
   * @return This creator
   * @since 2.4
   */
  public PromptCreator ssml(String ssml, String voiceName) {
    messages.add(Messages.sayMessage(ssml, voiceName, SayMessage.FormatEnum.SSML));
    return this;
  }

  /**
   * Add an audio file to play
   *
   * @param url URL of the media to play
   * @return This creator
   * @since 2.4
   */
  public PromptCreator play(String url) {
    messages.add(Messages.playMessage(url));
    return this;
  }

  /**
   * Set whether user input interrupts the prompt. The API default is <code>true</code>
   *
   * @param allowBargeIn <code>false</code> to play the whole prompt before evaluating the input,
   *     which is still collected during playback
   * @return This creator
   * @since 2.4
   */
  public PromptCreator allowBargeIn(boolean allowBargeIn) {
    this.allowBargeIn = allowBargeIn;
    return this;
  }

  MenuPrompt build() {
    if (messages.isEmpty()) {
      throw new IllegalStateException("prompt requires at least one text, ssml or play message");
    }
    MenuPrompt.Builder builder = MenuPrompt.builder().setMessages(new ArrayList<>(messages));
    if (null != allowBargeIn) {
      builder.setAllowBargeIn(allowBargeIn);
    }
    return builder.build();
  }
}
