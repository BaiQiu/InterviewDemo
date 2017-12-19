package com.interview.entity;

import java.io.Serializable;

/**
 * 面试题目类型.
 *
 * @author rxliuli
 */
public class TopicType implements Serializable {

  private Long id;
  private String title;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
