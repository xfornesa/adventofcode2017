package org.xfornesa.adventofcode;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class Day06Test {
  @Test
  public void tests() throws Exception {
    final Day06 sut = new Day06();
    Assert.assertEquals(5, sut.loop("0\t2\t7\t0"));


    final InputStream resourceAsStream = this.getClass().getResourceAsStream("/input06.txt");
    String input = IOUtils.toString(resourceAsStream, "UTF-8");
    Assert.assertEquals(11137, sut.loop(input));
  }
}