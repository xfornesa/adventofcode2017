package org.xfornesa.adventofcode;

import org.junit.Assert;
import org.junit.Test;

public class Day10Test {

  @Test
  public void tests() throws Exception {
    final Day10 sut = new Day10();

    Assert.assertEquals(12, sut.knotHash(5, "3,4,1,5"));

    Assert.assertEquals(4114, sut.knotHash(256, "165,1,255,31,87,52,24,113,0,91,148,254,158,2,73,153"));
  }
}