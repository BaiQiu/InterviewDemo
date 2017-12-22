package com.interview.dao;

import com.interview.entity.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
   * 根据用户编号和复数考试的 id 查询成绩.
   *
   * @param map 参数映射表
   * @return 查询到的成绩列表
   */
  List<Result> listByUserIdAndExaminations(Map<String, Object> map);

  /**
   * 添加一个学生的成绩信息.
   *
   * @param result 要添加的成绩实体
   * @return 受影响行数
   */
  int insert(Result result);
}
