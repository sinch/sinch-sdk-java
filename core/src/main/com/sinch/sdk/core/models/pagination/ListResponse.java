package com.sinch.sdk.core.models.pagination;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Abstract class used for handling unified paginated response
 *
 * <p>Act as an iterator over pages response and pages content.
 *
 * @param <T> Page content items type
 * @since 1.0
 */
public abstract class ListResponse<T> {

  protected ListResponse() {}

  /**
   * Indicate if another page response is available
   *
   * @return Returns true if the iteration has more pages. (In other words, returns true if next()
   *     would return a page rather than throwing an exception.)
   */
  public abstract boolean hasNextPage();

  /**
   * Get next page response if available
   *
   * @return Returns the next page in the pagination/iteration. Next page response. Exception is
   *     throw in case no page available; call hasNextPage before to ensure is page is available
   * @throws NoSuchElementException if the iteration has no more pages
   */
  public abstract ListResponse<T> nextPage() throws NoSuchElementException;

  /**
   * Get the page items collection content
   *
   * @return The items related to current page content
   */
  public abstract Collection<T> getContent();

  /**
   * Get an iterator across all items available across all page responses
   *
   * <p>Underline API (HTTP request) will be called on demand when next page content will be
   * required to fulfill iterator with items for consecutive page
   *
   * @return Iterator onto items
   */
  public Iterator<T> iterator() {
    return new ItemsIterator<>(this);
  }

  /**
   * Getting a stream across all items
   *
   * <p>Underline API (HTTP request) will be called on demand when next page content will be
   * required to fulfill iterator with items for consecutive page
   *
   * @return Stream onto items
   */
  public Stream<T> stream() {
    if (!iterator().hasNext()) {
      return Stream.empty();
    }

    Iterable<T> iterable = this::iterator;
    return StreamSupport.stream(iterable.spliterator(), false);
  }

  static class ItemsIterator<T> implements Iterator<T> {

    ListResponse<T> response;
    int currentIndex = 0;
    ArrayList<T> currentList;

    public ItemsIterator(ListResponse<T> response) {
      this.response = response;
      syncIteratorWithCurrentPage();
    }

    private void syncIteratorWithCurrentPage() {
      this.currentIndex = 0;
      this.currentList = new ArrayList<>(response.getContent());
    }

    @Override
    public boolean hasNext() {
      // still items from current page to be consumed
      if (currentIndex < currentList.size()) {
        return true;
      }
      // no more page ?
      if (!response.hasNextPage()) {
        return false;
      }
      // need to require next page and check if next page is empty before being to claim "hasNext"
      // true/false
      response = response.nextPage();
      syncIteratorWithCurrentPage();
      return !this.currentList.isEmpty();
    }

    @Override
    public T next() {
      if (currentIndex >= currentList.size()) {
        response = response.nextPage();
        syncIteratorWithCurrentPage();
      }
      return currentList.get(currentIndex++);
    }
  }
}
