package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.MenuDto;
import com.sinch.sdk.domains.voice.models.dto.v1.OptionDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionRunMenuDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionRunMenuDto.NameEnum;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ActionRunMenuDtoTest extends BaseTest {

  public static SvamlActionRunMenuDto dto =
      new SvamlActionRunMenuDto()
          .name(NameEnum.RUNMENU.getValue())
          .barge(true)
          .locale("fr")
          .mainMenu(" the main menu")
          .enableVoice(false)
          .menus(
              Collections.singletonList(
                  new MenuDto()
                      .id("the id")
                      .mainPrompt("main prompt")
                      .repeatPrompt("repeat prompt")
                      .repeats(5)
                      .maxDigits(18)
                      .timeoutMills(500)
                      .maxTimeoutMills(123456)
                      .options(
                          Collections.singletonList(
                              new OptionDto().dtmf("#w").action("menu(foo)")))));

  @GivenTextResource("/domains/voice/v1/svaml/action/ActionRunMenuDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
