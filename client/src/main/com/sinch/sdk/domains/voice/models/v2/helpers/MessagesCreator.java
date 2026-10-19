package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.Message;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessageEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Fluent creator of a <code>messages</code> command, returned by {@link Messages#start()}
 *
 * <p>Messages are played in the order they are added, at most 10. Calling {@link #onFinish} more
 * than once appends the commands.
 *
 * @since 2.4
 */
public final class MessagesCreator {

  private final List<Message> messages = new ArrayList<>();
  private String name;
  private List<SvamlCommand> onFinish;

  MessagesCreator() {}

  /**
   * Add a text-to-speech message in plain text
   *
   * @param text Text to synthesize
   * @param voiceName Voice used for speech synthesis
   * @return This creator
   * @since 2.4
   */
  public MessagesCreator text(String text, String voiceName) {
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
  public MessagesCreator ssml(String ssml, String voiceName) {
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
  public MessagesCreator play(String url) {
    messages.add(Messages.playMessage(url));
    return this;
  }

  /**
   * Set the name of the message sequence, sent as <code>messagesName</code>. A named sequence can
   * be stopped with {@link Messages#stop(String)}
   *
   * @param name Name of the message sequence, unique within the session
   * @return This creator
   * @since 2.4
   */
  public MessagesCreator name(String name) {
    this.name = Objects.requireNonNull(name, "name must not be null");
    return this;
  }

  /**
   * Add commands to run when all the messages have been played
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public MessagesCreator onFinish(SvamlCommand... commands) {
    onFinish = Commands.append(onFinish, commands);
    return this;
  }

  /**
   * Add commands to run when all the messages have been played
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public MessagesCreator onFinish(Collection<? extends SvamlCommand> commands) {
    onFinish = Commands.append(onFinish, commands);
    return this;
  }

  /**
   * Build the <code>messages</code> command
   *
   * @return The command
   * @throws IllegalStateException if no message was added
   * @since 2.4
   */
  public MessagesCommand build() {
    if (messages.isEmpty()) {
      throw new IllegalStateException("messages requires at least one text, ssml or play message");
    }
    MessagesCommand.Builder builder =
        MessagesCommand.builder().setMessages(new ArrayList<>(messages));
    if (null != name) {
      builder.setMessagesName(name);
    }
    if (null != onFinish) {
      builder.setEvents(MessageEvents.builder().setOnFinish(Commands.copy(onFinish)).build());
    }
    return builder.build();
  }
}
