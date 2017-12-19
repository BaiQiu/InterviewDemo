package com.interview.entity;

import java.io.Serializable;

/**
 * 面试题目实体类.
 *
 * @author rxliuli
 */
public class Topic implements Serializable {

  private Long id;
  private Long typeId;
  private String title;
  private String referenceAnswer;
  private java.sql.Timestamp updateTime;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getTypeId() {
    return typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getReferenceAnswer() {
    return referenceAnswer;
  }

  public void setReferenceAnswer(String referenceAnswer) {
    this.referenceAnswer = referenceAnswer;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
