package org.xfornesa.adventofcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day04 {

  public int isPassPhraseValid(String input) {
    int result = 0;
    for (String row: input.split("\n")) {
      final Set<String> words = new HashSet<>();
      boolean valid = true;
      for (String value: row.split(" ")) {
        valid = valid && (!words.contains(value));
        words.add(value);
      }
      if (valid) {
        result++;
      }
    }
    return result;
  }

  public int isPassPhraseValidWithoutAnagrams(String input) {
    int result = 0;
    for (String row: input.split("\n")) {
      final Set<String> words = new HashSet<>();
      boolean valid = true;
      for (String value: row.split(" ")) {
        final String valueReordered = reOrder(value);
        valid = valid && (!words.contains(valueReordered));
        words.add(valueReordered);
      }
      if (valid) {
        result++;
      }
    }
    return result;
  }

  private String reOrder(String value) {
    return Stream.of(value.split("")).sorted().collect(Collectors.joining());
  }
}
