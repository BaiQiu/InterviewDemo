package com.interview.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 考试题目的工具类.
 * 主要用于拆分在一场考试中包含有所有考试题目编号的字符串，以及反向的操作
 *
 * @author rxliuli
 */
public final class TopicIdsUtil {
  /**
   * 分隔符
   */
  public static final char LINE = '\n';

  /**
   * 隐藏构造器.
   */
  private TopicIdsUtil() {

  }

  /**
   * 连接多个考试的编号成字符串.
   *
   * @param topicIds 多个考试编号
   * @return 连接完成的字符串
   */
  public static String join(Long... topicIds) {
    return StringUtils.join(topicIds, LINE);
  }

  /**
   * 将连接多个考试的编号成的字符串拆分成编号数组.
   *
   * @param topicIds 多个考试的编号连接成的字符串
   * @return 考试编号数组
   */
  public static Long[] splitToArray(String topicIds) {
    String[] split = StringUtils.split(topicIds, LINE);
    Long[] longs = new Long[split.length];
    for (int i = 0; i < split.length; i++) {
      longs[i] = Long.valueOf(split[i]);
    }
    return longs;
  }
}
