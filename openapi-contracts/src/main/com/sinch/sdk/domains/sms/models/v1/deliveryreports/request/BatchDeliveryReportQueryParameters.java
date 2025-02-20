/*
 * API Overview | Sinch
 *
 * OpenAPI document version: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.v1.deliveryreports.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryReceiptErrorCode;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryStatus;
import java.util.List;

/** BatchDeliveryReportQueryParameters */
public interface BatchDeliveryReportQueryParameters {

  /**
   * Get type
   *
   * @return type
   */
  OptionalValue<QueryReportType> getType();

  /**
   * Get status
   *
   * @return status
   */
  OptionalValue<List<DeliveryStatus>> getStatus();

  /**
   * Get code
   *
   * @return code
   */
  OptionalValue<List<DeliveryReceiptErrorCode>> getCode();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new BatchDeliveryReportQueryParametersImpl.Builder();
  }

  /**
   * Getting builder from existing instance
   *
   * @return New Builder instance
   */
  static Builder builder(BatchDeliveryReportQueryParameters parameters) {
    return new BatchDeliveryReportQueryParametersImpl.Builder(parameters);
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param type see getter
     * @return Current builder
     * @see #getType
     */
    Builder setType(QueryReportType type);

    /**
     * see getter
     *
     * @param status see getter
     * @return Current builder
     * @see #getStatus
     */
    Builder setStatus(List<DeliveryStatus> status);

    /**
     * see getter
     *
     * @param code see getter
     * @return Current builder
     * @see #getCode
     */
    Builder setCode(List<DeliveryReceiptErrorCode> code);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    BatchDeliveryReportQueryParameters build();
  }
}
