package com.sinch.sdk.domains.conversation.api.v1;

import com.sinch.sdk.domains.conversation.models.v1.app.request.AppCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppUpdateRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.response.AppResponse;
import com.sinch.sdk.models.ConversationRegion;
import java.util.Collection;

/**
 * Applications related service
 *
 * <p>Apps are created and configured through the Sinch Dashboard, are tied to the API user and come
 * with a set of channel credentials for each underlying connected channel.
 *
 * <p>The app has a list of conversations between itself and different contacts which share the same
 * project.
 *
 * <p>Webhooks, which the app is attached to, defines the destination for various events coming from
 * the Conversation API. An app has the following configurable properties:
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/App/">https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/App/</a>
 * @since 1.0
 */
public interface AppService {

  /**
   * List all apps
   *
   * <p>Get a list of all apps in the specified project
   *
   * @return List of apps related to configured region (from {@link
   *     com.sinch.sdk.models.Configuration.Builder#setConversationRegion(ConversationRegion)})
   * @since 1.0
   */
  Collection<AppResponse> list();

  /**
   * Get an app
   *
   * <p>Returns a particular app as specified by the App ID.
   *
   * @param appId The application identifier
   * @return App information details
   * @since 1.0
   */
  AppResponse get(String appId);

  /**
   * Delete an app
   *
   * <p>Deletes the app specified by the App ID
   *
   * <p>Note that this operation will not delete contacts (which are stored at the project level)
   * nor any channel-specific resources (for example, WhatsApp Sender Identities will not be
   * deleted).
   *
   * @param appId The application identifier
   * @since 1.0
   */
  void delete(String appId);

  /**
   * Create a Conversation application
   *
   * <p>You can create a new Conversation API app using the API.
   *
   * <p>You can create an app for one or more channels at once.
   *
   * @param parameters Creation parameters
   * @return Created application
   */
  AppResponse create(AppCreateRequest parameters);

  /**
   * Update a Conversation application
   *
   * <p>Updates a particular app as specified by the App ID.
   *
   * <p>Any specified field values will replace existing values.
   *
   * <p>Therefore, if you'd like to add additional configurations to an existing Conversation API
   * app, ensure that you include existing values AND new values in the call. For example, if you'd
   * like to add new channel_credentials, you can get your existing Conversation API app, extract
   * the existing channel_credentials list, append your new configuration to that list, and include
   * the updated channel_credentials list in this update call.
   *
   * @param appId The unique ID of the app to be updated
   * @param parameters Fields to be updated. Only fields filled within the parameters will be
   *     updated
   * @return Updated application
   */
  AppResponse update(String appId, AppUpdateRequest parameters);
}
