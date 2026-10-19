package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.voice.models.v2.svaml.menu.MenuCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.menu.MenuItem;
import com.sinch.sdk.domains.voice.models.v2.svaml.menu.MenuPrompt;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingDestinationType;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

class MenuTest extends HelpersBaseTest {

  static final String PROMPT_JSON =
      "{\"messages\":[{\"type\":\"SAY\",\"say\":{\"text\":\"Press 1\",\"voiceName\":\"Emma\"}}]}";

  static final Consumer<PromptCreator> PRESS_1 = prompt -> prompt.text("Press 1", "Emma");

  @Test
  void gotoMenu() throws JsonProcessingException, JSONException {
    assertJson(Menu.gotoMenu("billing"), "{\"command\":\"gotoMenu\",\"menuName\":\"billing\"}");
  }

  @Test
  void createWithOneItem() throws JsonProcessingException, JSONException {
    assertJson(
        Menu.create("main").item("main", item -> item.prompt(PRESS_1)).build(),
        "{\"command\":\"menu\",\"startMenu\":\"main\",\"menus\":{\"main\":{\"prompt\":"
            + PROMPT_JSON
            + "}}}");
  }

  @Test
  void itemAllFields() throws JsonProcessingException, JSONException {
    MenuCommand menu =
        Menu.create("main")
            .item(
                "main",
                item ->
                    item.prompt(
                            prompt -> prompt.play("https://example.com/a.mp3").allowBargeIn(false))
                        .repeatPrompt(PRESS_1)
                        .inputTimeoutDurationSeconds(10)
                        .repeatCount(3)
                        .minimumInputLength(1)
                        .maximumInputLength(4)
                        .terminatingSequence("#")
                        .inputMethods(MenuItem.InputMethodsEnum.DTMF)
                        .match("1", Menu.gotoMenu("main"))
                        .onFailure(Calls.hangup("origin")))
            .build();

    assertJson(
        menu,
        "{\"command\":\"menu\",\"startMenu\":\"main\",\"menus\":{\"main\":{"
            + "\"prompt\":{\"allowBargeIn\":false,\"messages\":[{\"type\":\"PLAY\","
            + "\"play\":{\"url\":\"https://example.com/a.mp3\"}}]},"
            + "\"repeatPrompt\":"
            + PROMPT_JSON
            + ",\"inputTimeoutDurationSeconds\":10,\"repeatCount\":3,"
            + "\"minimumInputLength\":1,\"maximumInputLength\":4,\"terminatingSequence\":\"#\","
            + "\"inputMethods\":[\"DTMF\"],"
            + "\"matches\":{\"1\":[{\"command\":\"gotoMenu\",\"menuName\":\"main\"}]},"
            + "\"onFailure\":[{\"command\":\"hangup\",\"callName\":\"origin\"}]}}}");
  }

  @Test
  void matchesAppendPerInput() throws JsonProcessingException, JSONException {
    MenuCommand menu =
        Menu.create("main")
            .item(
                "main",
                item ->
                    item.match("1", Calls.pause(500))
                        .match("1", Arrays.asList(Calls.hangup()))
                        .match("2", Calls.answer()))
            .build();

    assertJson(
        menu,
        "{\"command\":\"menu\",\"startMenu\":\"main\",\"menus\":{\"main\":{\"matches\":{"
            + "\"1\":[{\"command\":\"pause\",\"durationMilliseconds\":500},"
            + HANGUP_JSON
            + "],\"2\":[{\"command\":\"answer\"}]}}}}");
  }

  @Test
  void sharedPromptAndPrebuiltItem() throws JsonProcessingException, JSONException {
    MenuPrompt shared = Menu.prompt(PRESS_1);
    MenuItem support = MenuItem.builder().setPrompt(shared).build();

    assertJson(
        Menu.create("main")
            .item("main", item -> item.prompt(shared).repeatPrompt(shared))
            .item("support", support)
            .build(),
        "{\"command\":\"menu\",\"startMenu\":\"main\",\"menus\":{"
            + "\"main\":{\"prompt\":"
            + PROMPT_JSON
            + ",\"repeatPrompt\":"
            + PROMPT_JSON
            + "},\"support\":{\"prompt\":"
            + PROMPT_JSON
            + "}}}");
  }

  @Test
  void gotoAcrossItemsIsValid() {
    Assertions.assertThatCode(
            () ->
                Menu.create("main")
                    .item("main", item -> item.match("2", Menu.gotoMenu("support")))
                    .item("support", item -> item.onFailure(Menu.gotoMenu("main")))
                    .build())
        .doesNotThrowAnyException();
  }

