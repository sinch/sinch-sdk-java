package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SvamlActionRunMenuTest extends BaseTest {

  public static SvamlActionRunMenu dto =
      SvamlActionRunMenu.builder()
          .setBarge(true)
          .setLocale("fr")
          .setMainMenu(" the main menu")
          .setEnableVoice(false)
          .setMenus(
              Collections.singletonList(
                  Menu.builder()
                      .setId("the id")
                      .setMainPrompt("main prompt")
                      .setRepeatPrompt("repeat prompt")
                      .setRepeats(5)
                      .setMaxDigits(18)
                      .setTimeoutMills(500)
                      .setMaxTimeoutMills(123456)
                      .setOptions(
                          Collections.singletonList(
                              MenuOption.builder().setDtmf("#w").setAction("menu(foo)").build()))
                      .build()))
          .build();

  @GivenTextResource("/domains/voice/v1/svaml/action/SvamlActionRunMenuDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
