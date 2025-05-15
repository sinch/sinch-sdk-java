package com.sinch.sdk.domains.conversation.templates.models.v2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.TemplateReference;
import com.sinch.sdk.domains.conversation.models.v1.TemplateReferenceImpl;

public class ChannelTemplateOverrideMapper {

  public static void initMapper() {

    Mapper.getInstance()
        .addMixIn(ChannelTemplateOverride.class, ChannelTemplateOverrideMixinSerializer.class)
        .addMixIn(
            ChannelTemplateOverride.Builder.class,
            ChannelTemplateOverrideBuilderMixinSerializer.class);
  }

  static class ChannelTemplateOverrideMixinSerializer extends ChannelTemplateOverrideImpl {

    @Override
    @JsonSerialize(using = TemplateReferenceImpl.DelegatedSerializer.class)
    public OptionalValue<TemplateReference> templateReference() {
      return super.templateReference();
    }
  }

  static class ChannelTemplateOverrideBuilderMixinSerializer
      extends ChannelTemplateOverrideImpl.Builder {

    @Override
    @JsonDeserialize(using = TemplateReferenceImpl.DelegatedDeSerializer.class)
    public ChannelTemplateOverrideImpl.Builder setTemplateReference(
        TemplateReference templateReference) {
      return super.setTemplateReference(templateReference);
    }
  }
}
