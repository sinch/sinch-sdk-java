package com.sinch.sdk.models;

import com.sinch.sdk.core.utils.StringUtil;
import java.util.Arrays;
import java.util.Optional;

/**
 * HTTP proxy configuration for the Sinch SDK HTTP client.
 *
 * <p>Provides a transport-agnostic proxy abstraction. Use {@link Builder} to construct an instance,
 * optionally providing credentials for authenticated proxies.
 *
 * <p><strong>Scheme:</strong> Only plain HTTP proxies are supported. HTTPS-terminating (SSL
 * intercepting) proxies are not. All outbound connections — including OAuth token exchange — are
 * routed through the configured proxy.
 *
 * <pre>{@code
 * // Unauthenticated proxy
 * HttpProxyConfiguration proxy = HttpProxyConfiguration.builder()
 *     .setHostname("proxy.corp.example.com")
 *     .setPort(3128)
 *     .build();
 *
 * // Authenticated proxy
 * HttpProxyConfiguration proxy = HttpProxyConfiguration.builder()
 *     .setHostname("proxy.corp.example.com")
 *     .setPort(3128)
 *     .setUsername("user")
 *     .setPassword("secret")
 *     .build();
 * }</pre>
 *
 * @since 2.1
 */
public class HttpProxyConfiguration {

  private final String hostname;
  private final int port;
  private final String username;
  private final char[] password;

  private HttpProxyConfiguration(String hostname, int port, String username, char[] password) {
    this.hostname = hostname;
    this.port = port;
    this.username = username;
    this.password = password;
  }

  /**
   * Proxy host name or IP address.
   *
   * @return hostname
   * @since 2.1
   */
  public String getHostname() {
    return hostname;
  }

  /**
   * Proxy port number.
   *
   * @return port
   * @since 2.1
   */
  public int getPort() {
    return port;
  }

  /**
   * Proxy username, present only when the proxy requires authentication.
   *
   * @return username, or empty if not configured
   * @since 2.1
   */
  public Optional<String> getUsername() {
    return Optional.ofNullable(username);
  }

  /**
   * Proxy password, present only when the proxy requires authentication.
   *
   * <p>Returns a defensive copy of the internal array. Callers are encouraged to zero the array
   * with {@code Arrays.fill(pwd, '\0')} once they have finished using it.
   *
   * @return password as a char array, or empty if not configured
   * @since 2.1
   */
  public Optional<char[]> getPassword() {
    return password == null
        ? Optional.empty()
        : Optional.of(Arrays.copyOf(password, password.length));
  }

  @Override
  public String toString() {
    return "HttpProxyConfiguration{"
        + "hostname='"
        + hostname
        + '\''
        + ", port="
        + port
        + ", username="
        + (username != null ? "'***'" : "null")
        + ", password="
        + (password != null ? "'***'" : "null")
        + '}';
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 2.1
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Getting Builder pre-populated from an existing instance
   *
   * @param configuration source configuration
   * @return New Builder instance
   * @since 2.1
   */
  public static Builder builder(HttpProxyConfiguration configuration) {
    return new Builder(configuration);
  }

  /**
   * Dedicated Builder
   *
   * @since 2.1
   */
  public static class Builder {

    private String hostname;
    private int port;
    private String username;
    private char[] password;

    protected Builder() {}

    protected Builder(HttpProxyConfiguration configuration) {
      if (null == configuration) {
        return;
      }
      this.hostname = configuration.hostname;
      this.port = configuration.port;
      this.username = configuration.username;
      this.password =
          configuration.password == null
              ? null
              : Arrays.copyOf(configuration.password, configuration.password.length);
    }

    /**
     * Set proxy hostname or IP address
     *
     * @param hostname proxy host
     * @return Current builder
     * @since 2.1
     */
    public Builder setHostname(String hostname) {
      this.hostname = hostname;
      return this;
    }

    /**
     * Set proxy port
     *
     * @param port proxy port
     * @return Current builder
     * @since 2.1
     */
    public Builder setPort(int port) {
      this.port = port;
      return this;
    }

    /**
     * Set proxy username (for authenticated proxies)
     *
     * @param username proxy username
     * @return Current builder
     * @since 2.1
     */
    public Builder setUsername(String username) {
      this.username = username;
      return this;
    }

    /**
     * Set proxy password (for authenticated proxies).
     *
     * <p>The {@code String} argument is converted to a {@code char[]} immediately and the reference
     * is not retained. Prefer {@link #setPassword(char[])} when the password is already available
     * as a {@code char[]} (e.g. from {@code Console.readPassword()}) to avoid creating an
     * intermediate {@code String} on the heap.
     *
     * @param password proxy password
     * @return Current builder
     * @since 2.1
     */
    public Builder setPassword(String password) {
      this.password = password == null ? null : password.toCharArray();
      return this;
    }

    /**
     * Set proxy password as a char array (for authenticated proxies).
     *
     * <p>A defensive copy of the provided array is stored. The caller may zero the original array
     * with {@code Arrays.fill(password, '\0')} immediately after this call.
     *
     * @param password proxy password as a char array
     * @return Current builder
     * @since 2.1
     */
    public Builder setPassword(char[] password) {
      this.password = password == null ? null : Arrays.copyOf(password, password.length);
      return this;
    }

    /**
     * Build an {@link HttpProxyConfiguration} instance
     *
     * @return HttpProxyConfiguration instance
     * @since 2.1
     */
    public HttpProxyConfiguration build() {
      String trimmedHostname = hostname == null ? null : hostname.trim();
      if (StringUtil.isEmpty(trimmedHostname)) {
        throw new IllegalArgumentException(
            "HttpProxyConfiguration: hostname must not be null or empty");
      }
      if (port <= 0 || port > 65535) {
        throw new IllegalArgumentException(
            "HttpProxyConfiguration: port must be in range 1–65535, got: " + port);
      }
      if (password != null && username == null) {
        throw new IllegalArgumentException(
            "HttpProxyConfiguration: a password was provided without a username");
      }
      if (username != null && password == null) {
        throw new IllegalArgumentException(
            "HttpProxyConfiguration: a username was provided without a password");
      }
      return new HttpProxyConfiguration(
          trimmedHostname,
          port,
          username,
          password == null ? null : Arrays.copyOf(password, password.length));
    }
  }
}
