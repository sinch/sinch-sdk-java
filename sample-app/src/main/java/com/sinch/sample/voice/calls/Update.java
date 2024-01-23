package com.sinch.sample.voice.calls;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
import com.sinch.sdk.domains.voice.models.DestinationSip;
import com.sinch.sdk.domains.voice.models.DestinationUser;
import com.sinch.sdk.domains.voice.models.DtfmModeType;
import com.sinch.sdk.domains.voice.models.MohClassType;
import com.sinch.sdk.domains.voice.models.TransportType;
import com.sinch.sdk.domains.voice.models.svaml.Action;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectConference;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectMxp;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectPstn;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectSip;
import com.sinch.sdk.domains.voice.models.svaml.ActionContinue;
import com.sinch.sdk.domains.voice.models.svaml.ActionHangUp;
import com.sinch.sdk.domains.voice.models.svaml.ActionPark;
import com.sinch.sdk.domains.voice.models.svaml.ActionRunMenu;
import com.sinch.sdk.domains.voice.models.svaml.AnsweringMachineDetection;
import com.sinch.sdk.domains.voice.models.svaml.IndicationType;
import com.sinch.sdk.domains.voice.models.svaml.Instruction;
import com.sinch.sdk.domains.voice.models.svaml.InstructionAnswer;
import com.sinch.sdk.domains.voice.models.svaml.InstructionPlayFiles;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSendDtfm;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSetCookie;
import com.sinch.sdk.domains.voice.models.svaml.InstructionStartRecording;
import com.sinch.sdk.domains.voice.models.svaml.InstructionStopRecording;
import com.sinch.sdk.domains.voice.models.svaml.Menu;
import com.sinch.sdk.domains.voice.models.svaml.MenuOption;
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionAction;
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionActionType;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.svaml.StartRecordingOptions;
import com.sinch.sdk.domains.voice.models.svaml.TranscriptionOptions;
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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

    var actionConnectConference =
        ActionConnectConference.builder()
            .setConferenceId(conferenceId)
            .setDtfmOptions(
                ConferenceDtfmOptions.builder()
                    .setMode(DtfmModeType.FORWARD)
                    .setMaxDigits(45)
                    .setTimeoutMills(456)
                    .build())
            .setMoh(MohClassType.MUSIC3)
            .build();

    var actionRunMenu =
        ActionRunMenu.builder()
            .setBarge(true)
            .setEnableVoice(false)
            .setLocale("fr")
            .setMainMenu(" the main menu")
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
                                MenuOption.builder()
                                    .setAction(
                                        MenuOptionAction.from(MenuOptionActionType.MENU, "foo"))
                                    .build()))
                        .build()))
            .build();

    var actionConnectMxp =
        ActionConnectMxp.builder()
            .setDestination(DestinationUser.valueOf("a user string"))
            .setCallheaders(List.of(new Pair<>("left string", "right string")))
            .build();

    var actionConnectPstn =
        ActionConnectPstn.builder()
            .setNumber(E164PhoneNumber.valueOf("+123456789"))
            .setLocale("fr")
            .setMaxDuration(123)
            .setDialTimeout(456)
            .setCli("cli value")
            .setSuppressCallbacks(true)
            .setDtmf(DualToneMultiFrequency.valueOf("#w123"))
            .setIndications(IndicationType.from("unknown value"))
            .setAnsweringMachineDetectionEnabled(
                AnsweringMachineDetection.builder().setEnabled(true).build())
            .build();

    var actionConnectSip =
        ActionConnectSip.builder()
            .setDestination(DestinationSip.valueOf("a sip string"))
            .setMaxDuration(456)
            .setCli("a cli value")
            .setTransport(TransportType.TLS)
            .setSuppressCallbacks(true)
            .setCallheaders(List.of(new Pair<>("left string", "right string")))
            .setMoh(MohClassType.MUSIC2)
            .build();

    var actionContinue = ActionContinue.builder().build();

    var actionHanghup = ActionHangUp.builder().build();

    var actionPark =
        ActionPark.builder()
            .setLocale("en")
            .setIntroPrompt("intro prompt")
            .setHoldPrompt("hold prompt")
            .setMaxDuration(456)
            .build();

    var instructionAnswer = InstructionAnswer.builder().build();

    var instructionPlayFile =
        InstructionPlayFiles.builder().setIds(List.of("[Welcome]")).setLocale("en").build();

    var instructionSay = InstructionSay.builder().setText("[Welcome]").setLocale("en").build();

    var instructionDtfm =
        InstructionSendDtfm.builder().setDtfm(DualToneMultiFrequency.valueOf("ww123#")).build();

    var instructionSetCookie =
        InstructionSetCookie.builder().setKey("a key").setValue("a value").build();

    var instructionStartRecording =
        InstructionStartRecording.builder()
            .setOptions(
                StartRecordingOptions.builder()
                    .setCredentials("foo")
                    .setDestinationUrl("foo")
                    .setFormat("mp3")
                    .setNotificationEvents(true)
                    .setTranscriptionOptions(
                        TranscriptionOptions.builder().setEnabled(true).setLocale("en-US").build())
                    .build())
            .build();

    var instructionStopRecording = InstructionStopRecording.builder().build();

    Action action = actionConnectPstn;
    Instruction instruction = instructionStartRecording;

    Collection<Instruction> instructions = Collections.singletonList(instruction);

    var parameters = SVAMLControl.builder().setInstructions(instructions).setAction(action).build();
    client.voice().calls().update(callId, parameters);
  }
}
