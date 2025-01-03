package com.sinch.sdk.domains.sms.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.api.v1.internal.DeliveryReportsApi;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.BatchDeliveryReportQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.ListDeliveryReportsQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.response.ListDeliveryReportsResponse;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.response.internal.DeliveryReportList;
import com.sinch.sdk.domains.sms.models.v1.internal.SMSCursorPageNavigator;
import com.sinch.sdk.models.SmsContext;
import java.util.Map;

public class DeliveryReportsService
    implements com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService {

  private final DeliveryReportsApi api;

  protected DeliveryReportsApi getApi() {
    return this.api;
  }

  public DeliveryReportsService(
      String uriUUID,
      SmsContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.api =
        new DeliveryReportsApi(
            httpClient, context.getSmsServer(), authManagers, new HttpMapper(), uriUUID);
  }

  public BatchDeliveryReport get(String batchId, BatchDeliveryReportQueryParameters parameters)
      throws ApiException {

    return getApi().get(batchId, parameters);
  }

  public RecipientDeliveryReport getForNumber(String batchId, String recipient)
      throws ApiException {
    return getApi().getForNumber(batchId, recipient);
  }

  public ListDeliveryReportsResponse list() throws ApiException {
    return this.list(null);
  }

  public ListDeliveryReportsResponse list(ListDeliveryReportsQueryParameters parameters)
      throws ApiException {

    DeliveryReportList response = getApi().list(parameters);

    SMSCursorPageNavigator navigator =
        new SMSCursorPageNavigator(response.getPage(), response.getPageSize());

    return new ListDeliveryReportsResponse(
        this, new Page<>(parameters, response.getDeliveryReports(), navigator));
  }
}
