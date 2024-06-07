package com.sinch.sdk.domains.verification.adapters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal.TypeEnum;
import java.io.IOException;
import java.util.logging.Logger;

public class IdentityMapper {
  private static final Logger LOGGER = Logger.getLogger(IdentityMapper.class.getName());

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule()
            .addSerializer(Identity.class, new Serializer())
            .addDeserializer(Identity.class, new IdentityDeserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Serializer extends StdSerializer<Identity> {

    public Serializer() {
      this(null);
    }

    public Serializer(Class<Identity> t) {
      super(t);
    }

    @Override
    public void serialize(Identity raw, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {
      if (!(raw instanceof NumberIdentity)) {
        // avoid exception
        LOGGER.severe("Unexpected type'" + raw + "'");
        return;
      }
      NumberIdentity identity = (NumberIdentity) raw;
      IdentityInternal.Builder internal =
          IdentityInternal.builder().setType(TypeEnum.NUMBER).setEndpoint(identity.getEndpoint());

      jgen.writeObject(internal.build());
    }
  }

  static final class IdentityDeserializer extends StdDeserializer<Identity> {

    private static final long serialVersionUID = 1L;

    public IdentityDeserializer() {
      this(Identity.class);
    }

    public IdentityDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public Identity deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      IdentityInternal internal = Mapper.getInstance().readValue(jp, IdentityInternal.class);
      if (!internal.getType().equals(TypeEnum.NUMBER)) {
        // avoid exception
        LOGGER.severe("Unexpected type'" + internal + "'");
        return NumberIdentity.valueOf("");
      }
      return NumberIdentity.valueOf(internal.getEndpoint());
    }
  }
}
