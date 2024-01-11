package com.sinch.sample.voice.calls;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.models.requests.CallUpdateRequestParameters;
import com.sinch.sdk.domains.voice.models.svaml.ActionRunMenu;
import com.sinch.sdk.domains.voice.models.svaml.Instruction;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.Menu;
import com.sinch.sdk.domains.voice.models.svaml.MenuOption;
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionActionType;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

public class Update extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public Update() throws IOException {}

  public static void main(String[] args) {
    try {
      new Update().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info(
        "Updating call information for '%s' (conference '%s')".formatted(callId, conferenceId));

    var action =
        ActionRunMenu.builder()
            .setBarge(true)
            .setEnableVoice(false)
            .setLocale("fr")
            .setMainMenu(" the main menu")
            .setMenus(
                Arrays.asList(
                    Menu.builder()
                        .setId("the id")
                        .setMainPrompt("main prompt")
                        .setRepeatPrompt("repeat prompt")
                        .setRepeats(5)
                        .setMaxDigits(18)
                        .setTimeoutMills(500)
                        .setMaxTimeoutMills(123456)
                        .setOptions(
                            Arrays.asList(
                                MenuOption.builder().setAction(MenuOptionActionType.MENU).build()))
                        .build()))
            .build();

    Collection<Instruction> instructions =
        Arrays.asList(
            InstructionSay.builder().setText("Hello from sample app").setLocale("en").build());

    var parameters =
        CallUpdateRequestParameters.builder()
            .setInstructions(instructions)
            .setAction(action)
            .build();
    client.voice().calls().update(callId, parameters);
  }
}
