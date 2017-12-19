import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author rxliuli
 */
public class TestJava {
  public static void main(String[] args) throws SQLException {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
    DataSource dataSource = (DataSource) context.getBean("dataSource");
    System.out.println(dataSource);
  }
}
