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
}
