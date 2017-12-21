package com.interview.service;

import com.interview.entity.Admin;

/**
 * 管理员业务接口.
 *
 * @author rxliuli
 */
public interface AdminService {
  /**
   * 管理员登录.
   *
   * @param admin 要进行登录的管理员
   * @return 查询到的管理员，没有查询到就为空
   */
  Admin login(Admin admin);
}
