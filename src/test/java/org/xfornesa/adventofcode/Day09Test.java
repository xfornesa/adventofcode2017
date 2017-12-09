package org.xfornesa.adventofcode;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class Day09Test {

  @Test
  public void tests() throws Exception {
    final Day09 sut = new Day09();

    Assert.assertEquals(1, sut.groupScoring("{}"));
    Assert.assertEquals(6, sut.groupScoring("{{{}}}"));
    Assert.assertEquals(5, sut.groupScoring("{{},{}}"));
    Assert.assertEquals(16, sut.groupScoring("{{{},{},{{}}}}"));
    Assert.assertEquals(1, sut.groupScoring("{<a>,<a>,<a>,<a>}"));
    Assert.assertEquals(9, sut.groupScoring("{{<ab>},{<ab>},{<ab>},{<ab>}}"));
    Assert.assertEquals(9, sut.groupScoring("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
    Assert.assertEquals(3, sut.groupScoring("{{<a!>},{<a!>},{<a!>},{<ab>}}"));


    final InputStream resourceAsStream = this.getClass().getResourceAsStream("/input09.txt");
    String input = IOUtils.toString(resourceAsStream, "UTF-8");
    Assert.assertEquals(11846, sut.groupScoring(input));
  }
}