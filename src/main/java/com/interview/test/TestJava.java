package com.interview.test;

import com.interview.dao.TopicMapper;
import com.interview.entity.Topic;
import com.interview.util.SnowflakeIdUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rxliuli
 */
public class TestJava {
  public static void main(String[] args) throws IOException {
    //读取文件的全部内容
    String result = StringUtils.trim(readerFile("src/main/schema/interviewList.txt"));

    //根据标题进行分割
    String[] strings = result.split("\\d{1,2}\\.");

    //把数组转为 List 集合
    List<String> list = new ArrayList<>(Arrays.asList(strings));

    //删除第一个
    list.remove(0);

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml");
    TopicMapper topicMapper = context.getBean(TopicMapper.class);
    final long typeId = SnowflakeIdUtil.getId();
    list.stream()
        .forEach(string -> {
          //获取换行的位置
          int i = StringUtils.indexOf(string, "\n");
          //截取标题和内容
          String title = StringUtils.substring(string, 0, i).trim();
          String content = StringUtils.substring(string, i).trim();
          long id = SnowflakeIdUtil.getId();
          Topic topic = new Topic(id, typeId, title, content);
          int num = topicMapper.insert(topic);
          System.out.println(num + "\n");
        });

    System.out.println(list.size());

    System.out.println(SnowflakeIdUtil.getId());
  }

  /**
   * 读取文本文件内容
   *
   * @param path 文件的路径
   * @return 文件的全部内容
   */
  private static String readerFile(String path) {
    //设置编码格式
    String encoding = "UTF-8";
    //获取文件对象
    File file = new File(path);
    //读取文件的大小
    Long fileLength = file.length();
    //文件内容的字节数组
    byte[] fileContent = new byte[fileLength.intValue()];
    try {
      //文件读取流对象
      FileInputStream in = new FileInputStream(file);
      //读取文件
      in.read(fileContent);
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      return new String(fileContent, encoding);
    } catch (UnsupportedEncodingException e) {
      System.err.println("The OS does not support " + encoding);
      e.printStackTrace();
      return null;
    }
  }
}
