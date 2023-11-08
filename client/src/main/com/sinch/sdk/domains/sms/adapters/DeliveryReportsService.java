package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.domains.sms.adapters.api.v1.DeliveryReportsApi;
import com.sinch.sdk.domains.sms.adapters.converters.DeliveryReportDtoConverter;
import com.sinch.sdk.domains.sms.models.DeliveryReport;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import com.sinch.sdk.models.Configuration;
import java.util.Collection;
import java.util.stream.Collectors;

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
public class DeliveryReportsService implements com.sinch.sdk.domains.sms.DeliveryReportsService {

  private Configuration configuration;
  private DeliveryReportsApi api;

  public DeliveryReportsService() {}

  private DeliveryReportsApi getApi() {
    return this.api;
  }

  public DeliveryReportsService(Configuration configuration, HttpClient httpClient) {
    this.configuration = configuration;
    this.api = new DeliveryReportsApi(httpClient, configuration.getSmsServer(), new HttpMapper());
  }

  public com.sinch.sdk.domains.sms.models.webhooks.DeliveryReport get(
      String batchId,
      DeliveryReport type,
      Collection<DeliveryReportStatus> statuses,
      Collection<Integer> codes)
      throws ApiException {

    String typeParam = null != type ? type.value() : null;
    String statusesParam =
        null != statuses
            ? statuses.stream().map(EnumDynamic::value).collect(Collectors.joining(","))
            : null;
    String codesParam =
        null != codes
            ? codes.stream().map(Object::toString).collect(Collectors.joining(","))
            : null;

    return DeliveryReportDtoConverter.convert(
        getApi()
            .getDeliveryReportByBatchId(
                configuration.getProjectId(), batchId, typeParam, statusesParam, codesParam));
  }
}
