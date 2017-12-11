package org.xfornesa.adventofcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Day06 {

  public int loop(String input) {
    final int[] memory = Stream.of(input.split("\t"))
        .mapToInt(Integer::valueOf).toArray();
    final Set<String> occurrences = new HashSet<>();
    int result = 0;

    while (!occurrences.contains(Arrays.toString(memory))) {
      occurrences.add(Arrays.toString(memory));

      // locate max value
      int location = locateMaxValue(memory);

      // take it
      int valToSpread = memory[location];
      memory[location] = 0;

      // spread
      int spreadLocation = (location + 1) % memory.length;
      for (int i = 0; i < valToSpread; i++) {
        memory[spreadLocation]++;
        spreadLocation = (spreadLocation + 1) % memory.length;
      }

      result++;
    }

    return result;
  }

  private int locateMaxValue(int[] memory) {
    int location = 0;
    int currentValue = Integer.MIN_VALUE;
    for (int i = 0; i < memory.length; i++) {
      if (memory[i]>currentValue) {
        location = i;
        currentValue = memory[i];
      }
    }

    return location;
  }

  public int cycles(String input) {
    final int[] memory = Stream.of(input.split("\t"))
        .mapToInt(Integer::valueOf).toArray();
    final Map<String, Integer> occurrences = new HashMap<>();
    int result = 0;

    while (!occurrences.containsKey(Arrays.toString(memory))) {
      occurrences.put(Arrays.toString(memory), result);

      // locate max value
      int location = locateMaxValue(memory);

      // take it
      int valToSpread = memory[location];
      memory[location] = 0;

      // spread
      int spreadLocation = (location + 1) % memory.length;
      for (int i = 0; i < valToSpread; i++) {
        memory[spreadLocation]++;
        spreadLocation = (spreadLocation + 1) % memory.length;
      }

      result++;
    }

    return result - occurrences.get(Arrays.toString(memory));
  }
}
