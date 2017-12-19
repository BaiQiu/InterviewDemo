package com.interview.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 考试信息实体类.
 *
 * @author rxliuli
 */
public class Examination implements Serializable {

  private Long id;
  private String name;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private String topicIds;

  public Examination() {
  }

  public Examination(Long id, String name, Timestamp startTime, Timestamp endTime, String topicIds) {

    this.id = id;
    this.name = name;
    this.startTime = startTime;
    this.endTime = endTime;
    this.topicIds = topicIds;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }

  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }

  public String getTopicIds() {
    return topicIds;
  }

  public void setTopicIds(String topicIds) {
    this.topicIds = topicIds;
  }

}
