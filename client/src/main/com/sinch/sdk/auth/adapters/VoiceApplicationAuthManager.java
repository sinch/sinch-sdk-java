package com.sinch.sdk.auth.adapters;

// Voice and Verification are sharing same authentication mechanism
public class VoiceApplicationAuthManager extends VerificationApplicationAuthManager {

  public VoiceApplicationAuthManager(String key, String base64Secret) {
    super(key, base64Secret);
  }
}
