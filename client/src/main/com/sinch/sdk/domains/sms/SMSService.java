package com.sinch.sdk.domains.sms;

/**
 * SMS Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/">https://developers.sinch.com/docs/sms/api-reference/</a>
 * @since 1.0
 */
public interface SMSService {

  /**
   * Batches Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  BatchesService batches();

  /**
   * WebHooksService Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  WebHooksService webHooks();

  /**
   * Delivery Reports Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  DeliveryReportsService deliveryReports();

  /**
   * Inbounds Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  InboundsService inbounds();

  /**
   * Groups Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  GroupsService groups();
}
