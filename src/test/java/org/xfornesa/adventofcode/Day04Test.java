package org.xfornesa.adventofcode;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class Day04Test {

  @Test
  public void tests() throws Exception {
    final Day04 sut = new Day04();

    Assert.assertEquals(1, sut.isPassPhraseValid("aa bb cc dd ee"));
    Assert.assertEquals(0, sut.isPassPhraseValid("aa bb cc dd aa"));
    Assert.assertEquals(1, sut.isPassPhraseValid("aa bb cc dd aaa"));

    final InputStream resourceAsStream = this.getClass().getResourceAsStream("/input04.txt");
    String input04 = IOUtils.toString(resourceAsStream, "UTF-8");
    Assert.assertEquals(477, sut.isPassPhraseValid(input04));
    Assert.assertEquals(167, sut.isPassPhraseValidWithoutAnagrams(input04));
  }
}