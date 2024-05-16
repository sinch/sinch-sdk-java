package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.conversation.api.v1.ContactApi;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.Contact;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactGetChannelProfileByChannelIdentityRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactGetChannelProfileByContactIdRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactListRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.GetChannelProfileRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.MergeContactRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.ContactListResponse;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.ListContactsResponse;
import com.sinch.sdk.models.ConversationContext;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ContactService implements com.sinch.sdk.domains.conversation.ContactService {

  private final String uriUUID;
  private final ContactApi api;
  private final Collection<ConversationChannel> supportedChannelForGetProfile =
      Arrays.asList(
          ConversationChannel.INSTAGRAM,
          ConversationChannel.MESSENGER,
          ConversationChannel.VIBER,
          ConversationChannel.LINE);

  public ContactService(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api = new ContactApi(httpClient, context.getServer(), authManagers, new HttpMapper());
  }

  protected ContactApi getApi() {
    return this.api;
  }

  public ContactListResponse list(ContactListRequest client) throws ApiException {

    // guard against null value to start with a default request parameters set
    if (null == client) {
      client = ContactListRequest.builder(null).build();
    }

    String externalId = client.getExternalId().orElse(null);
    ConversationChannel channel = client.getChannel().orElse(null);
    String identity = client.getIdentity().orElse(null);

    Integer pageSize = client.getPageSize().orElse(null);
    String pageToken = client.getPageToken().orElse(null);

    ListContactsResponse response =
        getApi().contactListContacts(uriUUID, pageSize, pageToken, externalId, channel, identity);

    String nextPageToken = response.getNextPageToken();
    List<Contact> list = response.getContacts();
    Collection<Contact> pageContent = null != list ? list : Collections.emptyList();
    Pair<Collection<Contact>, TokenPageNavigator> content =
        new Pair<>(pageContent, TokenPageNavigator.valueOf(nextPageToken));
    return new ContactListResponse(this, new Page<>(client, content.getLeft(), content.getRight()));
  }

  public Contact get(String contactId) {
    return getApi().contactGetContact(uriUUID, contactId);
  }

  public Contact create(ContactCreateRequest client) {
    return getApi().contactCreateContact(uriUUID, client);
  }

  public void delete(String contactId) {

    getApi().contactDeleteContact(uriUUID, contactId);
  }

  public Contact update(Contact client) {

    return getApi().contactUpdateContact(uriUUID, client.getId(), client, null);
  }

  public Contact mergeContact(String destinationId, String sourceId) {
    return getApi()
        .contactMergeContact(
            uriUUID, destinationId, MergeContactRequest.builder().setSourceId(sourceId).build());
  }

  public String getChannelProfileByContactId(ContactGetChannelProfileByContactIdRequest client) {

    checkGetChannelProfileChannelType(client);
    return getApi().contactGetChannelProfile(uriUUID, client).getProfileName();
  }

  public String getChannelProfileByChannelIdentity(
      ContactGetChannelProfileByChannelIdentityRequest client) {

    checkGetChannelProfileChannelType(client);
    return getApi().contactGetChannelProfile(uriUUID, client).getProfileName();
  }

  private void checkGetChannelProfileChannelType(GetChannelProfileRequest client) {

    if (null != client && !supportedChannelForGetProfile.contains(client.getChannel())) {
      throw new IllegalArgumentException(
          String.format(
              "Invalid channel value '%s'. Channel has to be in list '%s'",
              client.getChannel(), supportedChannelForGetProfile));
    }
  }
}
