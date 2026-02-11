package com.sinch.sdk.domains.conversation.models.v1.contacts.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Objects;

public class ContactsListQueryParametersImpl implements ContactsListQueryParameters {

  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;
  private final OptionalValue<String> externalId;
  private final OptionalValue<ConversationChannel> channel;
  private final OptionalValue<String> identity;

  private ContactsListQueryParametersImpl(
      OptionalValue<Integer> pageSize,
      OptionalValue<String> pageToken,
      OptionalValue<String> externalId,
      OptionalValue<ConversationChannel> channel,
      OptionalValue<String> identity) {
    this.pageSize = pageSize;
    this.pageToken = pageToken;
    this.externalId = externalId;
    this.channel = channel;
    this.identity = identity;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<String> getPageToken() {
    return pageToken;
  }

  public OptionalValue<String> getExternalId() {
    return externalId;
  }

  public OptionalValue<ConversationChannel> getChannel() {
    return channel;
  }

  public OptionalValue<String> getIdentity() {
    return identity;
  }

  /** Return true if this ContactListContactsQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactsListQueryParametersImpl contactListContactsQueryParameters =
        (ContactsListQueryParametersImpl) o;
    return Objects.equals(this.pageSize, contactListContactsQueryParameters.pageSize)
        && Objects.equals(this.pageToken, contactListContactsQueryParameters.pageToken)
        && Objects.equals(this.externalId, contactListContactsQueryParameters.externalId)
        && Objects.equals(this.channel, contactListContactsQueryParameters.channel)
        && Objects.equals(this.identity, contactListContactsQueryParameters.identity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageSize, pageToken, externalId, channel, identity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactsListQueryParametersImpl {\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageToken: ").append(toIndentedString(pageToken)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  static class Builder implements ContactsListQueryParameters.Builder {
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();
    OptionalValue<String> externalId = OptionalValue.empty();
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<String> identity = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ContactsListQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ContactsListQueryParametersImpl parameters = (ContactsListQueryParametersImpl) _parameters;
      this.pageSize = parameters.getPageSize();
      this.pageToken = parameters.getPageToken();
      this.externalId = parameters.getExternalId();
      this.channel = parameters.getChannel();
      this.identity = parameters.getIdentity();
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public Builder setPageToken(String pageToken) {
      this.pageToken = OptionalValue.of(pageToken);
      return this;
    }

    public Builder setExternalId(String externalId) {
      this.externalId = OptionalValue.of(externalId);
      return this;
    }

    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    public Builder setIdentity(String identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    public ContactsListQueryParameters build() {
      return new ContactsListQueryParametersImpl(
          pageSize, pageToken, externalId, channel, identity);
    }
  }
}
