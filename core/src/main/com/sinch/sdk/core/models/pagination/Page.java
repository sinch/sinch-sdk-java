package com.sinch.sdk.core.models.pagination;

import java.util.Collection;

public class Page<P, E, T> {

  private final PageNavigator<T> nextPageNavigator;
  private final P parameters;
  private final Collection<E> entities;

  public Page(P parameters, Collection<E> entities, PageNavigator<T> nextPageNavigator) {
    this.parameters = parameters;
    this.entities = entities;
    this.nextPageNavigator = nextPageNavigator;
  }

  public T getNextPageToken() {
    return null != nextPageNavigator ? nextPageNavigator.getToken() : null;
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
        + "nextPageNavigator="
        + nextPageNavigator
        + ", parameters="
        + parameters
        + ", entities="
        + entities
        + '}';
  }
}
