package com.sinch.sdk.core.databind.multipart;

import com.sinch.sdk.core.databind.FormSerializer;
import com.sinch.sdk.core.databind.annotation.FormSerialize;
import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.databind.annotation.Required;
import com.sinch.sdk.core.exceptions.SerializationException;
import com.sinch.sdk.core.models.AdditionalProperties;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ObjectMapper {

  static final String ADDITIONAL_PROPERTIES_IDENTIFIER = "additionalProperties";

  public Map<String, Object> serialize(Object value)
      throws IntrospectionException,
          InvocationTargetException,
          IllegalAccessException,
          ClassNotFoundException,
          NoSuchMethodException,
          InstantiationException {

    BeanInfo beanInfo = Introspector.getBeanInfo(value.getClass(), Object.class);
    List<PropertyMetadata> serializableProperties = collectSerializableProperties(beanInfo);
    Map<String, Object> output = serializeProperties(serializableProperties, value);
    if (value instanceof AdditionalProperties) {
      serializeAdditionalProperties(
          getAdditionalPropertiesGetter(beanInfo).getMethod(), value, output);
    }

    return output;
  }

  private List<PropertyMetadata> collectSerializableProperties(BeanInfo beanInfo) {

    List<PropertyMetadata> result = new ArrayList<>();
    final MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();

    for (MethodDescriptor methodDescriptor : methodDescriptors) {
      getPropertyGetter(methodDescriptor.getMethod()).ifPresent(result::add);
    }

    return result;
  }

  private Optional<PropertyMetadata> getPropertyGetter(Method method) {

    Property property = method.getDeclaredAnnotation(Property.class);
    if (null == property) {
      return Optional.empty();
    }
    Required required = method.getDeclaredAnnotation(Required.class);
    return Optional.of(new PropertyMetadata(property.value(), required != null, method));
  }

  private MethodDescriptor getAdditionalPropertiesGetter(BeanInfo beanInfo) {

    return Arrays.stream(beanInfo.getMethodDescriptors())
        .filter(f -> f.getMethod().getName().equals(ADDITIONAL_PROPERTIES_IDENTIFIER))
        .findFirst()
        .orElseThrow(
            () ->
                new SerializationException(
                    String.format("Missing '%s' getter", ADDITIONAL_PROPERTIES_IDENTIFIER)));
  }

  private Map<String, Object> serializeProperties(
      List<PropertyMetadata> serializableProperties, Object object)
      throws InvocationTargetException, IllegalAccessException {
    Map<String, Object> out = new LinkedHashMap<>();
    for (PropertyMetadata property : serializableProperties) {
      serializeProperty(object, property, out);
    }
    return out;
  }

  private void serializeAdditionalProperties(
      Method method, Object object, Map<String, Object> output)
      throws InvocationTargetException, IllegalAccessException {

    @SuppressWarnings("unchecked")
    Map<String, Object> propertyValue = (Map<String, Object>) method.invoke(object);
    if (null == propertyValue) {
      return;
    }

    FormSerialize formSerialize = method.getDeclaredAnnotation(FormSerialize.class);
    if (null != formSerialize) {
      handleOverriddenSerialization(formSerialize, propertyValue, "", output);
      return;
    }
    output.putAll(propertyValue);
  }

  private void serializeProperty(Object object, PropertyMetadata property, Map<String, Object> out)
      throws InvocationTargetException, IllegalAccessException {

    Method method = property.getGetter();
    String fieldName = property.getName();
    boolean required = property.getRequired();

    OptionalValue<?> propertyValue = (OptionalValue<?>) method.invoke(object);
    boolean isPresent = propertyValue.isPresent();
    if (required && !isPresent) {
      throw new IllegalArgumentException(String.format("Missing required field '%s'", fieldName));
    }
    if (!isPresent || null == propertyValue.get()) {
      return;
    }

    Object value = propertyValue.get();

    FormSerialize formSerialize = method.getDeclaredAnnotation(FormSerialize.class);
    if (null != formSerialize) {
      handleOverriddenSerialization(formSerialize, value, fieldName, out);
      return;
    }

    if (value instanceof EnumDynamic) {
      EnumDynamic<?, ?> enumDynamic = (EnumDynamic<?, ?>) value;
      out.put(fieldName, enumDynamic.value().toString());
      return;
    }
    out.put(fieldName, value);
  }

  private void handleOverriddenSerialization(
      FormSerialize formSerialize, Object in, String fieldName, Map<String, Object> out) {
    try {
      Class<?> clazz = Class.forName(formSerialize.using().getName());
      @SuppressWarnings("unchecked")
      Constructor<FormSerializer<Object>> ctor =
          (Constructor<FormSerializer<Object>>) clazz.getConstructor();
      ctor.newInstance().serialize(in, fieldName, out);
    } catch (Exception e) {
      throw new SerializationException(e);
    }
  }

  static class PropertyMetadata {
    final String name;
    final Boolean required;
    final Method getter;

    public PropertyMetadata(String name, Boolean required, Method getter) {
      this.name = name;
      this.required = required;
      this.getter = getter;
    }

    public String getName() {
      return name;
    }

    public Boolean getRequired() {
      return Boolean.TRUE.equals(required);
    }

    public Method getGetter() {
      return getter;
    }
  }
}
