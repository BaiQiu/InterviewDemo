package com.interview.dao;

import com.interview.entity.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生成绩数据访问接口.
 *
 * @author rxliuli
 */
public interface ResultMapper {
  /**
   * 查询某个学生的成绩信息.
   *
   * @param userId 学生编号
   * @return 成绩列表
   */
  List<Result> listByUserId(@Param("userId") Long userId);

  /**
   * 添加一个学生的成绩信息.
   *
   * @param result 要添加的成绩实体
   * @return 受影响行数
   */
  int insert(Result result);
}
