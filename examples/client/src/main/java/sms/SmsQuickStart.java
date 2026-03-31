package sms;

import com.sinch.sdk.domains.sms.api.v1.SMSService;
import java.util.logging.Logger;

public class SmsQuickStart {

  private static final Logger LOGGER = Logger.getLogger(SmsQuickStart.class.getName());

  private final SMSService smsService;

  public SmsQuickStart(SMSService smsService) {
    this.smsService = smsService;

    // Insert your application logic or business process here
    LOGGER.info("Snippet execution");
  }
}
