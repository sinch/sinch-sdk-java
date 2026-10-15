package com.sinch.sdk.domains.voice.models.v2.services.response.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.PaginationLinks;
import com.sinch.sdk.domains.voice.models.v2.PaginationMeta;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceShortResponse;
import java.util.List;

/** List of available voice services in the project. */
@JsonDeserialize(builder = ServicesListResponseInternalImpl.Builder.class)
public interface ServicesListResponseInternal {

  /**
   * Get services
   *
   * <p>Field is required
   *
   * @return services
   */
  List<ServiceShortResponse> getServices();

  /**
   * Get links
   *
   * <p>Field is required
   *
   * @return links
   */
  PaginationLinks getLinks();

  /**
   * Get meta
   *
   * <p>Field is required
   *
   * @return meta
   */
  PaginationMeta getMeta();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ServicesListResponseInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param services see getter
     * @return Current builder
     * @see #getServices
     */
    Builder setServices(List<ServiceShortResponse> services);

    /**
     * see getter
     *
     * @param links see getter
     * @return Current builder
     * @see #getLinks
     */
    Builder setLinks(PaginationLinks links);

    /**
     * see getter
     *
     * @param meta see getter
     * @return Current builder
     * @see #getMeta
     */
    Builder setMeta(PaginationMeta meta);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ServicesListResponseInternal build();
  }
}
