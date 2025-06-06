/*
 * Mailgun API
 *
 * OpenAPI document version: 0.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.mailgun.models.v1.templates.response;

import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.mailgun.api.v1.adapters.TemplatesServiceImpl;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Version;
import java.util.Collection;
import java.util.NoSuchElementException;

/** Auto paginated response for list of Version */
public class ListVersionsResponse extends ListResponse<Version> {

  private final Page<Object, Version, HttpRequest> page;
  private final TemplatesServiceImpl service;

  public ListVersionsResponse(
      TemplatesServiceImpl service, Page<Object, Version, HttpRequest> page) {
    this.service = service;
    this.page = page;
  }

  @Override
  public boolean hasNextPage() {
    if (null == page.getNextPageToken() || null == getContent() || getContent().isEmpty()) {
      return false;
    }
    return true;
  }

  @Override
  public ListVersionsResponse nextPage() {

    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }

    return service._getVersionsPageAsListResponse(page.getNextPageToken());
  }

  @Override
  public Collection<Version> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "ListVersionsResponse {" + "page=" + page + '}';
  }
}
