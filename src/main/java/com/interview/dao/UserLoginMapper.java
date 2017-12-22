package com.interview.dao;

import com.interview.entity.UserLogin;

import java.util.List;

/**
 * 用户数据访问接口.
 *
 * @author rxliuli
 */
public interface UserLoginMapper {
  /**
   * 添加一个新的用户.
   *
   * @param userLogin 新的用户实例
   * @return 受影响行数
   */
  int insert(UserLogin userLogin);

  /**
   * 查询全部用户的登录信息
   *
   * @return 全部用户的登录信息列表
   */
  List<UserLogin> listByAll();
}
