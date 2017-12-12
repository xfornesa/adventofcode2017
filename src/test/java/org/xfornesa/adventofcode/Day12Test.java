package org.xfornesa.adventofcode;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class Day12Test {
  @Test
  public void tests() throws Exception {
    final Day12 sut = new Day12();

    final InputStream resourceAsStreamExample = this.getClass().getResourceAsStream("/input12-example.txt");
    String inputExample = IOUtils.toString(resourceAsStreamExample, "UTF-8");

    Assert.assertEquals(6, sut.connectingPeople(inputExample));
    Assert.assertEquals(2, sut.howManyGroups(inputExample));

    final InputStream resourceAsStream = this.getClass().getResourceAsStream("/input12.txt");
    String input = IOUtils.toString(resourceAsStream, "UTF-8");
    Assert.assertEquals(378, sut.connectingPeople(input));
    Assert.assertEquals(204, sut.howManyGroups(input));
  }
}