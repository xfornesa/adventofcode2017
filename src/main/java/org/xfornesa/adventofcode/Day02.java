package org.xfornesa.adventofcode;

import java.util.Arrays;

public class Day02 {

  public int checksum(String input) {
    return Arrays.stream(input.split("\n"))
        .mapToInt(this::difference)
        .sum();
  }

  private Integer difference(String row) {
    final String[] array = row.split("\t");
    Integer min = Integer.MAX_VALUE;
    Integer max = Integer.MIN_VALUE;
    for (String anArray : array) {
      final Integer current = Integer.valueOf(anArray);
      if (current < min) {
        min = current;
      }
      if (max < current) {
        max = current;
      }
    }
    return max - min;
  }

  public int sumDivisibleRows(String input) {
    return Arrays.stream(input.split("\n"))
        .mapToInt(this::divisibleValues)
        .sum();
  }

  private int divisibleValues(String row) {
    final String[] values = row.split("\t");
    for (String value : values) {
      final Integer currentValue = Integer.valueOf(value);
      for (String candidateValue : values) {
        final Integer candidate = Integer.valueOf(candidateValue);
        if (candidate % currentValue == 0 && !candidate.equals(currentValue)) {
          return candidate / currentValue;
        }
      }
    }
    return 0;
  }
}
