package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingDestinationType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Fluent creator of an ordered sequence of SVAML commands, e.g. the <code>commands</code> of a call
 * or of a Sinch Event response
 *
 * <p>Each method adds one command, built as the helper of the same name would. The creators of the
 * commands with events are given to a lambda, so no intermediate <code>build()</code> is needed:
 *
 * <pre>{@code
 * List<SvamlCommand> commands =
 *     CommandsSequenceCreator.create()
 *         .dial("+34600111222", dial -> dial
 *             .from("+34910000000")
 *             .onAnswer(answered -> answered
 *                 .text("Connecting you to support", "Emma")
 *                 .bridgeCall("support-queue")))
 *         .build();
 * }</pre>
 *
 * <p>The event handlers of every creator also accept such a lambda.
 *
 * @since 2.4
 */
public final class CommandsSequenceCreator {

  private final List<SvamlCommand> commands = new ArrayList<>();

  CommandsSequenceCreator() {}

  /**
   * Start a new sequence
   *
   * @return The creator
   * @since 2.4
   */
  public static CommandsSequenceCreator create() {
    return new CommandsSequenceCreator();
  }

  /**
   * Add an <code>answer</code> command
   *
   * @return This creator
   * @see Calls#answer()
   * @since 2.4
   */
  public CommandsSequenceCreator answer() {
    return command(Calls.answer());
  }

  /**
   * Add a <code>bridgeCall</code> command
   *
   * @param name Name of the bridge
   * @return This creator
   * @see Calls#bridgeCall(String)
   * @since 2.4
   */
  public CommandsSequenceCreator bridgeCall(String name) {
    return command(Calls.bridgeCall(name));
  }

  /**
   * Add a <code>dial</code> command with no other field than its destination
   *
   * @param to Call destination
   * @return This creator
   * @see Calls#dial(CallDestination)
   * @since 2.4
   */
  public CommandsSequenceCreator dial(CallDestination to) {
    return command(Calls.dial(to).build());
  }

  /**
   * Add a <code>dial</code> command with no other field than its destination
   *
   * @param to Call destination, parsed with {@link Destination#of(String)}
   * @return This creator
   * @see Calls#dial(String)
   * @since 2.4
   */
  public CommandsSequenceCreator dial(String to) {
    return command(Calls.dial(to).build());
  }

  /**
   * Add a <code>dial</code> command
   *
   * @param to Call destination
   * @param dial Lambda filling the other fields and the events
   * @return This creator
   * @see Calls#dial(CallDestination)
   * @since 2.4
   */
  public CommandsSequenceCreator dial(CallDestination to, Consumer<DialCreator> dial) {
    DialCreator creator = Calls.dial(to);
    Objects.requireNonNull(dial, "dial must not be null").accept(creator);
    return command(creator.build());
  }

  /**
   * Add a <code>dial</code> command
   *
   * @param to Call destination, parsed with {@link Destination#of(String)}
   * @param dial Lambda filling the other fields and the events
   * @return This creator
   * @see Calls#dial(String)
   * @since 2.4
   */
  public CommandsSequenceCreator dial(String to, Consumer<DialCreator> dial) {
    return dial(Destination.of(to), dial);
  }

  /**
   * Add a <code>hangup</code> command ending the current call leg
   *
   * @return This creator
   * @see Calls#hangup()
   * @since 2.4
   */
  public CommandsSequenceCreator hangup() {
    return command(Calls.hangup());
  }

  /**
   * Add a <code>hangup</code> command
   *
   * @param name Name of the call leg to end
   * @return This creator
   * @see Calls#hangup(String)
   * @since 2.4
   */
  public CommandsSequenceCreator hangup(String name) {
    return command(Calls.hangup(name));
  }

  /**
   * Add a <code>pause</code> command
   *
   * @param durationMilliseconds Duration of the pause in milliseconds
   * @return This creator
   * @see Calls#pause(int)
   * @since 2.4
   */
  public CommandsSequenceCreator pause(int durationMilliseconds) {
    return command(Calls.pause(durationMilliseconds));
  }

  /**
   * Add an <code>amd</code> command
   *
   * @param amd Lambda filling the events
   * @return This creator
   * @see Amd#activate()
   * @since 2.4
   */
  public CommandsSequenceCreator amd(Consumer<AmdCreator> amd) {
    AmdCreator creator = Amd.activate();
    Objects.requireNonNull(amd, "amd must not be null").accept(creator);
    return command(creator.build());
  }

  /**
   * Add a <code>messages</code> command playing a text-to-speech message in plain text
   *
   * @param text Text to synthesize
   * @param voiceName Voice used for speech synthesis
   * @return This creator
   * @see Messages#text(String, String)
   * @since 2.4
   */
  public CommandsSequenceCreator text(String text, String voiceName) {
    return command(Messages.text(text, voiceName));
  }

  /**
   * Add a <code>messages</code> command playing a text-to-speech message in SSML
   *
   * @param ssml SSML document to synthesize
   * @param voiceName Voice used for speech synthesis
   * @return This creator
   * @see Messages#ssml(String, String)
   * @since 2.4
   */
  public CommandsSequenceCreator ssml(String ssml, String voiceName) {
    return command(Messages.ssml(ssml, voiceName));
  }

  /**
   * Add a <code>messages</code> command playing an audio file
   *
   * @param url URL of the media to play
   * @return This creator
   * @see Messages#play(String)
   * @since 2.4
   */
  public CommandsSequenceCreator play(String url) {
    return command(Messages.play(url));
  }

