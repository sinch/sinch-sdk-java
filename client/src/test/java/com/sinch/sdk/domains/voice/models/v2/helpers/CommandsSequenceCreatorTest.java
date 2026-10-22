package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.voice.models.v2.VoiceName;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.menu.MenuCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingDestinationType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingFormatType;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

class CommandsSequenceCreatorTest extends HelpersBaseTest {

  void assertSameJson(Object actual, Object expected)
      throws JsonProcessingException, JSONException {
    assertJson(actual, objectMapper.writeValueAsString(expected));
  }

  @Test
  void simpleMethodsAddTheHelperCommand() throws JsonProcessingException, JSONException {
    List<SvamlCommand> sequence =
        CommandsSequenceCreator.create()
            .answer()
            .bridgeCall("queue")
            .dial("+15551234567")
            .dial(Destination.phone("+15550000000"))
            .hangup()
            .hangup("leg")
            .pause(100)
            .text("Hello", "Emma")
            .ssml("<speak>Hello</speak>", "Emma")
            .play("https://example.com/a.mp3")
            .stopMessages("greeting")
            .recording(RecordingDestinationType.AWS, "s3://b", "c")
            .recording(Recording.options(RecordingDestinationType.GCP, "gs://b", "c"))
            .stopRecording("rec")
            .customEvents("event", "https://example.com")
            .customEvents("event", "https://example.com", "https://fallback.example.com")
            .command(Calls.pause(200), Calls.answer())
            .build();

    assertSameJson(
        sequence,
        Arrays.asList(
            Calls.answer(),
            Calls.bridgeCall("queue"),
            Calls.dial("+15551234567").build(),
            Calls.dial(Destination.phone("+15550000000")).build(),
            Calls.hangup(),
            Calls.hangup("leg"),
            Calls.pause(100),
            Messages.text("Hello", "Emma"),
            Messages.ssml("<speak>Hello</speak>", "Emma"),
            Messages.play("https://example.com/a.mp3"),
            Messages.stop("greeting"),
            Recording.start(RecordingDestinationType.AWS, "s3://b", "c").build(),
            Recording.start(Recording.options(RecordingDestinationType.GCP, "gs://b", "c")).build(),
            Recording.stop("rec"),
            CustomEvents.trigger("event", "https://example.com"),
            CustomEvents.trigger("event", "https://example.com", "https://fallback.example.com"),
            Calls.pause(200),
            Calls.answer()));
  }

  @Test
  void lambdaMethodsAddTheCreatorCommand() throws JsonProcessingException, JSONException {
    List<SvamlCommand> sequence =
        CommandsSequenceCreator.create()
            .dial("+15551234567", dial -> dial.name("customer").onBusy(Calls.hangup()))
            .amd(amd -> amd.onMachine(Calls.hangup()))
            .messages(messages -> messages.text("Hi", "Emma").name("greeting"))
            .recording(
                RecordingDestinationType.AWS,
                "s3://b",
                "c",
                recording -> recording.format(RecordingFormatType.WAV).name("rec"))
            .recording(
                Recording.options(RecordingDestinationType.GCP, "gs://b", "c"),
                recording -> recording.name("other"))
            .menu("main", menu -> menu.item("main", item -> item.match("1", Calls.hangup())))
            .build();

    assertSameJson(
        sequence,
        Arrays.asList(
            Calls.dial("+15551234567").name("customer").onBusy(Calls.hangup()).build(),
            Amd.activate().onMachine(Calls.hangup()).build(),
            Messages.start().text("Hi", "Emma").name("greeting").build(),
            Recording.start(RecordingDestinationType.AWS, "s3://b", "c")
                .format(RecordingFormatType.WAV)
                .name("rec")
                .build(),
            Recording.start(Recording.options(RecordingDestinationType.GCP, "gs://b", "c"))
                .name("other")
                .build(),
            Menu.create("main").item("main", item -> item.match("1", Calls.hangup())).build()));
  }

  @Test
  void handlersAcceptASequenceLambda() throws JsonProcessingException, JSONException {
    assertSameJson(
        Calls.dial("+15551234567")
            .onAnswer(answered -> answered.answer().text("Hi", "Emma"))
            .onAnswer(more -> more.hangup())
            .build(),
        Calls.dial("+15551234567")
            .onAnswer(Calls.answer(), Messages.text("Hi", "Emma"), Calls.hangup())
            .build());
    assertSameJson(
        Amd.activate().onHuman(human -> human.bridgeCall("queue")).build(),
        Amd.activate().onHuman(Calls.bridgeCall("queue")).build());
    assertSameJson(
        Messages.start().play("https://example.com/a.mp3").onFinish(done -> done.hangup()).build(),
        Messages.start().play("https://example.com/a.mp3").onFinish(Calls.hangup()).build());
    assertSameJson(
        Recording.start(RecordingDestinationType.AWS, "s3://b", "c")
            .onFinish(done -> done.hangup())
            .onFailure(failed -> failed.pause(10))
            .build(),
        Recording.start(RecordingDestinationType.AWS, "s3://b", "c")
            .onFinish(Calls.hangup())
            .onFailure(Calls.pause(10))
            .build());
  }

