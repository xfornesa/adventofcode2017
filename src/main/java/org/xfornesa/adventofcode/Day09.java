package org.xfornesa.adventofcode;

public class Day09 {
  public int groupScoring(String input) {
    final String[] chars = input.split("");
    int i = 0;
    int result = 0;
    int currentLevel = 0;
    boolean garbage = false;
    while (i<chars.length) {
      final String currentChar = chars[i];
      switch (currentChar) {
        case "{":
          if (!garbage) {
            currentLevel++;
          }
          break;
        case "}":
          if (!garbage) {
            result += currentLevel;
            currentLevel--;
          }
          break;
        case "<":
          garbage = true;
          break;
        case ">":
          garbage = false;
          break;
        case "!":
          i++; // ignore following char
          break;
        default:
          // Do nothing at all
          break;
      }
      i++;
    }
    return result;
  }

  public int garbageChars(String input) {
    final String[] chars = input.split("");
    int i = 0;
    int result = 0;
    boolean garbage = false;
    while (i<chars.length) {
      final String currentChar = chars[i];
      switch (currentChar) {
        case "<":
          if (garbage) {
            result++;
          }
          garbage = true;
          break;
        case ">":
          garbage = false;
          break;
        case "!":
          i++; // ignore following char
          break;
        default:
          if (garbage) {
            result++;
          }
          // Do nothing at all
          break;
      }
      i++;
    }
    return result;
  }
}
