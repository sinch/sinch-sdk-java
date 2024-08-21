package com.sinch.sdk.domains.conversation.api.v1;

import com.sinch.sdk.domains.conversation.models.v1.events.ConversationEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.request.EventsListRequest;
import com.sinch.sdk.domains.conversation.models.v1.events.request.SendEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.events.response.EventsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.response.SendEventResponse;

/**
 * Service for working with the Events
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Events">online
 *     documentation</a>
 * @since _NEXT_VERSION_
 */
public interface EventsService {

  /**
   * Send an event
   *
   * <p>Sends an event to the referenced contact from the referenced app.
   *
   * <p>Note that this operation enqueues the event in a queue so a successful response only
   * indicates that the event has been queued
   *
   * @param request Send event request parameters
   * @return Response related to event enqueued
   * @since _NEXT_VERSION_
   */
  SendEventResponse send(SendEventRequest request);

  /**
   * Get event from ID
   *
   * @param eventId The unique ID of the event
   * @return Conversation event
   * @since _NEXT_VERSION_
   */
  ConversationEvent get(String eventId);

  /**
   * Delete a specific event by its ID
   *
   * @param eventId The unique ID of the event
   * @since _NEXT_VERSION_
   */
  void delete(String eventId);

  /**
   * List all events in a project
   *
   * @param request Request parameters
   * @return List of events
   * @since _NEXT_VERSION_
   */
  EventsListResponse list(EventsListRequest request);
}
