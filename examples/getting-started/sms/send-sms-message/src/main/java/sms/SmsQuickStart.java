package sms;

import com.sinch.sdk.domains.sms.api.v1.SMSService;

public class SmsQuickStart {

  private final SMSService smsService;

  public SmsQuickStart(SMSService smsService) {
    this.smsService = smsService;

    // Insert your application logic or business process here
    Snippet.execute(this.smsService);
  }
}
