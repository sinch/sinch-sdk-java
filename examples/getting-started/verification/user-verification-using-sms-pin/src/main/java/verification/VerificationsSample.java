package verification;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.verification.api.v1.*;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSms;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSms;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Scanner;

public class VerificationsSample {

  private final VerificationService verificationService;

  public VerificationsSample(VerificationService verificationService) {
    this.verificationService = verificationService;
  }

  public void start() {

    E164PhoneNumber e164Number = promptPhoneNumber();

    try {
      // Starting verification onto phone number
      String id = startSmsVerification(verificationService.verificationStart(), e164Number);

      // Ask user for received code
      Integer code = promptSmsCode();

      // Submit the verification report
      reportSmsVerification(verificationService.verificationReport(), code, id);
    } catch (ApiException e) {
      echo("Error (%d): %s", e.getCode(), e.getMessage());
    }
  }

  /**
   * Will start an SMS verification onto specified phone number
   *
   * @param service Verification Start service
   * @param phoneNumber Destination phone number
   * @return Verification ID
   */
  private String startSmsVerification(
      VerificationStartService service, E164PhoneNumber phoneNumber) {

    echo("Sending verification request onto '%s'", phoneNumber.stringValue());

    VerificationStartRequestSms parameters =
        VerificationStartRequestSms.builder()
            .setIdentity(NumberIdentity.valueOf(phoneNumber))
            .build();

    VerificationStartResponseSms response = service.startSms(parameters);
    echo("Verification started with ID '%s'", response.getId());
    return response.getId();
  }

  /**
   * Will use Sinch product to retrieve verification report by ID
   *
   * @param service Verification service
   * @param code Code received by SMS
   * @param id Verification ID related to the verification
   */
  private void reportSmsVerification(VerificationReportService service, Integer code, String id) {

    VerificationReportRequestSms parameters =
        VerificationReportRequestSms.builder().setCode(String.valueOf(code)).build();

    echo("Requesting report for '%s'", id);
    VerificationReportResponseSms response = service.reportSmsById(id, parameters);
    echo("Report response: %s", response);
  }

  /**
   * Prompt user for a valid phone number
   *
   * @return Phone number value
   */
  private E164PhoneNumber promptPhoneNumber() {
    String input;
    boolean valid;
    do {
      input = prompt("\nEnter a phone number to start verification");
      valid = E164PhoneNumber.validate(input);
      if (!valid) {
        echo("Invalid number '%s'", input);
      }
    } while (!valid);

    return E164PhoneNumber.valueOf(input);
  }

  /**
   * Prompt user for a SMS code
   *
   * @return Value entered by user
   */
  private Integer promptSmsCode() {
    Integer code = null;
    do {
      String input = prompt("Enter the verification code to report the verification");
      try {
        code = Integer.valueOf(input);
      } catch (NumberFormatException nfe) {
        echo("Invalid value '%s' (code should be numeric)", input);
      }

    } while (null == code);
    return code;
  }

  /**
   * Endless loop for user input until a valid string is entered or 'Q' to quit
   *
   * @param prompt Prompt to be used task user a value
   * @return The entered text from user
   */
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
    return input.trim();
  }

  private void echo(String text, Object... args) {
    System.out.println("  " + String.format(text, args));
  }
}
