package com.sinch.sdk.core.http;

public class URLParameter {
  private final String name;
  private final Object value;
  private final STYLE style;
  private final boolean explode;

  /**
   * Create a URL parameter from an object and a style: matrix, label, form, ... (see OAS <a
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

  public enum STYLE {
    MATRIX,
    LABEL,
    FORM,
    SIMPLE,
    SPACE_DELIMITED,
    PIPE_DELIMITED,
    DEEP_OBJECT
  }
}
