package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.api.v1.adapters.VoiceService;
import com.sinch.sdk.domains.voice.api.v1.adapters.mapper.CallInformationMapper;
import com.sinch.sdk.domains.voice.api.v1.adapters.mapper.CalloutRequestCustomMapper;
import com.sinch.sdk.models.adapters.DualToneMultiFrequencyMapper;

public class VoiceBaseTest extends BaseTest {

  static {
    DualToneMultiFrequencyMapper.initMapper();
    CalloutRequestCustomMapper.initMapper();
    CallInformationMapper.initMapper();
    VoiceService.LocalLazyInit.init();
  }
}
