package com.sinch.sdk.domains.conversation.api.v1;

import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.Contact;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactGetChannelProfileByChannelIdentityRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactGetChannelProfileByContactIdRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactListRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.IdentityConflictsListRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.ContactListResponse;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.IdentityConflictsListResponse;

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
 * @since 1.3
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
   * @since 1.3
   */
  ContactListResponse list(ContactListRequest parameters);

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
   * @since 1.3
   */
  Contact get(String contactId);

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
   * @since 1.3
   */
  Contact create(ContactCreateRequest contact);

  /**
   * Delete a contact as specified by the contact ID.
   *
   * @param contactId Contact's Id
   * @since 1.3
   */
  void delete(String contactId);

  /**
   * Updates a contact as specified by the contact ID.
   *
   * @param contactId Contact ID to be updated
   * @param contact Contact information to be updated
   * @return Updated contact information
   * @since 1.3
   */
  Contact update(String contactId, Contact contact);

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
   * @since 1.3
   */
  Contact mergeContact(String destinationId, String sourceId);

  /**
   * Get user profile from a specific channel by contact ID.
   *
   * <p>Only supported on {@link ConversationChannel#MESSENGER MESSENGER}, {@link
   * ConversationChannel#INSTAGRAM INSTAGRAM} and {@link ConversationChannel#LINE LINE} channels.
   *
   * <p>Note that, in order to retrieve a WhatsApp display name, you can use the Get a Contact or
   * List Contacts operations, which will populate the display_name field of each returned contact
   * with the WhatsApp display name (if the name is already stored on the server and the
   * display_name field has not been overwritten by the user).
   *
   * @param parameters The ID of the contact to be used to check profile information
   * @return The profile name
   * @since 1.3
   */
  String getChannelProfileByContactId(ContactGetChannelProfileByContactIdRequest parameters);

  /**
   * Get user profile from a specific channel by channel identity.
   *
   * <p>Only supported on {@link ConversationChannel#MESSENGER MESSENGER}, {@link
   * ConversationChannel#INSTAGRAM INSTAGRAM} and {@link ConversationChannel#LINE LINE} channels.
   *
   * <p>Note that, in order to retrieve a WhatsApp display name, you can use the Get a Contact or
   * List Contacts operations, which will populate the display_name field of each returned contact
   * with the WhatsApp display name (if the name is already stored on the server and the
   * display_name field has not been overwritten by the user).
   *
   * @param parameters The identity as specified by the channel to be used to check profile
   *     information
   * @return The profile name
   * @since 1.3
   */
  String getChannelProfileByChannelIdentity(
      ContactGetChannelProfileByChannelIdentityRequest parameters);

  /**
   * Lists Contact Identity Conflicts Lists contact identity conflicts across supported SIM-based
   * channels (SMS, MMS, RCS). Use this to identify contact records sharing the same identity (e.g.,
   * phone number), which must be resolved before enabling the Unified Contact ID feature.
   *
   * @param parameters Filtering parameters
   * @return ListIdentityConflictsResponse
   * @since 2.0
   */
  IdentityConflictsListResponse listIdentityConflicts(IdentityConflictsListRequest parameters);
}
