package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.utils.databind.Mapper;
import java.util.Map;

public final class MapToJSONStringHelper {

  private MapToJSONStringHelper() {}

  public static String serialize(Map<String, Object> in) {
    if (null == in) {
      return null;
    }
    try {
      return Mapper.getInstance().writeValueAsString(in);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
