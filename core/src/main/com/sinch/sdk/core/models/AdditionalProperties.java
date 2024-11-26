package com.sinch.sdk.core.models;

import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequest.Builder;

/** Interface definition for schemas supporting additional properties */
public interface AdditionalProperties {

  /**
   * Return the additional property with the specified name.
   *
   * @param key the name of the property
   * @return the additional property with the specified name
   * @since __TO_BE_DEFINED__
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
