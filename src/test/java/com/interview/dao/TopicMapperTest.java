package com.interview.dao;

import com.interview.entity.Topic;
import com.interview.util.SnowflakeIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rxliuli
 */
public class TopicMapperTest extends BaseTestNGUtil {
  @Autowired
  private TopicMapper topicMapper;

  @Test
  public void testInsert() throws Exception {
    long typeId = SnowflakeIdUtil.getId();
    Topic topic = new Topic(SnowflakeIdUtil.getId(), typeId, "问题的标题", "参考答案", null);
    int i = topicMapper.insert(topic);
    assertThat(i).isEqualTo(1);
  }

  @Test
  public void testListByRandom() throws Exception {
    List<Long> topicIdList = topicMapper.listByRandom(20);
    log(topicIdList);
    assertThat(topicIdList).hasSize(20);
  }
}