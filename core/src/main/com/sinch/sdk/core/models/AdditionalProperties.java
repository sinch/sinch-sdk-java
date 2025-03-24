package com.sinch.sdk.core.models;

/**
 * Interface definition for schemas supporting additional properties
 *
 * @since 1.6
 */
public interface AdditionalProperties {

  /**
   * Return the additional property with the specified name.
   *
   * @param key the name of the property
   * @return the additional property with the specified name
   * @since 1.6
   */
  Object get(String key);

  interface Builder {

    /**
     * see getter
     *
     * @return Current builder
     * @see #get
     */
    Builder put(String key, Object value);
  }
}
