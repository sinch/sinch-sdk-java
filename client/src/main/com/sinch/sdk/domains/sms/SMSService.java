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

  /**
   * Batches Service instance
   *
   * @return service instance for project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.SMSService#batches()} instead.
   */
  @Deprecated
  BatchesService batches();

  /**
   * WebHooksService Service instance
   *
   * @return service instance for project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.SMSService#webhooks()} instead.
   */
  @Deprecated
  WebHooksService webHooks();

  /**
   * Delivery Reports Service instance
   *
   * @return service instance for project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.SMSService#deliveryReports()} instead.
   */
  @Deprecated
  DeliveryReportsService deliveryReports();

  /**
   * Inbounds Service instance
   *
   * @return service instance for project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.SMSService#inbounds()} instead.
   */
  @Deprecated
  InboundsService inbounds();

  /**
   * Groups Service instance
   *
   * @return service instance for project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.SMSService#groups()} instead.
   */
  @Deprecated
  GroupsService groups();
}
