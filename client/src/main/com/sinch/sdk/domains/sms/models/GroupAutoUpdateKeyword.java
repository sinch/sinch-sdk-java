package com.sinch.sdk.domains.sms.models;

public class GroupAutoUpdateKeyword {

  private final String firstWord;
  private final String secondWord;

  /**
   * @param firstWord Opt-in keyword like "JOIN" if _auto_update.to_ is dedicated long/short number
   *     or unique brand keyword like "Sinch" if it is a shared short code.
   * @param secondWord Opt-in keyword like "JOIN" if _auto_update.to_ is shared short code.
   */
  public GroupAutoUpdateKeyword(String firstWord, String secondWord) {
    this.firstWord = firstWord;
    this.secondWord = secondWord;
  }

  public String getFirstWord() {
    return firstWord;
  }

  public String getSecondWord() {
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

    String firstWord;
    String secondWord;

    private Builder() {}

    public Builder setFirstWord(String firstWord) {
      this.firstWord = firstWord;
      return this;
    }

    public Builder setSecondWord(String secondWord) {
      this.secondWord = secondWord;
      return this;
    }

    public GroupAutoUpdateKeyword build() {
      return new GroupAutoUpdateKeyword(firstWord, secondWord);
    }
  }
}
