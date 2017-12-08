package org.xfornesa.adventofcode;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class Day08Test {

  @Test
  public void tests() throws Exception {
    final Day08 sut = new Day08();

    final InputStream resourceAsStreamExample = this.getClass().getResourceAsStream("/input08-example.txt");
    String inputExample = IOUtils.toString(resourceAsStreamExample, "UTF-8");

    Assert.assertEquals(1, sut.jumpInstructions(inputExample));


    final InputStream resourceAsStream = this.getClass().getResourceAsStream("/input08.txt");
    String input = IOUtils.toString(resourceAsStream, "UTF-8");
    Assert.assertEquals(1, sut.jumpInstructions(input));
  }
}