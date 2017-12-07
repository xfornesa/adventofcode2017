package org.xfornesa.adventofcode;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class Day07Test {

  @Test
  public void tests() throws Exception {
    final Day07 sut = new Day07();

    final InputStream resourceAsStreamExample = this.getClass().getResourceAsStream("/input07-example.txt");
    String inputExample = IOUtils.toString(resourceAsStreamExample, "UTF-8");

    Assert.assertEquals("tknk", sut.circus(inputExample));


    final InputStream resourceAsStream = this.getClass().getResourceAsStream("/input07.txt");
    String input = IOUtils.toString(resourceAsStream, "UTF-8");
    Assert.assertEquals("hlhomy", sut.circus(input));
  }
}