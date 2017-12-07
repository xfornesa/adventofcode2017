package org.xfornesa.adventofcode;


import org.apache.commons.lang3.StringUtils;

public class Day07 {

  public String circus(String input) {
    final String[] rows = input.split("\n");
    for (String row: rows) {
      final String[] parentParts = row.split(" -> ");
      final String rootPart = parentParts[0].trim();
      final String[] rootParts = rootPart.split(" ");
      final String root = rootParts[0].trim();
      final int matches = StringUtils.countMatches(input, root);
      if (matches == 1) {
        return root;
      }

    }
    return "";
  }
}
