package util;

import com.interview.util.GsonUtil;
import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

/**
 * TestNG Spring 测试基类
 * 依赖：
 * Log4j 日志
 * Spring 核心容器
 * TestNG 测试框架
 * Spring Test 测试集成框架
 * 在 Spring 配置文件中必须要配置事物(因为需要自动回滚数据库)
 * Gson json 转换类库
 * GsonUtil 工具类
 * <p>
 * 继承自 Spring 中的 Spring-TestNG 整合类
 * 默认开启事务控制并且自动回滚（无论是否成功，最后都一定会进行回滚，以避免污染数据库）
 * 如果不想回滚可以使用注解 @Rollback(false) 标注类/方法，甚至标注现在的这个基类（然而并不建议这样做）
 *
 * @author rxliuli
 * @date 2017/12/7 19:39
 */
//启动 Spring 容器
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
//避免使用 ssm 时 idea 产生找不到 bean 的错误
//@SuppressWarnings("SpringJavaAutowiringInspection")
public abstract class BaseTestNGUtil extends AbstractTransactionalTestNGSpringContextTests {
  /**
   * 日志记录实例
   */
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  private final StringBuffer stringBuffer = new StringBuffer();

  /**
   * 使用 log4j 打印对象
   * 之所以要加上换行是因为日志的大量输出会掩盖真正想要看到的内容，所以上下需要各空开一行
   *
   * @param object 要进行打印的对象
   */
  public void log(Object object) {
    logger.info("\n\n结果是：\n"
        + GsonUtil.GSON_OUTPUT.toJson(object)
        + "\n"
    );
  }
}
