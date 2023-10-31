package com.sinch.sdk.core.models.pagination;

import java.util.Collection;

public class Page<P, E, T> {

  private final PageToken<T> nextPageToken;
  private final P parameters;
  private final Collection<E> entities;

  public Page(P parameters, Collection<E> entities, PageToken<T> nextPageToken) {
    this.parameters = parameters;
    this.entities = entities;
    this.nextPageToken = nextPageToken;
  }

  public PageToken<T> getNextPageToken() {
    return nextPageToken;
  }

  public P getParameters() {
    return parameters;
  }

  public Collection<E> getEntities() {
    return entities;
  }

  @Override
  public String toString() {
    return "Page{"
        + "nextPageToken="
        + nextPageToken
        + ", parameters="
        + parameters
        + ", entities="
        + entities
        + '}';
  }
}
