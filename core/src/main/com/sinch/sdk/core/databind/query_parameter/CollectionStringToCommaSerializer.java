package com.sinch.sdk.core.databind.query_parameter;

import com.sinch.sdk.core.databind.QueryParameterSerializer;
import java.util.Collection;

public class CollectionStringToCommaSerializer
    implements QueryParameterSerializer<Collection<String>, String> {

  public static CollectionStringToCommaSerializer getInstance() {
    return CollectionStringToCommaSerializer.LazyHolder.INSTANCE;
  }

  @Override
  public String apply(Collection<String> collection) {
    if (null == collection) {
      return null;
    }
    return String.join(",", collection);
  }

  private static class LazyHolder {
    private static final CollectionStringToCommaSerializer INSTANCE =
        new CollectionStringToCommaSerializer();
  }

  private CollectionStringToCommaSerializer() {}
}
