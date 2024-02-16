package com.sinch.sdk.domains.conversation.models;

import com.sinch.sdk.domains.conversation.adapters.AppBuilders;

/**
 * Each App has a retention policy that specifies how long messages, sent to or from the App, are
 * stored.
 *
 * <p>The retention policy can be changed via the API by updating the corresponding app, or via the
 * Customer Dashboard by editing the corresponding app
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/keyconcepts/#retention-policy">Retention
 *     Policy Documenation</a>
 */
public interface RetentionPolicy {

  /**
   * The retention policy type
   *
   * @return policy type value
   */
  RetentionPolicyType getRetentionType();

  /**
   * The days before a message or conversation is eligible for deletion.
   *
   * <p>The allowed values are 1,3650 and the default value is 180 days.
   *
   * @return Time GTo Live Days value
   */
  Integer getTtlDays();

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return AppBuilders.RetentionPolicyBuilder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  interface Builder {

    /**
     * see getter
     *
     * @param retentionType see getter
     * @return Current builder
     * @see RetentionPolicy#getRetentionType()
     * @since 1.0
     */
    Builder setRetentionType(RetentionPolicyType retentionType);

    /**
     * see getter
     *
     * @param ttlDays see getter
     * @return Current builder
     * @see RetentionPolicy#getTtlDays()
     * @since 1.0
     */
    Builder setTtlDays(Integer ttlDays);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    RetentionPolicy build();
  }
}
