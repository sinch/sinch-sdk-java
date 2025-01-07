package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import static java.util.stream.Collectors.toMap;

import com.sinch.sdk.core.databind.FormSerializer;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.core.utils.databind.Mapper;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

public class MapOfPairsToJSONFormSerializer
    extends FormSerializer<Map<String, Collection<Pair<String, String>>>> {

  @Override
  public void serialize(
      Map<String, Collection<Pair<String, String>>> in, String fieldName, Map<String, Object> out) {
    if (null != in) {
      try {
        Map<String, Map<String, String>> collected =
            in.entrySet().stream()
                .collect(
                    toMap(
                        Entry::getKey,
                        entry ->
                            entry.getValue().stream()
                                .collect(toMap(Pair::getLeft, Pair::getRight))));
        out.put(fieldName, Mapper.getInstance().writeValueAsString(collected));
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
