package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import com.sinch.sdk.core.utils.Pair;
import java.util.List;
import java.util.Map;

public class PrefixedListFormSerializerHelper {

  public static void serialize(
      String prefix, List<Pair<String, String>> in, Map<String, Object> out) {
    if (null != in) {
      try {
        Map<String, List<String>> groupedByKey =
            in.stream()
                .map(
                    entry ->
                        Pair.of(String.format("%s%s", prefix, entry.getLeft()), entry.getRight()))
                .collect(groupingBy(Pair::getLeft, mapping(Pair::getRight, toList())));

        out.putAll(groupedByKey);

      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
