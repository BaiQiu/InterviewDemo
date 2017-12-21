package com.interview.util;

import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import java.util.Arrays;

/**
 * @author rxliuli
 */
public class TopicIdsUtilTest extends BaseTestNGUtil {

  @Test
  public void testJoin() throws Exception {
    Long[] longs = new Long[10];
    Arrays.fill(longs, 0, longs.length, SnowflakeIdUtil.getId());
    System.out.println(Arrays.toString(longs));
    String join = TopicIdsUtil.join(longs);
    System.out.println(join);
    System.out.println(Arrays.toString(TopicIdsUtil.splitToArray(join)));
  }
}
