package org.xfornesa.adventofcode;

import java.util.ArrayList;
import java.util.List;

public class Day10 {
  public int knotHash(int elementsLength, String lengths) {
    int[] elements = new int[elementsLength];
    for (int i = 0; i < elementsLength; i++) {
      elements[i] = i;
    }
    int currentIndex = 0;
    int skipSize = 0;
    for (String length : lengths.split(",")) {
      int take = Integer.valueOf(length);
      reverse(elements, currentIndex, take);

      currentIndex = (currentIndex + take + skipSize) % elements.length;
      skipSize++;
    }

    return elements[0] * elements[1];
  }

  private void reverse(int[] elements, int currentIndex, int length) {
    final List<Integer> values = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      values.add(elements[(currentIndex + i) % elements.length]);
    }
    for (int i = 0; i < length; i++) {
      int invertI = (currentIndex + length - 1 - i) % elements.length;
      elements[invertI] = values.get(i);
    }
  }
}
