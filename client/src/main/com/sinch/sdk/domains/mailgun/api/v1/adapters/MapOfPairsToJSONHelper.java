package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import static java.util.stream.Collectors.toMap;

import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.core.utils.databind.Mapper;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

public final class MapOfPairsToJSONHelper {

  private MapOfPairsToJSONHelper() {}

  public static String serialize(Map<String, Collection<Pair<String, Object>>> in) {
    if (null == in) {
      return null;
    }

    try {
      Map<String, Map<String, Object>> collected =
          in.entrySet().stream()
              .collect(
                  toMap(
                      Entry::getKey,
                      entry ->
                          entry.getValue().stream().collect(toMap(Pair::getLeft, Pair::getRight))));
      return Mapper.getInstance().writeValueAsString(collected);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
