package com.interview.service;

import com.interview.entity.Admin;
import com.interview.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rxliuli
 */
public class AdminServiceTest extends BaseTestNGUtil {
  @Autowired
  private AdminService adminService;

  @Test
  public void testLogin() throws Exception {
    //准备数据
    String adminName = "rxliuli";
    String password = EncryptUtil.sha512Hex("123456");
    Admin rxliuli = new Admin();
    rxliuli.setAdminName(adminName);
    rxliuli.setPassword(password);
    //执行登录
    Admin admin = adminService.login(rxliuli);
    //判断是否登录成功
    assertThat(admin)
      .isNotNull()
      .extracting("adminName", "password")
      .contains(rxliuli.getAdminName(), rxliuli.getPassword());
  }
}