package com.sinch.sdk.domains.sms.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage;
import com.sinch.sdk.domains.sms.models.v1.inbounds.request.ListInboundMessagesQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.inbounds.response.ListInboundsResponse;

public interface InboundsService {

  ListInboundsResponse list(ListInboundMessagesQueryParameters parameters) throws ApiException;

  InboundMessage get(String inboundId) throws ApiException;
}
