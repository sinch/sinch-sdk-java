package com.sinch.sdk.domains.sms;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.sms.models.BaseDeliveryReport;
import com.sinch.sdk.domains.sms.models.Inbound;

/**
 * WebHooks
 *
 * <p><b>Callbacks</b>
 *
 * <p>A callback is an HTTP POST request with a notification made by the Sinch SMS REST API to a URI
 * of your choosing.
 *
 * <p>The REST API expects the receiving server to respond with a response code within the <code>2xx
 * </code> success range. For <code>5xx</code> the callback will be retried. For <code>429</code>
 * the callback will be retried and the throughput will be lowered. For other status codes in the
 * <code>4xx</code> range the callback will not be retried. The first initial retry will happen 5
 * seconds after the first try. The next attempt is after 10 seconds, then after 20 seconds, after
 * 40 seconds, after 80 seconds, doubling on every attempt. The last retry will be at 81920 seconds
 * (or 22 hours 45 minutes) after the initial failed attempt.
 *
 * <p>The SMS REST API offers the following callback options which can be configured for your
 * account upon request to your account manager.
 *
 * <ul>
 *   <li>Callback with mutual authentication over TLS (HTTPS) connection by provisioning the
 *       callback URL with client keystore and password.
 *   <li>Callback with basic authentication by provisioning the callback URL with username and
 *       password.
 *   <li>Callback with OAuth 2.0 by provisioning the callback URL with username, password and the
 *       URL to fetch OAuth access token.
 *   <li>Callback using AWS SNS by provisioning the callback URL with an Access Key ID, Secret Key
 *       and Region.
 * </ul>
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/</a>
 * @since 1.0
 */
public interface WebHooksService {

  /**
   * Incoming SMS WebHook
   *
   * <p>An inbound message is a message sent to one of your short codes or long numbers from a
   * mobile phone. To receive inbound message callbacks, a URL needs to be added to your REST API.
   * This URL can be specified in your <a href="https://dashboard.sinch.com/sms/api">Dashboard</a>.
   *
   * @param jsonPayload The incoming message to your sinch number
   * @return Decoded payload
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/operation/incomingSMS">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/operation/incomingSMS</a>
   * @since 1.0
   */
  Inbound<?> incomingSMS(String jsonPayload) throws ApiMappingException;

  /**
   * Delivery Report WebHook
   *
   * <p>A delivery report contains the status and status code for each recipient of a batch. To get
   * a delivery report callback for a message or batch of messages, set the <code>delivery_report
   * </code> field accordingly when creating a batch.
   *
   * <p>The following is provided so you can better understand our webhooks/callbacks. Configuration
   * of both webhooks and the type of delivery report requested happens when sending a batch.
   *
   * <p><b>Callback URL</b>
   *
   * <p>The callback URL can either be provided for each batch or provisioned globally for your
   * account in your <a href="https://dashboard.sinch.com/sms/api/rest">Sinch Customer
   * Dashboard</a>. Learn how to configure a webhook/callback <a
   * href="https://community.sinch.com/t5/SMS/How-do-I-assign-a-callback-URL-to-an-SMS-service-plan/ta-p/8414">here</a>
   *
   * <p><b>Type</b>
   *
   * <p>The <code>type</code> is the type of delivery report webhook. The response will vary
   * depending on the webhook delivery report you selected when the batch was sent, so choose the
   * appropriate selection under "One of".
   *
   * <ul>
   *   <li>The <code>delivery_report_sms</code> and <code>delivery_report_mms</code> types are
   *       documented under <b>Delivery report</b>. These are reports containing <a
   *       href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/SendSMS!path=0/delivery_report&amp;t=request">either
   *       a full report or summary report</a>, depending on your selection at the time the batch
   *       was sent.
   *   <li>The <code>recipient_delivery_report_sms</code> and <code>recipient_delivery_report_mms
   *       </code> delivery report types are documented under <b>Recipient delivery report</b>.
   *       These are delivery reports for recipient phone numbers. If you set <code>per_recipient
   *       </code> for the <code>delivery_report</code> parameter when sending the batch, a
   *       recipient report gets sent to you for each status change for each recipient in your
   *       batch. If you set <code>per_recipient_final</code>, a recipient report gets sent to you
   *       for the final status of each recipient in your batch.
   * </ul>
   *
   * @param jsonPayload The incoming delivery report
   * @return Decoded payload
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/operation/deliveryReport">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/operation/deliveryReport</a>
   * @since 1.0
   */
  BaseDeliveryReport deliveryReport(String jsonPayload) throws ApiMappingException;
}
