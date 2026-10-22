package com.sinch.sdk.domains.voice.models.v2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class VoiceNameTest {

  @Test
  void declaresEveryVoiceOfTheSpec() {
    Assertions.assertThat(VoiceName.values()).hasSize(772);
  }

  @Test
  void constantsKeepTheWireValue() {
    Assertions.assertThat(VoiceName.valueOf(VoiceName.EMMA)).isEqualTo("Emma");
    Assertions.assertThat(VoiceName.valueOf(VoiceName.AARAV_2)).isEqualTo("Aarav_2");
    Assertions.assertThat(VoiceName.valueOf(VoiceName.BONG_JIN)).isEqualTo("BongJin");
    Assertions.assertThat(VoiceName.valueOf(VoiceName.SUN_HI_2)).isEqualTo("SunHi_2");
  }

  @Test
  void fromReturnsTheDeclaredConstant() {
    Assertions.assertThat(VoiceName.from("Emma_3")).isSameAs(VoiceName.EMMA_3);
  }

  @Test
  void fromAcceptsAVoiceOutsideTheCatalog() {
    VoiceName future = VoiceName.from("FutureVoice");

    Assertions.assertThat(VoiceName.valueOf(future)).isEqualTo("FutureVoice");
  }
}
