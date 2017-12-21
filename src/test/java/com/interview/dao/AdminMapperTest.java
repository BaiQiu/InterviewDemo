package com.interview.dao;

import com.interview.entity.Admin;
import com.interview.util.EncryptUtil;
import com.interview.util.SnowflakeIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rxliuli
 */
public class AdminMapperTest extends BaseTestNGUtil {
  @Autowired
  private AdminMapper adminMapper;

  @Test
  public void testFindByAdmin() throws Exception {
    String adminName = "rxliuli";
    String password = EncryptUtil.sha512Hex("123456");
    Admin rxliuli = new Admin();
    rxliuli.setAdminName(adminName);
    rxliuli.setPassword(password);

    Admin admin = adminMapper.findByAdmin(rxliuli);
    assertThat(admin)
      .isNotNull()
      .extracting("adminName", "password")
      .contains(rxliuli.getAdminName(), rxliuli.getPassword());
  }

  @Test
  public void testInsert() throws Exception {
    Admin rxliuli = new Admin(
      SnowflakeIdUtil.getId(),
      "rxliuli",
      EncryptUtil.sha512Hex("123456")
    );
    int num = adminMapper.insert(rxliuli);
    assertThat(num).isEqualTo(1);
  }
}