package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.Objects;

@JsonPropertyOrder({SayMessageImpl.JSON_PROPERTY_TYPE, SayMessageImpl.JSON_PROPERTY_SAY})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SayMessageImpl implements SayMessage, Message {
  private static final long serialVersionUID = 1L;

  /** The type property. Must have the value <code>SAY</code>. */
  public static class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>SAY</code> type. */
    public static final TypeEnum SAY = new TypeEnum("SAY");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(SAY));

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

  public static final String JSON_PROPERTY_SAY = "say";

  private OptionalValue<Say> say;

  public SayMessageImpl() {}

  protected SayMessageImpl(OptionalValue<TypeEnum> type, OptionalValue<Say> say) {
    this.type = type;
    this.say = say;
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
  public Say getSay() {
    return say.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SAY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Say> say() {
    return say;
  }

  /** Return true if this SayMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SayMessageImpl sayMessage = (SayMessageImpl) o;
    return Objects.equals(this.type, sayMessage.type) && Objects.equals(this.say, sayMessage.say);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, say);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SayMessageImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    say: ").append(toIndentedString(say)).append("\n");
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
  static class Builder implements SayMessage.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.SAY);
    OptionalValue<Say> say = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.SAY)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.SAY, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SAY, required = true)
    public Builder setSay(Say say) {
      this.say = OptionalValue.of(say);
      return this;
    }

    public SayMessage build() {
      return new SayMessageImpl(type, say);
    }
  }
}
