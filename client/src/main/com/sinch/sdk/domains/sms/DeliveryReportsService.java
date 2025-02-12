package com.sinch.sdk.domains.sms;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipient;
import com.sinch.sdk.domains.sms.models.requests.DeliveryReportBatchGetRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.DeliveryReportListRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.DeliveryReportsListResponse;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.BatchDeliveryReportQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.ListDeliveryReportsQueryParameters;

/**
 * Delivery reports Service.
 *
 * <p>The REST API uses message statuses and error codes in delivery reports, which refer to the
 * state of the batch and can be present in either <a
 * href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/GetDeliveryReportByBatchId">Retrieve
 * a delivery report</a> or sent as a callback.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports</a>
 * @since 1.0
 * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService} instead.
 */
@Deprecated
public interface DeliveryReportsService {

  /**
   * Retrieve a batch delivery report.
   *
   * <p>Delivery reports can be retrieved even if no callback was requested. The difference between
   * a summary and a full report is only that the full report contains the phone numbers in <a
   * href="https://community.sinch.com/t5/Glossary/E-164/ta-p/7537">E.164</a> format for each status
   * code.
   *
   * @param batchId The batch ID you received from sending a message param type param status param
   *     code
   * @param parameters Filtering parameters
   * @return Delivery report related to batchId according to filters
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/GetDeliveryReportByBatchId">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/GetDeliveryReportByBatchId</a>
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService#get(String,
   *     BatchDeliveryReportQueryParameters)} instead.
   */
  @Deprecated
  DeliveryReportBatch get(String batchId, DeliveryReportBatchGetRequestParameters parameters)
      throws ApiException;

  /**
   * Retrieve a recipient delivery report.
   *
   * <p>A recipient delivery report contains the message status for a single recipient phone number.
   *
   * @param batchId The batch ID you received from sending a message param type param status param
   *     code
   * @param recipient Phone number for which you to want to search
   * @return Delivery report related to batchId according to filters
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/GetDeliveryReportByPhoneNumber">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/GetDeliveryReportByPhoneNumber</a>
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService#getForNumber(String, String)}
   *     instead.
   */
  @Deprecated
  DeliveryReportRecipient getForNumber(String batchId, String recipient) throws ApiException;

  /**
   * Get a list of finished delivery reports.
   *
   * <p>This operation supports pagination.
   *
   * @param parameters Filtering parameters
   * @return Delivery report related to batchId according to filters
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/getDeliveryReports">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/getDeliveryReports</a>
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService#list(ListDeliveryReportsQueryParameters)}
   *     instead.
   */
  @Deprecated
  DeliveryReportsListResponse list(DeliveryReportListRequestParameters parameters)
      throws ApiException;
}
