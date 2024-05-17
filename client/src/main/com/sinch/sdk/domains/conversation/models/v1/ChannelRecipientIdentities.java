package com.sinch.sdk.domains.conversation.models.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ChannelRecipientIdentities extends ArrayList<ChannelRecipientIdentity>
    implements com.sinch.sdk.domains.conversation.models.v1.Recipient {

  public ChannelRecipientIdentities() {
    super();
  }

  public ChannelRecipientIdentities(Collection<ChannelRecipientIdentity> collection) {
    super(collection);
  }

  public static ChannelRecipientIdentities of(ChannelRecipientIdentity... elements) {
    return new ChannelRecipientIdentities(Arrays.asList(elements));
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    Collection<ChannelRecipientIdentity> identities;

    public Builder setRecipientIdentities(Collection<ChannelRecipientIdentity> identities) {
      this.identities = identities;
      return this;
    }

    public ChannelRecipientIdentities build() {
      return new ChannelRecipientIdentities(identities);
    }
  }
}
