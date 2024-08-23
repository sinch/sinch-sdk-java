package com.sinch.sample.conversation.templates.v2;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.templates.v2.TemplatesServiceV2;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.templates.models.TemplateVariable;
import com.sinch.sdk.domains.conversation.templates.models.v2.ChannelTemplateOverride;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslation;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

public class Update extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public Update() throws IOException {}

  public static void main(String[] args) {
    try {
      new Update().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesServiceV2 service = client.conversation().templates().v2();

    TemplateV2 current = service.get(conversationTemplateId);

    TemplateV2 request =
        TemplateV2.builder()
            .setVersion(current.getVersion())
            .setDescription("Updated description from V2 API")
            .setDefaultTranslation("fr-FR")
            .setTranslations(
                Collections.singletonList(
                    TemplateTranslation.builder()
                        .setVersion("1")
                        .setLanguageCode("fr-FR")
                        .setMessage(TextMessage.builder().setText("my text from template").build())
                        .setVariables(
                            Arrays.asList(
                                TemplateVariable.builder()
                                    .setKey("they key1")
                                    .setPreviewValue("foo1")
                                    .build(),
                                TemplateVariable.builder()
                                    .setKey("they key2")
                                    .setPreviewValue("foo2")
                                    .build()))
                        .setChannelTemplateOverrides(
                            Collections.singletonMap(
                                ConversationChannel.WHATSAPP,
                                ChannelTemplateOverride.builder()
                                    .setParameterMappings(
                                        Collections.singletonMap("they key1", "they key2"))
                                    .build()))
                        .build()))
            .build();

    LOGGER.info("Update template: " + request);
    TemplateV2 result = service.update(conversationTemplateId, request);
    LOGGER.info("Response: " + result);
  }
}
