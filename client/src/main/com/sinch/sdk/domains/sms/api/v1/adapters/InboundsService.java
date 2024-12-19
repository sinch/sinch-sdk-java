package com.sinch.sdk.domains.sms.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.api.v1.internal.InboundsApi;
import com.sinch.sdk.domains.sms.models.v1.batches.internal.SMSCursorPageNavigator;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage;
import com.sinch.sdk.domains.sms.models.v1.inbounds.request.ListInboundMessagesQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.inbounds.response.ListInboundsResponse;
import com.sinch.sdk.domains.sms.models.v1.inbounds.response.internal.ApiInboundList;
import com.sinch.sdk.models.SmsContext;
import java.util.Map;

public class InboundsService implements com.sinch.sdk.domains.sms.api.v1.InboundsService {

  private final InboundsApi api;

  public InboundsService(
      String uriUUID,
      SmsContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.api =
        new InboundsApi(
            httpClient, context.getSmsServer(), authManagers, new HttpMapper(), uriUUID);
  }

  protected InboundsApi getApi() {
    return this.api;
  }

  public ListInboundsResponse list(ListInboundMessagesQueryParameters parameters)
      throws ApiException {

    ApiInboundList response = getApi().list(parameters);

    SMSCursorPageNavigator navigator =
        new SMSCursorPageNavigator(response.getPage(), response.getPageSize());

    return new ListInboundsResponse(
        this, new Page<>(parameters, response.getInbounds(), navigator));
  }

  public InboundMessage get(String inboundId) throws ApiException {
    return getApi().get(inboundId);
  }
}
