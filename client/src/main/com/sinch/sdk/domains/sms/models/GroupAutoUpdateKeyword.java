package com.sinch.sdk.domains.sms.models;

import com.sinch.sdk.core.models.OptionalValue;

public class GroupAutoUpdateKeyword {

  private final OptionalValue<String> firstWord;
  private final OptionalValue<String> secondWord;

  /**
   * @param firstWord Opt-in keyword like "JOIN" if _auto_update.to_ is dedicated long/short number
   *     or unique brand keyword like "Sinch" if it is a shared short code.
   * @param secondWord Opt-in keyword like "JOIN" if _auto_update.to_ is shared short code.
   */
  private GroupAutoUpdateKeyword(
      OptionalValue<String> firstWord, OptionalValue<String> secondWord) {
    this.firstWord = firstWord;
    this.secondWord = secondWord;
  }

  public OptionalValue<String> getFirstWord() {
    return firstWord;
  }

  public OptionalValue<String> getSecondWord() {
    return secondWord;
  }

  @Override
  public String toString() {
    return "GroupAutoUpdateKeyword{"
        + "firstWord='"
        + firstWord
        + '\''
        + ", secondWord='"
        + secondWord
        + '\''
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    OptionalValue<String> firstWord = OptionalValue.empty();
    OptionalValue<String> secondWord = OptionalValue.empty();

    private Builder() {}

    public Builder setFirstWord(String firstWord) {
      this.firstWord = OptionalValue.of(firstWord);
      return this;
    }

    public Builder setSecondWord(String secondWord) {
      this.secondWord = OptionalValue.of(secondWord);
      return this;
    }

    public GroupAutoUpdateKeyword build() {
      return new GroupAutoUpdateKeyword(firstWord, secondWord);
    }
  }
}
