package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.MailgunContext;
import com.sinch.sdk.models.MailgunCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MailgunService implements com.sinch.sdk.domains.mailgun.api.v1.MailgunService {

  private static final Logger LOGGER = Logger.getLogger(MailgunService.class.getName());
  private static final String SECURITY_SCHEME_KEYWORD_NUMBERS = "basicAuth";

  private final MailgunContext context;
  private final HttpClient httpClient;

  private final Map<String, AuthManager> authManagers;

  private EmailsService emails;

  public MailgunService(
      MailgunCredentials credentials, MailgunContext context, HttpClient httpClient) {

    Objects.requireNonNull(credentials, "Mailgun service require credentials to be defined");
    Objects.requireNonNull(context, "Mailgun service requires context to be defined");
    StringUtil.requireNonEmpty(
        credentials.getApiUser(), "Mailgun service requires 'apiUser' to be defined");
    StringUtil.requireNonEmpty(
        credentials.getApiKey(), "Mailgun service requires 'apiKey' to be defined");
    StringUtil.requireNonEmpty(context.getUrl(), "'Mailgun service requires 'url' to be defined");

    LOGGER.fine("Activate Mailgun API with server='" + context.getServer().getUrl() + "'");

    this.context = context;
    this.httpClient = httpClient;

    AuthManager basicAuthManager =
        new BasicAuthManager(credentials.getApiUser(), credentials.getApiKey());

    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_NUMBERS, basicAuthManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  public EmailsService emails() {
    if (null == this.emails) {
      this.emails = new EmailsService(context, httpClient, authManagers);
    }
    return this.emails;
  }
}