  /**
   * Add a <code>messages</code> command
   *
   * @param messages Lambda adding the messages, the name and the events
   * @return This creator
   * @see Messages#start()
   * @since 2.4
   */
  public CommandsSequenceCreator messages(Consumer<MessagesCreator> messages) {
    MessagesCreator creator = Messages.start();
    Objects.requireNonNull(messages, "messages must not be null").accept(creator);
    return command(creator.build());
  }

  /**
   * Add a <code>stopMessages</code> command
   *
   * @param name Name of the message sequence
   * @return This creator
   * @see Messages#stop(String)
   * @since 2.4
   */
  public CommandsSequenceCreator stopMessages(String name) {
    return command(Messages.stop(name));
  }

  /**
   * Add a <code>startRecording</code> command with no other field than its recording options
   *
   * @param destination Third party storage the recording is delivered to
   * @param url Destination URL
   * @param credentials Credentials to the third party storage
   * @return This creator
   * @see Recording#start(RecordingDestinationType, String, String)
   * @since 2.4
   */
  public CommandsSequenceCreator recording(
      RecordingDestinationType destination, String url, String credentials) {
    return command(Recording.start(destination, url, credentials).build());
  }

  /**
   * Add a <code>startRecording</code> command
   *
   * @param destination Third party storage the recording is delivered to
   * @param url Destination URL
   * @param credentials Credentials to the third party storage
   * @param recording Lambda filling the other fields and the events
   * @return This creator
   * @see Recording#start(RecordingDestinationType, String, String)
   * @since 2.4
   */
  public CommandsSequenceCreator recording(
      RecordingDestinationType destination,
      String url,
      String credentials,
      Consumer<RecordingCreator> recording) {
    RecordingCreator creator = Recording.start(destination, url, credentials);
    Objects.requireNonNull(recording, "recording must not be null").accept(creator);
    return command(creator.build());
  }

  /**
   * Add a <code>startRecording</code> command with no other field than its recording options
   *
   * @param options Recording options
   * @return This creator
   * @see Recording#start(RecordingOptions)
   * @since 2.4
   */
  public CommandsSequenceCreator recording(RecordingOptions options) {
    return command(Recording.start(options).build());
  }

  /**
   * Add a <code>startRecording</code> command
   *
   * @param options Recording options
   * @param recording Lambda filling the other fields and the events
   * @return This creator
   * @see Recording#start(RecordingOptions)
   * @since 2.4
   */
  public CommandsSequenceCreator recording(
      RecordingOptions options, Consumer<RecordingCreator> recording) {
    RecordingCreator creator = Recording.start(options);
    Objects.requireNonNull(recording, "recording must not be null").accept(creator);
    return command(creator.build());
  }

  /**
   * Add a <code>stopRecording</code> command
   *
   * @param name Name of the recording
   * @return This creator
   * @see Recording#stop(String)
   * @since 2.4
   */
  public CommandsSequenceCreator stopRecording(String name) {
    return command(Recording.stop(name));
  }

  /**
   * Add a <code>customEvent</code> command
   *
   * @param name Name of the custom event
   * @param url URL the event is sent to
   * @return This creator
   * @see CustomEvents#trigger(String, String)
   * @since 2.4
   */
  public CommandsSequenceCreator customEvents(String name, String url) {
    return command(CustomEvents.trigger(name, url));
  }

  /**
   * Add a <code>customEvent</code> command with a fallback URL
   *
   * @param name Name of the custom event
   * @param url URL the event is sent to
   * @param fallbackUrl URL a failed request is sent to
   * @return This creator
   * @see CustomEvents#trigger(String, String, String)
   * @since 2.4
   */
  public CommandsSequenceCreator customEvents(String name, String url, String fallbackUrl) {
    return command(CustomEvents.trigger(name, url, fallbackUrl));
  }

  /**
   * Add a <code>menu</code> command
   *
   * @param startMenu Name of the item played first
   * @param menu Lambda adding the items
   * @return This creator
   * @see Menu#create(String)
   * @since 2.4
   */
  public CommandsSequenceCreator menu(String startMenu, Consumer<MenuCreator> menu) {
    MenuCreator creator = Menu.create(startMenu);
    Objects.requireNonNull(menu, "menu must not be null").accept(creator);
    return command(creator.build());
  }

  /**
   * Add a <code>gotoMenu</code> command. Only valid within a menu
   *
   * @param name Name of the menu item
   * @return This creator
   * @see Menu#gotoMenu(String)
   * @since 2.4
   */
  public CommandsSequenceCreator gotoMenu(String name) {
    return command(Menu.gotoMenu(name));
  }

  /**
   * Add commands built by other means, e.g. with the model builders
   *
   * @param commands Commands to add
   * @return This creator
   * @since 2.4
   */
  public CommandsSequenceCreator command(SvamlCommand... commands) {
    Commands.append(this.commands, commands);
    return this;
  }

  /**
   * Build the sequence
   *
   * @return A new list with the commands, in the order they were added
   * @throws IllegalStateException if a <code>gotoMenu</code> command is outside a menu, or if a
   *     menu of the sequence has a start menu or a <code>gotoMenu</code> target that is not one of
   *     its items
   * @since 2.4
   */
  public List<SvamlCommand> build() {
    MenuCreator.checkGotoTargets(commands, Collections.emptySet());
    return commands();
  }

  /**
   * The commands, not checked: a sequence filled in an event handler lambda may sit within a menu
   * whose items are not known here. The enclosing menu or sequence checks them when built
   */
  List<SvamlCommand> commands() {
    return new ArrayList<>(commands);
  }
}
