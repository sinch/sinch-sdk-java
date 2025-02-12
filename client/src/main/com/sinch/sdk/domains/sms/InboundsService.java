package com.sinch.sdk.domains.sms;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.Inbound;
import com.sinch.sdk.domains.sms.models.requests.InboundsListRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.InboundsListResponse;
import com.sinch.sdk.domains.sms.models.v1.inbounds.request.ListInboundMessagesQueryParameters;

/**
 * Inbounds Service
 *
 * <p>Inbounds, or Mobile Originated (MO) messages, are incoming messages. Inbound messages can be
 * listed and retrieved like batch messages and they can also be delivered by callback requests like
 * delivery reports.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Inbounds/">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Inbounds/</a>
 * @since 1.0
 * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.InboundsService} instead.
 */
@Deprecated
public interface InboundsService {

  /**
   * List incoming messages
   *
   * <p>With the list operation, you can list all inbound messages that you have received. This
   * operation supports pagination. Inbounds are returned in reverse chronological order.
   *
   * @param parameters Filtering parameters
   * @return Incoming messages
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/getDeliveryReports">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/getDeliveryReports</a>
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.sms.api.v1.InboundsService#list(ListInboundMessagesQueryParameters)}
   *     instead.
   */
  @Deprecated
  InboundsListResponse list(InboundsListRequestParameters parameters) throws ApiException;

  /**
   * Retrieve inbound message
   *
   * <p>This operation retrieves a specific inbound message with the provided inbound ID
   *
   * @param inboundId The inbound ID found when listing inbound messages
   * @return Inbound messages-
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Inbounds/#tag/Inbounds/operation/RetrieveInboundMessage">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Inbounds/#tag/Inbounds/operation/RetrieveInboundMessage</a>
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.InboundsService#get(String)} instead.
   */
  @Deprecated
  Inbound<?> get(String inboundId) throws ApiException;
}
