package com.sinch.sdk.core.models.pagination;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Abstract class used for handling unified paginated response
 *
 * <p>Act as an iterator over pages response and pages content.
 *
 * @since 1.0
 */
public abstract class ListResponse<T> {

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
      return currentIndex < currentList.size() || response.hasNextPage();
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
