package com.sinch.sdk.domains.voice.models.v2.services;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import java.util.Arrays;
import java.util.Objects;

@JsonPropertyOrder({
  StaticCallBehaviorImpl.JSON_PROPERTY_TYPE,
  StaticCallBehaviorImpl.JSON_PROPERTY_STATIC
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StaticCallBehaviorImpl implements StaticCallBehavior, CallBehavior {
  private static final long serialVersionUID = 1L;

  /** The type property. Must have the value <code>STATIC</code>. */
  public static class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** Calls are handled using predefined static SVAML commands. */
    public static final TypeEnum STATIC = new TypeEnum("STATIC");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(STATIC));

    private TypeEnum(String value) {
      super(value);
    }

    public static java.util.stream.Stream<TypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_STATIC = "static";

  private OptionalValue<SvamlInput> _static;

  public StaticCallBehaviorImpl() {}

  protected StaticCallBehaviorImpl(
      OptionalValue<TypeEnum> type, OptionalValue<SvamlInput> _static) {
    this.type = type;
    this._static = _static;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public SvamlInput getStatic() {
    return _static.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATIC)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<SvamlInput> _static() {
    return _static;
  }

  /** Return true if this StaticCallBehavior object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StaticCallBehaviorImpl staticCallBehavior = (StaticCallBehaviorImpl) o;
    return Objects.equals(this.type, staticCallBehavior.type)
        && Objects.equals(this._static, staticCallBehavior._static);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, _static);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StaticCallBehaviorImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    _static: ").append(toIndentedString(_static)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements StaticCallBehavior.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.STATIC);
    OptionalValue<SvamlInput> _static = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.STATIC)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.STATIC, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_STATIC, required = true)
    public Builder setStatic(SvamlInput _static) {
      this._static = OptionalValue.of(_static);
      return this;
    }

    public StaticCallBehavior build() {
      return new StaticCallBehaviorImpl(type, _static);
    }
  }
}
