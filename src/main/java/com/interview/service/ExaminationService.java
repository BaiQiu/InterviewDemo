package com.interview.service;

import com.interview.entity.Examination;

/**
 * 考试相关的业务接口.
 *
 * @author rxliuli
 */
public interface ExaminationService {
  /**
   * 添加一场新的考试.
   *
   * @param name      考试名字
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @param maxNumber 最大题目数量
   * @return 添加成功则返回添加的考试对象，否则返回 null
   */
  Examination addExamination(String name, String startTime, String endTime, int maxNumber);
}
