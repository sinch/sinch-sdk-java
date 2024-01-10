package com.sinch.sample.voice.calls;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.requests.CallUpdateRequestParameters;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.svaml.ActionRunMenu;
import com.sinch.sdk.domains.voice.models.svaml.Instruction;
import com.sinch.sdk.domains.voice.models.svaml.Menu;
import com.sinch.sdk.domains.voice.models.svaml.MenuOption;
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionActionType;
import com.sinch.sdk.models.E164PhoneNumber;
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

    callId =
        client
            .voice()
            .callouts()
            .call(
                CalloutRequestParametersConference.builder()
                    .setConferenceId(conferenceId)
                    .setDestination(DestinationNumber.valueOf(phoneNumber))
                    .setCli(E164PhoneNumber.valueOf("+123456789"))
                    .setCustom("my custom value")
                    .build());
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
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
                        .setRepeatPrompt("repeat tprompt")
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
            // InstructionAnswer.builder().build()
            // InstructionPlayFile.builder().setIds(Arrays.asList("[Welcome]")).setLocale("en").build(),
            //    InstructionSay.builder().setText("Hello from sample app").setLocale("en").build()
            //
            // InstructionSendDtfm.builder().setDtfm(DualToneMultiFrequency.valueOf("ww123#")).build()
            //  InstructionSetCookie.builder().setKey("a key").setValue("a value").build()
            // InstructionStartRecording.builder().setOptions(StartRecordingOptions.builder().setCredentials("foo").setDestinationUrl("foo").setFormat("mp3").setNotificationEvents(true).build()).build()
            //  InstructionStopRecording.builder().build()
            );
    var parameters =
        CallUpdateRequestParameters.builder()
            .setInstructions(instructions)
            .setAction(action)
            .build();
    client.voice().calls().update(callId, parameters);
  }
}
