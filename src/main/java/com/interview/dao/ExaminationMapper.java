package com.interview.dao;

import com.interview.entity.Examination;

/**
 * 考试相关数据访问接口.
 *
 * @author rxliuli
 */
public interface ExaminationMapper {
  /**
   * 添加一场新的考试.
   *
   * @param examination 新的考试对象
   * @return 受影响行数
   */
  int insert(Examination examination);
}
