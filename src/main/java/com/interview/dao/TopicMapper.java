package com.interview.dao;

import com.interview.entity.Topic;

/**
 * 面试题目数据访问接口.
 *
 * @author rxliuli
 */
public interface TopicMapper {
  /**
   * 添加一个面试题目.
   *
   * @param topic 面试题目实体类
   * @return 受影响行数
   */
  int insert(Topic topic);
}
