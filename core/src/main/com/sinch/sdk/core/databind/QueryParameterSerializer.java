package com.sinch.sdk.core.databind;

import java.util.function.Function;

public interface QueryParameterSerializer<T, R> extends Function<T, R> {}
