package com.sinch.sdk;

import com.adelean.inject.resources.junit.jupiter.WithJacksonMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.sinch.sdk.core.utils.databind.Mapper;
import java.lang.reflect.Field;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BaseTest {

  @WithJacksonMapper protected ObjectMapper objectMapper = Mapper.getInstance();

  @BeforeEach
  void init_mocks() throws NoSuchFieldException, IllegalAccessException {

    // extracted from https://github.com/FasterXML/jackson-databind/issues/4953
    // currently based onto jackson 2.18, the "clear" feature will be available starting with 2.19
    // (not yet released)
    // mapper._rootDeserializers is private, so we need to clear it using reflection
    Field field = objectMapper.getClass().getDeclaredField("_rootDeserializers");
    field.setAccessible(true);
    Map<?, ?> rootDeserializers = (Map<?, ?>) field.get(objectMapper);
    rootDeserializers.clear();

    // DeserializationContext._cache is private, so we need to clear it using reflection
    field =
        objectMapper
            .getDeserializationContext()
            .getClass()
            .getSuperclass()
            .getSuperclass()
            .getDeclaredField("_cache");
    field.setAccessible(true);
    DeserializerCache cache =
        (DeserializerCache) field.get(objectMapper.getDeserializationContext());
    cache.flushCachedDeserializers();

    MockitoAnnotations.openMocks(this);
  }
}
