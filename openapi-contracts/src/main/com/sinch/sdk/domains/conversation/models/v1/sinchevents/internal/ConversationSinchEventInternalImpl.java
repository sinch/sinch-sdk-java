package com.sinch.sdk.domains.conversation.models.v1.sinchevents.internal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.models.AbstractOpenApiSchema;
import com.sinch.sdk.core.utils.databind.JSONNavigator;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.capability.CapabilityEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.channel.ChannelEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactCreateEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactDeleteEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactIdentitiesDuplicationEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactMergeEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactUpdateEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.conversation.ConversationDeleteEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.conversation.ConversationStartEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.conversation.ConversationStopEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.delivery.EventDeliveryReceiptEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.delivery.MessageDeliveryReceiptEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.inbound.InboundEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.message.MessageInboundEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.message.MessageSubmitEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.opting.OptInEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.opting.OptOutEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.record.RecordNotificationEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.smartconversations.MessageInboundSmartConversationRedactionEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.smartconversations.SmartConversationsEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.unsupported.UnsupportedCallbackEventImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using = ConversationSinchEventInternalImpl.ConversationSinchEventInternalImplDeserializer.class)
@JsonSerialize(
    using = ConversationSinchEventInternalImpl.ConversationSinchEventInternalImplSerializer.class)
