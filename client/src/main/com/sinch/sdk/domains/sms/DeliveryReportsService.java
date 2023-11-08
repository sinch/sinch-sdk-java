package com.sinch.sdk.domains.sms;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import java.util.Collection;

/**
 * Delivery reports Service
 *
 * <p>The REST API uses message statuses and error codes in delivery reports, which refer to the
 * state of the batch and can be present in either <a
 * href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/GetDeliveryReportByBatchId">Retrieve
 * a delivery report</a> or sent as a callback.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports</a>
 * @since 1.0
 */
public interface DeliveryReportsService {

  /**
   * Retrieve a delivery report <br>
   * Delivery reports can be retrieved even if no callback was requested. The difference between a
   * summary and a full report is only that the full report contains the phone numbers in <a
   * href="https://community.sinch.com/t5/Glossary/E-164/ta-p/7537">E.164</a> format for each status
   * code.
   *
   * @param batchId The batch ID you received from sending a message param type param status param
   *     code
   * @param type The type of delivery report.
   *     <ul>
   *       <li>A <code>summary</code> will count the number of messages sent per status.
   *       <li>A <code>full</code> report give that of a summary report but in addition, lists phone
   *           numbers.
   *     </ul>
   *
   * @param statuses List of <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/section/Delivery-report-statuses">statuses</a>
   *     to include
   * @param codes List of <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/section/Delivery-report-error-codes">codes</a>
   *     to include
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/GetDeliveryReportByBatchId">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/GetDeliveryReportByBatchId</a>
   * @since 1.0
   */
  DeliveryReportBatch get(
      String batchId,
      DeliveryReportType type,
      Collection<DeliveryReportStatus> statuses,
      Collection<Integer> codes)
      throws ApiException;
}
