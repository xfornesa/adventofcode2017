package org.xfornesa.adventofcode;

public class Day01 {

  public int resolve(String digits) {
    final String[] array = digits.split("");
    int result = 0;
    final int length = array.length;
    for (int i = 0; i < length; i++) {
      final String current = array[i];
      final String following = array[(i+1) % length];
      if (current.equals(following)) {
        result += Integer.valueOf(current);
      }
    }
    return result;
  }

  public int halfAround(String digits) {
    final String[] array = digits.split("");
    int result = 0;
    final int length = array.length;
    for (int i = 0; i < length; i++) {
      final String current = array[i];
      final String following = array[(i+array.length/2) % length];
      if (current.equals(following)) {
        result += Integer.valueOf(current);
      }
    }
    return result;
  }
}
