package com.sinch.sdk.domains.conversation.models.v1.messages.types.card;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = CardMessageMediaImpl.Builder.class)
public interface MediaMessageBody {}
