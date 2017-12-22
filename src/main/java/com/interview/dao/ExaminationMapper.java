package com.interview.dao;

import com.interview.entity.Examination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

  /**
   * 查询最近的考试.
   *
   * @param examinationNumber 指定要查看的最近考试的数量
   * @return 要查看的最近考试
   */
  List<Examination> listByLimit(@Param("examinationNumber") int examinationNumber);
}
