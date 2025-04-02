package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.databind.FormSerializer;
import com.sinch.sdk.core.utils.Pair;
import java.util.List;
import java.util.Map;

public class CustomHeadersFormSerializer extends FormSerializer<List<Pair<String, String>>> {

  @Override
  public void serialize(List<Pair<String, String>> in, String fieldName, Map<String, Object> out) {
    PrefixedListFormSerializerHelper.serialize("h:", in, out);
  }
}
