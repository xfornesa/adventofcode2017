package org.xfornesa.adventofcode;

public class Day11 {
  public int hexGrid(String input) {

    int x = 0;
    int y = 0;
    int z = 0;
    for(String direction: input.split(",")) {
      switch (direction) {
        case "n":
          //x;
          y++;
          z--;
          break;
        case "s":
          //x;
          y--;
          z++;
          break;
        case "ne":
          x++;
          //y;
          z--;
          break;
        case "sw":
          x--;
          //y;
          z++;
          break;
        case "nw":
          x--;
          y++;
          //z;
          break;
        case "se":
          x++;
          y--;
          //z;
          break;
      }
    }
    return Math.max(Math.abs(x), Math.max(Math.abs(y), Math.abs(z)));
  }

  public int furthest(String input) {

    int result = 0;
    int x = 0;
    int y = 0;
    int z = 0;
    for(String direction: input.split(",")) {
      switch (direction) {
        case "n":
          //x;
          y++;
          z--;
          break;
        case "s":
          //x;
          y--;
          z++;
          break;
        case "ne":
          x++;
          //y;
          z--;
          break;
        case "sw":
          x--;
          //y;
          z++;
          break;
        case "nw":
          x--;
          y++;
          //z;
          break;
        case "se":
          x++;
          y--;
          //z;
          break;
      }
      int currentDistance = Math.max(Math.abs(x), Math.max(Math.abs(y), Math.abs(z)));
      if (currentDistance > result) {
        result = currentDistance;
      }
    }
    return result;
  }
}
