package com.sinch.sdk.domains.conversation;

/**
 * Contact related service
 *
 * <p>A contact is a collection that groups together underlying connected channel recipient
 * identities.
 *
 * <p>It's tied to a specific project and is therefore considered public to all apps sharing the
 * same project.
 *
 * <p>Most contact creation and maintenance is handled by the Conversation API's automatic see <a
 * href="https://developers.sinch.com/docs/conversation/contact-management">contact management
 * processes</a>.
 *
 * <p>However, you can also use API calls to manually manage your contacts.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Contact">https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Contact</a>
 * @since 1.0
 */
public interface ContactService {

  /**
   * List Contacts
   *
   * <p>List all contacts in the project. Note that, if a WhatsApp contact is returned, the
   * display_name field of that contact may be populated with the WhatsApp display name (if the name
   * is already stored on the server and the display_name field has not been overwritten by the
   * user).
   *
   * @param parameters Filtering parameters
   * @return List of contacts according to search criteria
   * @since 1.0
   */
  // ContactListResponse list(ContactListRequestParameters parameters);

  /**
   * Get a Contact
   *
   * <p>Returns a specific contact as specified by the contact ID. Note that, if a WhatsApp contact
   * is returned, the display_name field of that contact may be populated with the WhatsApp display
   * name (if the name is already stored on the server and the display_name field has not been
   * overwritten by the user).
   *
   * @param contactId Contact's Id
   * @return Contact information
   * @since 1.0
   */
  //  Contact get(String contactId);

  /**
   * Create a Contact
   *
   * <p>Most Conversation API contacts are <a
   * href="https://developers.sinch.com/docs/conversation/contact-management">created
   * automatically</a> when a message is sent to a new recipient. You can also create a new contact
   * manually using this API call.
   *
   * @param contact Contact information to be used for creation
   * @return Contact information
   * @since 1.0
   */
  // Contact create(ContactCreateRequestParameters contact);

  /**
   * Delete a contact as specified by the contact ID.
   *
   * @param contactId Contact's Id
   * @since 1.0
   */
  // void delete(String contactId);

  /**
   * Updates a contact as specified by the contact ID.
   *
   * @param contact Contact information to be updated. {@link Contact#getId() #Id} have to set and
   *     will be used to identify Contact to be updated
   * @return Updated contact information
   * @since 1,0
   */
  // Contact update(Contact contact);

  /**
   * Merge two Contacts.
   *
   * <p>The remaining contact will contain all conversations that the removed contact did.
   *
   * <p>If both contacts had conversations within the same App, messages from the removed contact
   * will be merged into corresponding active conversations in the destination contact.
   *
   * <p>Channel identities will be moved from the source contact to the destination contact only for
   * channels that weren't present there before.
   *
   * <p>Moved channel identities will be placed at the bottom of the channel priority list. Optional
   * fields from the source contact will be copied only if corresponding fields in the destination
   * contact are empty
   *
   * <p>The contact being removed cannot be referenced after this call.
   *
   * @param destinationId The unique ID of the contact that should be kept when merging two
   *     contacts.
   * @param sourceId The ID of the contact that should be removed
   * @return The merged contact details
   * @since 1,0
   */
  //// Contact mergeContact(String destinationId, String sourceId);

  /**
   * Get user profile from a specific channel by contact ID.
   *
   * <p>Only supported on {@link com.sinch.sdk.domains.conversation.models.ChannelType#MESSENGER
   * MESSENGER}, {@link com.sinch.sdk.domains.conversation.models.ChannelType#INSTAGRAM INSTAGRAM},
   * {@link com.sinch.sdk.domains.conversation.models.ChannelType#VIBER VIBER} and {@link
   * com.sinch.sdk.domains.conversation.models.ChannelType#LINE LINE} channels.
   *
   * <p>Note that, in order to retrieve a WhatsApp display name, you can use the Get a Contact or
   * List Contacts operations, which will populate the display_name field of each returned contact
   * with the WhatsApp display name (if the name is already stored on the server and the
   * display_name field has not been overwritten by the user).
   *
   * @param parameters The ID of the contact to be used to check profile information
   * @return The profile name
   * @since 1,0
   */
  // String getChannelProfileByContactId(GetChannelProfileByContactRequestParameters parameters);

  /**
   * Get user profile from a specific channel by channel identity.
   *
   * <p>Only supported on {@link com.sinch.sdk.domains.conversation.models.ChannelType#MESSENGER
   * MESSENGER}, {@link com.sinch.sdk.domains.conversation.models.ChannelType#INSTAGRAM INSTAGRAM},
   * {@link com.sinch.sdk.domains.conversation.models.ChannelType#VIBER VIBER} and {@link
   * com.sinch.sdk.domains.conversation.models.ChannelType#LINE LINE} channels.
   *
   * <p>Note that, in order to retrieve a WhatsApp display name, you can use the Get a Contact or
   * List Contacts operations, which will populate the display_name field of each returned contact
   * with the WhatsApp display name (if the name is already stored on the server and the
   * display_name field has not been overwritten by the user).
   *
   * @param parameters The identity as specified by the channel to be used to check profile
   *     information
   * @return The profile name
   * @since 1,0
   */
  //  String getChannelProfileByChannelIdentity(GetChannelProfileByChannelRequestParameters
  // parameters);
}
