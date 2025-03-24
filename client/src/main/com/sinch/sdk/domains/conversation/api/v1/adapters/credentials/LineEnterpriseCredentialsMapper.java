package com.sinch.sdk.domains.conversation.api.v1.adapters.credentials;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.credentials.LineEnterpriseCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.LineEnterpriseCredentialsJapan;
import com.sinch.sdk.domains.conversation.models.v1.credentials.LineEnterpriseCredentialsThailand;
import com.sinch.sdk.domains.conversation.models.v1.credentials.internal.LineEnterpriseCredentialsDetailsInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.credentials.internal.LineEnterpriseCredentialsInternalImpl;
import java.io.IOException;
import java.util.logging.Logger;

public class LineEnterpriseCredentialsMapper {

  private static final Logger LOGGER =
      Logger.getLogger(LineEnterpriseCredentialsMapper.class.getName());

  public static void initMapper() {

    SimpleModule module =
        new SimpleModule().addDeserializer(LineEnterpriseCredentials.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<LineEnterpriseCredentials> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<LineEnterpriseCredentials> vc) {
      super(vc);
    }

    @Override
    public LineEnterpriseCredentials deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      LineEnterpriseCredentialsInternalImpl deserialized =
          jp.readValueAs(LineEnterpriseCredentialsInternalImpl.class);

      if (deserialized.lineJapan().isPresent()) {
        LineEnterpriseCredentialsJapan.Builder builder = LineEnterpriseCredentialsJapan.builder();
        convert(
            builder,
            deserialized,
            (LineEnterpriseCredentialsDetailsInternalImpl) deserialized.getLineJapan());
        return builder.build();
      }
      if (deserialized.lineThailand().isPresent()) {
        LineEnterpriseCredentialsThailand.Builder builder =
            LineEnterpriseCredentialsThailand.builder();
        convert(
            builder,
            deserialized,
            (LineEnterpriseCredentialsDetailsInternalImpl) deserialized.getLineThailand());
        return builder.build();
      }

      LOGGER.severe("Unexpected class '" + deserialized + "'");
      return null;
    }
  }

  static void convert(
      LineEnterpriseCredentials.Builder builder,
      LineEnterpriseCredentialsInternalImpl object,
      LineEnterpriseCredentialsDetailsInternalImpl details) {
    details.secret().ifPresent(builder::setSecret);
    details.token().ifPresent(builder::setToken);
    object.isDefault().ifPresent(builder::setIsDefault);
  }
}
