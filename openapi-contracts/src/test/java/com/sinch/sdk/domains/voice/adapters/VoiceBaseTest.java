package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.api.v1.adapters.mapper.CalloutRequestCustomMapper;
import com.sinch.sdk.models.adapters.DualToneMultiFrequencyMapper;

public class VoiceBaseTest extends BaseTest {

  static {
    // faking a service init to trigger dedicated serializers initialization
    DualToneMultiFrequencyMapper.initMapper();
    CalloutRequestCustomMapper.initMapper();
  }
}
