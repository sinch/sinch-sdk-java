package com.sinch.sdk.domains.sms;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.BaseBatch;
import com.sinch.sdk.domains.sms.models.Batch;
import com.sinch.sdk.domains.sms.models.DryRun;
import com.sinch.sdk.domains.sms.models.requests.BatchesListRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.UpdateBaseBatchRequest;
import com.sinch.sdk.domains.sms.models.responses.BatchesListResponse;
import java.util.Collection;

/**
 * Batches Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/</a>
 * @since 1.0
 */
public interface BatchesService {

  /**
   * Get a batch message.
   *
   * <p>This operation returns a specific batch that matches the provided batch ID.
   *
   * @param batchId The batch ID you received from sending a message
   * @param <T> A type of Batch
   * @return Batch information
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/GetBatchMessage">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/GetBatchMessage</a>
   * @since 1.0
   */
  <T extends Batch<?>> T get(String batchId) throws ApiException;

  /**
   * Send a message or a batch of messages.
   *
   * <p>Depending on the length of the body, one message might be split into multiple parts and
   * charged accordingly. <br>
   * Any groups targeted in a scheduled batch will be evaluated at the time of sending. If a group
   * is deleted between batch creation and scheduled date, it will be considered empty. <br>
   * Be sure to use the correct region in the server URL.
   *
   * @param batch The batch to be created
   * @param <T> A type of Batch
   * @return Batch information
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/SendSMS">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/SendSMS</a>
   * @since 1.0
   */
  <T extends Batch<?>> T send(BaseBatch<?> batch) throws ApiException;

  /**
   * Dry run.
   *
   * <p>This operation will perform a dry run of a batch which calculates the bodies and number of
   * parts for all messages in the batch without actually sending any messages.
   *
   * @param perRecipient Whether to include per recipient details in the response
   * @param numberOfRecipient Max number of recipients to include per recipient details for in the
   *     response
   * @param batch The batch to be send
   * @return Details about dryRun execution
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/Dry_Run">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/Dry_Run</a>
   * @since 1.0
   */
  DryRun dryRun(boolean perRecipient, int numberOfRecipient, BaseBatch<?> batch)
      throws ApiException;

  /**
   * List Batches.
   *
   * <p>With the list operation you can list batch messages created in the last 14 days that you
   * have created. This operation supports pagination.
   *
   * @param parameters Query parameters filtering returned batches
   * @return Paginated list of Batches
   * @since 1.0
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/ListBatches">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/ListBatches</a>
   */
  BatchesListResponse list(BatchesListRequestParameters parameters) throws ApiException;

  /**
   * Update a Batch message.
   *
   * <p>This operation updates all specified parameters of a batch that matches the provided batch
   * ID.
   *
   * @param batchId The batch ID you received from sending a message
   * @param batch Batch parameters to be updated
   * @param <T> A type of Batch
   * @return Batch information
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/UpdateBatchMessage">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/UpdateBatchMessage</a>
   * @since 1.0
   */
  <T extends Batch<?>> T update(String batchId, UpdateBaseBatchRequest<?> batch)
      throws ApiException;

  /**
   * Replace a batch .
   *
   * <p>This operation will replace all the parameters of a batch with the provided values. It is
   * the same as cancelling a batch and sending a new one instead.
   *
   * @param batchId The batch ID you received from sending a message
   * @param batch Batch parameters to be used
   * @param <T> A type of Batch
   * @return Batch information
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/ReplaceBatch">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/ReplaceBatch</a>
   * @since 1.0
   */
  <T extends Batch<?>> T replace(String batchId, BaseBatch<?> batch) throws ApiException;

  /**
   * Cancel a batch message.
   *
   * <p>A batch can be canceled at any point. If a batch is canceled while it's currently being
   * delivered some messages currently being processed might still be delivered. The delivery report
   * will indicate which messages were canceled and which weren't. <br>
   * Canceling a batch scheduled in the future will result in an empty delivery report while
   * canceling an already sent batch would result in no change to the completed delivery report.
   *
   * @param batchId The batch ID you received from sending a message
   * @param <T> A type of Batch
   * @return Batch information
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/CancelBatchMessage">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/CancelBatchMessage</a>
   * @since 1.0
   */
  <T extends Batch<?>> T cancel(String batchId) throws ApiException;

  /**
   * Send delivery feedback for a message.
   *
   * <p>Send feedback if your system can confirm successful message delivery.
   *
   * <p>Feedback can only be provided if feedback_enabled was set when batch was submitted.
   *
   * <p><em>Batches</em>: It is possible to submit feedback multiple times for the same batch for
   * different recipients. Feedback without specified recipients is treated as successful message
   * delivery to all recipients referenced in the batch. Note that the recipients key is still
   * required even if the value is empty.
   *
   * <p><em>Groups</em>: If the batch message was creating using a group ID, at least one recipient
   * is required. Excluding recipients (an empty recipient list) does not work and will result in a
   * failed request.
   *
   * @param batchId The batch ID you received from sending a message
   * @param recipients A list of phone numbers (MSISDNs) that have successfully received the
   *     message. The key is required, however, the value can be an empty array ([]) for a batch. If
   *     the feedback was enabled for a group, at least one phone number is required.
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/deliveryFeedback">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/deliveryFeedback</a>
   * @since 1.0
   */
  void sendDeliveryFeedback(String batchId, Collection<String> recipients) throws ApiException;
}
