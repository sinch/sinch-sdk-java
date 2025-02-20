/*
 * API Overview | Sinch
 *
 * OpenAPI document version: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.BatchDeliveryReportQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.ListDeliveryReportsQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.response.ListDeliveryReportsResponse;

/** Delivery reports Service */
public interface DeliveryReportsService {

  /**
   * Retrieve a delivery report (using default parameters) Delivery reports can be retrieved even if
   * no callback was requested. The difference between a summary and a full report is only that the
   * full report contains the phone numbers in
   * [E.164](https://community.sinch.com/t5/Glossary/E-164/ta-p/7537) format for each status code.
   *
   * @param batchId The batch ID you received from sending a message. (required)
   * @return BatchDeliveryReport
   * @throws ApiException if fails to make API call
   */
  BatchDeliveryReport get(String batchId) throws ApiException;

  /**
   * Retrieve a delivery report Delivery reports can be retrieved even if no callback was requested.
   * The difference between a summary and a full report is only that the full report contains the
   * phone numbers in [E.164](https://community.sinch.com/t5/Glossary/E-164/ta-p/7537) format for
   * each status code.
   *
   * @param batchId The batch ID you received from sending a message. (required)
   * @param queryParameter (optional)
   * @return BatchDeliveryReport
   * @throws ApiException if fails to make API call
   */
  BatchDeliveryReport get(String batchId, BatchDeliveryReportQueryParameters queryParameter)
      throws ApiException;

  /**
   * Retrieve a recipient delivery report A recipient delivery report contains the message status
   * for a single recipient phone number.
   *
   * @param batchId The batch ID you received from sending a message. (required)
   * @param recipientMsisdn Phone number for which you to want to search. (required)
   * @return RecipientDeliveryReport
   * @throws ApiException if fails to make API call
   */
  RecipientDeliveryReport getForNumber(String batchId, String recipientMsisdn) throws ApiException;

  /**
   * Retrieve a list of delivery reports (using default parameters) Get a list of finished delivery
   * reports. This operation supports pagination.
   *
   * @return ListDeliveryReportsResponse
   * @throws ApiException if fails to make API call
   */
  ListDeliveryReportsResponse list() throws ApiException;

  /**
   * Retrieve a list of delivery reports Get a list of finished delivery reports. This operation
   * supports pagination.
   *
   * @param queryParameter (optional)
   * @return ListDeliveryReportsResponse
   * @throws ApiException if fails to make API call
   */
  ListDeliveryReportsResponse list(ListDeliveryReportsQueryParameters queryParameter)
      throws ApiException;
}
