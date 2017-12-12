package org.xfornesa.adventofcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day08 {

  public int jumpInstructions(String input) {
    final Map<String, Integer> registers = new HashMap<>();
    final List<Instruction> instructions = Stream.of(input.split("\n"))
        .map(Instruction::of)
        .collect(Collectors.toList());

    final CPU cpu = new CPU(registers);
    cpu.run(instructions);

    return cpu.getRegisters().entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
        .map(Map.Entry::getValue)
        .orElse(0);
  }

  public int maxValue(String input) {
    final Map<String, Integer> registers = new HashMap<>();
    final List<Instruction> instructions = Stream.of(input.split("\n"))
        .map(Instruction::of)
        .collect(Collectors.toList());

    final CPU cpu = new CPU(registers);
    int maxValueStored = cpu.run(instructions);

    return maxValueStored;
  }

  private static class Instruction {

    private final String store;
    private final String operation;
    private final Integer value;
    private final String read;
    private final String condition;
    private final Integer conditionValue;

    private Instruction(String store, String operation, Integer value, String read, String condition, Integer conditionValue) {
      this.store = store;
      this.operation = operation;
      this.value = value;
      this.read = read;
      this.condition = condition;
      this.conditionValue = conditionValue;
    }

    public static Instruction of(String instruction) {
      // b inc 5 if a > 1
      // 0  1  2  3 4 5 6
      final String[] parts = instruction.split(" ");
      String store = parts[0];
      String operation = parts[1];
      Integer value = Integer.valueOf(parts[2]);
      String read = parts[4];
      String condition = parts[5];
      Integer conditionValue = Integer.valueOf(parts[6]);

      return new Instruction(store, operation, value, read, condition, conditionValue);
    }
  }

  private class CPU {

    private Map<String, Integer> registers;

    public CPU(Map<String, Integer> registers) {
      this.registers = registers;
    }

    public int run(List<Instruction> instructions) {
      int maxValueStored = 0;
      for (Instruction instruction : instructions) {
        if (checkCondition(instruction)) {
          final int newValue = calculateOperationValue(instruction);
          registers.put(instruction.store, newValue);
          if (newValue > maxValueStored) {
            maxValueStored = newValue;
          }
        }
      }

      return maxValueStored;
    }

    private int calculateOperationValue(Instruction instruction) {
      final Integer value = instruction.value;
      final Integer currentValue = registers.getOrDefault(instruction.store, 0);
      switch (instruction.operation) {
        case "inc":
          return currentValue + value;
        case "dec":
          return currentValue - value;
      }
      return 0;
    }

    private boolean checkCondition(Instruction instruction) {
      final Integer readValue = registers.getOrDefault(instruction.read, 0);
      final Integer conditionalValue = instruction.conditionValue;
      switch (instruction.condition) {
        case "<":
          return readValue < conditionalValue;
        case "<=":
          return readValue <= conditionalValue;
        case "==":
          return readValue.equals(conditionalValue);
        case "!=":
          return !readValue.equals(conditionalValue);
        case ">=":
          return readValue >= conditionalValue;
        case ">":
          return readValue > conditionalValue;
      }
      return false;
    }

    public Map<String, Integer> getRegisters() {
      return registers;
    }
  }
}
