/**
 * SMS API webhooks related models
 *
 * <h2>Incoming SMS WebHook</h2>
 *
 * <p>An inbound message is a message sent to one of your short codes or long numbers from a mobile
 * phone. To receive inbound message callbacks, a URL needs to be added to your REST API.
 *
 * <p>This URL can be specified in your <a href="https://dashboard.sinch.com/sms/api">Dashboard</a>.
 *
 * <p>See <a
 * href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/operation/incomingSMS">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/operation/incomingSMS</a>
 *
 * <h2>Delivery Report WebHook</h2>
 *
 * <p>A delivery report contains the status and status code for each recipient of a batch. To get a
 * delivery report callback for a message or batch of messages, set the <code>delivery_report
 * </code> field accordingly when creating a batch.
 *
 * <p>The following is provided so you can better understand our webhooks/callbacks. Configuration
 * of both webhooks and the type of delivery report requested happens when sending a batch.
 *
 * <p><b>Callback URL</b>
 *
 * <p>The callback URL can either be provided for each batch or provisioned globally for your
 * account in your <a href="https://dashboard.sinch.com/sms/api/rest">Sinch Customer Dashboard</a>.
 * Learn how to configure a webhook/callback <a
 * href="https://community.sinch.com/t5/SMS/How-do-I-assign-a-callback-URL-to-an-SMS-service-plan/ta-p/8414">here</a>
 *
 * <p><b>Type</b>
 *
 * <p>The <code>type</code> is the type of delivery report webhook. The response will vary depending
 * on the webhook delivery report you selected when the batch was sent, so choose the appropriate
 * selection under "One of".
 *
 * <ul>
 *   <li>The <code>delivery_report_sms</code> and <code>delivery_report_mms</code> types are
 *       documented under <b>Delivery report</b>.
 *       <p>These are reports containing <a
 *       href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/SendSMS!path=0/delivery_report&amp;t=request">either
 *       a full report or summary report</a>, depending on your selection at the time the batch was
 *       sent.
 *   <li>The <code>recipient_delivery_report_sms</code> and <code>recipient_delivery_report_mms
 *       </code> delivery report types are documented under <b>Recipient delivery report</b>.
 *       <p>These are delivery reports for recipient phone numbers. If you set <code>per_recipient
 *       </code> for the <code>delivery_report</code> parameter when sending the batch, a recipient
 *       report gets sent to you for each status change for each recipient in your batch. If you set
 *       <code>per_recipient_final</code>, a recipient report gets sent to you for the final status
 *       of each recipient in your batch.
 * </ul>
 *
 * See <a
 * href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/operation/deliveryReport">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/operation/deliveryReport</a>
 *
 * @since 1.0
 */
package com.sinch.sdk.domains.sms.models.v1.webhooks;
