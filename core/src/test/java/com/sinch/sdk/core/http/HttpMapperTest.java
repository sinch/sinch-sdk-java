package com.sinch.sdk.core.http;

import static com.sinch.sdk.core.http.HttpContentType.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.models.OptionalValue;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HttpMapperTest {

  final HttpMapper mapper = HttpMapper.getInstance();

  @Test
  void deserializeNullResponse() throws ApiException {
    TypeReference<String> returnType = new TypeReference<String>() {};

    Assertions.assertThat(mapper.deserialize(null, returnType)).isNull();
  }

  @Test
  void deserializeNullReference() throws ApiException {

    HttpResponse httpResponse = new HttpResponse(-100, null, null, null);
    Assertions.assertThat(mapper.deserialize(httpResponse, (TypeReference<String>) null)).isNull();
  }

  @Test
  void deserializeNoContentType() throws ApiException {

    DefaultSerialization value = new DefaultSerialization("my value");
    HttpResponse httpResponse =
        new HttpResponse(
            -100, "a message", null, "{\"value\": \"my value\"}".getBytes(StandardCharsets.UTF_8));

    Assertions.assertThat(
            mapper.deserialize(httpResponse, new TypeReference<DefaultSerialization>() {}))
        .usingRecursiveComparison()
        .isEqualTo(value);
  }

  @Test
  void deserializeJsonContentType() throws ApiException {

    DefaultSerialization value = new DefaultSerialization("my value");
    HttpResponse httpResponse =
        new HttpResponse(
            -100,
            "a message",
            Stream.of(new String[][] {{CONTENT_TYPE_HEADER, APPLICATION_JSON}})
                .collect(
                    Collectors.toMap(data -> data[0], data -> Collections.singletonList(data[1]))),
            "{\"value\": \"my value\"}".getBytes(StandardCharsets.UTF_8));

    Assertions.assertThat(
            mapper.deserialize(httpResponse, new TypeReference<DefaultSerialization>() {}))
        .usingRecursiveComparison()
        .isEqualTo(value);
  }

  @Test
  void deserializeTextContentType() throws ApiException {

    HttpResponse httpResponse =
        new HttpResponse(
            -100,
            "a message",
            Stream.of(new String[][] {{CONTENT_TYPE_HEADER, TEXT_PLAIN}})
                .collect(
                    Collectors.toMap(data -> data[0], data -> Collections.singletonList(data[1]))),
            "my text plain content".getBytes(StandardCharsets.UTF_8));

    Assertions.assertThat(mapper.deserialize(httpResponse, new TypeReference<String>() {}))
        .isEqualTo("my text plain content");
  }

  @Test
  void serializeDefaultJSON() throws ApiException {

    DefaultSerialization value = new DefaultSerialization("to deserialized");

    Assertions.assertThat(mapper.serialize(null, value))
        .isEqualTo("{\"value\":\"to deserialized\"}");
  }

  @Test
  void serializeUninitializedRequiredWithDefinedGetter() throws ApiException {

    UninitializedFilterSerializationWithDefinedGetter value =
        new UninitializedFilterSerializationWithDefinedGetter().setRequired("my required value");

    Assertions.assertThat(mapper.serialize(null, value))
        .isEqualTo("{\"required\":\"my required value\"}");
  }

  @Test
  void serializeUninitializedRequiredUndefinedWithDefinedGetter() throws ApiException {

    UninitializedFilterSerializationWithDefinedGetter value =
        new UninitializedFilterSerializationWithDefinedGetter();

    ApiException thrown =
        assertThrows(
            ApiException.class,
            () -> mapper.serialize(null, value),
            "Expected mapper.serialize() to throw, but it didn't");

    assertTrue(thrown.getMessage().contains("Required property 'required' was not set"));
  }

  @Test
  void serializeUninitializedRequiredWithNullWithDefinedGetter() throws ApiException {

    UninitializedFilterSerializationWithDefinedGetter value =
        new UninitializedFilterSerializationWithDefinedGetter().setRequired(null);

    Assertions.assertThat(mapper.serialize(null, value)).isEqualTo("{\"required\":null}");
  }

  @Test
  void serializeUninitializedOptionalWithDefinedGetter() throws ApiException {

    UninitializedFilterSerializationWithDefinedGetter value =
        new UninitializedFilterSerializationWithDefinedGetter()
            .setRequired("my required value")
            .setOptional("my optional value");

    Assertions.assertThat(mapper.serialize(null, value))
        .isEqualTo("{\"required\":\"my required value\",\"optional\":\"my optional value\"}");
  }

  @Test
  void serializeUninitializedOptionalWithNullWithDefinedGetter() throws ApiException {

    UninitializedFilterSerializationWithDefinedGetter value =
        new UninitializedFilterSerializationWithDefinedGetter()
            .setRequired("my required value")
            .setOptional(null);

    Assertions.assertThat(mapper.serialize(null, value))
        .isEqualTo("{\"required\":\"my required value\",\"optional\":null}");
  }

  @Test
  void serializeUninitializedRequiredWithOptionalValueGetter() throws ApiException {

    UninitializedFilterSerializationWithOptionalValueGetter value =
        new UninitializedFilterSerializationWithOptionalValueGetter()
            .setRequired("my required value");

    Assertions.assertThat(mapper.serialize(null, value))
        .isEqualTo("{\"required\":\"my required value\"}");
  }

  @Test
  void serializeUninitializedRequiredUndefinedWithOptionalValueGetter() throws ApiException {

    UninitializedFilterSerializationWithOptionalValueGetter value =
        new UninitializedFilterSerializationWithOptionalValueGetter();

    ApiException thrown =
        assertThrows(
            ApiException.class,
            () -> mapper.serialize(null, value),
            "Expected mapper.serialize() to throw, but it didn't");

    assertTrue(thrown.getMessage().contains("Required property 'required' was not set"));
  }

  @Test
  void serializeUninitializedRequiredWithNullWithOptionalValueGetter() throws ApiException {

    UninitializedFilterSerializationWithOptionalValueGetter value =
        new UninitializedFilterSerializationWithOptionalValueGetter().setRequired(null);

    Assertions.assertThat(mapper.serialize(null, value)).isEqualTo("{\"required\":null}");
  }

  @Test
  void serializeUninitializedOptionalWithOptionalValueGetter() throws ApiException {

    UninitializedFilterSerializationWithOptionalValueGetter value =
        new UninitializedFilterSerializationWithOptionalValueGetter()
            .setRequired("my required value")
            .setOptional("my optional value");

    Assertions.assertThat(mapper.serialize(null, value))
        .isEqualTo("{\"required\":\"my required value\",\"optional\":\"my optional value\"}");
  }

  @Test
  void serializeUninitializedOptionalWithNullWithOptionalValueGetter() throws ApiException {

    UninitializedFilterSerializationWithOptionalValueGetter value =
        new UninitializedFilterSerializationWithOptionalValueGetter()
            .setRequired("my required value")
            .setOptional(null);

    Assertions.assertThat(mapper.serialize(null, value))
        .isEqualTo("{\"required\":\"my required value\",\"optional\":null}");
  }

  @Test
  void serializeHashMap() throws ApiException {

    HashMapSerialization value = new HashMapSerialization();
    value.put("my key", "my value");
    Assertions.assertThat(mapper.serialize(null, value)).isEqualTo("{\"my key\":\"my value\"}");
  }

  @Test
  void deserializeOffsetDateTimeWithoutTZ() throws ApiException {

    String date = "2024-01-05T08:23:28";
    // DefaultSerialization value = new DefaultSerialization("my value");
    String jsonValue =
        String.format(" { \"" + DatesClass.JSON_PROPERTY_OFFSETDATETIME + "\" : \"" + date + "\"}");
    HttpResponse httpResponse =
        new HttpResponse(-100, null, null, jsonValue.getBytes(StandardCharsets.UTF_8));

    DatesClass value = mapper.deserialize(httpResponse, new TypeReference<DatesClass>() {});
    Assertions.assertThat(value.getOffsetDateTime()).isEqualTo(date + "Z");
  }

  @Test
  void deserializeOffsetDateTimeWithTZ() throws ApiException {

    String date = "2024-01-05T08:23:28Z";
    // DefaultSerialization value = new DefaultSerialization("my value");
    String jsonValue =
        String.format(" { \"" + DatesClass.JSON_PROPERTY_OFFSETDATETIME + "\" : \"" + date + "\"}");
    HttpResponse httpResponse =
        new HttpResponse(-100, null, null, jsonValue.getBytes(StandardCharsets.UTF_8));

    DatesClass value = mapper.deserialize(httpResponse, new TypeReference<DatesClass>() {});
    Assertions.assertThat(value.getOffsetDateTime()).isEqualTo(date);
  }

  public static class DatesClass {

    public static final String JSON_PROPERTY_OFFSETDATETIME = "offsetdatetime";
    private OffsetDateTime offsetdatetime;

    @JsonCreator
    public DatesClass() {}

    @JsonProperty(JSON_PROPERTY_OFFSETDATETIME)
    public OffsetDateTime getOffsetDateTime() {
      return offsetdatetime;
    }

    @JsonProperty(JSON_PROPERTY_OFFSETDATETIME)
    public DatesClass setOffsetDateTime(OffsetDateTime value) {
      this.offsetdatetime = value;
      return this;
    }
  }

  @JsonFilter("uninitializedFilter")
  @JsonInclude(value = JsonInclude.Include.CUSTOM)
  public static class UninitializedFilterSerializationWithDefinedGetter {

    public static final String JSON_PROPERTY_REQUIRED = "required";
    public static final String JSON_PROPERTY_OPTIONAL = "optional";
    private String required;
    private boolean requiredDefined = false;
    private String optional;
    private boolean optionalDefined = false;

    @JsonCreator
    public UninitializedFilterSerializationWithDefinedGetter() {}

    @JsonProperty(JSON_PROPERTY_REQUIRED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getRequired() {
      return required;
    }

    @JsonProperty(JSON_PROPERTY_REQUIRED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public UninitializedFilterSerializationWithDefinedGetter setRequired(String value) {
      this.required = value;
      this.requiredDefined = true;
      return this;
    }

    @JsonIgnore
    public boolean getRequiredDefined() {
      return requiredDefined;
    }

    @JsonProperty(JSON_PROPERTY_OPTIONAL)
    public String getOptional() {
      return optional;
    }

    @JsonProperty(JSON_PROPERTY_OPTIONAL)
    public UninitializedFilterSerializationWithDefinedGetter setOptional(String value) {
      this.optional = value;
      this.optionalDefined = true;
      return this;
    }

    @JsonIgnore
    public boolean getOptionalDefined() {
      return optionalDefined;
    }
  }

  @JsonFilter("uninitializedFilter")
  @JsonInclude(value = JsonInclude.Include.CUSTOM)
  public static class UninitializedFilterSerializationWithOptionalValueGetter {

    public static final String JSON_PROPERTY_REQUIRED = "required";
    public static final String JSON_PROPERTY_OPTIONAL = "optional";
    private OptionalValue<String> required = OptionalValue.empty();
    private OptionalValue<String> optional = OptionalValue.empty();

    @JsonCreator
    public UninitializedFilterSerializationWithOptionalValueGetter() {}

    @JsonIgnore
    public String getRequired() {
      return required.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_REQUIRED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public UninitializedFilterSerializationWithOptionalValueGetter setRequired(String value) {
      this.required = OptionalValue.of(value);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REQUIRED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public OptionalValue<String> required() {
      return required;
    }

    @JsonIgnore
    public String getOptional() {
      return optional.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_OPTIONAL)
    public UninitializedFilterSerializationWithOptionalValueGetter setOptional(String value) {
      this.optional = OptionalValue.of(value);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OPTIONAL)
    public OptionalValue<String> optional() {
      return optional;
    }
  }

  @JsonFilter("uninitializedFilter")
  @JsonInclude(value = JsonInclude.Include.CUSTOM)
  public static class HashMapSerialization extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;
  }

  public static class DefaultSerialization {

    public static final String JSON_PROPERTY = "value";
    private String value;

    public DefaultSerialization() {}

    public DefaultSerialization(String value) {
      this.value = value;
    }

    @JsonProperty(JSON_PROPERTY)
    public String getValue() {
      return value;
    }

    @JsonProperty(JSON_PROPERTY)
    public void setValue(String value) {
      this.value = value;
    }
  }
}
