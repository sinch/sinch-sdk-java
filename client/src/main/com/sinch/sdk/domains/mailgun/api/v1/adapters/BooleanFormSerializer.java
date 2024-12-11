package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.databind.FormSerializer;
import java.util.Map;

public class BooleanFormSerializer extends FormSerializer<Boolean> {

  @Override
  public void serialize(Boolean in, String fieldName, Map<String, Object> out) {
    if (null != in) {
      out.put(fieldName, format(in));
    }
  }

  private static String format(Boolean value) {
    return String.format("%s", value);
  }
}
