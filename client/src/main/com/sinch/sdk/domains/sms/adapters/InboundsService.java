package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.adapters.api.v1.InboundsApi;
import com.sinch.sdk.domains.sms.adapters.converters.InboundsDtoConverter;
import com.sinch.sdk.domains.sms.models.Inbound;
import com.sinch.sdk.domains.sms.models.SMSCursorPageNavigator;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiInboundListDto;
import com.sinch.sdk.domains.sms.models.dto.v1.InboundDto;
import com.sinch.sdk.domains.sms.models.requests.InboundsListRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.InboundsListResponse;
import com.sinch.sdk.models.SmsContext;
import java.time.Instant;
import java.util.Collection;
import java.util.Map;

public class InboundsService implements com.sinch.sdk.domains.sms.InboundsService {

  private final String uriUUID;
  private final InboundsApi api;

  protected InboundsApi getApi() {
    return this.api;
  }

  public InboundsService(
      String uriUUID,
      SmsContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api = new InboundsApi(httpClient, context.getSmsServer(), authManagers, new HttpMapper());
  }

  public InboundsListResponse list() throws ApiException {
    return this.list(null);
  }

  public InboundsListResponse list(InboundsListRequestParameters parameters) throws ApiException {
    InboundsListRequestParameters guardParameters =
        null != parameters ? parameters : InboundsListRequestParameters.builder().build();

    ApiInboundListDto response =
        getApi()
            .listInboundMessages(
                uriUUID,
                guardParameters.getPage().orElse(null),
                guardParameters.getPageSize().orElse(null),
                guardParameters.getTo().map(f -> String.join(",", f)).orElse(null),
                guardParameters.getStartDate().map(Instant::toString).orElse(null),
                guardParameters.getEndDate().map(Instant::toString).orElse(null),
                guardParameters.getClientReference().orElse(null));

    Collection<Inbound<?>> content = InboundsDtoConverter.convert(response);
    SMSCursorPageNavigator navigator =
        new SMSCursorPageNavigator(response.getPage(), response.getPageSize());

    return new InboundsListResponse(this, new Page<>(guardParameters, content, navigator));
  }

  public Inbound<?> get(String inboundId) throws ApiException {

    InboundDto response = getApi().retrieveInboundMessage(uriUUID, inboundId);
    return InboundsDtoConverter.convert(response);
  }
}
