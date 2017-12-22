package com.interview.dao;

import com.interview.entity.Examination;
import com.interview.util.SnowflakeIdUtil;
import com.interview.util.TopicIdsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rxliuli
 */
public class ExaminationMapperTest extends BaseTestNGUtil {
  @Autowired
  private ExaminationMapper examinationMapper;
  @Autowired
  private TopicMapper topicMapper;

  @Test
  public void testInsert() throws Exception {
    //查询 20 道随机的题目
    List<Long> topicList = topicMapper.listByRandom(20);
    //创建一个考试实例
    Examination examination = new Examination(
      SnowflakeIdUtil.getId(),
      "测试考试",
      new Timestamp(new Date().getTime()),
      new Timestamp(new Date().getTime()),
      TopicIdsUtil.join(topicList)
    );
    int num = examinationMapper.insert(examination);
    assertThat(num).isEqualTo(1);
  }

  @Test
  public void testListByLimit() throws Exception {
    List<Examination> examinationList = examinationMapper.listByLimit(3);
    assertThat(examinationList)
      .hasSize(3);
  }
}