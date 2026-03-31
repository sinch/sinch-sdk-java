package com.mycompany.app.voice;

import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.voice.VoiceService;
import com.sinch.sdk.domains.voice.api.v1.CalloutsService;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestCustom;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.AnsweringMachineDetectionQuery;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectPstn;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLIHelper implements CommandLineRunner {

  @Value("${sinch-number}")
  String sinchNumber;

  private final CalloutsService calloutsService;

  @Autowired
  public CLIHelper(VoiceService voiceService) {
    this.calloutsService = voiceService.v1().callouts();
  }

  @Override
  public void run(String... args) {

    while (true) {
      String phoneNumber = promptPhoneNumber();

      proceedCallout(phoneNumber);
    }
  }

  void proceedCallout(String phoneNumber) {
    var response =
        calloutsService.custom(
            CalloutRequestCustom.builder()
                .setIce(
                    SvamlControl.builder()
                        .setAction(
                            SvamlActionConnectPstn.builder()
                                .setNumber(phoneNumber)
                                .setCli(sinchNumber)
                                .setAmd(
                                    AnsweringMachineDetectionQuery.builder()
                                        .setEnabled(true)
                                        .build())
                                .build())
                        .build())
                .build());

    echo("Callout response: '%s'", response);
  }

  private String promptPhoneNumber() {
    String input;
    boolean valid;
    do {
      input = prompt("\nEnter the phone number you want to call");
      valid = E164PhoneNumber.validate(input);
      if (!valid) {
        echo("Invalid number '%s'", input);
      }
    } while (!valid);

    return input;
  }

  private String prompt(String prompt) {

    String input = null;
    Scanner scanner = new Scanner(System.in);

    while (StringUtil.isEmpty(input)) {
      System.out.println(prompt + " ([Q] to quit): ");
      input = scanner.nextLine();
    }

    if ("Q".equalsIgnoreCase(input)) {
      System.out.println("Quit application");
      System.exit(0);
    }

    return input.replaceAll(" ", "");
  }

  private void echo(String text, Object... args) {
    System.out.println("  " + String.format(text, args));
  }
}
