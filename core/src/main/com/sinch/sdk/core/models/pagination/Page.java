package com.sinch.sdk.core.models.pagination;

import java.util.Collection;

public class Page<E, T> {

  private final PageNavigator<T> nextPageNavigator;

  private final Collection<E> entities;

  public Page(Collection<E> entities, PageNavigator<T> nextPageNavigator) {
    this.entities = entities;
    this.nextPageNavigator = nextPageNavigator;
  }

  public T getNextPageToken() {
    return null != nextPageNavigator ? nextPageNavigator.getToken() : null;
  }

  public Collection<E> getEntities() {
    return entities;
  }

  @Override
  public String toString() {
    return "Page{" + "nextPageNavigator=" + nextPageNavigator + ", entities=" + entities + '}';
  }
}
