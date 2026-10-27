package com.sinch.sdk.core.http.transport;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.utils.databind.Mapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Content of an HTTP response, fully loaded in memory.
 *
 * @since 2.4
 */
public final class BufferedHttpContentParser implements HttpContentParser {

  private static final Logger LOGGER = Logger.getLogger(BufferedHttpContentParser.class.getName());

  private final byte[] content;
  private final Charset charset;

  /**
   * @param content Bytes received, <code>null</code> when the response has no content
   * @param contentType Value of the <code>content-type</code> header, <code>null</code> when absent
   * @since 2.4
   */
  public BufferedHttpContentParser(byte[] content, String contentType) {
    this.content = null == content ? new byte[0] : content;
    this.charset = charsetOf(contentType);
  }

  @Override
  public String asString() {
    return new String(content, charset);
  }

  @Override
  public byte[] asBytes() {
    return content.clone();
  }

  @Override
  public Map<String, Object> asMap() throws ApiException {
    if (0 == content.length) {
      return Collections.emptyMap();
    }
    JsonNode node;
    try {
      node = Mapper.getInstance().readTree(asString());
    } catch (IOException e) {
      throw new ApiException("Response content is not valid JSON: " + e.getMessage(), e);
    }
    if (null == node || node.isMissingNode()) {
      return Collections.emptyMap();
    }
    if (!node.isObject()) {
      throw new ApiException("Response content is not a JSON object but " + node.getNodeType());
    }
    return Mapper.getInstance().convertValue(node, new TypeReference<Map<String, Object>>() {});
  }

  @Override
  public InputStream asStream() {
    return new ByteArrayInputStream(content);
  }

  private static Charset charsetOf(String contentType) {
    return HttpContentType.getCharsetValue(contentType)
        .flatMap(
            name -> {
              try {
                return Optional.of(Charset.forName(name.replace("\"", "")));
              } catch (IllegalArgumentException e) {
                LOGGER.fine("Unsupported response charset '" + name + "', falling back to UTF-8");
                return Optional.empty();
              }
            })
        .orElse(StandardCharsets.UTF_8);
  }

  @Override
  public String toString() {
    return "BufferedHttpContentParser{" + "length=" + content.length + ", charset=" + charset + '}';
  }
}