public class ConversationSinchEventInternalImpl extends AbstractOpenApiSchema
    implements ConversationSinchEventInternal {
  private static final Logger log =
      Logger.getLogger(ConversationSinchEventInternalImpl.class.getName());

  public static final class ConversationSinchEventInternalImplSerializer
      extends StdSerializer<ConversationSinchEventInternalImpl> {
    private static final long serialVersionUID = 1L;

    public ConversationSinchEventInternalImplSerializer(
        Class<ConversationSinchEventInternalImpl> t) {
      super(t);
    }

    public ConversationSinchEventInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        ConversationSinchEventInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class ConversationSinchEventInternalImplDeserializer
      extends StdDeserializer<ConversationSinchEventInternalImpl> {

    private static final long serialVersionUID = 1L;

    public ConversationSinchEventInternalImplDeserializer() {
      this(ConversationSinchEventInternalImpl.class);
    }

    public ConversationSinchEventInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public ConversationSinchEventInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize CapabilityEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CapabilityEventImpl.class.equals(Integer.class)
            || CapabilityEventImpl.class.equals(Long.class)
            || CapabilityEventImpl.class.equals(Float.class)
            || CapabilityEventImpl.class.equals(Double.class)
            || CapabilityEventImpl.class.equals(Boolean.class)
            || CapabilityEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CapabilityEventImpl.class.equals(Integer.class)
                        || CapabilityEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CapabilityEventImpl.class.equals(Float.class)
                        || CapabilityEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CapabilityEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CapabilityEventImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CapabilityEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CapabilityEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'CapabilityEventImpl'", e);
      }

      // deserialize ChannelEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ChannelEventImpl.class.equals(Integer.class)
            || ChannelEventImpl.class.equals(Long.class)
            || ChannelEventImpl.class.equals(Float.class)
            || ChannelEventImpl.class.equals(Double.class)
            || ChannelEventImpl.class.equals(Boolean.class)
            || ChannelEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ChannelEventImpl.class.equals(Integer.class)
                        || ChannelEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ChannelEventImpl.class.equals(Float.class)
                        || ChannelEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ChannelEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ChannelEventImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ChannelEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ChannelEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ChannelEventImpl'", e);
      }

      // deserialize ContactCreateEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ContactCreateEventImpl.class.equals(Integer.class)
            || ContactCreateEventImpl.class.equals(Long.class)
            || ContactCreateEventImpl.class.equals(Float.class)
            || ContactCreateEventImpl.class.equals(Double.class)
            || ContactCreateEventImpl.class.equals(Boolean.class)
            || ContactCreateEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ContactCreateEventImpl.class.equals(Integer.class)
                        || ContactCreateEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ContactCreateEventImpl.class.equals(Float.class)
                        || ContactCreateEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ContactCreateEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ContactCreateEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ContactCreateEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ContactCreateEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ContactCreateEventImpl'", e);
      }

      // deserialize ContactDeleteEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ContactDeleteEventImpl.class.equals(Integer.class)
            || ContactDeleteEventImpl.class.equals(Long.class)
            || ContactDeleteEventImpl.class.equals(Float.class)
            || ContactDeleteEventImpl.class.equals(Double.class)
            || ContactDeleteEventImpl.class.equals(Boolean.class)
            || ContactDeleteEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ContactDeleteEventImpl.class.equals(Integer.class)
                        || ContactDeleteEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ContactDeleteEventImpl.class.equals(Float.class)
                        || ContactDeleteEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ContactDeleteEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ContactDeleteEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ContactDeleteEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ContactDeleteEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ContactDeleteEventImpl'", e);
      }

      // deserialize ContactIdentitiesDuplicationEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ContactIdentitiesDuplicationEventImpl.class.equals(Integer.class)
            || ContactIdentitiesDuplicationEventImpl.class.equals(Long.class)
            || ContactIdentitiesDuplicationEventImpl.class.equals(Float.class)
            || ContactIdentitiesDuplicationEventImpl.class.equals(Double.class)
            || ContactIdentitiesDuplicationEventImpl.class.equals(Boolean.class)
            || ContactIdentitiesDuplicationEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ContactIdentitiesDuplicationEventImpl.class.equals(Integer.class)
                        || ContactIdentitiesDuplicationEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ContactIdentitiesDuplicationEventImpl.class.equals(Float.class)
                        || ContactIdentitiesDuplicationEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ContactIdentitiesDuplicationEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ContactIdentitiesDuplicationEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ContactIdentitiesDuplicationEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ContactIdentitiesDuplicationEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'ContactIdentitiesDuplicationEventImpl'",
            e);
      }

      // deserialize ContactMergeEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ContactMergeEventImpl.class.equals(Integer.class)
            || ContactMergeEventImpl.class.equals(Long.class)
            || ContactMergeEventImpl.class.equals(Float.class)
            || ContactMergeEventImpl.class.equals(Double.class)
            || ContactMergeEventImpl.class.equals(Boolean.class)
            || ContactMergeEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ContactMergeEventImpl.class.equals(Integer.class)
                        || ContactMergeEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ContactMergeEventImpl.class.equals(Float.class)
                        || ContactMergeEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ContactMergeEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ContactMergeEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ContactMergeEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ContactMergeEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ContactMergeEventImpl'", e);
      }

      // deserialize ContactUpdateEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ContactUpdateEventImpl.class.equals(Integer.class)
            || ContactUpdateEventImpl.class.equals(Long.class)
            || ContactUpdateEventImpl.class.equals(Float.class)
            || ContactUpdateEventImpl.class.equals(Double.class)
            || ContactUpdateEventImpl.class.equals(Boolean.class)
            || ContactUpdateEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ContactUpdateEventImpl.class.equals(Integer.class)
                        || ContactUpdateEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ContactUpdateEventImpl.class.equals(Float.class)
                        || ContactUpdateEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ContactUpdateEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ContactUpdateEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ContactUpdateEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ContactUpdateEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ContactUpdateEventImpl'", e);
      }

      // deserialize ConversationDeleteEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ConversationDeleteEventImpl.class.equals(Integer.class)
            || ConversationDeleteEventImpl.class.equals(Long.class)
            || ConversationDeleteEventImpl.class.equals(Float.class)
            || ConversationDeleteEventImpl.class.equals(Double.class)
            || ConversationDeleteEventImpl.class.equals(Boolean.class)
            || ConversationDeleteEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ConversationDeleteEventImpl.class.equals(Integer.class)
                        || ConversationDeleteEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ConversationDeleteEventImpl.class.equals(Float.class)
                        || ConversationDeleteEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ConversationDeleteEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ConversationDeleteEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ConversationDeleteEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ConversationDeleteEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ConversationDeleteEventImpl'", e);
      }

      // deserialize ConversationStartEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ConversationStartEventImpl.class.equals(Integer.class)
            || ConversationStartEventImpl.class.equals(Long.class)
            || ConversationStartEventImpl.class.equals(Float.class)
            || ConversationStartEventImpl.class.equals(Double.class)
            || ConversationStartEventImpl.class.equals(Boolean.class)
            || ConversationStartEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ConversationStartEventImpl.class.equals(Integer.class)
                        || ConversationStartEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ConversationStartEventImpl.class.equals(Float.class)
                        || ConversationStartEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ConversationStartEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ConversationStartEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ConversationStartEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ConversationStartEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ConversationStartEventImpl'", e);
      }

      // deserialize ConversationStopEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ConversationStopEventImpl.class.equals(Integer.class)
            || ConversationStopEventImpl.class.equals(Long.class)
            || ConversationStopEventImpl.class.equals(Float.class)
            || ConversationStopEventImpl.class.equals(Double.class)
            || ConversationStopEventImpl.class.equals(Boolean.class)
            || ConversationStopEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ConversationStopEventImpl.class.equals(Integer.class)
                        || ConversationStopEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ConversationStopEventImpl.class.equals(Float.class)
                        || ConversationStopEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ConversationStopEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ConversationStopEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ConversationStopEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ConversationStopEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ConversationStopEventImpl'", e);
      }

      // deserialize EventDeliveryReceiptEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (EventDeliveryReceiptEventImpl.class.equals(Integer.class)
            || EventDeliveryReceiptEventImpl.class.equals(Long.class)
            || EventDeliveryReceiptEventImpl.class.equals(Float.class)
            || EventDeliveryReceiptEventImpl.class.equals(Double.class)
            || EventDeliveryReceiptEventImpl.class.equals(Boolean.class)
            || EventDeliveryReceiptEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((EventDeliveryReceiptEventImpl.class.equals(Integer.class)
                        || EventDeliveryReceiptEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((EventDeliveryReceiptEventImpl.class.equals(Float.class)
                        || EventDeliveryReceiptEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (EventDeliveryReceiptEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (EventDeliveryReceiptEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(EventDeliveryReceiptEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'EventDeliveryReceiptEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'EventDeliveryReceiptEventImpl'", e);
      }

      // deserialize InboundEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (InboundEventImpl.class.equals(Integer.class)
            || InboundEventImpl.class.equals(Long.class)
            || InboundEventImpl.class.equals(Float.class)
            || InboundEventImpl.class.equals(Double.class)
            || InboundEventImpl.class.equals(Boolean.class)
            || InboundEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((InboundEventImpl.class.equals(Integer.class)
                        || InboundEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((InboundEventImpl.class.equals(Float.class)
                        || InboundEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (InboundEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (InboundEventImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(InboundEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'InboundEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'InboundEventImpl'", e);
      }

      // deserialize MessageDeliveryReceiptEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MessageDeliveryReceiptEventImpl.class.equals(Integer.class)
            || MessageDeliveryReceiptEventImpl.class.equals(Long.class)
            || MessageDeliveryReceiptEventImpl.class.equals(Float.class)
            || MessageDeliveryReceiptEventImpl.class.equals(Double.class)
            || MessageDeliveryReceiptEventImpl.class.equals(Boolean.class)
            || MessageDeliveryReceiptEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MessageDeliveryReceiptEventImpl.class.equals(Integer.class)
                        || MessageDeliveryReceiptEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MessageDeliveryReceiptEventImpl.class.equals(Float.class)
                        || MessageDeliveryReceiptEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MessageDeliveryReceiptEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MessageDeliveryReceiptEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(MessageDeliveryReceiptEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MessageDeliveryReceiptEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'MessageDeliveryReceiptEventImpl'", e);
      }

      // deserialize MessageInboundEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MessageInboundEventImpl.class.equals(Integer.class)
            || MessageInboundEventImpl.class.equals(Long.class)
            || MessageInboundEventImpl.class.equals(Float.class)
            || MessageInboundEventImpl.class.equals(Double.class)
            || MessageInboundEventImpl.class.equals(Boolean.class)
            || MessageInboundEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MessageInboundEventImpl.class.equals(Integer.class)
                        || MessageInboundEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MessageInboundEventImpl.class.equals(Float.class)
                        || MessageInboundEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MessageInboundEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MessageInboundEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MessageInboundEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MessageInboundEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'MessageInboundEventImpl'", e);
      }

      // deserialize MessageInboundSmartConversationRedactionEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MessageInboundSmartConversationRedactionEventImpl.class.equals(Integer.class)
            || MessageInboundSmartConversationRedactionEventImpl.class.equals(Long.class)
            || MessageInboundSmartConversationRedactionEventImpl.class.equals(Float.class)
            || MessageInboundSmartConversationRedactionEventImpl.class.equals(Double.class)
            || MessageInboundSmartConversationRedactionEventImpl.class.equals(Boolean.class)
            || MessageInboundSmartConversationRedactionEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MessageInboundSmartConversationRedactionEventImpl.class.equals(Integer.class)
                        || MessageInboundSmartConversationRedactionEventImpl.class.equals(
                            Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MessageInboundSmartConversationRedactionEventImpl.class.equals(Float.class)
                        || MessageInboundSmartConversationRedactionEventImpl.class.equals(
                            Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MessageInboundSmartConversationRedactionEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MessageInboundSmartConversationRedactionEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(MessageInboundSmartConversationRedactionEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER,
              "Input data matches schema 'MessageInboundSmartConversationRedactionEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'MessageInboundSmartConversationRedactionEventImpl'",
            e);
      }

      // deserialize MessageSubmitEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MessageSubmitEventImpl.class.equals(Integer.class)
            || MessageSubmitEventImpl.class.equals(Long.class)
            || MessageSubmitEventImpl.class.equals(Float.class)
            || MessageSubmitEventImpl.class.equals(Double.class)
            || MessageSubmitEventImpl.class.equals(Boolean.class)
            || MessageSubmitEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MessageSubmitEventImpl.class.equals(Integer.class)
                        || MessageSubmitEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MessageSubmitEventImpl.class.equals(Float.class)
                        || MessageSubmitEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MessageSubmitEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MessageSubmitEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MessageSubmitEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MessageSubmitEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'MessageSubmitEventImpl'", e);
      }

      // deserialize OptInEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (OptInEventImpl.class.equals(Integer.class)
            || OptInEventImpl.class.equals(Long.class)
            || OptInEventImpl.class.equals(Float.class)
            || OptInEventImpl.class.equals(Double.class)
            || OptInEventImpl.class.equals(Boolean.class)
            || OptInEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((OptInEventImpl.class.equals(Integer.class)
                        || OptInEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((OptInEventImpl.class.equals(Float.class)
                        || OptInEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (OptInEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (OptInEventImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(OptInEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'OptInEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'OptInEventImpl'", e);
      }

      // deserialize OptOutEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (OptOutEventImpl.class.equals(Integer.class)
            || OptOutEventImpl.class.equals(Long.class)
            || OptOutEventImpl.class.equals(Float.class)
            || OptOutEventImpl.class.equals(Double.class)
            || OptOutEventImpl.class.equals(Boolean.class)
            || OptOutEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((OptOutEventImpl.class.equals(Integer.class)
                        || OptOutEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((OptOutEventImpl.class.equals(Float.class)
                        || OptOutEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (OptOutEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (OptOutEventImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(OptOutEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'OptOutEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'OptOutEventImpl'", e);
      }

      // deserialize RecordNotificationEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (RecordNotificationEventImpl.class.equals(Integer.class)
            || RecordNotificationEventImpl.class.equals(Long.class)
            || RecordNotificationEventImpl.class.equals(Float.class)
            || RecordNotificationEventImpl.class.equals(Double.class)
            || RecordNotificationEventImpl.class.equals(Boolean.class)
            || RecordNotificationEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((RecordNotificationEventImpl.class.equals(Integer.class)
                        || RecordNotificationEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((RecordNotificationEventImpl.class.equals(Float.class)
                        || RecordNotificationEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (RecordNotificationEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (RecordNotificationEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(RecordNotificationEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'RecordNotificationEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'RecordNotificationEventImpl'", e);
      }

      // deserialize SmartConversationsEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (SmartConversationsEventImpl.class.equals(Integer.class)
            || SmartConversationsEventImpl.class.equals(Long.class)
            || SmartConversationsEventImpl.class.equals(Float.class)
            || SmartConversationsEventImpl.class.equals(Double.class)
            || SmartConversationsEventImpl.class.equals(Boolean.class)
            || SmartConversationsEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((SmartConversationsEventImpl.class.equals(Integer.class)
                        || SmartConversationsEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((SmartConversationsEventImpl.class.equals(Float.class)
                        || SmartConversationsEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (SmartConversationsEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (SmartConversationsEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(SmartConversationsEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'SmartConversationsEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'SmartConversationsEventImpl'", e);
      }

      // deserialize UnsupportedCallbackEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (UnsupportedCallbackEventImpl.class.equals(Integer.class)
            || UnsupportedCallbackEventImpl.class.equals(Long.class)
            || UnsupportedCallbackEventImpl.class.equals(Float.class)
            || UnsupportedCallbackEventImpl.class.equals(Double.class)
            || UnsupportedCallbackEventImpl.class.equals(Boolean.class)
            || UnsupportedCallbackEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((UnsupportedCallbackEventImpl.class.equals(Integer.class)
                        || UnsupportedCallbackEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((UnsupportedCallbackEventImpl.class.equals(Float.class)
                        || UnsupportedCallbackEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (UnsupportedCallbackEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (UnsupportedCallbackEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(UnsupportedCallbackEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'UnsupportedCallbackEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'UnsupportedCallbackEventImpl'", e);
      }

      if (match == 1) {
        ConversationSinchEventInternalImpl ret = new ConversationSinchEventInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for ConversationSinchEventInternalImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public ConversationSinchEventInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "ConversationSinchEventInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public ConversationSinchEventInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public ConversationSinchEventInternalImpl(CapabilityEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(ChannelEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(ContactCreateEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(ContactDeleteEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(ContactIdentitiesDuplicationEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(ContactMergeEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(ContactUpdateEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(ConversationDeleteEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(ConversationStartEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(ConversationStopEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(EventDeliveryReceiptEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(InboundEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(MessageDeliveryReceiptEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(MessageInboundEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(MessageInboundSmartConversationRedactionEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(MessageSubmitEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(OptInEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(OptOutEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(RecordNotificationEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(SmartConversationsEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ConversationSinchEventInternalImpl(UnsupportedCallbackEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("CapabilityEventImpl", CapabilityEventImpl.class);
    schemas.put("ChannelEventImpl", ChannelEventImpl.class);
    schemas.put("ContactCreateEventImpl", ContactCreateEventImpl.class);
    schemas.put("ContactDeleteEventImpl", ContactDeleteEventImpl.class);
    schemas.put(
        "ContactIdentitiesDuplicationEventImpl", ContactIdentitiesDuplicationEventImpl.class);
    schemas.put("ContactMergeEventImpl", ContactMergeEventImpl.class);
    schemas.put("ContactUpdateEventImpl", ContactUpdateEventImpl.class);
    schemas.put("ConversationDeleteEventImpl", ConversationDeleteEventImpl.class);
    schemas.put("ConversationStartEventImpl", ConversationStartEventImpl.class);
    schemas.put("ConversationStopEventImpl", ConversationStopEventImpl.class);
    schemas.put("EventDeliveryReceiptEventImpl", EventDeliveryReceiptEventImpl.class);
    schemas.put("InboundEventImpl", InboundEventImpl.class);
    schemas.put("MessageDeliveryReceiptEventImpl", MessageDeliveryReceiptEventImpl.class);
    schemas.put("MessageInboundEventImpl", MessageInboundEventImpl.class);
    schemas.put(
        "MessageInboundSmartConversationRedactionEventImpl",
        MessageInboundSmartConversationRedactionEventImpl.class);
    schemas.put("MessageSubmitEventImpl", MessageSubmitEventImpl.class);
    schemas.put("OptInEventImpl", OptInEventImpl.class);
    schemas.put("OptOutEventImpl", OptOutEventImpl.class);
    schemas.put("RecordNotificationEventImpl", RecordNotificationEventImpl.class);
    schemas.put("SmartConversationsEventImpl", SmartConversationsEventImpl.class);
    schemas.put("UnsupportedCallbackEventImpl", UnsupportedCallbackEventImpl.class);
    JSONNavigator.registerDescendants(
        ConversationSinchEventInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return ConversationSinchEventInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: CapabilityEventImpl, ChannelEventImpl, ContactCreateEventImpl,
   * ContactDeleteEventImpl, ContactIdentitiesDuplicationEventImpl, ContactMergeEventImpl,
   * ContactUpdateEventImpl, ConversationDeleteEventImpl, ConversationStartEventImpl,
   * ConversationStopEventImpl, EventDeliveryReceiptEventImpl, InboundEventImpl,
   * MessageDeliveryReceiptEventImpl, MessageInboundEventImpl,
   * MessageInboundSmartConversationRedactionEventImpl, MessageSubmitEventImpl, OptInEventImpl,
   * OptOutEventImpl, RecordNotificationEventImpl, SmartConversationsEventImpl,
   * UnsupportedCallbackEventImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(CapabilityEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(ChannelEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ContactCreateEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ContactDeleteEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ContactIdentitiesDuplicationEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ContactMergeEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ContactUpdateEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ConversationDeleteEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ConversationStartEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ConversationStopEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        EventDeliveryReceiptEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(InboundEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        MessageDeliveryReceiptEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        MessageInboundEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        MessageInboundSmartConversationRedactionEventImpl.class,
        instance,
        new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        MessageSubmitEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(OptInEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(OptOutEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        RecordNotificationEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SmartConversationsEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        UnsupportedCallbackEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be CapabilityEventImpl, ChannelEventImpl,"
            + " ContactCreateEventImpl, ContactDeleteEventImpl,"
            + " ContactIdentitiesDuplicationEventImpl, ContactMergeEventImpl,"
            + " ContactUpdateEventImpl, ConversationDeleteEventImpl, ConversationStartEventImpl,"
            + " ConversationStopEventImpl, EventDeliveryReceiptEventImpl, InboundEventImpl,"
            + " MessageDeliveryReceiptEventImpl, MessageInboundEventImpl,"
            + " MessageInboundSmartConversationRedactionEventImpl, MessageSubmitEventImpl,"
            + " OptInEventImpl, OptOutEventImpl, RecordNotificationEventImpl,"
            + " SmartConversationsEventImpl, UnsupportedCallbackEventImpl");
  }

  /**
   * Get the actual instance, which can be the following: CapabilityEventImpl, ChannelEventImpl,
   * ContactCreateEventImpl, ContactDeleteEventImpl, ContactIdentitiesDuplicationEventImpl,
   * ContactMergeEventImpl, ContactUpdateEventImpl, ConversationDeleteEventImpl,
   * ConversationStartEventImpl, ConversationStopEventImpl, EventDeliveryReceiptEventImpl,
   * InboundEventImpl, MessageDeliveryReceiptEventImpl, MessageInboundEventImpl,
   * MessageInboundSmartConversationRedactionEventImpl, MessageSubmitEventImpl, OptInEventImpl,
   * OptOutEventImpl, RecordNotificationEventImpl, SmartConversationsEventImpl,
   * UnsupportedCallbackEventImpl
   *
   * @return The actual instance (CapabilityEventImpl, ChannelEventImpl, ContactCreateEventImpl,
   *     ContactDeleteEventImpl, ContactIdentitiesDuplicationEventImpl, ContactMergeEventImpl,
   *     ContactUpdateEventImpl, ConversationDeleteEventImpl, ConversationStartEventImpl,
   *     ConversationStopEventImpl, EventDeliveryReceiptEventImpl, InboundEventImpl,
   *     MessageDeliveryReceiptEventImpl, MessageInboundEventImpl,
   *     MessageInboundSmartConversationRedactionEventImpl, MessageSubmitEventImpl, OptInEventImpl,
   *     OptOutEventImpl, RecordNotificationEventImpl, SmartConversationsEventImpl,
   *     UnsupportedCallbackEventImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `CapabilityEventImpl`. If the actual instance is not
   * `CapabilityEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CapabilityEventImpl`
   * @throws ClassCastException if the instance is not `CapabilityEventImpl`
   */
  public CapabilityEventImpl getCapabilityEventImpl() throws ClassCastException {
    return (CapabilityEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ChannelEventImpl`. If the actual instance is not
   * `ChannelEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ChannelEventImpl`
   * @throws ClassCastException if the instance is not `ChannelEventImpl`
   */
  public ChannelEventImpl getChannelEventImpl() throws ClassCastException {
    return (ChannelEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ContactCreateEventImpl`. If the actual instance is not
   * `ContactCreateEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ContactCreateEventImpl`
   * @throws ClassCastException if the instance is not `ContactCreateEventImpl`
   */
  public ContactCreateEventImpl getContactCreateEventImpl() throws ClassCastException {
    return (ContactCreateEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ContactDeleteEventImpl`. If the actual instance is not
   * `ContactDeleteEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ContactDeleteEventImpl`
   * @throws ClassCastException if the instance is not `ContactDeleteEventImpl`
   */
  public ContactDeleteEventImpl getContactDeleteEventImpl() throws ClassCastException {
    return (ContactDeleteEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ContactIdentitiesDuplicationEventImpl`. If the actual instance is
   * not `ContactIdentitiesDuplicationEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ContactIdentitiesDuplicationEventImpl`
   * @throws ClassCastException if the instance is not `ContactIdentitiesDuplicationEventImpl`
   */
  public ContactIdentitiesDuplicationEventImpl getContactIdentitiesDuplicationEventImpl()
      throws ClassCastException {
    return (ContactIdentitiesDuplicationEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ContactMergeEventImpl`. If the actual instance is not
   * `ContactMergeEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ContactMergeEventImpl`
   * @throws ClassCastException if the instance is not `ContactMergeEventImpl`
   */
  public ContactMergeEventImpl getContactMergeEventImpl() throws ClassCastException {
    return (ContactMergeEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ContactUpdateEventImpl`. If the actual instance is not
   * `ContactUpdateEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ContactUpdateEventImpl`
   * @throws ClassCastException if the instance is not `ContactUpdateEventImpl`
   */
  public ContactUpdateEventImpl getContactUpdateEventImpl() throws ClassCastException {
    return (ContactUpdateEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ConversationDeleteEventImpl`. If the actual instance is not
   * `ConversationDeleteEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ConversationDeleteEventImpl`
   * @throws ClassCastException if the instance is not `ConversationDeleteEventImpl`
   */
  public ConversationDeleteEventImpl getConversationDeleteEventImpl() throws ClassCastException {
    return (ConversationDeleteEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ConversationStartEventImpl`. If the actual instance is not
   * `ConversationStartEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ConversationStartEventImpl`
   * @throws ClassCastException if the instance is not `ConversationStartEventImpl`
   */
  public ConversationStartEventImpl getConversationStartEventImpl() throws ClassCastException {
    return (ConversationStartEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ConversationStopEventImpl`. If the actual instance is not
   * `ConversationStopEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ConversationStopEventImpl`
   * @throws ClassCastException if the instance is not `ConversationStopEventImpl`
   */
  public ConversationStopEventImpl getConversationStopEventImpl() throws ClassCastException {
    return (ConversationStopEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `EventDeliveryReceiptEventImpl`. If the actual instance is not
   * `EventDeliveryReceiptEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `EventDeliveryReceiptEventImpl`
   * @throws ClassCastException if the instance is not `EventDeliveryReceiptEventImpl`
   */
  public EventDeliveryReceiptEventImpl getEventDeliveryReceiptEventImpl()
      throws ClassCastException {
    return (EventDeliveryReceiptEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `InboundEventImpl`. If the actual instance is not
   * `InboundEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `InboundEventImpl`
   * @throws ClassCastException if the instance is not `InboundEventImpl`
   */
  public InboundEventImpl getInboundEventImpl() throws ClassCastException {
    return (InboundEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MessageDeliveryReceiptEventImpl`. If the actual instance is not
   * `MessageDeliveryReceiptEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `MessageDeliveryReceiptEventImpl`
   * @throws ClassCastException if the instance is not `MessageDeliveryReceiptEventImpl`
   */
  public MessageDeliveryReceiptEventImpl getMessageDeliveryReceiptEventImpl()
      throws ClassCastException {
    return (MessageDeliveryReceiptEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MessageInboundEventImpl`. If the actual instance is not
   * `MessageInboundEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `MessageInboundEventImpl`
   * @throws ClassCastException if the instance is not `MessageInboundEventImpl`
   */
  public MessageInboundEventImpl getMessageInboundEventImpl() throws ClassCastException {
    return (MessageInboundEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MessageInboundSmartConversationRedactionEventImpl`. If the actual
   * instance is not `MessageInboundSmartConversationRedactionEventImpl`, the ClassCastException
   * will be thrown.
   *
   * @return The actual instance of `MessageInboundSmartConversationRedactionEventImpl`
   * @throws ClassCastException if the instance is not
   *     `MessageInboundSmartConversationRedactionEventImpl`
   */
  public MessageInboundSmartConversationRedactionEventImpl
      getMessageInboundSmartConversationRedactionEventImpl() throws ClassCastException {
    return (MessageInboundSmartConversationRedactionEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MessageSubmitEventImpl`. If the actual instance is not
   * `MessageSubmitEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `MessageSubmitEventImpl`
   * @throws ClassCastException if the instance is not `MessageSubmitEventImpl`
   */
  public MessageSubmitEventImpl getMessageSubmitEventImpl() throws ClassCastException {
    return (MessageSubmitEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `OptInEventImpl`. If the actual instance is not `OptInEventImpl`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `OptInEventImpl`
   * @throws ClassCastException if the instance is not `OptInEventImpl`
   */
  public OptInEventImpl getOptInEventImpl() throws ClassCastException {
    return (OptInEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `OptOutEventImpl`. If the actual instance is not `OptOutEventImpl`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `OptOutEventImpl`
   * @throws ClassCastException if the instance is not `OptOutEventImpl`
   */
  public OptOutEventImpl getOptOutEventImpl() throws ClassCastException {
    return (OptOutEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `RecordNotificationEventImpl`. If the actual instance is not
   * `RecordNotificationEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `RecordNotificationEventImpl`
   * @throws ClassCastException if the instance is not `RecordNotificationEventImpl`
   */
  public RecordNotificationEventImpl getRecordNotificationEventImpl() throws ClassCastException {
    return (RecordNotificationEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SmartConversationsEventImpl`. If the actual instance is not
   * `SmartConversationsEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SmartConversationsEventImpl`
   * @throws ClassCastException if the instance is not `SmartConversationsEventImpl`
   */
  public SmartConversationsEventImpl getSmartConversationsEventImpl() throws ClassCastException {
    return (SmartConversationsEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `UnsupportedCallbackEventImpl`. If the actual instance is not
   * `UnsupportedCallbackEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `UnsupportedCallbackEventImpl`
   * @throws ClassCastException if the instance is not `UnsupportedCallbackEventImpl`
   */
  public UnsupportedCallbackEventImpl getUnsupportedCallbackEventImpl() throws ClassCastException {
    return (UnsupportedCallbackEventImpl) super.getActualInstance();
  }
}
