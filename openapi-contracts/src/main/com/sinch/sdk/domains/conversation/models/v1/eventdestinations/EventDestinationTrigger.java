package com.sinch.sdk.domains.conversation.models.v1.eventdestinations;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Each webhook can subscribe to one or more of the following triggers */
public class EventDestinationTrigger extends EnumDynamic<String, EventDestinationTrigger> {

  /** Using this value will cause errors. */
  public static final EventDestinationTrigger UNSPECIFIED_TRIGGER =
      new EventDestinationTrigger("UNSPECIFIED_TRIGGER");

  /** Subscribe to delivery receipts for a message sent. */
  public static final EventDestinationTrigger MESSAGE_DELIVERY =
      new EventDestinationTrigger("MESSAGE_DELIVERY");

  /** Subscribe to delivery receipts for a event sent. */
  public static final EventDestinationTrigger EVENT_DELIVERY =
      new EventDestinationTrigger("EVENT_DELIVERY");

  /** Subscribe to inbound messages from end users on the underlying channels. */
  public static final EventDestinationTrigger MESSAGE_INBOUND =
      new EventDestinationTrigger("MESSAGE_INBOUND");

  /** Subscribe to inbound events from end users on the underlying channels. */
  public static final EventDestinationTrigger EVENT_INBOUND =
      new EventDestinationTrigger("EVENT_INBOUND");

  /** Subscribe to an event that is triggered when a new conversation has been started. */
  public static final EventDestinationTrigger CONVERSATION_START =
      new EventDestinationTrigger("CONVERSATION_START");

  /** Subscribe to an event that is triggered when a active conversation has been stopped. */
  public static final EventDestinationTrigger CONVERSATION_STOP =
      new EventDestinationTrigger("CONVERSATION_STOP");

  /** Subscribe to an event that is triggered when a new contact has been created. */
  public static final EventDestinationTrigger CONTACT_CREATE =
      new EventDestinationTrigger("CONTACT_CREATE");

  /** Subscribe to an event that is triggered when a contact has been deleted. */
  public static final EventDestinationTrigger CONTACT_DELETE =
      new EventDestinationTrigger("CONTACT_DELETE");

  /** Subscribe to an event that is triggered when a two contacts are merged. */
  public static final EventDestinationTrigger CONTACT_MERGE =
      new EventDestinationTrigger("CONTACT_MERGE");

  /** Subscribe to an event that is triggered when a contact is updated. */
  public static final EventDestinationTrigger CONTACT_UPDATE =
      new EventDestinationTrigger("CONTACT_UPDATE");

  /** Subscribe to callbacks that are not natively supported by the Conversation API. */
  public static final EventDestinationTrigger UNSUPPORTED =
      new EventDestinationTrigger("UNSUPPORTED");

  /** Subscribe to opt_ins. */
  public static final EventDestinationTrigger OPT_IN = new EventDestinationTrigger("OPT_IN");

  /** Subscribe to opt_outs. */
  public static final EventDestinationTrigger OPT_OUT = new EventDestinationTrigger("OPT_OUT");

  /** Subscribe to see get capability results. */
  public static final EventDestinationTrigger CAPABILITY =
      new EventDestinationTrigger("CAPABILITY");

  /** Subscribe to get an event when a conversation is deleted. */
  public static final EventDestinationTrigger CONVERSATION_DELETE =
      new EventDestinationTrigger("CONVERSATION_DELETE");

  /**
   * Subscribe to get an event when contact identity duplications are found during message or event
   * processing.
   */
  public static final EventDestinationTrigger CONTACT_IDENTITIES_DUPLICATION =
      new EventDestinationTrigger("CONTACT_IDENTITIES_DUPLICATION");

  /** Subscribe to direct channel event. */
  public static final EventDestinationTrigger CHANNEL_EVENT =
      new EventDestinationTrigger("CHANNEL_EVENT");

  /**
   * Subscribe to <a href="https://developers.sinch.com/docs/smart-conversations">Smart conversation
   * analysis</a>.
   */
  public static final EventDestinationTrigger SMART_CONVERSATION =
      new EventDestinationTrigger("SMART_CONVERSATION");

  /**
   * Subscribe to <a href="https://developers.sinch.com/docs/smart-conversations">analysis</a> for
   * messages from end-users.
   */
  public static final EventDestinationTrigger MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION =
      new EventDestinationTrigger("MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION");

  /** Subscribe to Record Notifications. */
  public static final EventDestinationTrigger RECORD_NOTIFICATION =
      new EventDestinationTrigger("RECORD_NOTIFICATION");

  /** Subscribe to message submit Notifications. */
  public static final EventDestinationTrigger MESSAGE_SUBMIT =
      new EventDestinationTrigger("MESSAGE_SUBMIT");

  private static final EnumSupportDynamic<String, EventDestinationTrigger> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          EventDestinationTrigger.class,
          EventDestinationTrigger::new,
          Arrays.asList(
              UNSPECIFIED_TRIGGER,
              MESSAGE_DELIVERY,
              EVENT_DELIVERY,
              MESSAGE_INBOUND,
              EVENT_INBOUND,
              CONVERSATION_START,
              CONVERSATION_STOP,
              CONTACT_CREATE,
              CONTACT_DELETE,
              CONTACT_MERGE,
              CONTACT_UPDATE,
              UNSUPPORTED,
              OPT_IN,
              OPT_OUT,
              CAPABILITY,
              CONVERSATION_DELETE,
              CONTACT_IDENTITIES_DUPLICATION,
              CHANNEL_EVENT,
              SMART_CONVERSATION,
              MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION,
              RECORD_NOTIFICATION,
              MESSAGE_SUBMIT));

  private EventDestinationTrigger(String value) {
    super(value);
  }

  public static Stream<EventDestinationTrigger> values() {
    return ENUM_SUPPORT.values();
  }

  public static EventDestinationTrigger from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(EventDestinationTrigger e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
