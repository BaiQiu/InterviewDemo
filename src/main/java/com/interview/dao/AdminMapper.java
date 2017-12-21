package com.interview.dao;

import com.interview.entity.Admin;

/**
 * 管理员数据访问接口.
 *
 * @author rxliuli
 */
public interface AdminMapper {
  /**
   * 根据用户实例查询管理员（实际上就是管理员登录信息查询而已）.
   *
   * @param admin 要进行匹配的管理员
   * @return 查询到的管理员，没有查询到就为空
   */
  Admin findByAdmin(Admin admin);

  /**
   * 插入新的用户.
   *
   * @param admin 新的用户对象
   * @return 受影响行数
   */
  int insert(Admin admin);
}
