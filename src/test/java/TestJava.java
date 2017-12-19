import com.interview.dao.TopicMapper;
import com.interview.entity.Topic;
import com.interview.util.SnowflakeIdUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author rxliuli
 */
public class TestJava {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
    DataSource dataSource = (DataSource) context.getBean("dataSource");
    System.out.println("数据源: " + dataSource);
    long typeId = SnowflakeIdUtil.getId();
    Topic topic = new Topic(SnowflakeIdUtil.getId(), typeId, "问题的标题", "参考答案");
    System.out.println(context.getBean(TopicMapper.class).insert(topic));
  }
}
