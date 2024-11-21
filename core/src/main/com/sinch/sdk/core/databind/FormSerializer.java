package com.sinch.sdk.core.databind;

public abstract class FormSerializer<T> {

  public abstract Object serialize(T in);
}
