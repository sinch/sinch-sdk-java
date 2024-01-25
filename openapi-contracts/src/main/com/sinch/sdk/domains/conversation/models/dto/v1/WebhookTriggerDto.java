/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * - &#x60;UNSPECIFIED_TRIGGER&#x60;: Using this value will cause errors. -
 * &#x60;MESSAGE_DELIVERY&#x60;: Subscribe to delivery receipts for a message sent. -
 * &#x60;MESSAGE_SUBMIT&#x60;: Subscribe to message submission notifications. -
 * &#x60;EVENT_DELIVERY&#x60;: Subscribe to delivery receipts for a event sent. -
 * &#x60;MESSAGE_INBOUND&#x60;: Subscribe to inbound messages from end users on the underlying
 * channels. - &#x60;SMART_CONVERSATION&#x60;: These triggers allows you to subscribe to payloads
 * that provide machine learning analyses of inbound messages from end users on the underlying
 * channels - &#x60;MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION&#x60;: These triggers allows you to
 * subscribe to payloads that deliver redacted versions of inbound messages -
 * &#x60;EVENT_INBOUND&#x60;: Subscribe to inbound events from end users on the underlying channels.
 * - &#x60;CONVERSATION_START&#x60;: Subscribe to an event that is triggered when a new conversation
 * has been started. - &#x60;CONVERSATION_STOP&#x60;: Subscribe to an event that is triggered when a
 * active conversation has been stopped. - &#x60;CONTACT_CREATE&#x60;: Subscribe to an event that is
 * triggered when a new contact has been created. - &#x60;CONTACT_DELETE&#x60;: Subscribe to an
 * event that is triggered when a contact has been deleted. - &#x60;CONTACT_MERGE&#x60;: Subscribe
 * to an event that is triggered when a two contacts are merged. - &#x60;CONTACT_UPDATE&#x60;:
 * Subscribe to an event that is triggered when a contact is updated. - &#x60;UNSUPPORTED&#x60;:
 * Subscribe to callbacks that are not natively supported by the Conversation API. -
 * &#x60;OPT_IN&#x60;: Subscribe to opt_ins. - &#x60;OPT_OUT&#x60;: Subscribe to opt_outs. -
 * &#x60;CAPABILITY&#x60;: Subscribe to see get capability results. - &#x60;CHANNEL_EVENT&#x60;:
 * Subscribe to channel event notifications. - &#x60;CONVERSATION_DELETE&#x60;: Subscribe to get an
 * event when a conversation is deleted. - &#x60;CONTACT_IDENTITIES_DUPLICATION&#x60;: Subscribe to
 * get an event when contact identity duplications are found during message or event processing. -
 * &#x60;SMART_CONVERSATIONS&#x60;: Subscribe to smart conversations callback
 */
public enum WebhookTriggerDto {
  UNSPECIFIED_TRIGGER("UNSPECIFIED_TRIGGER"),

  MESSAGE_DELIVERY("MESSAGE_DELIVERY"),

  MESSAGE_SUBMIT("MESSAGE_SUBMIT"),

  EVENT_DELIVERY("EVENT_DELIVERY"),

  MESSAGE_INBOUND("MESSAGE_INBOUND"),

  SMART_CONVERSATION("SMART_CONVERSATION"),

  MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION("MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION"),

  EVENT_INBOUND("EVENT_INBOUND"),

  CONVERSATION_START("CONVERSATION_START"),

  CONVERSATION_STOP("CONVERSATION_STOP"),

  CONTACT_CREATE("CONTACT_CREATE"),

  CONTACT_DELETE("CONTACT_DELETE"),

  CONTACT_MERGE("CONTACT_MERGE"),

  CONTACT_UPDATE("CONTACT_UPDATE"),

  UNSUPPORTED("UNSUPPORTED"),

  OPT_IN("OPT_IN"),

  OPT_OUT("OPT_OUT"),

  CAPABILITY("CAPABILITY"),

  CHANNEL_EVENT("CHANNEL_EVENT"),

  CONVERSATION_DELETE("CONVERSATION_DELETE"),

  CONTACT_IDENTITIES_DUPLICATION("CONTACT_IDENTITIES_DUPLICATION"),

  SMART_CONVERSATIONS("SMART_CONVERSATIONS"),

  UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

  private String value;

  WebhookTriggerDto(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static WebhookTriggerDto fromValue(String value) {
    for (WebhookTriggerDto b : WebhookTriggerDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}
