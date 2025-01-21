package com.sinch.sdk.core.databind.query_parameter;

import com.sinch.sdk.core.databind.QueryParameterSerializer;
import java.time.Instant;

public class InstantToIso8601Serializer implements QueryParameterSerializer<Instant, String> {

  public static InstantToIso8601Serializer getInstance() {
    return LazyHolder.INSTANCE;
  }

  @Override
  public String apply(Instant instant) {
    if (null == instant) {
      return null;
    }
    return instant.toString();
  }

  private static class LazyHolder {
    private static final InstantToIso8601Serializer INSTANCE = new InstantToIso8601Serializer();
  }

  private InstantToIso8601Serializer() {}
}
