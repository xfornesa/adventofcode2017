package org.xfornesa.adventofcode;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class Day05Test {

  @Test
  public void tests() throws Exception {
    final Day05 sut = new Day05();

    Assert.assertEquals(5, sut.jump("0\n" +
        "3\n" +
        "0\n" +
        "1\n" +
        "-3"));
    Assert.assertEquals(10, sut.strangerJumps("0\n" +
        "3\n" +
        "0\n" +
        "1\n" +
        "-3"));

    final InputStream resourceAsStream = this.getClass().getResourceAsStream("/input05.txt");
    String input05 = IOUtils.toString(resourceAsStream, "UTF-8");
    Assert.assertEquals(355965, sut.jump(input05));
    Assert.assertEquals(26948068, sut.strangerJumps(input05));
  }
}