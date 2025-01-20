package com.sinch.sdk.domains.sms.api.v1;

/**
 * SMS Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/">https://developers.sinch.com/docs/sms/api-reference/</a>
 * @since 1.5
 */
public interface SMSService {

  /**
   * Batches Service instance
   *
   * @return service instance for project
   * @since 1.5
   */
  BatchesService batches();

  /**
   * Inbounds Service instance
   *
   * @return service instance for project
   * @since 1.5
   */
  InboundsService inbounds();

  /**
   * Delivery Reports Service instance
   *
   * @return service instance for project
   * @since 1.5
   */
  DeliveryReportsService deliveryReports();

  /**
   * Groups Service instance
   *
   * @return service instance for project
   * @since 1.5
   */
  GroupsService groups();

  /**
   * WebHooksService Service instance
   *
   * @return service instance for project
   * @since 1.5
   */
  WebHooksService webhooks();
}
