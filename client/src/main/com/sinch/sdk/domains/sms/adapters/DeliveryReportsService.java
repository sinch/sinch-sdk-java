package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.domains.sms.adapters.api.v1.DeliveryReportsApi;
import com.sinch.sdk.domains.sms.adapters.converters.DeliveryReportDtoConverter;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipient;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.requests.DeliveryReportBatchGetRequestParameters;
import com.sinch.sdk.models.Configuration;
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

  public DeliveryReportBatch get(String batchId, DeliveryReportBatchGetRequestParameters parameters)
      throws ApiException {

    DeliveryReportBatchGetRequestParameters guardParameters =
        null != parameters ? parameters : DeliveryReportBatchGetRequestParameters.builder().build();

    return DeliveryReportDtoConverter.convert(
        getApi()
            .getDeliveryReportByBatchId(
                configuration.getProjectId(),
                batchId,
                guardParameters.getType().map(DeliveryReportType::value).orElse(null),
                guardParameters
                    .geStatues()
                    .map(f -> f.stream().map(EnumDynamic::value).collect(Collectors.joining(",")))
                    .orElse(null),
                guardParameters
                    .getCodes()
                    .map(f -> f.stream().map(Object::toString).collect(Collectors.joining(",")))
                    .orElse(null)));
  }

  public DeliveryReportRecipient getForNumber(String batchId, String recipient)
      throws ApiException {
    return DeliveryReportDtoConverter.convert(
        getApi().getDeliveryReportByPhoneNumber(configuration.getProjectId(), batchId, recipient));
  }
}
