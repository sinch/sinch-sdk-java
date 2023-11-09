package com.sinch.sdk.domains.sms.models;

import java.util.Collection;

/**
 * Details related to a delivery report status
 *
 * @since 1.0
 */
public class DeliveryReportStatusDetails {

  private final Integer code;
  private final Integer count;
  private final Collection<String> recipients;
  private final DeliveryReportStatus status;

  /**
   * @param code <code>Required.</code> The detailed <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/section/Delivery-report-error-codes">status
   *     code</a>.
   * @param count <code>Required.</code> The number of messages that currently has this code
   * @param recipients <code>Required.</code> Only for full report. A list of the phone number
   *     recipients which messages has this status code
   * @param status <code>Required.</code> The simplified status as described in <em>Delivery Report
   *     Statuses</em>
   */
  public DeliveryReportStatusDetails(
      Integer code, Integer count, Collection<String> recipients, String status) {
    this.code = code;
    this.count = count;
    this.recipients = recipients;
    this.status = DeliveryReportStatus.from(status);
  }

  public Integer getCode() {
    return code;
  }

  public Integer getCount() {
    return count;
  }

  public Collection<String> getRecipients() {
    return recipients;
  }

  public DeliveryReportStatus getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "DeliveryReportStatusDetails{"
        + "code="
        + code
        + ", count="
        + count
        + ", recipients="
        + recipients
        + ", status="
        + status
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private Integer code;
    private Integer count;
    private Collection<String> recipients;
    private DeliveryReportStatus status;

    private Builder() {}

    public Builder setCode(Integer code) {
      this.code = code;
      return this;
    }

    public Builder setCount(Integer count) {
      this.count = count;
      return this;
    }

    public Builder setRecipients(Collection<String> recipients) {
      this.recipients = recipients;
      return this;
    }

    public Builder setStatus(DeliveryReportStatus status) {
      this.status = status;
      return this;
    }

    public DeliveryReportStatusDetails build() {
      return new DeliveryReportStatusDetails(code, count, recipients, status.value());
    }
  }
}
