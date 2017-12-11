package org.xfornesa.adventofcode;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class Day11Test {
  @Test
  public void tests() throws Exception {
    final Day11 sut = new Day11();

    Assert.assertEquals(3, sut.hexGrid("ne,ne,ne"));
    Assert.assertEquals(0, sut.hexGrid("ne,ne,sw,sw"));
    Assert.assertEquals(2, sut.hexGrid("ne,ne,s,s"));
    Assert.assertEquals(3, sut.hexGrid("se,sw,se,sw,sw"));

    final InputStream resourceAsStream = this.getClass().getResourceAsStream("/input11.txt");
    String input = IOUtils.toString(resourceAsStream, "UTF-8");
    Assert.assertEquals(722, sut.hexGrid(input));
    Assert.assertEquals(1551, sut.furthest(input));

  }
}