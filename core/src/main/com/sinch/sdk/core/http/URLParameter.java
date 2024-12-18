package com.sinch.sdk.core.http;

import java.util.Objects;

public class URLParameter {
  private final String name;
  private final Object value;
  private final STYLE style;
  private final boolean explode;

  /**
   * Create a URL parameter from an object and a style: matrix, label, form, ... (see <a
   * href="https://spec.openapis.org/oas/latest.html#parameter-object">OAS site</a>)
   *
   * @param name The name of the parameter.
   * @param value The value of the parameter. Could be a collection of object values for name
   * @param style The style to be used for converting value to URL parameter string representation
   * @param explode Is parameter have to be exploded for URL parameter string representation
   */
  public URLParameter(String name, Object value, STYLE style, boolean explode) {
    this.name = name;
    this.value = value;
    this.style = style;
    this.explode = explode;
  }

  public URLParameter(String name, Object value) {
    this.name = name;
    this.value = value;
    this.style = STYLE.FORM;
    this.explode = false;
  }

  public String getName() {
    return name;
  }

  public Object getValue() {
    return value;
  }

  public STYLE getStyle() {
    return style;
  }

  public boolean isExplode() {
    return explode;
  }

  @Override
  public String toString() {
    return "URLParameter{"
        + "name='"
        + name
        + '\''
        + ", value='"
        + value
        + '\''
        + ", style='"
        + style
        + '\''
        + ", explode="
        + explode
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof URLParameter)) {
      return false;
    }
    URLParameter that = (URLParameter) o;
    return isExplode() == that.isExplode()
        && Objects.equals(getName(), that.getName())
        && Objects.equals(getValue(), that.getValue())
        && getStyle() == that.getStyle();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getValue(), getStyle(), isExplode());
  }

  public enum STYLE {
    MATRIX,
    LABEL,
    FORM,
    SIMPLE,
    SPACE_DELIMITED,
    PIPE_DELIMITED,
    DEEP_OBJECT;
  }

  // the following constants do not follow java standard by purpose
  // Aim is to  have direct access to OpenApi Spec authorized values as constant without overhead
  // ref: https://spec.openapis.org/oas/latest.html#style-values
  public static final STYLE matrix = STYLE.MATRIX;
  public static final STYLE label = STYLE.LABEL;
  public static final STYLE form = STYLE.FORM;
  public static final STYLE simple = STYLE.SIMPLE;
  public static final STYLE spaceDelimited = STYLE.SPACE_DELIMITED;
  public static final STYLE pipeDelimited = STYLE.PIPE_DELIMITED;
  public static final STYLE deepObject = STYLE.DEEP_OBJECT;
}
