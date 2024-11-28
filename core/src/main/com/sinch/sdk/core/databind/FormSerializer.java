package com.sinch.sdk.core.databind;

import java.util.Map;

public abstract class FormSerializer<T> {

  public abstract void serialize(T in, String fieldName, Map<String, Object> out);
}
