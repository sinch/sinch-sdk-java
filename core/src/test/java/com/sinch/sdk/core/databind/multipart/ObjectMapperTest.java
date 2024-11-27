package com.sinch.sdk.core.databind.multipart;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.databind.FormSerializer;
import com.sinch.sdk.core.databind.annotation.FormSerialize;
import com.sinch.sdk.core.databind.annotation.PropertiesOrder;
import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.databind.multipart.ObjectMapperTest.SerializableObject.AnEnum;
import com.sinch.sdk.core.models.AdditionalProperties;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.core.utils.databind.RFC822FormSerializer;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequestTest;
import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectMapperTest {

  static File fileAttachment1;
  static File fileAttachment2;

  static Map<String, Object> serialized, defaultAdditionalPropertiesSerialized;

  static {
    ClassLoader classLoader = SendEmailRequestTest.class.getClassLoader();
    fileAttachment1 =
        new File(
            classLoader.getResource("domains/mailgun/v1/emails/request/attachment1.txt").getFile());
    fileAttachment2 =
        new File(
            classLoader.getResource("domains/mailgun/v1/emails/request/attachment2.txt").getFile());

    Map<String, Object> additionalProperties =
        fillMap("header:toto", "toto-value", "variable:foo", "foo-value", "raw", "raw-value");

    SerializableObject object =
        new SerializableObject(
            OptionalValue.of("text value"),
            OptionalValue.of(AnEnum.from("a dyn value")),
            OptionalValue.of(fileAttachment1),
            OptionalValue.of(Instant.parse("2024-11-25T09:06:54Z")),
            OptionalValue.of(Arrays.asList("text 1", "text2")),
            OptionalValue.of(Arrays.asList(AnEnum.from("a dyn value"), AnEnum.YES)),
            OptionalValue.of(Arrays.asList(fileAttachment1, fileAttachment2)),
            OptionalValue.of(
                Arrays.asList(
                    Instant.parse("2024-11-25T10:06:54Z"), Instant.parse("2024-11-25T09:06:54Z"))),
            additionalProperties);

    DefaultAdditionalPropertiesSerializableObject defaultAdditionalPropertiesSerializableObject =
        new DefaultAdditionalPropertiesSerializableObject(additionalProperties);

    try {
      serialized = new ObjectMapper().serialize(object);
      defaultAdditionalPropertiesSerialized =
          new ObjectMapper().serialize(defaultAdditionalPropertiesSerializableObject);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void countValue() {
    Assertions.assertEquals(11, serialized.size());
  }

  @Test
  void order() {

    String[] expectedOrder = {
      SerializableObject.PROPERTY_RFC822_COLLECTION,
      SerializableObject.PROPERTY_TEXT,
      SerializableObject.PROPERTY_FILE_COLLECTION,
      SerializableObject.PROPERTY_RFC822,
      SerializableObject.PROPERTY_FILE,
      SerializableObject.PROPERTY_ENUM,
      SerializableObject.PROPERTY_ENUM_COLLECTION,
      SerializableObject.PROPERTY_TEXT_COLLECTION,
      "h:toto",
      "v:foo",
      "raw"
    };
    String[] keys = serialized.keySet().toArray(new String[0]);
    TestHelpers.recursiveEquals(expectedOrder, keys);
  }

  @Test
  void textValue() {
    TestHelpers.recursiveEquals("text value", serialized.get("aText"));
  }

  @Test
  void enumValue() {
    TestHelpers.recursiveEquals("a dyn value", serialized.get("anEnum"));
  }

  @Test
  void fileValue() {
    TestHelpers.recursiveEquals(fileAttachment1, serialized.get("aFile"));
  }

  @Test
  void rfc822Value() {
    TestHelpers.recursiveEquals("Mon, 25 Nov 2024 09:06:54 GMT", serialized.get("aRfc822"));
  }

  @Test
  void textCollectionValue() {
    TestHelpers.recursiveEquals(
        Arrays.asList("text 1", "text2"), serialized.get("aTextCollection"));
  }

  @Test
  void enumCollectionValue() {
    TestHelpers.recursiveEquals(
        Arrays.asList(AnEnum.from("a dyn value"), AnEnum.YES), serialized.get("anEnumCollection"));
  }

  @Test
  void fileCollectionValue() {
    TestHelpers.recursiveEquals(
        Arrays.asList(fileAttachment1, fileAttachment2), serialized.get("aFileCollection"));
  }

  @Test
  void rfc822CollectionValue() {
    TestHelpers.recursiveEquals(
        new ArrayList<>(
            Arrays.asList("Mon, 25 Nov 2024 10:06:54 GMT", "Mon, 25 Nov 2024 09:06:54 GMT")),
        serialized.get("aRfc822Collection"));
  }

  @Test
  void additionalPropertiesValues() {
    Assertions.assertEquals("toto-value", serialized.get("h:toto"));
    Assertions.assertEquals("foo-value", serialized.get("v:foo"));
    Assertions.assertEquals("raw-value", serialized.get("raw"));
  }

  @Test
  void defaultAdditionalPropertiesValues() {
    TestHelpers.recursiveEquals(
        fillMap("header:toto", "toto-value", "variable:foo", "foo-value", "raw", "raw-value"),
        defaultAdditionalPropertiesSerialized);
  }

  @PropertiesOrder({
    SerializableObject.PROPERTY_RFC822_COLLECTION,
    SerializableObject.PROPERTY_TEXT,
    SerializableObject.PROPERTY_FILE_COLLECTION,
    SerializableObject.PROPERTY_RFC822,
    SerializableObject.PROPERTY_FILE,
    SerializableObject.PROPERTY_ENUM,
    SerializableObject.PROPERTY_ENUM_COLLECTION,
    SerializableObject.PROPERTY_RFC822_COLLECTION,
    SerializableObject.PROPERTY_TEXT_COLLECTION
  })
  static class SerializableObject implements AdditionalProperties {
    public static final String PROPERTY_TEXT = "aText";
    public static final String PROPERTY_ENUM = "anEnum";
    public static final String PROPERTY_FILE = "aFile";
    public static final String PROPERTY_RFC822 = "aRfc822";

    public static final String PROPERTY_TEXT_COLLECTION = "aTextCollection";
    public static final String PROPERTY_ENUM_COLLECTION = "anEnumCollection";
    public static final String PROPERTY_FILE_COLLECTION = "aFileCollection";
    public static final String PROPERTY_RFC822_COLLECTION = "aRfc822Collection";

    private final OptionalValue<String> text;
    private final OptionalValue<AnEnum> _enum;
    private final OptionalValue<File> file;
    private final OptionalValue<Instant> instant;

    private final OptionalValue<Collection<String>> textCollection;
    private final OptionalValue<Collection<AnEnum>> enumCollection;
    private final OptionalValue<Collection<File>> fileCollection;
    private final OptionalValue<Collection<Instant>> instantCollection;
    private final Map<String, Object> additionalProperties;

    public SerializableObject(
        OptionalValue<String> text,
        OptionalValue<AnEnum> _enum,
        OptionalValue<File> file,
        OptionalValue<Instant> instant,
        OptionalValue<Collection<String>> textCollection,
        OptionalValue<Collection<AnEnum>> enumCollection,
        OptionalValue<Collection<File>> fileCollection,
        OptionalValue<Collection<Instant>> instantCollection,
        Map<String, Object> additionalProperties) {
      this.text = text;
      this._enum = _enum;
      this.file = file;
      this.instant = instant;
      this.instantCollection = instantCollection;
      this.textCollection = textCollection;
      this.enumCollection = enumCollection;
      this.fileCollection = fileCollection;
      this.additionalProperties = additionalProperties;
    }

    @Property(PROPERTY_TEXT)
    public OptionalValue<String> text() {
      return text;
    }

    @Property(PROPERTY_ENUM)
    public OptionalValue<AnEnum> _enum() {
      return _enum;
    }

    @Property(PROPERTY_FILE)
    public OptionalValue<File> file() {
      return file;
    }

    @Property(PROPERTY_RFC822)
    @FormSerialize(using = RFC822FormSerializer.class)
    public OptionalValue<Instant> instant() {
      return instant;
    }

    @Property(PROPERTY_TEXT_COLLECTION)
    public OptionalValue<Collection<String>> textCollection() {
      return textCollection;
    }

    @Property(PROPERTY_ENUM_COLLECTION)
    public OptionalValue<Collection<AnEnum>> enumCollection() {
      return enumCollection;
    }

    @Property(PROPERTY_FILE_COLLECTION)
    public OptionalValue<Collection<File>> fileCollection() {
      return fileCollection;
    }

    @Property(PROPERTY_RFC822_COLLECTION)
    @FormSerialize(using = RFC822ListFormSerializer.class)
    public OptionalValue<Collection<Instant>> instantCollection() {
      return instantCollection;
    }

    @FormSerialize(using = AdditionalPropertiesFormSerializer.class)
    public Map<String, Object> additionalProperties() {
      return additionalProperties;
    }

    public Object get(String key) {
      return null;
    }

    public Set<String> keys() {
      return additionalProperties.keySet();
    }

    public static class AnEnum extends EnumDynamic<String, AnEnum> {
      public static final AnEnum YES = new AnEnum("yes");
      public static final AnEnum NO = new AnEnum("no");

      private static final EnumSupportDynamic<String, AnEnum> ENUM_SUPPORT =
          new EnumSupportDynamic<>(AnEnum.class, AnEnum::new, Arrays.asList(YES, NO));

      private AnEnum(String value) {
        super(value);
      }

      public static Stream<AnEnum> values() {
        return ENUM_SUPPORT.values();
      }

      public static AnEnum from(String value) {
        return ENUM_SUPPORT.from(value);
      }

      public static String valueOf(AnEnum e) {
        return ENUM_SUPPORT.valueOf(e);
      }
    }
  }

  static class DefaultAdditionalPropertiesSerializableObject implements AdditionalProperties {
    private final Map<String, Object> additionalProperties;

    public DefaultAdditionalPropertiesSerializableObject(Map<String, Object> additionalProperties) {
      this.additionalProperties = additionalProperties;
    }

    public Map<String, Object> additionalProperties() {
      return additionalProperties;
    }

    public Object get(String key) {
      return null;
    }

    public Set<String> keys() {
      return additionalProperties.keySet();
    }
  }

  public static class RFC822ListFormSerializer extends FormSerializer<Collection<Instant>> {

    @Override
    public void serialize(Collection<Instant> in, String fieldName, Map<String, Object> out) {
      out.put(
          fieldName,
          in.stream()
              .map(
                  instant ->
                      DateTimeFormatter.RFC_1123_DATE_TIME.format(instant.atZone(ZoneId.of("UTC"))))
              .collect(Collectors.toList()));
    }
  }

  public static class AdditionalPropertiesFormSerializer
      extends FormSerializer<Map<Object, Object>> {

    @Override
    public void serialize(Map<Object, Object> in, String fieldName, Map<String, Object> out) {

      in.forEach(
          (_key, value) -> {
            String key =
                ((String) _key).replaceAll("^header:", "h:").replaceAll("^variable:", "v:");
            out.put(key, value);
          });
    }
  }

  public static Map<String, Object> fillMap(Object... pairs) {
    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
    for (int i = 0; i < pairs.length; ) {
      map.put((String) pairs[i++], pairs[i++]);
    }
    return map;
  }
}
