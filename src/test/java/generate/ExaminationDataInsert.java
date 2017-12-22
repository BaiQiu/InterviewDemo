package generate;

import com.interview.dao.ExaminationMapper;
import com.interview.dao.TopicMapper;
import com.interview.entity.Examination;
import com.interview.util.SnowflakeIdUtil;
import com.interview.util.TopicIdsUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 插入一些考试.
 *
 * @author rxliuli
 */
public class ExaminationDataInsert extends BaseTestNGUtil {
  @Autowired
  private ExaminationMapper examinationMapper;
  @Autowired
  private TopicMapper topicMapper;

  @Test
//  @Rollback(value = false)
  public void testInsert() throws Exception {
    for (int i = 0; i < 100; i++) {
      Timestamp startTime = new Timestamp(System.currentTimeMillis());
      Timestamp endTime = new Timestamp(DateUtils.addHours(new Date(), 1).getTime());
      String topicIds = TopicIdsUtil.join(topicMapper.listByRandom(new Random(i).nextInt(60)));
      Examination examination = new Examination(
        SnowflakeIdUtil.getId(),
        "测试考试" + i,
        startTime,
        endTime,
        topicIds
      );
      int num = examinationMapper.insert(examination);
      assertThat(num).isEqualTo(1);
    }
  }
}
