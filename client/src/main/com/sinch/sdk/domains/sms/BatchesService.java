package com.sinch.sdk.domains.sms;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.Batch;

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
   * @return Batch information
   * @since 1.0
   */
  <T extends Batch<?>> T get(String batchId) throws ApiException;
}
