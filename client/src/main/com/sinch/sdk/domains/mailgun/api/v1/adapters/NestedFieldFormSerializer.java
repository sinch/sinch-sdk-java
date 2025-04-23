package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.databind.FormSerializer;
import com.sinch.sdk.core.utils.databind.MultiPartMapper;
import java.util.Map;

public class NestedFieldFormSerializer extends FormSerializer<Object> {

  @Override
  public void serialize(Object in, String fieldName, Map<String, Object> out) {
    if (null != in) {
      try {
        out.putAll(MultiPartMapper.getInstance().serialize(in));
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
