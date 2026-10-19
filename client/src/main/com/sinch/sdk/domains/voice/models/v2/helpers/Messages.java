package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.PlayMessage;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.StopMessagesCommand;
import java.util.Objects;

/**
 * Helpers to build the message playback SVAML commands
 *
 * <p>{@link #text}, {@link #ssml} and {@link #play} are shortcuts for a <code>messages</code>
 * command with a single message. Use {@link #start()} to play several messages, or to set a name or
 * the commands to run once they have been played.
 *
 * @since 2.4
 */
public final class Messages {

  private Messages() {}

  /**
   * Play a text-to-speech message in plain text
   *
   * @param text Text to synthesize
   * @param voiceName Voice used for speech synthesis
   * @return The <code>messages</code> command, with this single message
   * @since 2.4
   */
  public static MessagesCommand text(String text, String voiceName) {
    return start().text(text, voiceName).build();
  }

  /**
   * Play a text-to-speech message in SSML
   *
   * @param ssml SSML document (<code>&lt;speak&gt;...&lt;/speak&gt;</code>) to synthesize
   * @param voiceName Voice used for speech synthesis
   * @return The <code>messages</code> command, with this single message
   * @since 2.4
   */
  public static MessagesCommand ssml(String ssml, String voiceName) {
    return start().ssml(ssml, voiceName).build();
  }

  /**
   * Play an audio file
   *
   * @param url URL of the media to play
   * @return The <code>messages</code> command, with this single message
   * @since 2.4
   */
  public static MessagesCommand play(String url) {
    return start().play(url).build();
  }

  /**
   * Play one or more messages, in the order they are added
   *
   * @return The creator of the <code>messages</code> command
   * @since 2.4
   */
  public static MessagesCreator start() {
    return new MessagesCreator();
  }

  /**
   * Stop a named message sequence
   *
   * @param name Name of the message sequence, sent as <code>messagesName</code>
   * @return The <code>stopMessages</code> command
   * @since 2.4
   */
  public static StopMessagesCommand stop(String name) {
    Objects.requireNonNull(name, "name must not be null");
    return StopMessagesCommand.builder().setMessagesName(name).build();
  }

  /** <code>format</code> is only set for SSML: plain text is the API default */
  static SayMessage sayMessage(String text, String voiceName, SayMessage.FormatEnum format) {
    Objects.requireNonNull(text, "text must not be null");
    Objects.requireNonNull(voiceName, "voiceName must not be null");
    SayMessage.Builder builder = SayMessage.builder().setText(text).setVoiceName(voiceName);
    if (null != format) {
      builder.setFormat(format);
    }
    return builder.build();
  }

  static PlayMessage playMessage(String url) {
    Objects.requireNonNull(url, "url must not be null");
    return PlayMessage.builder().setUrl(url).build();
  }
}
