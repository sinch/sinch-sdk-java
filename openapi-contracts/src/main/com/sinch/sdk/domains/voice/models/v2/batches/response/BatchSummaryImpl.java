package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  BatchSummaryImpl.JSON_PROPERTY_BATCH_ID,
  BatchSummaryImpl.JSON_PROPERTY_SESSION_COUNT,
  BatchSummaryImpl.JSON_PROPERTY_END_TIME,
  BatchSummaryImpl.JSON_PROPERTY_QUEUED,
  BatchSummaryImpl.JSON_PROPERTY_IN_PROGRESS,
  BatchSummaryImpl.JSON_PROPERTY_COMPLETED,
  BatchSummaryImpl.JSON_PROPERTY_EXPIRED,
  BatchSummaryImpl.JSON_PROPERTY_TTL_SECONDS,
  BatchSummaryImpl.JSON_PROPERTY_REQUESTED_CPS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class BatchSummaryImpl implements BatchSummary {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_BATCH_ID = "batchId";

  private OptionalValue<String> batchId;

  public static final String JSON_PROPERTY_SESSION_COUNT = "sessionCount";

  private OptionalValue<Integer> sessionCount;

  public static final String JSON_PROPERTY_END_TIME = "endTime";

  private OptionalValue<Instant> endTime;

  public static final String JSON_PROPERTY_QUEUED = "queued";

  private OptionalValue<Integer> queued;

  public static final String JSON_PROPERTY_IN_PROGRESS = "inProgress";

  private OptionalValue<Integer> inProgress;

  public static final String JSON_PROPERTY_COMPLETED = "completed";

  private OptionalValue<Integer> completed;

  public static final String JSON_PROPERTY_EXPIRED = "expired";

  private OptionalValue<Integer> expired;

  public static final String JSON_PROPERTY_TTL_SECONDS = "ttlSeconds";

  private OptionalValue<Integer> ttlSeconds;

  public static final String JSON_PROPERTY_REQUESTED_CPS = "requestedCps";

  private OptionalValue<Integer> requestedCps;

  public BatchSummaryImpl() {}

  protected BatchSummaryImpl(
      OptionalValue<String> batchId,
      OptionalValue<Integer> sessionCount,
      OptionalValue<Instant> endTime,
      OptionalValue<Integer> queued,
      OptionalValue<Integer> inProgress,
      OptionalValue<Integer> completed,
      OptionalValue<Integer> expired,
      OptionalValue<Integer> ttlSeconds,
      OptionalValue<Integer> requestedCps) {
    this.batchId = batchId;
    this.sessionCount = sessionCount;
    this.endTime = endTime;
    this.queued = queued;
    this.inProgress = inProgress;
    this.completed = completed;
    this.expired = expired;
    this.ttlSeconds = ttlSeconds;
    this.requestedCps = requestedCps;
  }

  @JsonIgnore
  public String getBatchId() {
    return batchId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BATCH_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> batchId() {
    return batchId;
  }

  @JsonIgnore
  public Integer getSessionCount() {
    return sessionCount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SESSION_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> sessionCount() {
    return sessionCount;
  }

  @JsonIgnore
  public Instant getEndTime() {
    return endTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_END_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> endTime() {
    return endTime;
  }

  @JsonIgnore
  public Integer getQueued() {
    return queued.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_QUEUED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> queued() {
    return queued;
  }

  @JsonIgnore
  public Integer getInProgress() {
    return inProgress.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IN_PROGRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> inProgress() {
    return inProgress;
  }

  @JsonIgnore
  public Integer getCompleted() {
    return completed.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMPLETED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> completed() {
    return completed;
  }

  @JsonIgnore
  public Integer getExpired() {
    return expired.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXPIRED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> expired() {
    return expired;
  }

  @JsonIgnore
  public Integer getTtlSeconds() {
    return ttlSeconds.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TTL_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> ttlSeconds() {
    return ttlSeconds;
  }

  @JsonIgnore
  public Integer getRequestedCps() {
    return requestedCps.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REQUESTED_CPS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> requestedCps() {
    return requestedCps;
  }

  /** Return true if this BatchSummary object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchSummaryImpl batchSummary = (BatchSummaryImpl) o;
    return Objects.equals(this.batchId, batchSummary.batchId)
        && Objects.equals(this.sessionCount, batchSummary.sessionCount)
        && Objects.equals(this.endTime, batchSummary.endTime)
        && Objects.equals(this.queued, batchSummary.queued)
        && Objects.equals(this.inProgress, batchSummary.inProgress)
        && Objects.equals(this.completed, batchSummary.completed)
        && Objects.equals(this.expired, batchSummary.expired)
        && Objects.equals(this.ttlSeconds, batchSummary.ttlSeconds)
        && Objects.equals(this.requestedCps, batchSummary.requestedCps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        batchId,
        sessionCount,
        endTime,
        queued,
        inProgress,
        completed,
        expired,
        ttlSeconds,
        requestedCps);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchSummaryImpl {\n");
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
    sb.append("    sessionCount: ").append(toIndentedString(sessionCount)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    queued: ").append(toIndentedString(queued)).append("\n");
    sb.append("    inProgress: ").append(toIndentedString(inProgress)).append("\n");
    sb.append("    completed: ").append(toIndentedString(completed)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
    sb.append("    ttlSeconds: ").append(toIndentedString(ttlSeconds)).append("\n");
    sb.append("    requestedCps: ").append(toIndentedString(requestedCps)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements BatchSummary.Builder {
    OptionalValue<String> batchId = OptionalValue.empty();
    OptionalValue<Integer> sessionCount = OptionalValue.empty();
    OptionalValue<Instant> endTime = OptionalValue.empty();
    OptionalValue<Integer> queued = OptionalValue.empty();
    OptionalValue<Integer> inProgress = OptionalValue.empty();
    OptionalValue<Integer> completed = OptionalValue.empty();
    OptionalValue<Integer> expired = OptionalValue.empty();
    OptionalValue<Integer> ttlSeconds = OptionalValue.empty();
    OptionalValue<Integer> requestedCps = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_BATCH_ID, required = true)
    public Builder setBatchId(String batchId) {
      this.batchId = OptionalValue.of(batchId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SESSION_COUNT, required = true)
    public Builder setSessionCount(Integer sessionCount) {
      this.sessionCount = OptionalValue.of(sessionCount);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_END_TIME)
    public Builder setEndTime(Instant endTime) {
      this.endTime = OptionalValue.of(endTime);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_QUEUED, required = true)
    public Builder setQueued(Integer queued) {
      this.queued = OptionalValue.of(queued);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_IN_PROGRESS, required = true)
    public Builder setInProgress(Integer inProgress) {
      this.inProgress = OptionalValue.of(inProgress);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_COMPLETED, required = true)
    public Builder setCompleted(Integer completed) {
      this.completed = OptionalValue.of(completed);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_EXPIRED, required = true)
    public Builder setExpired(Integer expired) {
      this.expired = OptionalValue.of(expired);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TTL_SECONDS)
    public Builder setTtlSeconds(Integer ttlSeconds) {
      this.ttlSeconds = OptionalValue.of(ttlSeconds);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_REQUESTED_CPS, required = true)
    public Builder setRequestedCps(Integer requestedCps) {
      this.requestedCps = OptionalValue.of(requestedCps);
      return this;
    }

    public BatchSummary build() {
      return new BatchSummaryImpl(
          batchId,
          sessionCount,
          endTime,
          queued,
          inProgress,
          completed,
          expired,
          ttlSeconds,
          requestedCps);
    }
  }
}