  @Test
  void promptRequiresAMessage() {
    Assertions.assertThatThrownBy(() -> Menu.prompt(prompt -> prompt.allowBargeIn(true)))
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void rejectsDuplicatedItem() {
    Assertions.assertThatThrownBy(
            () -> Menu.create("main").item("main", item -> {}).item("main", item -> {}))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("\"main\"");
  }

  @Test
  void duplicatedItemLambdaIsNotRun() {
    AtomicBoolean run = new AtomicBoolean();
    MenuCreator menu = Menu.create("main").item("main", item -> {});

    Assertions.assertThatThrownBy(() -> menu.item("main", item -> run.set(true)))
        .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThat(run).isFalse();
  }

  @Test
  void promptWithSsml() throws JsonProcessingException, JSONException {
    assertJson(
        Menu.prompt(prompt -> prompt.ssml("<speak>Press 1</speak>", "Emma")),
        "{\"messages\":[{\"type\":\"SAY\",\"say\":{\"text\":\"<speak>Press 1</speak>\","
            + "\"voiceName\":\"Emma\",\"format\":\"SSML\"}}]}");
  }

  @Test
  void reusableItem() throws JsonProcessingException, JSONException {
    MenuItem shared = Menu.item(item -> item.prompt(PRESS_1).onFailure(Calls.hangup()));

    assertJson(
        Menu.create("main").item("main", shared).build(),
        "{\"command\":\"menu\",\"startMenu\":\"main\",\"menus\":{\"main\":{\"prompt\":"
            + PROMPT_JSON
            + ",\"onFailure\":["
            + HANGUP_JSON
            + "]}}}");
  }

  @Test
  void rejectsUndefinedGotoTargetInPrebuiltItem() {
    MenuItem item =
        MenuItem.builder()
            .setMatches(
                Collections.singletonMap("1", Collections.singletonList(Menu.gotoMenu("missing"))))
            .build();

    Assertions.assertThatThrownBy(() -> Menu.create("main").item("main", item).build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("\"missing\"");
  }

  @Test
  void rejectsUndefinedGotoTargetInMessagesOnFinish() {
    Assertions.assertThatThrownBy(
            () ->
                Menu.create("main")
                    .item(
                        "main",
                        item ->
                            item.match(
                                "1",
                                Messages.start()
                                    .text("Bye", "Emma")
                                    .onFinish(Menu.gotoMenu("missing"))
                                    .build()))
                    .build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("\"missing\"");
  }

  @Test
  void rejectsUndefinedGotoTargetInRecordingHandlers() {
    Assertions.assertThatThrownBy(
            () ->
                Menu.create("main")
                    .item(
                        "main",
                        item ->
                            item.onFailure(
                                Recording.start(RecordingDestinationType.AWS, "s3://b", "c")
                                    .onFailure(Menu.gotoMenu("missing"))
                                    .build()))
                    .build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("\"missing\"");
    Assertions.assertThatThrownBy(
            () ->
                Menu.create("main")
                    .item(
                        "main",
                        item ->
                            item.onFailure(
                                Recording.start(RecordingDestinationType.AWS, "s3://b", "c")
                                    .onFinish(Menu.gotoMenu("missing"))
                                    .build()))
                    .build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("\"missing\"");
  }

  @Test
  void rejectsHandBuiltNestedMenuWithUndefinedStartMenu() {
    MenuCommand nested =
        MenuCommand.builder()
            .setStartMenu("other")
            .setMenus(Collections.singletonMap("inner", MenuItem.builder().build()))
            .build();

    Assertions.assertThatThrownBy(
            () -> Menu.create("main").item("main", item -> item.match("9", nested)).build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("\"other\"");
  }

  @Test
  void rejectsHandBuiltNestedMenuWithUndefinedGotoTarget() {
    MenuItem inner =
        MenuItem.builder().setOnFailure(Collections.singletonList(Menu.gotoMenu("main"))).build();
    MenuCommand nested =
        MenuCommand.builder()
            .setStartMenu("inner")
            .setMenus(Collections.singletonMap("inner", inner))
            .build();

    // "main" is an item of the outer menu, not of the nested one
    Assertions.assertThatThrownBy(
            () -> Menu.create("main").item("main", item -> item.match("9", nested)).build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("\"main\"");
  }

  @Test
  void rejectsUndefinedStartMenu() {
    Assertions.assertThatThrownBy(() -> Menu.create("other").item("main", item -> {}).build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("\"other\"");
  }

  @Test
  void rejectsUndefinedGotoTarget() {
    Assertions.assertThatThrownBy(
            () ->
                Menu.create("main")
                    .item("main", item -> item.match("1", Menu.gotoMenu("missing")))
                    .build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("\"missing\"");
  }

  @Test
  void rejectsUndefinedGotoTargetInNestedHandler() {
    Assertions.assertThatThrownBy(
            () ->
                Menu.create("main")
                    .item(
                        "main",
                        item ->
                            item.onFailure(
                                Calls.dial("+15551234567")
                                    .onBusy(
                                        Amd.activate().onMachine(Menu.gotoMenu("missing")).build())
                                    .build()))
                    .build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("\"missing\"");
  }

  @Test
  void nestedMenuKeepsItsOwnItems() {
    MenuCommand nested =
        Menu.create("inner").item("inner", item -> item.match("1", Menu.gotoMenu("inner"))).build();

    Assertions.assertThatCode(
            () -> Menu.create("main").item("main", item -> item.match("9", nested)).build())
        .doesNotThrowAnyException();
  }

  @Test
  void rejectsNullValues() {
    Assertions.assertThatThrownBy(() -> Menu.create(null)).isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Menu.gotoMenu(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Menu.prompt(null)).isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Menu.create("main").item(null, item -> {}))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(
            () -> Menu.create("main").item("main", item -> item.match(null, Calls.hangup())))
        .isInstanceOf(NullPointerException.class);
  }
}
