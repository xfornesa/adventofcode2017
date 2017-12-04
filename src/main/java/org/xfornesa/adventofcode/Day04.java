package org.xfornesa.adventofcode;

import java.util.HashSet;
import java.util.Set;

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
}
