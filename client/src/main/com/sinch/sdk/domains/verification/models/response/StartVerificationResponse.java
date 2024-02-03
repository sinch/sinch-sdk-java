package com.sinch.sdk.domains.verification.models.response;

import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.VerificationId;
import java.util.Collection;

/**
 * Base class to all Start verification requests
 *
 * @since 1.0
 */
public class StartVerificationResponse {

  private final VerificationId id;
  private final Collection<Link> links;

  protected StartVerificationResponse(VerificationId id, Collection<Link> links) {
    this.id = id;
    this.links = links;
  }

  /**
   * Verification identifier used to query for status.
   *
   * @return Id value
   * @since 1.0
   */
  public VerificationId getId() {
    return id;
  }

  /**
   * Available methods and actions which can be done after a successful Verification
   *
   * @return Links value
   * @since 1.0
   */
  public Collection<Link> getLinks() {
    return links;
  }

  @Override
  public String toString() {
    return "StartVerificationResponse{" + "id='" + id + '\'' + ", links=" + links + '}';
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder<?> builder() {
    return new Builder<>();
  }

  /**
   * Dedicated Builder
   *
   * @param <B> Builder
   * @since 1.0
   */
  public static class Builder<B extends Builder<B>> {

    VerificationId id;
    Collection<Link> links;

    protected Builder() {}
    ;

    /**
     * See {@link StartVerificationResponse#getId() getter}
     *
     * @param id see getter
     * @return The current builder
     * @since 1.0
     */
    public B setId(VerificationId id) {
      this.id = id;
      return self();
    }

    /**
     * See {@link StartVerificationResponse#getLinks() getter}
     *
     * @param links see getter
     * @return The current builder
     * @since 1.0
     */
    public B setLinks(Collection<Link> links) {
      this.links = links;
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public StartVerificationResponse build() {
      return new StartVerificationResponse(id, links);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
