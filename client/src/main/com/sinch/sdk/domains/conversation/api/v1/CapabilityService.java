package com.sinch.sdk.domains.conversation.api.v1;

import com.sinch.sdk.domains.conversation.models.v1.capability.request.QueryCapabilityRequest;
import com.sinch.sdk.domains.conversation.models.v1.capability.response.QueryCapabilityResponse;

/**
 * Service for working with capability
 *
 * <p>A capability query checks the options available for reaching the contact on the channels on
 * which it has a channel identity.
 *
 * <p>Capability queries can only be executed for contacts that already exist in a project and app.
 * For executing the request, either the contact ID or the channel recipient identities of the
 * contact are required.
 *
 * <p>The request is executed asynchronously, therefore the service responds immediately. The result
 * of the capability query is sent to the registered webhook for the <b>CAPABILITY</b> trigger.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Capability/">online
 *     documentation</a>
 * @since _NEXT_VERSION_
 */
public interface CapabilityService {

  /**
   * Capability lookup
   *
   * <p>This method is asynchronous - it immediately returns the requested Capability registration.
   *
   * <p>Capability check is then delivered as a callback to registered webhooks with trigger <code>
   * CAPABILITY</code> for every reachable channel.
   *
   * @param request The request parameters to lookup capability
   * @return The capability response
   * @since _NEXT_VERSION_
   */
  QueryCapabilityResponse lookup(QueryCapabilityRequest request);
}
