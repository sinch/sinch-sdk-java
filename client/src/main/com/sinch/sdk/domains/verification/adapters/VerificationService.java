package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.verification.VerificationStatusService;
import com.sinch.sdk.domains.verification.VerificationsService;
import com.sinch.sdk.domains.verification.WebHooksService;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VerificationContext;

public class VerificationService implements com.sinch.sdk.domains.verification.VerificationService {

  private final com.sinch.sdk.domains.verification.api.v1.VerificationService v1;

  private VerificationsService verifications;
  private VerificationStatusService verificationStatus;
  private WebHooksService webhooks;

  static {
    LocalLazyInit.init();
  }

  public VerificationService(
      ApplicationCredentials credentials, VerificationContext context, HttpClient httpClient) {

    this.v1 =
        new com.sinch.sdk.domains.verification.api.v1.adapters.VerificationService(
            credentials, context, httpClient);
  }

  public com.sinch.sdk.domains.verification.api.v1.VerificationService v1() {
    return this.v1;
  }

  public VerificationsService verifications() {
    if (null == this.verifications) {
      this.verifications =
          new com.sinch.sdk.domains.verification.adapters.VerificationsService(
              v1.verificationStart(), v1.verificationReport());
    }
    return this.verifications;
  }

  public VerificationStatusService verificationStatus() {
    if (null == this.verificationStatus) {
      this.verificationStatus =
          new com.sinch.sdk.domains.verification.adapters.VerificationStatusService(
              v1.verificationStatus());
    }
    return this.verificationStatus;
  }

  public WebHooksService webhooks() {
    if (null == this.webhooks) {
      this.webhooks =
          new com.sinch.sdk.domains.verification.adapters.WebHooksService(v1.webhooks());
    }
    return this.webhooks;
  }

  static final class LocalLazyInit {

    private LocalLazyInit() {
      IdentityMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LocalLazyInit.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
