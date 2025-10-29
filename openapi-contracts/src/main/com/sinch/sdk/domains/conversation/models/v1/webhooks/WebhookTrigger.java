package com.sinch.sdk.domains.conversation.models.v1.webhooks;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Each webhook can subscribe to one or more of the following triggers */
public class WebhookTrigger extends EnumDynamic<String, WebhookTrigger> {

  /** Using this value will cause errors. */
  public static final WebhookTrigger UNSPECIFIED_TRIGGER =
      new WebhookTrigger("UNSPECIFIED_TRIGGER");

  /** Subscribe to delivery receipts for a message sent. */
  public static final WebhookTrigger MESSAGE_DELIVERY = new WebhookTrigger("MESSAGE_DELIVERY");

  /** Subscribe to delivery receipts for a event sent. */
  public static final WebhookTrigger EVENT_DELIVERY = new WebhookTrigger("EVENT_DELIVERY");

  /** Subscribe to inbound messages from end users on the underlying channels. */
  public static final WebhookTrigger MESSAGE_INBOUND = new WebhookTrigger("MESSAGE_INBOUND");

  /** Subscribe to inbound events from end users on the underlying channels. */
  public static final WebhookTrigger EVENT_INBOUND = new WebhookTrigger("EVENT_INBOUND");

  /** Subscribe to an event that is triggered when a new conversation has been started. */
  public static final WebhookTrigger CONVERSATION_START = new WebhookTrigger("CONVERSATION_START");

  /** Subscribe to an event that is triggered when a active conversation has been stopped. */
  public static final WebhookTrigger CONVERSATION_STOP = new WebhookTrigger("CONVERSATION_STOP");

  /** Subscribe to an event that is triggered when a new contact has been created. */
  public static final WebhookTrigger CONTACT_CREATE = new WebhookTrigger("CONTACT_CREATE");

  /** Subscribe to an event that is triggered when a contact has been deleted. */
  public static final WebhookTrigger CONTACT_DELETE = new WebhookTrigger("CONTACT_DELETE");

  /** Subscribe to an event that is triggered when a two contacts are merged. */
  public static final WebhookTrigger CONTACT_MERGE = new WebhookTrigger("CONTACT_MERGE");

  /** Subscribe to an event that is triggered when a contact is updated. */
  public static final WebhookTrigger CONTACT_UPDATE = new WebhookTrigger("CONTACT_UPDATE");

  /** Subscribe to callbacks that are not natively supported by the Conversation API. */
  public static final WebhookTrigger UNSUPPORTED = new WebhookTrigger("UNSUPPORTED");

  /** Subscribe to opt_ins. */
  public static final WebhookTrigger OPT_IN = new WebhookTrigger("OPT_IN");

  /** Subscribe to opt_outs. */
  public static final WebhookTrigger OPT_OUT = new WebhookTrigger("OPT_OUT");

  /** Subscribe to see get capability results. */
  public static final WebhookTrigger CAPABILITY = new WebhookTrigger("CAPABILITY");

  /** Subscribe to get an event when a conversation is deleted. */
  public static final WebhookTrigger CONVERSATION_DELETE =
      new WebhookTrigger("CONVERSATION_DELETE");

  /**
   * Subscribe to get an event when contact identity duplications are found during message or event
   * processing.
   */
  public static final WebhookTrigger CONTACT_IDENTITIES_DUPLICATION =
      new WebhookTrigger("CONTACT_IDENTITIES_DUPLICATION");

  /** Subscribe to direct channel event. */
  public static final WebhookTrigger CHANNEL_EVENT = new WebhookTrigger("CHANNEL_EVENT");

  /**
   * Subscribe to <a href="https://developers.sinch.com/docs/smart-conversations">Smart conversation
   * analysis</a>.
   */
  public static final WebhookTrigger SMART_CONVERSATION = new WebhookTrigger("SMART_CONVERSATION");

  /**
   * Subscribe to <a href="https://developers.sinch.com/docs/smart-conversations">analysis</a> for
   * messages from end-users.
   */
  public static final WebhookTrigger MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION =
      new WebhookTrigger("MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION");

  /** Subscribe to Record Notifications. */
  public static final WebhookTrigger RECORD_NOTIFICATION =
      new WebhookTrigger("RECORD_NOTIFICATION");

  /** Subscribe to message submit Notifications. */
  public static final WebhookTrigger MESSAGE_SUBMIT = new WebhookTrigger("MESSAGE_SUBMIT");

  private static final EnumSupportDynamic<String, WebhookTrigger> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          WebhookTrigger.class,
          WebhookTrigger::new,
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

  private WebhookTrigger(String value) {
    super(value);
  }

  public static Stream<WebhookTrigger> values() {
    return ENUM_SUPPORT.values();
  }

  public static WebhookTrigger from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(WebhookTrigger e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
