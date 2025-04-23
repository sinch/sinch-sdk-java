package com.sinch.sdk.domains.sms.models.v1.groups;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  AddKeywordImpl.JSON_PROPERTY_FIRST_WORD,
  AddKeywordImpl.JSON_PROPERTY_SECOND_WORD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AddKeywordImpl implements AddKeyword {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_FIRST_WORD = "first_word";

  private OptionalValue<String> firstWord;

  public static final String JSON_PROPERTY_SECOND_WORD = "second_word";

  private OptionalValue<String> secondWord;

  public AddKeywordImpl() {}

  protected AddKeywordImpl(OptionalValue<String> firstWord, OptionalValue<String> secondWord) {
    this.firstWord = firstWord;
    this.secondWord = secondWord;
  }

  @JsonIgnore
  public String getFirstWord() {
    return firstWord.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FIRST_WORD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> firstWord() {
    return firstWord;
  }

  @JsonIgnore
  public String getSecondWord() {
    return secondWord.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SECOND_WORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> secondWord() {
    return secondWord;
  }

  /** Return true if this addKeyword object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddKeywordImpl addKeyword = (AddKeywordImpl) o;
    return Objects.equals(this.firstWord, addKeyword.firstWord)
        && Objects.equals(this.secondWord, addKeyword.secondWord);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstWord, secondWord);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddKeywordImpl {\n");
    sb.append("    firstWord: ").append(toIndentedString(firstWord)).append("\n");
    sb.append("    secondWord: ").append(toIndentedString(secondWord)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements AddKeyword.Builder {
    OptionalValue<String> firstWord = OptionalValue.empty();
    OptionalValue<String> secondWord = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_FIRST_WORD, required = true)
    public Builder setFirstWord(String firstWord) {
      this.firstWord = OptionalValue.of(firstWord);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SECOND_WORD)
    public Builder setSecondWord(String secondWord) {
      this.secondWord = OptionalValue.of(secondWord);
      return this;
    }

    public AddKeyword build() {
      return new AddKeywordImpl(firstWord, secondWord);
    }
  }
}
