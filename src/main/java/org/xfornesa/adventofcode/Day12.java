package org.xfornesa.adventofcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day12 {

  public int connectingPeople(String input) {

    // init bus
    final Map<Integer, List<Integer>> bus = initBus(input);

    // process queue
    final Set<Integer> connectedPeople = new HashSet<>();
    final Queue<Integer> toVisit = new LinkedList<>();
    toVisit.add(0);
    while (!toVisit.isEmpty()) {
      final Integer current = toVisit.poll();
      if (!connectedPeople.contains(current)) {
        connectedPeople.add(current);
        toVisit.addAll(bus.getOrDefault(current, Collections.emptyList()));
      }
    }

    return connectedPeople.size();
  }

  public int howManyGroups(String input) {

    // init bus
    final Map<Integer, List<Integer>> bus = initBus(input);

    // process queue
    final Queue<Integer> programsToVisit = new LinkedList<>(bus.keySet());
    final Set<Set<Integer>> groups = new HashSet<>();
    while (!programsToVisit.isEmpty()) {
      final Integer currentProgram = programsToVisit.poll();

      final Set<Integer> connectedPeople = new HashSet<>();
      final Queue<Integer> toVisit = new LinkedList<>();
      toVisit.add(currentProgram);
      while (!toVisit.isEmpty()) {
        final Integer current = toVisit.poll();
        programsToVisit.remove(current);
        if (!connectedPeople.contains(current)) {
          connectedPeople.add(current);
          toVisit.addAll(bus.getOrDefault(current, Collections.emptyList()));
        }
      }
      groups.add(connectedPeople);
    }

    return groups.size();
  }


  private Map<Integer, List<Integer>> initBus(String input) {
    final Map<Integer, List<Integer>> bus = new HashMap<>();
    for(String row: input.split("\n")) {
      final String[] parts = row.split(" <-> ");
      final Integer program = Integer.valueOf(parts[0]);
      final List<Integer> connections = Stream.of(parts[1].split(","))
          .map(String::trim)
          .map(Integer::valueOf)
          .collect(Collectors.toList());
      bus.put(program, connections);
    }
    return bus;
  }
}
