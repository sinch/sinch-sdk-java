package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.conversation.adapters.api.v1.ContactApi;
import com.sinch.sdk.domains.conversation.adapters.converters.ChannelTypeDtoConverter;
import com.sinch.sdk.domains.conversation.adapters.converters.ContactDtoConverter;
import com.sinch.sdk.domains.conversation.adapters.models.ContactImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.ContactCreateRequestParametersImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.ContactListRequestParametersImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.GetChannelProfileByChannelRequestParametersImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.GetChannelProfileByContactRequestParametersImpl;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.Contact;
import com.sinch.sdk.domains.conversation.models.dto.v1.ConversationChannelDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ListContactsResponseDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.MergeContactRequestDto;
import com.sinch.sdk.domains.conversation.models.requests.BaseGetChannelProfileRequestParameters;
import com.sinch.sdk.domains.conversation.models.requests.ContactCreateRequestParameters;
import com.sinch.sdk.domains.conversation.models.requests.ContactListRequestParameters;
import com.sinch.sdk.domains.conversation.models.requests.GetChannelProfileByChannelRequestParameters;
import com.sinch.sdk.domains.conversation.models.requests.GetChannelProfileByContactRequestParameters;
import com.sinch.sdk.domains.conversation.models.responses.ContactListResponse;
import com.sinch.sdk.models.ConversationContext;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class ContactService implements com.sinch.sdk.domains.conversation.ContactService {

  private final String uriPathID;
  private final ContactApi api;

  private final Collection<ChannelType> supportedChannelForGetProfile =
      Arrays.asList(
          ChannelType.INSTAGRAM, ChannelType.MESSENGER, ChannelType.VIBER, ChannelType.LINE);

  public ContactService(
      String uriPathID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriPathID = uriPathID;
    this.api = new ContactApi(httpClient, context.getServer(), authManagers, new HttpMapper());
  }

  protected ContactApi getApi() {
    return this.api;
  }

  public ContactListResponse list(ContactListRequestParameters iclient) throws ApiException {
    ContactListRequestParametersImpl client = (ContactListRequestParametersImpl) iclient;

    if (null == client) {
      client = ContactListRequestParametersImpl.builder(null).build();
    }

    String externalId = client.getExternalId().orElse(null);
    ConversationChannelDto channel = ChannelTypeDtoConverter.convert(client.getChannel());
    String identity = client.getIdentity().orElse(null);

    Integer pageSize = client.getPageSize().orElse(null);
    String pageToken = client.getPageToken().orElse(null);

    ListContactsResponseDto response =
        getApi().contactListContacts(uriPathID, pageSize, pageToken, externalId, channel, identity);

    Pair<Collection<Contact>, TokenPageNavigator> content = ContactDtoConverter.convert(response);

    return new ContactListResponse(this, new Page<>(client, content.getLeft(), content.getRight()));
  }

  public Contact get(String contactId) {
    return ContactDtoConverter.convert(getApi().contactGetContact(uriPathID, contactId));
  }

  public Contact create(ContactCreateRequestParameters iclient) {
    ContactCreateRequestParametersImpl client = (ContactCreateRequestParametersImpl) iclient;

    return ContactDtoConverter.convert(
        getApi().contactCreateContact(uriPathID, ContactDtoConverter.convertForCreate(client)));
  }

  public void delete(String contactId) {

    getApi().contactDeleteContact(uriPathID, contactId);
  }

  public Contact update(Contact iclient) {
    ContactImpl client = (ContactImpl) iclient;

    return ContactDtoConverter.convert(
        getApi()
            .contactUpdateContact(
                uriPathID, client.getId(), ContactDtoConverter.convert(client), null));
  }

  public Contact mergeContact(String destinationId, String sourceId) {
    return ContactDtoConverter.convert(
        getApi()
            .contactMergeContact(
                uriPathID, destinationId, new MergeContactRequestDto().sourceId(sourceId)));
  }

  public String getChannelProfileByContactId(GetChannelProfileByContactRequestParameters iclient) {
    GetChannelProfileByContactRequestParametersImpl client =
        (GetChannelProfileByContactRequestParametersImpl) iclient;

    checkGetChannelProfileChannelType(client);
    return ContactDtoConverter.convert(
        getApi().contactGetChannelProfile(uriPathID, ContactDtoConverter.convert(client)));
  }

  public String getChannelProfileByChannelIdentity(
      GetChannelProfileByChannelRequestParameters iclient) {
    GetChannelProfileByChannelRequestParametersImpl client =
        (GetChannelProfileByChannelRequestParametersImpl) iclient;

    checkGetChannelProfileChannelType(client);
    return ContactDtoConverter.convert(
        getApi().contactGetChannelProfile(uriPathID, ContactDtoConverter.convert(client)));
  }

  private void checkGetChannelProfileChannelType(BaseGetChannelProfileRequestParameters client) {

    if (null != client && !supportedChannelForGetProfile.contains(client.getChannel())) {
      throw new IllegalArgumentException(
          String.format(
              "Invalid channel value '%s'. Channel has to be in list '%s'",
              client.getChannel(), supportedChannelForGetProfile));
    }
  }
}
