package com.sinch.sdk.core.utils.databind;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.Map;

public class Mapper {

  private Mapper() {}

  public static ObjectMapper getInstance() {
    return LazyHolder.INSTANCE;
  }

  private static class LazyHolder {

    public static final ObjectMapper INSTANCE =
        new ObjectMapper()
            .setAnnotationIntrospector(new FilteringIntrospection())
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
            .enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
            .setFilterProvider(
                new SimpleFilterProvider().addFilter("uninitializedFilter", uninitializedFilter))
            .registerModule(new JavaTimeModule());
  }

  public static final PropertyFilter uninitializedFilter =
      new SimpleBeanPropertyFilter() {
        @Override
        public void serializeAsField(
            Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
            throws Exception {

          if (include(writer)) {

            AnnotatedMember member = writer.getMember();

            // Generated POJO contains a "getXXXDefined" function letting known if the field XXX was
            // set (initialized) or not.
            // Do not serialize uninitialized fields to avoid sending a null value when not required
            boolean serialize =
                (boolean) pojo.getClass().getMethod(member.getName() + "Defined").invoke(pojo);

            // not set but is field is required ?
            if (!serialize) {
              if (member.hasAnnotation(JsonInclude.class)) {
                JsonInclude annotation = member.getAnnotation(JsonInclude.class);
                // property is required but was not defined: throw an exception from client side
                // before
                // network transfer
                if (null != annotation && JsonInclude.Include.ALWAYS == annotation.value()) {
                  throw new IllegalStateException(
                      String.format("Required property '%s' was not set", writer.getName()));
                }
              }
            }

            if (serialize) {
              writer.serializeAsField(pojo, jgen, provider);
            }
          }
        }
      };

  private static class FilteringIntrospection extends JacksonAnnotationIntrospector {

    @Override
    public Object findFilterId(Annotated ac) {

      // FIXME: generated sources are setting filter onto all classes but HashMap is causing issue
      // To be investigated but currently a workaround: ignore our filter for these classes
      // "com.sinch.sdk.domains.sms.models.dto.v1.ParameterObjDto" is one of
      Class<?> clss = ac.getRawType();
      if (Map.class.isAssignableFrom(clss)) {
        return null;
      }
      return super.findFilterId(ac);
    }
  }
}
