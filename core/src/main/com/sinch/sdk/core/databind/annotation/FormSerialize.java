package com.sinch.sdk.core.databind.annotation;

import com.sinch.sdk.core.databind.FormSerializer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@SinchAnnotation
public @interface FormSerialize {

  @SuppressWarnings("rawtypes") // to work around JDK8 bug wrt Class-valued annotation properties
  Class<? extends FormSerializer> using();
}
