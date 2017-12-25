package com.interview.dao;

import com.interview.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Administrator
 */
public class UserInfoMapperTest extends BaseTestNGUtil {
  @Autowired
  private UserInfoMapper userInfoMapper;

  @Test
  public void testSelect() throws Exception {
    List<UserInfo> userInfoList = userInfoMapper.listByAll();
    assertThat(userInfoList)
        .isNotEmpty();

  }
}
