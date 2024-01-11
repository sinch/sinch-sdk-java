package com.sinch.sdk;

import com.adelean.inject.resources.junit.jupiter.WithJacksonMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinch.sdk.core.utils.databind.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BaseTest {

  @WithJacksonMapper protected ObjectMapper objectMapper = Mapper.getInstance();

  @BeforeEach
  void init_mocks() {
    MockitoAnnotations.openMocks(this);
  }
}
