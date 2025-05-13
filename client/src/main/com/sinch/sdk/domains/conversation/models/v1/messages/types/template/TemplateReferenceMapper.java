package com.sinch.sdk.domains.conversation.models.v1.messages.types.template;

import com.sinch.sdk.domains.conversation.models.v1.TemplateReference;
import com.sinch.sdk.domains.conversation.models.v1.TemplateReferenceImpl;
import com.sinch.sdk.domains.conversation.models.v1.internal.TemplateReferenceInternal;
import com.sinch.sdk.domains.conversation.models.v1.internal.TemplateReferenceInternalImpl;

public class TemplateReferenceMapper {

  static TemplateReferenceInternal convert(TemplateReference _from) {
    TemplateReferenceImpl from = (TemplateReferenceImpl) _from;
    TemplateReferenceInternal.Builder builder = TemplateReferenceInternal.builder();
    from.version().ifPresent(builder::setVersion);
    from.languageCode().ifPresent(builder::setLanguageCode);
    from.parameters().ifPresent(builder::setParameters);
    from.templateId().ifPresent(builder::setTemplateId);
    return builder.build();
  }

  static TemplateReference convert(TemplateReferenceInternal _from) {
    TemplateReferenceInternalImpl from = (TemplateReferenceInternalImpl) _from;
    TemplateReference.Builder builder = TemplateReference.builder();
    from.languageCode().ifPresent(builder::setLanguageCode);
    from.parameters().ifPresent(builder::setParameters);
    from.templateId().ifPresent(builder::setTemplateId);
    from.version().ifPresent(builder::setVersion);
    return builder.build();
  }
}
