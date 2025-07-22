package com.sinch.sdk.domains.sms;

/**
 * SMS Service
 *
 * @see <a href="https://developers.sinch.com/docs/sms">https://developers.sinch.com/docs/sms</a>
 * @since 1.0
 */
public interface SMSService {

  /**
   * SMS Service V1
   *
   * @return V1 service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/sdks/java/syntax-reference/">Documentation</a>
   * @since 1.5
   */
  com.sinch.sdk.domains.sms.api.v1.SMSService v1();
}
