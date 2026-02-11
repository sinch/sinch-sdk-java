package com.mycompany.app.voice;

import com.sinch.sdk.domains.voice.models.v1.destination.DestinationSip;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.Menu;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.MenuOption;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.MenuOptionActionFactory;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectSip;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectSip.TransportEnum;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangup;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionRunMenu;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import com.sinch.sdk.domains.voice.models.v1.webhooks.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.AnsweringMachineDetection.StatusEnum;
import com.sinch.sdk.domains.voice.models.v1.webhooks.PromptInputEvent;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("VoiceServerBusinessLogic")
public class ServerBusinessLogic {

  private final String SIP_MENU = "sip";

  private final String NON_SIP_MENU = "non-sip";

  @Value("${sinch-number}")
  String sinchNumber;

  @Value("${sip-address}")
  String sipAddress;

  public SvamlControl answeredCallEvent(AnsweredCallEvent event) {

    var amdResult = event.getAmd();

    if (StatusEnum.MACHINE.equals(amdResult.getStatus())) {
      return machineResponse();
    }
    if (StatusEnum.HUMAN.equals(amdResult.getStatus())) {
      return humanResponse();
    }
    throw new IllegalStateException("Unexpected value: " + event);
  }

  public SvamlControl promptInputEvent(PromptInputEvent event) {
    var menuResult = event.getMenuResult();

    if (SIP_MENU.equals(menuResult.getValue())) {
      return sipResponse();
    }
    if (NON_SIP_MENU.equals(menuResult.getValue())) {
      return nonSipResponse();
    }
    return defaultResponse();
  }

  private SvamlControl sipResponse() {

    String instruction =
        "Thanks for agreeing to speak to one of our sales reps! We'll now connect your call.";

    return SvamlControl.builder()
        .setAction(
            SvamlActionConnectSip.builder()
                .setDestination(DestinationSip.from(sipAddress))
                .setCli(sinchNumber)
                .setTransport(TransportEnum.TLS)
                .build())
        .setInstructions(
            Collections.singletonList(SvamlInstructionSay.builder().setText(instruction).build()))
        .build();
  }

  private SvamlControl nonSipResponse() {

    String instruction =
        "Thank you for choosing to speak to one of our sales reps! If this were in production, at"
            + " this point you would be connected to a sales rep on your sip network. Since you do"
            + " not, you have now completed this tutorial. We hope you had fun and learned"
            + " something new. Be sure to keep visiting https://developers.sinch.com for more great"
            + " tutorials.";

    return SvamlControl.builder()
        .setAction(SvamlActionHangup.builder().build())
        .setInstructions(
            Collections.singletonList(SvamlInstructionSay.builder().setText(instruction).build()))
        .build();
  }

  private SvamlControl defaultResponse() {

    String instruction = "Thank you for trying our tutorial! This call will now end.";

    return SvamlControl.builder()
        .setAction(SvamlActionHangup.builder().build())
        .setInstructions(
            Collections.singletonList(SvamlInstructionSay.builder().setText(instruction).build()))
        .build();
  }

  private SvamlControl humanResponse() {

    String SIP_MENU_OPTION = "1";
    String NON_SIP_MENU_OPTION = "2";

    String mainPrompt =
        String.format(
            "#tts[Hi, you awesome person! Press '%s' if you have performed this tutorial using a"
                + " sip infrastructure. Press '%s' if you have not used a sip infrastructure. Press"
                + " any other digit to end this call.]",
            SIP_MENU_OPTION, NON_SIP_MENU_OPTION);

    String repeatPrompt =
        String.format(
            "#tts[Again, simply press '%s' if you have used sip, press '%s' if you have not, or"
                + " press any other digit to end this call.]",
            SIP_MENU_OPTION, NON_SIP_MENU_OPTION);

    MenuOption option1 =
        MenuOption.builder()
            .setDtmf(DualToneMultiFrequency.valueOf(SIP_MENU_OPTION))
            .setAction(MenuOptionActionFactory.returnAction(SIP_MENU))
            .build();

    MenuOption option2 =
        MenuOption.builder()
            .setDtmf(DualToneMultiFrequency.valueOf(NON_SIP_MENU_OPTION))
            .setAction(MenuOptionActionFactory.returnAction(NON_SIP_MENU))
            .build();

    List<MenuOption> options = Arrays.asList(option1, option2);

    return SvamlControl.builder()
        .setAction(
            SvamlActionRunMenu.builder()
                .setBarge(false)
                .setMenus(
                    Collections.singletonList(
                        Menu.builder()
                            .setId("main")
                            .setMainPrompt(mainPrompt)
                            .setRepeatPrompt(repeatPrompt)
                            .setRepeats(2)
                            .setOptions(options)
                            .build()))
                .build())
        .build();
  }

  private SvamlControl machineResponse() {

    String instruction =
        "Hi there! We tried to reach you to speak with you about our awesome products. We will try"
            + " again later. Bye!";

    return SvamlControl.builder()
        .setAction(SvamlActionHangup.builder().build())
        .setInstructions(
            Collections.singletonList(SvamlInstructionSay.builder().setText(instruction).build()))
        .build();
  }
}
