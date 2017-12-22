package com.interview.service.impl;

import com.interview.dao.ExaminationMapper;
import com.interview.dao.TopicMapper;
import com.interview.entity.Examination;
import com.interview.service.ExaminationService;
import com.interview.util.SnowflakeIdUtil;
import com.interview.util.TopicIdsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 考试相关的业务接口实现类.
 *
 * @author rxliuli
 */
@Service
public class ExaminationServiceImpl implements ExaminationService {
  /**
   * 自动注入的考试相关的数据接口.
   */
  @Autowired
  private ExaminationMapper examinationMapper;

  /**
   * 自动注入的面试题目相关的数据表.
   */
  @Autowired
  private TopicMapper topicMapper;


  @Override
  public Examination addExamination(String name, String startTime, String endTime, int topicNumber) {
    //获取 topicNumber 数量的随机题目
    List<Long> topicIdList = topicMapper.listByRandom(topicNumber);
    //根据参数创建一个题目对象
    Examination examination = new Examination(
      SnowflakeIdUtil.getId(),
      name,
      Timestamp.valueOf(startTime),
      Timestamp.valueOf(endTime),
      TopicIdsUtil.join(topicIdList)
    );
    //执行数据库添加
    int num = examinationMapper.insert(examination);
    //判断结果返回
    return num != 1 ? null : examination;
  }
}
