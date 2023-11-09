package com.sinch.sdk.domains.sms.models;

import java.util.Objects;
import java.util.Optional;

/**
 * Base class for Delivery Report WebHook
 *
 * @since 1.0
 */
public abstract class BaseDeliveryReport {

  private final String batchId;
  private final String clientReference;

  /**
   * @param batchId <code>Required.</code> The ID of the batch this delivery report belongs to.
   * @param clientReference The client identifier of the batch this delivery report belongs to, if
   *     set when submitting batch.
   */
  public BaseDeliveryReport(String batchId, String clientReference) {
    Objects.requireNonNull(batchId);
    this.batchId = batchId;
    this.clientReference = clientReference;
  }

  public String getBatchId() {
    return batchId;
  }

  public Optional<String> getClientReference() {
    return Optional.ofNullable(clientReference);
  }

  @Override
  public String toString() {
    return "BaseDeliveryReport{"
        + "batchId='"
        + batchId
        + '\''
        + ", clientReference='"
        + clientReference
        + '\''
        + '}';
  }

  public abstract static class Builder<B extends Builder<B>> {
    protected String batchId;
    protected String clientReference;

    public B setBatchId(String batchId) {
      this.batchId = batchId;
      return self();
    }

    public B setClientReference(String clientReference) {
      this.clientReference = clientReference;
      return self();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
