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
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HttpMapperTest {

  final HttpMapper mapper = new HttpMapper();

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
  void serializeUninitializedRequired() throws ApiException {

    UninitializedFilterSerialization value =
        new UninitializedFilterSerialization().setRequired("my required value");

    Assertions.assertThat(mapper.serialize(null, value))
        .isEqualTo("{\"required\":\"my required value\"}");
  }

  @Test
  void serializeUninitializedRequiredUndefined() throws ApiException {

    UninitializedFilterSerialization value = new UninitializedFilterSerialization();

    ApiException thrown =
        assertThrows(
            ApiException.class,
            () -> mapper.serialize(null, value),
            "Expected mapper.serialize() to throw, but it didn't");

    assertTrue(thrown.getMessage().contains("Required property 'required' was not set"));
  }

  @Test
  void serializeUninitializedRequiredWithNull() throws ApiException {

    UninitializedFilterSerialization value =
        new UninitializedFilterSerialization().setRequired(null);

    Assertions.assertThat(mapper.serialize(null, value)).isEqualTo("{\"required\":null}");
  }

  @Test
  void serializeUninitializedOptional() throws ApiException {

    UninitializedFilterSerialization value =
        new UninitializedFilterSerialization()
            .setRequired("my required value")
            .setOptional("my optional value");

    Assertions.assertThat(mapper.serialize(null, value))
        .isEqualTo("{\"required\":\"my required value\",\"optional\":\"my optional value\"}");
  }

  @Test
  void serializeUninitializedOptionalWithNull() throws ApiException {

    UninitializedFilterSerialization value =
        new UninitializedFilterSerialization().setRequired("my required value").setOptional(null);

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
  public static class UninitializedFilterSerialization {

    public static final String JSON_PROPERTY_REQUIRED = "required";
    private String required;
    private boolean requiredDefined = false;
    public static final String JSON_PROPERTY_OPTIONAL = "optional";
    private String optional;
    private boolean optionalDefined = false;

    @JsonCreator
    public UninitializedFilterSerialization() {}

    @JsonProperty(JSON_PROPERTY_REQUIRED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getRequired() {
      return required;
    }

    @JsonIgnore
    public boolean getRequiredDefined() {
      return requiredDefined;
    }

    @JsonProperty(JSON_PROPERTY_REQUIRED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public UninitializedFilterSerialization setRequired(String value) {
      this.required = value;
      this.requiredDefined = true;
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OPTIONAL)
    public String getOptional() {
      return optional;
    }

    @JsonIgnore
    public boolean getOptionalDefined() {
      return optionalDefined;
    }

    @JsonProperty(JSON_PROPERTY_OPTIONAL)
    public UninitializedFilterSerialization setOptional(String value) {
      this.optional = value;
      this.optionalDefined = true;
      return this;
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
