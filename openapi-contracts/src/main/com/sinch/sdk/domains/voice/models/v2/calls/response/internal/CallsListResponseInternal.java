package com.sinch.sdk.domains.voice.models.v2.calls.response.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.Call;
import com.sinch.sdk.domains.voice.models.v2.PaginationLinks;
import com.sinch.sdk.domains.voice.models.v2.PaginationMeta;
import java.util.List;

/** List of calls. */
@JsonDeserialize(builder = CallsListResponseInternalImpl.Builder.class)
public interface CallsListResponseInternal {

  /**
   * Array of call resources
   *
   * <p>Field is required
   *
   * @return calls
   */
  List<Call> getCalls();

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
    return new CallsListResponseInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param calls see getter
     * @return Current builder
     * @see #getCalls
     */
    Builder setCalls(List<Call> calls);

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
    CallsListResponseInternal build();
  }
}
