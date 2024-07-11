package com.sinch.sdk.core.utils.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sinch.sdk.core.models.OptionalValue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * Deserializer used to check deserialization result from Builder pattern Looking for required
 * properties and check if they was present from received payload
 */
class BuilderDeserializerWithValidation extends BeanDeserializerModifier {

  @Override
  public JsonDeserializer<?> modifyDeserializer(
      DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {

    if (!(deserializer instanceof BuilderBasedDeserializer)) {
      return deserializer;
    }
    return new DeserializerWithValidation((BuilderBasedDeserializer) deserializer);
  }

  static class DeserializerWithValidation extends BuilderBasedDeserializer {

    protected DeserializerWithValidation(BuilderBasedDeserializer src) {
      super(src);
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
      return validate(this, p, super.deserialize(p, ctxt));
    }

    private Object validate(BuilderBasedDeserializer deserializer, JsonParser p, Object instance)
        throws InvalidFormatException {

      Collection<Object> names = deserializer.getKnownPropertyNames();

      if (null == instance || null == names) {
        return null;
      }

      for (Object property : names) {
        if (property instanceof String)
          validateProperty(p, deserializer.findProperty((String) property), instance);
      }
      return instance;
    }

    private void validateProperty(JsonParser p, SettableBeanProperty property, Object pojo)
        throws InvalidFormatException {

      if (null == property) {
        return;
      }
      if (!property.getMetadata().getRequired()) {
        return;
      }
      // looking for getter returning OptionalValue
      char[] charGetterName = property.getMember().getName().replace("set", "").toCharArray();
      charGetterName[0] = Character.toLowerCase(charGetterName[0]);
      String getterName = new String(charGetterName);

      Object value;
      try {
        value = pojo.getClass().getMethod(getterName).invoke(pojo);
      } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
        // ignore error let have a chance to work in "relax" mode
        return;
      }
      if (value instanceof OptionalValue) {
        if (!((OptionalValue<?>) value).isPresent()) {
          throw new InvalidFormatException(
              p,
              String.format("Missing required field '%s'", property.getMember().getName()),
              pojo,
              pojo.getClass());
        }
      }
    }
  }
}