  @Test
  void menuMatchAndOnFailureAcceptASequenceLambda() throws JsonProcessingException, JSONException {
    assertSameJson(
        Menu.create("main")
            .item(
                "main",
                item ->
                    item.match("1", one -> one.text("Bye", "Emma").hangup())
                        .match("2", two -> two.gotoMenu("support"))
                        .onFailure(failed -> failed.hangup()))
            .item("support", item -> item.onFailure(failed -> failed.gotoMenu("main")))
            .build(),
        Menu.create("main")
            .item(
                "main",
                item ->
                    item.match("1", Messages.text("Bye", "Emma"), Calls.hangup())
                        .match("2", Menu.gotoMenu("support"))
                        .onFailure(Calls.hangup()))
            .item("support", item -> item.onFailure(Menu.gotoMenu("main")))
            .build());
  }

  @Test
  void supportCallFlow() throws JsonProcessingException, JSONException {
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        "+34600111222",
                        dial ->
                            dial.name("customer")
                                .from("+34910000000")
                                .timeoutDurationSeconds(25)
                                .onAnswer(
                                    answered ->
                                        answered.amd(
                                            amd ->
                                                amd.onHuman(
                                                        human ->
                                                            human
                                                                .text(
                                                                    "Connecting you to support,"
                                                                        + " one moment.",
                                                                    "Emma")
                                                                .recording(
                                                                    RecordingDestinationType.AWS,
                                                                    "s3://voice-recordings/support",
                                                                    "key:secret:eu-west-1",
                                                                    recording ->
                                                                        recording.name(
                                                                            "support-call"))
                                                                .bridgeCall("support-queue"))
                                                    .onMachine(
                                                        machine ->
                                                            machine
                                                                .pause(1200)
                                                                .text(
                                                                    "This is a call from support,"
                                                                        + " please call us back.",
                                                                    "Emma")
                                                                .hangup())))
                                .onHangup(hungUp -> hungUp.stopRecording("support-call")))
                    .build())
            .build();

    assertJson(request, ComposedFlowTest.EXPECTED);
  }

  @Test
  void gotoMenuWithinAMenuOfTheSequenceIsValid() {
    Assertions.assertThatCode(
            () ->
                CommandsSequenceCreator.create()
                    .menu(
                        "main",
                        menu ->
                            menu.item(
                                "main",
                                item ->
                                    item.onFailure(
                                        failed ->
                                            failed.dial(
                                                "+15551234567",
                                                dial ->
                                                    dial.onBusy(busy -> busy.gotoMenu("main"))))))
                    .build())
        .doesNotThrowAnyException();
  }

  @Test
  void rejectsGotoMenuOutsideAMenu() {
    Assertions.assertThatThrownBy(() -> CommandsSequenceCreator.create().gotoMenu("main").build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("only valid within a menu");
  }

  @Test
  void rejectsGotoMenuOutsideAMenuInNestedHandler() {
    Assertions.assertThatThrownBy(
            () ->
                CommandsSequenceCreator.create()
                    .dial("+15551234567", dial -> dial.onAnswer(answered -> answered.gotoMenu("x")))
                    .build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("only valid within a menu");
  }

  @Test
  void rejectsInvalidMenuAddedAsCommand() {
    Assertions.assertThatThrownBy(
            () ->
                CommandsSequenceCreator.create()
                    .command(MenuCommand.builder().setStartMenu("missing").build())
                    .build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("\"missing\"");
  }

  @Test
  void buildReturnsANewList() {
    CommandsSequenceCreator creator = CommandsSequenceCreator.create().answer();
    List<SvamlCommand> first = creator.build();

    first.add(Calls.hangup());
    creator.hangup("leg");

    Assertions.assertThat(first).hasSize(2);
    Assertions.assertThat(creator.build()).hasSize(2);
  }

  @Test
  void everyDialHandlerAcceptsASequenceLambda() throws JsonProcessingException, JSONException {
    assertSameJson(
        Calls.dial("+15551234567")
            .onAnswer(s -> s.answer())
            .onBusy(s -> s.pause(1))
            .onReject(s -> s.pause(2))
            .onTimeout(s -> s.pause(3))
            .onHangup(s -> s.pause(4))
            .onFailure(s -> s.hangup())
            .build(),
        Calls.dial("+15551234567")
            .onAnswer(Calls.answer())
            .onBusy(Calls.pause(1))
            .onReject(Calls.pause(2))
            .onTimeout(Calls.pause(3))
            .onHangup(Calls.pause(4))
            .onFailure(Calls.hangup())
            .build());
  }

  @Test
  void everyAmdHandlerAcceptsASequenceLambda() throws JsonProcessingException, JSONException {
    assertSameJson(
        Amd.activate()
            .onHuman(s -> s.answer())
            .onMachine(s -> s.hangup())
            .onBeep(s -> s.pause(1))
            .onUnknown(s -> s.pause(2))
            .build(),
        Amd.activate()
            .onHuman(Calls.answer())
            .onMachine(Calls.hangup())
            .onBeep(Calls.pause(1))
            .onUnknown(Calls.pause(2))
            .build());
  }

  @Test
  void emptySequenceLambdaIsSentAsEmptyList() throws JsonProcessingException, JSONException {
    assertJson(
        Calls.dial("+15551234567").onBusy(s -> {}).build(),
        "{\"command\":\"dial\",\"to\":" + PHONE_JSON + ",\"events\":{\"onBusy\":[]}}");
  }

  @Test
  void rejectsNullSequenceLambda() {
    Assertions.assertThatThrownBy(
            () -> Calls.dial("+15551234567").onAnswer((Consumer<CommandsSequenceCreator>) null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(
            () -> Amd.activate().onHuman((Consumer<CommandsSequenceCreator>) null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(
            () -> Messages.start().onFinish((Consumer<CommandsSequenceCreator>) null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(
            () ->
                Recording.start(RecordingDestinationType.AWS, "s3://b", "c")
                    .onFailure((Consumer<CommandsSequenceCreator>) null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(
            () -> Menu.item(item -> item.match("1", (Consumer<CommandsSequenceCreator>) null)))
        .isInstanceOf(NullPointerException.class);
  }

  @Test
  void messageShortcutsAcceptNameAndOnFinish() throws JsonProcessingException, JSONException {
    assertSameJson(
        CommandsSequenceCreator.create()
            .text("Hello", "Emma", m -> m.name("greeting").onFinish(Calls.hangup()))
            .ssml("<speak>Hi</speak>", "Emma", m -> m.name("ssml"))
            .play("https://example.com/a.mp3", m -> m.onFinish(s -> s.hangup()))
            .build(),
        Arrays.asList(
            Messages.text("Hello", "Emma", m -> m.name("greeting").onFinish(Calls.hangup())),
            Messages.ssml("<speak>Hi</speak>", "Emma", m -> m.name("ssml")),
            Messages.play("https://example.com/a.mp3", m -> m.onFinish(Calls.hangup()))));
  }

  @Test
  void commandAcceptsACollection() throws JsonProcessingException, JSONException {
    assertSameJson(
        CommandsSequenceCreator.create()
            .command(Arrays.asList(Calls.answer(), Calls.hangup()))
            .build(),
        Arrays.asList(Calls.answer(), Calls.hangup()));
  }

  @Test
  void messageShortcutsAcceptAVoiceNameFromTheCatalog()
      throws JsonProcessingException, JSONException {
    assertSameJson(
        CommandsSequenceCreator.create()
            .text("Hello", VoiceName.EMMA)
            .ssml("<speak>Hi</speak>", VoiceName.EMMA)
            .text("Bye", VoiceName.EMMA, m -> m.onFinish(Calls.hangup()))
            .ssml("<speak>Bye</speak>", VoiceName.EMMA, m -> m.name("bye"))
            .build(),
        Arrays.asList(
            Messages.text("Hello", "Emma"),
            Messages.ssml("<speak>Hi</speak>", "Emma"),
            Messages.text("Bye", "Emma", m -> m.onFinish(Calls.hangup())),
            Messages.ssml("<speak>Bye</speak>", "Emma", m -> m.name("bye"))));
  }

  @Test
  void rejectsNullValues() {
    Assertions.assertThatThrownBy(() -> CommandsSequenceCreator.create().amd(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> CommandsSequenceCreator.create().dial("+15551234567", null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(
            () -> CommandsSequenceCreator.create().command((SvamlCommand) null))
        .isInstanceOf(NullPointerException.class);
  }
}
