package org.xfornesa.adventofcode;

import org.junit.Assert;
import org.junit.Test;

public class Day03Test {

  @Test
  public void tests() throws Exception {
    final Day03 sut = new Day03();

    Assert.assertEquals(3, sut.manhattanDistance(12));
    Assert.assertEquals(2, sut.manhattanDistance(23));
    Assert.assertEquals(31, sut.manhattanDistance(1024));
    Assert.assertEquals(326, sut.manhattanDistance(361527));
  }
}