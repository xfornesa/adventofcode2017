package org.xfornesa.adventofcode;

import java.util.LinkedList;
import java.util.List;

public class Day05 {
  public int jump(String input) {
    final String[] rows = input.split("\n");
    final List<Integer> jumps = new LinkedList<>();
    for(String row: rows) {
      jumps.add(Integer.valueOf(row));
    }
    int currentIndex = 0;
    int moves = 0;
    while (currentIndex >= 0 && currentIndex < jumps.size()) {
      int jump = jumps.get(currentIndex);
      jumps.set(currentIndex, jump + 1);
      currentIndex = currentIndex + jump;
      moves++;
    }

    return moves;
  }
}
