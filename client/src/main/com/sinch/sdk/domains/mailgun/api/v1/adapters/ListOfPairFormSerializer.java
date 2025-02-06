package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.databind.FormSerializer;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.core.utils.databind.Mapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOfPairFormSerializer extends FormSerializer<List<Pair<String, Object>>> {

  @Override
  public void serialize(List<Pair<String, Object>> in, String fieldName, Map<String, Object> out) {

    try {

      if (null == in) {
        out.put(fieldName, null);
        return;
      }

      Map<String, Object> collected =
          in.stream()
              .collect(
                  Collectors.toMap(
                      Pair::getLeft, Pair::getRight, (s1, s2) -> s1, LinkedHashMap::new));

      out.put(fieldName, Mapper.getInstance().writeValueAsString(collected));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
