package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.BaseTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TransportSettingsTest extends BaseTest {

  @Nested
  class Defaults {

    @Test
    void anUnconfiguredInstanceCarriesTheDocumentedDefaults() {
      TransportSettings settings = TransportSettings.builder().build();

      assertEquals(60, settings.getTimeoutSeconds());
      assertTrue(settings.getUseSinchAuth());
    }

    @Test
    void theDefaultConstantsAreThemselvesValid() {
      assertEquals(
          TransportSettings.DEFAULT_TIMEOUT_SECONDS,
          TransportSettings.DEFAULTS.getTimeoutSeconds());
      assertEquals(
          TransportSettings.DEFAULT_USE_SINCH_AUTH, TransportSettings.DEFAULTS.getUseSinchAuth());
    }

    @Test
    void eachFieldFallsBackIndependently() {
      TransportSettings settings = TransportSettings.builder().setUseSinchAuth(false).build();

      assertFalse(settings.getUseSinchAuth());
      assertEquals(
          TransportSettings.DEFAULT_TIMEOUT_SECONDS,
          settings.getTimeoutSeconds(),
          "setting one field must not disturb the others");
    }
  }

  @Nested
  class Validation {

    @Test
    void zeroIsAcceptedAndDisablesTheTimeout() {
      assertEquals(0, TransportSettings.builder().setTimeoutSeconds(0).build().getTimeoutSeconds());
    }

    @Test
    void aNegativeTimeoutIsRejected() {
      IllegalArgumentException exception =
          assertThrows(
              IllegalArgumentException.class,
              () -> TransportSettings.builder().setTimeoutSeconds(-1).build());
      assertTrue(exception.getMessage().contains("timeoutSeconds"));
    }
  }

  @Nested
  class BuilderRoundTrip {

    @Test
    void anExistingInstanceRebuildsIdentically() {
      TransportSettings source =
          TransportSettings.builder().setTimeoutSeconds(15).setUseSinchAuth(false).build();

      TransportSettings copy = TransportSettings.builder(source).build();

      assertEquals(source.getTimeoutSeconds(), copy.getTimeoutSeconds());
      assertEquals(source.getUseSinchAuth(), copy.getUseSinchAuth());
    }

    @Test
    void aNullSourceLeavesTheBuilderAtItsDefaults() {
      assertEquals(
          TransportSettings.DEFAULT_TIMEOUT_SECONDS,
          TransportSettings.builder(null).build().getTimeoutSeconds());
    }
  }

  @Nested
  class OnSinchConfiguration {

    @Test
    void isEmptyWhenNotConfiguredSoTheDefaultsApply() {
      assertFalse(Configuration.builder().build().getTransportSettings().isPresent());
    }

    @Test
    void isCarriedThroughTheBuilder() {
      Configuration configuration =
          Configuration.builder()
              .setTransportSettings(TransportSettings.builder().setTimeoutSeconds(30).build())
              .build();

      assertEquals(30, configuration.getTransportSettings().get().getTimeoutSeconds());
    }

    @Test
    void survivesRebuildingTheConfiguration() {
      Configuration source =
          Configuration.builder()
              .setTransportSettings(TransportSettings.builder().setTimeoutSeconds(15).build())
              .build();

      Configuration rebuilt = Configuration.builder(source).build();

      assertEquals(15, rebuilt.getTransportSettings().get().getTimeoutSeconds());
    }

    @Test
    void isReportedInToString() {
      assertTrue(Configuration.builder().build().toString().contains("transportSettings="));
    }
  }
}
