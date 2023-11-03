package com.sinch.sdk.domains.sms;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.BaseBatch;
import com.sinch.sdk.domains.sms.models.Batch;
import com.sinch.sdk.domains.sms.models.DryRun;

/**
 * Batches Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/</a>
 * @since 1.0
 */
public interface BatchesService {

  /**
   * Get a batch message
   *
   * @param batchId The batch ID you received from sending a message
   * @param <T> A type of Batch
   * @return Batch information
   * @since 1.0
   */
  <T extends Batch<?>> T get(String batchId) throws ApiException;

  /**
   * Send a message or a batch of messages Depending on the length of the body, one message might be
   * split into multiple parts and charged accordingly.
   *
   * <p>Any groups targeted in a scheduled batch will be evaluated at the time of sending. If a
   * group is deleted between batch creation and scheduled date, it will be considered empty.
   *
   * @param batch The batch to be created
   * @param <T> A type of Batch
   * @return Batch information
   * @since 1.0
   */
  <T extends Batch<?>> T send(BaseBatch<?> batch) throws ApiException;

  /**
   * This operation will perform a dry run of a batch which calculates the bodies and number of
   * parts for all messages in the batch without actually sending any messages.
   *
   * @param perRecipient Whether to include per recipient details in the response
   * @param numberOfRecipient Max number of recipients to include per recipient details for in the
   *     response
   * @param batch The batch to be send
   * @return Details about dryRun execution
   */
  DryRun dryRun(boolean perRecipient, int numberOfRecipient, BaseBatch<?> batch)
      throws ApiException;
}
