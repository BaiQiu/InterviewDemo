package com.interview.dao;

import com.interview.entity.UserInfo;

import java.util.List;

/**
 * 学生数据访问接口
 *
 * @author Administrator
 */
public interface UserInfoMapper {
  /**
   * 查询所有学生信息.
   *
   * @return 所有学生信息列表
   */
  List<UserInfo> listByAll();
}
