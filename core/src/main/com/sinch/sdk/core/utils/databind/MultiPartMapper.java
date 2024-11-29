package com.sinch.sdk.core.utils.databind;

import com.sinch.sdk.core.databind.multipart.ObjectMapper;

public class MultiPartMapper {

  public static ObjectMapper getInstance() {
    return LazyHolder.INSTANCE;
  }

  private MultiPartMapper() {}

  private static class LazyHolder {

    public static final ObjectMapper INSTANCE = new ObjectMapper();
  }
}
