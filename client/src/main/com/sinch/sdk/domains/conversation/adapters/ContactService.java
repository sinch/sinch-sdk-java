package com.sinch.sdk.domains.conversation.adapters;

public class ContactService implements com.sinch.sdk.domains.conversation.ContactService {
  /*
  private final String uriUUID;
  private final ContactApi api;

  private final Collection<ChannelType> supportedChannelForGetProfile =
      Arrays.asList(
          ChannelType.INSTAGRAM, ChannelType.MESSENGER, ChannelType.VIBER, ChannelType.LINE);

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

  public ContactListResponse list(ContactListRequestParameters iclient) throws ApiException {
    ContactListRequestParametersImpl client = (ContactListRequestParametersImpl) iclient;

    if (null == client) {
      client = ContactListRequestParametersImpl.builder(null).build();
    }

    String externalId = client.getExternalId().orElse(null);
    ConversationChannel channel = ChannelTypeDtoConverter.convert(client.getChannel());
    String identity = client.getIdentity().orElse(null);

    Integer pageSize = client.getPageSize().orElse(null);
    String pageToken = client.getPageToken().orElse(null);

    ListContactsResponse response =
        getApi().contactListContacts(uriUUID, pageSize, pageToken, externalId, channel, identity);

    Pair<Collection<Contact>, TokenPageNavigator> content = ContactDtoConverter.convert(response);

    return new ContactListResponse(this, new Page<>(client, content.getLeft(), content.getRight()));
  }

  public Contact get(String contactId) {
    return ContactDtoConverter.convert(getApi().contactGetContact(uriUUID, contactId));
  }

  public Contact create(ContactCreateRequestParameters iclient) {
    ContactCreateRequestParametersImpl client = (ContactCreateRequestParametersImpl) iclient;

    return ContactDtoConverter.convert(
        getApi().contactCreateContact(uriUUID, ContactDtoConverter.convertForCreate(client)));
  }

  public void delete(String contactId) {

    getApi().contactDeleteContact(uriUUID, contactId);
  }

  public Contact update(Contact iclient) {
    ContactImpl client = (ContactImpl) iclient;

    return ContactDtoConverter.convert(
        getApi()
            .contactUpdateContact(
                uriUUID, client.getId(), ContactDtoConverter.convert(client), null));
  }

  public Contact mergeContact(String destinationId, String sourceId) {
    return ContactDtoConverter.convert(
        getApi()
            .contactMergeContact(
                uriUUID, destinationId, MergeContactRequest.builder().setSourceId(sourceId).build()));
  }

  public String getChannelProfileByContactId(GetChannelProfileByContactRequestParameters iclient) {
    GetChannelProfileByContactRequestParametersImpl client =
        (GetChannelProfileByContactRequestParametersImpl) iclient;

    checkGetChannelProfileChannelType(client);
    return ContactDtoConverter.convert(
        getApi().contactGetChannelProfile(uriUUID, ContactDtoConverter.convert(client)));
  }

  public String getChannelProfileByChannelIdentity(
      GetChannelProfileByChannelRequestParameters iclient) {
    GetChannelProfileByChannelRequestParametersImpl client =
        (GetChannelProfileByChannelRequestParametersImpl) iclient;

    checkGetChannelProfileChannelType(client);
    return ContactDtoConverter.convert(
        getApi().contactGetChannelProfile(uriUUID, ContactDtoConverter.convert(client)));
  }

  private void checkGetChannelProfileChannelType(BaseGetChannelProfileRequestParameters client) {

    if (null != client && !supportedChannelForGetProfile.contains(client.getChannel())) {
      throw new IllegalArgumentException(
          String.format(
              "Invalid channel value '%s'. Channel has to be in list '%s'",
              client.getChannel(), supportedChannelForGetProfile));
    }
  }*/
}
