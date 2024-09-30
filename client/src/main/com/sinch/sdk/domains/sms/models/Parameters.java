package com.sinch.sdk.domains.sms.models;

import com.sinch.sdk.core.utils.Pair;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Parameters extends HashMap<String, List<Parameters.Entry>> {

  private static final long serialVersionUID = 1L;

  /**
   * @throws NullPointerException – if the specified map is null
   */
  public Parameters(Collection<Parameters.Entry> list) throws NullPointerException {
    super(list.stream().collect(Collectors.groupingBy(Parameters.Entry::getKey)));
  }

  public static class Entry {
    private final String key;
    private final Pair<String, String> value;
    private final String defaultValue;

    public Entry(String key, Pair<String, String> value, String defaultValue) {
      this.key = key;
      this.value = value;
      this.defaultValue = defaultValue;
    }

    public Entry(String key, Pair<String, String> value) {
      this(key, value, null);
    }

    public String getKey() {
      return key;
    }

    public Pair<String, String> getValue() {
      return value;
    }

    public Optional<String> getDefaultValue() {
      return Optional.ofNullable(defaultValue);
    }

    @Override
    public String toString() {
      return "Entry{"
          + "key='"
          + key
          + '\''
          + ", value="
          + value
          + ", defaultValue="
          + defaultValue
          + '}';
    }
  }
}
