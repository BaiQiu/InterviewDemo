package com.interview.dao;

import com.interview.entity.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

  /**
   * 获取某个数量的随机题目
   *
   * @param topicNumber 随机题目的数量
   * @return 指定数量的随机题目
   */
  List<Long> listByRandom(@Param("topicNumber") Integer topicNumber);

  /**
   * 修改一个面试题目
   *
   * @param topic 面试题目实体类
   * @return 受影响行数
   */
  int update(Topic topic);

  /**
   * 删除一个面试题目
   *
   * @param id 要删除题目的id
   * @return 受影响行数
   */
  int delete(Integer id);
}


