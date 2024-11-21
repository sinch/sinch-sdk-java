package com.sinch.sdk.core.databind.multipart;

import com.sinch.sdk.core.databind.FormSerializer;
import com.sinch.sdk.core.databind.annotation.FormSerialize;
import com.sinch.sdk.core.databind.annotation.PropertiesOrder;
import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.exceptions.SerializationException;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.Pair;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ObjectMapper {

  public Map<String, Object> serialize(Object value)
      throws IntrospectionException,
          InvocationTargetException,
          IllegalAccessException,
          ClassNotFoundException,
          NoSuchMethodException,
          InstantiationException {

    BeanInfo beanInfo = Introspector.getBeanInfo(value.getClass(), Object.class);
    List<Pair<String, Method>> serializableProperties = collectSerializableProperties(beanInfo);
    return serializeProperties(serializableProperties, value);
  }

  private List<Pair<String, Method>> collectSerializableProperties(BeanInfo beanInfo) {

    ArrayList<Pair<String, Method>> result = new ArrayList<>();
    final MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();

    for (MethodDescriptor methodDescriptor : methodDescriptors) {
      getPropertyGetter(methodDescriptor.getMethod()).ifPresent(result::add);
    }
    return sortProperties(beanInfo, result);
  }

  private List<Pair<String, Method>> sortProperties(
      BeanInfo beanInfo, List<Pair<String, Method>> properties) {

    PropertiesOrder propertyOrder =
        beanInfo.getBeanDescriptor().getBeanClass().getAnnotation(PropertiesOrder.class);

    if (null == propertyOrder) {
      return properties;
    }

    ArrayList<Pair<String, Method>> sorted = new ArrayList<>(properties.size());

    for (String property : propertyOrder.value()) {
      properties.stream()
          .filter(p -> p.getLeft().equals(property))
          .findFirst()
          .ifPresent(sorted::add);
    }
    return sorted;
  }

  private Optional<Pair<String, Method>> getPropertyGetter(Method method) {

    Property property = method.getDeclaredAnnotation(Property.class);
    if (null == property) {
      return Optional.empty();
    }
    return Optional.of(new Pair<>(property.value(), method));
  }

  private Map<String, Object> serializeProperties(
      List<Pair<String, Method>> serializableProperties, Object object)
      throws InvocationTargetException, IllegalAccessException {
    Map<String, Object> properties = new LinkedHashMap<>();
    for (Pair<String, Method> property : serializableProperties) {

      serializeProperty(object, property.getRight())
          .ifPresent(v -> properties.put(property.getLeft(), v));
    }
    return properties;
  }

  private OptionalValue<?> serializeProperty(Object object, Method method)
      throws InvocationTargetException, IllegalAccessException {

    OptionalValue<?> propertyValue = (OptionalValue<?>) method.invoke(object);

    if (!propertyValue.isPresent() || null == propertyValue.get()) {
      return propertyValue;
    }

    Object value = propertyValue.get();

    FormSerialize formSerialize = method.getDeclaredAnnotation(FormSerialize.class);
    if (null != formSerialize) {
      value = handleOverriddenSerialization(formSerialize, value);
    }

    if (value instanceof EnumDynamic) {
      EnumDynamic<?, ?> enumDynamic = (EnumDynamic<?, ?>) value;
      return OptionalValue.of((enumDynamic.value().toString()));
    }
    return OptionalValue.of(value);
  }

  private Object handleOverriddenSerialization(FormSerialize formSerialize, Object value) {
    try {
      Class<?> clazz = Class.forName(formSerialize.using().getName());
      @SuppressWarnings("unchecked")
      Constructor<FormSerializer<Object>> ctor =
          (Constructor<FormSerializer<Object>>) clazz.getConstructor();
      FormSerializer<Object> serializer = ctor.newInstance();
      return serializer.serialize(value);
    } catch (Exception e) {
      throw new SerializationException(e);
    }
  }
}
