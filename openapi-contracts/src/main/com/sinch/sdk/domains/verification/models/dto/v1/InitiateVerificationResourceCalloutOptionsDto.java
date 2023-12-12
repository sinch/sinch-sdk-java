/*
 * Verification
 * Verification REST API for verifying phone numbers and users. Support of FlashCall verification, PIN SMS verification and Callout verification.    **Note:** OTP CODE must be the full valid E.164 number that we called from.    ## Overview    For general information on how to use the Sinch APIs including methods, types, errors and authorization, please check the [Using REST](doc:using-rest) page.  Use the Sinch Verification Service to verify end-user's mobile phone numbers. The Sinch Verification APIs should be used in combination with the Verification SDKs for a complete end-to-end solution, though it is possible to only use the APIs. Currently, there are three verification methods supported:    - FlashCall verification - Android only  - PIN SMS verification - iOS, Android, Javascript  - Callout verification (voice call) - iOS only  - Data verification (distinguished by method = `seamless`) - iOS, Android    #### FlashCall verification    With the flashCall verification method, a user's phone number is verified by triggering a \"missed call\" towards this number. The call is intercepted by the Android SDK in the mobile app and blocked automatically.  To initiate a flashCall verification, check the [Android SDK documentation](doc:verification-android-the-verification-process#flash-call-verification). For additional security, it is recommended that you control which verification requests should proceed and which ones not, by listening in your backend for the [Verification Request Event](doc:verification-rest-verification-api#verification-request) and respond accordingly. Your backend will be notified on the result of the verification with the [Verification Result Event](doc:verification-rest-callback-api#verification-result-event).    #### PIN SMS verification    With the PIN SMS verification method, a user's phone number is verified by sending an SMS containing a PIN code to this number. In the case of iOS or Javascript, the user needs to enter the PIN manually in the app, while for Android there is an option of intercepting the SMS message delivery and capturing the PIN code automatically.  To initiate a PIN SMS verification, check the [iOS](doc:verification-ios-sms-verification), [Android](doc:verification-for-android) and [Javascript](doc:verification-for-javascript) documentation. For additional security, it is recommended that you control which verification requests should proceed and which ones not, by listening in your backend for the [Verification Request Event](doc:verification-rest-verification-api#verification-request) and respond accordingly. Your backend will be notified on the result of the verification with the [Verification Result Event](doc:verification-rest-callback-api#verification-result-event).    #### Callout verification    With the callout verification method, a user's phone number is verified by receiving a phone call and hearing a pre-recorded or text-to-speech message, advising the user to press a digit code. When the user presses the digit code in the dialpad, the verification is successful.  To initiate a callout verification, check the [iOS documentation](doc:verification-ios-callout-verification). For additional security, it is recommended that you control which verification requests should proceed and which ones not, by listening in your backend for the [Verification Request Event](doc:verification-rest-verification-api#verification-request) and respond accordingly. Your backend will be notified on the result of the verification with the [Verification Result Event](doc:verification-rest-callback-api#verification-result-event).    #### Data verification    With the data verification method, a user's phone number is verified by carrier using mobile data network. For additional security, it is recommended that you control which verification requests should proceed and which ones not, by listening in your backend for the [Verification Request Event](doc:verification-rest-verification-api#verification-request) and respond accordingly. Your backend will be notified on the result of the verification with the [Verification Result Event](doc:verification-rest-callback-api#verification-result-event).    > 📘 For information about webhooks and the verifications events [Callbacks](/docs/verification-rest-callback-api).
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.dto.v1;

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
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonDeserialize(
    using =
        InitiateVerificationResourceCalloutOptionsDto
            .InitiateVerificationResourceCalloutOptionsDtoDeserializer.class)
@JsonSerialize(
    using =
        InitiateVerificationResourceCalloutOptionsDto
            .InitiateVerificationResourceCalloutOptionsDtoSerializer.class)
public class InitiateVerificationResourceCalloutOptionsDto extends AbstractOpenApiSchema {
  private static final Logger log =
      Logger.getLogger(InitiateVerificationResourceCalloutOptionsDto.class.getName());

  public static class InitiateVerificationResourceCalloutOptionsDtoSerializer
      extends StdSerializer<InitiateVerificationResourceCalloutOptionsDto> {
    public InitiateVerificationResourceCalloutOptionsDtoSerializer(
        Class<InitiateVerificationResourceCalloutOptionsDto> t) {
      super(t);
    }

    public InitiateVerificationResourceCalloutOptionsDtoSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        InitiateVerificationResourceCalloutOptionsDto value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static class InitiateVerificationResourceCalloutOptionsDtoDeserializer
      extends StdDeserializer<InitiateVerificationResourceCalloutOptionsDto> {
    public InitiateVerificationResourceCalloutOptionsDtoDeserializer() {
      this(InitiateVerificationResourceCalloutOptionsDto.class);
    }

    public InitiateVerificationResourceCalloutOptionsDtoDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public InitiateVerificationResourceCalloutOptionsDto deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize CalloutOptionsDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CalloutOptionsDto.class.equals(Integer.class)
            || CalloutOptionsDto.class.equals(Long.class)
            || CalloutOptionsDto.class.equals(Float.class)
            || CalloutOptionsDto.class.equals(Double.class)
            || CalloutOptionsDto.class.equals(Boolean.class)
            || CalloutOptionsDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CalloutOptionsDto.class.equals(Integer.class)
                        || CalloutOptionsDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CalloutOptionsDto.class.equals(Float.class)
                        || CalloutOptionsDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CalloutOptionsDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CalloutOptionsDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
            attemptParsing |= (token == JsonToken.VALUE_NULL);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CalloutOptionsDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CalloutOptionsDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'CalloutOptionsDto'", e);
      }

      if (match == 1) {
        InitiateVerificationResourceCalloutOptionsDto ret =
            new InitiateVerificationResourceCalloutOptionsDto();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for InitiateVerificationResourceCalloutOptionsDto: %d"
                  + " classes match result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public InitiateVerificationResourceCalloutOptionsDto getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      return null;
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public InitiateVerificationResourceCalloutOptionsDto() {
    super("oneOf", Boolean.TRUE);
  }

  public InitiateVerificationResourceCalloutOptionsDto(CalloutOptionsDto o) {
    super("oneOf", Boolean.TRUE);
    setActualInstance(o);
  }

  static {
    schemas.put("CalloutOptionsDto", CalloutOptionsDto.class);
    JSONNavigator.registerDescendants(
        InitiateVerificationResourceCalloutOptionsDto.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return InitiateVerificationResourceCalloutOptionsDto.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: CalloutOptionsDto
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (instance == null) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(CalloutOptionsDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException("Invalid instance type. Must be CalloutOptionsDto");
  }

  /**
   * Get the actual instance, which can be the following: CalloutOptionsDto
   *
   * @return The actual instance (CalloutOptionsDto)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `CalloutOptionsDto`. If the actual instance is not
   * `CalloutOptionsDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CalloutOptionsDto`
   * @throws ClassCastException if the instance is not `CalloutOptionsDto`
   */
  public CalloutOptionsDto getCalloutOptionsDto() throws ClassCastException {
    return (CalloutOptionsDto) super.getActualInstance();
  }
}
