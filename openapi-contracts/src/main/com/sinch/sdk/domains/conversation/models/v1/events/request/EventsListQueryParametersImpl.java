package com.sinch.sdk.domains.conversation.models.v1.events.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class EventsListQueryParametersImpl implements EventsListQueryParameters {

  private final OptionalValue<String> conversationId;
  private final OptionalValue<String> contactId;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;

  private EventsListQueryParametersImpl(
      OptionalValue<String> conversationId,
      OptionalValue<String> contactId,
      OptionalValue<Integer> pageSize,
      OptionalValue<String> pageToken) {
    this.conversationId = conversationId;
    this.contactId = contactId;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
  }

  public OptionalValue<String> getConversationId() {
    return conversationId;
  }

  public OptionalValue<String> getContactId() {
    return contactId;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<String> getPageToken() {
    return pageToken;
  }

  /** Return true if this EventsListEventsQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventsListQueryParametersImpl eventsListEventsQueryParameters =
        (EventsListQueryParametersImpl) o;
    return Objects.equals(this.conversationId, eventsListEventsQueryParameters.conversationId)
        && Objects.equals(this.contactId, eventsListEventsQueryParameters.contactId)
        && Objects.equals(this.pageSize, eventsListEventsQueryParameters.pageSize)
        && Objects.equals(this.pageToken, eventsListEventsQueryParameters.pageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conversationId, contactId, pageSize, pageToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventsListQueryParametersImpl {\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageToken: ").append(toIndentedString(pageToken)).append("\n");
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

  static class Builder implements EventsListQueryParameters.Builder {
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();

    protected Builder() {}

    protected Builder(EventsListQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      EventsListQueryParametersImpl parameters = (EventsListQueryParametersImpl) _parameters;
      this.conversationId = parameters.getConversationId();
      this.contactId = parameters.getContactId();
      this.pageSize = parameters.getPageSize();
      this.pageToken = parameters.getPageToken();
    }

    public Builder setConversationId(String conversationId) {
      this.conversationId = OptionalValue.of(conversationId);
      return this;
    }

    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public Builder setPageToken(String pageToken) {
      this.pageToken = OptionalValue.of(pageToken);
      return this;
    }

    public EventsListQueryParameters build() {
      return new EventsListQueryParametersImpl(conversationId, contactId, pageSize, pageToken);
    }
  }
}
