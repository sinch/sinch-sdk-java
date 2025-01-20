package com.sinch.sdk.domains.sms.api.v1;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent;
import java.util.Map;

/**
 * SMS WebHooks service
 *
 * <p><b>Callbacks</b>
 *
 * <p>A callback is an HTTP POST request with a notification made by the Sinch SMS REST API to a URI
 * of your choosing.
 *
 * <p>The REST API expects the receiving server to respond with a response code within the <code>2xx
 * </code> success range. For <code>5xx</code> the callback will be retried. For <code>429</code>
 * the callback will be retried and the throughput will be lowered. For other status codes in the
 * <code>4xx</code> range the callback will not be retried. The first initial retry will happen 5
 * seconds after the first try. The next attempt is after 10 seconds, then after 20 seconds, after
 * 40 seconds, after 80 seconds, doubling on every attempt. The last retry will be at 81920 seconds
 * (or 22 hours 45 minutes) after the initial failed attempt.
 *
 * <p>The SMS REST API offers the following callback options which can be configured for your
 * account upon request to your account manager.
 *
 * <ul>
 *   <li>Callback with mutual authentication over TLS (HTTPS) connection by provisioning the
 *       callback URL with client keystore and password.
 *   <li>Callback with basic authentication by provisioning the callback URL with username and
 *       password.
 *   <li>Callback with OAuth 2.0 by provisioning the callback URL with username, password and the
 *       URL to fetch OAuth access token.
 *   <li>Callback using AWS SNS by provisioning the callback URL with an Access Key ID, Secret Key
 *       and Region.
 * </ul>
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/</a>
 * @since 1,5
 */
public interface WebHooksService {

  SmsEvent parseEvent(String jsonPayload) throws ApiMappingException;

  boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload);
}
