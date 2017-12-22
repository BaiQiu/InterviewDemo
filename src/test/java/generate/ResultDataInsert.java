package generate;

import com.github.pagehelper.PageHelper;
import com.interview.dao.ExaminationMapper;
import com.interview.dao.ResultMapper;
import com.interview.dao.UserLoginMapper;
import com.interview.entity.Examination;
import com.interview.entity.Result;
import com.interview.entity.UserLogin;
import com.interview.util.SnowflakeIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 成绩表插入数据.
 *
 * @author rxliuli
 */
public class ResultDataInsert extends BaseTestNGUtil {
  @Autowired
  private ResultMapper resultMapper;
  @Autowired
  private UserLoginMapper userLoginMapper;
  @Autowired
  private ExaminationMapper examinationMapper;

  @Test
  @Rollback(value = false)
  public void testInsert() throws Exception {
    PageHelper.startPage(2, 10);
    List<UserLogin> userLoginList = userLoginMapper.listByAll();
    int examinationNumber = 50;
    List<Examination> examinationList = examinationMapper.listByLimit(examinationNumber);
    assertThat(examinationList).hasSize(examinationNumber);
    for (int i = 0; i < 200; i++) {
      Result result = new Result(
        SnowflakeIdUtil.getId(),
        userLoginList.get(i % 10).getId(),
        examinationList.get(i % examinationNumber).getId(),
        (double) new Random(i).nextInt(100)
      );
      int num = resultMapper.insert(result);
      assertThat(num).isEqualTo(1);
    }
  }
}
