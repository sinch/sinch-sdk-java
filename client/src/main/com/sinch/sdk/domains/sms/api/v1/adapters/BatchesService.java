package com.sinch.sdk.domains.sms.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.sms.api.v1.internal.BatchesApi;
import com.sinch.sdk.domains.sms.models.v1.batches.request.BatchRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.Batch;
import com.sinch.sdk.models.SmsContext;
import java.util.Map;

public class BatchesService implements com.sinch.sdk.domains.sms.api.v1.BatchesService {

  private final BatchesApi api;

  public BatchesService(
      String uriUUID,
      SmsContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.api =
        new BatchesApi(httpClient, context.getSmsServer(), authManagers, new HttpMapper(), uriUUID);
  }

  protected BatchesApi getApi() {
    return this.api;
  }

  public Batch send(BatchRequest batch) throws ApiException {
    return getApi().send(batch);
  }

}
