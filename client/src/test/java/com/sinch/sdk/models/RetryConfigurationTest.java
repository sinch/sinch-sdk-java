package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.BaseTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RetryConfigurationTest extends BaseTest {

  @Nested
  class Defaults {

    @Test
    void anUnconfiguredInstanceCarriesTheDocumentedDefaults() {
      RetryConfiguration configuration = RetryConfiguration.builder().build();

      assertEquals(RetryPolicy.DEFAULT, configuration.getRetryPolicy());
      assertEquals(3, configuration.getMaxRetryCount());
      assertEquals(4, configuration.getExponentialBackoff());
    }

    @Test
    void theDefaultConstantsAreThemselvesValid() {
      assertEquals(
          RetryConfiguration.DEFAULT_RETRY_POLICY, RetryConfiguration.DEFAULTS.getRetryPolicy());
      assertEquals(
          RetryConfiguration.DEFAULT_MAX_RETRY_COUNT,
          RetryConfiguration.DEFAULTS.getMaxRetryCount());
      assertEquals(
          RetryConfiguration.DEFAULT_EXPONENTIAL_BACKOFF,
          RetryConfiguration.DEFAULTS.getExponentialBackoff());
    }

    @Test
    void theDefaultsInstanceMatchesAnEmptyBuilder() {
      RetryConfiguration defaults = RetryConfiguration.DEFAULTS;

      assertEquals(RetryConfiguration.DEFAULT_RETRY_POLICY, defaults.getRetryPolicy());
      assertEquals(RetryConfiguration.DEFAULT_MAX_RETRY_COUNT, defaults.getMaxRetryCount());
      assertEquals(
          RetryConfiguration.DEFAULT_EXPONENTIAL_BACKOFF, defaults.getExponentialBackoff());
    }

    @Test
    void eachFieldFallsBackIndependently() {
      RetryConfiguration configuration =
          RetryConfiguration.builder().setRetryPolicy(RetryPolicy.BACKOFF).build();

      assertEquals(RetryPolicy.BACKOFF, configuration.getRetryPolicy());
      assertEquals(
          RetryConfiguration.DEFAULT_MAX_RETRY_COUNT,
          configuration.getMaxRetryCount(),
          "setting one field must not disturb the others");
    }
  }

  @Nested
  class Validation {

    @Test
    void rejectsANegativeRetryCount() {
      IllegalArgumentException exception =
          assertThrows(
              IllegalArgumentException.class,
              () -> RetryConfiguration.builder().setMaxRetryCount(-1).build());
      assertTrue(exception.getMessage().contains("maxRetryCount"));
    }

    @Test
    void acceptsAZeroRetryCountAsAWayToDisableRetries() {
      assertEquals(0, RetryConfiguration.builder().setMaxRetryCount(0).build().getMaxRetryCount());
    }

    @Test
    void rejectsABackoffFactorBelowOne() {
      // A factor under one would shrink the delay on every attempt instead of growing it
      IllegalArgumentException exception =
          assertThrows(
              IllegalArgumentException.class,
              () -> RetryConfiguration.builder().setExponentialBackoff(0).build());
      assertTrue(exception.getMessage().contains("exponentialBackoff"));
    }
  }

  @Nested
  class BuilderRoundTrip {

    @Test
    void anExistingConfigurationRebuildsIdentically() {
      RetryConfiguration source =
          RetryConfiguration.builder()
              .setRetryPolicy(RetryPolicy.RETRY_AFTER)
              .setMaxRetryCount(7)
              .setExponentialBackoff(2)
              .build();

      RetryConfiguration copy = RetryConfiguration.builder(source).build();

      assertEquals(source.getRetryPolicy(), copy.getRetryPolicy());
      assertEquals(source.getMaxRetryCount(), copy.getMaxRetryCount());
      assertEquals(source.getExponentialBackoff(), copy.getExponentialBackoff());
    }

    @Test
    void aNullSourceLeavesTheBuilderAtItsDefaults() {
      RetryConfiguration configuration = RetryConfiguration.builder(null).build();

      assertEquals(RetryPolicy.DEFAULT, configuration.getRetryPolicy());
    }
  }

  @Nested
  class OnSinchConfiguration {

    @Test
    void anUnconfiguredClientReportsNoPolicyAndFallsBackToTheDefaults() {
      Configuration configuration = Configuration.builder().build();

      assertFalse(
          configuration.getRetryConfiguration().isPresent(),
          "nothing was configured, so the getter must be empty like the other optional ones");
      assertEquals(RetryPolicy.DEFAULT, RetryConfiguration.DEFAULTS.getRetryPolicy());
    }

    @Test
    void acceptsAWholeRetryConfiguration() {
      Configuration configuration =
          Configuration.builder()
              .setRetryConfiguration(
                  RetryConfiguration.builder().setRetryPolicy(RetryPolicy.NONE).build())
              .build();

      assertEquals(RetryPolicy.NONE, configuration.getRetryConfiguration().get().getRetryPolicy());
    }

    @Test
    void acceptsTheIndividualSettingsAndCombinesThem() {
      Configuration configuration =
          Configuration.builder()
              .setRetryConfiguration(
                  RetryConfiguration.builder()
                      .setRetryPolicy(RetryPolicy.BACKOFF)
                      .setMaxRetryCount(5)
                      .setExponentialBackoff(2)
                      .build())
              .build();

      RetryConfiguration retry = configuration.getRetryConfiguration().get();
      assertEquals(RetryPolicy.BACKOFF, retry.getRetryPolicy());
      assertEquals(5, retry.getMaxRetryCount());
      assertEquals(2, retry.getExponentialBackoff());
    }

    @Test
    void survivesRebuildingTheConfiguration() {
      // SinchClient rebuilds the configuration it is given, so the policy must make the round trip
      Configuration source =
          Configuration.builder()
              .setRetryConfiguration(RetryConfiguration.builder().setMaxRetryCount(9).build())
              .build();

      Configuration rebuilt = Configuration.builder(source).build();

      assertEquals(9, rebuilt.getRetryConfiguration().get().getMaxRetryCount());
    }

    @Test
    void isReportedInToString() {
      assertTrue(Configuration.builder().build().toString().contains("retryConfiguration="));
    }
  }
}
