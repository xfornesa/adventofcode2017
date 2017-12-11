package org.xfornesa.adventofcode;

public class Day03 {

  public int manhattanDistance(int source) {
    // build matrix
    final int[][] matrix = buildMatrix(source);
    int accessPort_x = 0;
    int accessPort_y = 0;
    int source_x = 0;
    int source_y = 0;

    // identify position for value 1 and source
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1) {
          accessPort_x = i;
          accessPort_y = j;
        }
        if (matrix[i][j] == source) {
          source_x = i;
          source_y = j;
        }
      }
    }

    // calculate distance
    return Math.abs(accessPort_x - source_x) + Math.abs(accessPort_y - source_y);
  }

  private int[][] buildMatrix(int source) {
    int dimension = 0;
    for (int i = 1; i < source / 2; i = i + 2) {
      if (i*i > source) {
        dimension = i;
        break;
      }
    }
    int[][] result = new int[dimension][dimension];

    // numConcentricSquares
    int numConcentricSquares = (int) Math.ceil((dimension) / 2.0);

    // locate center
    int current = 1;
    int center_x = (int) Math.ceil((dimension) / 2.0)-1;
    int center_y = (int) Math.ceil((dimension) / 2.0)-1;
    result[center_x][center_y] = current;


    int current_x = center_x;
    int current_y = center_y;

    int step = 0;
    for (int currentSquare = 1; currentSquare < numConcentricSquares; currentSquare++) {

      // open the new square
      for (int k = 1; k <= 1; k++) {
        current_y = current_y + 1;
        result[current_x][current_y] = ++current;
      }

      ++step;
      // move up
      for (int k = 1; k <= step; k++) {
        current_x = current_x - 1;
        result[current_x][current_y] = ++current;
      }

      ++step;
      // move left
      for (int k = 1; k <= step; k++) {
        current_y = current_y - 1;
        result[current_x][current_y] = ++current;
      }

      // move down
      for (int k = 1; k <= step; k++) {
        current_x = current_x + 1;
        result[current_x][current_y] = ++current;
      }

      // move right
      for (int k = 1; k <= step; k++) {
        current_y = current_y + 1;
        result[current_x][current_y] = ++current;
      }
    }

    return result;
  }

  public int largerValue(int source) {
    return buildMatrixTakingLarger(source);
  }

  private int buildMatrixTakingLarger(int source) {
    int dimension = 0;
    for (int i = 1; i < source / 2; i = i + 2) {
      if (i*i > source) {
        dimension = i;
        break;
      }
    }
    int[][] result = new int[dimension][dimension];

    // numConcentricSquares
    int numConcentricSquares = (int) Math.ceil((dimension) / 2.0);

    // locate center
    int center_x = (int) Math.ceil((dimension) / 2.0)-1;
    int center_y = (int) Math.ceil((dimension) / 2.0)-1;
    result[center_x][center_y] = 1;


    int current_x = center_x;
    int current_y = center_y;

    int step = 0;
    for (int currentSquare = 1; currentSquare < numConcentricSquares; currentSquare++) {
      // open the new square
      for (int k = 1; k <= 1; k++) {
        current_y = current_y + 1;
        final int sum = sumNeighbours(result, current_x, current_y);
        if (sum > source) return sum;
        result[current_x][current_y] = sum;
      }

      ++step;
      // move up
      for (int k = 1; k <= step; k++) {
        current_x = current_x - 1;
        final int sum = sumNeighbours(result, current_x, current_y);
        if (sum > source) return sum;
        result[current_x][current_y] = sum;
      }

      ++step;
      // move left
      for (int k = 1; k <= step; k++) {
        current_y = current_y - 1;
        final int sum = sumNeighbours(result, current_x, current_y);
        if (sum > source) return sum;
        result[current_x][current_y] = sum;
      }

      // move down
      for (int k = 1; k <= step; k++) {
        current_x = current_x + 1;
        final int sum = sumNeighbours(result, current_x, current_y);
        if (sum > source) return sum;
        result[current_x][current_y] = sum;
      }

      // move right
      for (int k = 1; k <= step; k++) {
        current_y = current_y + 1;
        final int sum = sumNeighbours(result, current_x, current_y);
        if (sum > source) return sum;
        result[current_x][current_y] = sum;
      }
    }

    return 0;
  }

  private int sumNeighbours(int[][] matrix, int current_x, int current_y) {
    int result = 0;
    for (int i = current_x-1; i <= current_x+1; i++) {
      for (int j = current_y-1; j <= current_y+1; j++) {
        if (i < 0 || j < 0 || i == matrix.length || j == matrix[i].length) {
          continue;
        }
        result += matrix[i][j];
      }
    }

    return result;
  }
}
