package com.interview.service.impl;

import com.interview.dao.AdminMapper;
import com.interview.entity.Admin;
import com.interview.service.AdminService;
import com.interview.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员业务接口实现类.
 *
 * @author rxliuli
 */
@Service
public class AdminServiceImpl implements AdminService {
  /**
   * 自动注入管理员数据访问接口实例.
   */
  @Autowired
  private AdminMapper adminMapper;

  @Override
  public Admin login(Admin admin) {
    admin.setPassword(EncryptUtil.sha512Hex(admin.getPassword()));
    return adminMapper.findByAdmin(admin);
  }
}
