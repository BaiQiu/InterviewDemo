package generate;

import com.interview.dao.UserLoginMapper;
import com.interview.entity.UserLogin;
import com.interview.util.EncryptUtil;
import com.interview.util.SnowflakeIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 用户登录表插入测试数据.
 *
 * @author rxliuli
 */
public class UserLoginDataInsert extends BaseTestNGUtil {
  @Autowired
  private UserLoginMapper userLoginMapper;

  @Test
  @Rollback(value = false)
  public void testInsert() throws Exception {
    for (int i = 0; i < 100; i++) {
      UserLogin userLogin = new UserLogin(
        SnowflakeIdUtil.getId(),
        "测试用户" + i,
        EncryptUtil.sha512Hex("123456"),
        "测试用户" + i + "@gmail.com"
      );
      int num = userLoginMapper.insert(userLogin);
      assertThat(num).isEqualTo(1);
    }
  }
}
