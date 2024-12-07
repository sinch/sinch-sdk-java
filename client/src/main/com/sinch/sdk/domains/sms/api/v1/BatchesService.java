package com.sinch.sdk.domains.sms.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.v1.batches.request.BatchRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.Batch;

public interface BatchesService {

  Batch send(BatchRequest batch) throws ApiException;

}
