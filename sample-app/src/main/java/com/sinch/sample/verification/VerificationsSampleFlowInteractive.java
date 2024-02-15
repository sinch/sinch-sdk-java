package com.sinch.sample.verification;

import static com.sinch.sample.BaseApplication.PHONE_NUMBER_KEY;
import static com.sinch.sample.Utils.echo;

import com.sinch.sample.Utils;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.verification.VerificationsService;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Scanner;
import java.util.logging.Logger;

public class VerificationsSampleFlowInteractive {

  private static final Logger LOGGER =
      Utils.initializeLogger(VerificationsSampleFlowInteractive.class.getName());

  public static void main(String[] args) {

    try {
      var properties = Utils.loadProperties(LOGGER);
      var configuration = Utils.loadConfiguration(LOGGER);
      var phoneNumber =
          null != System.getenv(PHONE_NUMBER_KEY)
              ? System.getenv(PHONE_NUMBER_KEY)
              : properties.getProperty(PHONE_NUMBER_KEY);
      new VerificationsSampleFlowInteractive().run(configuration, phoneNumber);
    } catch (ApiException apiException) {
      LOGGER.severe(apiException.toString());
      System.exit(-1);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void run(Configuration configuration, String phoneNumber) throws InterruptedException {

    VerificationsService service = new SinchClient(configuration).verification().verifications();

    //noinspection InfiniteLoopStatement
    do {

      E164PhoneNumber e164Number;

      // Console input for phone number if not set by default
      if (StringUtil.isEmpty(phoneNumber)) {
        e164Number = queryPhoneNumber();
      } else {
        e164Number = E164PhoneNumber.valueOf(phoneNumber);
      }

      try {
        // Starting verification onto phone number
        VerificationId id = startSmsVerification(service, e164Number);

        // Ask user for received code
        String code = queryCode();

        // Query report
        reportSmsVerification(service, code, id);
        phoneNumber = null;
      } catch (ApiException e) {
        echo("Error (%d): %s".formatted(e.getCode(), e.getMessage()));
      }
    } while (true);
  }

  /**
   * Will start an SMS verification onto specified phone number
   *
   * @param service Verification service
   * @param phoneNumber Destination phone number
   * @return Verification ID
   */
  private VerificationId startSmsVerification(
      VerificationsService service, E164PhoneNumber phoneNumber) {

    var parameters =
        StartVerificationSMSRequestParameters.builder()
            .setIdentity(NumberIdentity.valueOf(phoneNumber))
            .build();
    echo("Sending verification request onto '%s'".formatted(phoneNumber.stringValue()));

    var response = service.startSms(parameters);
    echo("Verification started with ID '%s'".formatted(response.getId()));
    return response.getId();
  }

  /**
   * Will query for a verification report by ID
   *
   * @param service Verification service
   * @param code Code received by SMS
   * @param id Verification ID related to the verification
   */
  private void reportSmsVerification(VerificationsService service, String code, VerificationId id) {
    var parameters = VerificationReportSMSRequestParameters.builder().setCode(code).build();

    echo("Requesting report for '%s'".formatted(id.getId()));
    var response = service.reportSmsById(id, parameters);
    echo("Report response: %s".formatted(response));
  }

  /**
   * Query user for a valid phone number
   *
   * @return Phone number value
   */
  private E164PhoneNumber queryPhoneNumber() {
    String input;
    boolean valid;
    do {
      input = prompt("\nEnter a phone number to start verification");
      valid = E164PhoneNumber.validate(input);
      if (!valid) {
        echo("Invalid number '%s'".formatted(input));
      }
    } while (!valid);

    return E164PhoneNumber.valueOf(input);
  }

  /**
   * Query user for a code
   *
   * @return Value entered by user
   */
  private String queryCode() {
    return prompt("Enter the verification code to report the verification");
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
}
