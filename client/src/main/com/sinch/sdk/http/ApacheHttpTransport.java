package com.sinch.sdk.http;

import static com.sinch.sdk.core.http.HttpContentType.CONTENT_TYPE_HEADER;

import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.transport.BufferedHttpContentParser;
import com.sinch.sdk.core.http.transport.HttpContent;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpRequest;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.core.http.transport.HttpTransport;
import com.sinch.sdk.models.HttpProxyConfiguration;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.CredentialsProvider;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.auth.CredentialsProviderBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.impl.routing.DefaultProxyRoutePlanner;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.FileEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.util.Timeout;

/**
 * {@link HttpTransport} based onto Apache HttpClient.
 *
 * <p>Response contents are fully loaded in memory.
 */
class ApacheHttpTransport implements HttpTransport {

  private static final Logger LOGGER = Logger.getLogger(ApacheHttpTransport.class.getName());

  private volatile CloseableHttpClient client;

  /**
   * @param proxyConfiguration Proxy to route through, or {@code null} for a direct connection
   * @param timeoutSeconds Timeout applied to I/O operations, zero to disable it
   */
  ApacheHttpTransport(HttpProxyConfiguration proxyConfiguration, int timeoutSeconds) {
    this.client = buildHttpClient(proxyConfiguration, timeoutSeconds);
  }

  private static CloseableHttpClient buildHttpClient(
      HttpProxyConfiguration proxyConfiguration, int timeoutSeconds) {

    Timeout timeout = Timeout.ofSeconds(timeoutSeconds);

    HttpClientBuilder builder =
        HttpClients.custom()
            .disableAutomaticRetries()
            .setDefaultRequestConfig(
                RequestConfig.custom()
                    .setConnectionRequestTimeout(timeout)
                    .setResponseTimeout(timeout)
                    .build())
            .setConnectionManager(
                PoolingHttpClientConnectionManagerBuilder.create()
                    .setDefaultConnectionConfig(
                        ConnectionConfig.custom()
                            .setConnectTimeout(timeout)
                            .setSocketTimeout(timeout)
                            .build())
                    .build());

    if (proxyConfiguration == null) {
      return builder.build();
    }

    HttpHost proxyHost =
        new HttpHost(proxyConfiguration.getHostname(), proxyConfiguration.getPort());
    builder.setRoutePlanner(new DefaultProxyRoutePlanner(proxyHost));

    if (proxyConfiguration.getUsername().isPresent()) {
      // getPassword() returns a defensive copy of the internal array; HC5 receives that copy and
      // owns it for the lifetime of the client. The caller does not need to keep the original
      // alive.
      CredentialsProvider credentialsProvider =
          CredentialsProviderBuilder.create()
              .add(
                  new AuthScope(proxyHost),
                  proxyConfiguration.getUsername().orElse(""),
                  proxyConfiguration.getPassword().orElse(new char[0]))
              .build();
      builder.setDefaultCredentialsProvider(credentialsProvider);
    }
    return builder.build();
  }

  @Override
  public HttpResponse send(HttpRequest request) throws IOException {

    CloseableHttpClient activeClient = this.client;
    if (activeClient == null) {
      throw new IOException("HTTP transport has been closed");
    }

    ClassicRequestBuilder requestBuilder = ClassicRequestBuilder.create(request.getMethod().name());
    requestBuilder.setUri(request.getUrl() + request.getQueryParameters().orElse(""));

    HttpContent content = request.getContent().orElse(null);
    // form data are sent with a content type carrying the boundary of their parts
    boolean formData = content instanceof HttpContent.FormDataContent;
    request
        .getHeaders()
        .forEach(
            (name, value) -> {
              if (!formData || !CONTENT_TYPE_HEADER.equalsIgnoreCase(name)) {
                requestBuilder.addHeader(name, value);
              }
            });

    if (null != content) {
      requestBuilder.setEntity(toEntity(content, request.getHeaders()));
    }

    return activeClient.execute(requestBuilder.build(), ApacheHttpTransport::toResponse);
  }

  private static HttpEntity toEntity(HttpContent content, HttpHeaders headers) {

    if (content instanceof HttpContent.StringContent) {
      return new StringEntity(
          ((HttpContent.StringContent) content).getValue(),
          charsetOf(headers).orElse(StandardCharsets.UTF_8));
    }
    if (content instanceof HttpContent.BytesContent) {
      return new ByteArrayEntity(((HttpContent.BytesContent) content).getValue(), null);
    }
    if (content instanceof HttpContent.FileContent) {
      return new FileEntity(((HttpContent.FileContent) content).getFile(), null);
    }
    if (content instanceof HttpContent.FormDataContent) {
      return toMultiPartEntity((HttpContent.FormDataContent) content, headers);
    }
    throw new IllegalArgumentException("Unsupported content: " + content);
  }

  private static HttpEntity toMultiPartEntity(
      HttpContent.FormDataContent content, HttpHeaders headers) {

    Charset charset = charsetOf(headers).orElse(StandardCharsets.UTF_8);
    MultipartEntityBuilder multiPartBuilder = MultipartEntityBuilder.create().setCharset(charset);
    content
        .getParameters()
        .forEach((name, value) -> addMultiPart(multiPartBuilder, name, value, charset));
    return multiPartBuilder.build();
  }

  private static void addMultiPart(
      MultipartEntityBuilder multiPartBuilder, String name, Object value, Charset charset) {

    if (value instanceof File) {
      multiPartBuilder.addBinaryBody(name, (File) value);
    } else if (value instanceof byte[]) {
      multiPartBuilder.addBinaryBody(name, (byte[]) value);
    } else if (value instanceof Collection) {
      ((Collection<?>) value).forEach(item -> addMultiPart(multiPartBuilder, name, item, charset));
    } else {
      multiPartBuilder.addTextBody(
          name,
          String.valueOf(value),
          ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
    }
  }

  private static Optional<Charset> charsetOf(HttpHeaders headers) {
    return headers.getAll(CONTENT_TYPE_HEADER).stream()
        .filter(value -> value.contains("charset="))
        .findFirst()
        .flatMap(HttpContentType::getCharsetValue)
        .map(Charset::forName);
  }

  private static HttpResponse toResponse(ClassicHttpResponse response) throws IOException {

    HttpHeaders headers = new HttpHeaders();
    for (Header header : response.getHeaders()) {
      headers.add(header.getName(), header.getValue());
    }
    LOGGER.finest("response: " + response.getCode() + ", headers:" + headers);

    HttpEntity entity = response.getEntity();
    byte[] content = null == entity ? null : EntityUtils.toByteArray(entity);

    return new HttpResponse(
        response.getCode(),
        response.getReasonPhrase(),
        headers,
        new BufferedHttpContentParser(content, headers.getFirst(CONTENT_TYPE_HEADER).orElse(null)));
  }

  @Override
  public void close() throws IOException {
    if (null != client) {
      synchronized (this) {
        CloseableHttpClient local = client;
        client = null;
        if (local != null) {
          local.close();
        }
      }
    }
  }
}
