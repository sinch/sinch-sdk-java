package sms;

import com.sinch.sdk.domains.sms.api.v1.SMSService;

public class SmsQuickStart {

  private final SMSService smsService;

  public SmsQuickStart(SMSService smsService) {
    this.smsService = smsService;

    // replace by your code and business logic
    Snippet.execute(this.smsService);
  }
}
