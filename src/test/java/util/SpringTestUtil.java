package util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * 测试 Spring 框架基本的测试
 *
 * @author rxliuli
 * @date 2017/12/6 20:17
 */
public class SpringTestUtil {
  /**
   * spring-test.xml 的 dao 层配置文件
   */
  private final String springDaoConfig = "spring/spring-dao.xml";
  /**
   * spring-test.xml 的 dao 层配置文件
   */
  private final String springServiceConfig = "spring/spring-service.xml";
  /**
   * spring-test.xml 的 dao 层配置文件
   */
  private final String springWebConfig = "spring/spring-web.xml";

  private final Logger logger = Logger.getLogger(SpringTestUtil.class);

  /**
   * 简单的测试 spring-test.xml dao 层的配置文件
   */
  @Test
  public void springDaoTest() throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext(springDaoConfig);
    logger.info(context);
  }

  /**
   * 简单的测试 spring-test.xml service 层的配置文件
   */
  @Test
  public void springServiceTest() throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext(springServiceConfig);
    logger.info(context);
  }

  /**
   * 简单的测试 spring-test.xml web 层的配置文件
   */
  @Test
  public void springWebTest() throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext(springWebConfig);
    logger.info(context);
  }

  @Test
  public void testApplicationContextTest() throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    logger.info(context);
  }
}
