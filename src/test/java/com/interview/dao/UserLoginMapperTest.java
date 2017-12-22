package com.interview.dao;

import com.github.pagehelper.PageHelper;
import com.interview.entity.UserLogin;
import com.interview.util.EncryptUtil;
import com.interview.util.SnowflakeIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rxliuli
 */
public class UserLoginMapperTest extends BaseTestNGUtil {
  @Autowired
  private UserLoginMapper userLoginMapper;

  @Test
  public void testInsert() throws Exception {
    UserLogin userLogin = new UserLogin(
      SnowflakeIdUtil.getId(),
      "测试用户",
      EncryptUtil.sha512Hex("123456"),
      "测试用户" + "@gmail.com"
    );
    int num = userLoginMapper.insert(userLogin);
    assertThat(num).isEqualTo(1);
  }

  @Test
  public void testListByAll() throws Exception {
    PageHelper.startPage(1, 10);
    List<UserLogin> userLoginList = userLoginMapper.listByAll();
    assertThat(userLoginList).hasSize(10);
  }
}