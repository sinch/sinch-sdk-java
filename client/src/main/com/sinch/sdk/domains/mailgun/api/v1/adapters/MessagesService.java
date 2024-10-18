package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.MailgunContext;
import java.util.Map;

public class MessagesService implements com.sinch.sdk.domains.mailgun.api.v1.MessagesService {

  public MessagesService(
      MailgunContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {}
}
