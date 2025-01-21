package com.sinch.sdk.domains;

import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.URLParameter.STYLE;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PaginationFillerHelper {

  public static Collection<URLParameter> parametersFiller(
      String name, Object value, STYLE style, boolean explode, List<?> values) {

    List<URLParameter> parameters = new ArrayList<>();

    URLParameter parameter = new URLParameter(name, value, style, explode);
    parameters.add(parameter);
    for (int i = 0; i < values.size(); ) {
      parameter =
          new URLParameter(
              (String) values.get(i++),
              values.get(i++),
              (STYLE) values.get(i++),
              (boolean) values.get(i++));
      parameters.add(parameter);
    }
    return parameters;
  }
}
